/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Interfaces;

import Logica.DataTypes.DTFecha;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;
import logica.Clases.Espectador;
import logica.Clases.Usuario;

/**
 *
 * @author LucasCiceri
 */
public interface IControladorUsuario {
    public abstract Map<String, Usuario> getUsuarios();
    public abstract void agregarEspectador(Espectador espectador);
    public abstract void obtenerEspectadores(JList listEspec);
    public abstract void cargarDatosConsultaEspectador(String seleccion, JTextField nick, JTextField nombre, JTextField apellido, JTextField mail, JTextField nacimiento);
    public abstract void modificarEspectador(String nombre, String apellido, DTFecha fecha);
}
