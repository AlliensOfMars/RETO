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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import oracle.jdbc.OracleTypes;
/**
 *
 * @author 7fprog03
 */
public class Trabajador {

    private BigDecimal id;
    private String dni;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;
    private String categoria;
    private String calle;
    private BigDecimal numero;
    private BigDecimal piso;
    private String mano;
    private String ciudad;
    private BigDecimal codigoPostal;
    private String provincia;
    private BigDecimal movilEmpresa;
    private BigDecimal movilPersonal;
    private BigDecimal salario;
    private String fechaNacimiento;
    private BigDecimal idCent;
    //asociacion con centros 
    private Centro centro;
    //asociacion con usuarios
    private  Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Trabajador() {
    }

    public Trabajador( String dni, String nombre, String primerApellido, String segundoApellido, String categoria, String calle, BigDecimal numero, BigDecimal piso, String mano, String ciudad, BigDecimal codigoPostal, String provincia, BigDecimal movilEmpresa, BigDecimal movilPersonal, BigDecimal salario, String fechaNacimiento, BigDecimal idCent) {
      
        this.dni = dni;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.categoria = categoria;
        this.calle = calle;
        this.numero = numero;
        this.piso = piso;
        this.mano = mano;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.provincia = provincia;
        this.movilEmpresa = movilEmpresa;
        this.movilPersonal = movilPersonal;
        this.salario = salario;
        this.fechaNacimiento = fechaNacimiento;
        this.idCent = idCent;
    }



    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public BigDecimal getNumero() {
        return numero;
    }

    public void setNumero(BigDecimal numero) {
        this.numero = numero;
    }

    public BigDecimal getPiso() {
        return piso;
    }

    public void setPiso(BigDecimal piso) {
        this.piso = piso;
    }

    public String getMano() {
        return mano;
    }

