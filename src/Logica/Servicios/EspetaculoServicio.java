/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Servicios;

import Logica.Clases.Espectaculo;
import logica.Clases.DTFecha;
import Persistencia.ConexionDB;
import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 59898
 */
public class EspetaculoServicio {
    
    public EspetaculoServicio(){}
    
    private Connection conexion = new ConexionDB().getConexion();

    public ArrayList<String> llenarComboEspectaculos(int plataforma)
    {
        ArrayList<String> lista = new ArrayList<String>();
        try{
            ResultSet result = conexion.createStatement().executeQuery("SELECT * FROM espectaculos WHERE espec_plataforma = "+plataforma);
               try{
                   while(result.next())
                   {
                       lista.add(result.getString("espec_nombre"));
                   }
               }catch(Exception e)
               {
                  e.printStackTrace();
               }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return lista;
    }
}
