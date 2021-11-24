
package Logica.Servicio;

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
import Logica.Clases.Artista;
import Logica.Clases.Paquete;
import java.util.Set;


public class ArtistasServicios {

    public ArtistasServicios() {
    }
    private Connection conexion = new ConexionDB().getConexion();

    public DTFecha dateToDTFecha(Date fecha){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fechaDB = dateFormat.format(fecha);
        String[] partes = fechaDB.split("-");
        return new DTFecha(Integer.parseInt(partes[2]),Integer.parseInt(partes[1]),Integer.parseInt(partes[0]));
    }
    
    public Map<String, Artista> getArtista() {
        Map<String, Artista> resultado = new HashMap<>();
        try {
            PreparedStatement status = conexion.prepareStatement("SELECT * FROM artistas as a, usuario as U WHERE A.art_usu=U.usu_id");
            ResultSet rs = status.executeQuery();
            
            while (rs.next()) {
                
                resultado.put(rs.getString("U.usu_nick"),new Artista(rs.getString("U.usu_nick"),rs.getString("U.usu_nombre"),rs.getString("U.usu_apellido"),rs.getString("U.usu_mail"),dateToDTFecha(rs.getDate("U.usu_nacimiento")),rs.getString("A.art_descripcion"),rs.getString("A.art_biografia"),rs.getString("A.art_url")));   
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
    
    public Artista getArtista(int usuId) { //Se obtiene todo los datos de un artistas con sus respectivos segudiores y seguidos.
        Artista resultado = null;
        UsuariosServicios servicioUsuarios = new UsuariosServicios();
        try {
            PreparedStatement status = conexion.prepareStatement("SELECT * FROM artistas as a, usuario as U WHERE A.art_usu=U.usu_id AND U.usu_id=?");
            status.setInt(1, usuId);
            ResultSet rs = status.executeQuery();
            int seguidores=servicioUsuarios.getSeguidores(usuId);
            int seguidos=servicioUsuarios.getSiguiendo(usuId);
            
            if(rs.next()) {
                resultado=new Artista(rs.getString("U.usu_nick"),rs.getString("U.usu_nombre"),rs.getString("U.usu_apellido"),rs.getString("U.usu_mail"),dateToDTFecha(rs.getDate("U.usu_nacimiento")),rs.getString("A.art_descripcion"),rs.getString("A.art_biografia"),rs.getString("A.art_url"));   
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }
    
    public Artista getArtistaPorNick(String usuNick) { //Se obtiene todo los datos de un artistas(POR NICK) con sus respectivos segudiores y seguidos.
        Artista resultado = null;
        UsuariosServicios servicioUsuarios = new UsuariosServicios();
        try {
            PreparedStatement status = conexion.prepareStatement("SELECT * FROM artistas as a, usuario as U WHERE A.art_usu=U.usu_id AND U.usu_nick=?");
            status.setString(1, usuNick);
            ResultSet rs = status.executeQuery();
            if(rs.next()) {
                int seguidores=servicioUsuarios.getSeguidores(rs.getInt("U.usu_id"));
                int seguidos=servicioUsuarios.getSiguiendo(rs.getInt("U.usu_id"));
                resultado=new Artista(rs.getString("U.usu_nick"),rs.getString("U.usu_nombre"),rs.getString("U.usu_apellido"),rs.getString("U.usu_mail"),dateToDTFecha(rs.getDate("U.usu_nacimiento")),rs.getString("A.art_descripcion"),rs.getString("A.art_biografia"),rs.getString("A.art_url"), rs.getString("U.usu_contrasenia"), rs.getString("usu_imagen"), seguidores, seguidos);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return resultado;
    }
    
    public boolean checkearSorteo(String nickArtista, String nombreFuncion){
        int id = obtenerIdArtistaPorNick(nickArtista);
        int funcionId = obtenerIdfuncionPorNick(nombreFuncion);
        
        try {
            PreparedStatement status = conexion.prepareStatement("SELECT funcion.* FROM funcion, artistas, espetaculos WHERE espetaculos.espec_artista=artistas.art_id AND funcion.fun_espec_id=espetaculos.espec_id AND espetaculos.espec_artista=artistas.art_id AND artistas.art_id=? AND funcion.fun_id=?");
            status.setInt(1, id);
            status.setInt(2, funcionId);
            ResultSet rs = status.executeQuery();
            if(rs.next()) { // EL ARTISTA ES DEUNIO DE LA FUNCION
                PreparedStatement status2 = conexion.prepareStatement("SELECT * from funcion WHERE funcion.fun_fecha_inicio < now() AND funcion.fun_id=?");
                status2.setInt(1, rs.getInt("fun_id"));
                ResultSet rs2 = status2.executeQuery();
                if(rs2.next()) { // FUNCION YA SE REALIZO
                    PreparedStatement status3 = conexion.prepareStatement("SELECT * FROM funcion, premios_espectadores WHERE funcion.fun_id=premios_espectadores.id_funcion AND funcion.fun_id=?");
                    status3.setInt(1, rs.getInt("fun_id"));
                    ResultSet rs3 = status3.executeQuery();
                    if(rs3.next()) { // YA SE SORETO PREMIO EN ESTA FUNCION
                        return false;
                    } else { // SE CUMPLE TODO
                        return true;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public int obtenerIdArtistaPorNick(String nick){
        int id = -1;
        try {
            PreparedStatement status = conexion.prepareStatement("SELECT artistas.art_id FROM artistas, usuario WHERE usuario.usu_id=artistas.art_usu AND usuario.usu_nick=?");
            status.setString(1, nick);

            ResultSet rs = status.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return id;
    }
    public int obtenerIdfuncionPorNick(String funcion){
        int id = -1;
        try {
            PreparedStatement status = conexion.prepareStatement("SELECT funcion.fun_id FROM funcion WHERE funcion.fun_nombre=?");
            status.setString(1, funcion);
            ResultSet rs = status.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return id;
    }
    
    
    
    
    
}
