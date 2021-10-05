/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Controladores;

import Logica.DataTypes.DTFecha;
import java.util.Map;
import javax.swing.JTextField;
import Logica.Clases.Usuario;
import Logica.Clases.Espectador;
import Logica.Interfaz.IControladorUsuario;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;
import Logica.Clases.Artista;
import Logica.Servicio.ArtistasServicios;
import Logica.Servicio.UsuariosServicios;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;





/**
 *
 * @author LucasCiceri
 */
public class ControladorUsuario implements IControladorUsuario{
    
    private Map<String, Usuario> artistas;
    private Map<String, Usuario> artistasBuscados;
    private Map<String, Usuario> espectadores;

    private UsuariosServicios servicioUsuarios;
    private static ControladorUsuario instancia;
    
    private ArtistasServicios servicioArtista;

    public ControladorUsuario() {
        this.servicioUsuarios = new UsuariosServicios();
        this.servicioArtista = new ArtistasServicios();
        //this.espectadores = new HashMap<>();
        //this.artistas = new HashMap<>();
    }
    
    public static ControladorUsuario getInstance() {
        if (instancia == null) {
            instancia = new ControladorUsuario();
        }
        return instancia;
    }
    public boolean controlFecha(int dia, int mes,int anio){// TRUE SI ES CORRECTA / FALSE SI ESTA FUERA DE RANGO
        int[] bisiestos = {1904, 1908, 1912, 1916, 1920, 1924, 1928, 1932, 1936, 1940, 1944, 1948, 1952, 1956, 1960, 1964, 1968, 1972, 1976, 1980, 1984, 1988, 1992, 1996, 2000, 2004, 2008, 2012, 2016, 2020, 2024, 2028, 2032, 2036, 2040, 2044, 2048, 2052, 2056, 2060, 2064, 2068, 2072, 2076, 2080, 2084, 2088, 2092, 2096};
        int[] mesesLargos = {1, 3, 5 , 7, 8, 10, 12};
        boolean val = contains(bisiestos, anio);
        if (val){ 
            System.out.println("BISIESTO");
        }
        System.out.println("Dia:" + dia);
        System.out.println("Mes:" + mes);
        System.out.println("Anio:" + anio);
        
        boolean val2 = contains(mesesLargos, mes);
        if (dia > 28){
            if (val){// ANIO BISIESTO
                if (mes == 2 && dia == 29){ //UNICO CASO QUE ME INTERESA
                    return true;
                }
            }
            if (dia == 31){
                if (val2){ // MESES LARGOS
                    return true;
                } else {
                    return false;
                }
            }
            if (dia==30 || dia == 29){
                if (mes == 2){
                    return false;
                }
            }
        } else { // TODO OK
            return true;
        }
        return true;
    }
    
