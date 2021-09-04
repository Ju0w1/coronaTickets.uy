/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Interfaz;

import Logica.Clases.Espectaculo;
import javax.swing.JComboBox;
import javax.swing.JList; //NUEVO

/**
 *
 * @author Admin
 */
public interface IControladorEspectaculo {
    public abstract void altaEspectaculo(String nombrePlataforma, String nombreOrganizador, String nombreEspectaculo, String descripcion, Double duracion, int cantEspectadoresMinima, int cantEspectadoresMaxima, String URL, Double Costo);
    public abstract void obtenerPlataformas();
    
    public abstract void obtenerArtistas();
    public abstract void obtenerArtistaPorNombre(String nombre);
    public abstract boolean verificarNombreEspectaculo(String nombre);
    public void obtenerPaquetes(JList listPaquetes); //NUEVO
    public void obtenerPlataformas(JComboBox comboBoxPlataformas); //NUEVO
    public void obtenerEspectaculosPP(JList listEspectaculos, String paq_seleccionado, String plat_seleccionada); //NUEVO
    public void agregarEspectaculoAlPaquete(String espec_seleccionada, String paq_seleccionado); //NUEVO
}

