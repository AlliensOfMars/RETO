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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import oracle.jdbc.OracleTypes;

/**
 *
 * @author 7fprog03
 */
public class Vehiculo {

    private BigDecimal idVehiculo;
    private String matricula;
    private String marca;
    private String modelo;

    public Vehiculo() {
    }

    public Vehiculo(BigDecimal idVehiculo, String matricula, String marca, String modelo) {

        this.idVehiculo = idVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.matricula = matricula;

    }

    public Vehiculo(String matricula, String marca, String modelo) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
    }

    /**
     * 
     * Metodo que se ocupa de la insercion de los datos en la base de datos.
     */
    public boolean gestionVehiculos() {
        Conexion.conectar();

        try {
            PreparedStatement smt = Conexion.getConexion().prepareStatement("insert into vehiculos(marca,modelo,matricula) values (?,?,?)");
            smt.setString(1, marca);
            smt.setString(2, modelo);
            smt.setString(3, matricula);

            smt.executeUpdate();

            smt.close();
            Conexion.desconectar();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Administracion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public BigDecimal getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(BigDecimal idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     *
     * Metodo que devuelve un arraylist con todos los vehiculos de nuestra base
     * de datos.
     */
    public static List<Vehiculo> listarVehiculos() {
        List<Vehiculo> vehiculos = new ArrayList<>();
        Conexion.conectar();

        try {

            CallableStatement cs = Conexion.getConexion().prepareCall("{call pvehiculos.listarVehiculos(?)}");

            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();

            ResultSet rs = (ResultSet) cs.getObject(1);

            while (rs.next()) {
                Vehiculo v = new Vehiculo();

                v.setIdVehiculo(rs.getBigDecimal("id"));
                v.setMarca(rs.getString("marca"));
                v.setModelo(rs.getString("modelo"));
                v.setMatricula(rs.getString("matricula"));
                vehiculos.add(v);
                System.out.println(v);
            }
            rs.close();
            Conexion.desconectar();

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede efectuar la conexión, hable con el administrador del sistema" + ex.getMessage());
        }
        return vehiculos;
    }

    /**
     * Metodo que nos devuelve un obejeto del tipo vehiculo, para generar dicho
     * objeto si ha pasado la variable matricula la cual recogemos de la ventana
     * seleccionarVehiculo.
     */
    public static Vehiculo filtrarVehiculo(String matricula) {
        Vehiculo v;

        Conexion.conectar();
        String sql = "call pvehiculos.filtrarVehiculo(?,?,?,?,?)";

        try {
            CallableStatement cs = Conexion.getConexion().prepareCall(sql);
            cs.setString(1, matricula);
            cs.registerOutParameter(2, OracleTypes.INTEGER);
            cs.registerOutParameter(3, OracleTypes.VARCHAR);
            cs.registerOutParameter(4, OracleTypes.VARCHAR);
            cs.registerOutParameter(5, OracleTypes.VARCHAR);
            cs.execute();
            v = new Vehiculo(cs.getBigDecimal(2), cs.getString(3), cs.getString(4), cs.getString(5));

            cs.close();
            Conexion.desconectar();
            return v;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se encuentra ningun vehiculo con esa matricula\n" + ex.getMessage());
            return null;
        }

    }

    /**
     * Metodo que recibe la id del vehiculo recogida en la ventana Vehiculos ud,
     * y nos devuelve un respuesta de verdadero o falso, este metodo se encarga
     * de dar de baja el vehiculo con la id correspondente.
     *
     */
    public static boolean bajaVehiculo(BigDecimal idV) {

        try {
            Conexion.conectar();
            PreparedStatement ps = Conexion.getConexion().prepareStatement("delete from vehiculos where ID=?");
            ps.setBigDecimal(1, idV);
            ps.execute();
            ps.close();
            Conexion.desconectar();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede efectuar la conexión, hable con el administrador del sistema \n" + ex.getMessage());
            return false;
        }

    }

    /**
     * Metodo que recibe la id del vehiculo recogida en la ventana Vehiculos ud,
     * y nos devuelve un respuesta de verdadero o falso, este metodo se encarga
     * de modificar el vehiculo con la id correspondente.
     *
     */
    public boolean modificarVehiculo(BigDecimal idV) {

        Conexion.conectar();

        try {
            PreparedStatement ps = Conexion.getConexion().prepareStatement("UPDATE VEHICULOS SET matricula=?,marca=?,"
                    + "modelo=? WHERE ID=?");
            ps.setString(1, matricula);
            ps.setString(2, marca);
            ps.setString(3, modelo);
            ps.setBigDecimal(4, idV);

            ps.executeUpdate();
            ps.close();
            Conexion.desconectar();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede efectuar la conexión, hable con el administrador del sistema \n" + ex.getMessage());
            return false;
        }

    }

}
