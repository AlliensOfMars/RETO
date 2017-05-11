/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clases;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
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

    public Trabajador getTrabajador() {
        return trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }
    
    
    

    public String loguearse() {
        String cat = null;
        try {
            Conexion.conectar();
            CallableStatement cs = Conexion.getConexion().prepareCall("{call PLOGIN.VALIDACION(?,?,?)}");
            cs.setString(1, idUsuario);
            cs.setNString(2, password);
            cs.registerOutParameter(3, OracleTypes.VARCHAR);
            cs.execute();
            String categoria = cs.getString(3);

            if (categoria.equalsIgnoreCase("administracion")) {
                cat = categoria;
            }

            if (categoria.equalsIgnoreCase("logistica")) {
                cat = categoria;
            }

            Conexion.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede efectuar la conexión, hable con el administrador del sistema \n" + ex.getMessage());
        }
        return cat;
    }
    
     public static String user(String nombre, String apellido) {

        String name = nombre.replaceAll(" ", "");
        String user = String.valueOf(name).concat(".").concat(apellido);

        return user;
    }

    public static String password() {

        String caracteres = "TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke1234567890";
        StringBuilder pass = new StringBuilder();
        Random rnd = new Random();

        while (pass.length() < 8) {
            int password = (int) (rnd.nextFloat() * (float) caracteres.length());
            pass.append(caracteres.charAt(password));
        }
        String password1 = pass.toString();

        return password1;
    }
    
    public boolean altaUsuario(String dni, String user, String password){
        String ido="call idTrabajador(?,?)";
        String insert = "insert into usuarios (usuario, password, TRABAJADORES_ID) values(?,?,?)";
        
        try {
            Conexion.conectar();
            CallableStatement cs = Conexion.getConexion().prepareCall(ido);
            cs.setString(1, dni);
            cs.registerOutParameter(2, OracleTypes.INTEGER);
            cs.execute();
            
            BigDecimal idu = cs.getBigDecimal(2);
          
            cs.close();
            Conexion.desconectar();
            
            Conexion.conectar();
            PreparedStatement smt = Conexion.getConexion().prepareStatement(insert);
            smt.setString(1, user);
            smt.setString(2, password);
            smt.setBigDecimal(3, idu);
            
            smt.executeUpdate();
            smt.close();
            Conexion.desconectar();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede insertar el usuario" + ex.getMessage());
        }
        
        return false;
    }

}
