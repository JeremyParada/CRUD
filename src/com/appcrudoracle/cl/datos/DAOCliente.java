/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appcrudoracle.cl.datos;

import com.appcrudoracle.cl.entidades.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CETECOM
 */
public class DAOCliente {
    private static Conexion objConn = Conexion.InstanciaConn();
    private ResultSet rs;
    private final String selectAll = "SELECT \n" +
                                    "C.RUT AS RUT\n" +
                                    ", C.NOMBRE AS NOMBRE\n" +
                                    ", COM.NOMBRE AS NOM_COMUNA\n" +
                                    ", C.ESTADO_CIVIL AS ESTADO_CIVIL\n" +
                                    ", C.LENGUAJES AS LENGUAJES\n" +
                                    "FROM \n" +
                                    "CLIENTE C\n" +
                                    "INNER JOIN\n" +
                                    "COMUNA COM\n" +
                                    "ON(C.ID_COMUNA=COM.ID_COMUNA)";
    private final String insert = "INSERT INTO CLIENTE (RUT,NOMBRE,ID_COMUNA,ESTADO_CIVIL,LENGUAJES) VALUES (?,?,?,?,?)";
    private final String update = "UPDATE CLIENTE SET NOMBRE = ?,ID_COMUNA = ?, ESTADO_CIVIL = ?, LENGUAJES=? WHERE RUT=?";
    private final String delete = "DELETE FROM CLIENTE WHERE RUT = ?";
    public ArrayList<Cliente> listarTodo()
    {
        try {
            ArrayList<Cliente> listaCli = new ArrayList<Cliente>();
            PreparedStatement ps = objConn.getConn().prepareStatement(selectAll);
            rs = ps.executeQuery();
            while(rs.next())
            {
                Cliente cli = new Cliente();
                cli.setRut(rs.getString("RUT"));
                cli.setNombre(rs.getString("NOMBRE"));
                cli.setEstadoCivil(rs.getString("ESTADO_CIVIL"));
                cli.setComuna(rs.getString("NOM_COMUNA"));
                cli.setLenguajes(rs.getString("LENGUAJES"));
                listaCli.add(cli);
            
            }
            return listaCli;
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
    public boolean crear(Cliente cli)
    {
        try {
            PreparedStatement ps = objConn.getConn().prepareStatement(insert);
            ps.setString(1, cli.getRut());
            ps.setString(2, cli.getNombre());
            ps.setInt(3, cli.getId_comuna());
            ps.setString(4, cli.getEstadoCivil());
            ps.setString(5, cli.getLenguajes());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean modificar(Cliente cli)
    {
        try {
            PreparedStatement ps = objConn.getConn().prepareStatement(update);
            
            ps.setString(1, cli.getNombre());
            ps.setInt(2, cli.getId_comuna());
            ps.setString(3, cli.getEstadoCivil());
            ps.setString(4, cli.getLenguajes());
            ps.setString(5, cli.getRut());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean eliminar(Cliente cli)
    {
        try {
            PreparedStatement ps = objConn.getConn().prepareStatement(delete);
            
            
            ps.setString(1, cli.getRut());
            ps.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DAOCliente.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    
    }
    
    
}
