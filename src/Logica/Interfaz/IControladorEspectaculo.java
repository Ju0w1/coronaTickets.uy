/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Interfaz;

import Logica.Clases.Espectaculo;
import Logica.Clases.Funcion;
import java.sql.Date;
import java.sql.Time;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;

/**
 *
 * @author Admin
 */
public interface IControladorEspectaculo {
    public abstract void altaEspectaculo(String nombrePlataforma, String nombreOrganizador, String nombreEspectaculo, String descripcion, Double duracion, int cantEspectadoresMinima, int cantEspectadoresMaxima, String URL, Double Costo);
    public abstract void obtenerJComboBoxPlataformas(JComboBox comboBox);
    public abstract void obtenerJComboBoxEspectaculos(JComboBox comboBox);
    public void obtenerListaFunciones(JList jList, String idEspectaculo);
    public void obtenerTablaFunciones (JTable tablaFunciones, String nomEspectaculo);
    public abstract void obtenerArtistas();
    public abstract void obtenerArtistaPorNombre(String nombre);
    public abstract boolean verificarNombreEspectaculo(String nombre);
    public abstract void consultaFuncionEspectaculo(String plataforma, String espectaculo, String funcion, JLabel mostrarNom, JLabel mostrarFecha, JLabel mostrarHora, JList mostrarArtistas);
    public abstract int registroFuncionEspectaculo(String nomFuncion, String espectadorNom, Date fecha);
    public void obtenerListaEspectadores(JList listaEspec);
}

