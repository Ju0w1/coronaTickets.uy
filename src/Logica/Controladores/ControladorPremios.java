package Logica.Controladores;

import Logica.Interfaz.IControladorPremio;
import Logica.Servicio.FuncionServicios;
import Logica.Servicio.PremioServicios;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author facun
 */
public class ControladorPremios implements IControladorPremio {
    private static ControladorPremios instancia;
    private PremioServicios servicioPremios;
    //private FuncionServicios servicioFunciones;
    
    public ControladorPremios() {
        this.servicioPremios= new PremioServicios();
    }
    
    public static ControladorPremios getInstance() {
        if (instancia == null) {
            instancia = new ControladorPremios();
        }
        return instancia;
    }
    
    @Override
    public boolean addPremio (String nickEspectador, String descripcion, String nomfuncion, int cantidad, Date fecha){
        if (this.servicioPremios.addPremio(descripcion, nomfuncion, cantidad)){
            return true;
        } else {
            return false;
        }
    }
    
    public void premiarEspectadores (String nomFuncion, String nickEspectador){
        long millis=System.currentTimeMillis();  //Saca fecha actual
        Date fechaActual=new Date(millis);
        this.servicioPremios.getEspectadoresFuncion;
        this.servicioPremios.premiarEspectador();
    }
    
    public List<String> getFuncionesArtistaRealizadas(String nickArtista, String nomEspectaculo){
        List<String> funciones = new ArrayList<>();
        funciones = this.servicioPremios.getFuncionesArtistaRealizadas(nickArtista, nomEspectaculo);
        return funciones;
    }
    
    public boolean premiosRealizados (String nomfuncion){
        if(this.servicioPremios.premiosRealizados(nomfuncion)){
            return true;
        }
        else{
            return false;
        }
    }
  
}
