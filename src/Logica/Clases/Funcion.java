/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Clases;

import Logica.DataTypes.DTFecha;
import Logica.DataTypes.DTTimeStamp;
import java.sql.Date;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class Funcion {
        private String nombre;
        private Date fecha;
        private DTTimeStamp horaInicio;
        private Date fechaRegistro;
        private Espectaculo espectaculo;
        private Map<String, Artista> artistas;
        
        public Funcion(String nombre, Date fecha, DTTimeStamp horaInicio, Date fechaRegistro, Espectaculo espectaculo, Map<String, Artista> artistas){
            this.nombre= nombre;
            this.fecha= fecha;
            this.horaInicio= horaInicio;
            this.fechaRegistro= fechaRegistro;
            this.espectaculo=espectaculo;
            this.artistas=artistas;
        }
        
        public void setNombre(String nombre_){
            this.nombre=nombre_;
        }
        
        public void setFecha(Date fecha_){
            this.fecha= fecha_;
        }
        
        public void setHoraInicio(DTTimeStamp horaInicio_){
            this.horaInicio= horaInicio_;
        }
        
        public void setFechaRegistro(Date fechaRegistro_){
            this.fechaRegistro=fechaRegistro_;
        }
        
        public void setArtistas(Map<String, Artista> artistas){
            this.artistas=artistas;
        }
        
        public String getNombre(){
            return this.nombre;
        }
        
        public Date getFecha(){
            return this.fecha;
        }
        
        public DTTimeStamp getHoraInicio(){
            return this.horaInicio;
        }
        
        public Date getFechaRegistro(){
            return this.fechaRegistro;
        }
        
        public Map<String, Artista> getArtistas(){
            return this.artistas;
        }
    
}
