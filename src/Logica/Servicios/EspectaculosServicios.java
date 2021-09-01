/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Servicios;

import Logica.Clases.Espectaculo;
import Logica.DataTypes.DTTimeStamp;
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
import Logica.Clases.Artista;
import Logica.Clases.Funcion;
import Logica.Clases.Usuario;
import javax.swing.JTable;

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

    public JComboBox llenarComboBoxPlataformas() {
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
    
    public JComboBox llenarComboBoxEspectaculo() {
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
    
    public Map<String, Artista> getMapArtistas(String funcionId) {
        Map<String, Artista> artistas= new HashMap<>();
        String query1="SELECT * FROM artistas AS a, funcion_artista AS funart WHERE a.art_id=funart.funart_art_id AND funart.funart_fun_id="+funcionId;
        try {
            Statement status1 = conexion.createStatement();
            ResultSet rs1 = status1.executeQuery(query1);
            try {
                while (rs1.next()) {
                    String query2="SELECT * FROM usuario AS u WHERE u.usu_id="+rs1.getString("art_id");
                    Statement status2= conexion.createStatement();
                    ResultSet rs2= status2.executeQuery(query2);
                    artistas.put(rs1.getString("art_id)"), new Artista(rs2.getString("usu_nick"), rs2.getString("usu_nombre"), rs2.getString("usu_apellido"), rs2.getString("usu_mail"), rs2.getDate("usu_nacimiento"), rs1.getString("art_descripcion"), rs1.getString("art_biografia"), rs1.getString("art_url")));
                }
            }catch(SQLException ex2){
                ex2.printStackTrace();
            }
        } catch (SQLException ex1) {
            ex1.printStackTrace();
        }
        return artistas;
    }
    
    //No se si hacer un conversor o cambiar a float la duracion
    public Espectaculo getEspecaculo(String funcionId){
        Espectaculo rslt;
        double auxT=0;
        Date auxD= new Date(1234, 12, 8);
        try {
            PreparedStatement status = conexion.prepareStatement("SELECT * FROM espectaculos AS e AND funcion AS f WHERE e.espec_id=f.fun_espec_id AND f.fun_id="+funcionId);
            ResultSet rs = status.executeQuery();
            rslt= new Espectaculo(rs.getString("espec_nombre"), rs.getString("espec_artista"), rs.getString("espec_descripcion"), rs.getInt("espec_cant_min_espect"), rs.getInt("espec_cant_max_espect"), rs.getString("espec_url"), rs.getInt("espec_costo"), rs.getDouble("espec_duracion"), rs.getDate("espec_fecha_registro"));
            return rslt;
        }catch (SQLException ex){
            ex.printStackTrace();
            return new Espectaculo("error", "error", "error", 0, 0, "error", 0, auxT, auxD);
        }
    }
    
    public Map<String, Funcion> getMapFunciones(String espectaculoId) {
        Map<String, Funcion> resultado = new HashMap<>();
        Map<String, Artista> artistas;
        Espectaculo espectaculo;
        try {
            PreparedStatement status1 = conexion.prepareStatement("SELECT * FROM funcion AS f WHERE f.fun_espec_id="+espectaculoId);
            ResultSet rs1 = status1.executeQuery();
            while (rs1.next()) {
                artistas=getMapArtistas(rs1.getString("fun_id"));
                espectaculo=getEspecaculo(rs1.getString("fun_id"));
                resultado.put(rs1.getString("fun_nombre"), new Funcion(rs1.getString("fun_nombre"), rs1.getDate("fun_fecha"), rs1.getTime("fun_hora"),rs1.getDate("fun_fecha_registro"), espectaculo, artistas));
            }
        } catch (SQLException ex1) {
            ex1.printStackTrace();
        }
        return resultado;
    }
    
}
