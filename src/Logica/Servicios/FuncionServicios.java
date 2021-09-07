
package Logica.Servicios;

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
import Logica.Clases.Artista;
import Logica.Clases.Funcion;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FuncionServicios {

    public FuncionServicios() {
        this.servicioEspectaculo = new EspectaculosServicios();
    }
    private Connection conexion = new ConexionDB().getConexion();
    static Statement sentencia_;
    static ResultSet resultado_;
    private EspectaculosServicios servicioEspectaculo;
    
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
    
    public JComboBox llenarListaEspectaculo(String nombrePlataforma) {
        JComboBox aux = new JComboBox();
        try {
            Statement status2 = conexion.createStatement();
            ResultSet rs2 = status2.executeQuery("SELECT vp_id FROM valores_tipo WHERE tp_id = 1 AND vp_nombre = '"+nombrePlataforma+"'");
            int idPlataforma = 0; 
            if(rs2.next()){
                idPlataforma = rs2.getInt(1);
                System.out.println(idPlataforma);
            }
            
            Statement status = conexion.createStatement();
            ResultSet rs = status.executeQuery("SELECT espec_nombre FROM espetaculos WHERE espec_plataforma="+idPlataforma);
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
                PreparedStatement status = conexion.prepareStatement("INSERT INTO funcion_artista (funart_fun_id,funart_art_id,fun_nombre) VALUES (?,?,?)");

                status.setInt (1, prueba_id_funcion);
                status.setInt (2, prueba_id);
                status.setString (3, nombre_funcion);

                status.execute();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        
        }
    
    public void addFuncion(String nombreEspec, String nombre, DTFecha fecha_registro, DTTimeStamp hora_inicio, DTFecha fecha_comienzo, Map <String,Artista> artistas) {
        try {
            System.out.println(artistas.isEmpty());
            Statement status1 = conexion.createStatement();
            ResultSet rs = status1.executeQuery("SELECT espec_id FROM espetaculos WHERE espec_nombre='"+nombreEspec+"'");
            System.out.println("entró");
            if(rs.next()){
                System.out.println("entró");
                PreparedStatement status2 = conexion.prepareStatement("INSERT INTO funcion (fun_espec_id,fun_nombre,fun_fecha_registro,fun_hora_inicio,fun_fecha_inicio) VALUES (?,?,?,?,?)");
                status2.setInt(1, rs.getInt(1));
                status2.setString (2, nombre);
                status2.setString (3, fecha_registro.getAnio() + "-" +  fecha_registro.getMes() + "-" + fecha_registro.getDia());
                status2.setString (4, hora_inicio.getHora() + ":" +  hora_inicio.getMinuto()+":"+ hora_inicio.getSegundo());
                status2.setString (5, fecha_comienzo.getAnio() + "-" +  fecha_comienzo.getMes() + "-" + fecha_comienzo.getDia());
                status2.execute();
                
                String idFuncion = this.servicioEspectaculo.getIdFuncion(nombre);
                
                for(Map.Entry<String, Artista> entry : artistas.entrySet()){
                    try {
                        Statement statusID = conexion.createStatement();
                        ResultSet rsID = statusID.executeQuery("SELECT A.art_id FROM usuario as U, artistas as A WHERE U.usu_id=A.art_usu AND U.usu_nick='"+entry.getKey()+"'");
                        int artID = 0;
                        if(rsID.next()){
                            artID=rs.getInt(1);
                        }
                        
                        PreparedStatement status3 = conexion.prepareStatement("INSERT INTO funcion_artista (funart_fun_id,funart_art_id) VALUES (?,?)");
                        status3.setInt (1, Integer.parseInt(idFuncion));
                        status3.setInt (2, artID);
                        //status3.setString (3, nombre_funcion);
                        status3.execute();
                        
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }else{
                System.out.println("No encontró el nombre de espectáculo");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            if(ex.getErrorCode() == 1062 ){
                JFrame j = new JFrame();
                JOptionPane.showMessageDialog(j,"La plataforma '"+nombre+"' ya existe en la base de datos");
            }
        }
        
    }
    
   public Artista getArtista(String nickname){
       Artista a = null;
       try {
            Statement status = conexion.createStatement();
            ResultSet rs = status.executeQuery("SELECT U.*, A.art_descripcion,A.art_biografia,A.art_url FROM usuario as U, artistas as A WHERE U.usu_id=A.art_usu AND U.usu_nick ='"+nickname+"'");
            
            if(rs.next()) {
                a = new Artista(nickname, rs.getString("usu_nombre"), rs.getString("usu_apellido"), rs.getString("usu_mail"), dateToDTFecha(rs.getDate("usu_nacimiento")), rs.getString("art_descripcion"), rs.getString("art_biografia"), rs.getString("art_url"));
                //String nickname, String nombre, String apellido, String email, DTFecha nacimiento, String descripcion, String biografia, String linkWeb
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       return a;
   }
   
   public void actualizarEstadoDeCanjeRegistro (String idFuncion1, String idFuncion2, String idFuncion3, String idEspectador){
        try {
            PreparedStatement ps = conexion.prepareStatement("UPDATE usuario_funcion SET usuario_funcion.canjeado = 1 WHERE usuario_funcion.usu_id=? AND usuario_funcion.funcion_id=?");
            ps.setString (1, idEspectador);
            ps.setString (2, idFuncion1);
            ps.execute();
            ps.close();
            PreparedStatement ps2 = conexion.prepareStatement("UPDATE usuario_funcion SET usuario_funcion.canjeado = 1 WHERE usuario_funcion.usu_id=? AND usuario_funcion.funcion_id=?");
            ps2.setString (1, idEspectador);
            ps2.setString (2, idFuncion2);
            ps2.execute();
            ps2.close();
            PreparedStatement ps3 = conexion.prepareStatement("UPDATE usuario_funcion SET usuario_funcion.canjeado = 1 WHERE usuario_funcion.usu_id=? AND usuario_funcion.funcion_id=?");
            ps3.setString (1, idEspectador);
            ps3.setString (2, idFuncion3);
            ps3.execute();
            ps3.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
