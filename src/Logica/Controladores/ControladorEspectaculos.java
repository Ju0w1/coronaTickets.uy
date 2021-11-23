/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Controladores;

import Logica.Clases.Artista;
import Logica.Clases.Categoria;
import java.util.Map;
import Logica.Clases.Espectaculo;
import Logica.Clases.Plataforma;
import Logica.Interfaz.IControladorEspectaculo;
import Logica.Servicio.EspectaculosServicios;
import java.util.HashMap;
import Logica.Clases.Plataforma; //NUEVO
import Logica.Interfaz.IControladorEspectaculo;
import Logica.Servicio.EspectaculosServicios;
import java.util.Iterator; //NUEVO
import javax.swing.DefaultListModel; //NUEVO
import javax.swing.JComboBox; //NUEVO
import javax.swing.JList; // NUEVO
import Logica.Clases.Paquete; // NUEVO

import Logica.DataTypes.DTFecha;
import java.util.HashMap;
import Logica.Servicio.EspetaculoServicio;
import Logica.Servicio.PlataformaServicio;
import java.text.ParseException;
import java.util.Map;
import Logica.Clases.Plataforma;
import Logica.Clases.Paquete;
import Logica.Interfaz.IControladorEspectaculo;
import Logica.Servicio.PaquetesServicios;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextArea;
import Logica.Clases.Funcion;
import Logica.Clases.Paquete;
import Logica.Clases.Registro;
import Logica.DataTypes.DTFecha;
import Logica.Servicio.FuncionServicios;
import Logica.Servicio.PaquetesServicios;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;

public class ControladorEspectaculos implements IControladorEspectaculo {

    //atributos
    //private Map<String, Espectaculo> espectaculos;
    //private Map<String, Plataforma> plataformas;
    private Map<String, Paquete> paquetes; // NUEVO
    private Map<String, Plataforma> plataformas; // NUEVO
    private Map<String, Espectaculo> espectaculos;
    private EspectaculosServicios servicioEspectaculo;
    private FuncionServicios servicioFuncion;
    private Map<String, Funcion> funciones;
    //private Map<String, Paquete> paquetes;
    private static ControladorEspectaculos instancia;
    private PaquetesServicios servicioPaquete;
    private PlataformaServicio servicioPlataforma;
    private EspetaculoServicio servicioEspetaculo;

    //metodos
    public ControladorEspectaculos() {
        this.servicioEspectaculo = new EspectaculosServicios();
        this.servicioPaquete = new PaquetesServicios();
        this.plataformas = new HashMap<>();
        this.espectaculos = new HashMap<>();
        this.servicioFuncion = new FuncionServicios();
        this.servicioPlataforma = new PlataformaServicio();
    }

    public static ControladorEspectaculos getInstance() {
        if (instancia == null) {
            instancia = new ControladorEspectaculos();
        }
        return instancia;
    }
    
    @Override
    public Map<String, Espectaculo> getEspectaculos() {
        Map<String, Espectaculo> espectaculos = servicioEspectaculo.getEspectaculos();
        return espectaculos;
    }
    
    public Map<String, Espectaculo> getEspectaculosFinalizados(){
        Map<String, Espectaculo> espectaculos = servicioEspectaculo.getEspectaculosFinalizados();
        return espectaculos;
    }
    //123
    @Override
    public Map<String, Plataforma> getPlataformas() {
        Map<String, Plataforma> plataformas = servicioEspectaculo.getPlataformas();
        return plataformas;
    }
    
    //123
    @Override
    public Map<String, Categoria> getCategorias() {
        Map<String, Categoria> categorias = servicioEspectaculo.getCategorias();
        return categorias;
    }
     //123
    @Override
     public boolean addCategoria(String nombre){
        if (this.servicioEspectaculo.checkCategoria(nombre) == false){
            this.servicioEspectaculo.addCategoria(nombre);
            return true;
        } else {
            return false;
        }
    }
     
     //123
    @Override
     public void addCategorias_Espectaculos(String nombreEspectaculo, String nombreCategoria){
          this.servicioEspectaculo.addCategorias_Espectaculos(nombreEspectaculo, nombreCategoria);
     }

    @Override
    public boolean addPlataforma(String nombre, String url, String descripcion) {
        if (this.servicioEspectaculo.checkCategoria(nombre)) {
            return false;
        }
        if (this.servicioEspectaculo.addPlataforma(nombre, url, descripcion)) {
            this.plataformas.put(nombre, new Plataforma(nombre, url, descripcion));
            return true;
        }
        return false;
    }
    
   

    public void altaEspectaculo(String nombrePlataforma, String nombreOrganizador, String nombreEspectaculo, String descripcion, Double duracion, int cantEspectadoresMinima, int cantEspectadoresMaxima, String URL, Double Costo, String estado, String imagen, String[] categorias) {
        if(this.servicioEspectaculo.getEspectaculoPorNombre(nombreEspectaculo).getNombre().equals("")){
            this.servicioEspectaculo.addEspectaculo(nombrePlataforma, nombreOrganizador, nombreEspectaculo, descripcion, duracion, cantEspectadoresMinima, cantEspectadoresMaxima, URL, Costo, estado, imagen, categorias);
        }
    }
    
