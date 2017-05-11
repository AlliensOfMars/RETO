/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clases;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 7fprog03
 */
public class Parte {
        
        private int idTrabajador;
        private int idVehiculo;
        private String fecha;
	private int kmInicial;
	private int kmFinal;
	private double gastoPeaje;
	private double gastoDietas;
	private double gastoCombustible;
	private double gastoVarios;
	private String incidencias;
	private String notasAdministrativas;
	private boolean estado;
        private boolean validado;
        
        //asociacion con aviso
        private Aviso aviso;
        //asosiacion con logistica
        private Logistica logistica;
        //asociacion con administracion
        // private Administracion administracion;
        //asociciacion con vehiculos
        private List<Vehiculo>vehiculo = new ArrayList<>();
        //asociacion con viajes 
        private List<Viaje>viaje=new ArrayList<>();

        public Parte() {
    }
     
        public Parte(int idTrabajador, int idVehiculo, String fecha, int kmInicial, int kmFinal, double gastoPeaje, double gastoDietas, double gastoCombustible, double gastoVarios, String incidencias, String notasAdministrativas, boolean estado, boolean validado) {
        this.idTrabajador = idTrabajador;
        this.idVehiculo = idVehiculo;
        this.fecha = fecha;
        this.kmInicial = kmInicial;
        this.kmFinal = kmFinal;
        this.gastoPeaje = gastoPeaje;
        this.gastoDietas = gastoDietas;
        this.gastoCombustible = gastoCombustible;
        this.gastoVarios = gastoVarios;
        this.incidencias = incidencias;
        this.notasAdministrativas = notasAdministrativas;
        this.estado = estado;
        this.validado = validado;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getKmInicial() {
        return kmInicial;
    }

    public void setKmInicial(int kmInicial) {
        this.kmInicial = kmInicial;
    }

    public int getKmFinal() {
        return kmFinal;
    }

    public void setKmFinal(int kmFinal) {
        this.kmFinal = kmFinal;
    }

    public double getGastoPeaje() {
        return gastoPeaje;
    }

    public void setGastoPeaje(double gastoPeaje) {
        this.gastoPeaje = gastoPeaje;
    }

    public double getGastoDietas() {
        return gastoDietas;
    }

    public void setGastoDietas(double gastoDietas) {
        this.gastoDietas = gastoDietas;
    }

    public double getGastoCombustible() {
        return gastoCombustible;
    }

    public void setGastoCombustible(double gastoCombustible) {
        this.gastoCombustible = gastoCombustible;
    }

    public double getGastoVarios() {
        return gastoVarios;
    }

    public void setGastoVarios(double gastoVarios) {
        this.gastoVarios = gastoVarios;
    }

    public String getIncidencias() {
        return incidencias;
    }

    public void setIncidencias(String incidencias) {
        this.incidencias = incidencias;
    }

    public String getNotasAdministrativas() {
        return notasAdministrativas;
    }

    public void setNotasAdministrativas(String notasAdministrativas) {
        this.notasAdministrativas = notasAdministrativas;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean isValidado() {
        return validado;
    }

    public void setValidado(boolean validado) {
        this.validado = validado;
    }

    @Override
    public String toString() {
        return "Parte{" + "idTrabajador=" + idTrabajador + 
                ", idVehiculo=" + idVehiculo + 
                ", fecha=" + fecha + 
                ", kmInicial=" + kmInicial + 
                ", kmFinal=" + kmFinal + 
                ", gastoPeaje=" + gastoPeaje + 
                ", gastoDietas=" + gastoDietas + 
                ", gastoCombustible=" + gastoCombustible + 
                ", gastoVarios=" + gastoVarios + 
                ", incidencias=" + incidencias + 
                ", notasAdministrativas=" + notasAdministrativas + 
                ", estado=" + estado + 
                ", validado=" + validado + '}';
    }
        
    
}