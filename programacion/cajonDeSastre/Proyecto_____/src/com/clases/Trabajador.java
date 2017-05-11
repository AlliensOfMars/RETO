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
public class Trabajador {
    
    private int id;
	private String dni;
	String nombre;
	private String primerApellido;
	private String segundoApellido;
	private String categoria;
	private String calle;
	private int numero;
	private int piso;
	private String mano;
	private String ciudad;
	private int codigoPostal;
	private String provincia;
	private int movilEmpresa;
	private int movilPersonal;
	private double salario;
	private String fechaNacimiento;
        
        //asociacion con centros 
        private Centro centro;
        //asociacion con usuarios
        private List<Usuario>usuario=new ArrayList<>();
        

    public Trabajador() {
    }

    public Trabajador(int id, String dni, String nombre, String primerApellido, String segundoApellido, String categoria, String calle, int numero, int piso, String mano, String ciudad, int codigoPostal, String provincia, int movilEmpresa, int movilPersonal, double salario, String fechaNacimiento) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.categoria = categoria;
        this.calle = calle;
        this.numero = numero;
        this.piso = piso;
        this.mano = mano;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.provincia = provincia;
        this.movilEmpresa = movilEmpresa;
        this.movilPersonal = movilPersonal;
        this.salario = salario;
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getId() {
        return id;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getCalle() {
        return calle;
    }

    public int getNumero() {
        return numero;
    }

    public int getPiso() {
        return piso;
    }

    public String getMano() {
        return mano;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getCodigoPostal() {
        return codigoPostal;
    }

    public String getProvincia() {
        return provincia;
    }

    public int getMovilEmpresa() {
        return movilEmpresa;
    }

    public int getMovilPersonal() {
        return movilPersonal;
    }

    public double getSalario() {
        return salario;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    
}
