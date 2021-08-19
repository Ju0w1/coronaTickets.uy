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
public class DTUsuario {
    // atributos
    private String nickname, nombre, apellido, email;
    private DTFecha nacimiento;

    public DTUsuario(String nickname, String nombre, String apellido, String email, DTFecha nacimiento) {
        this.nickname = nickname;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.nacimiento = nacimiento;
    }
    

    public String getNickname() {
        return nickname;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public DTFecha getNacimiento() {
        return nacimiento;
    }
    
    
    
}
