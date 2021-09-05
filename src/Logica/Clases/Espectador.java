package Logica.Clases;

import Logica.DataTypes.DTFecha;

import java.sql.Date;

public class Espectador extends Usuario {
    public Espectador (String nickname, String nombre, String apellido, String email, DTFecha nacimiento){
        super (nickname, nombre, apellido, email, nacimiento);
    }
}
