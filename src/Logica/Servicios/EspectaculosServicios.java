/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Servicios;

import Logica.Clases.Espectaculo; //NUEVO
import Logica.Clases.Plataforma; // NUEVO
import Logica.DataTypes.DTFecha; //NUEVO
import Persistencia.ConexionDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat; //NUEVO
import java.text.SimpleDateFormat; //NUEVO
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import logica.Clases.Paquete; //NUEVO
import logica.Clases.Usuario;

/**
 *
 * @author Admin
 */
public class EspectaculosServicios {

    public EspectaculosServicios() {
    }
    private Connection conexion = new ConexionDB().getConexion();

    public Map<String, Usuario> getUsers() {
        Map<String, Usuario> resultado = new HashMap<>();
        try {
            PreparedStatement status = conexion.prepareStatement("SELECT * FROM usuario");
            ResultSet rs = status.executeQuery();

            while (rs.next()) {
                resultado.put(rs.getString("Nombre"), new Usuario(rs.getString("Nombre"), rs.getString("Apellido")));
                System.out.println("Nombre: " + rs.getString("Nombre"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return resultado;
    }

    public void addEspectaculo(String nombrePlataforma, String nombreOrganizador, String nombreEspectaculo, String descripcion, Double duracion, int cantEspectadoresMinima, int cantEspectadoresMaxima, String URL, Double Costo) {
        LocalDateTime now = LocalDateTime.now();
        Date today = new Date(now.getYear() - 1900, now.getMonthValue() - 1, now.getDayOfMonth());
        int id_plataforma = 1, id_usuario = 1;
        try { //PRIMERO OBTENGO EL ID DE LA PLATAFORMA SEGUN EL NOMBRE OBTENIDO POR PARAMETRO
            PreparedStatement status = conexion.prepareStatement("SELECT valores_tipo.vp_id FROM valores_tipo WHERE valores_tipo.vp_nombre=?");
            status.setString(1, nombrePlataforma);
            ResultSet rs = status.executeQuery();
            while (rs.next()) {
                id_plataforma = rs.getInt(1);
            } //SEGUNDO OBTENGO EL ID DEL ARTISTA SEGUN EL NICK DEL ARTISTA POR PARAMETRO
            PreparedStatement status2 = conexion.prepareStatement("SELECT usuario.usu_id FROM usuario WHERE usuario.usu_nick=?");
            status2.setString(1, nombreOrganizador);
            ResultSet rs2 = status2.executeQuery();
            while (rs2.next()) {
                id_usuario = rs2.getInt(1);
            } //TERCERO INSERTO EL NUEVO ESPECTACULO
            PreparedStatement status3 = conexion.prepareStatement("INSERT INTO espetaculos (espec_artista, espec_plataforma, espec_nombre, espec_descripcion, espec_duracion, espec_cant_min_espect, espec_cant_max_espect, espec_url, espec_fecha_registro, espec_costo) VALUES (?,?,?,?,?,?,?,?,?,?)");
            status3.setInt(1, id_usuario);
            status3.setInt(2, id_plataforma);
            status3.setString(3, nombreEspectaculo);
            status3.setString(4, descripcion);
            status3.setDouble(5, duracion);
            status3.setInt(6, cantEspectadoresMinima);
            status3.setInt(7, cantEspectadoresMaxima);
            status3.setString(8, URL);
            status3.setDate(9, today);
            status3.setDouble(10, Costo);
            status3.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public JComboBox llenarListaPlataformas() {
        JComboBox aux = new JComboBox();
        try {
            Statement status = conexion.createStatement();
            ResultSet rs = status.executeQuery("SELECT vp_nombre FROM valores_tipo WHERE tp_id = 1");
            while (rs.next()) {
                aux.addItem(rs.getString(1));
            }
            return aux;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new JComboBox();
        }
    }

    public JList llenarListaArtistas() {
        DefaultListModel demoList = new DefaultListModel();
        try {
            Statement status = conexion.createStatement();
            ResultSet rs = status.executeQuery("SELECT usuario.usu_nick FROM usuario WHERE usuario.usu_id IN(SELECT u2.usu_id FROM usuario as u2,artistas WHERE artistas.art_usu=u2.usu_id)");
            while (rs.next()) {
                demoList.addElement(rs.getString(1));
            }
            JList listd = new JList(demoList);
            return listd;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new JList();
        }
    }

    public JList llenarListaArtistasPorNombre(String nombre) {
        DefaultListModel demoList = new DefaultListModel();
        try {
            if (nombre.equalsIgnoreCase("")) { //Si está vacío muestro todos los Artistas
                PreparedStatement status = conexion.prepareStatement("SELECT usuario.usu_nick FROM usuario WHERE usuario.usu_id IN(SELECT u2.usu_id FROM usuario as u2,artistas WHERE artistas.art_usu=u2.usu_id)"); //MUESTRO TODOS
                ResultSet rs = status.executeQuery();
                while (rs.next()) {
                    demoList.addElement(rs.getString(1));
                }
                JList listd = new JList(demoList);
                return listd;
            } else if (nombre.contains(" ") == false) { //Si solo ingreso nombre y no apellido 
                PreparedStatement status = conexion.prepareStatement("SELECT usuario.usu_nick FROM usuario WHERE usuario.usu_id IN(SELECT u2.usu_id FROM usuario as u2,artistas WHERE artistas.art_usu=u2.usu_id AND u2.usu_nombre LIKE ? OR u2.usu_apellido LIKE ?)");
                status.setString(1, nombre + "%");
                status.setString(2, nombre + "%");
                ResultSet rs = status.executeQuery();
                while (rs.next()) {
                    demoList.addElement(rs.getString(1));
                }
                JList listd = new JList(demoList);
                return listd;
            } else { //Ingresó nombre y apellido (Hay un espacio)
                String[] nombreCompleto = nombre.split(" ");
                String firstName = nombreCompleto[0];
                String lastName = null;
                if(nombreCompleto.length>1){
                    lastName = nombreCompleto[1];
                }
                PreparedStatement status = conexion.prepareStatement("SELECT usuario.usu_nick FROM usuario WHERE usuario.usu_id IN(SELECT u2.usu_id FROM usuario as u2,artistas WHERE artistas.art_usu=u2.usu_id AND u2.usu_nombre LIKE ? AND u2.usu_apellido LIKE ?)");
                status.setString(1, firstName + "%");
                status.setString(2, lastName + "%");
                ResultSet rs = status.executeQuery();
                while (rs.next()) {
                    demoList.addElement(rs.getString(1));
                }
                JList listd = new JList(demoList);
                return listd;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new JList();
        }
    }
    //NUEVO
    public DTFecha dateToDTFecha(Date fecha){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fechaDB = dateFormat.format(fecha);
        String[] partes = fechaDB.split("-");
        return new DTFecha(Integer.parseInt(partes[2]),Integer.parseInt(partes[1]),Integer.parseInt(partes[0]));
    }
    
    public boolean verificarExistenciaNombreEspectaculo(String nombreEspectaculo) {
        String nombrePlataformaAux = null;
        try {
            PreparedStatement status = conexion.prepareStatement("SELECT espec_nombre FROM espetaculos WHERE espec_nombre=?");
            status.setString(1, nombreEspectaculo);
            ResultSet rs = status.executeQuery();
            while (rs.next()) {
                nombrePlataformaAux = rs.getString(1);
            }
            if(nombreEspectaculo.equalsIgnoreCase(nombrePlataformaAux)){
                return true;
            }
            else{
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    
    // NUEVO
    public Map<String, Paquete> getPaquetes() {
        Map<String, Paquete> map = new HashMap<>();
        try {
            PreparedStatement status = conexion.prepareStatement("SELECT * FROM paquetes"); //SELECT paq_id, paq_nombre FROM paquetes
            ResultSet rs = status.executeQuery();
            
            while (rs.next()) {
                map.put(rs.getString("paq_id"), new Paquete(rs.getString("paq_nombre"),rs.getString("paq_descripcion"), dateToDTFecha(rs.getDate("paq_fecha_inicio")), dateToDTFecha(rs.getDate("paq_fecha_fin")), rs.getFloat("paq_costo"),rs.getFloat("paq_descuento")));
                
                //
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return map;

    }
    
    
    // NUEVO
    public Map<String, Plataforma> getPlataformas(){
        Map<String, Plataforma> map = new HashMap<>();
        try {
            PreparedStatement status = conexion.prepareStatement("SELECT vp_id, vp_nombre, vp_valor_1, vp_valor_2 FROM valores_tipo"); 
            ResultSet rs = status.executeQuery();
            
            while (rs.next()) {
                map.put(rs.getString("vp_id"), new Plataforma(rs.getString("vp_nombre"),rs.getString("vp_valor_1"), rs.getString("vp_valor_2")));
                
                //
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return map;
    
    }
    //NUEVO
    public String getidPaquete(String paq_seleccionado){
        String idpaquete = "";
        try {
            
            PreparedStatement status = conexion.prepareStatement("SELECT paq_id FROM paquetes WHERE paquetes.paq_nombre = '"+paq_seleccionado+"';"); 
            ResultSet rs = status.executeQuery();
            if (rs.next()) {
               // System.out.println(rs.getString(1));
                idpaquete = rs.getString(1);
            }            
        
            return idpaquete;
                        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
        
    }
    //NUEVO
     public String getidPlataforma(String plat_seleccionada){
        String idplataforma = "";
        try {
            
            PreparedStatement status = conexion.prepareStatement("SELECT vp_id FROM valores_tipo WHERE valores_tipo.vp_nombre = '"+plat_seleccionada+"';"); 
            ResultSet rs = status.executeQuery();
            if (rs.next()) {
               // System.out.println(rs.getString(1));
                idplataforma = rs.getString(1);
            }    
            return idplataforma;
                        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    //NUEVO
    public Map<String, String> getEspectaculosPP(String paq_seleccionado, String plat_seleccionada){
        
        Map<String, String> map = new HashMap<>();
        String idpaquete = getidPaquete(paq_seleccionado);
        String idplataforma = getidPlataforma(plat_seleccionada);
        try {
            
            PreparedStatement status = conexion.prepareStatement("SELECT espec_nombre FROM espetaculos WHERE espec_plataforma = "+ idplataforma +" AND espec_nombre NOT IN (SELECT E.espec_nombre FROM espetaculos E, paquete_espetaculos P WHERE E.espec_id = P.paqespec_espec_id AND P.paqespec_paq_id = "+ idpaquete +");"); 
            ResultSet rs = status.executeQuery();
            int i=0;
            while (rs.next()) {
                map.put(Integer.toString(i), rs.getString(1));
                i++;
                //
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return map;
    
    }
    //NUEVO
    public String getidEspectaculo(String espec_seleccionado){
        String idEspectaculo = "";
        try {
            
            PreparedStatement status = conexion.prepareStatement("SELECT espec_id FROM espetaculos WHERE espetaculos.espec_nombre = '"+espec_seleccionado+"';"); 
            ResultSet rs = status.executeQuery();
            if (rs.next()) {
               // System.out.println(rs.getString(1));
                idEspectaculo = rs.getString(1);
            }    
            return idEspectaculo;
                        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    //NUEVO
    public void addEspectaculoAPaquete(String espec_seleccionado, String paq_seleccionado){
        // pide el id de los sus respectivas filas dado el nombre en estas
       String idPaquete = getidPaquete(paq_seleccionado);
       String idEspectaculo = getidEspectaculo(espec_seleccionado);
       try {
           // inserta los datos
            PreparedStatement status3 = conexion.prepareStatement("INSERT INTO paquete_espetaculos (paqespec_paq_id, paqespec_espec_id) VALUES (?,?)");
            status3.setString(1, idPaquete);
            status3.setString(2, idEspectaculo);
            status3.execute();       
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       
    
    }


}
