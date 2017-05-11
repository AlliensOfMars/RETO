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
public class Logistica extends Trabajador {
    
    //asociacion con parte
    private List<Parte>parte = new ArrayList<>();

    public Logistica() {
    }

    public Logistica(int id, String dni, String nombre, String primerApellido, String segundoApellido, String categoria, String calle, int numero, int piso, String mano, String ciudad, int codigoPostal, String provincia, int movilEmpresa, int movilPersonal, double salario, String fechaNacimiento) {
        super(id, dni, nombre, primerApellido, segundoApellido, categoria, calle, numero, piso, mano, ciudad, codigoPostal, provincia, movilEmpresa, movilPersonal, salario, fechaNacimiento);
    }
    
    
    public void rellenarParteParcial() {
		// TODO - implement Logistica.rellenarParteParcial
		throw new UnsupportedOperationException();
	}

	public void cerrarParte() {
		// TODO - implement Logistica.cerrarParte
		throw new UnsupportedOperationException();
	}
    
        
}
