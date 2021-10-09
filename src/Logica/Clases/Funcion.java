package Logica.Clases;

import java.sql.Date;
import java.sql.Time;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class Funcion {
        private String nombre;
        private Date fecha;
        private Time horaInicio;
        private Date fechaRegistro;
        private Espectaculo espectaculo;
        private Map<String, Artista> artistas;
        private String urlImagen;
        private boolean estado;
        
        public Funcion(String nombre, Date fecha, Time horaInicio, Date fechaRegistro, Espectaculo espectaculo, Map<String, Artista> artistas, String urlImagen){
            this.nombre= nombre;
            this.fecha= fecha;
            this.horaInicio= horaInicio;
            this.fechaRegistro= fechaRegistro;
            this.espectaculo=espectaculo;
            this.artistas=artistas;
            this.urlImagen=urlImagen;
        }
        
        public Funcion(String nombre, Date fecha, Time horaInicio, Date fechaRegistro){
            this.nombre= nombre;
            this.fecha= fecha;
            this.horaInicio= horaInicio;
            this.fechaRegistro= fechaRegistro;
        }
        
        public void setNombre(String nombre_){
            this.nombre=nombre_;
        }
        
        public void setFecha(Date fecha_){
            this.fecha= fecha_;
        }
        
        public void setHoraInicio(Time horaInicio_){
            this.horaInicio= horaInicio_;
        }
        
        public void setFechaRegistro(Date fechaRegistro_){
            this.fechaRegistro=fechaRegistro_;
        }
        
        public void setArtistas(Map<String, Artista> artistas){
            this.artistas=artistas;
        }
        public void setUrlImagen (String urlImagen){
            this.urlImagen=urlImagen;
        }
        
        public void setEstado(boolean estado_){
            this.estado=estado_;
        }
  
        public String getNombre(){
            return this.nombre;
        }
        
        public Date getFecha(){
            return this.fecha;
        }
        
        public Time getHoraInicio(){
            return this.horaInicio;
        }
        
        public Date getFechaRegistro(){
            return this.fechaRegistro;
        }
        
        public Map<String, Artista> getArtistas(){
            return this.artistas;
        }
        public Espectaculo getEspectaculo(){
            return this.espectaculo;
        }
        public String getUrlImagen (){
            return this.urlImagen;
        }
        
        public Boolean getEstado(){
            return this.estado;
        }
        
        public Funcion(String nombre, Date fecha, Time horaInicio, Date fechaRegistro, Espectaculo espectaculo, Map<String, Artista> artistas, String imagen_, boolean estado_){
            this.nombre= nombre;
            this.fecha= fecha;
            this.horaInicio= horaInicio;
            this.fechaRegistro= fechaRegistro;
            this.espectaculo=espectaculo;
            this.artistas=artistas;
            this.urlImagen=imagen_;
            this.estado=estado_;
        }
}