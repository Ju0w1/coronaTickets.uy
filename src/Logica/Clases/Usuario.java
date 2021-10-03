package Logica.Clases;

import Logica.DataTypes.DTFecha;

public class Usuario {
    private String nickname;
    private String nombre;
    private String apellido;
    private String email;
    private DTFecha nacimiento;
    private String contrasenia;
    private String url_imagen;
    
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
    
}
