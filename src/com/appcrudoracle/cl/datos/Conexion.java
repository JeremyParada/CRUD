/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appcrudoracle.cl.datos;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.*;
/**
 *
 * @author CETECOM
 */
public class Conexion {
    public static Conexion instConn;
    private Connection conn;
    private Conexion()
    {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "VENTAS", "123456");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public synchronized static Conexion InstanciaConn()
    {
        if(instConn==null)
        {
            instConn = new Conexion();
        }
        return instConn;
    }
    
    public Connection getConn()
    {
        return conn;
    }
    
    public void Cerrar()
    {
        instConn = null;
    }
    
}
