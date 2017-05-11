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
import oracle.jdbc.OracleTypes;
import oracle.jdbc.oracore.OracleType;

/**
 *
 * @author 7fprog03
 */
public class Viaje {

    private String horaInicio;
    private String horaFin;
    private BigDecimal idt;
    private String fecha;
    private int albaran;

    //asociacion con parte
    private Parte parte;

    public Viaje() {
    }

    public Viaje(BigDecimal idt, String fecha, int albaran, String horaInicio, String horaFin) {
        this.idt = idt;
        this.fecha = fecha;
        this.albaran = albaran;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public Viaje(String horaInicio, String horaFin,int albaran) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.albaran = albaran;
    }

    public BigDecimal getIdt() {
        return idt;
    }

    public void setIdt(BigDecimal idt) {
        this.idt = idt;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getAlabaran() {
        return albaran;
    }

    public void setAlabaran(int alabaran) {
        this.albaran = alabaran;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public Parte getParte() {
        return parte;
    }

    public void setParte(Parte parte) {
        this.parte = parte;
    }

    public boolean insertarViaje(BigDecimal idt, String fecha) {
        Conexion.conectar();
        String sql = "insert into viajes (horaInicial, horaFinal, TRABAJADORES_ID, FECHA_ID, albaran) values(?,?,?,?,?)";

        try {
            PreparedStatement smt = Conexion.getConexion().prepareStatement(sql);
            smt.setString(1, horaInicio);
            smt.setString(2, horaFin);
            smt.setBigDecimal(3, idt);
            smt.setString(4, fecha);
            smt.setInt(5, albaran);

            smt.executeUpdate();
            smt.close();
            Conexion.desconectar();

            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Viaje.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean modificarviaje(BigDecimal idt, String fecha){
        Conexion.conectar();
        String sql ="update viajes set horaInicial=?, horaFinal=?, albaran=? where TRABAJADORES_ID=? AND FECHA_ID=?";
        
        try {
            PreparedStatement ps = Conexion.getConexion().prepareStatement(sql);
            ps.setString(1, horaInicio);
            ps.setString(2, horaFin);
            ps.setInt(3, albaran);
            ps.setBigDecimal(4, idt);
            ps.setString(5, fecha);
            
            ps.executeUpdate();
            ps.close();
            Conexion.desconectar();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Viaje.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }   
    }

    public static boolean borrarViaje(String fecha, int albaran, BigDecimal idt){
        
        Conexion.conectar();
        String sql = "delete from viajes where fecha_id=? and albaran =? and trabajadores_id=?";
        try {
            PreparedStatement ps =Conexion.getConexion().prepareStatement(sql);
            
            ps.setString(1, fecha);
            ps.setInt(2, albaran);
            ps.setBigDecimal(3, idt);
            ps.execute();
            ps.close();
            Conexion.desconectar();
            
        } catch (SQLException ex) {
            Logger.getLogger(Viaje.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return true;
    }
    
    public static List<Viaje> logisticaViajes(BigDecimal idt, String fecha) {
        List<Viaje> viajes = new ArrayList<>();

        Conexion.conectar();
        String sql = "call logisticaViajes (?,?,?)";

        try {
            CallableStatement cs = Conexion.getConexion().prepareCall(sql);

            cs.setBigDecimal(1, idt);
            cs.setString(2, fecha);
            cs.registerOutParameter(3, OracleTypes.CURSOR);
            cs.execute();
            ResultSet rs = (ResultSet) cs.getObject(3);

            while (rs.next()) {
                Viaje v = new Viaje();

                v.setAlabaran(rs.getInt("albaran"));
                v.setHoraInicio(rs.getString("horaInicial"));
                v.setHoraFin(rs.getString("horaFinal"));

                viajes.add(v);
            }

            rs.close();
            cs.close();
            Conexion.desconectar();

        } catch (SQLException ex) {
            Logger.getLogger(Viaje.class.getName()).log(Level.SEVERE, null, ex);
        }

        return viajes;
    }
}
