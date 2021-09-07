/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Controladores;

import Logica.Clases.Artista;
import java.util.Map;
import Logica.Clases.Espectaculo;
import Logica.Clases.Plataforma;
import Logica.Interfaz.IControladorEspectaculo;
import Logica.Servicios.EspectaculosServicios;
import java.util.HashMap;
import Logica.Clases.Plataforma; //NUEVO
import Logica.Interfaz.IControladorEspectaculo;
import Logica.Servicios.EspectaculosServicios;
import java.util.Iterator; //NUEVO
import javax.swing.DefaultListModel; //NUEVO
import javax.swing.JComboBox; //NUEVO
import javax.swing.JList; // NUEVO
import Logica.Clases.Paquete; // NUEVO

import Logica.DataTypes.DTFecha;
import java.util.HashMap;
import Logica.Servicios.EspetaculoServicio;
import Logica.Servicios.PlataformaServicio;
import java.text.ParseException;
import java.util.Map;
import Logica.Clases.Plataforma;
import Logica.Clases.Paquete;
import Logica.Interfaz.IControladorEspectaculo;
import Logica.Servicios.PaquetesServicios;
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
import Logica.Servicios.FuncionServicios;
import Logica.Servicios.PaquetesServicios;
import java.sql.Date;
import java.util.Arrays;
import java.util.HashMap;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
    }

    public static ControladorEspectaculos getInstance() {
        if (instancia == null) {
            instancia = new ControladorEspectaculos();
        }
        return instancia;
    }

    public Map<String, Espectaculo> getEspectaculos() {
        Map<String, Espectaculo> espectaculos = servicioEspectaculo.getEspectaculos();
        return espectaculos;
    }

    public boolean addPlataforma(String nombre, String url, String descripcion) {
        if (this.servicioEspectaculo.checkPlataforma(nombre)) {
            return false;
        }
        if (this.servicioEspectaculo.addPlataforma(nombre, url, descripcion)) {
            this.plataformas.put(nombre, new Plataforma(nombre, url, descripcion));
            return true;
        }
        return false;
    }

    public void altaEspectaculo(String nombrePlataforma, String nombreOrganizador, String nombreEspectaculo, String descripcion, Double duracion, int cantEspectadoresMinima, int cantEspectadoresMaxima, String URL, Double Costo) {
        this.servicioEspectaculo.addEspectaculo(nombrePlataforma, nombreOrganizador, nombreEspectaculo, descripcion, duracion, cantEspectadoresMinima, cantEspectadoresMaxima, URL, Costo);
    }

    public void obtenerPlataformasToComboBox(JComboBox listPlataform) {
        //listPlataform = this.servicioEspectaculo.llenarComboBoxPlataformas();
        for (int i = 0; i < this.servicioEspectaculo.llenarComboBoxPlataformas().getItemCount(); i++) {
            listPlataform.addItem(this.servicioEspectaculo.llenarComboBoxPlataformas().getItemAt(i).toString());
        }
    }

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

    public void obtenerEspectaculosPorPlataforma(JList listaEspectaculos, String nombrePlataforma) {
        this.espectaculos = servicioEspectaculo.getEspectaculosSegunPlataforma(nombrePlataforma);
        DefaultListModel listModel1 = new DefaultListModel();
        Iterator iterator = this.espectaculos.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entrada = (Map.Entry) iterator.next();
            Espectaculo e = (Espectaculo) entrada.getValue();
            listModel1.addElement(e.getNombre());
        }
        listaEspectaculos.setModel(listModel1);
    }

    public void obtenerFuncionesDeEspectaculo() {
        //CONTINUAR
    }

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

    public void obtenerArtistas() {
        Presentacion.AltaEspectaculo.jListArtistas.setModel(this.servicioEspectaculo.llenarListaArtistas().getModel());
    }

    public void obtenerArtistaPorNombre(String nombre) {
        Presentacion.AltaEspectaculo.jListArtistas.setModel(this.servicioEspectaculo.llenarListaArtistasPorNombre(nombre).getModel());
    }

    public boolean verificarNombreEspectaculo(String nombre) {
        return this.servicioEspectaculo.verificarExistenciaNombreEspectaculo(nombre);
    }

    public void consultaEspectaculo() {

    }

    public void altaFuncionEspectaculo() {

    }

    public void consultaFuncionEspectaculo() {

    }

    public void registroFuncionEspectaculo() {

    }

    public void crearPaqueteEspectaculos() {

    }

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
        //System.out.println(id);
        Map<String, Funcion> mapFunciones = servicioEspectaculo.getMapFunciones(idEsp);
