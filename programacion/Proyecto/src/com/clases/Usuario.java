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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import oracle.jdbc.OracleTypes;

/**
 *
 * clase para la insercion y generacion de nuevos usuarios y gestion del login.
 */
public class Usuario {

    private String idUsuario;
    private String password;
    private BigDecimal idt;

    //asosciacion con trabajador
    private Trabajador trabajador;

    public Usuario() {
    }

    public Usuario(String idUsuario, String password) {
        this.idUsuario = idUsuario;
        this.password = password;
    }

    public Usuario(String idUsuario, BigDecimal idt) {
        this.idUsuario = idUsuario;
        this.idt = idt;
    }

    /**
     *
     * Metodo que se encarga en la gestion del login a nuestra base datos, el
     * cual recibe idUsiario y password recogidos en la ventana login, estos dos
     * parametros son utilizados para recuperar la informacion del trabajador de
     * la base datos.
     */
    public static Usuario log(String idUsuario, String password) {
        Usuario usuario = new Usuario();

        Conexion.conectar();

        try {
            CallableStatement cs = Conexion.getConexion().prepareCall("{call LOGIN(?,?,?,?)}");
            cs.setString(1, idUsuario);
            cs.setString(2, password);
            cs.registerOutParameter(3, OracleTypes.VARCHAR);
            cs.registerOutParameter(4, OracleTypes.INTEGER);
            cs.execute();

            cs.getString(3);
            cs.getBigDecimal(4);

            usuario = new Usuario(cs.getString(3), cs.getBigDecimal(4));

            cs.close();
            Conexion.desconectar();
            return usuario;
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    /**
     *
     * Metodo que nos genera el nombre de usuario partiendo del nombre y
     * apellido del trabajador que estamos dando de alta y nos devuelve una
     * cadena de texto con el resultado obtenido.
     */
    public static String user(String nombre, String apellido) {

        String name = nombre.replaceAll(" ", "");
        String user = String.valueOf(name).concat(".").concat(apellido);

        return user;
    }

    /**
     * Metodo que nos genera una contraseña para el usario que estamos dando de
     * alta y nos devuelve la contraseña generada.
     */
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

    /**
     * Metodo de dada de alta de usuario en nuestra base de datos.
     */
    public boolean altaUsuario(String dni, String user, String password) {
        String ido = "call idTrabajador(?,?)";
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

    public BigDecimal getIdt() {
        return idt;
    }

    public void setIdt(BigDecimal idt) {
        this.idt = idt;
    }

}
