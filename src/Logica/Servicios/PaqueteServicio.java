/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Servicios;

import logica.Clases.Paquete;
import logica.Clases.DTFecha;
import Persistencia.ConexionDB;
import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 59898
 */
public class PaqueteServicio {
    public PaqueteServicio() {}
    private Connection conexion = new ConexionDB().getConexion();

    public void addPaquete(String nombre,Date fechaInicio, Date fechaFin,Date fechaCreado,double descuento,String descripcion)
    {
        try{
            //,paq_fecha_inicio,paq_fecha_fin,paq_fecha_creado  
            //,?,?,?
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO paquetes(paq_nombre, paq_descripcion,paq_descuento) VALUES(?,?,?)");
            statement.setString(0, nombre);
            statement.setString(1, descripcion);
/*            statement.setDate(2, fechaInicio); //Fecha inicio
            statement.setDate(3, fechaFin); //Fecha fin
            statement.setDate(4, fechaCreado); //Fecha creado
  */          statement.setDouble(2, descuento); //Descuento
            statement.execute();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public boolean verificarPaquete(String nombre)
    {
        boolean encontro = false;
        try{
            PreparedStatement stm = conexion.prepareStatement("SELECT * FROM paquetes WHERE paq_nombre = ?");
            stm.setString(0,nombre);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                if(rs.getString("paq_nombre") == nombre)
                {
                    encontro = true;
                    break;
                }
            }
           
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return encontro;
    }
    
}
