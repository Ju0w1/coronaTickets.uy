/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.servicios;

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
import logica.Clases.Espectador;
import logica.Clases.Usuario;
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
            PreparedStatement status = conexion.prepareStatement("SELECT * FROM usuario");
            ResultSet rs = status.executeQuery();
            
            while (rs.next()) {
                resultado.put(rs.getString("usu_mail"), new Espectador(rs.getString("usu_nick"),rs.getString("usu_nombre"), rs.getString("usu_apellido"), rs.getString("usu_mail"), dateToDTFecha(rs.getDate("usu_nacimiento"))));
                
                //+e.getNacimiento().getDia()+"/"+e.getNacimiento().getMes()+"/"+e.getNacimiento().getAnio()
                //resultado.put(rs.getString("usu_nombre"), new Usuario(rs.getString("usu_nick"), rs.getString("usu_nombre"), rs.getString("usu_apellido"), rs.getString("usu_mail"), new DTFecha(1,1,1900)));
                System.out.println("Nombre: "+ rs.getString("usu_nombre"));
            }
            //Espectador e = (Espectador) resultado.get("pablopeculio@cras-dev.com");
            //System.out.println("Nombre: "+ rs.getString("usu_nombre")+", fechaNacimeinto: "+e.getNacimiento().getAnio()+"/"+e.getNacimiento().getMes()+"/"+e.getNacimiento().getDia());
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
    
    public boolean addArtista(String nickname, String nombre, String apellido, String email, DTFecha nacimiento, String descripcion, String biografia,String link) {
        String id;
        try {
            this.addUsuario(nickname, nombre, apellido, email, nacimiento);
            Statement status = conexion.createStatement();
            ResultSet rs = status.executeQuery("SELECT usu_id FROM usuario WHERE usu_nick='" + nickname+"'");
            rs.next();
            id = rs.getString(1);
            //System.out.println("asddasdasdasd" + id);
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
