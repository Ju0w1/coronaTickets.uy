package Logica.Servicio;

import Logica.Clases.Artista;
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
        PreparedStatement status = conexion.prepareStatement("SELECT espec_id FROM espetaculos WHERE espec_id.espec_nombre=?");
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
    
    public boolean addPremio(String descripcion, String nomfuncion, int cantidad){
        try {
            Statement status1 = conexion.createStatement();
            ResultSet rs1 = status1.executeQuery("SELECT * FROM funcion WHERE fun_nombre='"+nomfuncion+"'");
            
            System.out.println("entró");
            if(rs1.next()){
                System.out.println("entró");
                //
                PreparedStatement status3 = conexion.prepareStatement("INSERT INTO premios (id_espectaculo,premio_descripcion,premio_cantidad) VALUES (?,?,?)");
                status3.setInt(1, rs1.getInt("fun_espec_id"));
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
            PreparedStatement status2 = conexion.prepareStatement("INSERT INTO premios_espectadores (id_espectador,id_funcion,premio_espec_fecha) VALUES (?,?,?)");
            status2.setInt(1, rs1.getInt("fun_id"));
            status2.setInt (2, idEspectador);
            status2.setDate (3, fecha);
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
    
    
    
}
