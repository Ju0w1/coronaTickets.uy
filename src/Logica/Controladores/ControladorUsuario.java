/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Controladores;

import Logica.DataTypes.DTFecha;
import java.util.Iterator;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;
import Logica.Clases.Espectador;
import java.util.HashMap;
import Logica.Clases.Usuario;
import Logica.Clases.Espectador;
import Logica.Interfaz.IControladorUsuario;
import Logica.servicios.UsuariosServicios;
import java.sql.Date;


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
        this.espectadores = new HashMap<>();
        this.artistas = new HashMap<>();
    }
    
    public static ControladorUsuario getInstance() {
        if (instancia == null) {
            instancia = new ControladorUsuario();
        }
        return instancia;
    }
    
    @Override
    public Map<String, Usuario> getUsuarios(){
        Map<String, Usuario> usuarios = servicioUsuarios.getUsers();
        return usuarios;
    };
//    public Map<String, Usuario> getUsuarios(){
//        this.espectadores = servicioUsuarios.getUsers();
//        return espectadores;
//    };
    
    @Override
    public void addEspectador(String nickname, String nombre, String apellido, String email, Date nacimiento) {
        this.espectadores.put(email, new Espectador(nickname,nombre,apellido,email,nacimiento));
        this.servicioUsuarios.addEspectador(nickname, nombre, apellido, email, nacimiento);
    }
    
    @Override
    public void obtenerEspectadores(JList listEspec){
        this.espectadores = this.servicioUsuarios.getUsers();
        DefaultListModel listModel1 = new DefaultListModel();
        
        System.out.println("While Loop:");
        Iterator iterator = this.espectadores.entrySet().iterator();
        
        while (iterator.hasNext()) {
            Map.Entry entrada = (Map.Entry) iterator.next();
            Espectador e = (Espectador) entrada.getValue();
            System.out.println(e.getNickname()+ " (" + e.getEmail()+")");
            listModel1.addElement(e.getNickname()+ " (" + e.getEmail()+")");
        } 
        
        listEspec.setModel(listModel1);
    }
    
    @Override
    public void cargarDatosConsultaEspectador(String seleccion, JTextField nick, JTextField nombre, JTextField apellido, JTextField mail, JTextField nacimiento){
        String[] partes = seleccion.split("\\(");
        String[] partes2 = partes[1].split("\\)");
        
        Espectador e = (Espectador) this.espectadores.get(partes2[0]);
        Date fechaN = e.getNacimiento();

        String fechaNacim = fechaN.getDay()+"/"+fechaN.getMonth()+"/"+fechaN.getYear();
        nick.setText(e.getNickname());
        nombre.setText(e.getNombre());
        apellido.setText(e.getApellido());
        mail.setText(e.getEmail());
        nacimiento.setText(fechaNacim);
        
    }
    
    @Override
    public void modificarEspectador(String nombre, String apellido, Date fecha){
        System.out.println(nombre);
        System.out.println(apellido);
        System.out.println(fecha.getDay());
        System.out.println(fecha.getMonth());
        System.out.println(fecha.getYear());
    }
}
     
 
