/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Controladores;

import java.util.Map;
import Logica.Clases.Espectaculo;
import Logica.Clases.Plataforma; //NUEVO
import Logica.Interfaz.IControladorEspectaculo;
import Logica.Servicios.EspectaculosServicios;
import java.util.Iterator; //NUEVO
import javax.swing.DefaultListModel; //NUEVO
import javax.swing.JComboBox; //NUEVO
import javax.swing.JList; // NUEVO
import logica.Clases.Paquete; // NUEVO


/**
 *
 * @author pabli
 */
public class ControladorEspectaculos implements IControladorEspectaculo{
    //atributos
    private Map<String, Paquete> paquetes; // NUEVO
    private Map<String, Plataforma> plataformas; // NUEVO
    private Map<String, Espectaculo> espectaculos;
    private EspectaculosServicios servicioEspectaculo;
    private static ControladorEspectaculos instancia;
    //getters
//    public Espectaculo getEspectaculo(){
//        
//    }
    
    public Map<String, Espectaculo> getEspectaculos(){
        return this.espectaculos;
    }
    
    //metodos
    public ControladorEspectaculos() {
        this.servicioEspectaculo = new EspectaculosServicios();
    }
   
    public static ControladorEspectaculos getInstance() {
        if (instancia == null) {
            instancia = new ControladorEspectaculos();
        }
        return instancia;
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

//    @Override
//    public void agregarEspectaculo(String nombrePlataforma, String nombreOrganizador, String nombreEspectaculo, String descripcion, Double duracion, int cantEspectadoresMinima, int cantEspectadoresMaxima, String URL, Double Costo) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
    //NUEVO
    public void obtenerPaquetes(JList jlist){
        DefaultListModel model = new DefaultListModel();
        this.paquetes = this.servicioEspectaculo.getPaquetes();
        
        for (Paquete value : paquetes.values()) {
             model.addElement(value.getNombre());
              //System.out.println("Value = " + value);
        }
        
        /*
        DefaultListModel model = new DefaultListModel();
        
        
        Iterator iterator = this.paquetes.entrySet().iterator();
        
        while (iterator.hasNext()) {
           
            Map.Entry entrada = (Map.Entry) iterator.next(); // tomando las entradas
            Paquete p = (Paquete) entrada.getValue(); // se obtiene el paquete 
           
            model.addElement(p.getNombre()); // agrega el nombre al model
                    
        } */
        
        jlist.setModel(model); // se le pasa al jlist
    }
    
    //NUEVO
    public void obtenerPlataformas(JComboBox jComboBox1Plataformas){
        this.plataformas = this.servicioEspectaculo.getPlataformas();
        jComboBox1Plataformas.removeAllItems();
               
        
        Iterator iterator = this.plataformas.entrySet().iterator();
        
        while (iterator.hasNext()) {
           
            Map.Entry entrada = (Map.Entry) iterator.next(); // tomando las entradas
            Plataforma p = (Plataforma) entrada.getValue(); // se obtiene el paquete 
           
            jComboBox1Plataformas.addItem(p.getNombre()); // agrega el nombre al combobox
                    
        } 
        
    }
    
    //NUEVO
    public void obtenerEspectaculosPP(JList jlist, String paq_seleccionado, String plat_seleccionada){
        Map<String, String>espectaculosRaros;
        DefaultListModel model = new DefaultListModel();
        espectaculosRaros = this.servicioEspectaculo.getEspectaculosPP(paq_seleccionado, plat_seleccionada);
        
        for (String value : espectaculosRaros.values()) {
             model.addElement(value);
              //System.out.println("Value = " + value);
        }
        jlist.setModel(model);
    
    }

    @Override
    public void agregarEspectaculoAlPaquete(String espec_seleccionada, String paq_seleccionado) {
        this.servicioEspectaculo.addEspectaculoAPaquete(espec_seleccionada, paq_seleccionado);
    }
}
