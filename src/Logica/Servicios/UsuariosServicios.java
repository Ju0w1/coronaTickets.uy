/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.servicios;

import Logica.DataTypes.DTFecha;
import Persistencia.ConexionDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import Logica.Clases.Artista;
import Logica.Clases.Espectador;
import Logica.Clases.Usuario;
/**
 *
 * @author LucasCiceri
 */
public class UsuariosServicios {

    public UsuariosServicios() {
    }
    private Connection conexion = new ConexionDB().getConexion();

    public DTFecha dateToDTFecha(Date fecha){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fechaDB = dateFormat.format(fecha);
        String[] partes = fechaDB.split("-");
        return new DTFecha(Integer.parseInt(partes[2]),Integer.parseInt(partes[1]),Integer.parseInt(partes[0]));
    }
    
    
    public Map<String, Usuario> getUsers() {
        Map<String, Usuario> resultado = new HashMap<>();
        try {
            PreparedStatement status = conexion.prepareStatement("SELECT * FROM usuario where usuario.usu_id NOT IN(SELECT artistas.art_usu FROM artistas)");
            ResultSet rs = status.executeQuery();
            
//            if(rs.){
//                System.out.println("Es el único");
//            }else{
//                
//            }
            while (rs.next()) {
                resultado.put(rs.getString("usu_mail"), new Espectador(rs.getString("usu_nick"),rs.getString("usu_nombre"), rs.getString("usu_apellido"), rs.getString("usu_mail"), dateToDTFecha(rs.getDate("usu_nacimiento"))));

                //+e.getNacimiento().getDia()+"/"+e.getNacimiento().getMes()+"/"+e.getNacimiento().getAnio()
                //resultado.put(rs.getString("usu_nombre"), new Usuario(rs.getString("usu_nick"), rs.getString("usu_nombre"), rs.getString("usu_apellido"), rs.getString("usu_mail"), new DTFecha(1,1,1900)));
            }
            
            //Espectador e = (Espectador) resultado.get("pablopeculio@cras-dev.com");
            //System.out.println("Nombre: "+ rs.getString("usu_nombre")+", fechaNacimeinto: "+e.getNacimiento().getAnio()+"/"+e.getNacimiento().getMes()+"/"+e.getNacimiento().getDia());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }
    
    public Map<String, Usuario> getUsersBuscador(String nick) {
        Map<String, Usuario> resultado = new HashMap<>();
        try {   //"SELECT * FROM usuario where usuario.usu_id NOT IN(SELECT artistas.art_usu FROM artistas) AND usuario.usu_nick LIKE '" + Tom + "%';"
            PreparedStatement status = conexion.prepareStatement("SELECT * FROM usuario where usuario.usu_id NOT IN(SELECT artistas.art_usu FROM artistas) AND usuario.usu_nick LIKE '" + nick + "%';");
            ResultSet rs = status.executeQuery();
            while (rs.next()) {
                resultado.put(rs.getString("usu_mail"), new Espectador(rs.getString("usu_nick"),rs.getString("usu_nombre"), rs.getString("usu_apellido"), rs.getString("usu_mail"), dateToDTFecha(rs.getDate("usu_nacimiento"))));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }
    
    
    
    public Map<String, Usuario> getArtistas() {
        Map<String, Usuario> resultado = new HashMap<>();
        try {
            PreparedStatement status = conexion.prepareStatement("SELECT * FROM usuario,artistas WHERE usuario.usu_id = artistas.art_usu;");
            ResultSet rs = status.executeQuery();
            
            while (rs.next()) {
                resultado.put(rs.getString("usu_mail"), new Artista(rs.getString("usu_nick"),rs.getString("usu_nombre"), rs.getString("usu_apellido"), rs.getString("usu_mail"), dateToDTFecha(rs.getDate("usu_nacimiento")), rs.getString("art_descripcion"), rs.getString("art_biografia"), rs.getString("art_url")));
                //String nickname, String nombre, String apellido, String email, DTFecha nacimiento, String descripcion, String biografia, String linkWeb
                //+e.getNacimiento().getDia()+"/"+e.getNacimiento().getMes()+"/"+e.getNacimiento().getAnio()
                //resultado.put(rs.getString("usu_nombre"), new Usuario(rs.getString("usu_nick"), rs.getString("usu_nombre"), rs.getString("usu_apellido"), rs.getString("usu_mail"), new DTFecha(1,1,1900)));
                //System.out.println("Nombre: "+ rs.getString("usu_nombre"));
            }
            //Espectador e = (Espectador) resultado.get("pablopeculio@cras-dev.com");
            //System.out.println("Nombre: "+ rs.getString("usu_nombre")+", fechaNacimeinto: "+e.getNacimiento().getAnio()+"/"+e.getNacimiento().getMes()+"/"+e.getNacimiento().getDia());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }
    
    public Map<String, Usuario> getArtistasBuscador(String nick) {
        Map<String, Usuario> resultado = new HashMap<>();
        try { // "SELECT * FROM usuario INNER JOIN artistas ON usuario.usu_id=artistas.art_usu WHERE usuario.usu_nick LIKE '" + nick+ "%';"
            PreparedStatement status = conexion.prepareStatement("SELECT * FROM usuario INNER JOIN artistas ON usuario.usu_id=artistas.art_usu WHERE usuario.usu_nick LIKE '" + nick+ "%';");
            ResultSet rs = status.executeQuery();
            
            while (rs.next()) {
                resultado.put(rs.getString("usu_mail"), new Artista(rs.getString("usu_nick"),rs.getString("usu_nombre"), rs.getString("usu_apellido"), rs.getString("usu_mail"), dateToDTFecha(rs.getDate("usu_nacimiento")), rs.getString("art_descripcion"), rs.getString("art_biografia"), rs.getString("art_url")));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }
    
    public boolean addUsuario(String nickname, String nombre, String apellido, String email, DTFecha nacimiento) {
        try {
            PreparedStatement status = conexion.prepareStatement("INSERT INTO usuario (usu_nick,usu_nombre,usu_apellido,usu_mail,usu_nacimiento) VALUES (?,?,?,?,?)");
            status.setString (1, nickname);
            status.setString (2, nombre);
            status.setString (3, apellido);
            status.setString (4, email);
            status.setString (5, nacimiento.getAnio() + "-" +  nacimiento.getMes() + "-" + nacimiento.getDia());
            status.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    public void modificarEspectador(String nombre, String apellido, DTFecha fecha, String email){
        try{
            PreparedStatement status = conexion.prepareStatement("UPDATE usuario SET usu_nombre = ?, usu_apellido= ?, usu_nacimiento = ? WHERE usu_mail = ?");
            status.setString(1, nombre);
            status.setString(2, apellido);
            status.setString (3, fecha.getAnio() + "-" +  fecha.getMes() + "-" + fecha.getDia());
            status.setString(4, email);
            status.execute();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public void modificarArtista(String nombre, String apellido, DTFecha fecha, String email, String descripcion, String biografia, String url){
        try{
            PreparedStatement status = conexion.prepareStatement("UPDATE usuario, artistas SET usuario.usu_nombre = ?, usuario.usu_apellido = ?, usu_nacimiento = ?, artistas.art_descripcion = ?, artistas.art_biografia = ?, artistas.art_url = ? WHERE usuario.usu_id = artistas.art_usu AND usuario.usu_mail = ?");
            status.setString(1, nombre);
            status.setString(2, apellido);
            status.setString(3, fecha.getAnio() + "-" +  fecha.getMes() + "-" + fecha.getDia());
            status.setString(4, descripcion);
            status.setString(5, biografia);
            status.setString(6, url);
            status.setString(7, email);
            status.execute();
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    public boolean addArtista(String nickname, String nombre, String apellido, String email, DTFecha nacimiento, String descripcion, String biografia,String link) {
        String id;
        try {
            this.addUsuario(nickname, nombre, apellido, email, nacimiento);
            Statement status = conexion.createStatement();
            ResultSet rs = status.executeQuery("SELECT usu_id FROM usuario WHERE usu_nick='" + nickname+"'");
            rs.next();
            id = rs.getString(1);
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        try {
            PreparedStatement status = conexion.prepareStatement("INSERT INTO artistas (art_usu, art_descripcion, art_biografia, art_url) VALUES (?,?,?,?)");
            status.setString (1, id);
            status.setString (2, descripcion);
            status.setString (3, biografia);
            status.setString (4, link);
            status.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean checkUsuario(String nick, String email) { // compruebo que no haya un espectador con ese nick
        String nickAux, emailAux;
        try {
            PreparedStatement status = conexion.prepareStatement("SELECT usu_nick FROM usuario WHERE usu_nick=?");
            status.setString(1, nick);
            ResultSet rs = status.executeQuery();
            while (rs.next()) {
                nickAux = rs.getString(1);
                if (nick.equals(nickAux))
                    return true; // Existe el usuario
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false; // No existe el usuario
        }
        
        try {
            PreparedStatement status = conexion.prepareStatement("SELECT usu_mail FROM usuario WHERE usu_mail=?");
            status.setString(1, email);
            ResultSet rs = status.executeQuery();
            while (rs.next()) {
                emailAux = rs.getString(1);
                if (emailAux.equals(email))
                    return true; // Existe el usuario
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false; // No existe el usuario
        }
        return false; // No existe el usuario
    }

}
