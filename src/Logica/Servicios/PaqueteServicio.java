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

    public void addPaquete(String nombre,Date fechaInicio, Date fechaFin,Date fechaCreado,int descuento,String descripcion)
    {
        try{
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO paquetes(paq_nombre, paq_descripcion,paq_descuento,paq_fecha_inicio,paq_fecha_fin,paq_fecha_creado  ) VALUES(?,?,?,?,?,?)");
            statement.setString(1, nombre);
            statement.setString(2, descripcion);
            statement.setDouble(3, descuento); //Descuento
            statement.setDate(4, fechaInicio); //Fecha inicio
            statement.setDate(5, fechaFin); //Fecha fin
            statement.setDate(6, fechaCreado); //Fecha creado
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
            stm.setString(1,nombre);
            ResultSet rs = stm.executeQuery();
            if(rs.next())
            {
                while(rs.next())
                {
                    if(rs.getString("paq_nombre") == nombre)
                    {
                        encontro = true;
                        break;
                    }
                }
            }
           
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return encontro;
    }
    
}
