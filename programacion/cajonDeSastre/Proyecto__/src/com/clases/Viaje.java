/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clases;

/**
 *
 * @author 7fprog03
 */
public class Viaje {
    
    private double horaInicio;
    private double horaFin;
    
    //asociacion con parte
    private Parte parte;

    public Viaje() {
    }

    public Viaje(double horaInicio, double horaFin) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }
    
    public double getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(double horaInicio) {
        this.horaInicio = horaInicio;
    }

    public double getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(double horaFin) {
        this.horaFin = horaFin;
    }
      
}
