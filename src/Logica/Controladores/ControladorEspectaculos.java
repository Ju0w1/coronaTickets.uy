/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Controladores;

import java.util.Map;
import Logica.Clases.Espectaculo;
import Logica.Clases.Plataforma;
import Logica.Interfaz.IControladorEspectaculo;
import Logica.Servicios.EspectaculosServicios;
import java.util.HashMap;

import Logica.DataTypes.DTFecha;
import java.util.HashMap;
import Logica.Servicios.EspetaculoServicio;
import Logica.Servicios.PlataformaServicio;
import java.text.ParseException;
import java.util.Map;
import Logica.Clases.Plataforma;
import Logica.Clases.Paquete;
import Logica.Interfaz.IControladorEspectaculo;
import Logica.Servicios.PaqueteServicio;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class ControladorEspectaculos implements IControladorEspectaculo{
    //atributos
    private EspectaculosServicios servicioEspectaculo;
    private PaqueteServicio servicioPaquete;
    private PlataformaServicio servicioPlataforma;
    private EspetaculoServicio servicioEspetaculo;
    private static ControladorEspectaculos instancia;
    private Map<String, Espectaculo> espectaculos = new HashMap<>();
    private Map<String, Paquete > paquetes = new HashMap<>();
    private Map<String, Plataforma> plataformas = new HashMap<>();
    
    public ControladorEspectaculos ()
    {
        this.servicioPaquete = new PaqueteServicio();
        this.servicioEspectaculo = new EspectaculosServicios();
        this.plataformas = new HashMap<>();
        this.espectaculos = new HashMap<>();
    }
    
    public static ControladorEspectaculos getInstance() {
        if (instancia == null) {
            instancia = new ControladorEspectaculos();
        }
        return instancia;
    }
    
    public Map<String, Espectaculo> getEspectaculos(){
        Map<String, Espectaculo> espectaculos = servicioEspectaculo.getEspectaculos();
        return espectaculos;
    }
   
    
    public boolean addPlataforma(String nombre, String url, String descripcion){
        if (this.servicioEspectaculo.checkPlataforma(nombre)){
            return false;
        }
        if (this.servicioEspectaculo.addPlataforma(nombre, url, descripcion)){
            this.plataformas.put(nombre, new Plataforma(nombre, url, descripcion));    
            return true;
        }
        return false;
    }

    public void altaEspectaculo(String nombrePlataforma, String nombreOrganizador, String nombreEspectaculo, String descripcion, Double duracion, int cantEspectadoresMinima, int cantEspectadoresMaxima, String URL, Double Costo) {
        this.servicioEspectaculo.addEspectaculo(nombrePlataforma, nombreOrganizador, nombreEspectaculo, descripcion, duracion, cantEspectadoresMinima, cantEspectadoresMaxima, URL, Costo);
    }
    
    public void obtenerPlataformas(){
        for(int i=0;i<this.servicioEspectaculo.llenarListaPlataformas().getItemCount();i++){
            Presentacion.AltaEspectaculo.jComboBox1Plataformas.addItem(this.servicioEspectaculo.llenarListaPlataformas().getItemAt(i).toString());
        }
    }
    
    public void obtenerArtistas(){
        Presentacion.AltaEspectaculo.jListArtistas.setModel(this.servicioEspectaculo.llenarListaArtistas().getModel());
    }
    
    public void obtenerArtistaPorNombre(String nombre){
        Presentacion.AltaEspectaculo.jListArtistas.setModel(this.servicioEspectaculo.llenarListaArtistasPorNombre(nombre).getModel());
    }
    
    public boolean verificarNombreEspectaculo(String nombre){
        return this.servicioEspectaculo.verificarExistenciaNombreEspectaculo(nombre);
    }
    
    public void consultaEspectaculo() {

    }
    
    public void altaFuncionEspectaculo(){
        
    }
    
    public void consultaFuncionEspectaculo(){
        
    }
    
    public void registroFuncionEspectaculo(){
        
    }
    
    public void crearPaqueteEspectaculos(){
        
    }
    
    public boolean crearPaquete(String nombre, DTFecha fechaInicio, DTFecha fechaFin, int descuento, String descripcion){
        //Busco si encuentro el paquete
        boolean encontre = this.servicioPaquete.verificarPaquete(nombre);
        if(!encontre) // Si no encontro lo agrego
        {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            String fechaSI = String.valueOf(fechaInicio.getAnio())+"-"+String.valueOf(fechaInicio.getMes())+"-"+String.valueOf(fechaInicio.getDia());
            
            String fechaSF = String.valueOf(fechaFin.getAnio())+"-"+String.valueOf(fechaFin.getMes())+"-"+String.valueOf(fechaFin.getDia()); 

           try
           {
            java.util.Date fechaIF = formato.parse(fechaSI); 
            java.util.Date fechaFF = formato.parse(fechaSF);  
            java.util.Date fechaFC = new java.util.Date();
            java.sql.Date fechasql = new java.sql.Date(fechaIF.getTime());
            java.sql.Date fechaF = new java.sql.Date(fechaFF.getTime());
            java.sql.Date fechaCreado = new java.sql.Date(fechaFC.getTime());
            
            this.servicioPaquete.addPaquete(nombre, fechasql, fechaF,fechaCreado, descuento, descripcion);
           }catch(ParseException ex)
           {
               ex.getStackTrace();
           }
           return true;
        }else{ //Lo encontro 
            return false;
        }
    }

    public String obtenerDescripcion(String nombre)    
    {
        return this.servicioPaquete.obtenerDescripcion(nombre);
    }
    
    public String[] obtenerFecha(String nombre, int fecha)
    {
        return this.servicioPaquete.obtenerFecha(nombre, fecha);
    }
    
    public int obtenerDescuento(String nombre)
    {
        return this.servicioPaquete.obtenerDescuento(nombre);
    }
    
    public boolean actualizarPaquete(String nombre, DTFecha fechaInicio, DTFecha fechaFin, int descuento, String descripcion)
    {
        boolean actualizo = false;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechaSI = String.valueOf(fechaInicio.getAnio())+"-"+String.valueOf(fechaInicio.getMes())+"-"+String.valueOf(fechaInicio.getDia());

        String fechaSF = String.valueOf(fechaFin.getAnio())+"-"+String.valueOf(fechaFin.getMes())+"-"+String.valueOf(fechaFin.getDia()); 

        try
        {
            java.util.Date fechaIF = formato.parse(fechaSI); 
            java.util.Date fechaFF = formato.parse(fechaSF);  
            java.util.Date fechaFC = new java.util.Date();
            java.sql.Date fechasql = new java.sql.Date(fechaIF.getTime());
            java.sql.Date fechaF = new java.sql.Date(fechaFF.getTime());

            this.servicioPaquete.updatePaquete(nombre, fechasql, fechaF, descuento, descripcion);
            actualizo = true;
        }catch(ParseException ex)
        {
            ex.getStackTrace();
        }
        return actualizo;
    }
    
    public void crearFuncion()
    {
        
    }
    
    public ArrayList<String> cargarPlataforma()
    {
        return this.servicioPlataforma.llenarComboPlataforma();
    }
    
    public ArrayList<String> cargarEspectaculos(int plataforma)
    {
        return this.servicioEspetaculo.llenarComboEspectaculos(plataforma);
    }
    
}

