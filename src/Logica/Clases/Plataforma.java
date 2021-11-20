package Logica.Clases;

import java.io.Serializable;


public class Plataforma implements Serializable{
    private String Nombre;
    private String Descripcion;
    private String Url;
    
    public Plataforma(String nom,String desc,String url){
        this.Nombre=nom;
        this.Descripcion=desc;
        this.Url=url;
    }
    
    public Plataforma() {
        
    }
    //Getters
    public String getNombre(){
        return this.Nombre;
    }
    public String getDescripcion(){
        return this.Descripcion;
    }
    public String getUrl(){
        return this.Url;
    }
    //Setters
    public void setNombre(String nom){
        this.Nombre=nom;
    }
    public void setDesc(String desc){
        this.Descripcion=desc;
    }
    public void setUrl(String url){
        this.Url=url;
    }
}
