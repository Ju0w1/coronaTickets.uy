/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Clases;

import Logica.DataTypes.DTFecha;
import Logica.DataTypes.DTTimeStamp;

/**
 *
 * @author Admin
 */
public class Funcion {
        private String nombre;
        private DTFecha fecha;
        private DTTimeStamp horaInicio;
        private DTFecha fechaRegistro;
        
        public Funcion(String nombre_, DTFecha fecha_, DTTimeStamp horaInicio_, DTFecha fechaRegistro_){
            this.nombre= nombre_;
            this.fecha= fecha_;
            this.horaInicio= horaInicio_;
            this.fechaRegistro= fechaRegistro_;
        }
        
        public void setNombre(String nombre_){
            this.nombre=nombre_;
        }
        
        public void setFecha(DTFecha fecha_){
            this.fecha= fecha_;
        }
        
        public void setHoraInicio(DTTimeStamp horaInicio_){
            this.horaInicio= horaInicio_;
        }
        
        public void setFechaRegistro(DTFecha fechaRegistro_){
            this.fechaRegistro=fechaRegistro_;
        }
        
        public String getNombre(){
            return this.nombre;
        }
        
        public DTFecha getFecha(){
            return this.fecha;
        }
        
        public DTTimeStamp getHoraInicio(){
            return this.horaInicio;
        }
        
        public DTFecha getFechaRegistro(){
            return this.fechaRegistro;
        }
        
    
}
