package Logica.Controladores;

import Logica.DataTypes.DTFecha;
import java.util.Iterator;
import java.util.Map;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextField;
import Logica.Clases.Paquete;
import java.util.HashMap;
import Logica.Interfaz.IControladorPaquete;
import Logica.Servicio.PaquetesServicios;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class ControladorPaquete implements IControladorPaquete{
    
    private Map<String, Paquete> paquetes;
    
    private PaquetesServicios servicioPaq;
    private static ControladorPaquete instancia;

    public ControladorPaquete() {
        this.servicioPaq = new PaquetesServicios();
        this.paquetes= new HashMap<>();
    }
    
    public static ControladorPaquete getInstance() {
        if (instancia == null) {
            instancia = new ControladorPaquete();
        }
        return instancia;
    }
    
   
     public void actualizarPaquete(String nombre, String descripcion, DTFecha fechaInicio, DTFecha fechaFin, Float descuento, String imagen){
         //123
         Paquete paquete = new Paquete();
         paquete.setNombre(nombre);
         paquete.setDescripcion(descripcion);
         paquete.setFecha_Inicio(fechaInicio);
         paquete.setFecha_Fin(fechaFin);
         paquete.setDescuento(descuento);
         paquete.setUrl(imagen);
         this.servicioPaq.actualizarPaquete(paquete);     
     }
    
    public void altaPaquete(String nombre,String fechaInicio, String fechaFin,String fechaCreado,double descuento,String descripcion, String imagen){
        this.servicioPaq.altaPaquete(nombre, fechaInicio, fechaFin, fechaCreado, descuento, descripcion, imagen);
    }
    
     public boolean addPaquete(String nombre, String descripcion, DTFecha fechaInicio, DTFecha fechaFin, Float descuento, String imagen){
        //123
         if (this.servicioPaq.verificarPaquete(nombre) == false){
            Paquete paquete = new Paquete();
            paquete.setNombre(nombre);
            paquete.setDescripcion(descripcion);
            paquete.setFecha_Inicio(fechaInicio);
            paquete.setFecha_Fin(fechaFin);
            paquete.setDescuento(descuento);
            paquete.setUrl(imagen);
            this.servicioPaq.addPaquete(paquete);
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public Map<String, Paquete> getPaquetes(){
        Map<String, Paquete> paquetes = servicioPaq.getPaquete();
        return paquetes;
    };

    public void addPaquete(String nombre, String descripcion, DTFecha Finicio, DTFecha Ffinal, String costo, String descuento, DTFecha Fcompra) {
        float x=Float.parseFloat(costo);
        float y=Float.parseFloat(descuento);
        this.paquetes.put(nombre, new Paquete(nombre,descripcion,Finicio,Ffinal,x,y,Fcompra));
    }
  
   
    
    
    public void obtenerPaquete(JList listEspec){
        this.paquetes = this.servicioPaq.getPaquete();
        DefaultListModel listModel1 = new DefaultListModel();
        
        System.out.println("While Loop:");
        Iterator iterator = this.paquetes.entrySet().iterator();
        
        while (iterator.hasNext()) {
            Map.Entry entrada = (Map.Entry) iterator.next();
            Paquete e = (Paquete) entrada.getValue();
            System.out.println(e.getNombre());
            listModel1.addElement(e.getNombre());
        } 
        
        listEspec.setModel(listModel1);
    }
    
    @Override
    public void obtenerPaqueteEspectaculo(JList listEspec, String espectaculoNombre){
        this.paquetes = this.servicioPaq.getPaquetesDeEspectaculo(espectaculoNombre);
        DefaultListModel listModel1 = new DefaultListModel();
        
        System.out.println("While Loop:");
        Iterator iterator = this.paquetes.entrySet().iterator();
        
        while (iterator.hasNext()) {
            Map.Entry entrada = (Map.Entry) iterator.next();
            Paquete e = (Paquete) entrada.getValue();
            System.out.println(e.getNombre());
            listModel1.addElement(e.getNombre());
        } 
        
        listEspec.setModel(listModel1);
    }
    
    
    @Override
    public void cargarDatosConsultaPaquete(String seleccion, JTextField nombre_, JTextField descripcion_, JTextField Finicio, JTextField Ffinal, JTextField costo_, JTextField descuento_, JTextField FCompra){
        
        Paquete e = (Paquete) this.paquetes.get(seleccion);
        DTFecha fechaI = e.getFecha_Inicio();

        String fechaIn = fechaI.getDia()+"/"+fechaI.getMes()+"/"+fechaI.getAnio();
        
        DTFecha fechaF = e.getFecha_Fin();

        String fechaFn = fechaF.getDia()+"/"+fechaF.getMes()+"/"+fechaF.getAnio();
        
        DTFecha fechaC = e.getFecha_Compra();

        String fechaCm = fechaC.getDia()+"/"+fechaC.getMes()+"/"+fechaC.getAnio();
        
        nombre_.setText(e.getNombre());
        descripcion_.setText(e.getDescripcion());
        Finicio.setText(fechaIn);
        Ffinal.setText(fechaFn);
        costo_.setText(Float.toString(e.getCosto()));
        descuento_.setText(Float.toString(e.getDescuento()));
        FCompra.setText(fechaCm);
        
    }
    public boolean getEspectaculos(String nombrePaquete,JList listEspectaculos){
        ResultSet rs = this.servicioPaq.getEspectaculos(nombrePaquete);
        DefaultListModel listModel1 = new DefaultListModel();
        try {
            while(rs.next()){
                listModel1.addElement(rs.getString(1));
            }
            listEspectaculos.setModel(listModel1);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ControladorPaquete.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public Map<String, Paquete> getPaquetesQueComproUsuario(int idUsuario){
        Map<String, Paquete> paquetes = servicioPaq.getPaquetesQueComproUsuario(idUsuario);
        return paquetes;
    }
//    public Paquete PruebaPaquete(String ID_paq){
//        //ResultSet rs = this.servicioPaq.getAllPaquete(nombre_);
//        Paquete a = this.servicioPaq.getAllPaquete(ID_paq);
//        return a;
//    }
    @Override
    public Map<String, Paquete> getPaquetesV2(){
        Map<String, Paquete> paquetess = servicioPaq.getPaqueteV2();
        return paquetess;
    };
    
    //Funciones para la parte WEB
    public Map<String, Paquete> obtenerMapPaquetesVigentesEspectaculoUsuario (String nickUsuario, String nomEspectaculo){
        Map<String, Paquete> mapPaquetes=servicioPaq.obtenerMapPaquetesVigentesEspectaculoUsuario(nickUsuario, nomEspectaculo);
        return mapPaquetes;
    }
    
}
