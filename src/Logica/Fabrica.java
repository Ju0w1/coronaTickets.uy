/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import logica.Controladores.ControladorUsuario;
import logica.Interfaces.IControladorUsuario;


import Logica.Interfaz.IControladorEspectaculo;
import logica.Controladores.ControladorEspectaculos;

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
    
     public IControladorEspectaculo getIControladorEspectaculo() {
        IControladorEspectaculo ControladorE = ControladorEspectaculos.getInstance();
        return ControladorE; //To change body of generated methods, choose Tools | Templates.
    }

    private Fabrica() {
    }
    
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
