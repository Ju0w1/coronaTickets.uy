/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Servicios;

import Logica.Clases.Espectaculo;
import Logica.Clases.Plataforma;
import Logica.Clases.Espectaculo; //NUEVO
import Logica.Clases.Plataforma; // NUEVO
import Logica.DataTypes.DTFecha; //NUEVO
import Persistencia.ConexionDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat; //NUEVO
import java.text.SimpleDateFormat; //NUEVO
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import Logica.Clases.Artista;
import Logica.Clases.Funcion;
import Logica.DataTypes.DTFecha;
import Logica.Clases.Paquete; //NUEVO
import Logica.Clases.Registro;
import Logica.Clases.Usuario;

/**
 *
 * @author Admin
 */
public class EspectaculosServicios {

    public EspectaculosServicios() {
    }
    private Connection conexion = new ConexionDB().getConexion();

    public Map<String, Espectaculo> getEspectaculos() {
        Map<String, Espectaculo> resultado = new HashMap<>();
        try {
            PreparedStatement status = conexion.prepareStatement("SELECT * FROM espetaculos");
            ResultSet rs = status.executeQuery();
            while (rs.next()) {
                resultado.put(rs.getString("espec_nombre"), new Espectaculo(rs.getString("espec_nombre"), rs.getInt("espec_artista"), rs.getString("espec_descripcion"), rs.getInt("espec_cant_min_espect"), rs.getInt("espec_cant_max_espect"), rs.getString("espec_URL"), rs.getDouble("espec_Costo") , rs.getInt("espec_duracion"), rs.getDate("espec_fecha_registro")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return resultado;
    }
    
    public Map<String, Espectaculo> getEspectaculosSegunPlataforma(String nombrePlataforma) {
        Map<String, Espectaculo> resultado = new HashMap<>();
        //String nombre,int Artista,String descr,int min,int max, String url, double costo,int duracion,String Fregistro)
        try {
            PreparedStatement status = conexion.prepareStatement("SELECT * FROM espetaculos WHERE espetaculos.espec_plataforma in (SELECT valores_tipo.vp_id from valores_tipo WHERE valores_tipo.vp_nombre=?)");
            status.setString(1, nombrePlataforma);
            ResultSet rs = status.executeQuery();
            while (rs.next()) {
                resultado.put(rs.getString("espec_nombre"), new Espectaculo(rs.getString("espec_nombre"), rs.getInt("espec_artista"), rs.getString("espec_descripcion"), rs.getInt("espec_cant_min_espect"), rs.getInt("espec_cant_max_espect"), rs.getString("espec_URL"), rs.getDouble("espec_Costo") , rs.getInt("espec_duracion"), rs.getDate("espec_fecha_registro")));
                System.out.println("Nombre: " + rs.getString("espec_nombre"));
                System.out.println("Artista: " + rs.getInt("espec_artista"));
                System.out.println("Descripcion: " + rs.getString("espec_descripcion"));
                System.out.println("Min: " + rs.getInt("espec_cant_min_espect"));
                System.out.println("Min: " + rs.getInt("espec_cant_max_espect"));
                System.out.println("URL: " + rs.getString("espec_URL"));
                System.out.println("Costo: " + rs.getDouble("espec_Costo"));
                System.out.println("Duracion: " + rs.getInt("espec_duracion"));
                System.out.println("Fecha: " + rs.getDate("espec_fecha_registro"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return resultado;
    }
    
    

    public Map<String, Plataforma> getPlataformas() {
        Map<String, Plataforma> resultado = new HashMap<>();
        try {
            PreparedStatement status = conexion.prepareStatement("SELECT * FROM valores_tipo");
            ResultSet rs = status.executeQuery();
            while (rs.next()) {
                resultado.put(rs.getString("vp_nombre"), new Plataforma(rs.getString("vp_nombre"), rs.getString("vp_valor_1"), rs.getString("vp_valor_2")));
                System.out.println("Nombre Plataforma: " + rs.getString("vp_nombre"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return resultado;
    }
    
    public boolean addPlataforma(String nombre, String url, String descripcion){
        String id;
        try { // Busco el id del "tipo" con nombre "Plataforma" en la base y si no existe la creo
            PreparedStatement status = conexion.prepareStatement("SELECT * FROM tipo WHERE tp_nombre = 'Plataforma'");
            ResultSet rs = status.executeQuery();
            if (rs.next()){
                id = rs.getString(1);
                //System.out.println("1.ID de Plataforma: " + id);
            } else {
                status = conexion.prepareStatement("INSERT INTO tipo (tp_id, tp_nombre) VALUES (DEFAULT,'Plataforma')");
                status.execute();
                rs = status.executeQuery("SELECT tp_id FROM tipo WHERE tp_nombre = 'Plataforma'");
                rs.next();
                id = rs.getString(1);
                //System.out.println("2.ID de Plataforma: " + id);
            }
            //return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        int intID = Integer.parseInt(id);
        try { // Creo la plataforma en "Valores_tipo" una vez ya obtenido el ID
            PreparedStatement status = conexion.prepareStatement("INSERT INTO valores_tipo (tp_id, vp_id, vp_nombre, vp_valor_1, vp_valor_2, vp_vigente) VALUES (?,DEFAULT,?,?,?, NULL)");
            status.setInt(1, intID);
            status.setString(2, nombre);
            status.setString(3, url);
            status.setString(4, descripcion);
            status.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public boolean checkPlataforma(String nombre){
        try {
            PreparedStatement status = conexion.prepareStatement("SELECT * FROM valores_tipo WHERE vp_nombre=?");
            status.setString(1, nombre);
            ResultSet rs = status.executeQuery();
            if (rs.next()){
                return true;
            }// existe la plataforma
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false; // No existe la plataforma
        }
        return false;
    }
    
    public void addEspectaculo(String nombrePlataforma, String nombreOrganizador, String nombreEspectaculo, String descripcion, Double duracion, int cantEspectadoresMinima, int cantEspectadoresMaxima, String URL, Double Costo) {
        LocalDateTime now = LocalDateTime.now();
        Date today = new Date(now.getYear() - 1900, now.getMonthValue() - 1, now.getDayOfMonth());
        int id_plataforma = 1, id_usuario = 1;
        try { //PRIMERO OBTENGO EL ID DE LA PLATAFORMA SEGUN EL NOMBRE OBTENIDO POR PARAMETRO
            PreparedStatement status = conexion.prepareStatement("SELECT valores_tipo.vp_id FROM valores_tipo WHERE valores_tipo.vp_nombre=?");
            status.setString(1, nombrePlataforma);
            ResultSet rs = status.executeQuery();
            while (rs.next()) {
                id_plataforma = rs.getInt(1);
            } //SEGUNDO OBTENGO EL ID DEL ARTISTA SEGUN EL NICK DEL ARTISTA POR PARAMETRO
            PreparedStatement status2 = conexion.prepareStatement("SELECT artistas.art_id FROM artistas where artistas.art_usu IN(SELECT usuario.usu_id FROM usuario WHERE usuario.usu_nick=?)");
            status2.setString(1, nombreOrganizador);
            ResultSet rs2 = status2.executeQuery();
            
            if (rs2.next()) {
                id_usuario = rs2.getInt(1);
            } //TERCERO INSERTO EL NUEVO ESPECTACULO
            PreparedStatement status3 = conexion.prepareStatement("INSERT INTO espetaculos (espec_artista, espec_plataforma, espec_nombre, espec_descripcion, espec_duracion, espec_cant_min_espect, espec_cant_max_espect, espec_url, espec_fecha_registro, espec_costo) VALUES (?,?,?,?,?,?,?,?,?,?)");
            status3.setInt(1, id_usuario);
            status3.setInt(2, id_plataforma);
            status3.setString(3, nombreEspectaculo);
            status3.setString(4, descripcion);
            status3.setDouble(5, duracion);
            status3.setInt(6, cantEspectadoresMinima);
            status3.setInt(7, cantEspectadoresMaxima);
            status3.setString(8, URL);
            status3.setDate(9, today);
            status3.setDouble(10, Costo);
            System.out.println(status3.toString());
            status3.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public JComboBox llenarComboBoxPlataformas() {
        JComboBox aux = new JComboBox();
        try {
            Statement status = conexion.createStatement();
            ResultSet rs = status.executeQuery("SELECT vp_nombre FROM valores_tipo WHERE tp_id = 1");
            while (rs.next()) {
                aux.addItem(rs.getString(1));
            }
            return aux;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new JComboBox();
        }
    }
    
    

    public JList llenarListaArtistas() {
        DefaultListModel demoList = new DefaultListModel();
        try {
            Statement status = conexion.createStatement();
            ResultSet rs = status.executeQuery("SELECT usuario.usu_nick FROM usuario WHERE usuario.usu_id IN(SELECT u2.usu_id FROM usuario as u2,artistas WHERE artistas.art_usu=u2.usu_id)");
            while (rs.next()) {
                demoList.addElement(rs.getString(1));
            }
            JList listd = new JList(demoList);
            return listd;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new JList();
        }
    }

    public JList llenarListaArtistasPorNombre(String nombre) {
        DefaultListModel demoList = new DefaultListModel();
        try {
            if (nombre.equalsIgnoreCase("")) { //Si está vacío muestro todos los Artistas
                PreparedStatement status = conexion.prepareStatement("SELECT usuario.usu_nick FROM usuario WHERE usuario.usu_id IN(SELECT u2.usu_id FROM usuario as u2,artistas WHERE artistas.art_usu=u2.usu_id)"); //MUESTRO TODOS
                ResultSet rs = status.executeQuery();
                while (rs.next()) {
                    demoList.addElement(rs.getString(1));
                }
                JList listd = new JList(demoList);
                return listd;
            } else if (nombre.contains(" ") == false) { //Si solo ingreso nombre y no apellido 
                PreparedStatement status = conexion.prepareStatement("SELECT usuario.usu_nick FROM usuario WHERE usuario.usu_id IN(SELECT u2.usu_id FROM usuario as u2,artistas WHERE artistas.art_usu=u2.usu_id AND u2.usu_nombre LIKE ? OR u2.usu_apellido LIKE ?)");
                status.setString(1, nombre + "%");
                status.setString(2, nombre + "%");
                ResultSet rs = status.executeQuery();
                while (rs.next()) {
                    demoList.addElement(rs.getString(1));
                }
                JList listd = new JList(demoList);
                return listd;
            } else { //Ingresó nombre y apellido (Hay un espacio)
                String[] nombreCompleto = nombre.split(" ");
                String firstName = nombreCompleto[0];
                String lastName = null;
                if(nombreCompleto.length>1){
                    lastName = nombreCompleto[1];
                }
                PreparedStatement status = conexion.prepareStatement("SELECT usuario.usu_nick FROM usuario WHERE usuario.usu_id IN(SELECT u2.usu_id FROM usuario as u2,artistas WHERE artistas.art_usu=u2.usu_id AND u2.usu_nombre LIKE ? AND u2.usu_apellido LIKE ?)");
                status.setString(1, firstName + "%");
                status.setString(2, lastName + "%");
                ResultSet rs = status.executeQuery();
                while (rs.next()) {
                    demoList.addElement(rs.getString(1));
                }
                JList listd = new JList(demoList);
                return listd;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new JList();
        }
    }
    //NUEVO
    public DTFecha dateToDTFecha(Date fecha){
        if(fecha != null){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String fechaDB = dateFormat.format(fecha);
        String[] partes = fechaDB.split("-");
        return new DTFecha(Integer.parseInt(partes[2]),Integer.parseInt(partes[1]),Integer.parseInt(partes[0]));
        }
        else{
            return new DTFecha(0,0,0);
        }
    }
    
    public boolean verificarExistenciaNombreEspectaculo(String nombreEspectaculo) {
        String nombrePlataformaAux = null;
        try {
            PreparedStatement status = conexion.prepareStatement("SELECT espec_nombre FROM espetaculos WHERE espec_nombre=?");
            status.setString(1, nombreEspectaculo);
            ResultSet rs = status.executeQuery();
            while (rs.next()) {
                nombrePlataformaAux = rs.getString(1);
            }
            if(nombreEspectaculo.equalsIgnoreCase(nombrePlataformaAux)){
                return true;
            }
            else{
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    
    
      public Map<String, Funcion> getMapFuncionesEspectaculoNombre(String espectaculoNombre) {
        Map<String, Funcion> resultado = new HashMap<>();
        Map<String, Artista> artistas = new HashMap<>();
        Espectaculo espectaculo;
        try {
            PreparedStatement status1 = conexion.prepareStatement("SELECT * FROM funcion WHERE funcion.fun_espec_id in (SELECT espetaculos.espec_id FROM espetaculos WHERE espetaculos.espec_nombre= ? )");
            status1.setString(1, espectaculoNombre);
            ResultSet rs1 = status1.executeQuery();
            while (rs1.next()) {
                artistas=getMapArtistas(rs1.getString("fun_id"));
                espectaculo=getEspecaculo(rs1.getString("fun_id"));
                resultado.put(rs1.getString("fun_nombre"), new Funcion(rs1.getString("fun_nombre"), rs1.getDate("fun_fecha_inicio"), rs1.getTime("fun_hora_inicio"),rs1.getDate("fun_fecha_registro"), espectaculo, artistas));

            }
        } catch (SQLException ex1) {
            ex1.printStackTrace();
        }
        return resultado;
    }
      
    
      
      public Map<String, Artista> getMapArtistas(String funcionId) {
        Map<String, Artista> artistas= new HashMap<>();
        try {
            PreparedStatement status1 = conexion.prepareStatement("SELECT * FROM artistas AS a, funcion_artista AS funart WHERE a.art_id=funart.funart_art_id AND funart.funart_fun_id=?");
            status1.setString(1, funcionId);
            ResultSet rs1 = status1.executeQuery();
            try {
                while (rs1.next()) {
                    //System.out.println("ID ARTISTA: "+rs1.getString("art_id"));
                    PreparedStatement status2= conexion.prepareStatement("SELECT * FROM usuario AS u WHERE u.usu_id="+rs1.getString("art_id"));
                    ResultSet rs2= status2.executeQuery();
                    if(rs2.next()){
                        String fechaString = rs2.getDate("usu_nacimiento").toString(); 
                        String[] fechaParts = fechaString.split("-");
                        DTFecha auxFecha = new DTFecha(Integer.parseInt(fechaParts[2]),Integer.parseInt(fechaParts[1]),Integer.parseInt(fechaParts[0]));
                        artistas.put(rs1.getString("art_id)"), new Artista(rs2.getString("usu_nick"), rs2.getString("usu_nombre"), rs2.getString("usu_apellido"), rs2.getString("usu_mail"), auxFecha , rs1.getString("art_descripcion"), rs1.getString("art_biografia"), rs1.getString("art_url"))); 
                    }
                }
            }catch(SQLException ex2){
                ex2.printStackTrace();
            }
        } catch (SQLException ex1) {
            ex1.printStackTrace();
        }
        return artistas;
    }
      
    public Map<String, Espectaculo> getMapEspectaculoDePaquete(String paqueteId) {
        Map<String, Espectaculo> resultado = new HashMap<>();
        try {
            PreparedStatement status1 = conexion.prepareStatement("SELECT * FROM espetaculos WHERE espetaculos.espec_id IN (SELECT paquete_espetaculos.paqespec_espec_id FROM paquete_espetaculos,paquetes WHERE paquete_espetaculos.paqespec_paq_id=paquetes.paq_id AND paquetes.paq_nombre=?)");
            status1.setString(1, paqueteId);
            ResultSet rs = status1.executeQuery();
            while (rs.next()) {
                resultado.put(rs.getString("espec_nombre"), new Espectaculo(rs.getString("espec_nombre"), rs.getInt("espec_artista"), rs.getString("espec_descripcion"), rs.getInt("espec_cant_min_espect"), rs.getInt("espec_cant_max_espect"), rs.getString("espec_URL"), rs.getDouble("espec_Costo") , rs.getInt("espec_duracion"), rs.getDate("espec_fecha_registro")));
            }
        } catch (SQLException ex1) {
            ex1.printStackTrace();
        }
        return resultado;
    }
    // NUEVO
    public Map<String, Paquete> getPaquetes() {
        Map<String, Paquete> map = new HashMap<>();
        try {
            PreparedStatement status = conexion.prepareStatement("SELECT * FROM paquetes"); //SELECT paq_id, paq_nombre FROM paquetes
            ResultSet rs = status.executeQuery();
            
            
            
            if (rs.next()) {
                map.put(rs.getString("paq_id"), new Paquete(rs.getString("paq_nombre"),rs.getString("paq_descripcion"), dateToDTFecha(rs.getDate("paq_fecha_inicio")), dateToDTFecha(rs.getDate("paq_fecha_fin")), rs.getFloat("paq_costo"),rs.getFloat("paq_descuento"), dateToDTFecha(rs.getDate("paq_fecha_alta"))));
                //
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return map;

    }
    
    

    //NUEVO
    public String getidPaquete(String paq_seleccionado){
        String idpaquete = "";
        try {
            
            PreparedStatement status = conexion.prepareStatement("SELECT paq_id FROM paquetes WHERE paquetes.paq_nombre = '"+paq_seleccionado+"';"); 
            ResultSet rs = status.executeQuery();
            if (rs.next()) {
               // System.out.println(rs.getString(1));
                idpaquete = rs.getString(1);
            }            
        
            return idpaquete;
                        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
        
    }
    //NUEVO
     public String getidPlataforma(String plat_seleccionada){
        String idplataforma = "";
        try {
            
            PreparedStatement status = conexion.prepareStatement("SELECT vp_id FROM valores_tipo WHERE valores_tipo.vp_nombre = '"+plat_seleccionada+"';"); 
            ResultSet rs = status.executeQuery();
            if (rs.next()) {
               // System.out.println(rs.getString(1));
                idplataforma = rs.getString(1);
            }    
            return idplataforma;
                        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    //NUEVO
    public Map<String, String> getEspectaculosPP(String paq_seleccionado, String plat_seleccionada){
        
        Map<String, String> map = new HashMap<>();
        String idpaquete = getidPaquete(paq_seleccionado);
        String idplataforma = getidPlataforma(plat_seleccionada);
        try {
            
            PreparedStatement status = conexion.prepareStatement("SELECT espec_nombre FROM espetaculos WHERE espec_plataforma = "+ idplataforma +" AND espec_nombre NOT IN (SELECT E.espec_nombre FROM espetaculos E, paquete_espetaculos P WHERE E.espec_id = P.paqespec_espec_id AND P.paqespec_paq_id = "+ idpaquete +");"); 
            ResultSet rs = status.executeQuery();
            int i=0;
            while (rs.next()) {
                map.put(Integer.toString(i), rs.getString(1));
                i++;
                //
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return map;
    
    }
    //NUEVO
    public String getidEspectaculo(String espec_seleccionado){
        String idEspectaculo = "";
        try {
            
            PreparedStatement status = conexion.prepareStatement("SELECT espec_id FROM espetaculos WHERE espetaculos.espec_nombre = '"+espec_seleccionado+"';"); 
            ResultSet rs = status.executeQuery();
            if (rs.next()) {
               // System.out.println(rs.getString(1));
                idEspectaculo = rs.getString(1);
            }    
            return idEspectaculo;
                        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    //NUEVO
    public void addEspectaculoAPaquete(String espec_seleccionado, String paq_seleccionado){
        // pide el id de los sus respectivas filas dado el nombre en estas
       String idPaquete = getidPaquete(paq_seleccionado);
       String idEspectaculo = getidEspectaculo(espec_seleccionado);
       try {
           // inserta los datos
            PreparedStatement status3 = conexion.prepareStatement("INSERT INTO paquete_espetaculos (paqespec_paq_id, paqespec_espec_id) VALUES (?,?)");
            status3.setString(1, idPaquete);
            status3.setString(2, idEspectaculo);
            status3.execute();       
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
       
    
    }

      public Espectaculo getEspecaculo(String funcionId){
        try {
            PreparedStatement status = conexion.prepareStatement("SELECT * FROM espetaculos, funcion WHERE espetaculos.espec_id=funcion.fun_espec_id AND funcion.fun_id=?");
            status.setString(1, funcionId);
            ResultSet rs = status.executeQuery();
            while(rs.next()){
                Espectaculo rslt= new Espectaculo(rs.getString("espec_nombre"), rs.getInt("espec_artista"), rs.getString("espec_descripcion"), rs.getInt("espec_cant_min_espect"), rs.getInt("espec_cant_max_espect"), rs.getString("espec_URL"), rs.getDouble("espec_Costo") , rs.getInt("espec_duracion"), rs.getDate("espec_fecha_registro"));
                return rslt;
            }
        }catch (SQLException ex){
            ex.printStackTrace();

        }
        return new Espectaculo();
    }
      
     public String getIdEspectaculo (String espectaculoNom){
        String rslt="";
        try {
            PreparedStatement status1 = conexion.prepareStatement("SELECT espec_id FROM espetaculos AS e WHERE e.espec_nombre='"+espectaculoNom+"'");
            ResultSet rs1 = status1.executeQuery();
            if(rs1.next()){
                rslt=rs1.getString("espec_id");
            }
        } catch (SQLException ex1) {
            ex1.printStackTrace();
        }
        return rslt;
    }
     public Map<String, Funcion> getMapFunciones(int espectaculoId) {
        Map<String, Funcion> resultado = new HashMap<>();
        Map<String, Artista> artistas;
        Espectaculo espectaculo;
        try {
            
            PreparedStatement status1 = conexion.prepareStatement("SELECT * FROM funcion AS f WHERE f.fun_espec_id="+espectaculoId);
            ResultSet rs1 = status1.executeQuery();
            while (rs1.next()) {
                artistas=getMapArtistas(rs1.getString("fun_id"));
                espectaculo=getEspecaculo(rs1.getString("fun_id"));
                resultado.put(rs1.getString("fun_nombre"), new Funcion(rs1.getString("fun_nombre"), rs1.getDate("fun_fecha_inicio"), rs1.getTime("fun_hora_inicio"),rs1.getDate("fun_fecha_registro"), espectaculo, artistas));
            }
        } catch (SQLException ex1) {
            ex1.printStackTrace();
        }
        return resultado;
    }
     
     public String getIdFuncion (String nomFuncion){
        String rslt="";
        try {
            PreparedStatement status1 = conexion.prepareStatement("SELECT f.fun_id FROM funcion AS f WHERE f.fun_nombre='"+nomFuncion+"'");
            ResultSet rs1 = status1.executeQuery();
            if(rs1.next()){
                rslt=rs1.getString("fun_id");
            }
        } catch (SQLException ex1) {
            ex1.printStackTrace();
        }
        return rslt;
    }
     
    public String getIdUsuario (String nickUsuario){
        String rslt="";
        try {
            PreparedStatement status1 = conexion.prepareStatement("SELECT u.usu_id FROM usuario AS u WHERE u.usu_nick='"+nickUsuario+"'");
            ResultSet rs1 = status1.executeQuery();
            if(rs1.next()){
                rslt=rs1.getString("usu_id");
            }
        } catch (SQLException ex1) {
            ex1.printStackTrace();
        }
        return rslt;
    }
    
    public Map<String, Registro> registrosPrevios(String idEspectador){
        Map<String, Registro> resultado = new HashMap<>();
        try {
            PreparedStatement status1 = conexion.prepareStatement("SELECT * FROM usuario_funcion AS usfu WHERE usfu.usu_id='"+idEspectador+"'");
            ResultSet rs1 = status1.executeQuery();
            while (rs1.next()) {
                PreparedStatement status2 = conexion.prepareStatement("SELECT usu_nick FROM usuario AS u WHERE u.usu_id="+rs1.getInt("usu_id"));
                ResultSet rs2 = status2.executeQuery();
                if(rs2.next()){
                    System.out.println("Entra al primer if");
                    PreparedStatement status3 = conexion.prepareStatement("SELECT fun_nombre FROM funcion AS f WHERE f.fun_id="+rs1.getInt("funcion_id"));
                    ResultSet rs3 = status3.executeQuery();
                    if(rs3.next()){
                        System.out.println("Entra al segundo if");
                        resultado.put(rs1.getString("funcion_id"), new Registro(rs2.getString(1), rs3.getString(1), rs1.getDate("fechaRegistro"),rs1.getBoolean("canjeado")));
                    }
                }  
            }
        } catch (SQLException ex1) {
            ex1.printStackTrace();
        }
        return resultado;
    }
    
    public Boolean limiteSobrepasado(String idFuncion){
        //int i=0;
        Boolean rslt=false;
        try {
            //SELECT funcion_id,COUNT(funcion_id) FROM usuario_funcion where funcion_id = 1;
            
            PreparedStatement status1 = conexion.prepareStatement("SELECT funcion_id,COUNT(funcion_id) FROM usuario_funcion where funcion_id = '"+idFuncion+"'");
            ResultSet rs1 = status1.executeQuery();
            int cantidadRegistros = 0;
            if(rs1.next()){
                cantidadRegistros = rs1.getInt(2);
            }
            PreparedStatement status2 = conexion.prepareStatement("SELECT fun_espec_id FROM funcion WHERE funcion.fun_id='"+idFuncion+"'");
            ResultSet rs2 = status2.executeQuery();
            int idEspectaculo = 0;
            if(rs2.next()){
                idEspectaculo = rs2.getInt(1);
            }
            PreparedStatement status3 = conexion.prepareStatement("SELECT espec_cant_max_espect FROM espetaculos WHERE espetaculos.espec_id='"+idEspectaculo+"'");
            ResultSet rs3 = status3.executeQuery();
            int cantMax = 0;
            if(rs3.next()){
                cantMax = rs3.getInt(1);
            }
            
            if(cantidadRegistros < cantMax){
                rslt=false;
            }else{
                rslt=true;
            }
            
//            PreparedStatement status1 = conexion.prepareStatement("SELECT * FROM usuario_funcion AS usfu WHERE usfu.funcion_id='"+idFuncion+"'");
//            ResultSet rs1 = status1.executeQuery();
//            String idEspectaculo=rs1.getString("fun_espec_id");
//            while (rs1.next()) {
//                i++;
//            }
//            try {
//                PreparedStatement status2 = conexion.prepareStatement("SELECT espec_cant_max_espect FROM espectaculos AS e WHERE e.espec_id='"+idEspectaculo+"'");
//                ResultSet rs2 = status2.executeQuery();
//                int maxRegistros=rs2.getInt("espec_cant_max_espect");
//                if(i<maxRegistros){
//                    rslt=false;
//                }
//            }catch (SQLException ex1) {
//                ex1.printStackTrace();
//            }
        }catch (SQLException ex1) {
            ex1.printStackTrace();
        }
        //return rslt;
        return rslt;
    }
    
    public void registrarFuncion(String idFuncion, String idEspectador, Date fechaRegistro){
        try {
            PreparedStatement status = conexion.prepareStatement("INSERT INTO usuario_funcion (funcion_id,usu_id,fechaRegistro,canjeado) VALUES (?,?,?,?)");
            System.out.println("aaaaaaaaaaa"+idFuncion);
            System.out.println("aaaaaaaaaaa"+idEspectador);
            status.setInt (1, Integer.parseInt(idFuncion));
            status.setInt (2, Integer.parseInt(idEspectador));
            status.setDate(3, fechaRegistro);
            status.setBoolean(4, false);
            
            status.execute();  
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    

}
