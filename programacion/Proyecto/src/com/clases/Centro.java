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
public class Centro {

    // private int IDCent;
    private BigDecimal IDcent;
    private String Nombre;
    private String Calle;
    private BigDecimal Numero;
    private String Ciudad;
    private BigDecimal CodigoPostal;
    private String Provincia;
    private BigDecimal Telefonos;

    //asociacion con trabajadores
    private List<Trabajador> trabajador = new ArrayList<>();

    // public static DefaultTableModel model= (DefaultTableModel) gc.getjTable1().getModel();
    public Centro() {
    }

    public Centro(String Nombre, String Calle, BigDecimal Numero, String Ciudad, BigDecimal CodigoPostal, String Provincia, BigDecimal Telefonos) {
        this.Nombre = Nombre;
        this.Calle = Calle;
        this.Numero = Numero;
        this.Ciudad = Ciudad;
        this.CodigoPostal = CodigoPostal;
        this.Provincia = Provincia;
        this.Telefonos = Telefonos;
    }

    public Centro(BigDecimal IDcent, String Nombre, String Calle, BigDecimal Numero, String Ciudad, BigDecimal CodigoPostal, String Provincia, BigDecimal Telefonos) {
        this.IDcent = IDcent;
        this.Nombre = Nombre;
        this.Calle = Calle;
        this.Numero = Numero;
        this.Ciudad = Ciudad;
        this.CodigoPostal = CodigoPostal;
        this.Provincia = Provincia;
        this.Telefonos = Telefonos;
    }
    

    public BigDecimal getIDcent() {
        return IDcent;
    }

