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
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.OracleTypes;

/**
clase creada con el fin de administrar los diferentes avisos, que son enviados por la administracion a los trabajadores
 */
public class Aviso {

    private BigDecimal idAviso;
    private String descripcion;
    private BigDecimal idT;
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

    public Aviso(String descripcion, BigDecimal idT, String fecha) {
        this.descripcion = descripcion;
        this.idT = idT;
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

    public BigDecimal getIdT() {
        return idT;
    }

    public void setIdT(BigDecimal idT) {
        this.idT = idT;
    }

    /* 
    Este metodo se utiliza en el login y nos sirve para saber si el trabajador tiene un aviso o no para asi poder 
    mostrarle la ventana que le corresponda, recibe un bigdecimal que lo genera la clase login una vez que nos logueamos
    y lo que guarda es la id del trabajador.
    */
    public static Aviso aviso(BigDecimal idt) {
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

    /*
    Con este metodo cambiamos el estado del aviso a leyido para que este una vez que se haya leyido no vuelva a salir
    */
    
    public void confirmarAviso(BigDecimal id) {
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
        return "Aviso{" + "idAviso=" + idAviso
                + ", descripcion=" + descripcion + '}';
    }

}
