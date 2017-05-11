/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author bcastrof
 */
public class Conexion {
    
    private static Connection conexion;
 
    public static Connection getConexion() {
        return conexion;
    }
    
    
    public static void conectar() {
        try { 
            //conexion fuera de clase
          /*
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String login="LOGISTICA"; // mirar esto
            String pass="deh74f5c";  //mirar esto
            String url="jdbc:oracle:thin:@localhost:1521:xe";   //mirar esto
            conexion= DriverManager.getConnection(url, login, pass);
            conexion.setAutoCommit(true);
            */
           
            //conexion clase
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String login="noc03";
            String pass="noc03";
            String url="jdbc:oracle:thin:@SrvOracle:1521:orcl";
            conexion= DriverManager.getConnection(url, login, pass);
            conexion.setAutoCommit(true);
            
            
        } catch (SQLException  | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un problema \n"+ex.getMessage()); 
        }
    }
    
    public static void desconectar() throws SQLException{
        conexion.close();
         
}
    
}
