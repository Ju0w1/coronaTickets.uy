/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Interfaz;

import java.util.*;
import Logica.Clases.Espectaculo;
import logica.Clases.DTFecha;
import logica.Clases.Paquete;
import logica.Clases.Funcion;

/**
 *
 * @author 59898
 */
public interface IControladorEspetaculo {
    
    public abstract Map<String, Espectaculo> getEspectaculos();
    public abstract boolean crearPaquete(String nombre, DTFecha fechaInicio, DTFecha fechaFin, int descuento, String descripcion);
    public abstract String obtenerDescripcion(String nombre);
    public abstract String[] obtenerFecha(String nombre,int fecha);
    public abstract int obtenerDescuento(String nombre); 
    public abstract boolean actualizarPaquete(String nombre, DTFecha fechaInicio, DTFecha fechaFin, int descuento, String descripcion);
    public abstract void crearFuncion();
    public abstract ArrayList<String> cargarPlataforma();
    public abstract ArrayList<String> cargarEspectaculos(int plataforma);
}
