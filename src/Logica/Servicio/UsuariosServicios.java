/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Servicio;

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
    
    public Usuario getUser(String user) throws SQLException {
        try {
            Usuario resultado = new Usuario();
            PreparedStatement status = conexion.prepareStatement("SELECT * FROM usuario");
            ResultSet rs = status.executeQuery();
            while (rs.next()) {
                String nick = rs.getString("usu_nick");
                String mail = rs.getString("usu_mail");
                String nombre = rs.getString("usu_nombre");
                String apellido = rs.getString("usu_apellido");
                String password = rs.getString("usu_contrasenia");
                if (mail.equals(user) || nick.equals(user)) {
                    resultado = new Usuario(nick, nombre, apellido, mail, password);
                }
                //String nickname, String nombre, String apellido, String email, String contrasenia
            }
            rs.close();
            return resultado;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
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
    
    public boolean addUsuario(String nickname, String password1, String email, String nombre, String apellido, String nacimiento, String imagen) {
        try {
            PreparedStatement status = conexion.prepareStatement("INSERT INTO usuario (usu_nick,usu_nombre,usu_apellido,usu_mail,usu_nacimiento, usu_contrasenia, usu_imagen) VALUES (?,?,?,?,?,SHA2(?, 256),?)");
            status.setString (1, nickname);
            status.setString (2, nombre);
            status.setString (3, apellido);
            status.setString (4, email);
            status.setString (5, nacimiento);
            status.setString (6, password1);
            status.setString (7, imagen);
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
    
    public Map<String, Usuario> getAllUsers() throws SQLException {
        try {
            Map<String, Usuario> resultado = new HashMap<>();
            PreparedStatement status = conexion.prepareStatement("SELECT * FROM usuario");
            ResultSet rs = status.executeQuery();
            while (rs.next()) {
                String nick = rs.getString("usu_nick");
                String mail = rs.getString("usu_mail");
                String nombre = rs.getString("usu_nombre");
                String apellido = rs.getString("usu_apellido");
                DTFecha nacimineto = dateToDTFecha(rs.getDate("usu_nacimiento"));
                String password = rs.getString("usu_contrasenia");
                String imagen = rs.getString("usu_imagen");
                int seguidores=this.getSeguidores(rs.getInt("usu_id"));
                int seguidos=this.getSiguiendo(rs.getInt("usu_id"));
                
                resultado.put(nick, new Usuario(nick, nombre, apellido, mail, nacimineto, password, imagen, seguidores, seguidos));

                //String nickname, String nombre, String apellido, String email, String contrasenia
            }
            rs.close();
            return resultado;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
     public int getSeguidores(int usuId){ //Se obtiene la cantidad de seguidores de un Usuario
        int seguidores=0;
        try {
            PreparedStatement status = conexion.prepareStatement("SELECT COUNT(seguidores.usu_id) as seguidores FROM seguidores WHERE seguidores.usu_id=?");
            status.setInt(1, usuId);
            ResultSet rs = status.executeQuery();
            
            if(rs.next()) {
                seguidores=rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return seguidores;
    }
    public int getSiguiendo(int usuId){ //Se obtiene la cantidad de siguiendo de un Usuario
        int seguidores=0;
        try {
            PreparedStatement status = conexion.prepareStatement("SELECT COUNT(seguidores.usu_seguidor) as siguiendo FROM seguidores WHERE seguidores.usu_seguidor=?");
            status.setInt(1, usuId);
            ResultSet rs = status.executeQuery();
            
            if(rs.next()) {
                seguidores=rs.getInt(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return seguidores;
    }
    public Usuario getUser(int usuId) throws SQLException { //Se obtiene TODA la información específica de un usuario (Incluye cantidad de seguidores y seguidos)
        try {
            Usuario resultado = null;
            PreparedStatement status = conexion.prepareStatement("SELECT * FROM usuario WHERE usuario.usu_id=?");
            status.setInt(1, usuId);
            ResultSet rs = status.executeQuery();
            if (rs.next()) {
                String nick = rs.getString("usu_nick");
                String mail = rs.getString("usu_mail");
                String nombre = rs.getString("usu_nombre");
                String apellido = rs.getString("usu_apellido");
                DTFecha nacimineto = dateToDTFecha(rs.getDate("usu_nacimiento"));
                String password = rs.getString("usu_contrasenia");
                String imagen = rs.getString("usu_imagen");
                int seguidores=this.getSeguidores(rs.getInt("usu_id"));
                int seguidos=this.getSiguiendo(rs.getInt("usu_id"));
                
                resultado= new Usuario(nick, nombre, apellido, mail, nacimineto, password, imagen, seguidores, seguidos);
            }
            rs.close();
            return resultado;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public boolean verificarPassword(String userNick, String userPass) {
        try {
            Usuario resultado = null;
            PreparedStatement status = conexion.prepareStatement("select usu_nick from usuario where usu_nick=? and usu_contrasenia=SHA2(?, 256) OR usu_mail=? and usu_contrasenia=SHA2(?, 256)");
            status.setString(1, userNick);
            status.setString(2, userPass);
            status.setString(3, userNick);
            status.setString(4, userPass);
            ResultSet rs = status.executeQuery();
            if (rs.next()) {
                if (rs.getString("usu_nick").equalsIgnoreCase(userNick)) {
                    rs.close();
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public String checkearTipoUsuario(String nickname){
        String tipo = "";
        try {
            PreparedStatement status = conexion.prepareStatement("SELECT usuario.usu_nick FROM usuario WHERE usuario.usu_nick=? AND usuario.usu_id IN(SELECT artistas.art_usu FROM artistas)");
            status.setString(1, nickname);
            ResultSet rs = status.executeQuery();
            if(rs.next()){
                String nick = rs.getString("usu_nick");
                if(nick.equals(nickname)){
                    tipo = "artista";
                }    
            }else{
                tipo = "espectador";
            }  
            return tipo;
        } catch (SQLException ex) {
            ex.printStackTrace();
            tipo = "error";
            return tipo;
        }
        
    }
    public Usuario getUserPorNick(String nickUsuario) throws SQLException { //Se obtiene TODA la información específica de un usuario
        Usuario resultado = null;
        PreparedStatement status = conexion.prepareStatement("SELECT * FROM usuario WHERE usuario.usu_nick=?");
        status.setString(1, nickUsuario);
        try {
            ResultSet rs = status.executeQuery();
            if (rs.next()) {
                String nick = rs.getString("usu_nick");
                String mail = rs.getString("usu_mail");
                String nombre = rs.getString("usu_nombre");
                String apellido = rs.getString("usu_apellido");
                DTFecha nacimineto = dateToDTFecha(rs.getDate("usu_nacimiento"));
                String password = rs.getString("usu_contrasenia");
                String imagen = rs.getString("usu_imagen");
                int seguidores=this.getSeguidores(rs.getInt("usu_id"));
                int seguidos=this.getSiguiendo(rs.getInt("usu_id"));
                
                resultado= new Usuario(nick, nombre, apellido, mail, nacimineto, password, imagen, seguidores, seguidos);
            }
            rs.close();
            return resultado;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public int getIdPorNick(String nick) throws SQLException{
        int id=-1;
        PreparedStatement status = conexion.prepareStatement("SELECT usu_id FROM usuario WHERE usuario.usu_nick=?");
        status.setString(1, nick);
        try {
            ResultSet rs = status.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return id;
    }
    
//    public int getIdporNickEspectador(String espectadorNick) throws SQLException {
//        int espectadorId=-1;
//        PreparedStatement status1 = conexion.prepareStatement("SELECT u.usu_id FROM usuario as u WHERE u.usu_nick=?");
//        status1.setString(1, espectadorNick);
//        try {
//            ResultSet rs = status1.executeQuery();
//            if (rs.next()) {
//                espectadorId=rs.getInt(1);
//            }
//        } catch (SQLException ex1) {
//            ex1.printStackTrace();
//            return -1;
//        }
//        return espectadorId;
//    }
    
    public void modificarEspectadorWeb(String usuNick,String usuMail, String usuNombre, String usuApelliedo, Date usuNacimiento, String usuImagen){
        try {
            PreparedStatement status = conexion.prepareStatement("update usuario set usuario.usu_nombre =?, usuario.usu_apellido=?, usuario.usu_nacimiento=?, usuario.usu_imagen=? where usuario.usu_nick=? OR usuario.usu_mail=?");
            status.setString(1, usuNombre);
            status.setString(2, usuApelliedo);
            status.setDate(3, usuNacimiento);
            status.setString(4, usuImagen);
            status.setString(5, usuNick);
            status.setString(6, usuMail);
            ResultSet rs = status.executeQuery();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
     public void modificarArtistaWeb(String usuNick,String usuMail, String usuNombre, String usuApelliedo, Date usuNacimiento, String usuImagen, String artDescripcion, String artBiografia, String artUrl){
        try {
            PreparedStatement status = conexion.prepareStatement("update usuario,artistas set usuario.usu_nombre =?, usuario.usu_apellido=?, usuario.usu_nacimiento=?, usuario.usu_imagen=?, artistas.art_biografia=?, artistas.art_descripcion=?, artistas.art_url=? where usuario.usu_nick=? AND usuario.usu_id=artistas.art_usu");
            status.setString(1, usuNombre);
            status.setString(2, usuApelliedo);
            status.setDate(3, usuNacimiento);
            status.setString(4, usuImagen);
            
            status.setString(5, artBiografia);
            status.setString(6, artDescripcion);
            status.setString(7, artUrl);
            
            status.setString(8, usuNick);
            ResultSet rs = status.executeQuery();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
     
     public boolean addArtista(String nickname, String descripcion, String biografia,String link) throws SQLException {
        int id = getIdPorNick(nickname);
        
        try {
            PreparedStatement status = conexion.prepareStatement("INSERT INTO artistas (art_usu, art_descripcion, art_biografia, art_url) VALUES (?,?,?,?)");
            status.setInt (1, id);
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
}
