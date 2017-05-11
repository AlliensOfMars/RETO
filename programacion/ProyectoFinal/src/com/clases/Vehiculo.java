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
    
    //asociacion con parte
    private Parte parte;
    //asociacion con administracion
    //private Administracion administracion; 

    public Vehiculo() {
    }

    public Vehiculo( String matricula, String marca, String modelo) {
       
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
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
    
    
    //26/04 Miriam FUNCIONA!!!!
    
    public static List<Vehiculo> listarVehiculos(){
        List<Vehiculo>vehiculos = new ArrayList<>();
        Conexion.conectar();
        
        try{
            
        CallableStatement cs = Conexion.getConexion().prepareCall("{call listarVehiculos(?)}");
        
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
            
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede efectuar la conexión, hable con el administrador del sistema" + ex.getMessage());
        }
     return vehiculos;
    }
    
    //26/06 FILTRAR POR MATRICULA, MIRIAM
    
    public static  List<Vehiculo>filtrarvehiculo(String matricula){
        List<Vehiculo> vehiculo =new ArrayList<>();
        Conexion.conectar();
        try {
            CallableStatement cs = Conexion.getConexion().prepareCall("{call filtrarVehiculo(?,?)}");
            cs.setString(1, matricula);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            
            ResultSet rs = (ResultSet) cs.getObject(2);
           
            while(rs.next()){
                Vehiculo v = new Vehiculo();
                v.setIdVehiculo(rs.getBigDecimal("Id"));
                v.setMarca(rs.getString("marca"));
                v.setModelo(rs.getString("modelo"));
                v.setMatricula(rs.getString("matricula"));
                vehiculo.add(v);
                System.out.println(v);
            }
            rs.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede efectuar la conexión, hable con el administrador del sistema" + ex.getMessage());
        }
        return vehiculo;
    }
    
     public boolean modificarVehiculo(BigDecimal idV) {

        Conexion.conectar();

        try {
            PreparedStatement ps = Conexion.getConexion().prepareStatement("UPDATE VEHICULOS SET matricula=?,marca=?,"
                    +"modelo=? WHERE ID=?");
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
  
     public static boolean bajaVehiculo(BigDecimal idV){
     
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
}
