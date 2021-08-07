package Logica.Clases;

import logica.Clases.DTFecha;
import logica.Clases.DTTimeStamp;


public class Espectaculo {
    
    private String Nombre;
    private String Artista;
    private String Descripcion;
    private int Cant_min_espectadores;
    private int Cant_max_espectadores;
    private String Url;
    private int Costo;
    private DTTimeStamp Duracion;
    private DTFecha Fecha_Registro;
    
    public Espectaculo(String nombre,String Artista,String descr,int min,int max, String url, int costo,DTTimeStamp duracion,DTFecha Fregistro){
        this.Nombre=nombre;
        this.Artista=Artista;
        this.Descripcion=descr;
        this.Cant_min_espectadores=min;
        this.Cant_max_espectadores=max;
        this.Url=url;
        this.Costo=costo;
        this.Duracion=duracion;
        this.Fecha_Registro=Fregistro;
    }
    
    //Getters
    public String getNombre(){
        return this.Nombre;
    }
    public String getArtista(){
        return this.Artista;
    }
    public String getDescripcion(){
        return this.Descripcion;
    }
    public int getMax(){
        return this.Cant_max_espectadores;
    }
    public int getMin(){
        return this.Cant_min_espectadores;
    }
    public String getUrl(){
        return this.Url;
    }
    public int getCosto(){
        return this.Costo;
    }
    
    //Setters
    public void setNombre(String nom_x){
        this.Nombre=nom_x;
    }
    public void setArtista(String artista_x){
        this.Artista=artista_x;
    }
    public void setDescripcion(String desc_x){
        this.Descripcion=desc_x;
    }
    public void setMax(int max_x){
        this.Cant_max_espectadores=max_x;
    }
    public void setMin(int min_x){
        this.Cant_min_espectadores=min_x;
    }
    public void setUrl(String url_x){
        this.Url=url_x;
    }
    public void setCosto(int costo_x){
        this.Costo=costo_x;
    }
}
