/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.uniandes.ecos.psp11.modelo;

import java.util.ArrayList;
/**
 * Description: Clase que representa el calculador de la desviación estándar de los puntos
 * entrados
 * Number Program: 4
 * @author deividosorio
 * @version 15/02/2015
 */
public class CalculatorRelativeSize {

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------
    private ClassName _class;
    private ArrayList<ClassName> listClass;
    private double sumLN, averageLN, varianceLN, stdDeviation;
    private double rangeVS, rangeS, rangeM, rangeL, rangeVL;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------
    public CalculatorRelativeSize(ArrayList<ClassName> dataClass) {
        this.listClass = dataClass;
        this.sumLN = 0;
        this.averageLN = 0;
        this.varianceLN = 0;
        this.stdDeviation = 0;
        this.rangeVS = 0;
        this.rangeS = 0;
        this.rangeM = 0;
        this.rangeL = 0;
        this.rangeVL = 0;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------
    /**
     * Método que la sumatoria de ln de la lista de Clases
     *
     * @return Ln(xi) tipo double
     */
    public double getSumLN() {
        if (this.sumLN != 0) {
            return this.sumLN;
        }

        for (ClassName _class : this.listClass) {
            try {
                this.sumLN += _class.getLNLOCMethos();
            } catch (NumberFormatException ex) {
                return -1;
            }
        }
        return this.sumLN;
    }

    /**
     * Método que devuelve el promedio de una lista de ln de x
     *
     * @return Average tipo double
     */
    public double getAverage() {
        if (this.averageLN != 0) {
            return this.averageLN;
        }
        this.averageLN = (getSumLN() / this.listClass.size());
        return this.averageLN;
    }

    /**
     * Método que devuelve la varianza de los valores de LN
     *
     * @return Variance tipo double
     */
    public double getVariance() {
        if (this.varianceLN != 0) {
            return varianceLN;
        }

        double _sumLN = 0;
        for (ClassName _class : this.listClass) {
            try {
                _sumLN += Math.pow((_class.getLNLOCMethos() - getAverage()), 2);
            } catch (NumberFormatException ex) {
                return -1;
            }
        }

        this.varianceLN = _sumLN / (this.listClass.size() - 1);
        return this.varianceLN;
    }

    /**
     * Método que retorna la desviación estándar
     *
     * @return El desviación estándar de tipo double
     */
    public double getStdDeviation() {
        if (this.stdDeviation != 0) {
            return stdDeviation;
        }

        this.stdDeviation = Math.sqrt(getVariance());

        return this.stdDeviation;
    }

    /**
     * Método que devuelve el rango very small
     *
     * @return El valor del rango para very small tipo double
     */
    public double getRangeVS() {
        if (this.rangeVS != 0) {
            return this.rangeVS;
        }

        this.rangeVS = getAverage() - (2 * getStdDeviation());
        return this.rangeVS;
    }

    /**
     * Método que devuelve el rango small
     *
     * @return El valor del rango para small tipo double
     */
    public double getRangeS() {
        if (this.rangeS != 0) {
            return this.rangeS;
        }

        this.rangeS = (getAverage() - getStdDeviation());
        return this.rangeS;
    }

    /**
     * Método que devuelve el rango medium
     *
     * @return El valor del rango para medium tipo double
     */
    public double getRangeM() {
        if (this.rangeM != 0) {
            return this.rangeM;
        }

        this.rangeM = getAverage();
        return this.rangeM;
    }

    /**
     * Método que devuelve el rango large
     *
     * @return El valor del rango para large tipo double
     */
    public double getRangeL() {
        if (this.rangeL != 0) {
            return this.rangeL;
        }

        this.rangeL = (getAverage() + getStdDeviation());
        return this.rangeL;
    }

    /**
     * Método que devuelve el rango very large
     *
     * @return El valor del rango para very large tipo double
     */
    public double getRangeVL() {
        if (this.rangeVL != 0) {
            return this.rangeVL;
        }

        this.rangeVL = getAverage() + (2 * getStdDeviation());
        return this.rangeVL;
    }
    
    
    /**
     * Método que devuelve el anti logaritmo del valor del rango calculado 
     * para Very Small
     *
     * @return El valor del anti rango para very small tipo double
     */
    public double getRangeAntiVS() {
        return Math.pow(Math.E,getRangeVS());
    }

    /**
     * Método que devuelve el anti logaritmo del valor del rango calculado 
     * para Small
     * 
     * @return El valor del anti rango para small tipo double
     */
    public double getRangeAntiS() {
        return Math.pow(Math.E, getRangeS());
    }

    /**
     * Método que devuelve el anti logaritmo del valor del rango calculado 
     * para medium
     *
     * @return El valor del anti rango para medium tipo double
     */
    public double getRangeAntiM() {
        return Math.pow(Math.E, getRangeM());
    }

    /**
     * Método que devuelve el anti logaritmo del valor del rango calculado 
     * para large
     *
     * @return El valor del anti rango para large tipo double
     */
    public double getRangeAntiL() {
        return Math.pow(Math.E, getRangeL());
    }

    /**
     * Método que devuelve el anti logaritmo del valor del rango calculado 
     * para very large
     *
     * @return El valor del anti rango para very large tipo double
     */
    public double getRangeAntiVL() {
        return Math.pow(Math.E, getRangeVL());
    }

}
