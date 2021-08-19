
package Logica.Interfaz;
import Logica.DataTypes.DTFecha;
import java.util.Map;
import javax.swing.JList;
import javax.swing.JTextField;
import logica.Clases.Espectador;
import logica.Clases.Usuario;
public interface IControladorUsuario {
    public abstract Map<String, Usuario> getUsuarios();
    public abstract void addEspectador(String nickname, String nombre, String apellido, String email, DTFecha nacimiento);
    public abstract void obtenerEspectadores(JList listEspec);
    public abstract void cargarDatosConsultaEspectador(String seleccion, JTextField nick, JTextField nombre, JTextField apellido, JTextField mail, JTextField nacimiento);
    public abstract void modificarEspectador(String nombre, String apellido, DTFecha fecha);
}
