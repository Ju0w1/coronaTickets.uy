package Logica.Clases;

import Logica.DataTypes.DTFecha;
import java.io.Serializable;

public class Artista extends Usuario implements Serializable{
    private String descripcion;
    private String biografia;
    private String linkWeb;
    public Artista(String nickname, String nombre, String apellido, String email, DTFecha nacimiento, String descripcion, String biografia, String linkWeb){
        super (nickname, nombre, apellido, email, nacimiento);
        this.descripcion=descripcion;
        this.biografia=biografia;
        this.linkWeb=linkWeb;
    }
    
    public Artista(String nickname, String nombre, String apellido, String email, DTFecha nacimiento, String descripcion, String biografia, String linkWeb, String contrasenia, String url_imagen, int seguidores, int seguidos){
        super (nickname, nombre, apellido, email, nacimiento, contrasenia, url_imagen, seguidores, seguidos);
        this.descripcion=descripcion;
        this.biografia=biografia;
        this.linkWeb=linkWeb;
    }
    public Artista(String nick){
        super (nick);
    }
    
    public void setDescripcion (String descripcion){
        this.descripcion=descripcion;
    }
    public void setBiografia (String biografia){
        this.biografia=biografia;
    }
    public void setLinkWeb (String linkWeb){
        this.linkWeb=linkWeb;
    }
    public String getDescripcion (){
         return this.descripcion;
    }
    public String getBiografia (){
         return this.biografia;
    }
    public String getLinkWeb (){
        return this.linkWeb;
    }   
    public Artista(){
        
    }
}
