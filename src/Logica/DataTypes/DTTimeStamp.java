/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.Clases;

/**
 *
 * @author pabli
 */
public class DTTimeStamp {
    //atributos
    private DTFecha fecha;
    private int hora,minuto,segundo;
    
    //constructor
    public DTTimeStamp(){}
    
    public DTTimeStamp(DTFecha fecha,int hora, int minuto, int segundo){
        this.fecha = fecha;
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }
    
    //getters
    public DTFecha getFecha(){
        return this.fecha;
    }
    public int getHora(){
        return this.hora;
    }
    public int getMinuto(){
        return this.minuto;
    }
    public int getSegundo(){
        return this.segundo;
    }
        
}
