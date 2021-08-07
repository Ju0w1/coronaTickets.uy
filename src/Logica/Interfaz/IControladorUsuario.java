/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Interfaces;

import java.util.Map;
import logica.Clases.Usuario;

/**
 *
 * @author LucasCiceri
 */
public interface IControladorUsuario {
    public abstract Map<String, Usuario> getUsuarios();
}