    public boolean altaEspectaculoWEB(String nombrePlataforma, String nombreOrganizador, String nombreEspectaculo, String descripcion, Double duracion, int cantEspectadoresMinima, int cantEspectadoresMaxima, String URL, Double Costo, String estado, String imagen, String[] categorias) {
        if(this.servicioEspectaculo.getEspectaculoPorNombre(nombreEspectaculo).getNombre()==null){
            System.out.println("NO SE ENCONTRÓ, PUEDE AGREGAR: "+this.servicioEspectaculo.getEspectaculoPorNombre(nombreEspectaculo).getNombre());
            this.servicioEspectaculo.addEspectaculo(nombrePlataforma, nombreOrganizador, nombreEspectaculo, descripcion, duracion, cantEspectadoresMinima, cantEspectadoresMaxima, URL, Costo, estado, imagen, categorias);
            return true;
  
        }else{
            System.out.println("SE ENCONTÓ, NO PUEDE AGREGAR: "+this.servicioEspectaculo.getEspectaculoPorNombre(nombreEspectaculo).getNombre());
            return false;
        }
    }

//    public void altaEspectaculo(String nombrePlataforma, String nombreOrganizador, String nombreEspectaculo, String descripcion, Double duracion, int cantEspectadoresMinima, int cantEspectadoresMaxima, String URL, Double Costo, String estado, String imagen) {
//        this.servicioEspectaculo.addEspectaculo(nombrePlataforma, nombreOrganizador, nombreEspectaculo, descripcion, duracion, cantEspectadoresMinima, cantEspectadoresMaxima, URL, Costo, estado, imagen);
//    }

    @Override
    public void obtenerPlataformasToComboBox(JComboBox listPlataform) {
        for (int i = 0; i < this.servicioEspectaculo.llenarComboBoxPlataformas().getItemCount(); i++) {
            listPlataform.addItem(this.servicioEspectaculo.llenarComboBoxPlataformas().getItemAt(i).toString());
        }
    }
    
    @Override
    public void obtenerCategoriasToComboBox(JComboBox listCat) {
        for (int i = 0; i < this.servicioEspectaculo.llenarComboBoxCategorias().getItemCount(); i++) {
            listCat.addItem(this.servicioEspectaculo.llenarComboBoxCategorias().getItemAt(i).toString());
        }
    }

