/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Servicios;

import Persistencia.ConexionDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import logica.Clases.Funcion;
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
            ResultSet rs = status.executeQuery("SELECT vp_nombre FROM valores_tipo");
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
    public Map<String, Funcion> getFunciones() {
        Map<String, Funcion> resultado = new HashMap<>();
        try {
            PreparedStatement status = conexion.prepareStatement("SELECT * FROM funciones");
            ResultSet rs = status.executeQuery();

            while (rs.next()) {
                //resultado.put(rs.getString("nombre"), new Usuario(rs.getString("nombre"), rs.getString("apellido")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return resultado;
    }

}
