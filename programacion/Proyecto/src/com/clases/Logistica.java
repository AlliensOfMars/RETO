/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clases;

import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

/**
 *
 * @author 7fprog03
 */
public class Logistica extends Trabajador {

    //asociacion con parte
    private List<Parte> parte = new ArrayList<>();

    private List<Conducen> conducen =new ArrayList<>();
    
    public Logistica() {
    }
    
    public Logistica (BigDecimal id){
        super(id);
    }

    public Logistica(String dni, String nombre, String primerApellido, String segundoApellido, String categoria, String calle, BigDecimal numero, BigDecimal piso, String mano, String ciudad, BigDecimal codigoPostal, String provincia, BigDecimal movilEmpresa, BigDecimal movilPersonal, BigDecimal salario, String fechaNacimiento, BigDecimal idCent) {
        super(dni, nombre, primerApellido, segundoApellido, categoria, calle, numero, piso, mano, ciudad, codigoPostal, provincia, movilEmpresa, movilPersonal, salario, fechaNacimiento, idCent);
    }

    public Logistica(BigDecimal id, String dni, String nombre, String primerApellido, String segundoApellido, String categoria, String calle, BigDecimal numero, BigDecimal piso, String mano, String ciudad, BigDecimal codigoPostal, String provincia, BigDecimal movilEmpresa, BigDecimal movilPersonal, BigDecimal salario, String fechaNacimiento, BigDecimal idCent) {
        super(id, dni, nombre, primerApellido, segundoApellido, categoria, calle, numero, piso, mano, ciudad, codigoPostal, provincia, movilEmpresa, movilPersonal, salario, fechaNacimiento, idCent);
    }

    public static boolean cerrarParte(Parte parte) {
        Parte p = parte;
        BigDecimal idT =p.getIdTrabajador();
        
         Conexion.conectar();
        
        BigDecimal kmi = p.getKmInicial();
        BigDecimal kmf = p.getKmFinal();
        
        String sql = "update partes set kmInicial=?, kmFinal=?, gastosPeaje=?, "
                + "gastosDietas=?, gastosCombustible=?,otrosGastos=?, incidencias=?, "
                + "estado=?"
                + "where TRABAJADORES_ID=? AND estado='ABIERTO'";
        
        try {
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
            
            ps.setBigDecimal(1, kmi);
            ps.setBigDecimal(2, kmf);
            ps.setBigDecimal(3, p.getGastoPeaje());
            ps.setBigDecimal(4, p.getGastoDietas());
            ps.setBigDecimal(5, p.getGastoCombustible());
            ps.setBigDecimal(6, p.getGastoVarios());
            ps.setString(7, p.getIncidencias());
            ps.setString(8, "CERRADO");
            ps.setBigDecimal(9, idT);
           // ps.setString(10, fecha);
            
            ps.executeUpdate();
            ps.close();
            Conexion.desconectar();
            
            return true;
        } catch (SQLException ex) {
          JOptionPane.showMessageDialog(null, "No se puede efectuar la conexión, hable con el administrador del sistema \n" + ex.getMessage());
        }
        
        return false;
    }

    public Logistica(Trabajador t) {
       
    }
    public void agregarParte(Parte p){
        parte.add(p);    
    }
    
    public void añadirVehiculo(Conducen c){
        conducen.add(c);
    }
    
    public List<Parte> getParte() {
        return parte;
    }

    public void setParte(List<Parte> parte) {
        this.parte = parte;
    }

    public List<Conducen> getConducen() {
        return conducen;
    }

    public void setConducen(List<Conducen> conducen) {
        this.conducen = conducen;
    }
    

}
