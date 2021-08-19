/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;
import logica.Controladores.ControladorUsuario;
import logica.Interfaces.IControladorUsuario;
/**
 *
 * @author pabli
 */
public class Fabrica {
    
    private static Fabrica instancia;
    public static Fabrica getInstance() {
        if (instancia == null) {
            instancia = new Fabrica();
        }
        return instancia;
    }
    
     public IControladorUsuario getIControladorUsuario() {
        IControladorUsuario ControladorU = ControladorUsuario.getInstance();
        return ControladorU; //To change body of generated methods, choose Tools | Templates.
    }
     
    private Fabrica() {
    }
    
}
