package Logica.Clases;

import Logica.DataTypes.DTFecha;
import Logica.DataTypes.DTTimeStamp;
import java.sql.Date;




public class Espectaculo {
    
    private String Nombre;
    private int Artista;
    private String Descripcion;
    private int Cant_min_espectadores;
    private int Cant_max_espectadores;
    private String Url;
    private double Costo;
    private int Duracion;
    private Date Fecha_Registro;
    
    public Espectaculo(String nombre,int Artista,String descr,int min,int max, String url, double costo,int duracion,Date Fregistro){
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
    
    public Espectaculo(int id, int organizador, int plataforma, String nombre, String descripcion, double duracion, int espectmax, int especmin, String url, String fecha, double costo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //Getters
    public String getNombre(){
        return this.Nombre;
    }
    public int getArtista(){
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
    public double getCosto(){
        return this.Costo;
    }
    public int getDuracion(){
        return this.Duracion;
    }
    public Date getFecha(){
        return this.Fecha_Registro;
    }
    
    //Setters
    public void setNombre(String nom_x){
        this.Nombre=nom_x;
    }
    public void setArtista(int artista_x){
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
    public void setFecha(Date fecha){
        this.Fecha_Registro=fecha;
    }
}
