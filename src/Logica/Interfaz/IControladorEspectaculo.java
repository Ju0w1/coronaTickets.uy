/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Interfaz;

import Logica.Clases.Espectaculo;
import javax.swing.JComboBox;
//import java.util.*;
import Logica.Clases.Espectaculo;
import Logica.DataTypes.DTFecha;
import Logica.Clases.Paquete;
import Logica.Clases.Funcion;
import Logica.Clases.Registro;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JList; //NUEVO
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;


/**
 *
 * @author Admin
 */
public interface IControladorEspectaculo {
    public abstract void altaEspectaculo(String nombrePlataforma, String nombreOrganizador, String nombreEspectaculo, String descripcion, Double duracion, int cantEspectadoresMinima, int cantEspectadoresMaxima, String URL, Double Costo);
    public abstract void obtenerPlataformasToList(JList listPlataform);
    public abstract void obtenerEspectaculos(JList listPlataform);
    public abstract void obtenerEspectaculosPorPlataforma(JList listPlataform, String nombrePlataforma);
    public abstract void obtenerPlataformas();
    public abstract void obtenerArtistas();
    public abstract void obtenerArtistaPorNick(String nombre);//NUEVOO
    public abstract void obtenerArtistaPorNombre(String nick);
    public abstract void cargarDatosConsultaEspectaculo(String espectaculoNombre, JLabel nombreApellido, JLabel nombreEspectaculo, JLabel duracion, JLabel espectMin, JLabel espectMax, JLabel URL, JLabel costo, JLabel fecha, JTextArea descrip);
    public abstract void cargarDatosFuncionConsultaEspectaculo(String nombreFuncion, JLabel nombreFun, JLabel fechaRegistro, JLabel horaInicio, JLabel fechaInicio);
    public abstract boolean verificarNombreEspectaculo(String nombre);
    public abstract boolean addPlataforma(String nombre, String url, String descripcion);
    public abstract Map<String, Espectaculo> getEspectaculos();
    public abstract boolean crearPaquete(String nombre, DTFecha fechaInicio, DTFecha fechaFin, int descuento, String descripcion);
    public abstract String obtenerDescripcion(String nombre);
    public abstract String[] obtenerFecha(String nombre,int fecha);
    public abstract int obtenerDescuento(String nombre); 
    public abstract boolean actualizarPaquete(String nombre, DTFecha fechaInicio, DTFecha fechaFin, int descuento, String descripcion);
    public abstract void crearFuncion();
    public abstract ArrayList<String> cargarPlataforma();
    public abstract ArrayList<String> cargarEspectaculos(int plataforma);
    public abstract void obtenerListaFunciones(JList listFunciones);
    public abstract void cargarDatosPaqueteConsultaEspectaculo(String nombreEspectaculo, String nombrePaquete, JLabel nombre, JLabel descripcion, JLabel fechaInicio, JLabel fechaFin, JLabel costo, JLabel Descuento , JList listaEspectaculos);
    public void obtenerPaquetes(JList listPaquetes); //NUEVO
    public void obtenerPlataformasToComboBox(JComboBox comboBoxPlataformas); //NUEVO
    public void obtenerEspectaculosToComboBox(JComboBox comboEspectaculos, String nombrePlataforma); //NUEVO
    //public void cargarDatosFunciones(DefaultTableModel modeloTabla, String nombreEspectaculo); //NUEVO
    public void obtenerEspectaculosPP(JList listEspectaculos, String paq_seleccionado, String plat_seleccionada); //NUEVO
    public boolean agregarEspectaculoAlPaquete(String espec_seleccionada, String paq_seleccionado); //NUEVO
    public abstract void obtenerTablaFunciones (DefaultTableModel tablaModelo, String nomEspectaculo);
    public abstract int registroFuncionEspectaculo(String nomFuncion, String espectadorNom, Date fecha);
    public abstract Boolean yaRegistradoAFuncion(Map<String, Registro> registros, String espectadorNom, String nomFuncion);
    public abstract boolean puedeCanjearRegistrosPrevios(Map<String, Registro> registros, String espectadorNom, String nomFuncion);
    public abstract void canjearTresRegistrosPrevios(String nomFuncion, String espectadorNom, Date fecha, DefaultTableModel tabla);
    public abstract void actualizarEstadoDeRegistros(String idFuncion,String registro1, String registro2, String registro3, String espectadorNom, Date fecha);
    public abstract boolean controlFecha(int dia, int mes,int anio);
    public abstract boolean fechaInicioMayor(int diaUno, int mesUno, int anioUno,int diaDos, int mesDos,int anioDos);
    public void obtenerArtistasDeFuncion(DefaultTableModel tablaModelo, String nombreFuncion);
    public abstract void llenarEspectaculos();
    public abstract void obtenerLinkPlataforma(String nombrePlataforma, JTextField linkPlataforma);
}

