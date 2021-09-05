package Logica.Clases;

import java.sql.Date;

public class Registro {
    private String nickEspectador;
    private String nomFuncion;
    private Date fechaRegistro;
    private Boolean canjeado;
    
    public Registro (String nickEspectador, String nomFuncion, Date fechaRegistro, Boolean canjeado){
        this.nickEspectador=nickEspectador;
        this.nomFuncion=nomFuncion;
        this.fechaRegistro=fechaRegistro;
        this.canjeado=canjeado;
    }
    
    public String getEspectador(){
        return this.nickEspectador;
    }
    
    public String getFuncion(){
        return this.nomFuncion;
    }
    
    public Date getFecha(){
        return this.fechaRegistro;
    }
    
    public Boolean getCanjeado(){
        return this.canjeado;
    }
    
    public void setEspectador(String nickEspectador){
        this.nickEspectador=nickEspectador;
    }
    
    public void setFuncion(String nomfuncion){
        this.nomFuncion=nomfuncion;
    }
    
    public void setFecha(Date fechaRegistro){
        this.fechaRegistro=fechaRegistro;
    }
    
    public void setCanjeado(Boolean canjeado){
        this.canjeado=canjeado;
    }
}
