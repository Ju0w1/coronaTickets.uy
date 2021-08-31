package Logica.servicios;

import Logica.DataTypes.DTFecha;
import Persistencia.ConexionDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import Logica.Clases.Paquete;


public class PaquetesServicios {

    public PaquetesServicios() {
    }
    private Connection conexion = new ConexionDB().getConexion();

    public DTFecha dateToDTFecha(Date fecha){
        if(fecha != null){
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String fechaDB = dateFormat.format(fecha);
            String[] partes = fechaDB.split("-");
            return new DTFecha(Integer.parseInt(partes[2]),Integer.parseInt(partes[1]),Integer.parseInt(partes[0]));
        }
        else{
            return new DTFecha(0,0,0);
        }
        
    }
    
    
    public Map<String, Paquete> getPaquete() {
        Map<String, Paquete> resultado = new HashMap<>();
        try {
            PreparedStatement status = conexion.prepareStatement("SELECT * FROM paquetes");
            ResultSet rs = status.executeQuery();
            
            while (rs.next()) {
                dateToDTFecha(rs.getDate("paq_fecha_inicio"));
                resultado.put(rs.getString("paq_nombre"), new Paquete(rs.getString("paq_nombre"), rs.getString("paq_descripcion"), dateToDTFecha(rs.getDate("paq_fecha_inicio")), dateToDTFecha(rs.getDate("paq_fecha_fin")),rs.getFloat("paq_costo"), rs.getFloat("paq_descuento"), dateToDTFecha(rs.getDate("paq_fecha_compra")))); 
                //System.out.println("Nombre: "+ rs.getString("paq_nombre")+"Descripcion: "+ rs.getString("paq_descripcion")+"Costo: "+ rs.getFloat("paq_costo")+"Descuento: "+ rs.getFloat("paq_descuento"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }
    
    public Map<String, Paquete> getPaquetesDeEspectaculo(String espectaculoNombre) {
        Map<String, Paquete> resultado = new HashMap<>();
        try {
            PreparedStatement status = conexion.prepareStatement("SELECT * FROM paquetes, paquete_espetaculos WHERE paquetes.paq_id=paquete_espetaculos.paqespec_paq_id AND paquete_espetaculos.paqespec_espec_id IN (select espetaculos.espec_id from espetaculos where espetaculos.espec_nombre=?)");
            status.setString(1, espectaculoNombre);
            ResultSet rs = status.executeQuery();
            while (rs.next()) {
                dateToDTFecha(rs.getDate("paq_fecha_inicio"));
                resultado.put(rs.getString("paq_nombre"), new Paquete(rs.getString("paq_nombre"), rs.getString("paq_descripcion"), dateToDTFecha(rs.getDate("paq_fecha_inicio")), dateToDTFecha(rs.getDate("paq_fecha_fin")),rs.getFloat("paq_costo"), rs.getFloat("paq_descuento"), dateToDTFecha(rs.getDate("paq_fecha_compra")))); 
                //System.out.println("Nombre: "+ rs.getString("paq_nombre")+"Descripcion: "+ rs.getString("paq_descripcion")+"Costo: "+ rs.getFloat("paq_costo")+"Descuento: "+ rs.getFloat("paq_descuento"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }
    

    public boolean addPaquete(String nombre, String descripcion,DTFecha Finicio,DTFecha Ffinal, String costo, String descuento, DTFecha FCompra) {
        try {
            PreparedStatement status = conexion.prepareStatement("INSERT INTO paquetes (paq_nombre,paq_descripcion,paq_fecha_inicio,paq_fecha_fin,paq_costo,paq_descuento,paq_fecha_compra) VALUES (?,?,?,?,?,?,?)");
            status.setString (1, nombre);
            status.setString (2, descripcion);
            status.setString (3, Finicio.getAnio() + "-" +  Finicio.getMes() + "-" + Finicio.getDia());
            status.setString (4, Ffinal.getAnio() + "-" +  Ffinal.getMes() + "-" + Ffinal.getDia());
            status.setString (5, costo);
            status.setString (6, descuento);
            status.setString (7, FCompra.getAnio() + "-" +  FCompra.getMes() + "-" + FCompra.getDia());
            status.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    
}
