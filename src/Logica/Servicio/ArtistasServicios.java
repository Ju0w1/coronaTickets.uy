
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
}
