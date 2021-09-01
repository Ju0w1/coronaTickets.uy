/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Controladores;

import java.util.Map;
import Logica.Clases.Espectaculo;
import Logica.Interfaz.IControladorEspectaculo;
import Logica.Servicios.EspectaculosServicios;
import java.util.Set;
import Logica.Clases.Funcion;
import Logica.Clases.Artista;
import Logica.Clases.Plataforma;
import Presentacion.ConsultaFuncion;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JTable;

/**
 *
 * @author pabli
 */
public class ControladorEspectaculos implements IControladorEspectaculo{
    //atributos
    private Map<String, Espectaculo> espectaculos;
    private Map<String, Funcion> funciones;
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

    @Override
    public void altaEspectaculo(String nombrePlataforma, String nombreOrganizador, String nombreEspectaculo, String descripcion, Double duracion, int cantEspectadoresMinima, int cantEspectadoresMaxima, String URL, Double Costo) {
        this.servicioEspectaculo.addEspectaculo(nombrePlataforma, nombreOrganizador, nombreEspectaculo, descripcion, duracion, cantEspectadoresMinima, cantEspectadoresMaxima, URL, Costo);
    }
    
    @Override
    public void obtenerJComboBoxPlataformas(JComboBox comboBox){
        for(int i=0;i<this.servicioEspectaculo.llenarComboBoxPlataformas().getItemCount();i++){
            comboBox.addItem(this.servicioEspectaculo.llenarComboBoxPlataformas().getItemAt(i).toString());
        }
    }
    
    @Override
    public void obtenerJComboBoxEspectaculos(JComboBox comboBox){
        for(int i=0;i<this.servicioEspectaculo.llenarComboBoxEspectaculo().getItemCount();i++){
            comboBox.addItem(this.servicioEspectaculo.llenarComboBoxEspectaculo().getItemAt(i).toString());
        }
    }
    
    @Override
     public void obtenerListaFunciones(JList listFunciones, String idEspectaculo){
        this.funciones= servicioEspectaculo.getMapFunciones(idEspectaculo);
        DefaultListModel listModel1 = new DefaultListModel();
        Iterator iterator = this.funciones.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entrada = (Map.Entry) iterator.next();
            Plataforma p = (Plataforma) entrada.getValue();
            listModel1.addElement(p.getNombre());
        }
        listFunciones.setModel(listModel1);
    }
     
    public void obtenerTablaFunciones (JTable tablaFunciones, String idEspectaculo){
        
    } 
    
    @Override
    public void obtenerArtistas(){
        Presentacion.AltaEspectaculo.jListArtistas.setModel(this.servicioEspectaculo.llenarListaArtistas().getModel());
    }
    
    @Override
    public void obtenerArtistaPorNombre(String nombre){
        Presentacion.AltaEspectaculo.jListArtistas.setModel(this.servicioEspectaculo.llenarListaArtistasPorNombre(nombre).getModel());
    }
    
    @Override
    public boolean verificarNombreEspectaculo(String nombre){
        return this.servicioEspectaculo.verificarExistenciaNombreEspectaculo(nombre);
    }
    
    public void consultaEspectaculo() {

    }
    
    public void altaFuncionEspectaculo(){
        
    }
    
    @Override
    public void consultaFuncionEspectaculo(String plataforma, String espectaculo, String funcion, JLabel mostrarNom, JLabel mostrarFecha, JLabel mostrarHora, JList mostrarArtistas){
        Map<String, Funcion> funciones = servicioEspectaculo.getMapFunciones(espectaculo);
        String auxFecha, auxHora, auxArtistas[]={};
        Set<String> artistas;
        Funcion rslt=funciones.get(funcion);
        
        mostrarNom.setText(rslt.getNombre());
        auxFecha= String.valueOf(rslt.getFecha().getDay())+"/"+String.valueOf(rslt.getFecha().getMonth())+"/"+String.valueOf(rslt.getFecha().getYear());
        mostrarFecha.setText(auxFecha);
        auxHora= String.valueOf(rslt.getHoraInicio().getHours())+":"+String.valueOf(rslt.getHoraInicio().getMinutes());
        mostrarHora.setText(auxHora);
        artistas= rslt.getArtistas().keySet();
        System.arraycopy(artistas.toArray(), 0, auxArtistas, 0, artistas.size());
        mostrarArtistas.setListData(auxArtistas);
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
