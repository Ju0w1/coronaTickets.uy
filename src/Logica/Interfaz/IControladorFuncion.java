
package Logica.Interfaz;
import Logica.Clases.Artista;
import Logica.Clases.Espectaculo;
import Logica.DataTypes.DTFecha;
import Logica.DataTypes.DTTimeStamp;
import java.util.Map;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextField;
import Logica.Clases.Funcion;
import java.sql.Date;
import java.sql.Time;

public interface IControladorFuncion {
    public abstract boolean addFuncion(String espec_id, String nombre, DTFecha fecha_registro, DTTimeStamp hora_inicio, DTFecha fecha_comienzo, Map<String,Artista> artistas);
    public abstract void obtenerPlataformas(JComboBox plataformas);
    public abstract void obtenerArtistas(JList listEspec);
    public abstract void obtenerEspectaculo(JComboBox espectaculos, String nombrePlataforma);
    public abstract void Prueba(String nombre_artista,String id_funcion,String id_artista,String nombre_funcion,DTFecha funcion_vigente);
    public abstract Artista obtenerArtista(String nickname);
    public abstract Map<String, Funcion> getRegistroDeFuncionesDeUsuario(int idUsuario); //Nuevo WebVersion
    public abstract void AltaFuncionV2(String nombre_, Date fecha_, Time horaInicio_, Date fechaRegistro_, Espectaculo espectaculo_, Map<String, Artista> artistas_, String imagen_, boolean estado_);
}