    @Override
    public void obtenerPlataformasToList(JList listPlataform) {
        this.plataformas = servicioEspectaculo.getPlataformas();
        DefaultListModel listModel1 = new DefaultListModel();
        Iterator iterator = this.plataformas.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entrada = (Map.Entry) iterator.next();
            Plataforma p = (Plataforma) entrada.getValue();
            listModel1.addElement(p.getNombre());
        }
        listPlataform.setModel(listModel1);
    }

    @Override
    public void obtenerEspectaculos(JList listaEspectaculos) {
        this.espectaculos = servicioEspectaculo.getEspectaculos();
        DefaultListModel listModel1 = new DefaultListModel();
        Iterator iterator = this.espectaculos.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entrada = (Map.Entry) iterator.next();
            Espectaculo e = (Espectaculo) entrada.getValue();
            listModel1.addElement(e.getNombre());
        }
        listaEspectaculos.setModel(listModel1);
    }
    public void llenarEspectaculos() {
        this.espectaculos = servicioEspectaculo.getEspectaculos();
    }

    @Override
    public void obtenerEspectaculosCorrectamente(JList listaEspectaculos, String nombrePlataforma, String nombreCategoria) {
        this.espectaculos = servicioEspectaculo.getEspectaculosCorrectamente(nombrePlataforma, nombreCategoria);
        DefaultListModel listModel1 = new DefaultListModel();
        Iterator iterator = this.espectaculos.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entrada = (Map.Entry) iterator.next();
            Espectaculo e = (Espectaculo) entrada.getValue();
            listModel1.addElement(e.getNombre());
        }
        listaEspectaculos.setModel(listModel1);
    }

    @Override
    public void cargarDatosConsultaEspectaculo(String espectaculoNombre, JLabel nombreApellido, JLabel nombreEspectaculo, JLabel duracion, JLabel espectMin, JLabel espectMax, JLabel URL, JLabel costo, JLabel fecha, JTextArea descrip) {
        Espectaculo e = (Espectaculo) this.espectaculos.get(espectaculoNombre);
        nombreApellido.setText(Integer.toString(e.getArtista()));
        nombreEspectaculo.setText(e.getNombre());
        duracion.setText(Double.toString(e.getDuracion()));
        espectMin.setText(Integer.toString(e.getMin()));
        espectMax.setText(Integer.toString(e.getMax()));
        URL.setText(e.getUrl());
        costo.setText(Double.toString(e.getCosto()));
        fecha.setText(e.getFecha().toString());
        descrip.setText(e.getDescripcion());
    }

    @Override
    public void obtenerArtistas() {
        Presentacion.AltaEspectaculo.jListArtistas.setModel(this.servicioEspectaculo.llenarListaArtistas().getModel());
    }

    @Override
    public void obtenerArtistaPorNombre(String nick) {
        Presentacion.AltaEspectaculo.jListArtistas.setModel(this.servicioEspectaculo.llenarListaArtistasPorNombre(nick).getModel());
    }
    
    @Override
    public void obtenerArtistaPorNick(String nick) { //NUEVOOOOOO
        Presentacion.AltaEspectaculo.jListArtistas.setModel(this.servicioEspectaculo.llenarListaArtistasPorNick(nick).getModel());
    }
    

    @Override
    public boolean verificarNombreEspectaculo(String nombre) {
        return this.servicioEspectaculo.verificarExistenciaNombreEspectaculo(nombre);
    }

    @Override
    public void obtenerListaFunciones(JList listFunciones) {
        this.funciones = servicioEspectaculo.getMapFuncionesEspectaculoNombre(Presentacion.ConsultaEspectaculo.txtNombreEspectaculo.getText());
        DefaultListModel listModel1 = new DefaultListModel();
        Iterator iterator = this.funciones.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entrada = (Map.Entry) iterator.next();
            Funcion f = (Funcion) entrada.getValue();
            listModel1.addElement(f.getNombre());
        }
        listFunciones.setModel(listModel1);
    }

    public void cargarDatosFuncionConsultaEspectaculo(String nombreFuncion, JLabel nombreFun, JLabel fechaRegistro, JLabel horaInicio, JLabel fechaInicio) {
        Funcion f = (Funcion) this.funciones.get(nombreFuncion);
        nombreFun.setText(f.getNombre());
        fechaRegistro.setText(f.getFechaRegistro().toString());
        horaInicio.setText(f.getHoraInicio().toString());
        fechaInicio.setText(f.getFecha().toString());
    }

    public void cargarDatosPaqueteConsultaEspectaculo(String nombreEspectaculo, String nombrePaquete, JLabel nombre, JLabel descripcion, JLabel fechaInicio, JLabel fechaFin, JLabel costo, JLabel Descuento, JList listaEspectaculos) {
        this.paquetes = this.servicioPaquete.getPaquete();
        Paquete p = (Paquete) this.paquetes.get(nombrePaquete);
        nombre.setText(p.getNombre());
        descripcion.setText(p.getDescripcion());
        costo.setText(p.getCosto().toString());
        Descuento.setText(p.getDescuento().toString());

        String fechaIn = p.getFecha_Fin().getDia() + "/" + p.getFecha_Fin().getMes() + "/" + p.getFecha_Fin().getAnio();

        String fechaFn = p.getFecha_Fin().getDia() + "/" + p.getFecha_Fin().getMes() + "/" + p.getFecha_Fin().getAnio();

        fechaInicio.setText(fechaIn);
        fechaFin.setText(fechaFn);

        Map<String, Espectaculo> espectaculos = new HashMap<>();
        espectaculos = this.servicioEspectaculo.getMapEspectaculoDePaquete(nombrePaquete);
        DefaultListModel listModel1 = new DefaultListModel();
        Iterator iterator = espectaculos.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entrada = (Map.Entry) iterator.next();
            Espectaculo e = (Espectaculo) entrada.getValue();
            listModel1.addElement(e.getNombre());
        }
        listaEspectaculos.setModel(listModel1);
    }

    public boolean crearPaquete(String nombre, DTFecha fechaInicio, DTFecha fechaFin, int descuento, String descripcion) {
        //Busco si encuentro el paquete
        boolean encontre = this.servicioPaquete.verificarPaquete(nombre);
        if (!encontre) // Si no encontro lo agrego
        {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            String fechaSI = String.valueOf(fechaInicio.getAnio()) + "-" + String.valueOf(fechaInicio.getMes()) + "-" + String.valueOf(fechaInicio.getDia());

            String fechaSF = String.valueOf(fechaFin.getAnio()) + "-" + String.valueOf(fechaFin.getMes()) + "-" + String.valueOf(fechaFin.getDia());

            try {
                java.util.Date fechaIF = formato.parse(fechaSI);
                java.util.Date fechaFF = formato.parse(fechaSF);
                java.util.Date fechaFC = new java.util.Date();
                java.sql.Date fechasql = new java.sql.Date(fechaIF.getTime());
                java.sql.Date fechaF = new java.sql.Date(fechaFF.getTime());
                java.sql.Date fechaCreado = new java.sql.Date(fechaFC.getTime());

                this.servicioPaquete.addPaquete(nombre, fechasql, fechaF, fechaCreado, descuento, descripcion);
            } catch (ParseException ex) {
                ex.getStackTrace();
            }
            return true;
        } else { //Lo encontro 
            return false;
        }
    }

    public String obtenerDescripcion(String nombre) {
        return this.servicioPaquete.obtenerDescripcion(nombre);
    }

    public String[] obtenerFecha(String nombre, int fecha) {
        return this.servicioPaquete.obtenerFecha(nombre, fecha);
    }

    public int obtenerDescuento(String nombre) {
        return this.servicioPaquete.obtenerDescuento(nombre);
    }

    public boolean actualizarPaquete(String nombre, DTFecha fechaInicio, DTFecha fechaFin, int descuento, String descripcion) {
        boolean actualizo = false;
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        String fechaSI = String.valueOf(fechaInicio.getAnio()) + "-" + String.valueOf(fechaInicio.getMes()) + "-" + String.valueOf(fechaInicio.getDia());

        String fechaSF = String.valueOf(fechaFin.getAnio()) + "-" + String.valueOf(fechaFin.getMes()) + "-" + String.valueOf(fechaFin.getDia());

        try {
            java.util.Date fechaIF = formato.parse(fechaSI);
            java.util.Date fechaFF = formato.parse(fechaSF);
            java.util.Date fechaFC = new java.util.Date();
            java.sql.Date fechasql = new java.sql.Date(fechaIF.getTime());
            java.sql.Date fechaF = new java.sql.Date(fechaFF.getTime());

            this.servicioPaquete.updatePaquete(nombre, fechasql, fechaF, descuento, descripcion);
            actualizo = true;
        } catch (ParseException ex) {
            ex.getStackTrace();
        }
        return actualizo;
    }

    public void crearFuncion() {

    }

    public ArrayList<String> cargarPlataforma() {
        return this.servicioPlataforma.llenarComboPlataforma();
    }
    
    public ArrayList<String> obtenerEspectaculosDeArtistaQueNoEstanEnPaquete(String paq_seleccionado, String plat_seleccionada, String nick) {
        return this.servicioEspectaculo.getEspectaculosPPWEB(paq_seleccionado,plat_seleccionada,nick);
    }

    public ArrayList<String> cargarEspectaculos(int plataforma) {
        return this.servicioEspetaculo.llenarComboEspectaculos(plataforma);
    }

