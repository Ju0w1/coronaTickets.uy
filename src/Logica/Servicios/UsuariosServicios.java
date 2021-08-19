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
    

    public boolean addEspectador(String nickname, String nombre, String apellido, String email, DTFecha nacimiento) {
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
}
