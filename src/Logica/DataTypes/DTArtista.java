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
public class DTArtista extends DTUsuario{
    // atributos
    private String descripcion, biografia, link_web;
    
    //constructor
    public DTArtista(String nickname, String nombre, String apellido, String email, DTFecha nacimiento, String descripcion, String biografia, String link_web) {
        super(nickname, nombre, apellido, email, nacimiento);
        this.descripcion = descripcion;
        this.biografia = biografia;
        this.link_web = link_web;
    }
    

    public String getDescripcion() {
        return descripcion;
    }

    public String getBiografia() {
        return biografia;
    }

    public String getLink_web() {
        return link_web;
    }

    
}
