/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.appcrudoracle.cl.negocio;

import com.appcrudoracle.cl.datos.DAOComuna;
import com.appcrudoracle.cl.entidades.Comuna;
import java.util.ArrayList;

/**
 *
 * @author CETECOM
 */
public class negComuna {
   public ArrayList<Comuna> listarTodo()
   {
       DAOComuna dComuna = new DAOComuna();
       ArrayList<Comuna> lCom = new ArrayList<Comuna>();
       lCom = dComuna.listarTodo();
       return lCom;
   }
}
