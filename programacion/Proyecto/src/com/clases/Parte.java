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
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import oracle.jdbc.OracleTypes;


/**
 *
 * @author 7fprog03
 */
public class Parte {
        
        private String fecha;
	private BigDecimal kmInicial;
	private BigDecimal kmFinal;
	private BigDecimal gastoPeaje;
	private BigDecimal gastoDietas;
	private BigDecimal gastoCombustible;
	private BigDecimal gastoVarios;
	private String incidencias;
	private String estado;
        private String validado;
        private BigDecimal horasExtras;
        private BigDecimal idTrabajador;
        private String notasAdministrativas;  
        //asociacion con aviso
        private Aviso aviso;
        
        //asosiacion con logistica
        private Logistica logistica;
        
         //asociacion con administracion
        //private Administracion administracion;
  
        //asociacion con viajes 
        private List<Viaje>viaje=new ArrayList<>();

    public Parte() {
    }

    public Parte(BigDecimal idTrabajador,  BigDecimal kmInicial, BigDecimal kmFinal, BigDecimal gastoPeaje, BigDecimal gastoDietas, BigDecimal gastoCombustible, BigDecimal gastoVarios, String incidencias) {
        this.idTrabajador=idTrabajador;
        this.kmInicial = kmInicial;
        this.kmFinal = kmFinal;
        this.gastoPeaje = gastoPeaje;
        this.gastoDietas = gastoDietas;
        this.gastoCombustible = gastoCombustible;
        this.gastoVarios = gastoVarios;
        this.incidencias = incidencias;
    }

    
    
    public Parte(String fecha, BigDecimal kmInicial, BigDecimal kmFinal, BigDecimal gastoPeaje, BigDecimal gastoDietas, BigDecimal gastoCombustible, BigDecimal gastoVarios, String incidencias, String estado, String validado, BigDecimal horasExtras, BigDecimal idTrabajador, String notasAdministrativas) {
        this.fecha = fecha;
        this.kmInicial = kmInicial;
        this.kmFinal = kmFinal;
        this.gastoPeaje = gastoPeaje;
        this.gastoDietas = gastoDietas;
        this.gastoCombustible = gastoCombustible;
        this.gastoVarios = gastoVarios;
        this.incidencias = incidencias;
        this.estado = estado;
        this.validado = validado;
        this.horasExtras = horasExtras;
        this.idTrabajador = idTrabajador;
        this.notasAdministrativas = notasAdministrativas;
    }

    public Parte(String fecha, BigDecimal idTrabajador) {
        this.fecha = fecha;
        this.idTrabajador = idTrabajador;
    }
    

    public Parte(BigDecimal idTrabajador) {
        this.idTrabajador = idTrabajador;
    }
    
  
    //metodo para recuperar un parte de un trabajador
    
    public static Parte parte(BigDecimal idt){
        Parte p = new Parte();
        Conexion.conectar();
        
            try {
                CallableStatement cs = Conexion.getConexion().prepareCall("call recuperarParte(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
                
                cs.setBigDecimal(1, idt);
                
                cs.registerOutParameter(2, OracleTypes.VARCHAR);
                cs.registerOutParameter(3, OracleTypes.INTEGER);
                cs.registerOutParameter(4, OracleTypes.INTEGER);
                cs.registerOutParameter(5, OracleTypes.INTEGER);
                cs.registerOutParameter(6, OracleTypes.INTEGER);
                cs.registerOutParameter(7, OracleTypes.INTEGER);
                cs.registerOutParameter(8, OracleTypes.INTEGER);
                cs.registerOutParameter(9, OracleTypes.VARCHAR);
                cs.registerOutParameter(10, OracleTypes.VARCHAR);
                cs.registerOutParameter(11, OracleTypes.VARCHAR);
                cs.registerOutParameter(12, OracleTypes.INTEGER);
                cs.registerOutParameter(13, OracleTypes.INTEGER);
                cs.registerOutParameter(14, OracleTypes.VARCHAR);
                cs.execute();
                
                String fecha = cs.getString(2);
                BigDecimal kmi = cs.getBigDecimal(3);
                BigDecimal kmf = cs.getBigDecimal(4);
                BigDecimal gp = cs.getBigDecimal(5);
                BigDecimal gd = cs.getBigDecimal(6);
                BigDecimal gc = cs.getBigDecimal(7);
                BigDecimal og = cs.getBigDecimal(8);
                String in=cs.getString(9);
                String es = cs.getString(10);
                String va = cs.getString(11);
                BigDecimal ho = cs.getBigDecimal(12);
                BigDecimal ift = cs.getBigDecimal(13);
                String no = cs.getString(14);
               p = new Parte(fecha, kmi, kmf, gp, gd, gc, og, in, es, va, ho, ift, no);    
              cs.close();
               Conexion.desconectar();
                 return p;
            } catch (SQLException ex) {
                    
            }    
      return null;
    }
    
    public boolean iniciarParte(){
        Conexion.conectar();
        
        String sql = "insert into partes (fecha, trabajadores_id) values (?,?)";
        
            try {
                PreparedStatement smt = Conexion.getConexion().prepareStatement(sql);
                
                smt.setString(1, fecha);
                smt.setBigDecimal(2, idTrabajador);
                
                smt.executeUpdate();
                smt.close();
                Conexion.desconectar();
                return true;
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "No se puede efectuar la conexión, hable con el administrador del sistema" + ex.getMessage());
            }
        
        return false;
    }
    
    

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public BigDecimal getKmInicial() {
        return kmInicial;
    }

    public void setKmInicial(BigDecimal kmInicial) {
        this.kmInicial = kmInicial;
    }

    public BigDecimal getKmFinal() {
        return kmFinal;
    }

    public void setKmFinal(BigDecimal kmFinal) {
        this.kmFinal = kmFinal;
    }

    public BigDecimal getGastoPeaje() {
        return gastoPeaje;
    }

    public void setGastoPeaje(BigDecimal gastoPeaje) {
        this.gastoPeaje = gastoPeaje;
    }

    public BigDecimal getGastoDietas() {
        return gastoDietas;
    }

    public void setGastoDietas(BigDecimal gastoDietas) {
        this.gastoDietas = gastoDietas;
    }

    public BigDecimal getGastoCombustible() {
        return gastoCombustible;
    }

    public void setGastoCombustible(BigDecimal gastoCombustible) {
        this.gastoCombustible = gastoCombustible;
    }

    public BigDecimal getGastoVarios() {
        return gastoVarios;
    }

    public void setGastoVarios(BigDecimal gastoVarios) {
        this.gastoVarios = gastoVarios;
    }

    public String getIncidencias() {
        return incidencias;
    }

    public void setIncidencias(String incidencias) {
        this.incidencias = incidencias;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getValidado() {
        return validado;
    }

    public void setValidado(String validado) {
        this.validado = validado;
    }

    public BigDecimal getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(BigDecimal horasExtras) {
        this.horasExtras = horasExtras;
    }

    public BigDecimal getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(BigDecimal idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public String getNotasAdministrativas() {
        return notasAdministrativas;
    }

    public void setNotasAdministrativas(String notasAdministrativas) {
        this.notasAdministrativas = notasAdministrativas;
    }

    public Logistica getLogistica() {
        return logistica;
    }

    public void setLogistica(Logistica logistica) {
        this.logistica = logistica;
    }
    
    public void añadirViaje(Viaje v){    
        viaje.add(v);
       v.setParte(this);
    } 
}