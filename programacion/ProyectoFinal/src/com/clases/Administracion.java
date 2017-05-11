/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clases;

import java.math.BigDecimal;

/**
 *
 * @author 7fprog03
 */
public class Administracion extends Trabajador  {
    //asociacion con parte para poder validarlo
    //private List<Parte>parte=new ArrayList<>();
    //asociacion con vehiculo para hacer operaciones CRUD
    // private List<Vehiculo>vehiculo = new ArrayList<>();
    
    public Administracion() {
	}
    public Administracion(String dni, String nombre, String primerApellido, String segundoApellido, String categoria, String calle, BigDecimal numero, BigDecimal piso, String mano, String ciudad, BigDecimal codigoPostal, String provincia, BigDecimal movilEmpresa, BigDecimal movilPersonal, BigDecimal salario, String fechaNacimiento, BigDecimal idCent) {
        super(dni, nombre, primerApellido, segundoApellido, categoria, calle, numero, piso, mano, ciudad, codigoPostal, provincia, movilEmpresa, movilPersonal, salario, fechaNacimiento, idCent);
    }
    
    public void enviarAviso() {
        // TODO - implement Administracion.enviarAviso
        throw new UnsupportedOperationException();
    }

	public void gestionParte() {
		// TODO - implement Administracion.gestionParte
		throw new UnsupportedOperationException();
	}

	public void gestionVehiculo() {
		// TODO - implement Administracion.gestionVehiculo
		throw new UnsupportedOperationException();
	}


        /*public void gestionCentros() {
        Conexion.conectar();
        
        try {
            Statement smt=Conexion.getConexion().prepareStatement("insert into centros (nombre,calle,numero,ciudad,codigoPostal,provincia,telefono) values (?,?,?,?,?,?,?,?)");
          
            smt. 
            
        } catch (SQLException ex) {
            Logger.getLogger(Administracion.class.getName()).log(Level.SEVERE, null, ex);
        }
  
           
	}
*/
	public void gestionarTrabajadores() {
		// TODO - implement Administracion.gestionarTrabajadores
		throw new UnsupportedOperationException();
	}
    
}
