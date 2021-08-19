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
public class DTFuncion {
    private String nombre;
    private DTFecha fecha, fecha_registro;
    private DTTimeStamp hora_inicio;

    public DTFuncion(String nombre, DTFecha fecha, DTFecha fecha_registro, DTTimeStamp hora_inicio) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.fecha_registro = fecha_registro;
        this.hora_inicio = hora_inicio;
    }


    public String getNombre() {
        return nombre;
    }

    public DTFecha getFecha() {
        return fecha;
    }

    public DTFecha getFecha_registro() {
        return fecha_registro;
    }

    public DTTimeStamp getHora_inicio() {
        return hora_inicio;
    }

    
    
    
}
