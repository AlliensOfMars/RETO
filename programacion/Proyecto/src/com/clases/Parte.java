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
 * Clase creada con el fin de realizar diferentes listados relacionados con el
 * parte, tambien es la encargada de dar de alta el mismo.
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

    //asociacion con viajes 
    private List<Viaje> viaje = new ArrayList<>();

    public Parte() {
    }

    public Parte(BigDecimal idTrabajador, BigDecimal kmInicial, BigDecimal kmFinal, BigDecimal gastoPeaje, BigDecimal gastoDietas, BigDecimal gastoCombustible, BigDecimal gastoVarios, String incidencias) {
        this.idTrabajador = idTrabajador;
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

    public Parte(String fecha, BigDecimal idTrabajador, String notasAdministrativas) {
        this.fecha = fecha;
        this.idTrabajador = idTrabajador;
        this.notasAdministrativas = notasAdministrativas;
    }

    public Parte(BigDecimal idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    /**
     *
     * Metodo que se encarga de la recuperación de un parte que ha sido
     * previamente creado por logistica y que no ha sido cerrado, dicho parte es
     * recuperado de la base de datos usando como parametro de busqueda la Id
     * del Trabajador.
     */
    public static Parte parte(BigDecimal idt) {
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
            String in = cs.getString(9);
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

    /**
     * Metodo utilizado para listar todos los partes existentes en nuestra base
     * datos, dicho metodo recibe un cursor de partes (de la base de datos) y va
     * almacenando esa información en un array que el cual se usa posteriormente
     * para visualizar la información recuperada.
     */
    public static List<Parte> listarPartes() {
        List<Parte> partes = new ArrayList<>();
        Conexion.conectar();
        String sql = "call ppartes.partesList (?)";

        try {
            CallableStatement cs = Conexion.getConexion().prepareCall(sql);
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();

            ResultSet rs = (ResultSet) cs.getObject(1);
            while (rs.next()) {
                Parte p = new Parte();
                p.setFecha(rs.getString("fecha"));
                p.setKmInicial(rs.getBigDecimal("kmInicial"));
                p.setKmFinal(rs.getBigDecimal("kmFinal"));
                p.setGastoPeaje(rs.getBigDecimal("gastosPeaje"));
                p.setGastoDietas(rs.getBigDecimal("gastosDietas"));
                p.setGastoCombustible(rs.getBigDecimal("gastosCombustible"));
                p.setGastoVarios(rs.getBigDecimal("otrosGastos"));
                p.setIncidencias(rs.getString("incidencias"));
                p.setEstado(rs.getString("estado"));
                p.setValidado(rs.getString("validado"));
                p.setHorasExtras(rs.getBigDecimal("horasExtras"));
                p.setIdTrabajador(rs.getBigDecimal("TRABAJADORES_ID"));
                p.setNotasAdministrativas(rs.getString("notasAdministrativas"));
                partes.add(p);
            }

            rs.close();
            cs.close();
            Conexion.desconectar();
            return partes;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede efectuar la conexión, hable con el administrador del sistema" + ex.getMessage());
        }
        return null;
    }

    /**
     *
     * Metodo para el listado de partes de un trabajador en un determinado rango
     * de fechas, dicha información es recuperada por un cursor (desde la base
     * datos), este metodo aparte recibe los parametros de busqueda que se van a
     * utilizar en el procidimento de la base datos.
     */
    public static List<Parte> partesTFI(BigDecimal idT, String fechaIni, String fechaFin) {
        List<Parte> partes = new ArrayList<>();
        Conexion.conectar();
        String sql = "call ppartes.partesTFI (?,?,?,?)";

        try {
            CallableStatement cs = Conexion.getConexion().prepareCall(sql);
            cs.setBigDecimal(1, idT);
            cs.setString(2, fechaIni);
            cs.setString(3, fechaFin);
            cs.registerOutParameter(4, OracleTypes.CURSOR);
            cs.execute();

            ResultSet rs = (ResultSet) cs.getObject(4);
            while (rs.next()) {
                Parte p = new Parte();
                p.setFecha(rs.getString("fecha"));
                p.setKmInicial(rs.getBigDecimal("kmInicial"));
                p.setKmFinal(rs.getBigDecimal("kmFinal"));
                p.setGastoPeaje(rs.getBigDecimal("gastosPeaje"));
                p.setGastoDietas(rs.getBigDecimal("gastosDietas"));
                p.setGastoCombustible(rs.getBigDecimal("gastosCombustible"));
                p.setGastoVarios(rs.getBigDecimal("otrosGastos"));
                p.setIncidencias(rs.getString("incidencias"));
                p.setEstado(rs.getString("estado"));
                p.setValidado(rs.getString("validado"));
                p.setHorasExtras(rs.getBigDecimal("horasExtras"));
                p.setIdTrabajador(rs.getBigDecimal("TRABAJADORES_ID"));
                p.setNotasAdministrativas(rs.getString("notasAdministrativas"));
                partes.add(p);
            }

            rs.close();
            cs.close();
            Conexion.desconectar();
            return partes;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede efectuar la conexión, hable con el administrador del sistema" + ex.getMessage());
        }
        return null;
    }

    /**
     * Metodo para el listado de partes en un determinado rango de fechas, dicha
     * información es recuperada por un cursor (desde la base datos), este
     * metodo aparte recibe los parametros de busqueda que se van a utilizar en
     * el procidimento de la base datos.
     */
    public static List<Parte> partesTFF(String fechaIni, String fechaFin) {
        List<Parte> partes = new ArrayList<>();
        Conexion.conectar();
        String sql = "call ppartes.partesTFF (?,?,?)";

        try {
            CallableStatement cs = Conexion.getConexion().prepareCall(sql);

            cs.setString(1, fechaIni);
            cs.setString(2, fechaFin);
            cs.registerOutParameter(3, OracleTypes.CURSOR);
            cs.execute();

            ResultSet rs = (ResultSet) cs.getObject(3);
            while (rs.next()) {
                Parte p = new Parte();
                p.setFecha(rs.getString("fecha"));
                p.setKmInicial(rs.getBigDecimal("kmInicial"));
                p.setKmFinal(rs.getBigDecimal("kmFinal"));
                p.setGastoPeaje(rs.getBigDecimal("gastosPeaje"));
                p.setGastoDietas(rs.getBigDecimal("gastosDietas"));
                p.setGastoCombustible(rs.getBigDecimal("gastosCombustible"));
                p.setGastoVarios(rs.getBigDecimal("otrosGastos"));
                p.setIncidencias(rs.getString("incidencias"));
                p.setEstado(rs.getString("estado"));
                p.setValidado(rs.getString("validado"));
                p.setHorasExtras(rs.getBigDecimal("horasExtras"));
                p.setIdTrabajador(rs.getBigDecimal("TRABAJADORES_ID"));
                p.setNotasAdministrativas(rs.getString("notasAdministrativas"));
                partes.add(p);
            }

            rs.close();
            cs.close();
            Conexion.desconectar();
            return partes;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede efectuar la conexión, hable con el administrador del sistema" + ex.getMessage());
        }
        return null;
    }

    /**
     *
     * Metodo para el listado de partes cuyo su estado sea abierto, dicha
     * información es recuperada por un cursor (desde la base datos) y la
     * alamacena en un array que es lo que devolvemos al usuario.
     */
    public static List<Parte> partesTFA() {
        List<Parte> partes = new ArrayList<>();
        Conexion.conectar();
        String sql = "call ppartes.partesTA (?)";

        try {
            CallableStatement cs = Conexion.getConexion().prepareCall(sql);

            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();

            ResultSet rs = (ResultSet) cs.getObject(1);
            while (rs.next()) {
                Parte p = new Parte();
                p.setFecha(rs.getString("fecha"));
                p.setKmInicial(rs.getBigDecimal("kmInicial"));
                p.setKmFinal(rs.getBigDecimal("kmFinal"));
                p.setGastoPeaje(rs.getBigDecimal("gastosPeaje"));
                p.setGastoDietas(rs.getBigDecimal("gastosDietas"));
                p.setGastoCombustible(rs.getBigDecimal("gastosCombustible"));
                p.setGastoVarios(rs.getBigDecimal("otrosGastos"));
                p.setIncidencias(rs.getString("incidencias"));
                p.setEstado(rs.getString("estado"));
                p.setValidado(rs.getString("validado"));
                p.setHorasExtras(rs.getBigDecimal("horasExtras"));
                p.setIdTrabajador(rs.getBigDecimal("TRABAJADORES_ID"));
                p.setNotasAdministrativas(rs.getString("notasAdministrativas"));
                partes.add(p);
            }

            rs.close();
            cs.close();
            Conexion.desconectar();
            return partes;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede efectuar la conexión, hable con el administrador del sistema" + ex.getMessage());
        }
        return null;
    }

    /**
     * Metodo para el listado de partes cuyo su estado sea cerrado, dicha
     * información es recuperada por un cursor (desde la base datos) y devuelve
     * un array con los datos.
     */
    public static List<Parte> partesTFC() {
        List<Parte> partes = new ArrayList<>();
        Conexion.conectar();
        String sql = "call ppartes.partesTC (?)";

        try {
            CallableStatement cs = Conexion.getConexion().prepareCall(sql);

            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();

            ResultSet rs = (ResultSet) cs.getObject(1);
            while (rs.next()) {
                Parte p = new Parte();
                p.setFecha(rs.getString("fecha"));
                p.setKmInicial(rs.getBigDecimal("kmInicial"));
                p.setKmFinal(rs.getBigDecimal("kmFinal"));
                p.setGastoPeaje(rs.getBigDecimal("gastosPeaje"));
                p.setGastoDietas(rs.getBigDecimal("gastosDietas"));
                p.setGastoCombustible(rs.getBigDecimal("gastosCombustible"));
                p.setGastoVarios(rs.getBigDecimal("otrosGastos"));
                p.setIncidencias(rs.getString("incidencias"));
                p.setEstado(rs.getString("estado"));
                p.setValidado(rs.getString("validado"));
                p.setHorasExtras(rs.getBigDecimal("horasExtras"));
                p.setIdTrabajador(rs.getBigDecimal("TRABAJADORES_ID"));
                p.setNotasAdministrativas(rs.getString("notasAdministrativas"));
                partes.add(p);
            }

            rs.close();
            cs.close();
            Conexion.desconectar();
            return partes;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede efectuar la conexión, hable con el administrador del sistema" + ex.getMessage());
        }
        return null;
    }

    /**
     * Metodo que se encarga de la inserción de un nuevo parte, una vez que el
     * trabajador ha iniciado su jornada laboral.
     */
    public boolean iniciarParte() {
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

    public void añadirViaje(Viaje v) {
        viaje.add(v);
        v.setParte(this);
    }
}
