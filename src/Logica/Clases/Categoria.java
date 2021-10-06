package Logica.Clases;

public class Categoria {
    private String nombre;
    
    public Categoria(String nombre){
        this.nombre=nombre;
    }
    
    public void setNombre(String nom){
        this.nombre=nom;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
}
