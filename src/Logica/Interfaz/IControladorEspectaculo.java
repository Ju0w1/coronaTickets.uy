/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Interfaz;

import Logica.Clases.Espectaculo;
import javax.swing.JComboBox;
import javax.swing.JList;

/**
 *
 * @author Admin
 */
public interface IControladorEspectaculo {
    public abstract void altaEspectaculo(String nombrePlataforma, String nombreOrganizador, String nombreEspectaculo, String descripcion, Double duracion, int cantEspectadoresMinima, int cantEspectadoresMaxima, String URL, Double Costo);
    public abstract void obtenerPlataformas(JComboBox comboPlataform);
    public abstract void obtenerPlataformas(JList listPlataform);
    public abstract void obtenerArtistas();
    public abstract void obtenerArtistaPorNombre(String nombre);
    //public abstract void obtenerEspectaculo(String nombre);
    //public abstract void obtenerFuncionesDeEspectaculo(String nombre);
    public abstract boolean verificarNombreEspectaculo(String nombre);
    
}