//        /Funcion f;
        int i = 0;

        tablaModelo.setRowCount(0);

        int tamanioFun = mapFunciones.size();
        Object[][] data = new Object[tamanioFun][2];

        for (int n = 0; n < tamanioFun; n++) {
            for (Map.Entry<String, Funcion> entry : mapFunciones.entrySet()) {

                data[n][0] = entry.getKey();
                data[n][1] = entry.getValue();
                //String datos[] = data[i][1].
                n++;
            }
        }
        for (int j = 0; j < tamanioFun; j++) {
            //String data[] = {this.usuarios.get(i).getNombre(), this.usuarios.get(i).getApellido(), this.usuarios.get(i).getCedula()};
            Funcion f = (Funcion) data[j][1];
            //System.err.println(e.getNacimiento().getDia()+"/"+e.getNacimiento().getMes()+"/"+e.getNacimiento().getMes());
            //String fecha = e.getNacimiento().getDia()+"/"+e.getNacimiento().getMes()+"/"+e.getNacimiento().getAnio();
            String datos[] = {f.getNombre(), f.getEspectaculo().getNombre(), f.getFecha().toString(), f.getHoraInicio().toString()};
            tablaModelo.addRow(datos);
        }

//        for (Map.Entry entry : mapFunciones.entrySet()) {
//            f= (Funcion) entry.getValue();
//            tablaFunciones.setValueAt(f.getNombre(), i, 0);
//            tablaFunciones.setValueAt(f.getEspectaculo().getNombre(), i, 1);
//            tablaFunciones.setValueAt(f.getFecha(), i, 2);
//            tablaFunciones.setValueAt(f.getHoraInicio(), i, 3);
//            i++;
//        }
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
                        servicioEspectaculo.registrarFuncion(idFuncion, idEspectador, fecha);
                        rslt = 0; //el registro ya fue realizado
                    }

                } else {
                    rslt = 2; //Llamar a presentacion y cambiar datos
                }
            } else { //Si no hay registros pervios
                servicioEspectaculo.registrarFuncion(idFuncion, idEspectador, fecha);
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

    public void canjearTresRegistrosPrevios(String nomFuncion, String espectadorNom, Date fecha, DefaultTableModel tabla) {
        /*LocalDateTime now = LocalDateTime.now();
        Date fechaRegistro= new Date(now.getYear() - 1900, now.getMonthValue() - 1, now.getDayOfMonth());*/
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
    
    public void actualizarEstadoDeRegistros(String nombreFuncion, String registro1, String registro2, String registro3, String espectadorNom, Date fecha) {
        String idFuncion1 = servicioEspectaculo.getIdFuncion(registro1);
        String idFuncion2 = servicioEspectaculo.getIdFuncion(registro2);
        String idFuncion3 = servicioEspectaculo.getIdFuncion(registro3);
        String idEspectador = servicioEspectaculo.getIdUsuario(espectadorNom);
        servicioFuncion.actualizarEstadoDeCanjeRegistro(idFuncion1,idFuncion2,idFuncion3,idEspectador);
        String idFuncion = servicioEspectaculo.getIdFuncion(nombreFuncion);
        servicioEspectaculo.registrarFuncion(idFuncion, idEspectador, fecha);
    }
    @Override
    public void obtenerEspectaculosToComboBox(JComboBox comboEspectaculos, String nombrePlataforma) {
        for (int i = 0; i < this.servicioEspectaculo.llenarComboBoxEspectaculos(nombrePlataforma).getItemCount(); i++) {
            comboEspectaculos.addItem(this.servicioEspectaculo.llenarComboBoxEspectaculos(nombrePlataforma).getItemAt(i).toString());
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


}
