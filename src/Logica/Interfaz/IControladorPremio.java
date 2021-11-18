package Logica.Interfaz;


import Logica.Clases.Premio;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author facun
 */
public interface IControladorPremio {
   public abstract boolean addPremio (String nickEspectador, String descripcion, String funcion, int cantidad, Date fecha);
   
   public abstract List<String> getFuncionesArtistaRealizadas(String nickArtista, String nomEspectaculo);
   public abstract boolean premiosRealizados (String nomfuncion);
}
