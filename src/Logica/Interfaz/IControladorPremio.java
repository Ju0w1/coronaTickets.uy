package Logica.Interfaz;


import Logica.Clases.Premio;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author facun
 */
public interface IControladorPremio {
   public abstract boolean addPremio (String descripcion, String espec, int cantidad);
   public abstract boolean premiarEspectadores (String nomFuncion);
   public abstract List<String> getFuncionesArtistaRealizadas(String nickArtista, String nomEspectaculo);
   public abstract boolean premiosRealizados (String nomfuncion);
   public abstract List<String> getEspectadoresPremiados(String nomFuncion);
}