    public void setIDcent(BigDecimal IDcent) {
        this.IDcent = IDcent;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCalle() {
        return Calle;
    }

    public void setCalle(String Calle) {
        this.Calle = Calle;
    }

    public BigDecimal getNumero() {
        return Numero;
    }

    public void setNumero(BigDecimal Numero) {
        this.Numero = Numero;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }

    public BigDecimal getCodigoPostal() {
        return CodigoPostal;
    }

    public void setCodigoPostal(BigDecimal CodigoPostal) {
        this.CodigoPostal = CodigoPostal;
    }

    public String getProvincia() {
        return Provincia;
    }

    public void setProvincia(String Provincia) {
        this.Provincia = Provincia;
    }

    public BigDecimal getTelefonos() {
        return Telefonos;
    }

    public void setTelefonos(BigDecimal Telefonos) {
        this.Telefonos = Telefonos;
    }

    //ESTO FUNCIONA 12C
    public boolean gestionCentros() {
        Conexion.conectar();

        try {
            PreparedStatement smt = Conexion.getConexion().prepareStatement("insert into centros (nombre,calle,numero,ciudad,codigoPostal,provincia,telefono) values (?,?,?,?,?,?,?)");
            smt.setString(1, Nombre);
            smt.setString(2, Calle);
            smt.setBigDecimal(3, Numero);
            smt.setString(4, Ciudad);
            smt.setBigDecimal(5, CodigoPostal);
            smt.setString(6, Provincia);
            smt.setBigDecimal(7, Telefonos);

            smt.executeUpdate();

            smt.close();
            Conexion.desconectar();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Administracion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    //alta centros para 11G
    public boolean gestionCentros1() {
        Conexion.conectar();

        try {
            PreparedStatement smt = Conexion.getConexion().prepareStatement("insert into centros (id, nombre,calle,numero,ciudad,codigoPostal,provincia,telefono) values (?,?,?,?,?,?,?,?)");

            smt.setBigDecimal(1, IDcent);
            smt.setString(2, Nombre);
            smt.setString(3, Calle);
            smt.setBigDecimal(4, Numero);
            smt.setString(5, Ciudad);
            smt.setBigDecimal(6, CodigoPostal);
            smt.setString(7, Provincia);
            smt.setBigDecimal(8, Telefonos);

            smt.executeUpdate();

            smt.close();
            Conexion.desconectar();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede efectuar la conexión, hable con el administrador del sistema" + ex.getMessage());
            return false;
        }
    }

    //auto incrementado para 11g
    public BigDecimal autoincremente() {
        BigDecimal id= new BigDecimal(0);
        try {
            Conexion.conectar();
            CallableStatement cs = Conexion.getConexion().prepareCall("{call incrementCenter(?)}");
            cs.registerOutParameter(1, OracleTypes.INTEGER);
            cs.execute();
            int idc;
            //idc = cs.getInt(1);
            id = cs.getBigDecimal(1);
            cs.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede efectuar la conexión, hable con el administrador del sistema" + ex.getMessage());
        }
        return id;
    }

    public static List<Centro> listarCentros() {
        List<Centro> centro = new ArrayList<>();
        try {
            Conexion.conectar();
            CallableStatement cs = Conexion.getConexion().prepareCall("{call complejos.CONSULTACENTROS(?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();

            ResultSet rs = (ResultSet) cs.getObject(1);

            while (rs.next()) {
                Centro c = new Centro();
                c.setIDcent(rs.getBigDecimal("ID"));
                c.setNombre(rs.getString("nombre"));
                c.setCalle(rs.getString("calle"));
                c.setNumero(rs.getBigDecimal("numero"));
                c.setCiudad(rs.getString("ciudad"));
                c.setCodigoPostal(rs.getBigDecimal("codigoPostal"));
                c.setProvincia(rs.getString("provincia"));
                c.setTelefonos(rs.getBigDecimal("telefono"));
                centro.add(c);
                System.out.println(c);
            }
             rs.close();
             cs.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede efectuar la conexión, hable con el administrador del sistema" + ex.getMessage());
        }
        return centro;
    }

    public static List<Centro> filtrarcentCentros(String name) {
        List<Centro> c = new ArrayList<>();

        Conexion.conectar();

        try {
            CallableStatement cs = Conexion.getConexion().prepareCall("{call COMPLEJOS.CONSULTACENTRO(?,?)}");
            cs.setString(1, name);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();

            ResultSet rs = (ResultSet) cs.getObject(2);

            while (rs.next()) {
                Centro d = new Centro();
                d.setIDcent(rs.getBigDecimal("ID"));
                d.setNombre(rs.getString("nombre"));
                d.setCalle(rs.getString("calle"));
                d.setNumero(rs.getBigDecimal("numero"));
                d.setCiudad(rs.getString("ciudad"));
                d.setCodigoPostal(rs.getBigDecimal("codigoPostal"));
                d.setProvincia(rs.getString("provincia"));
                d.setTelefonos(rs.getBigDecimal("telefono"));
                c.add(d);

                System.out.println(c);
            }
            rs.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede efectuar la conexión, hable con el administrador del sistema \n" + ex.getMessage());
        }

        return c;
    }
    
    public static Centro centro(BigDecimal id){
        Centro centro = new Centro();
        
        Conexion.conectar();
        
        try {
            CallableStatement cs = Conexion.getConexion().prepareCall("{call centrosFi(?,?,?,?,?,?,?,?,?)}");
            cs.setBigDecimal(1, id);
            
            cs.registerOutParameter(2, OracleTypes.INTEGER);
            cs.registerOutParameter(3, OracleTypes.VARCHAR);
            cs.registerOutParameter(4, OracleTypes.VARCHAR);
            cs.registerOutParameter(5, OracleTypes.INTEGER);
            cs.registerOutParameter(6, OracleTypes.VARCHAR);
            cs.registerOutParameter(7, OracleTypes.INTEGER);
            cs.registerOutParameter(8, OracleTypes.VARCHAR);
            cs.registerOutParameter(9, OracleTypes.INTEGER);
            cs.execute();
            
            BigDecimal idu = cs.getBigDecimal(2);
            String nombre = cs.getString(3);
            String calle = cs.getString(4);
            BigDecimal nu = cs.getBigDecimal(5);
            String pro = cs.getString(6);
            BigDecimal cd = cs.getBigDecimal(7);
            String no = cs.getString(8);
            BigDecimal tel = cs.getBigDecimal(9);
                
          centro = new Centro(idu, nombre, calle, nu, pro, cd, no, tel);
            
        } catch (SQLException ex) {
            Logger.getLogger(Centro.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return centro;
    }

    public boolean modificarCentro(BigDecimal id) {

        Conexion.conectar();

        try {
            PreparedStatement ps = Conexion.getConexion().prepareStatement("UPDATE CENTROS SET nombre=?,calle=?,"
                    + "numero=?,ciudad=?,CODIGOPOSTAL=?,provincia=?,"
                    + "telefono=? WHERE ID=?");
            ps.setString(1, Nombre);
            ps.setString(2, Calle);
            ps.setBigDecimal(3, Numero);
            ps.setString(4, Ciudad);
            ps.setBigDecimal(5, CodigoPostal);
            ps.setString(6, Provincia);
            ps.setBigDecimal(7, Telefonos);
            ps.setBigDecimal(8, id);

            ps.executeUpdate();
            ps.close();
            Conexion.desconectar();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede efectuar la conexión, hable con el administrador del sistema \n" + ex.getMessage());
            return false;
        }
    }

    public static boolean bajaCenro(BigDecimal id) {
        try {
            Conexion.conectar();
            PreparedStatement ps = Conexion.getConexion().prepareStatement("delete from centros where id=?");
            ps.setBigDecimal(1, id);
            ps.execute();
            ps.close();
            Conexion.desconectar();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede efectuar la conexión, hable con el administrador del sistema \n" + ex.getMessage());
            return false;
        }
    }

    @Override
    public String toString() {
        return "Centro{" + "IDCent=" + IDcent
                + ", Nombre=" + Nombre
                + ", Calle=" + Calle
                + ", Numero=" + Numero
                + ", Ciudad=" + Ciudad
                + ", CodigoPostal=" + CodigoPostal
                + ", Provincia=" + Provincia
                + ", Telefonos=" + Telefonos + '}';
    }
    public void agregarTrabajador (Trabajador t){
        trabajador.add(t);
        t.setCentro(this);
    }
    
}
