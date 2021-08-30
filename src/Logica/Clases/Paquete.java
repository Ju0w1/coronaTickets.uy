/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Clases;

import Logica.DataTypes.DTFecha;

/**
 *
 * @author Admin
 */
public class Paquete {
    private String Nombre;
    private String Descripcion;
    private DTFecha Fecha_Inicio;
    private DTFecha Fecha_Fin;
    private Float Costo;
    private Float Descuento;
    private DTFecha Fecha_Compra;
    
    public Paquete(String nombre_, String Descripcion_, DTFecha Fecha_Inicio_, DTFecha Fecha_Fin_, Float Costo_, Float Descuento_, DTFecha Fecha_Compra_) {
        this.Nombre=nombre_;
        this.Descripcion=Descripcion_;
        this.Fecha_Inicio= Fecha_Inicio_;
        this.Fecha_Fin= Fecha_Fin_;
        this.Costo= Costo_;
        this.Descuento= Descuento_;
        this.Fecha_Compra= Fecha_Compra_;
    }
    
    public void setNombre(String nombre){
        this.Nombre= nombre;
    }
    
    public void setDescripcion(String descripcion){
        this.Descripcion= descripcion;
    }
    
    public void setFecha_Inicio(DTFecha fecha_inicio){
        this.Fecha_Inicio= fecha_inicio;
    }
    
    public void setFecha_Fin(DTFecha fecha_fin){
        this.Fecha_Fin=fecha_fin;
    }
    
    public void setCosto(Float costo){
        this.Costo=costo;
    }
    
    public void setDescuento(Float descuento){
        this.Descuento=descuento;
    }
    
    public String getNombre(){
        return this.Nombre;
    }
    
    public String getDescripcion(){
        return this.Descripcion;
    }
    
    public DTFecha getFecha_Inicio(){
        return this.Fecha_Inicio;
    }
    
    public DTFecha getFecha_Fin(){
        return this.Fecha_Fin;
    }
    
    public Float getCosto(){
        return this.Costo;
    }
    
    public Float getDescuento(){
        return this.Descuento;
    }
    public void setFecha_Compra(DTFecha fecha_compra){
        this.Fecha_Compra= fecha_compra;
    }
    public DTFecha getFecha_Compra(){
        return this.Fecha_Compra;
    }
}