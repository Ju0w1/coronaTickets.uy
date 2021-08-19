/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Controladores;

import java.util.Map;
import java.util.HashMap;
import logica.Clases.Usuario;
import logica.Clases.Espectador;
import logica.interfaz.IControladorUsuario;
import logica.servicios.UsuariosServicios;
import logica.DataTypes.DTFecha;

/**
 *
 * @author LucasCiceri
 */
public class ControladorUsuario implements IControladorUsuario{
    
    private Map<String, Usuario> artistas;
    private Map<String, Espectador> espectadores;
    
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
    
    public Map<String, Usuario> getUsuarios(){
        Map<String, Usuario> usuarios = servicioUsuarios.getUsers();
        return usuarios;
    };
//    public Map<String, Usuario> getUsuarios(){
//        this.espectadores = servicioUsuarios.getUsers();
//        return espectadores;
//    };
    
    public void addEspectador(String nickname, String nombre, String apellido, String email, DTFecha nacimiento){
        //this.servicioUsuarios.getUsers();
        this.espectadores.put(nickname, new Espectador(nickname,nombre,apellido,email,nacimiento));
        
//        for(int i = 0; i < this.espectadores.size(); i++){
//            System.out.println("Nombre: " + this.espectadores.get(i).getNombre() + ", Apellido: " + this.espectadores.get(i).getApellido());
//        }

        this.servicioUsuarios.addEspectador(nickname, nombre, apellido, email, nacimiento);
    }
}