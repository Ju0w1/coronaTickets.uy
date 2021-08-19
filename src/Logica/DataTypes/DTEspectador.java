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
public class DTEspectador extends DTUsuario{

    public DTEspectador(String nickname, String nombre, String apellido, String email, DTFecha nacimiento) {
        super(nickname, nombre, apellido, email, nacimiento);
    }
    
}
