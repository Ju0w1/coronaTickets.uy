
package Logica.DataTypes;

public class DTFecha {
    //atributos
    private int dia,mes,anio;
    //constructor
    public DTFecha(){}
    
    public DTFecha(int dia, int mes, int anio){
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }
    
    //getters
    public int getDia(){
        return this.dia;
    }
    public int getMes(){
        return this.mes;
    }
    public int getAnio(){
        return this.anio;
    }
    
}