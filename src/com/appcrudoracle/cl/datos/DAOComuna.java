/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appcrudoracle.cl.datos;
import com.appcrudoracle.cl.entidades.Comuna;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author CETECOM
 */
public class DAOComuna {
    private final String selectAll = "select * from comuna";
    private static Conexion objConn = Conexion.InstanciaConn();
    private ResultSet rs;
    
    public ArrayList<Comuna> listarTodo()
    {
        try {
            ArrayList<Comuna> listaCom = new ArrayList<Comuna>();
            PreparedStatement ps = objConn.getConn().prepareStatement(selectAll);
            rs = ps.executeQuery();
            while(rs.next())
            {
                Comuna com = new Comuna();
                com.setId_comuna(rs.getInt("ID_COMUNA"));
                com.setNombre(rs.getString("NOMBRE"));
                listaCom.add(com);
            }
            return listaCom;
        } catch (SQLException ex) {
            Logger.getLogger(DAOComuna.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
