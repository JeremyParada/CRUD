/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appcrudoracle.cl.negocio;

import com.appcrudoracle.cl.datos.DAOCliente;
import com.appcrudoracle.cl.entidades.Cliente;
import java.util.ArrayList;

/**
 *
 * @author CETECOM
 */
public class negCliente {
    private ArrayList<Cliente> clientes;

    public negCliente() {
        clientes = new ArrayList<Cliente>();
    }
    
    public boolean agregar(Cliente cli)
    {
        DAOCliente datCli = new DAOCliente();
        return datCli.crear(cli);
    }
    
    public ArrayList<Cliente> listarTodo()
    {
        ArrayList<Cliente> lCli = new ArrayList<Cliente>();
        DAOCliente datCliente = new DAOCliente();
        lCli = datCliente.listarTodo();
        return lCli;
    }
    
    public boolean modificar(Cliente cli)
    {
        DAOCliente datCli = new DAOCliente();
        return datCli.modificar(cli);
    }
    
    public boolean eliminar(Cliente cli)
    {
        DAOCliente datCli = new DAOCliente();
        return datCli.eliminar(cli);
    }
    
}
