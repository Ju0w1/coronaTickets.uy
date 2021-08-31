/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Servicios;

import Logica.Clases.Paquete;
import Logica.DataTypes.DTFecha;
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
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO paquetes(paq_nombre, paq_descripcion,paq_descuento,paq_fecha_inicio,paq_fecha_fin,paq_fecha_alta  ) VALUES(?,?,?,?,?,?)");
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
    
    public void updatePaquete(String nombre,Date fechaInicio, Date fechaFin,int descuento,String descripcion)
    {
        try{
            PreparedStatement statement = conexion.prepareStatement("UPDATE paquetes SET paq_descripcion = ?, paq_fecha_inicio = ?, paq_fecha_fin = ?, paq_descuento = ? WHERE paq_nombre = ?");
            statement.setString(1, descripcion);
            statement.setDate(2, fechaInicio); //Fecha inicio
            statement.setDate(3, fechaFin); //Fecha fin
            statement.setDouble(4, descuento); //Descuento
            statement.setString(5, nombre);
            statement.execute();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public boolean verificarPaquete(String nombre)
    {
        boolean encontro = false;
        try{
            PreparedStatement stm = conexion.prepareStatement("SELECT * FROM paquetes");
            
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                if(rs.getString("paq_nombre").equals(nombre))
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
 
    public String obtenerDescripcion(String nombre)
    {
        String desc = "";
        try
        {
            PreparedStatement stm = conexion.prepareStatement("SELECT * FROM paquetes WHERE paq_nombre = ?");    
            stm.setString(1, nombre);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                desc = rs.getString("paq_descripcion");
            }
        }catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return desc;
    }
    
    public String[] obtenerFecha(String nombre, int fecha)
    {
        String fechas = "";
        String[] fechaSplit;
        try
        {
            PreparedStatement stm = conexion.prepareStatement("SELECT * FROM paquetes WHERE paq_nombre = ?");    
            stm.setString(1, nombre);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                if(fecha == 1) //Es la fecha de inicio
                {
                    fechas = rs.getDate("paq_fecha_inicio").toString();
                }else if(fecha == 2) //Es la fehca de fin
                {
                    fechas = rs.getDate("paq_fecha_fin").toString();
                }
            }
        }catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        fechaSplit = fechas.split("-");
        return fechaSplit;
    }
    
    public int obtenerDescuento(String nombre)
    {
        int descuento = 0;
        try
        {
            PreparedStatement stm = conexion.prepareStatement("SELECT * FROM paquetes WHERE paq_nombre = ?");    
            stm.setString(1, nombre);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                descuento = rs.getInt("paq_descuento");
            }
        }catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return descuento;
    }
    
}