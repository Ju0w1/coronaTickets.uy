package Logica.Interfaz;
import Logica.DataTypes.DTFecha;
import java.util.Map;
import javax.swing.JList;
import javax.swing.JTextField;

import Logica.Clases.Paquete;

public interface IControladorPaquete {
    public abstract Map<String, Paquete> getPaquetes();
    //public abstract void addEspectador(String nickname, String nombre, String apellido, String email, DTFecha nacimiento);
    public abstract void obtenerPaquete(JList listEspec);
    public abstract void cargarDatosConsultaPaquete(String seleccion, JTextField nombre, JTextField descripcion, JTextField Finicio, JTextField Ffinal, JTextField costo, JTextField descuento, JTextField FCompra);
    //public abstract void modificarPaquete(String nombre, String descripcion, DTFecha fechaInicio, DTFecha fechaFinal, float costo, float descuento,DTFecha fechaCompra);
    public abstract void obtenerPaqueteEspectaculo(JList listEspec, String espectaculoNombre);
    public abstract boolean getEspectaculos(String nombrePaquete, JList listEspectaculos);
    public abstract Map<String, Paquete> getPaquetesQueComproUsuario(int idUsuario);
    public Map<String, Paquete> obtenerMapPaquetesVigentesEspectaculoUsuario (String nickUsuario, String nomEspectaculo);
//    public abstract Paquete PruebaPaquete(String ID_paq);
    public abstract Map<String, Paquete> getPaquetesV2();
    public abstract void altaPaquete(String nombre,String fechaInicio, String fechaFin,String fechaCreado,double descuento,String descripcion, String imagen); //Web Version PABLO
    //123
    public abstract boolean addPaquete(String nombre, String descripcion, DTFecha fechaInicio, DTFecha fechaFin, Float descuento, String imagen); // Para el caso de uso crear paquete de espectaculos
    public abstract void actualizarPaquete(String nombre, String descripcion, DTFecha fechaInicio, DTFecha fechaFin, Float descuento, String imagen); // En caso de que exista un paquete de espectáculos con dicho nombre, el artista puede modificar los datos que ingresó
    public abstract Map<String, Paquete> getPaquetesArtistas(String nick_);
}
