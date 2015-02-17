/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.psp11.modelo;

/**
 * Number Program: 4
 * @author deividosorio
 * @version 15/02/2015
 * Description: Esta clase es la representación lógica una clase que tiene
 * ClassLOC, NumberMethods y el cálculo de la división entre los dos
 */

public class ClassName {
    
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    private double classLOC;
    private double numberMethods;
    
    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    public ClassName(double classLOC, int numberMethods){
        this.classLOC = classLOC;
        this.numberMethods = numberMethods;
    }
    
    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    
    /**
     * Método que retorna la cantidad de líneas de código de la clase
     * @return la cantidad de LOC de la clase de tipo double
     */
    public double getClassLOC(){
        return this.classLOC;
    }
    
    /**
     * Método que retorna la cantidad de métodos de la clase
     * @return número de métodos de la clase de tipo int
     */
    public double getNumberMethods(){
        return this.numberMethods;
    }
    
    /** 
     * Método que retorna la división entre la cantidad de LOC sobre el
     * número de métodos de la clase
     * @return División entre cantidad de LOC y número de métodos de tipo double
     */
    public double getLOCMethods(){
        return this.classLOC/this.numberMethods;
    }
    
    /**
     * Méotodo que retorna el logaritmo natural de la división entre
     * número de LOC y número de métodos de la clase
     * @return double con el logaritmo natural
     */
    public double getLNLOCMethos(){
        return Math.log(getLOCMethods());
    }
}
