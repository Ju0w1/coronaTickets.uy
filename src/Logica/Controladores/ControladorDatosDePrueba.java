/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Controladores;

import Logica.Interfaz.IControladorDatosDePrueba;
import Logica.Servicio.DatosDePruebaServicio;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pabli
 */
public class ControladorDatosDePrueba implements IControladorDatosDePrueba{
    private static ControladorDatosDePrueba instancia;
    private DatosDePruebaServicio servicioDatosDePrueba;
    
    public ControladorDatosDePrueba() {
        this.servicioDatosDePrueba= new DatosDePruebaServicio();
    }
    
    public static ControladorDatosDePrueba getInstance() {
        if (instancia == null) {
            instancia = new ControladorDatosDePrueba();
        }
        return instancia;
    }
    
    
    public void cargarDatosDePrueba(){
        this.servicioDatosDePrueba.cargarDatosDePrueba();
    }
}
