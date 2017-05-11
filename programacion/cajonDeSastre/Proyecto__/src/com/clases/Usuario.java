/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clases;

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
public class Usuario {
    
    private String idUsuario;
    private String password;
    

 
    //asosciacion con trabajador
    private Trabajador trabajador;

    public Usuario() {
    }

    public Usuario(String idUsuario, String password) {
        this.idUsuario = idUsuario;
        this.password = password;
    }
    
    

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String loguearse(){
          String cat=null;
        try {  
            Conexion.conectar();
            CallableStatement cs = Conexion.getConexion().prepareCall("{call PLOGIN.VALIDACION(?,?,?)}");
            cs.setString(1, idUsuario);
            cs.setNString(2, password);
            cs.registerOutParameter(3, OracleTypes.VARCHAR);
            cs.execute();
            String categoria =cs.getString(3);
           
            if(categoria.equalsIgnoreCase("administracion")){
                cat=categoria;
            }
            
            if(categoria.equalsIgnoreCase("logistica")){
                cat=categoria;
            }
            
            Conexion.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"No se puede efectuar la conexión, hable con el administrador del sistema \n"+ex.getMessage());       
        }
        return cat;
    }
    
}
