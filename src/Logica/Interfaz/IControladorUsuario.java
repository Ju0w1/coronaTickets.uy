
package Logica.Interfaz;

import java.util.Map;
import javax.swing.JList;
import javax.swing.JTextField;
import Logica.Clases.Espectador;
import Logica.Clases.Usuario;
import java.sql.Date;

public interface IControladorUsuario {
    public abstract Map<String, Usuario> getUsuarios();
    public abstract void addEspectador(String nickname, String nombre, String apellido, String email, Date nacimiento);
    public abstract void obtenerEspectadores(JList listEspec);
    public abstract void cargarDatosConsultaEspectador(String seleccion, JTextField nick, JTextField nombre, JTextField apellido, JTextField mail, JTextField nacimiento);
    public abstract void modificarEspectador(String nombre, String apellido, Date fecha);
}
