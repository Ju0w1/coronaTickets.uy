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
import Logica.servicios.UsuariosServicios;

/**
 *
 * @author LucasCiceri
 */
public class ControladorUsuario implements IControladorUsuario{
    
    private Map<String, Usuario> artistas;
    private Map<String, Usuario> espectadores;

    private UsuariosServicios servicioUsuarios;
    private static ControladorUsuario instancia;

    public ControladorUsuario() {
        this.servicioUsuarios = new UsuariosServicios();
        //this.espectadores = new HashMap<>();
        //this.artistas = new HashMap<>();
    }
    
    public static ControladorUsuario getInstance() {
        if (instancia == null) {
            instancia = new ControladorUsuario();
        }
        return instancia;
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

    public void obtenerArtistas(DefaultTableModel tablaModelo) {
        this.artistas = this.servicioUsuarios.getArtistas();
        tablaModelo.setRowCount(0);
        
        int tamanioUsuarios = this.artistas.size();
        Object[][] data = new Object[tamanioUsuarios][2];
        
        for(int i = 0; i < tamanioUsuarios; i++){

            for(Map.Entry<String, Usuario> entry : this.artistas.entrySet()){

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

}