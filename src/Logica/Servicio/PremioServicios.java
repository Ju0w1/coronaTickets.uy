package Logica.Servicio;

import Logica.Clases.Artista;
import Logica.Clases.Funcion;
import Logica.Clases.Premio;
import Logica.Clases.Usuario;
import Logica.Fabrica;
import Persistencia.ConexionDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author facun
 */
public class PremioServicios {
    private Connection conexion = new ConexionDB().getConexion();
    
    public PremioServicios() {
        
    }
    
    public int getIdEspectador(String nickEspectador) throws SQLException{
        int id=-1;
        PreparedStatement status = conexion.prepareStatement("SELECT usu_id FROM usuario WHERE usuario.usu_nick=?");
        status.setString(1, nickEspectador);
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
    
    public int getIdEspectaculo(String nomEspectaculo) throws SQLException{
        int id=-1;
        PreparedStatement status = conexion.prepareStatement("SELECT espec_id FROM espetaculos WHERE espetaculos.espec_nombre=?");
        status.setString(1, nomEspectaculo);
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
    
    public int getIdFuncion(String nomFuncion) throws SQLException{
        int id=-1;
        PreparedStatement status = conexion.prepareStatement("SELECT fun_id FROM funcion WHERE funcion.fun_nombre=?");
        status.setString(1, nomFuncion);
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
    
    public int getIdPremio(String nomFuncion) throws SQLException{
        int id=-1;
        
        PreparedStatement status = conexion.prepareStatement("SELECT id_premio FROM premios, funcion WHERE premios.id_espectaculo=funcion.fun_espec_id AND funcion.fun_nombre=?");
        status.setString(1, nomFuncion);
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
    
    public List<String> getEspectadoresFuncion(String nomFuncion){
        List<String> espectadores = new ArrayList<>();
        try {
            int idFuncion=getIdFuncion (nomFuncion);
            Statement status1 = conexion.createStatement();
            ResultSet rs1 = status1.executeQuery("SELECT usu_nick FROM usuario, usuario_funcion WHERE usuario.usu_id=usuario_funcion.usu_id AND usuario_funcion.funcion_id='"+idFuncion+"'");
            System.out.println("entró");
            if(rs1.next()){
                espectadores.add(rs1.getString(1));
                return espectadores;
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            if(ex.getErrorCode() == 1062 ){
                JFrame j = new JFrame();
                JOptionPane.showMessageDialog(j,"La funcion no existe");
                return null;
            }
        }
        return espectadores;
    }
    
    public boolean addPremio(String descripcion, String nomEspectaculo, int cantidad){
        try {
            Statement status1 = conexion.createStatement();
            ResultSet rs1 = status1.executeQuery("SELECT * FROM espetaculos WHERE espec_nombre='"+nomEspectaculo+"'");
            
            System.out.println("entró");
            if(rs1.next()){
                System.out.println("entró");
                //
                PreparedStatement status3 = conexion.prepareStatement("INSERT INTO premios (id_espectaculo,premio_descripcion,premio_cantidad) VALUES (?,?,?)");
                status3.setInt(1, rs1.getInt("espec_id"));
                status3.setString (2, descripcion);
                status3.setInt(3, cantidad);
                status3.execute();
                //
                return true;
            }else{
                System.out.println("No encontró el nombre de la funcion");
                return false;
            }
        } 
        catch (SQLException ex) {
            ex.printStackTrace();
            if(ex.getErrorCode() == 1062 ){
                JFrame j = new JFrame();
                JOptionPane.showMessageDialog(j,"No se pudo crear el premio");
                return false;
            }
            return false;
        }
    }
    
    public boolean premiarEspectador(String nomFuncion, String nickEspectador, Date fecha){
        try {
            Statement status1 = conexion.createStatement();
            ResultSet rs1 = status1.executeQuery("SELECT * FROM funcion WHERE fun_nombre='"+nomFuncion+"'");
            System.out.println("entró");
            //
            int idEspectador=getIdEspectador(nickEspectador);
            int idPremio=getIdPremio(nomFuncion);
            PreparedStatement status2 = conexion.prepareStatement("INSERT INTO premios_espectadores (id_prem_espec,id_espectador,id_funcion,premio_espec_fecha) VALUES (?,?,?,?)");
            status2.setInt(1, idPremio);
            status2.setInt(2, rs1.getInt("fun_id"));
            status2.setInt (3, idEspectador);
            status2.setDate (4, fecha);
            status2.execute();
            //
            return true;
        }
        catch (SQLException ex) {
            JFrame j = new JFrame();
            JOptionPane.showMessageDialog(j,"No se pudo premiar al espectador '"+nickEspectador+"' ");
            return false;
        }         
    }
    
    //Obtiene las funciones ya realizadas de un artista
    public List<String> getFuncionesArtistaRealizadas(String nickArtista, String nomEspectaculo){
        List<String> funciones = new ArrayList<>();
        
        try {
            int idArtista=getIdEspectador(nickArtista);
            int idEspectaculo=getIdEspectaculo(nomEspectaculo);
            
            PreparedStatement status1 = conexion.prepareStatement("SELECT funcion.fun_nombre FROM funcion, funcion_artista WHERE funcion.fun_id=funcion_artista.funart_art_id AND funcion_artista.funart_art_id=? AND funcion.fun_espec_id=?");
            status1.setInt(1, idArtista);
            status1.setInt(2, idEspectaculo);
            ResultSet rs = status1.executeQuery();
            
            long millis=System.currentTimeMillis();  //Sacp fecha actual
            Date fechaActual=new Date(millis); 
            
            if(rs.next()) { 
                if(rs.getDate("fun_fecha_inicio").compareTo(fechaActual) < 0){ //Comprueba que la fecha de la funcion sea anterior a la actual
                    funciones.add(rs.getString(1));
                }
            }
            return funciones;

        } catch (SQLException ex1) {
            ex1.printStackTrace();
            return null;
        }
    }
    
    public boolean premiosRealizados(String nomFuncion){
        try {
            int idFuncion=getIdFuncion (nomFuncion);
            Statement status1 = conexion.createStatement();
            ResultSet rs1 = status1.executeQuery("SELECT id_prem_espec FROM premios_espectadores WHERE premios_espectadores.id_funcion='"+idFuncion+"'");
            System.out.println("entró");
            if(rs1.next()) {
                return true;
            }
            else{
                return false;
            }
        } 
        catch(SQLException ex1){
            ex1.printStackTrace();
            return false;
        }
    }
    
    public int getCantidadPremios(String nomFuncion){
        int cantidad=-1;
        try {
            PreparedStatement status = conexion.prepareStatement("SELECT premio_cantidad FROM premios, funcion WHERE premios.id_espectaculo=funcion.fun_espec_id AND funcion.fun_nombre=?");
            status.setString(1, nomFuncion);
            ResultSet rs = status.executeQuery();
            System.out.println("entró");
            if (rs.next()) {
                cantidad = rs.getInt(1);
            }
            return cantidad;
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("No existe la funcion ingresada");
            return cantidad;
        }
    }
    
    public List<String> getEspectadoresPremiados(String nomFuncion){
        List<String> funciones = new ArrayList<>();
        
        try {
            int idFuncion=getIdFuncion(nomFuncion);
            
            PreparedStatement status1 = conexion.prepareStatement("SELECT usuario.usu_nick FROM usuario, premios_espectadores WHERE usuario.usu_id=premios_espectadores.id_espectador AND premios_espectadores.id_funcion=? ");
            status1.setInt(1, idFuncion);
            ResultSet rs = status1.executeQuery();
            
            if(rs.next()) { 
                funciones.add(rs.getString(1));
            }
            return funciones;

        } catch (SQLException ex1) {
            ex1.printStackTrace();
            return null;
        }
    }
    
    public List<Premio> getPremiosDeEspectador(String nick){
        List<Premio> premios = new ArrayList<>();
        int idUser = Fabrica.getInstance().getIControladorUsuario().getIdEspectadorPorNick(nick); // Obtenengo el Id del usuario
        try {
            PreparedStatement status1 = conexion.prepareStatement("SELECT premios_espectadores.*, premios.*, funcion.fun_nombre from premios_espectadores, usuario, premios, funcion WHERE funcion.fun_id=premios_espectadores.id_funcion AND premios_espectadores.id_espectador=usuario.usu_id AND premios.id_premio=premios_espectadores.premio_id AND usuario.usu_id= ?");
            status1.setInt(1, idUser);
            ResultSet rs = status1.executeQuery();
            while(rs.next()) {
                premios.add(new Premio(new Usuario(nick),rs.getString("premio_descripcion"),new Funcion(rs.getString("fun_nombre")), rs.getDate("fecha_sorteo")));
            }
            return premios;
        } catch (SQLException ex1) {
            ex1.printStackTrace();
            return null;
        }
    }
    
    
}
