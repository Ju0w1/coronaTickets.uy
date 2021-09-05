
package logica.servicios;

import Logica.DataTypes.DTFecha;
import Logica.DataTypes.DTTimeStamp;
import Persistencia.ConexionDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JComboBox;
import logica.Clases.Artista;
import logica.Clases.Funcion;

public class FuncionServicios {

    public FuncionServicios() {
    }
    private Connection conexion = new ConexionDB().getConexion();
    static Statement sentencia_;
    static ResultSet resultado_;
    
    public DTFecha dateToDTFecha(Date fecha){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fechaDB = dateFormat.format(fecha);
        String[] partes = fechaDB.split("-");
        return new DTFecha(Integer.parseInt(partes[2]),Integer.parseInt(partes[1]),Integer.parseInt(partes[0]));
    }
    
//    public static ArrayList<String> llenar_combo() throws SQLException{
//        ArrayList<String> lista = new ArrayList<String>();
//        String q = "SELECT * FROM plataforma";
//        try{
//            
//            resultado_ = sentencia_.executeQuery(q);
//            System.out.println("plataformas encontradas");
//        }catch(Exception e){
//            System.out.println("plataformas no encontradas");
//        }
//        try{
//            while(resultado_.next()){
//                lista.add(resultado_.getString("plat_nombre"));
//            }
//        }catch(Exception e){
//            
//        }
//        return lista;
//    }
    
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
    
    public JComboBox llenarListaEspectaculo() {
        JComboBox aux = new JComboBox();
        try {
            Statement status = conexion.createStatement();
            ResultSet rs = status.executeQuery("SELECT espec_nombre FROM espectaculos");
            while (rs.next()) {
                aux.addItem(rs.getString(1));
            }
            return aux;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new JComboBox();
        }
    }
    
    public JComboBox llenarListaArtistas() {
        JComboBox aux = new JComboBox();
        try {
            Statement status = conexion.createStatement();
            ResultSet rs = status.executeQuery("SELECT U.usu_nick FROM usuario as U, artistas as A WHERE U.usu_id=A.art_usu");
            while (rs.next()) {
                aux.addItem(rs.getString(1));
            }
            return aux;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new JComboBox();
        }
    }
    
    public void AgregarArtista(String nick_artista, String id_funcion, String id_artista, String nombre_funcion, DTFecha funcion_vigente){
        int prueba_id_funcion=0,prueba_id=0;
        try{
            System.out.println(nick_artista);
            Statement status = conexion.createStatement();
            ResultSet rs = status.executeQuery("SELECT A.art_id FROM usuario as U, artistas as A WHERE U.usu_id=A.art_usu AND U.usu_nick='"+nick_artista+"'");
            rs.next();
            prueba_id=rs.getInt(1);
            //System.out.println("Art id: "+prueba_id);
            //System.out.println("Nick :"+prueba_nombre);
            
            ResultSet rs1 = status.executeQuery("SELECT fun_id FROM funcion WHERE fun_nombre='"+nombre_funcion+"'");
            rs1.next();
            prueba_id_funcion=rs1.getInt(1);
            System.out.println("ID: "+prueba_id_funcion);
            
            }catch(SQLException e){
                System.out.println("Error");
                e.printStackTrace();
            }
//-------------------------------------------------------------------------------
        try {
            PreparedStatement status = conexion.prepareStatement("INSERT INTO funcion_artista (funart_fun_id,funart_art_id,fun_nombre,funart_vigente) VALUES (?,?,?,?)");
            
            status.setInt (1, prueba_id_funcion);
            status.setInt (2, prueba_id);
            status.setString (3, nombre_funcion);
            status.setString (4, funcion_vigente.getAnio()+"-"+funcion_vigente.getMes()+"-"+funcion_vigente.getDia());
            status.execute();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        
        }
    
    public boolean addFuncion(String espec_id, String nombre, DTFecha fecha_registro, DTTimeStamp hora_inicio, DTFecha fecha_comienzo) {
        try {
            PreparedStatement status = conexion.prepareStatement("INSERT INTO funcion (fun_nombre,fun_fecha_registro,fun_hora_inicio,fun_fecha_comienzo) VALUES (?,?,?,?)");
            status.setString (1, nombre);
            status.setString (2, fecha_registro.getAnio() + "-" +  fecha_registro.getMes() + "-" + fecha_registro.getDia());
            status.setString (3, hora_inicio.getHora() + ":" +  hora_inicio.getMinuto());
            status.setString (4, fecha_comienzo.getAnio() + "-" +  fecha_comienzo.getMes() + "-" + fecha_comienzo.getDia());

            status.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
   
    
}
