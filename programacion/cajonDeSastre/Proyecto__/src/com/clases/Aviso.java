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
public class Aviso {
    
    	private int idAviso;
	private String descripcion;
        
        //asociacion con parte
        private Parte parte;

        
        
    public Aviso() {
    }

    public Aviso(int idAviso, String descripcion) {
        this.idAviso = idAviso;
        this.descripcion = descripcion;
    }
        
	public int getIdAviso() {
		return this.idAviso;
	}

	
	public void setIdAviso(int idAviso) {
		this.idAviso = idAviso;
	}

	public String getDescripcion() {
		return this.descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

    @Override
    public String toString() {
        return "Aviso{" + "idAviso=" + idAviso + 
                ", descripcion=" + descripcion + '}';
    }
        
}