    public void setMano(String mano) {
        this.mano = mano;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public BigDecimal getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(BigDecimal codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public BigDecimal getMovilEmpresa() {
        return movilEmpresa;
    }

    public void setMovilEmpresa(BigDecimal movilEmpresa) {
        this.movilEmpresa = movilEmpresa;
    }

    public BigDecimal getMovilPersonal() {
        return movilPersonal;
    }

    public void setMovilPersonal(BigDecimal movilPersonal) {
        this.movilPersonal = movilPersonal;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public BigDecimal getIdCent() {
        return idCent;
    }

    public void setIdCent(BigDecimal idCent) {
        this.idCent = idCent;
    }
    
    //listar trabajadores
    public static List <Trabajador>listarTrabajadores(){
        List<Trabajador>trabajadores=new ArrayList<>();
        
        Conexion.conectar();
        try {
            CallableStatement cs = Conexion.getConexion().prepareCall("{call listartrabajadores(?)}");
            cs.registerOutParameter(1, OracleTypes.CURSOR);
            cs.execute();
            
            ResultSet rs = (ResultSet) cs.getObject(1);
            while(rs.next()){
                Trabajador t = new Trabajador();
                t.setId(rs.getBigDecimal("ID"));
                t.setDni(rs.getString("dni"));
                t.setNombre(rs.getString("nombre"));
                t.setPrimerApellido(rs.getString("primerApellido"));
                t.setSegundoApellido(rs.getString("segundoapellido"));
                t.setCategoria(rs.getString("categoria"));
                t.setCalle(rs.getString("calle"));
                t.setNumero(rs.getBigDecimal("numero"));
                t.setPiso(rs.getBigDecimal("piso"));
                t.setMano(rs.getString("mano"));
                t.setCiudad(rs.getString("ciudad"));
                t.setCodigoPostal(rs.getBigDecimal("codigoPostal"));
                t.setProvincia(rs.getString("provincia"));
                t.setMovilEmpresa(rs.getBigDecimal("movilEmpresa"));
                t.setMovilPersonal(rs.getBigDecimal("movilPersonal"));
                t.setSalario(rs.getBigDecimal("salario"));
                t.setFechaNacimiento(rs.getString("fechaNacimiento"));
                t.setIdCent(rs.getBigDecimal("CENTROS_ID"));
                trabajadores.add(t);
                System.out.println(t);
            }
            rs.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede efectuar la conexión, hable con el administrador del sistema" + ex.getMessage());
        }
        
        return trabajadores;
    }
    
    public static  List<Trabajador>filtrarTrabajador(String dni){
        List<Trabajador>trabajador=new ArrayList<>();
        Conexion.conectar();
        try {
            CallableStatement cs = Conexion.getConexion().prepareCall("{call filtrarTrabajador(?,?)}");
            cs.setString(1, dni);
            cs.registerOutParameter(2, OracleTypes.CURSOR);
            cs.execute();
            
            ResultSet rs = (ResultSet) cs.getObject(2);
           
            while(rs.next()){
                Trabajador t = new Trabajador();
                t.setId(rs.getBigDecimal("ID"));
                t.setDni(rs.getString("dni"));
                t.setNombre(rs.getString("nombre"));
                t.setPrimerApellido(rs.getString("primerApellido"));
                t.setSegundoApellido(rs.getString("segundoApellido"));
                t.setCategoria(rs.getString("categoria"));
                t.setCalle(rs.getString("calle"));
                t.setNumero(rs.getBigDecimal("numero"));
                t.setPiso(rs.getBigDecimal("piso"));
                t.setMano(rs.getString("mano"));
                t.setCiudad(rs.getString("ciudad"));
                t.setCodigoPostal(rs.getBigDecimal("codigoPostal"));
                t.setProvincia(rs.getString("provincia"));
                t.setMovilEmpresa(rs.getBigDecimal("movilEmpresa"));
                t.setMovilPersonal(rs.getBigDecimal("movilPersonal"));
                t.setSalario(rs.getBigDecimal("salario"));
                t.setFechaNacimiento(rs.getString("fechaNacimiento"));
                t.setIdCent(rs.getBigDecimal("CENTROS_ID"));
                trabajador.add(t);
                System.out.println(t);
            }
            rs.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            Logger.getLogger(Trabajador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return trabajador;
    }
    
    //27/04 botón modificar
    public boolean modificarTrabajador(BigDecimal idTrab) {

        Conexion.conectar();

        try {
            PreparedStatement ps = Conexion.getConexion().prepareStatement("UPDATE TRABAJADORES SET dni=?,nombre=?,"
                    +"primerApellido=?, segundoApellido =?,categoria=?,calle=?,"
                    + "numero=?,piso=?, mano=?, ciudad=?,codigoPostal=?,provincia=?,"
                    + "movilEmpresa=?,movilPersonal=?,salario=?,fechaNacimiento=?, CENTROS_ID=? WHERE id=?");
            ps.setString(1, dni);
            ps.setString(2, nombre);
            ps.setString(3, primerApellido);
            ps.setString(4, segundoApellido);
            ps.setString(5, categoria);
            ps.setString(6,calle );
            ps.setBigDecimal(7, numero);
            ps.setBigDecimal(8, piso);
            ps.setString(9, mano);
            ps.setString(10, ciudad);
            ps.setBigDecimal(11, codigoPostal);
            ps.setString(12, provincia);
            ps.setBigDecimal(13, movilEmpresa);
            ps.setBigDecimal(14, movilPersonal);
            ps.setBigDecimal(15, salario);
            ps.setString(16, fechaNacimiento);
            ps.setBigDecimal(17, idCent);
            ps.setBigDecimal(18, idTrab);

            ps.executeUpdate();
            ps.close();
            Conexion.desconectar();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede efectuar la conexión, hable con el administrador del sistema \n" + ex.getMessage());
            return false;
        }
        
    }
    
    //27/04 Miriam
    
     public static boolean bajaTrabajador(BigDecimal idTrab) {
        try {
            Conexion.conectar();
            PreparedStatement ps = Conexion.getConexion().prepareStatement("delete from trabajadores where id=?");
            ps.setBigDecimal(1, idTrab);
            ps.execute();
            ps.close();
            Conexion.desconectar();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede efectuar la conexión, hable con el administrador del sistema \n" + ex.getMessage());
            return false;
        }
    }
     
     public boolean altaTrabajador12c(){
        Conexion.conectar();
       
        try {
            
            String sql = ("insert into trabajadores (dni, nombre, primerApellido, segundoApellido, categoria, calle, numero, piso, mano, ciudad, codigoPostal, provincia, movilEmpresa, movilPersonal, salario, fechaNacimiento, CENTROS_ID)"
                    + "values(?,?,?,?,?,"
                    + "?,?,?,?,?,?,?,"
                    + "?,?,?,?,?)");
            //String sql = ("insert into trabajadores (dni,nombre,primerApellido, segundoApellido, categoria, calle, numero, ciudad, codigoPostal, provincia, movilEmpresa, movilPersonal"
                  // + "fechaNacimiento, CENTROS_ID values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            PreparedStatement smt = Conexion.getConexion().prepareStatement(sql);
           // smt.setBigDecimal(1, id);
            smt.setString(1, dni);
            smt.setString(2, nombre);
            smt.setString(3, primerApellido);
            smt.setString(4, segundoApellido);
            smt.setString(5, categoria);
            
            smt.setString(6, calle);
            smt.setBigDecimal(7, numero);
            smt.setBigDecimal(8, piso);
            smt.setString(9, mano);
            smt.setString(10, ciudad);
            smt.setBigDecimal(11, codigoPostal);
            smt.setString(12, provincia);
            
            smt.setBigDecimal(13, movilEmpresa);
            smt.setBigDecimal(14, movilPersonal);
            smt.setBigDecimal(15, salario);
            smt.setString(16, fechaNacimiento);
            smt.setBigDecimal(17, idCent);
           
            smt.executeUpdate();
            smt.close();
            Conexion.desconectar();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede efectuar la conexión, hable con el administrador del sistema" + ex.getMessage());
            return false;
        }     
    }
    
    public static Usuario altaUsuario(String dni, String nombre, String apellido){
        String ido="call idTrabajador(?,?)";
        String insert = "insert into usuarios (usuario, password, TRABAJADORES_ID) values(?,?,?)";
        BigDecimal idu=null;
         //recupero la id
        try {
            Conexion.conectar();
            CallableStatement cs = Conexion.getConexion().prepareCall(ido);
            cs.setString(1, dni);
            cs.registerOutParameter(2, OracleTypes.INTEGER);
            cs.execute();
            
            idu = cs.getBigDecimal(2);
            System.out.println("");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede recuperar la id del trabajador" + ex.getMessage());
        }
        
        //creo usuario 
        String name=nombre.replaceAll(" ","");
        String user = String.valueOf(name).concat(".").concat(apellido);
     
        //creo contraseña
        String caracteres = "TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke1234567890";
        StringBuilder pass = new StringBuilder();
        Random rnd = new Random();

        while(pass.length() < 8) {
            int password = (int)(rnd.nextFloat() * (float)caracteres.length());
            pass.append(caracteres.charAt(password));
        }
        String password1 = pass.toString();
       
         //inserto en base datos los datos del nuevo usuario
         try {
            Conexion.conectar();
            PreparedStatement smt = Conexion.getConexion().prepareStatement(insert);
            smt.setString(1, user);
            smt.setString(2, password1);
            smt.setBigDecimal(3, idu);
            
            smt.executeUpdate();
            smt.close();
            Conexion.desconectar();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "No se puede insertar el usuario" + ex.getMessage());
        }
         //creo objeto usuario
        Usuario usuario =new Usuario(user,password1);
        String pass1 = usuario.getPassword();
        String user1 = usuario.getIdUsuario();
        
        
        System.out.println("esto genera: "+pass+" esto tiene el obj: "+pass1);
        return usuario;
        
    }
    

    @Override
    public String toString() {
        return "Trabajador{" + "id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", primerApellido=" + primerApellido + ", segundoApellido=" + segundoApellido + ", categoria=" + categoria + ", calle=" + calle + ", numero=" + numero + ", piso=" + piso + ", mano=" + mano + ", ciudad=" + ciudad + ", codigoPostal=" + codigoPostal + ", provincia=" + provincia + ", movilEmpresa=" + movilEmpresa + ", movilPersonal=" + movilPersonal + ", salario=" + salario + ", fechaNacimiento=" + fechaNacimiento + ", idCent=" + idCent + '}';
    }

}