    public boolean login(String user, String password) {
        try {
            Usuario usuario = (Usuario) servicioUsuarios.getUser(user);
            System.out.println("usu: " + usuario.getEmail());
            if (usuario == null) {
                return false;
            } else if (password.equals(usuario.getContrasenia())) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(ControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public static boolean contains(final int[] arr, final int key) {
        return Arrays.stream(arr).anyMatch(i -> i == key);
    }
    
    public Map<String, Usuario> getUsuarios(){
        Map<String, Usuario> usuarios = servicioUsuarios.getUsers();
        return usuarios;
    };
    
    public boolean addEspectador(String nickname, String nombre, String apellido, String email, DTFecha nacimiento) {
        if (this.servicioUsuarios.checkUsuario(nickname, email) == false){
            //this.espectadores.put(email, new Espectador(nickname,nombre,apellido,email,nacimiento));
            this.servicioUsuarios.addUsuario(nickname, nombre, apellido, email, nacimiento);
            return true;
        } else {
            return false;
        }
    }
    
    public boolean addEspectador(String nickname, String password1, String email, String nombre, String apellido, String nacimiento, String imagen) {
        if (this.servicioUsuarios.checkUsuario(nickname, email) == false){
            //this.espectadores.put(email, new Espectador(nickname,nombre,apellido,email,nacimiento));
            this.servicioUsuarios.addUsuario( nickname,  password1,  email,  nombre,  apellido,  nacimiento, imagen);
            return true;
        } else {
            return false;
        }
    }
    public boolean addArtista(String nickname, String nombre, String apellido, String email, DTFecha nacimiento, String descripcion, String biografia, String link){
        if (this.servicioUsuarios.checkUsuario(nickname, email) == false){
            //this.artistas.put(email, new Artista(nickname, nombre, apellido, email, nacimiento, descripcion, biografia, link));
            this.servicioUsuarios.addArtista(nickname, nombre, apellido, email, nacimiento, descripcion, biografia, link);
            return true;
        } else {
            return false;
        }
    }
    
    //public void obtenerEspectadores(JList listEspec, DefaultTableModel tablaModelo){
    public void obtenerEspectadores( DefaultTableModel tablaModelo){
        this.espectadores = this.servicioUsuarios.getUsers();
        tablaModelo.setRowCount(0);
        
        int tamanioUsuarios = this.espectadores.size();
        Object[][] data = new Object[tamanioUsuarios][2];
        
        for(int i = 0; i < tamanioUsuarios; i++){

            for(Map.Entry<String, Usuario> entry : this.espectadores.entrySet()){

               data[i][0] = entry.getKey();
               data[i][1] = entry.getValue();
               //String datos[] = data[i][1].
               i++;
            }
        }  
        
        for(int i = 0; i < tamanioUsuarios; i++){
            //String data[] = {this.usuarios.get(i).getNombre(), this.usuarios.get(i).getApellido(), this.usuarios.get(i).getCedula()};
           
            Espectador e = (Espectador) data[i][1];
            //System.err.println(e.getNacimiento().getDia()+"/"+e.getNacimiento().getMes()+"/"+e.getNacimiento().getMes());
            String fecha = e.getNacimiento().getDia()+"/"+e.getNacimiento().getMes()+"/"+e.getNacimiento().getAnio();
            String datos[] = {e.getNickname(),e.getNombre(),e.getApellido(),e.getEmail(),fecha};
            tablaModelo.addRow(datos);
        }
    }
    
    public void obtenerEspectadoresBuscador( DefaultTableModel tablaModelo, String nick){
        this.espectadores = this.servicioUsuarios.getUsersBuscador(nick);
        tablaModelo.setRowCount(0);
        
        int tamanioUsuarios = this.espectadores.size();
        Object[][] data = new Object[tamanioUsuarios][2];
        
        for(int i = 0; i < tamanioUsuarios; i++){

            for(Map.Entry<String, Usuario> entry : this.espectadores.entrySet()){

               data[i][0] = entry.getKey();
               data[i][1] = entry.getValue();
               //String datos[] = data[i][1].
               i++;
            }
        }  
        
        for(int i = 0; i < tamanioUsuarios; i++){
            //String data[] = {this.usuarios.get(i).getNombre(), this.usuarios.get(i).getApellido(), this.usuarios.get(i).getCedula()};
           
            Espectador e = (Espectador) data[i][1];
            //System.err.println(e.getNacimiento().getDia()+"/"+e.getNacimiento().getMes()+"/"+e.getNacimiento().getMes());
            String fecha = e.getNacimiento().getDia()+"/"+e.getNacimiento().getMes()+"/"+e.getNacimiento().getAnio();
            String datos[] = {e.getNickname(),e.getNombre(),e.getApellido(),e.getEmail(),fecha};
            tablaModelo.addRow(datos);
        }
    }
    
    public void cargarDatosConsultaEspectador(String seleccion, JTextField nick, JTextField nombre, JTextField apellido, JTextField mail, JTextField nacimiento){
//        String[] partes = seleccion.split("\\(");
//        String[] partes2 = partes[1].split("\\)");
        
        Espectador e = (Espectador) this.espectadores.get(seleccion);
        DTFecha fechaN = e.getNacimiento();

        String fechaNacim = fechaN.getDia()+"/"+fechaN.getMes()+"/"+fechaN.getAnio();
        System.out.println(fechaNacim);
        nick.setText(e.getNickname());
        nombre.setText(e.getNombre());
        apellido.setText(e.getApellido());
        mail.setText(e.getEmail());
        nacimiento.setText(fechaNacim);
    }
    
    public void modificarEspectador(String email, String nombre, String apellido, DTFecha fecha){
        this.servicioUsuarios.modificarEspectador(nombre, apellido, fecha, email);
    }
    
    public void modificarArtista(String email, String nombre, String apellido, DTFecha fecha, String descripcion, String biografia, String url){
        this.servicioUsuarios.modificarArtista(nombre, apellido, fecha, email, descripcion, biografia, url);
    }

    public void obtenerArtistas(DefaultTableModel tablaModelo) {
        this.artistas = this.servicioUsuarios.getArtistas();
        tablaModelo.setRowCount(0);
        
        int tamanioUsuarios = this.artistas.size();
        Object[][] data = new Object[tamanioUsuarios][2];
        
        for(int i = 0; i < tamanioUsuarios; i++){

            for(Map.Entry<String, Usuario> entry : this.artistas.entrySet()){
        //        Map.e
               data[i][0] = entry.getKey();
               data[i][1] = entry.getValue();
               //String datos[] = data[i][1].
               i++;
            }
        }
        
        for(int i = 0; i < tamanioUsuarios; i++){
            //String data[] = {this.usuarios.get(i).getNombre(), this.usuarios.get(i).getApellido(), this.usuarios.get(i).getCedula()};
           
            Artista a = (Artista) data[i][1];
            //System.err.println(e.getNacimiento().getDia()+"/"+e.getNacimiento().getMes()+"/"+e.getNacimiento().getMes());
            String fecha = a.getNacimiento().getDia()+"/"+a.getNacimiento().getMes()+"/"+a.getNacimiento().getAnio();
            String datos[] = {a.getNickname(),a.getNombre(),a.getApellido(),a.getEmail(),fecha, a.getDescripcion(), a.getBiografia(), a.getLinkWeb()};
            tablaModelo.addRow(datos);
        }
    }
    public void obtenerArtistasBuscador(DefaultTableModel tablaModelo, String nick) {
        this.artistasBuscados = this.servicioUsuarios.getArtistasBuscador(nick);
        tablaModelo.setRowCount(0);
        
        int tamanioUsuarios = this.artistasBuscados.size();
        Object[][] data = new Object[tamanioUsuarios][2];
        
        for(int i = 0; i < tamanioUsuarios; i++){

            for(Map.Entry<String, Usuario> entry : this.artistasBuscados.entrySet()){
        //        Map.e
               data[i][0] = entry.getKey();
               data[i][1] = entry.getValue();
               //String datos[] = data[i][1].
               i++;
            }
        }
        
        for(int i = 0; i < tamanioUsuarios; i++){
            //String data[] = {this.usuarios.get(i).getNombre(), this.usuarios.get(i).getApellido(), this.usuarios.get(i).getCedula()};
           
            Artista a = (Artista) data[i][1];
            //System.err.println(e.getNacimiento().getDia()+"/"+e.getNacimiento().getMes()+"/"+e.getNacimiento().getMes());
            String fecha = a.getNacimiento().getDia()+"/"+a.getNacimiento().getMes()+"/"+a.getNacimiento().getAnio();
            String datos[] = {a.getNickname(),a.getNombre(),a.getApellido(),a.getEmail(),fecha, a.getDescripcion(), a.getBiografia(), a.getLinkWeb()};
            tablaModelo.addRow(datos);
        }
    }
    
    public void cargarDatosConsultaArtista(String seleccion, JTextField nick, JTextField nombre, JTextField apellido, JTextField mail, JTextField nacimiento, JTextArea areaDescripcion, JTextArea areaBiografia, JTextField url) {
        Artista a = (Artista) this.artistas.get(seleccion);
        DTFecha fechaN = a.getNacimiento();

        String fechaNacim = fechaN.getDia()+"/"+fechaN.getMes()+"/"+fechaN.getAnio();
        System.out.println(fechaNacim);
        nick.setText(a.getNickname());
        nombre.setText(a.getNombre());
        apellido.setText(a.getApellido());
        mail.setText(a.getEmail());
        nacimiento.setText(fechaNacim);
        areaDescripcion.setText(a.getDescripcion());
        areaBiografia.setText(a.getBiografia());
        url.setText(a.getLinkWeb());
    }
    
    public Map<String, Usuario> obtenerUsuarios(){ //Se obtienen todos los usuarios(Tanto artistas como Espectadores) con los campos actualizados (Versión web)
        try {
            Map<String, Usuario> usuarios = servicioUsuarios.getAllUsers();
            return usuarios;
        } catch (SQLException ex) {
            System.out.println(ex);
            Logger.getLogger(ControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    };
    public Artista obtenerArtista(int idUsuario){ //Se obtiene toda la información de un Artista (Incluye cantidad de seguidores y seguidos)
        Artista artista = servicioArtista.getArtista(idUsuario);
        return artista;
    };
    
    public Usuario obtenerEspectador(int idUsuario){ //Se obtiene toda la información de un Espectador en específico (Incluye cantidad de seguidores y seguidos)
        Usuario usuario = null;
        try {
            usuario = servicioUsuarios.getUser(idUsuario);
        } catch (SQLException ex) {
            Logger.getLogger(ControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

}