//    @Override
//    public void agregarEspectaculo(String nombrePlataforma, String nombreOrganizador, String nombreEspectaculo, String descripcion, Double duracion, int cantEspectadoresMinima, int cantEspectadoresMaxima, String URL, Double Costo) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    //NUEVO
    public void obtenerPaquetes(JList jlist) {
        DefaultListModel model = new DefaultListModel();
        this.paquetes = this.servicioEspectaculo.getPaquetes();

        for (Paquete value : paquetes.values()) {
            model.addElement(value.getNombre());
            //System.out.println("Value = " + value);
        }

        /*
        DefaultListModel model = new DefaultListModel();
        
        
        Iterator iterator = this.paquetes.entrySet().iterator();
        
        while (iterator.hasNext()) {
           
            Map.Entry entrada = (Map.Entry) iterator.next(); // tomando las entradas
            Paquete p = (Paquete) entrada.getValue(); // se obtiene el paquete 
           
            model.addElement(p.getNombre()); // agrega el nombre al model
                    
        } */
        jlist.setModel(model); // se le pasa al jlist
    }

    //NUEVO
    public void obtenerPlataformas(JComboBox jComboBox1Plataformas) {
        this.plataformas = this.servicioEspectaculo.getPlataformas();
        jComboBox1Plataformas.removeAllItems();

        Iterator iterator = this.plataformas.entrySet().iterator();

        while (iterator.hasNext()) {

            Map.Entry entrada = (Map.Entry) iterator.next(); // tomando las entradas
            Plataforma p = (Plataforma) entrada.getValue(); // se obtiene el paquete 

            jComboBox1Plataformas.addItem(p.getNombre()); // agrega el nombre al combobox

        }

    }

    //NUEVO
    public void obtenerEspectaculosPP(JList jlist, String paq_seleccionado, String plat_seleccionada) {
        Map<String, String> espectaculosRaros;
        DefaultListModel model = new DefaultListModel();
        espectaculosRaros = this.servicioEspectaculo.getEspectaculosPP(paq_seleccionado, plat_seleccionada);

        for (String value : espectaculosRaros.values()) {
            model.addElement(value);
            //System.out.println("Value = " + value);
        }
        jlist.setModel(model);
    }
        public boolean controlFecha(int dia, int mes,int anio){// TRUE SI ES CORRECTA / FALSE SI ESTA FUERA DE RANGO
        int[] bisiestos = {1904, 1908, 1912, 1916, 1920, 1924, 1928, 1932, 1936, 1940, 1944, 1948, 1952, 1956, 1960, 1964, 1968, 1972, 1976, 1980, 1984, 1988, 1992, 1996, 2000, 2004, 2008, 2012, 2016, 2020, 2024, 2028, 2032, 2036, 2040, 2044, 2048, 2052, 2056, 2060, 2064, 2068, 2072, 2076, 2080, 2084, 2088, 2092, 2096};
        int[] mesesLargos = {1, 3, 5 , 7, 8, 10, 12};
        boolean val = contains(bisiestos, anio);
        if (val){ 
            System.out.println("BISIESTO");
        }
        System.out.println("Dia:" + dia);
        System.out.println("Mes:" + mes);
        System.out.println("Anio:" + anio);
        
        boolean val2 = contains(mesesLargos, mes);
        if (dia > 28){
            if (val){// ANIO BISIESTO
                if (mes == 2 && dia == 29){ //UNICO CASO QUE ME INTERESA
                    return true;
                }
            }
            if (dia == 31){
                if (val2){ // MESES LARGOS
                    return true;
                } else {
                    return false;
                }
            }
            if (dia==30 || dia == 29){
                if (mes == 2){
                    return false;
                }
            }
        } else { // TODO OK
            return true;
        }
        return true;
    }
    
    public static boolean contains(final int[] arr, final int key) {
        return Arrays.stream(arr).anyMatch(i -> i == key);
    }
    
    public boolean fechaInicioMayor(int diaUno, int mesUno, int anioUno,int diaDos, int mesDos,int anioDos){
        if(anioUno <= anioDos){
            if(anioUno < anioDos){
                return false;
            } else {//Anios iguales
                if (mesUno <= mesDos){
                    if(mesUno < mesDos){
                        return false;
                    } else { // Meses iguales
                        if (diaUno <= diaDos){
                            if(diaUno < diaDos){
                                return false;
                            } else { // mismo anio mes y dia
                                return true;
                            }
                        } else {
                            return true;
                        }
                    }
                } else {//Mismo anio pero mes uno mayor
                    return true;
                }
            }
        } else { // Anio uno mayor que el dos
            return true;
        }
    }

    @Override
    public boolean agregarEspectaculoAlPaquete(String espec_seleccionada, String paq_seleccionado) {
        Boolean resultado = this.servicioEspectaculo.addEspectaculoAPaquete(espec_seleccionada, paq_seleccionado);
        return resultado;
    }

    @Override
    public void obtenerPlataformas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void obtenerTablaFunciones(DefaultTableModel tablaModelo, String nomEspectaculo) {
        String id = servicioEspectaculo.getIdEspectaculo(nomEspectaculo);
        int idEsp = Integer.parseInt(id);
        Map<String, Funcion> mapFunciones = servicioEspectaculo.getMapFunciones(idEsp);
        int i = 0;
        tablaModelo.setRowCount(0);
        int tamanioFun = mapFunciones.size();
        Object[][] data = new Object[tamanioFun][2];
        for (int n = 0; n < tamanioFun; n++) {
            for (Map.Entry<String, Funcion> entry : mapFunciones.entrySet()) {
                data[n][0] = entry.getKey();
                data[n][1] = entry.getValue();
                n++;
            }
        }
        for (int j = 0; j < tamanioFun; j++) {
            Funcion f = (Funcion) data[j][1];
            String datos[] = {f.getNombre(), f.getEspectaculo().getNombre(), f.getFecha().toString(), f.getHoraInicio().toString()};
            tablaModelo.addRow(datos);
        }
    }

    public int registroFuncionEspectaculo(String nomFuncion, String espectadorNom, Date fecha) {
        /*LocalDateTime now = LocalDateTime.now();
        Date fechaRegistro= new Date(now.getYear() - 1900, now.getMonthValue() - 1, now.getDayOfMonth());*/
        int rslt;
        String idFuncion = servicioEspectaculo.getIdFuncion(nomFuncion);
        String idEspectador = servicioEspectaculo.getIdUsuario(espectadorNom);
        Map<String, Registro> registros = servicioEspectaculo.registrosPrevios(idEspectador);

        System.out.println(registros.isEmpty());

        if (servicioEspectaculo.limiteSobrepasado(idFuncion)) { //Se sobrepasa el limite de registros
            rslt = 3;
        } else { //No se sobrepasa el limite de registros

            if (!registros.isEmpty()) { //Si hay registros pervios
                if (!yaRegistradoAFuncion(registros, espectadorNom, nomFuncion)) { //ver si son o no suficientes
                    if (puedeCanjearRegistrosPrevios(registros, espectadorNom, nomFuncion) == true) {
                        rslt = 1;//llamar a una ventana en la que seleccionar los registros a canjear
                    } else {
                        servicioEspectaculo.registrarFuncion(idFuncion, idEspectador, fecha, "");
                        rslt = 0; //el registro ya fue realizado
                    }

                } else {
                    rslt = 2; //Llamar a presentacion y cambiar datos
                }
            } else { //Si no hay registros pervios
                servicioEspectaculo.registrarFuncion(idFuncion, idEspectador, fecha, "");
                rslt = 0; //el registro ya fue realizado
            }
        }
        return rslt;
    }

    public Boolean yaRegistradoAFuncion(Map<String, Registro> registros, String espectadorNom, String nomFuncion) {
        Registro r;
        Boolean rslt = false;
        for (Map.Entry entry : registros.entrySet()) {
            r = (Registro) entry.getValue();
            if (r.getEspectador().equals(espectadorNom) && r.getFuncion().equals(nomFuncion)) {

                rslt = true;
            }
            System.out.println(espectadorNom);
        }
        return rslt;
    }

    public boolean puedeCanjearRegistrosPrevios(Map<String, Registro> registros, String espectadorNom, String nomFuncion) {
        Registro r;
        int registrosPrevios = 0;
        for (Map.Entry entry : registros.entrySet()) {
            r = (Registro) entry.getValue();
            if (r.getEspectador().equals(espectadorNom) && r.getCanjeado()==false) {
                registrosPrevios++;
            }
            System.out.println(espectadorNom);
        }
        if (registrosPrevios >= 3) {
            return true;
        } else {
            return false;
        }
    }

    public Map<String, Registro> obtenerRegistrosPreviosDeEspectador(String nick){
        String idUsuario = servicioEspectaculo.getIdUsuario(nick);
        Map<String, Registro> registros = servicioEspectaculo.registrosPrevios(idUsuario);
        Registro r;
        Map<String, Registro> filtrado = new HashMap<>();
        for (Map.Entry entry : registros.entrySet()) {
            r = (Registro) entry.getValue();
            if (r.getEspectador().equals(nick) && r.getCanjeado()==false) {
                filtrado.put(r.getFuncion(), new Registro(r.getEspectador(), r.getFuncion(), r.getFecha(),r.getCanjeado()));
                        //(String nickEspectador, String nomFuncion, Date fechaRegistro, Boolean canjeado)
            }
        }
        return registros;
    }
    
    public void canjearTresRegistrosPrevios(String nomFuncion, String espectadorNom, Date fecha, DefaultTableModel tabla) {
        tabla.setRowCount(0);
        int rslt;
        String idFuncion = servicioEspectaculo.getIdFuncion(nomFuncion);
        String idEspectador = servicioEspectaculo.getIdUsuario(espectadorNom);
        Map<String, Registro> registros = servicioEspectaculo.registrosPrevios(idEspectador);
        Registro r;
        for (Map.Entry entry : registros.entrySet()) {
            r = (Registro) entry.getValue();
            if (r.getEspectador().equals(espectadorNom) && r.getCanjeado()==false) {
                Object datos[] = {r.getFuncion(), r.getFecha(), r.getCanjeado()};
                tabla.addRow(datos);
            }
            System.out.println(espectadorNom);
        }
    }
    
    public void actualizarEstadoDeRegistrosWEB(String nombreFuncion, String registro1, String registro2, String registro3, String espectadorNom) {
        String idFuncion1 = servicioEspectaculo.getIdFuncion(registro1);
        String idFuncion2 = servicioEspectaculo.getIdFuncion(registro2);
        String idFuncion3 = servicioEspectaculo.getIdFuncion(registro3);
        String idEspectador = servicioEspectaculo.getIdUsuario(espectadorNom);
        servicioFuncion.actualizarEstadoDeCanjeRegistro(idFuncion1,idFuncion2,idFuncion3,idEspectador);
        String idFuncion = servicioEspectaculo.getIdFuncion(nombreFuncion);
        this.servicioEspectaculo.registrarFuncionWEB(idFuncion, idEspectador, "canje");
    }
    
    public void actualizarEstadoDeRegistros(String nombreFuncion, String registro1, String registro2, String registro3, String espectadorNom, Date fecha) {
        String idFuncion1 = servicioEspectaculo.getIdFuncion(registro1);
        String idFuncion2 = servicioEspectaculo.getIdFuncion(registro2);
        String idFuncion3 = servicioEspectaculo.getIdFuncion(registro3);
        String idEspectador = servicioEspectaculo.getIdUsuario(espectadorNom);
        servicioFuncion.actualizarEstadoDeCanjeRegistro(idFuncion1,idFuncion2,idFuncion3,idEspectador);
        String idFuncion = servicioEspectaculo.getIdFuncion(nombreFuncion);
        servicioEspectaculo.registrarFuncion(idFuncion, idEspectador, fecha, "canje");
    }
    @Override
    public void obtenerEspectaculosToComboBox(JComboBox comboEspectaculos, String nombrePlataforma, String nombreCategoria) {
        /*for (int i = 0; i < this.servicioEspectaculo.llenarComboBoxEspectaculos(nombrePlataforma).getItemCount(); i++) {
            comboEspectaculos.addItem(this.servicioEspectaculo.llenarComboBoxEspectaculos(nombrePlataforma).getItemAt(i).toString());
        }*/
        /*for (int i = 0; i < this.servicioEspectaculo.getEspectaculosCorrectamente(nombrePlataforma, nombreCategoria).size(); i++) {
            comboEspectaculos.addItem(this.servicioEspectaculo.getEspectaculosCorrectamente(nombrePlataforma, nombreCategoria).get(i).getNombre());
        }*/
        Map<String, Espectaculo> espec=this.servicioEspectaculo.getEspectaculosCorrectamente(nombrePlataforma, nombreCategoria);
        for (Map.Entry entry : espec.entrySet()) {
            comboEspectaculos.addItem(entry.getKey());
        }
    }

    @Override
    public void obtenerArtistasDeFuncion(DefaultTableModel tablaModelo, String nombreFuncion) {
        String idFuncion = this.servicioEspectaculo.getIdFuncion(nombreFuncion);
        Map<String, Artista> artistasEnFuncion = this.servicioEspectaculo.getMapArtistas(idFuncion);
        System.out.println("Este es el de ObtenerArtistasDeFuncion"+artistasEnFuncion.isEmpty());
        
        tablaModelo.setRowCount(0);
        
        int tamanioA = artistasEnFuncion.size();
        Object[][] data = new Object[tamanioA][2];
        
        for(int i = 0; i < tamanioA; i++){

            for(Map.Entry<String, Artista> entry : artistasEnFuncion.entrySet()){

               data[i][0] = entry.getKey();
               data[i][1] = entry.getValue();
               //String datos[] = data[i][1].
               i++;
            }
        }  
        
        for(int i = 0; i < tamanioA; i++){
            //String data[] = {this.usuarios.get(i).getNombre(), this.usuarios.get(i).getApellido(), this.usuarios.get(i).getCedula()};
           
            Artista a = (Artista) data[i][1];
            //System.err.println(e.getNacimiento().getDia()+"/"+e.getNacimiento().getMes()+"/"+e.getNacimiento().getMes());
            
            String datos[] = {a.getNombre(),a.getDescripcion(),a.getBiografia(),a.getLinkWeb()};
            tablaModelo.addRow(datos);
        }
    }

    public void obtenerLinkPlataforma(String nombrePlataforma, JTextField linkPlataforma){
        //Llamar a función ServicioPlataforma para obtener el link de la plataforma y setearlo
        String urlNueva = this.servicioEspectaculo.getLinkPlataforma(nombrePlataforma) + "/";
        if (urlNueva.equals("/")){
            linkPlataforma.setText("Seleccione una Plataforma");
        } else {
            linkPlataforma.setText(this.servicioEspectaculo.getLinkPlataforma(nombrePlataforma) + "/");
        }
    }
    public Map<String, Espectaculo> obtenerEspectaculosAceptadosDeArtista(int idArtista){
        Map<String, Espectaculo> espectaculos = servicioEspectaculo.getMapEspectaculosAceptados(idArtista);
        return espectaculos;
    }
    public Map<String, Espectaculo> obtenerEspectaculosAceptadosDeArtistaPorNick(String nickArtista){
        int idArtista = servicioEspectaculo.getIdporNickArtista(nickArtista);
        if (idArtista == -1){
            return null;
        } else {
            Map<String, Espectaculo> espectaculos = obtenerEspectaculosAceptadosDeArtista(idArtista);
            return espectaculos;
        }
    }
    public Map<String, Espectaculo> obtenerEspectaculosRechazadosDeArtista(int idArtista){
        Map<String, Espectaculo> espectaculos = servicioEspectaculo.getMapEspectaculosRechazados(idArtista);
        return espectaculos;
    }
    public Map<String, Espectaculo> obtenerEspectaculosRechazadosDeArtistaPorNick(String nickArtista){
        int idArtista = servicioEspectaculo.getIdporNickArtista(nickArtista);
        if (idArtista == -1){
            return null;
        } else {
            Map<String, Espectaculo> espectaculos = servicioEspectaculo.getMapEspectaculosRechazados(idArtista);
            return espectaculos;
        }
    }
    
    
    
    public Map<String, Espectaculo> obtenerEspectaculosIngresadosDeArtista(int idArtista){
        Map<String, Espectaculo> espectaculos = servicioEspectaculo.getMapEspectaculosIngresadosArtista(idArtista);
        return espectaculos;
    }
    public Map<String, Espectaculo> obtenerEspectaculosIngresadosDeArtistaPorNick(String nickArtista){
        int idArtista = servicioEspectaculo.getIdporNickArtista(nickArtista);
        if (idArtista == -1){
            return null;
        } else {
            Map<String, Espectaculo> espectaculos = servicioEspectaculo.getMapEspectaculosIngresadosArtista(idArtista);
            return espectaculos;
        }
    }
       
    public Map<String, Espectaculo> obtenerEspectaculosFinalizadosDeArtistaPorNick(String nickArtista){
        int idArtista = servicioEspectaculo.getIdporNickArtista(nickArtista);
        if(idArtista == -1){
            return null;
        }else{
            Map<String, Espectaculo> espectaculos = servicioEspectaculo.getMapEspectaculosFinaliazados(idArtista);
            return espectaculos;
        }  
    }
    
    public Espectaculo obtenerEspectaculoPorNombre(String nombreEspectaculo){
        String stringidEspectaculo = servicioEspectaculo.getIdEspectaculo(nombreEspectaculo);
        int idEspectaculo = Integer.parseInt(stringidEspectaculo);
        return servicioEspectaculo.getEspectaculoPorId(idEspectaculo);
    }
    
    //Funciones para la parte WEB

    @Override
    public Map<String, Funcion> obtenerMapFunciones(String nomEspectaculo) {
        String id = servicioEspectaculo.getIdEspectaculo(nomEspectaculo);
        int idEsp = Integer.parseInt(id);
        Map<String, Funcion> mapFunciones = servicioEspectaculo.getMapFunciones(idEsp);
        return mapFunciones;
    }
    
    @Override
    public Map<String, Artista> obtenerMapArtistasDeFuncion(String nomFuncion) {
        String idFuncion = this.servicioEspectaculo.getIdFuncion(nomFuncion);
        Map<String, Artista> artistasEnFuncion = this.servicioEspectaculo.getMapArtistas(idFuncion);
        return artistasEnFuncion;
    }
    
    @Override
    public Map<String, Espectaculo> obtenerMapEspectaculos(String nombrePlataforma, String nombreCategoria) {
        Map<String, Espectaculo> mapEspectaculos=servicioEspectaculo.getEspectaculosCorrectamente(nombrePlataforma, nombreCategoria);
        return mapEspectaculos;
    }
    
    @Override
    public Map<String, Funcion> getRegistroDeFuncionesDeUsuario(int usuId){
        Map<String, Funcion> funciones = servicioEspectaculo.getMapRegistroDeFuncionesDeUsuario(usuId);
        return funciones;
    }
    
    @Override
    public Map<String, Funcion> getRegistroDeFuncionesDeUsuarioPorNick(String usuNick){
        
        int usuId = servicioEspectaculo.getIdporNickEspectador(usuNick);
        if (usuId == -1){
            return null;
        } else {
            Map<String, Funcion> funciones = getRegistroDeFuncionesDeUsuario(usuId);
            return funciones;
        }
    }
    
    @Override
    public Map<String, Espectaculo> obtenerMapEspectaculosDePaquete(String nombrePaquete) {
        Map<String, Espectaculo> mapEspectaculos=servicioEspectaculo.getEspectaculosDePaquete(nombrePaquete);
        return mapEspectaculos;
    }
    
    @Override
    public Espectaculo getEspectaculoPorNombre(String nombreEspectaculo){
        Espectaculo resultado = servicioEspectaculo.getEspectaculoPorNombre(nombreEspectaculo);
        System.out.println("LLega el nombre:"+resultado.getNombre());
        return resultado;
    }
    
    public Map<String, Espectaculo> getMapEspectaculoIngresados(){
        Map<String, Espectaculo> mapEspectaculos=servicioEspectaculo.getMapEspectaculosIngresados();
        return mapEspectaculos;
    }
    
    public void aceptarEspectaculos (String nomEspectaculo, boolean aceptado){
        String idEspectaculo=servicioEspectaculo.getIdEspectaculo(nomEspectaculo);
        servicioEspectaculo.aceptarEspectaculo(idEspectaculo, aceptado);
    }
    
    public void registroFuncionWEB(String nombreFuncion, String nick){
        System.out.println("PRE:"+nombreFuncion);
        System.out.println("PRE:"+nick);
        String idFuncion = this.servicioEspectaculo.getIdFuncion(nombreFuncion);
        String idUsuario = this.servicioEspectaculo.getIdUsuario(nick);
        System.out.println("POST"+idFuncion);
        System.out.println("POST"+idUsuario);
        this.servicioEspectaculo.registrarFuncionWEB(idFuncion, idUsuario, "");
    }
    
    public Map<String, Paquete> obtenerPaquetesSinCanjear(String nick, String nombreFuncion){
        int idUsuario = Integer.parseInt(servicioEspectaculo.getIdUsuario(nick));
        int idFuncion = Integer.parseInt(servicioEspectaculo.getIdFuncion(nombreFuncion));
        
        Map<String, Paquete> paquetes = servicioPaquete.getPaquetesQueComproUsuarioSinCanjear(idUsuario, idFuncion);
        return paquetes;
    }
    
    public boolean FinalizarEspec(String nom_espec){
        if(this.servicioEspectaculo.FinalizarEspec(nom_espec)){
            return true;
        }else{
            return false;
        }
    }
    
     public  boolean checkFavorito(int usuario_id, int espec_id){
         if(servicioEspectaculo.checkFavorito(usuario_id, espec_id)){
             return true;
         }else{
             return false;
         }
     }
     public  boolean yaEsFavorito(int usuario_id, int espec_id){
         if(servicioEspectaculo.yaEsFavorito(usuario_id, espec_id)){
             return true;
         }else{
             return false;
         }
     }
    public void marcarEspectaculoFavorito(String nickname, String espec){
        servicioEspectaculo.marcarEspectaculoFavorito(nickname, espec);
    }
    public void desmarcarFavorito(String nickname, String espec){
        servicioEspectaculo.desmarcarFavorito(nickname, espec);
    }
    public int getFavoritos(String nombreEspec){
        return servicioEspectaculo.getFavoritos(nombreEspec);
    }
}