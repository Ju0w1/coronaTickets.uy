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
public class DTEspectaculo {
     // atributos
    private String artista, nombre, descripcion, url;
    private DTTimeStamp duracion;
    private int cant_min_espectadores, cant_max_espectadores, costo;
    private DTFecha fecha_registro;
   
    

    //constructor
    public DTEspectaculo(String artista, String nombre, String descripcion, String url, DTTimeStamp duracion, int cant_min_espectadores, int cant_max_espectadores, int costo, DTFecha fecha_registro){    
        this.artista = artista;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url = url;
        this.duracion = duracion;
        this.cant_min_espectadores = cant_min_espectadores;
        this.cant_max_espectadores = cant_max_espectadores;
        this.costo = costo;
        this.fecha_registro = fecha_registro;
    }

    //getters
    public String getArtista() {
        return this.artista;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getDescripcion(){
        return this.descripcion;
    }
    public String getUrl(){
        return this.url;
    }
    public DTTimeStamp getDuracion(){
        return this.duracion;
    }
    public int getCant_min_espectadores(){
        return this.cant_min_espectadores;
    }
    public int getCant_max_espectadores(){
        return this.cant_max_espectadores;
    }
    public int getCosto(){
        return this.costo;
    }
    public DTFecha getFecha_registro(){
        return this.fecha_registro;
    }
   
    
}
