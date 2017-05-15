/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clases;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author 7fprog03
 */
public class Administracion extends Trabajador {

    public Administracion() {
    }

    public Administracion(String dni, String nombre, String primerApellido, String segundoApellido, String categoria, String calle, BigDecimal numero, BigDecimal piso, String mano, String ciudad, BigDecimal codigoPostal, String provincia, BigDecimal movilEmpresa, BigDecimal movilPersonal, BigDecimal salario, String fechaNacimiento, BigDecimal idCent) {
        super(dni, nombre, primerApellido, segundoApellido, categoria, calle, numero, piso, mano, ciudad, codigoPostal, provincia, movilEmpresa, movilPersonal, salario, fechaNacimiento, idCent);
    }

    public Administracion(BigDecimal id, String dni, String nombre, String primerApellido, String segundoApellido, String categoria, String calle, BigDecimal numero, BigDecimal piso, String mano, String ciudad, BigDecimal codigoPostal, String provincia, BigDecimal movilEmpresa, BigDecimal movilPersonal, BigDecimal salario, String fechaNacimiento, BigDecimal idCent) {
        super(id, dni, nombre, primerApellido, segundoApellido, categoria, calle, numero, piso, mano, ciudad, codigoPostal, provincia, movilEmpresa, movilPersonal, salario, fechaNacimiento, idCent);
    }

   public static boolean gestionarAviso( Aviso aviso){
       Conexion. conectar();
       Aviso a=aviso;
       BigDecimal id = new BigDecimal(4);
       String sql= "insert into avisos(ID, aviso, TRABAJADORES_ID, FECHA_ID) values (?,?,?,?)";
       
        try {
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
            ps.setBigDecimal(1,id);
            ps.setString (2, a.getDescripcion());
            ps.setBigDecimal(3,a.getIdT());
            ps.setString(4, a.getFecha());
            ps.executeUpdate();
            ps.close();
            
            Conexion.desconectar();
              return true;
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "Este trabajador ya ha sido notificado.");
        }
       
     return false;
   }

    public static boolean gestionParte(Parte parte) {
        Conexion.conectar();
        Parte p = parte;
        String sql = "update partes set notasAdministrativas=?, validado=? where trabajadores_id=? and fecha=? and validado='NO'";

        try {
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
            ps.setString(1, p.getNotasAdministrativas());
            ps.setString(2, "SI");
            ps.setBigDecimal(3, p.getIdTrabajador());
            ps.setString(4, p.getFecha());
            ps.executeUpdate();
            
            ps.close();
            Conexion.desconectar();
             return true;
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "No se puede efectuar la conexión, hable con el administrador del sistema" + ex.getMessage());
        }

        return false;
    }

}
