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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BCASTROF
 */
public class Conducen {
    
    private BigDecimal idvH;
    private String fecha;
    private BigDecimal idT;

    private List<Logistica> logistaca =new ArrayList();
    
    public Conducen() {
    }

    public Conducen(BigDecimal idvH, String fecha, BigDecimal idT) {
        this.idvH = idvH;
        this.fecha = fecha;
        this.idT = idT;
    }

    public BigDecimal getIdvH() {
        return idvH;
    }

    public void setIdvH(BigDecimal idvH) {
        this.idvH = idvH;
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

    public List<Logistica> getLogistaca() {
        return logistaca;
    }

    public void setLogistaca(List<Logistica> logistaca) {
        this.logistaca = logistaca;
    }
    

    public boolean insertarConducen(){
        
        Conexion.conectar();
        String sql = "insert into conducen (TRABAJADORES_ID, VEHICULOS_ID, FECHA) values (?,?,?)";
        
        try {
            PreparedStatement smt = Conexion.getConexion().prepareStatement(sql);
            smt.setBigDecimal(1, idT);
            smt.setBigDecimal(2, idvH);
            smt.setString(3, fecha);
            smt.execute();
            smt.close();
            Conexion.desconectar();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Conducen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
    
    public void añadirLogistica(Logistica l){
        logistaca.add(l);
        
    }
      
}
