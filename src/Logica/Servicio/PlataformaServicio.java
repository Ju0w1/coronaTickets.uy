/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Servicio;

import Logica.Clases.Plataforma;
import Logica.DataTypes.DTFecha;
import Persistencia.ConexionDB;
import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
/**
 *
 * @author 59898
 */
public class PlataformaServicio {
    public PlataformaServicio(){}
    
    private Connection conexion = new ConexionDB().getConexion();
        
    public ArrayList<String> llenarComboPlataforma()
    {
        ArrayList<String> lista = new ArrayList<String>();
        try{
            ResultSet result = conexion.createStatement().executeQuery("SELECT * FROM valores_tipo WHERE dt_id = 1");
               try{
                   while(result.next())
                   {
                       lista.add(result.getString("vp_nombre"));
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
