/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.psp11.vista;

import edu.uniandes.ecos.psp11.modelo.CalculatorRelativeSize;
import edu.uniandes.ecos.psp11.modelo.ClassName;
import java.util.ArrayList;

/**
 *
 * @author deividosorio
 */
public class MainConsole {
    
    public static void main(String[] args) {
        String data = "18,3-18,3-25,3-31,3-37,3-82,5-82,4-87,4-89,4-230,10-85,3"
                + "-87,3-558,10";
        
        String[] arrStrPuntos = data.split("-");
        String[] arrStrPunto;
        ClassName newPunto;
        ArrayList<ClassName> puntosList = new ArrayList<ClassName>();

        for (String _strPunto : arrStrPuntos) {
            try {
                arrStrPunto = _strPunto.split(",");
                newPunto = new ClassName(Double.parseDouble(arrStrPunto[0]),
                        Integer.parseInt(arrStrPunto[1]));
                puntosList.add(newPunto);
                
            }catch(NumberFormatException ex){
                System.out.println(ex.getMessage());
            }
        }
         CalculatorRelativeSize datosPuntos = new CalculatorRelativeSize(puntosList);
         System.out.println(datosPuntos.getRangeAntiVS()+ "\n");
         System.out.println(datosPuntos.getRangeAntiS()+ "\n");
         System.out.println(datosPuntos.getRangeAntiM()+ "\n");
         System.out.println(datosPuntos.getRangeAntiL()+ "\n");
         System.out.println(datosPuntos.getRangeAntiVL()+ "\n");
    }
}