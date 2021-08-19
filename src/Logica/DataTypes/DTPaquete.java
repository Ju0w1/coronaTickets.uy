/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.DataTypes;

/**
 *
 * @author Dávila
 */
public class DTPaquete {
    private String nombre, descripcion;
    private DTFecha fechaInicio, fechaFin, fechaCompra;
    private float costo, descuento;

    public DTPaquete(String nombre, String descripcion, DTFecha fechaInicio, DTFecha fechaFin, DTFecha fechaCompra, float costo, float descuento) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.fechaCompra = fechaCompra;
        this.costo = costo;
        this.descuento = descuento;
    }
    

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public DTFecha getFechaInicio() {
        return fechaInicio;
    }

    public DTFecha getFechaFin() {
        return fechaFin;
    }

    public DTFecha getFechaCompra() {
        return fechaCompra;
    }

    public float getCosto() {
        return costo;
    }

    public float getDescuento() {
        return descuento;
    }
    
    

}
