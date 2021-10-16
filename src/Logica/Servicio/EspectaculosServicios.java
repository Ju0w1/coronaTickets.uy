/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Servicio;

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
import Logica.Clases.Categoria;
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

    //123 
    public boolean addCategoria(String nombre){
        try {
            PreparedStatement status = conexion.prepareStatement("INSERT INTO categorias (DEFAULT, cat_nombre) VALUES (?)");
            status.setString (1, nombre);
            status.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    //123
    public boolean checkCategoria(String nombre){
        try {
            PreparedStatement status = conexion.prepareStatement("SELECT * FROM categorias WHERE cat_nombre=?");
            status.setString(1, nombre);
            ResultSet rs = status.executeQuery();
            if (rs.next()){
                return true;
            }// existe la categoria
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false; // No existe la categoria
        }
        return false;
    }
    
    //123
     public Map<String, Categoria> getCategorias() {
        Map<String, Categoria> resultado = new HashMap<>();
        try {
            PreparedStatement status = conexion.prepareStatement("SELECT * FROM categorias");
            ResultSet rs = status.executeQuery();
            while (rs.next()) {
                resultado.put(rs.getString("cat_id"), new Categoria(rs.getString("cat_nombre")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
        return resultado;
    }
    //123
     public boolean addCategorias_Espectaculos(String nombreEspectaculo, String nombreCategoria){
        int cat_id = 1;
        int espec_id = 1;
        try {
            //Obtengo el ID de la Categoria segun el nombreCategoria que recibo por parametro
            PreparedStatement status = conexion.prepareStatement("SELECT cat_id FROM categorias WHERE cat_nombre=?");
            status.setString(1, nombreCategoria);
            ResultSet rs = status.executeQuery();
            while (rs.next()) {
                cat_id = rs.getInt(1);
            } 
            //Obtengo el ID del Espectaculo segun el nombreEspectaculo que recibo por parametro
            PreparedStatement status2 = conexion.prepareStatement("SELECT espec_id FROM espetaculos WHERE espec_nombre=?");
            status2.setString(1, nombreEspectaculo);
            ResultSet rs2 = status2.executeQuery();
            while (rs2.next()) {
                espec_id = rs2.getInt(1);
            }
            // Insert el espectaculo con su categoria asociada
            PreparedStatement status3 = conexion.prepareStatement("INSERT INTO categorias_espectaculos (cat_id, espec_id) VALUES (?,?)");
            status3.setInt (1, cat_id);
            status3.setInt (2, espec_id);
            status3.execute();
        
        }catch (SQLException ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }
     
     public void addCategoria_Espectaculo(String nombreEspectaculo, String nombreCategoria){
        int cat_id = 1;
        int espec_id = 1;
        try {
            //Obtengo el ID de la Categoria segun el nombreCategoria que recibo por parametro
            PreparedStatement status = conexion.prepareStatement("SELECT cat_id FROM categorias WHERE cat_nombre=?");
            status.setString(1, nombreCategoria);
            ResultSet rs = status.executeQuery();
            while (rs.next()) {
                cat_id = rs.getInt(1);
            } 
            //Obtengo el ID del Espectaculo segun el nombreEspectaculo que recibo por parametro
            PreparedStatement status2 = conexion.prepareStatement("SELECT espec_id FROM espetaculos WHERE espec_nombre=?");
            status2.setString(1, nombreEspectaculo);
            ResultSet rs2 = status2.executeQuery();
            while (rs2.next()) {
                espec_id = rs2.getInt(1);
            }
            // Insert el espectaculo con su categoria asociada
            PreparedStatement status3 = conexion.prepareStatement("INSERT INTO categorias_espectaculos (cat_id, espec_id) VALUES (?,?)");
            status3.setInt (1, cat_id);
            status3.setInt (2, espec_id);
            status3.execute();
        
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    
     
     public void addEspectaculo(String nombrePlataforma, String nombreOrganizador, String nombreEspectaculo, String descripcion, Double duracion, int cantEspectadoresMinima, int cantEspectadoresMaxima, String URL, Double Costo, String estado, String imagen, String [] categorias) {
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
            PreparedStatement status3 = conexion.prepareStatement("INSERT INTO espetaculos (espec_artista, espec_plataforma, espec_nombre, espec_descripcion, espec_duracion, espec_cant_min_espect, espec_cant_max_espect, espec_url, espec_fecha_registro, espec_costo, espec_estado, espec_imagen) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
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
            status3.setBoolean(11, true);
            status3.setString(12, imagen);
            System.out.println(status3.toString());
            status3.execute();
            
            //CUARTO INSERTO EN CATEGORIA_ESPECTACULO LOS LAS CATEGORIAS DEL ESPECTACULO
            
            
            for(int i = 0; i< categorias.length; i++){
                System.out.println(categorias[i]);
                addCategoria_Espectaculo(nombreEspectaculo, categorias[i]);
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
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
     
    public Map<String, Espectaculo> getEspectaculos() {
        Map<String, Espectaculo> resultado = new HashMap<>();
        Map<String, Categoria> categorias = new HashMap<>();
        try {
            PreparedStatement status = conexion.prepareStatement("SELECT * FROM espetaculos");
            ResultSet rs1 = status.executeQuery();
            while (rs1.next()) {
                PreparedStatement status2 = conexion.prepareStatement("SELECT cat_nombre FROM categorias AS cat, categorias_espectaculos AS catEspec WHERE  cat.cat_id=catEspec.cat_id AND catEspec.cat_id=?");
                status2.setString(1, rs1.getString("espec_id"));
                ResultSet rs2 = status2.executeQuery();
                while (rs2.next()) {
                    categorias.put(rs2.getString("cat_nombre"), new Categoria(rs2.getString("cat_nombre")));
                }
                resultado.put(rs1.getString("espec_nombre"), new Espectaculo(rs1.getString("espec_nombre"), rs1.getInt("espec_artista"), rs1.getString("espec_descripcion"), rs1.getInt("espec_cant_min_espect"), rs1.getInt("espec_cant_max_espect"), rs1.getString("espec_URL"), rs1.getDouble("espec_Costo") , rs1.getInt("espec_duracion"), rs1.getDate("espec_fecha_registro"), rs1.getString("espec_plataforma"), rs1.getString("espec_estado"), categorias, rs1.getString("espec_imagen")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        }
        return resultado;
    }
    
    /*public Map<String, Espectaculo> getEspectaculosSegunPlataforma(String nombrePlataforma) {
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
    }*/
    
    public Map<String, Categoria> getMapCategorias() throws SQLException {
        Map<String, Categoria> categorias = new HashMap<>();
        PreparedStatement status1 = conexion.prepareStatement("SELECT * FROM categorias");
        ResultSet rs1 = status1.executeQuery();
        while (rs1.next()) {
                categorias.put(rs1.getString("cat_nombre"), new Categoria(rs1.getString("cat_nombre")));
        }
        return categorias;
    }
    
    public Map<String, Espectaculo> getEspectaculosCorrectamente(String nomPlataforma, String nomCategoria) {
        Map<String, Espectaculo> resultado = new HashMap<>();
        Map<String, Categoria> categorias = new HashMap<>();
        if (nomPlataforma.isEmpty() && (!nomCategoria.isEmpty())){
            try {
                PreparedStatement status1 = conexion.prepareStatement("SELECT * FROM espetaculos AS espec WHERE espec.estado= 'a' AND espec.espec_id IN (SELECT espec_id FROM categorias_espectaculos as catEspec, categorias AS cat WHERE catEspec.cat_id=cat.cat_id AND cat.cat_nombre=?)");
                status1.setString(1, nomCategoria);
                ResultSet rs1 = status1.executeQuery();
                while (rs1.next()) {
                    PreparedStatement status2 = conexion.prepareStatement("SELECT cat_nombre FROM categorias AS cat, categorias_espectaculos AS catEspec WHERE  cat.cat_id=catEspec.cat_id AND atEspec.cat_id=?");
                    status2.setString(1, rs1.getString("espec_id"));
                    ResultSet rs2 = status2.executeQuery();
                    while (rs2.next()) {
                        categorias.put(rs2.getString("cat_nombre"), new Categoria(rs2.getString("cat_nombre")));
                    }
                    resultado.put(rs1.getString("espec_nombre"), new Espectaculo(rs1.getString("espec_nombre"), rs1.getInt("espec_artista"), rs1.getString("espec_descripcion"), rs1.getInt("espec_cant_min_espect"), rs1.getInt("espec_cant_max_espect"), rs1.getString("espec_URL"), rs1.getDouble("espec_Costo") , rs1.getInt("espec_duracion"), rs1.getDate("espec_fecha_registro"), rs1.getString("espec_plataforma"), rs1.getString("espec_estado"), categorias, rs1.getString("espec_imagen")));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        else{
            if ((!nomPlataforma.isEmpty()) && nomCategoria.isEmpty()){
                try {
                    PreparedStatement status1 = conexion.prepareStatement("SELECT * FROM espetaculos WHERE espetaculos.estado= 'a' AND espetaculos.espec_plataforma IN (SELECT valores_tipo.vp_id from valores_tipo WHERE valores_tipo.vp_nombre=?)");
                    status1.setString(1, nomPlataforma);
                    ResultSet rs1 = status1.executeQuery();
                    while (rs1.next()) {
                        PreparedStatement status2 = conexion.prepareStatement("SELECT cat_nombre FROM categorias AS cat, categorias_espectaculos AS catEspec WHERE  cat.cat_id=catEspec.cat_id AND atEspec.cat_id=?");
                        status2.setString(1, rs1.getString("espec_id"));
                        ResultSet rs2 = status2.executeQuery();
                        while (rs2.next()) {
                            categorias.put(rs2.getString("cat_nombre"), new Categoria(rs2.getString("cat_nombre")));
                        }
                        resultado.put(rs1.getString("espec_nombre"), new Espectaculo(rs1.getString("espec_nombre"), rs1.getInt("espec_artista"), rs1.getString("espec_descripcion"), rs1.getInt("espec_cant_min_espect"), rs1.getInt("espec_cant_max_espect"), rs1.getString("espec_URL"), rs1.getDouble("espec_Costo") , rs1.getInt("espec_duracion"), rs1.getDate("espec_fecha_registro"), rs1.getString("espec_plataforma"), rs1.getString("espec_estado"), categorias, rs1.getString("espec_imagen")));
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();

                }
            }
           /*else{
                if ((!nomPlataforma.isEmpty()) && (!nomCategoria.isEmpty())){
                    try { //Falta cambiar
                        PreparedStatement status1 = conexion.prepareStatement("SELECT * FROM espetaculos AS espec WHERE espec.estado= 'a' AND espec.espec_id IN (SELECT espec_id FROM categorias_espectaculos as catEspec, categorias AS cat WHERE catEspec.cat_id=cat.cat_id AND cat.cat_nombre=?)");
                        status1.setString(1, nomCategoria);
                        ResultSet rs1 = status1.executeQuery();
                        while (rs1.next()) {
                            PreparedStatement status2 = conexion.prepareStatement("SELECT cat_nombre FROM categorias AS cat, categorias_espectaculos AS catEspec WHERE  cat.cat_id=catEspec.cat_id AND atEspec.cat_id=?");
                            ResultSet rs2 = status2.executeQuery();
                            status2.setString(1, rs1.getString("espec_id"));
                            while (rs2.next()) {
                                categorias.put(rs2.getString("cat_nombre"), new Categoria(rs2.getString("cat_nombre")));
                            }
                            resultado.put(rs1.getString("espec_nombre"), new Espectaculo(rs1.getString("espec_nombre"), rs1.getInt("espec_artista"), rs1.getString("espec_descripcion"), rs1.getInt("espec_cant_min_espect"), rs1.getInt("espec_cant_max_espect"), rs1.getString("espec_URL"), rs1.getDouble("espec_Costo") , rs1.getInt("espec_duracion"), rs1.getDate("espec_fecha_registro"), rs1.getString("espec_estado"), categorias, rs1.getString("espec_imagen")));
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }*/
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
                //System.out.println("Nombre Plataforma: " + rs.getString("vp_nombre"));
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
    
    public JComboBox llenarComboBoxCategorias() {
        JComboBox aux = new JComboBox();
        try {
            Statement status = conexion.createStatement();
            ResultSet rs = status.executeQuery("SELECT cat_nombre FROM categorias");
            while (rs.next()) {
                aux.addItem(rs.getString(1));
            }
            return aux;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new JComboBox();
        }
    }
    
    public JComboBox llenarComboBoxEspectaculos (String nombrePlataforma) {
        JComboBox aux = new JComboBox();
        try {
            Statement status1 = conexion.createStatement();
            ResultSet rs1 = status1.executeQuery("SELECT vp_id FROM valores_tipo WHERE tp_id = 1 AND vp_nombre ='"+nombrePlataforma+"'");
            int id=0;
            if (rs1.next()) {
                id = rs1.getInt(1);
                Statement status = conexion.createStatement();
                ResultSet rs = status.executeQuery("SELECT espec_nombre FROM espetaculos WHERE espec_plataforma ="+id);
                while (rs.next()) {
                    aux.addItem(rs.getString(1));
                }
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
    public JList llenarListaArtistasPorNick(String nick) {
        DefaultListModel demoList = new DefaultListModel();
        try {
            //Si está vacío muestro todos los Artistas
                PreparedStatement status = conexion.prepareStatement("SELECT usuario.usu_nick FROM usuario WHERE usuario.usu_id IN(SELECT u2.usu_id FROM usuario as u2,artistas WHERE artistas.art_usu=u2.usu_id AND u2.usu_nick LIKE '" + nick + "%');"); //MUESTRO TODOS
                ResultSet rs = status.executeQuery();
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
                resultado.put(rs1.getString("fun_nombre"), new Funcion(rs1.getString("fun_nombre"), rs1.getDate("fun_fecha_inicio"), rs1.getTime("fun_hora_inicio"),rs1.getDate("fun_fecha_registro"), espectaculo, artistas, rs1.getString("fun_imagen")));

            }
        } catch (SQLException ex1) {
            ex1.printStackTrace();
        }
        return resultado;
    }
      
    
      
      public Map<String, Artista> getMapArtistas(String funcionId) {
        Map<String, Artista> artistas= new HashMap<>();
        try {
            PreparedStatement status1 = conexion.prepareStatement("SELECT * FROM artistas AS a, funcion_artista AS funart WHERE a.art_id=funart.funart_art_id AND funart.funart_fun_id="+Integer.parseInt(funcionId));
            //status1.setString(1, funcionId);
            ResultSet rs1 = status1.executeQuery();
            while (rs1.next()) {
                System.out.println("ID ARTISTA: "+rs1.getInt(1));
                //System.out.println("id artista ="+rs1.getInt("art_id"));
                PreparedStatement status2= conexion.prepareStatement("SELECT * FROM usuario AS u WHERE u.usu_id="+rs1.getInt("art_usu"));
                ResultSet rs2= status2.executeQuery();
                if(rs2.next()){
                    System.out.println("nombreUsuario ="+rs2.getString("usu_nombre"));
                    String fechaString = rs2.getDate("usu_nacimiento").toString(); 
                    String[] fechaParts = fechaString.split("-");
                    System.out.println("Fecha nacim: "+fechaString);
                    DTFecha auxFecha = new DTFecha(Integer.parseInt(fechaParts[2]),Integer.parseInt(fechaParts[1]),Integer.parseInt(fechaParts[0]));
                    artistas.put(rs1.getString("art_usu"), new Artista(rs2.getString("usu_nick"), rs2.getString("usu_nombre"), rs2.getString("usu_apellido"), rs2.getString("usu_mail"), auxFecha , rs1.getString("art_descripcion"), rs1.getString("art_biografia"), rs1.getString("art_url"))); 
                }else{
                    System.out.println("Vacio");
                }
            }

        } catch (SQLException ex1) {
            ex1.printStackTrace();
        }
        return artistas;
    }
      
    public Map<String, Espectaculo> getMapEspectaculoDePaquete(String paqueteId) {
        Map<String, Espectaculo> resultado = new HashMap<>();
        Map<String, Categoria> categorias = new HashMap<>();
        try {
            PreparedStatement status1 = conexion.prepareStatement("SELECT * FROM espetaculos WHERE espetaculos.espec_id IN (SELECT paquete_espetaculos.paqespec_espec_id FROM paquete_espetaculos,paquetes WHERE paquete_espetaculos.paqespec_paq_id=paquetes.paq_id AND paquetes.paq_nombre=?)");
            status1.setString(1, paqueteId);
            ResultSet rs1 = status1.executeQuery();
            while (rs1.next()) {
                PreparedStatement status2 = conexion.prepareStatement("SELECT cat_nombre FROM categorias AS cat, categorias_espectaculos AS catEspec WHERE  cat.cat_id=catEspec.cat_id AND atEspec.cat_id=?");
                status2.setString(1, rs1.getString("espec_id"));
                ResultSet rs2 = status2.executeQuery();
                while (rs2.next()) {
                    categorias.put(rs2.getString("cat_nombre"), new Categoria(rs2.getString("cat_nombre")));
                }
                resultado.put(rs1.getString("espec_nombre"), new Espectaculo(rs1.getString("espec_nombre"), rs1.getInt("espec_artista"), rs1.getString("espec_descripcion"), rs1.getInt("espec_cant_min_espect"), rs1.getInt("espec_cant_max_espect"), rs1.getString("espec_URL"), rs1.getDouble("espec_Costo") , rs1.getInt("espec_duracion"), rs1.getDate("espec_fecha_registro"), rs1.getString("espec_plataforma"), rs1.getString("espec_estado"), categorias, rs1.getString("espec_imagen")));
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
            
            
            
            while (rs.next()) {
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
            PreparedStatement status = conexion.prepareStatement("SELECT paq_id FROM paquetes WHERE paquetes.paq_nombre = '" + paq_seleccionado + "';"); 
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
    public boolean addEspectaculoAPaquete(String espec_seleccionado, String paq_seleccionado){
        // pide el id de los sus respectivas filas dado el nombre en estas
       String idPaquete = getidPaquete(paq_seleccionado);
       String idEspectaculo = getidEspectaculo(espec_seleccionado);
       try {
           // inserta los datos
            PreparedStatement status3 = conexion.prepareStatement("INSERT INTO paquete_espetaculos (paqespec_paq_id, paqespec_espec_id) VALUES (?,?)");
            status3.setString(1, idPaquete);
            status3.setString(2, idEspectaculo);
            status3.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public Espectaculo getEspecaculo(String funcionId){
        Map<String, Categoria> categorias = new HashMap<>();
        try {
            PreparedStatement status = conexion.prepareStatement("SELECT * FROM espetaculos, funcion WHERE espetaculos.espec_id=funcion.fun_espec_id AND funcion.fun_id=?");
            status.setString(1, funcionId);
            ResultSet rs = status.executeQuery();
            while(rs.next()){
                Espectaculo rslt= new Espectaculo(rs.getString("espec_nombre"), rs.getInt("espec_artista"), rs.getString("espec_descripcion"), rs.getInt("espec_cant_min_espect"), rs.getInt("espec_cant_max_espect"), rs.getString("espec_URL"), rs.getDouble("espec_Costo") , rs.getInt("espec_duracion"), rs.getDate("espec_fecha_registro"), rs.getString("espec_plataforma"), rs.getString("espec_estado"), categorias, rs.getString("espec_imagen"));
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
                resultado.put(rs1.getString("fun_nombre"), new Funcion(rs1.getString("fun_nombre"), rs1.getDate("fun_fecha_inicio"), rs1.getTime("fun_hora_inicio"),rs1.getDate("fun_fecha_registro"), espectaculo, artistas, rs1.getString("fun_imagen")));
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
    
    public void registrarFuncion(String idFuncion, String idEspectador, Date fechaRegistro, String metodo){
        try {
            PreparedStatement status = conexion.prepareStatement("INSERT INTO usuario_funcion (funcion_id,usu_id,fechaRegistro,canjeado) VALUES (?,?,?,?)");
            System.out.println("aaaaaaaaaaa"+idFuncion);
            System.out.println("aaaaaaaaaaa"+idEspectador);
            status.setInt (1, Integer.parseInt(idFuncion));
            status.setInt (2, Integer.parseInt(idEspectador));
            status.setDate(3, fechaRegistro);
            if (metodo.contains("canje")){
                status.setBoolean(4, true);
            }
            else{
                status.setBoolean(4, false);
            }
            status.execute();  
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public String getLinkPlataforma(String nombrePlataforma){
        String url = "";
        try {
        PreparedStatement status = conexion.prepareStatement("SELECT valores_tipo.vp_valor_1 FROM valores_tipo WHERE valores_tipo.vp_nombre='" + nombrePlataforma + "'");
            ResultSet rs = status.executeQuery();
            if(rs.next()){
                url=rs.getString(1);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return url;
    }
    
    public Map<String, Espectaculo> getMapEspectaculosAceptados(int artistaId) {
        Map<String, Espectaculo> resultado = new HashMap<>();
        String plataforma;
        try {
            PreparedStatement status1 = conexion.prepareStatement("SELECT * FROM espetaculos WHERE espetaculos.espec_estado='a' AND espetaculos.espec_artista=?");
            status1.setInt(1, artistaId);
            ResultSet rs = status1.executeQuery();
            while (rs.next()) {
                PreparedStatement status2 = conexion.prepareStatement("SELECT vp_nombre FROM valores_tipo as p, espetaculos as e WHERE p.vp_id=e.espec_plataforma AND e.espec_nombre='" + rs.getString("espec_nombre") + "'");
                ResultSet rs2 = status2.executeQuery();
                if(rs2.next()){
                    plataforma = rs2.getString(1);
                //resultado.put(rs.getString("espec_nombre"), new Espectaculo(rs.getString("espec_nombre"), rs.getInt("espec_artista"), rs.getString("espec_descripcion"), rs.getInt("espec_cant_min_espect"), rs.getInt("espec_cant_max_espect"), rs.getString("espec_URL"), rs.getDouble("espec_Costo") , rs.getInt("espec_duracion"), rs.getDate("espec_fecha_registro"), rs.getString("espec_estado"), rs.getString("espec_imagen")));
                    resultado.put(rs.getString("espec_nombre"), new Espectaculo(rs.getString("espec_nombre"), rs.getInt("espec_artista"), rs.getString("espec_descripcion"), rs.getInt("espec_cant_min_espect"), rs.getInt("espec_cant_max_espect"), rs.getString("espec_URL"), rs.getDouble("espec_Costo") , rs.getInt("espec_duracion"), rs.getDate("espec_fecha_registro"), rs.getString("espec_estado"), rs.getString("espec_imagen"), plataforma));
                }
            }
        } catch (SQLException ex1) {
            ex1.printStackTrace();
        }
        return resultado;
    }
    
    public int getIdporNickArtista(String artistaNick) {
        int artistaId=-1;
        try {
            PreparedStatement status1 = conexion.prepareStatement("SELECT a.art_id FROM artistas as a, usuario as u WHERE a.art_usu=u.usu_id AND u.usu_nick=?");
            status1.setString(1, artistaNick);
            ResultSet rs = status1.executeQuery();
            if (rs.next()) {
                artistaId=rs.getInt(1);
            }
        } catch (SQLException ex1) {
            ex1.printStackTrace();
            return -1;
        }
        return artistaId;
    }
    public int getIdporNickEspectador(String espectadorNick) {
        int espectadorId= -1;
        try {
            PreparedStatement status1 = conexion.prepareStatement("SELECT u.usu_id FROM usuario as u WHERE u.usu_nick=?");
            status1.setString(1, espectadorNick);
            ResultSet rs = status1.executeQuery();
            if (rs.next()) {
                espectadorId=rs.getInt(1);
            }
        } catch (SQLException ex1) {
            ex1.printStackTrace();
            return -1;
        }
        return espectadorId;
    }
    
    public Map<String, Espectaculo> getMapEspectaculosRechazados(int artistaId) {
        Map<String, Espectaculo> resultado = new HashMap<>();
        try {
            PreparedStatement status1 = conexion.prepareStatement("SELECT * FROM espetaculos WHERE espetaculos.espec_estado='r' AND espetaculos.espec_artista=?");
            status1.setInt(1, artistaId);
            ResultSet rs = status1.executeQuery();
            while (rs.next()) {
                resultado.put(rs.getString("espec_nombre"), new Espectaculo(rs.getString("espec_nombre"), rs.getInt("espec_artista"), rs.getString("espec_descripcion"), rs.getInt("espec_cant_min_espect"), rs.getInt("espec_cant_max_espect"), rs.getString("espec_URL"), rs.getDouble("espec_Costo") , rs.getInt("espec_duracion"), rs.getDate("espec_fecha_registro"), rs.getString("espec_estado"), rs.getString("espec_imagen")));
            }
        } catch (SQLException ex1) {
            ex1.printStackTrace();
        }
        return resultado;
    }
    
    public Map<String, Espectaculo> getMapEspectaculosIngresados(int artistaId) {
        Map<String, Espectaculo> resultado = new HashMap<>();
        try {
            PreparedStatement status1 = conexion.prepareStatement("SELECT * FROM espetaculos WHERE espetaculos.espec_estado='i' AND espetaculos.espec_artista=?");
            status1.setInt(1, artistaId);
            ResultSet rs = status1.executeQuery();
            while (rs.next()) {
                resultado.put(rs.getString("espec_nombre"), new Espectaculo(rs.getString("espec_nombre"), rs.getInt("espec_artista"), rs.getString("espec_descripcion"), rs.getInt("espec_cant_min_espect"), rs.getInt("espec_cant_max_espect"), rs.getString("espec_URL"), rs.getDouble("espec_Costo") , rs.getInt("espec_duracion"), rs.getDate("espec_fecha_registro"), rs.getString("espec_estado"), rs.getString("espec_imagen")));
            }
        } catch (SQLException ex1) {
            ex1.printStackTrace();
        }
        return resultado;
    }
    
    public Map<String, Funcion> getMapRegistroDeFuncionesDeUsuario(int usuId) {
        Map<String, Funcion> resultado = new HashMap<>();
        String id="";
        String espectaculo="";
        String plataforma="";
        try {
            //SELECT e.espec_nombre FROM espetaculos as e, funcion as f WHERE e.espec_id=f.fun_espec_id AND f.fun_nombre='Primer Dia'
            //SELECT e.espec_nombre FROM espetaculos as e, funcion as f WHERE e.espec_id=f.fun_espec_id AND f.fun_id=1;
            //SELECT vp_nombre FROM valores_tipo, espetaculos WHERE espetaculos.espec_plataforma=valores_tipo.vp_id AND espetaculos.espec_nombre='Rock de los 90'
            PreparedStatement status1 = conexion.prepareStatement("SELECT funcion.* FROM funcion,usuario_funcion WHERE funcion.fun_id=usuario_funcion.funcion_id AND usuario_funcion.usu_id=?");
            status1.setInt(1, usuId);
            ResultSet rs = status1.executeQuery();
            while (rs.next()) {
                id = String.valueOf(rs.getInt("fun_id")); 
                PreparedStatement status2 = conexion.prepareStatement("SELECT e.espec_nombre FROM espetaculos as e, funcion as f WHERE e.espec_id=f.fun_espec_id AND f.fun_id=?");
                status2.setInt(1, rs.getInt("fun_id"));
                ResultSet rs2 = status2.executeQuery();
                if (rs2.next()){
                    espectaculo = rs2.getString(1);//NOMBRE DEL ESPECTACULO
                }
                PreparedStatement status3 = conexion.prepareStatement("SELECT vp_nombre FROM valores_tipo, espetaculos WHERE espetaculos.espec_plataforma=valores_tipo.vp_id AND espetaculos.espec_nombre=?");
                status3.setString(1, espectaculo);
                ResultSet rs3 = status3.executeQuery();
                if (rs3.next()){
                    plataforma = rs3.getString(1);//NOMBRE DE LA PLATAFORMA
                }
                resultado.put(id, new Funcion(rs.getString("fun_nombre"), rs.getDate("fun_fecha_inicio"), rs.getTime("fun_hora_inicio"), rs.getDate("fun_fecha_registro"), new Espectaculo(espectaculo, plataforma)));
            }
        } catch (SQLException ex1) {
            ex1.printStackTrace();
            return null;
        }
        return resultado;
    }
    
    
}
