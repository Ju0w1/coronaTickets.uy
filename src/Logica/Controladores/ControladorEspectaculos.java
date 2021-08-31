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
import Logica.Servicios.PaquetesServicios;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import Logica.Clases.Funcion;
import Logica.Clases.Paquete;
import Logica.DataTypes.DTFecha;
import Logica.Servicios.PaquetesServicios;
import java.util.HashMap;

public class ControladorEspectaculos implements IControladorEspectaculo {

    //atributos
    //private Map<String, Espectaculo> espectaculos;
    //private Map<String, Plataforma> plataformas;
    private EspectaculosServicios servicioEspectaculo;
    private Map<String, Funcion> funciones;
    //private Map<String, Paquete> paquetes;
    private static ControladorEspectaculos instancia;
    private PaquetesServicios servicioPaquete;
    private PlataformaServicio servicioPlataforma;
    private EspetaculoServicio servicioEspetaculo;
    private Map<String, Espectaculo> espectaculos = new HashMap<>();
    private Map<String, Paquete > paquetes = new HashMap<>();
    private Map<String, Plataforma> plataformas = new HashMap<>();

    
    //metodos
    public ControladorEspectaculos() {
        this.servicioEspectaculo = new EspectaculosServicios();
        this.servicioPaquete = new PaquetesServicios();
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

    public void obtenerPlataformas(JComboBox listPlataform) {
        for (int i = 0; i < this.servicioEspectaculo.llenarComboBoxPlataformas().getItemCount(); i++) {
            listPlataform.addItem(this.servicioEspectaculo.llenarComboBoxPlataformas().getItemAt(i).toString());
        }
    }

    public void obtenerPlataformas(JList listPlataform) {
        this.plataformas = servicioEspectaculo.getPlataformas();
        DefaultListModel listModel1 = new DefaultListModel();
        Iterator iterator = this.plataformas.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entrada = (Map.Entry) iterator.next();
            Plataforma p = (Plataforma) entrada.getValue();
            listModel1.addElement(p.getNombre());
        }
        listPlataform.setModel(listModel1);
    }

    public void obtenerEspectaculos(JList listaEspectaculos) {
        this.espectaculos = servicioEspectaculo.getEspectaculos();
        DefaultListModel listModel1 = new DefaultListModel();
        Iterator iterator = this.espectaculos.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entrada = (Map.Entry) iterator.next();
            Espectaculo e = (Espectaculo) entrada.getValue();
            listModel1.addElement(e.getNombre());
        }
        listaEspectaculos.setModel(listModel1);
    }

    public void obtenerEspectaculosPorPlataforma(JList listaEspectaculos, String nombrePlataforma) {
        this.espectaculos = servicioEspectaculo.getEspectaculosSegunPlataforma(nombrePlataforma);
        DefaultListModel listModel1 = new DefaultListModel();
        Iterator iterator = this.espectaculos.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entrada = (Map.Entry) iterator.next();
            Espectaculo e = (Espectaculo) entrada.getValue();
            listModel1.addElement(e.getNombre());
        }
        listaEspectaculos.setModel(listModel1);
    }

    public void obtenerFuncionesDeEspectaculo() {
        //CONTINUAR
    }

    public void cargarDatosConsultaEspectaculo(String espectaculoNombre, JLabel nombreApellido, JLabel nombreEspectaculo, JLabel duracion, JLabel espectMin, JLabel espectMax, JLabel URL, JLabel costo, JLabel fecha, JTextArea descrip) {
        Espectaculo e = (Espectaculo) this.espectaculos.get(espectaculoNombre);
        nombreApellido.setText(Integer.toString(e.getArtista()));
        nombreEspectaculo.setText(e.getNombre());
        duracion.setText(Double.toString(e.getDuracion()));
        espectMin.setText(Integer.toString(e.getMin()));
        espectMax.setText(Integer.toString(e.getMax()));
        URL.setText(e.getUrl());
        costo.setText(Double.toString(e.getCosto()));
        fecha.setText(e.getFecha().toString());
        descrip.setText(e.getDescripcion());
    }

    public void obtenerArtistas() {
        Presentacion.AltaEspectaculo.jListArtistas.setModel(this.servicioEspectaculo.llenarListaArtistas().getModel());
    }

    public void obtenerArtistaPorNombre(String nombre) {
        Presentacion.AltaEspectaculo.jListArtistas.setModel(this.servicioEspectaculo.llenarListaArtistasPorNombre(nombre).getModel());
    }

    public boolean verificarNombreEspectaculo(String nombre) {
        return this.servicioEspectaculo.verificarExistenciaNombreEspectaculo(nombre);
    }

    public void consultaEspectaculo() {

    }

    public void altaFuncionEspectaculo() {

    }

    public void consultaFuncionEspectaculo() {

    }

    public void registroFuncionEspectaculo() {

    }

    public void crearPaqueteEspectaculos() {

    }

    public void obtenerListaFunciones(JList listFunciones) {
        this.funciones = servicioEspectaculo.getMapFuncionesEspectaculoNombre(Presentacion.ConsultaEspectaculo.txtNombreEspectaculo.getText());
        DefaultListModel listModel1 = new DefaultListModel();
        Iterator iterator = this.funciones.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entrada = (Map.Entry) iterator.next();
            Funcion f = (Funcion) entrada.getValue();
            listModel1.addElement(f.getNombre());
        }
        listFunciones.setModel(listModel1);
    }
    
    public void cargarDatosFuncionConsultaEspectaculo(String nombreFuncion, JLabel nombreFun, JLabel fechaRegistro, JLabel horaInicio, JLabel fechaInicio) {
        Funcion f = (Funcion) this.funciones.get(nombreFuncion);
        nombreFun.setText(f.getNombre());
        fechaRegistro.setText(f.getFechaRegistro().toString());
        horaInicio.setText(f.getHoraInicio().toString());
        fechaInicio.setText(f.getFecha().toString());
    }
    
    public void cargarDatosPaqueteConsultaEspectaculo(String nombreEspectaculo, String nombrePaquete, JLabel nombre, JLabel descripcion, JLabel fechaInicio, JLabel fechaFin, JLabel costo, JLabel Descuento , JList listaEspectaculos){
        this.paquetes=this.servicioPaquete.getPaquete();
        Paquete p = (Paquete) this.paquetes.get(nombrePaquete);
        nombre.setText(p.getNombre());
        descripcion.setText(p.getDescripcion());
        costo.setText(p.getCosto().toString());
        Descuento.setText(p.getDescuento().toString());
        
        String fechaIn = p.getFecha_Fin().getDia()+"/"+p.getFecha_Fin().getMes()+"/"+p.getFecha_Fin().getAnio();
        
        String fechaFn = p.getFecha_Fin().getDia()+"/"+p.getFecha_Fin().getMes()+"/"+p.getFecha_Fin().getAnio();
        
        fechaInicio.setText(fechaIn);
        fechaFin.setText(fechaFn);
        
        Map<String, Espectaculo> espectaculos = new HashMap<>();
        espectaculos = this.servicioEspectaculo.getMapEspectaculoDePaquete(nombrePaquete);
        DefaultListModel listModel1 = new DefaultListModel();
        Iterator iterator = espectaculos.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entrada = (Map.Entry) iterator.next();
            Espectaculo e = (Espectaculo) entrada.getValue();
            listModel1.addElement(e.getNombre());
        }
        listaEspectaculos.setModel(listModel1);
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

