package Logica;
import Logica.Interfaz.IControladorUsuario;
import Logica.Interfaz.IControladorEspectaculo;
import Logica.Controladores.ControladorEspectaculos;
import Logica.Controladores.ControladorUsuario;
import Logica.Interfaz.IControladorPaquete;
import Logica.Controladores.ControladorPaquete;
import Logica.Interfaz.IControladorFuncion;
import logica.Controladores.ControladorFuncion;

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

    public IControladorPaquete getIControladorPaquete() {
        IControladorPaquete ControladorP = ControladorPaquete.getInstance();
        return ControladorP; //To change body of generated methods, choose Tools | Templates.
    }
    public IControladorFuncion getIControladorFuncion() {
        IControladorFuncion ControladorF = ControladorFuncion.getInstance();
        return ControladorF; //To change body of generated methods, choose Tools | Templates.
    }

     public IControladorUsuario getIControladorUsuario() {
        IControladorUsuario ControladorU = ControladorUsuario.getInstance();
        return ControladorU; //To change body of generated methods, choose Tools | Templates.
    }
    
}
