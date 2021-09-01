package Logica.Clases;

import java.sql.Date;

public class Espectador extends Usuario {
    public Espectador (String nickname, String nombre, String apellido, String email, Date nacimiento){
         super (nickname, nombre, apellido, email, nacimiento);
    }

}
