/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Controladores;

import Logica.DataTypes.DTFecha;
import java.util.Iterator;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;
import logica.Clases.Espectador;
import logica.Clases.Usuario;
import logica.Interfaces.IControladorUsuario;
import logica.servicios.UsuariosServicios;

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
    
    public void agregarEspectador(Espectador espectador) {
    
        this.espectadores.put(espectador.getEmail(), espectador);
        //this.servicioUsuarios.agregarEspectador(espectador);
    
    }
    
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
    
    public void cargarDatosConsultaEspectador(String seleccion, JTextField nick, JTextField nombre, JTextField apellido, JTextField mail, JTextField nacimiento){
        String[] partes = seleccion.split("\\(");
        String[] partes2 = partes[1].split("\\)");
        
        Espectador e = (Espectador) this.espectadores.get(partes2[0]);
        DTFecha fechaN = e.getNacimiento();

        String fechaNacim = fechaN.getDia()+"/"+fechaN.getMes()+"/"+fechaN.getAnio();
        nick.setText(e.getNickname());
        nombre.setText(e.getNombre());
        apellido.setText(e.getApellido());
        mail.setText(e.getEmail());
        nacimiento.setText(fechaNacim);
        
    }
    
    public void modificarEspectador(String nombre, String apellido, DTFecha fecha){
        System.out.println(nombre);
        System.out.println(apellido);
        System.out.println(fecha.getDia());
        System.out.println(fecha.getMes());
        System.out.println(fecha.getAnio());
    }
}
