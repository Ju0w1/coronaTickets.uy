/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Controladores;

import Logica.DataTypes.DTFecha;
import Logica.DataTypes.DTTimeStamp;
import java.util.Iterator;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;
import java.util.HashMap;

import Logica.Interfaz.IControladorFuncion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import Logica.Clases.Artista;
import Logica.Clases.Funcion;
import Logica.Servicio.ArtistasServicios;
import Logica.Servicio.FuncionServicios;
import Logica.Servicio.UsuariosServicios;


public class ControladorFuncion implements IControladorFuncion{
    
    private Map<String, Funcion> funciones;
    //private UsuariosServicios servicioUsuarios;
    private FuncionServicios servicioFunciones;
    private Map<String, Artista> artistas;
    private ArtistasServicios servicioArt;
   
    
    private static ControladorFuncion instancia;

    public ControladorFuncion() {
        this.funciones = new HashMap<>();
        this.servicioFunciones = new FuncionServicios();
        this.servicioArt = new ArtistasServicios();
        this.artistas= new HashMap<>();
    }
    
    public static ControladorFuncion getInstance() {
        if (instancia == null) {
            instancia = new ControladorFuncion();
        }
        return instancia;
    }
    
    public boolean addFuncion(String nombreEspec, String nombre, DTFecha fecha_registro, DTTimeStamp hora_inicio, DTFecha fecha_comienzo, Map <String,Artista> artistas) {
        
        //this.funciones.put(nombre,new Funcion(nombre,fecha_comienzo,hora_inicio,fecha_registro,,));
        if (this.servicioFunciones.addFuncion(nombreEspec, nombre, fecha_registro, hora_inicio, fecha_comienzo, artistas)){
            return true;
        } else {
            return false;
        }
    }
    
    public void obtenerPlataformas(JComboBox PlataformaBox){
        for(int i=0;i<this.servicioFunciones.llenarListaPlataformas().getItemCount();i++){
            PlataformaBox.addItem(this.servicioFunciones.llenarListaPlataformas().getItemAt(i).toString());
            //Presentacion.AltaFuncion.PlataformaBox.addItem(this.servicioFunciones.llenarListaPlataformas().getItemAt(i).toString());
        }
    }
    
    public void obtenerEspectaculo(JComboBox EspectaculoBox, String nombrePlataforma){
        for(int i=0;i<this.servicioFunciones.llenarListaEspectaculo(nombrePlataforma).getItemCount();i++){
            EspectaculoBox.addItem(this.servicioFunciones.llenarListaEspectaculo(nombrePlataforma).getItemAt(i).toString());
        }
    }
    
    public Artista obtenerArtista(String nickname){
        Artista art = this.servicioFunciones.getArtista(nickname);
        return art;
    }
    
//    public void obtenerArtistas(){
//        for(int i=0;i<this.servicioFunciones.llenarListaArtistas().getItemCount();i++){
//            Presentacion.AltaFuncion.Lista_Artistas.
//            Presentacion.AltaFuncion.Lista_Artistas.addItem(this.servicioFunciones.llenarListaArtistas().getItemAt(i).toString());
//        }
//    }
    
    public void obtenerArtistas(JList listEspec){
        this.artistas = this.servicioArt.getArtista();
        //this.paquetes = this.servicioPaq.getPaquete();
        DefaultListModel listModel1 = new DefaultListModel();
        
        System.out.println("While Loop:");
        Iterator iterator = this.artistas.entrySet().iterator();//.entrySet().iterator();
        //Iterator iterator = this.paquetes.entrySet().iterator();
        
        while (iterator.hasNext()) {
            Map.Entry entrada = (Map.Entry) iterator.next();
            Artista e = (Artista) entrada.getValue();
            //System.out.println(e.getNickname());
            listModel1.addElement(e.getNickname());
        } 
        
        listEspec.setModel(listModel1);
    }
    
    @Override
    public void Prueba(String nombre_artista, String id_funcion, String id_artista, String nombre_funcion, DTFecha funcion_vigente) {
        this.servicioFunciones.AgregarArtista(nombre_artista,id_funcion,id_artista,nombre_funcion,funcion_vigente);
    }
    
//    public Map<String, Funcion> getRegistroDeFuncionesDeUsuario(int usuId){
//        Map<String, Funcion> funciones = servicioFunciones.getMapRegistroDeFuncionesDeUsuario(usuId);
//        return funciones;
//    }
//    public Map<String, Funcion> getRegistroDeFuncionesDeUsuarioPorNick(String usuNick){
//        int usuid = servicioFunciones.getIdporNickEspectador(usuNick);
//        if (usuid == -1){
//            return null;
//        } else {
//            Map<String, Funcion> funciones = getRegistroDeFuncionesDeUsuario(usuid);
//            return funciones;
//        }
//    }
}