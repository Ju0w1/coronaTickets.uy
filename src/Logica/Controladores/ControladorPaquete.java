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
import Logica.servicios.PaquetesServicios;



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



    @Override
    public void modificarPaquete(String nombre, String descripcion, DTFecha fechaInicio, DTFecha fechaFinal, float costo, float descuento, DTFecha fechaCompra) {
        System.out.println(nombre);
    }
    
}