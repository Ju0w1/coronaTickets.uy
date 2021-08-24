/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Interfaz;

import Logica.Clases.Espectaculo;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;

/**
 *
 * @author Admin
 */
public interface IControladorEspectaculo {
    public abstract void altaEspectaculo(String nombrePlataforma, String nombreOrganizador, String nombreEspectaculo, String descripcion, Double duracion, int cantEspectadoresMinima, int cantEspectadoresMaxima, String URL, Double Costo);
    public abstract void obtenerPlataformas(JComboBox comboPlataform);
    public abstract void obtenerPlataformas(JList listPlataform);
    public abstract void obtenerEspectaculos(JList listPlataform);
    public abstract void obtenerEspectaculosPorPlataforma(JList listPlataform, String nombrePlataforma);
    public abstract void obtenerArtistas();
    public abstract void obtenerArtistaPorNombre(String nombre);
    public abstract void cargarDatosConsultaEspectador(String espectaculoNombre, JLabel nombreApellido, JLabel nombreEspectaculo, JLabel duracion, JLabel espectMin, JLabel espectMax, JLabel URL, JLabel costo, JLabel fecha, JTextArea descrip);
    //public abstract void obtenerEspectaculo(String nombre);
    //public abstract void obtenerFuncionesDeEspectaculo(String nombre);
    public abstract boolean verificarNombreEspectaculo(String nombre);
    
}

