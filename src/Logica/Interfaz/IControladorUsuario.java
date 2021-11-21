
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
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
public interface IControladorUsuario {
    //public abstract Map<String, Usuario> getUsuarios();
    //public abstract void addEspectador(String nickname, String nombre, String apellido, String email, DTFecha nacimiento);
    public abstract void obtenerEspectadores(DefaultTableModel modelo);
    public abstract void obtenerEspectadoresBuscador(DefaultTableModel modelo,String nick);
    public abstract void obtenerArtistas(DefaultTableModel modelo);
    public abstract ArrayList<String> obtenerArtistasNicks(); // Nuevo WebVersion PABLO
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
    public abstract boolean login(String user, String password); //Nuevo WebVersion FEDERICO
    public abstract boolean controlFecha(int dia, int mes,int anio);
    public abstract Map<String, Usuario> obtenerUsuarios(); //Nuevo WebVersion FEDERICO
    public abstract Artista obtenerArtista(int idUsuario); //Nuevo WebVersion FEDERICO
    public abstract Artista obtenerArtistaPorNick(String nickUsuario); //Nuevo WebVersion MILTON
    public abstract Usuario obtenerEspectador(int idUsuario); //Nuevo WebVersion FEDERICO
    public abstract String esEspectador(String nickname); //Nuevo WebVersion
    public abstract Usuario obtenerEspectadorPorNick(String nickUsuario); //Nuevo WebVersion MILTON
    public abstract int getIdEspectadorPorNick(String nickUsuario); //Nuevo WebVersion MILTON
    public abstract void modificarUsuarioEspectador(String usuNick,String usuMail, String usuNombre, String usuApelliedo, Date usuNacimiento, String usuImagen); //Nuevo WebVersion FEDERICO
    public abstract void modificarUsuarioArtista(String usuNick,String usuMail, String usuNombre, String usuApelliedo, Date usuNacimiento, String usuImagen, String artDescripcion, String artBiografia, String artUrl); //Nuevo WebVersion FEDERICO
    public abstract boolean addArtista(String nickname, String descripcion, String biografia, String link); //Nuevo WebVersion FEDERICO
    public abstract Map<String, Usuario> getArtistas(); // Nuevo WebVersion PABLO
    public abstract int getIdUsuarioUsingIdArtista(int idUsuario); //Nuevo WebVersion FEDERICO
    public abstract void seguirUsuario(String usuario, String usuarioASeguir); // Para el caso de uso "Seguir a un usuario"
    public abstract void dejarDeSeguirUsuario(String usuario, String usuarioADejar); // Para el caso de uso "Dejar de seguir a un usuario"
    public abstract boolean loSigo(String yo, String usuario);
    public abstract int getSeguidores(int idUser); //Nuevo API-REST MILTON
    public abstract int getSeguidos(int idUser); //Nuevo API-REST MILTON
    public abstract int getEspectadorIdPorNick(String nick);
    
}
