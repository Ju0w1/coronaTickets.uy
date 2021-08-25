/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Controladores;

import java.util.Map;
import Logica.Clases.Espectaculo;
import Logica.Clases.Plataforma;
import Logica.Interfaz.IControladorEspectaculo;
import Logica.Servicios.EspectaculosServicios;
import java.util.HashMap;


/**
 *
 * @author pabli
 */
public class ControladorEspectaculos implements IControladorEspectaculo{
    //atributos
    private Map<String, Espectaculo> espectaculos;
    private EspectaculosServicios servicioEspectaculo;
    private static ControladorEspectaculos instancia;
    private Map<String, Plataforma> plataformas;
    
    //getters
//    public Espectaculo getEspectaculo(){
//        
//    }
    
    public Map<String, Espectaculo> getUsuarios(){
        Map<String, Espectaculo> espectaculos = servicioEspectaculo.getEspectaculos();
        return espectaculos;
    };
    
    //metodos
    public ControladorEspectaculos() {
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

//    @Override
//    public void agregarEspectaculo(String nombrePlataforma, String nombreOrganizador, String nombreEspectaculo, String descripcion, Double duracion, int cantEspectadoresMinima, int cantEspectadoresMaxima, String URL, Double Costo) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
