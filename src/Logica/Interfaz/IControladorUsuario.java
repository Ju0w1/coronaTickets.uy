
package Logica.Interfaz;
import Logica.Clases.Artista;
import Logica.DataTypes.DTFecha;
import java.util.Map;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import Logica.Clases.Espectador;
import Logica.Clases.Usuario;
import java.sql.Date;
import javax.swing.table.DefaultTableModel;
public interface IControladorUsuario {
    //public abstract Map<String, Usuario> getUsuarios();
    //public abstract void addEspectador(String nickname, String nombre, String apellido, String email, DTFecha nacimiento);
    public abstract void obtenerEspectadores(DefaultTableModel modelo);
    public abstract void obtenerEspectadoresBuscador(DefaultTableModel modelo,String nick);
    public abstract void obtenerArtistas(DefaultTableModel modelo);
    public abstract void obtenerArtistasBuscador(DefaultTableModel tablaModelo, String nick);
    //public abstract void obtenerEspectadores(JList listEspec, DefaultTableModel modelo);
    public abstract Map<String, Usuario> getUsuarios();
    public abstract boolean addEspectador(String nickname, String nombre, String apellido, String email, DTFecha nacimiento);
    public abstract boolean addEspectador(String nickname, String password1, String email, String nombre, String apellido, String nacimiento, String imagen);
    public abstract boolean addArtista(String nickname, String nombre, String apellido, String email, DTFecha nacimiento, String descripcion, String biografia, String link);
    public abstract void cargarDatosConsultaEspectador(String seleccion, JTextField nick, JTextField nombre, JTextField apellido, JTextField mail, JTextField nacimiento);
    public abstract void cargarDatosConsultaArtista(String seleccion, JTextField nick, JTextField nombre, JTextField apellido, JTextField mail, JTextField nacimiento, JTextArea areaDescripcion, JTextArea areaBiografia, JTextField url);
    public abstract void modificarEspectador(String email,String nombre, String apellido, DTFecha fecha);
    public abstract void modificarArtista(String email,String nombre, String apellido, DTFecha fecha, String descripcion, String biografia, String url);
    //public abstract static boolean contains(final int[] arr, final int key);
    public abstract boolean login(String user, String password);
    public abstract boolean controlFecha(int dia, int mes,int anio);
    public abstract Map<String, Usuario> obtenerUsuarios(); //Nuevo WebVersion
    public abstract Artista obtenerArtista(int idUsuario); //Nuevo WebVersion
    public abstract Artista obtenerArtistaPorNick(String nickUsuario); //Nuevo WebVersion MILTON
    public abstract Usuario obtenerEspectador(int idUsuario); //Nuevo WebVersion
    public abstract String esEspectador(String nickname); //Nuevo WebVersion
    public abstract Usuario obtenerEspectadorPorNick(String nickUsuario); //Nuevo WebVersion MILTON
    public abstract int getIdEspectadorPorNick(String nickUsuario); //Nuevo WebVersion MILTON
}
