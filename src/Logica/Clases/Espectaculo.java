package Logica.Clases;

import Logica.DataTypes.DTFecha;
import Logica.DataTypes.DTTimeStamp;
import java.sql.Date;
import java.util.Map;




public class Espectaculo {
    private String Nombre;
    private int Artista;
    private String Descripcion;
    private int Cant_min_espectadores;
    private int Cant_max_espectadores;
    private String Url;
    private double Costo;
    private double Duracion;
    private Date Fecha_Registro;
    private String plataforma;
    private String estado;
    private Map<String, Categoria> categorias;
    private String urlImagen;
    
    public Espectaculo(){
        
    }
    
    public Espectaculo(String nombre, String plataforma){
        this.Nombre=nombre;
        this.plataforma=plataforma;
    }
    
    public Espectaculo(String nombre,int Artista,String descr,int min,int max, String url, double costo,double duracion,Date fRegistro, String plataforma, String estado, Map<String, Categoria> categorias, String urlImagen){
        this.Nombre=nombre;
        this.Artista=Artista;
        this.Descripcion=descr;
        this.Cant_min_espectadores=min;
        this.Cant_max_espectadores=max;
        this.Url=url;
        this.Costo=costo;
        this.Duracion=duracion;
        this.Fecha_Registro=fRegistro;
        this.plataforma=plataforma;
        this.estado=estado;
        this.categorias=categorias;
        this.urlImagen=urlImagen;
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
    public double getDuracion(){
        return this.Duracion;
    }
    public Date getFecha(){
        return this.Fecha_Registro;
    }
    public String getPlataforma(){
        return this.plataforma;
    }
    public String getEstado (){
        return this.estado;
    }
    public Map<String, Categoria> getCategoria (){
        return this.categorias;
    }
    public String getUrlIamgen (){
        return this.urlImagen;
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
    
    public Espectaculo(String nombre,int Artista,String descr,int min,int max, String url, double costo,double duracion,Date Fregistro, String estado, String url_imagen){
        this.Nombre=nombre;
        this.Artista=Artista;
        this.Descripcion=descr;
        this.Cant_min_espectadores=min;
        this.Cant_max_espectadores=max;
        this.Url=url;
        this.Costo=costo;
        this.Duracion=duracion;
        this.Fecha_Registro=Fregistro;
        this.estado=estado;
        this.urlImagen=url_imagen;
    }
    
    public Espectaculo(String nombre,int Artista,String descr,int min,int max, String url, double costo,double duracion,Date Fregistro, String estado, String url_imagen, String plataforma){
        this.Nombre=nombre;
        this.Artista=Artista;
        this.Descripcion=descr;
        this.Cant_min_espectadores=min;
        this.Cant_max_espectadores=max;
        this.Url=url;
        this.Costo=costo;
        this.Duracion=duracion;
        this.Fecha_Registro=Fregistro;
        this.estado=estado;
        this.urlImagen=url_imagen;
        this.plataforma = plataforma;
    }
    
    public void setEstado (String estado){
        this.estado=estado;
    }
    public void setPlataforma (String plataforma){
        this.plataforma=plataforma;
    }
    public void setCategoria (Map<String, Categoria> categorias){
        this.categorias=categorias;
    }
    public void setUrlImagen (String urlImagen){
        this.urlImagen=urlImagen;
    }
}
