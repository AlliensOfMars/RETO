/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clases;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import oracle.jdbc.OracleTypes;


/**
 *
 * @author 7fprog03
 */
public class Aviso {
    
    	private BigDecimal idAviso;
	private String descripcion;
        private String fecha;
        //asociacion con parte
        private Parte parte;

        
        
    public Aviso() {
    }

    public Aviso(BigDecimal idAviso, String descripcion, String fecha) {
        this.idAviso = idAviso;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

  

    public BigDecimal getIdAviso() {
        return idAviso;
    }

    public void setIdAviso(BigDecimal idAviso) {
        this.idAviso = idAviso;
    }
    
	public String getDescripcion() {
		return this.descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
        
        
        
        public static Aviso aviso(BigDecimal idt){
             Aviso a = new Aviso();
            Conexion.conectar();
            
                try {
                    CallableStatement cs = Conexion.getConexion().prepareCall("{call notificacion (?,?,?,?)}");
                    
                    cs.setBigDecimal(1, idt);
                    cs.registerOutParameter(2, OracleTypes.INTEGER);
                    cs.registerOutParameter(3, OracleTypes.VARCHAR);
                    cs.registerOutParameter(4, OracleTypes.VARCHAR);
                    
                    cs.execute();
                        BigDecimal id = cs.getBigDecimal(2);
                    String descripcion = cs.getString(3);
                    String fecha = cs.getString(4);
                    a = new Aviso(id, descripcion, fecha);
                     System.out.println(a);
                  
                    
                    
                    
                   
                    cs.close();
                    Conexion.desconectar();
                    return a;
                } catch (SQLException ex) {
               // JOptionPane.showMessageDialog(null, "No se puede efectuar la conexión, hable con el administrador del sistema");
                }
            
                return null;
        }
        
        public void  confirmarAviso(BigDecimal id){
           Conexion.conectar();
           
           String sql = "update avisos set leido=? where id=?";
           
                try {
                    PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
                    
                    ps.setString(1, "SI");
                    ps.setBigDecimal(2, id);
                    ps.executeUpdate();
                    ps.close();
                    Conexion.desconectar();
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Aviso.class.getName()).log(Level.SEVERE, null, ex);
                }
           
        }

    @Override
    public String toString() {
        return "Aviso{" + "idAviso=" + idAviso + 
                ", descripcion=" + descripcion + '}';
    }
        
}
