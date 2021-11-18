package Logica.DataTypes;

import Logica.Clases.Funcion;
import Logica.Clases.Usuario;
import java.sql.Date;

/**
 *
 * @author facun
 */
public class DTPremio {
    Usuario espectador;
    String descripcion;
    Funcion funcion;
    int cantidad;
    Date fecha;
    
    public DTPremio(Usuario espectador, String descripcion, Funcion funcion, Date fecha){
        this.espectador=espectador;
        this.descripcion=descripcion;
        this.funcion=funcion;
        this.fecha=fecha;
    }
    
    //Getters
    public Usuario getEspectador(){
        return this.espectador;
    }
    
    public String getDescripcion(){
        return this.descripcion;
    }
    
    public Funcion getFuncion(){
        return this.funcion;
    }
    
    public Date getFecha(){
        return this.fecha;
    }
    
    public int getCantidad(){
        return this.cantidad;
    }
    
    //Setters
    public void setEspectador(Usuario espectador){
        this.espectador=espectador;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion=descripcion;
    }
    
    public void setFuncion(Funcion funcion){
        this.funcion=funcion;
    }
    
    public void setFecha(Date fecha){
        this.fecha=fecha;
    }
    
    public void setCantidad(int cantidad){
        this.cantidad=cantidad;
    }
}
