/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.psp11.vista;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Clase que representa la vista para el ambiente web que será visualizada en un
 * explorador
 *
 * @author deividosorio
 * @version 08/02/2015
 */
public class MainView {

    public static void showHome(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        PrintWriter pw = resp.getWriter();
        pw.write("<html>");
        pw.println("<h1>PSP11 Programa que calcula el Rangos relativos del tamaño</h1>");
        pw.println("<p>ECOS 2015 <br>Deivid Alexander Osorio Barrera</p>");
        
        pw.write("<p>Ingrese los valores LOC y Métodos de cada clase separados por una"
                + "coma (,) y cada clase separada por guion (-), cada punto debe"
                + "tener dos valore.</p> \n");
        pw.write("<p>Para el test2 ingrese los valores de Pgs y número de Chaper separados por coma"
                + "y cada Chaper separado por Guion.</p> \n");
        pw.write("<form action=\"calc\" method=\"post\"> \n"
                + "    Clases(LOC,numMetodos): <input type=\"text\" size=\"60\" name=\"puntos\"><br>\n"
                + "    <input type=\"submit\" value=\"Calcular Rangos\"> </form> ");
        pw.write("</html>");

    }

    public static void showResults(HttpServletRequest req, HttpServletResponse resp, 
            double vs, double s, double m, double l, double vl ) throws IOException {
        
        DecimalFormat formatter = new DecimalFormat("#0.0000");
        resp.getWriter().println("<br><hr>");
        resp.getWriter().println("<h2>Resultados</h2>");
        resp.getWriter().println("<b>Valor Rango VS :</b>   " + formatter.format(vs) + "<br>");
        resp.getWriter().println("<b>Valor Rango S  :</b>   " + formatter.format(s) + "<br>");
        resp.getWriter().println("<b>Valor Rango M  :</b>   " + formatter.format(m) + "<br>");
        resp.getWriter().println("<b>Valor Rango L  : </b>  " + formatter.format(l) + "<br>");
        resp.getWriter().println("<b>Valor Rango VL : </b> " + formatter.format(vl) + "<br>");
        
        resp.getWriter().println("<hr>");
        resp.getWriter().println("<h2>Test Realizados</h2>");
        resp.getWriter().println("<b>Lista test1: <br></b>18,3-18,3-25,3-31,3-"
                + "37,3-82,5-82,4-87,4-89,4-230,10-85,3-87,3-558,10<br>");
        resp.getWriter().println("<b>Lista test2: <br></b>7,1-12,1-10,1-12,1-10,1-"
                + "12,1-12,1-12,1-12,1-8,1-8,1-8,1-20,1-14,1-18,1-12,1<br>");
        
    }    
}
