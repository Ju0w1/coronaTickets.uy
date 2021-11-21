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
    

    public boolean addPremio (String descripcion, String nomEspec, int cantidad){ //añade un premio a la correspondiente tabla
        if (this.servicioPremios.addPremio(descripcion, nomEspec, cantidad)){
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public boolean premiarEspectadores (String nomFuncion){ //Premia a los espectadores de una funcion teniendo en cuenta lo descrito en la letra
        long millis=System.currentTimeMillis();  //Saca fecha actual
        Date fechaActual=new Date(millis);
        List<String> espectadores= new ArrayList<>();
        espectadores=this.servicioPremios.getEspectadoresFuncion(nomFuncion);
        if (espectadores!=null){
            int cantPremios=this.servicioPremios.getCantidadPremios(nomFuncion);
            if (cantPremios>espectadores.size()){
                for (int i = 0; i < espectadores.size(); i++) {
                    System.out.println(espectadores.get(i));
                    this.servicioPremios.premiarEspectador(nomFuncion, espectadores.get(i), fechaActual);
                }
            }
            else{
                for (int i = 0; i < cantPremios; i++) {
                    System.out.println(espectadores.get(i));
                    this.servicioPremios.premiarEspectador(nomFuncion, espectadores.get(i), fechaActual);
                }
            }
            return true;
        }
        else{
            return false;
        }
    }
    
    @Override
    public List<String> getFuncionesArtistaRealizadas(String nickArtista, String nomEspectaculo){ //Devuleve una lista de las funciones del artista que ya ocurrieron
        List<String> funciones = new ArrayList<>();
        funciones = this.servicioPremios.getFuncionesArtistaRealizadas(nickArtista, nomEspectaculo);
        return funciones;
    }
    
    @Override
    public boolean premiosRealizados (String nomfuncion){ //Deevulve true si la premiacion de una funcion ya fue realizada
        if(this.servicioPremios.premiosRealizados(nomfuncion)){
            return true;
        }
        else{
            return false;
        }
    }
    
    @Override
    public List<String> getEspectadoresPremiados(String nomFuncion){ //Devuelve una lista de espectadores premiados respecto a una funcion
        List<String> funciones = new ArrayList<>();
        funciones = this.servicioPremios.getEspectadoresPremiados(nomFuncion);
        return funciones;
    }
  
}
