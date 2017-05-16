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
 * clase extra creada para que los administrativos puedan consultar quien a
 * conducido que vehiculo en ea fecha
 */
public class Conducen {

    private BigDecimal idvH;
    private String matricula;
    private String nombret;
    private String fecha;
    private BigDecimal idT;

    private List<Logistica> logistaca = new ArrayList();

    public Conducen() {
    }

    public Conducen(BigDecimal idvH, String fecha, BigDecimal idT) {
        this.idvH = idvH;
        this.fecha = fecha;
        this.idT = idT;
    }

    public Conducen(String matricula, String nombret) {
        this.matricula = matricula;
        this.nombret = nombret;
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombret() {
        return nombret;
    }

    public void setNombret(String nombret) {
        this.nombret = nombret;
    }

    /**
     * Metodo para la insecion de los datos en la tabla conducen, este metodo se
     * ejecuta un vez que hayan seleccionado el vehiculo para realizar la
     * jornada laboral.
     */
    public boolean insertarConducen() {

        Conexion.conectar();
        String sql = "insert into conducen (TRABAJADORES_ID, VEHICULOS_ID, FECHA) values (?,?,?)";

        try {
            PreparedStatement smt = Conexion.getConexion().prepareStatement(sql);
            smt.setBigDecimal(1, idT);
            smt.setBigDecimal(2, idvH);
            smt.setString(3, fecha);
            smt.executeUpdate();
            smt.close();

            Conexion.desconectar();
            return true;

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Vehiculo ya seleccionado.\nVerifique la información de"
                    + "su vehiculo.\n" + ex.getMessage());
        }

        return false;
    }

    /**
     *
     * Con este metodo los administrativos pueden conocer a la hora de validar
     * el partes que vehiculo ha utilizado el trabajador de logistica.
     */
    public static Conducen listar(BigDecimal idt, String fecha) {
        try {
            Conexion.conectar();
            String sql = ("call cDetalle (?,?,?,?)");

            CallableStatement cs = Conexion.getConexion().prepareCall(sql);
            cs.setString(1, fecha);
            cs.setBigDecimal(2, idt);
            cs.registerOutParameter(3, OracleTypes.VARCHAR);
            cs.registerOutParameter(4, OracleTypes.VARCHAR);
            cs.execute();

            Conducen c = new Conducen(cs.getString(3), cs.getString(4));
            return c;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado ningun trabajador con esa matricula.\nVerifique la matricula de"
                    + "busqueda.\n" + ex.getMessage());
        }
        return null;
    }

    public void añadirLogistica(Logistica l) {
        logistaca.add(l);

    }

}
