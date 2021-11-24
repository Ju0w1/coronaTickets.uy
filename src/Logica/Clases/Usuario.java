package Logica.Clases;

import Logica.DataTypes.DTFecha;
import java.io.Serializable;
import java.sql.Date;

public class Usuario implements Serializable{
    private String nickname;
    private String nombre;
    private String apellido;
    private String email;
    private DTFecha nacimiento;
    private String contrasenia;
    private String url_imagen;
    private int seguidores;
    private int seguidos;
    
    public Usuario(String nickname, String nombre, String apellido, String email, DTFecha nacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nickname= nickname;
        this.email= email;
        this.nacimiento= nacimiento;
    }
    
    // PARA PRUEBA DE LOGIN
    public Usuario() {

    }
    
    public Usuario(String nickname, String nombre, String apellido, String email, String contrasenia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nickname= nickname;
        this.email= email;
        this.contrasenia = contrasenia;
    }

    public Usuario(String string, String string0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Usuario(String nickname, String nombre, String url_imagen) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.url_imagen = url_imagen;
    }
    
    
    public void setNickname(String nickname){
        this.nickname= nickname;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    
    public void setEmail(String email){
        this.email= email;
    }
    
    public void setNacimiento(DTFecha nacimiento){
        this.nacimiento= nacimiento;
    }
    
    public void setContrasenia(String contra){
        this.contrasenia = contra;
    }
    
    public void setImagen(String img){
        this.url_imagen = img;
    }
    
    public String getNickname(){
         return this.nickname;
    }
    
    public String getNombre(){
         return this.nombre;
    }
    
    public String getApellido(){
         return this.apellido;
    }
    
    public String getEmail(){
         return this.email;
    }
    
    public DTFecha getNacimiento(){
        return this.nacimiento;
    }
    
    public String getContrasenia(){
        return this.contrasenia;
    }
    
    public String getImagen(){
        return this.url_imagen;
    }
    
    public Usuario(String nickname, String nombre, String apellido, String email, DTFecha nacimiento, String contrasenia, String url_imagen, int seguidores, int seguidos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nickname= nickname;
        this.email= email;
        this.nacimiento= nacimiento;
        this.contrasenia=contrasenia;
        this.url_imagen=url_imagen;
        this.seguidores=seguidores;
        this.seguidos=seguidos;
    }
    public Usuario(String nickname, String nombre, String apellido, String email, DTFecha nacimiento, String url_imagen) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nickname= nickname;
        this.email= email;
        this.nacimiento= nacimiento;
        this.url_imagen=url_imagen;
    }
    
    
    public int getSeguidores (){
        return this.seguidores;
    }
    public int getSeguidos (){
        return this.seguidos;
    }
    public Usuario(String nick){
        this.nickname=nick;
    }
}
