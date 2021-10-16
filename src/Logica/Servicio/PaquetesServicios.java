package Logica.Servicio;

import Logica.DataTypes.DTFecha;
import Persistencia.ConexionDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import Logica.Clases.Paquete;
import Logica.Clases.Paquete;
import Logica.DataTypes.DTFecha;
import Persistencia.ConexionDB;
import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JList;


public class PaquetesServicios{

    public PaquetesServicios() {
    }
    private Connection conexion = new ConexionDB().getConexion();
    
   
    public void actualizarPaquete(Paquete paquete) {
                
         //'2021-02-02' ejemplo de fecha
         int anioInicio = paquete.getFecha_Inicio().getAnio();
         int mesInicio = paquete.getFecha_Inicio().getMes();
         int diaInicio = paquete.getFecha_Inicio().getDia();
         
         int anioFin = paquete.getFecha_Fin().getAnio();
         int mesFin = paquete.getFecha_Fin().getMes();
         int diaFin = paquete.getFecha_Fin().getDia();
         
        try {
            PreparedStatement status = conexion.prepareStatement("UPDATE paquetes SET paq_descripcion = ?, paq_fecha_inicio = ?, paq_fecha_fin = ?, paq_descuento = ?, paq_imagen = ? WHERE paq_nombre = ?");
            status.setString (1, paquete.getDescripcion());
            status.setString (2, anioInicio+"-"+mesInicio+"-"+diaInicio);
            status.setString (3, anioFin+"-"+mesFin+"-"+diaFin);
            status.setFloat (4, paquete.getDescuento());
            status.setString (5, paquete.getUrl());
            status.setString (5, paquete.getNombre());
            status.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
        
  
     public boolean addPaquete(Paquete paquete) {
         
         //'2021-02-02' ejemplo de fecha
         int anioInicio = paquete.getFecha_Inicio().getAnio();
         int mesInicio = paquete.getFecha_Inicio().getMes();
         int diaInicio = paquete.getFecha_Inicio().getDia();
         
         int anioFin = paquete.getFecha_Fin().getAnio();
         int mesFin = paquete.getFecha_Fin().getMes();
         int diaFin = paquete.getFecha_Fin().getDia();
         
        try {
            PreparedStatement status = conexion.prepareStatement("INSERT INTO paquetes (paq_nombre, paq_descripcion, paq_fecha_inicio, paq_fecha_fin, paq_descuento, paq_imagen) VALUES (?,?,?,?,?,?)");
            status.setString (1, paquete.getNombre());
            status.setString (2, paquete.getDescripcion());
            status.setString (3, anioInicio+"-"+mesInicio+"-"+diaInicio);
            status.setString (4, anioFin+"-"+mesFin+"-"+diaFin);
            status.setFloat (5, paquete.getDescuento());
            status.setString (6, paquete.getUrl());
            status.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    
    }

    public DTFecha dateToDTFecha(Date fecha){
        if(fecha != null){
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String fechaDB = dateFormat.format(fecha);
            String[] partes = fechaDB.split("-");
            return new DTFecha(Integer.parseInt(partes[2]),Integer.parseInt(partes[1]),Integer.parseInt(partes[0]));
        }
        else{
            return new DTFecha(0,0,0);
        }
    }
    
    
    public Map<String, Paquete> getPaquete() {
        Map<String, Paquete> resultado = new HashMap<>();
        try {
            PreparedStatement status = conexion.prepareStatement("SELECT * FROM paquetes");
            ResultSet rs = status.executeQuery();
            
            while (rs.next()) {
                dateToDTFecha(rs.getDate("paq_fecha_inicio"));
                resultado.put(rs.getString("paq_nombre"), new Paquete(rs.getString("paq_nombre"), rs.getString("paq_descripcion"), dateToDTFecha(rs.getDate("paq_fecha_inicio")), dateToDTFecha(rs.getDate("paq_fecha_fin")),rs.getFloat("paq_costo"), rs.getFloat("paq_descuento"), dateToDTFecha(rs.getDate("paq_fecha_compra")))); 
                //System.out.println("Nombre: "+ rs.getString("paq_nombre")+"Descripcion: "+ rs.getString("paq_descripcion")+"Costo: "+ rs.getFloat("paq_costo")+"Descuento: "+ rs.getFloat("paq_descuento"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }
    
    public Map<String, Paquete> getPaquetesDeEspectaculo(String espectaculoNombre) {
        Map<String, Paquete> resultado = new HashMap<>();
        try {
            PreparedStatement status = conexion.prepareStatement("SELECT * FROM paquetes, paquete_espetaculos WHERE paquetes.paq_id=paquete_espetaculos.paqespec_paq_id AND paquete_espetaculos.paqespec_espec_id IN (select espetaculos.espec_id from espetaculos where espetaculos.espec_nombre=?)");
            status.setString(1, espectaculoNombre);
            ResultSet rs = status.executeQuery();
            while (rs.next()) {
                dateToDTFecha(rs.getDate("paq_fecha_inicio"));
                resultado.put(rs.getString("paq_nombre"), new Paquete(rs.getString("paq_nombre"), rs.getString("paq_descripcion"), dateToDTFecha(rs.getDate("paq_fecha_inicio")), dateToDTFecha(rs.getDate("paq_fecha_fin")),rs.getFloat("paq_costo"), rs.getFloat("paq_descuento"), dateToDTFecha(rs.getDate("paq_fecha_compra")))); 
                //System.out.println("Nombre: "+ rs.getString("paq_nombre")+"Descripcion: "+ rs.getString("paq_descripcion")+"Costo: "+ rs.getFloat("paq_costo")+"Descuento: "+ rs.getFloat("paq_descuento"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }
    

    public boolean addPaquete(String nombre, String descripcion,DTFecha Finicio,DTFecha Ffinal, String costo, String descuento, DTFecha FCompra) {
        try {
            PreparedStatement status = conexion.prepareStatement("INSERT INTO paquetes (paq_nombre,paq_descripcion,paq_fecha_inicio,paq_fecha_fin,paq_costo,paq_descuento,paq_fecha_compra) VALUES (?,?,?,?,?,?,?)");
            status.setString (1, nombre);
            status.setString (2, descripcion);
            status.setString (3, Finicio.getAnio() + "-" +  Finicio.getMes() + "-" + Finicio.getDia());
            status.setString (4, Ffinal.getAnio() + "-" +  Ffinal.getMes() + "-" + Ffinal.getDia());
            status.setString (5, costo);
            status.setString (6, descuento);
            status.setString (7, FCompra.getAnio() + "-" +  FCompra.getMes() + "-" + FCompra.getDia());
            status.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    
    
    public void addPaquete(String nombre,Date fechaInicio, Date fechaFin,Date fechaCreado,int descuento,String descripcion)
    {
        try{
            PreparedStatement statement = conexion.prepareStatement("INSERT INTO paquetes(paq_nombre, paq_descripcion,paq_descuento,paq_fecha_inicio,paq_fecha_fin,paq_fecha_alta  ) VALUES(?,?,?,?,?,?)");
            statement.setString(1, nombre);
            statement.setString(2, descripcion);
            statement.setDouble(3, descuento); //Descuento
            statement.setDate(4, fechaInicio); //Fecha inicio
            statement.setDate(5, fechaFin); //Fecha fin
            statement.setDate(6, fechaCreado); //Fecha creado
            statement.execute();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public void updatePaquete(String nombre,Date fechaInicio, Date fechaFin, int descuento, String descripcion)
    {
        try{
            PreparedStatement statement = conexion.prepareStatement("UPDATE paquetes SET paq_descripcion = ?, paq_fecha_inicio = ?, paq_fecha_fin = ?, paq_descuento = ? WHERE paq_nombre = ?");
            statement.setString(1, descripcion);
            statement.setDate(2, fechaInicio); //Fecha inicio
            statement.setDate(3, fechaFin); //Fecha fin
            statement.setDouble(4, descuento); //Descuento
            statement.setString(5, nombre);
            statement.execute();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public boolean verificarPaquete(String nombre)
    {
        boolean encontro = false;
        try{
            PreparedStatement stm = conexion.prepareStatement("SELECT * FROM paquetes");
            
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                if(rs.getString("paq_nombre").equals(nombre))
                {
                    encontro = true;
                     break;
                }
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        return encontro;
    }
 
    public String obtenerDescripcion(String nombre)
    {
        String desc = "";
        try
        {
            PreparedStatement stm = conexion.prepareStatement("SELECT * FROM paquetes WHERE paq_nombre = ?");    
            stm.setString(1, nombre);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                desc = rs.getString("paq_descripcion");
            }
        }catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return desc;
    }
    
    public String[] obtenerFecha(String nombre, int fecha)
    {
        String fechas = "";
        String[] fechaSplit;
        try
        {
            PreparedStatement stm = conexion.prepareStatement("SELECT * FROM paquetes WHERE paq_nombre = ?");    
            stm.setString(1, nombre);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                if(fecha == 1) //Es la fecha de inicio
                {
                    fechas = rs.getDate("paq_fecha_inicio").toString();
                }else if(fecha == 2) //Es la fehca de fin
                {
                    fechas = rs.getDate("paq_fecha_fin").toString();
                }
            }
        }catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        fechaSplit = fechas.split("-");
        return fechaSplit;
    }
    
    public int obtenerDescuento(String nombre)
    {
        int descuento = 0;
        try
        {
            PreparedStatement stm = conexion.prepareStatement("SELECT * FROM paquetes WHERE paq_nombre = ?");    
            stm.setString(1, nombre);
            ResultSet rs = stm.executeQuery();
            while(rs.next())
            {
                descuento = rs.getInt("paq_descuento");
            }
        }catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return descuento;
    }
    
    public ResultSet getEspectaculos(String paqueteNombre){
        try
        {//SELECT espetaculos.espec_nombre FROM espetaculos WHERE espetaculos.espec_id IN (SELECT paquete_espetaculos.paqespec_espec_id FROM paquete_espetaculos WHERE paquete_espetaculos.paqespec_paq_id IN (SELECT paquetes.paq_id FROM paquetes WHERE paquetes.paq_nombre='" + paqueteNombre + "'))";
            PreparedStatement stm = conexion.prepareStatement("SELECT espetaculos.espec_nombre FROM espetaculos WHERE espetaculos.espec_id IN (SELECT paquete_espetaculos.paqespec_espec_id FROM paquete_espetaculos WHERE paquete_espetaculos.paqespec_paq_id IN (SELECT paquetes.paq_id FROM paquetes WHERE paquetes.paq_nombre='" + paqueteNombre + "'))");    
            ResultSet rs = stm.executeQuery();
            return rs;
        }catch(SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }
//    public Paquete getAllPaquete(String ID_paq){
//       Paquete a = null;
//       int i_=Integer.parseInt(ID_paq);  
//       try {
//            Statement status = conexion.createStatement();
//            ResultSet rs = status.executeQuery("SELECT * FROM paquetes as P WHERE P.paq_id ='"+i_+"'");
//            
//            if(rs.next()) {
//                //dateToDTFecha(rs.getDate("paq_fecha_inicio"));
//                //dateToDTFecha(rs.getDate("paq_fecha_fin"));
//                //
//                a = new Paquete(rs.getString("paq_nombre"),rs.getString("paq_descripcion"),dateToDTFecha(rs.getDate("paq_fecha_inicio")),dateToDTFecha(rs.getDate("paq_fecha_fin")),rs.getFloat("paq_costo"),rs.getFloat("paq_descuento"),dateToDTFecha(rs.getDate("paq_fecha_compra")));
//                System.out.println(a.getNombre());
//            }
//    } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//       return a;
//   }
    
    public Map<String, Paquete> getPaquetesQueComproUsuario(int idUsuario) {
        Map<String, Paquete> resultado = new HashMap<>();
        try {
            PreparedStatement status = conexion.prepareStatement("SELECT paquetes.* FROM paquetes, compra_paquetes WHERE compra_paquetes.compra_usu_id=paquetes.paq_id AND compra_paquetes.compra_usu_id=?)");
            status.setInt(1, idUsuario);
            ResultSet rs = status.executeQuery();
            while (rs.next()) {
                //dateToDTFecha(rs.getDate("paq_fecha_inicio"));
                //UTILIZAR AQUÍ EL NUEVO resultado.put QUE UTILIZA DIETER EN CONSUTLA PAQUETES
                //resultado.put(rs.getString("paq_nombre"), new Paquete(rs.getString("paq_nombre"), rs.getString("paq_descripcion"), dateToDTFecha(rs.getDate("paq_fecha_inicio")), dateToDTFecha(rs.getDate("paq_fecha_fin")),rs.getFloat("paq_costo"), rs.getFloat("paq_descuento"), dateToDTFecha(rs.getDate("paq_fecha_compra"))));
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }            
    
    public Map<String, Paquete> getPaqueteV2() {
        Map<String, Paquete> resultado = new HashMap<>();
        try {
            PreparedStatement status = conexion.prepareStatement("SELECT * FROM paquetes");
            ResultSet rs = status.executeQuery();
            
            while (rs.next()) {
                dateToDTFecha(rs.getDate("paq_fecha_inicio"));
                //dateToDTFecha(rs.getDate("paq_fecha_alta"));
                resultado.put(rs.getString("paq_nombre"), new Paquete(rs.getString("paq_nombre"), rs.getString("paq_descripcion"), dateToDTFecha(rs.getDate("paq_fecha_inicio")), dateToDTFecha(rs.getDate("paq_fecha_fin")),rs.getFloat("paq_costo"), rs.getFloat("paq_descuento"), dateToDTFecha(rs.getDate("paq_fecha_compra")) ,rs.getString("paq_imagen") , dateToDTFecha(rs.getDate("paq_fecha_alta")), rs.getBoolean("paq_vigente"))); 
                //String nombre_, String Descripcion_, DTFecha Fecha_Inicio_, DTFecha Fecha_Fin_, float Costo_, Float Descuento_, DTFecha Fecha_Compra_,String url_, DTFecha Fecha_alta_, boolean vigencia_)
                //System.out.println("Nombre: "+ rs.getString("paq_nombre")+"Descripcion: "+ rs.getString("paq_descripcion")+"Costo: "+ rs.getFloat("paq_costo")+"Descuento: "+ rs.getFloat("paq_descuento"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return resultado;
    }
    
    public Map<String, Paquete> getPaquetesUsuario(String nickUsuario){
        Map<String, Paquete> mapPaquetes = new HashMap<>();
        try {
            PreparedStatement status = conexion.prepareStatement("SELECT * FROM paquetes, compra_paquetes WHERE compra_paquetes.compra_usu_id=paquetes.paq_id AND compra_paquetes.compra_usu_id IN (SELECT usu_id FROM usuario, paquete_espetaculos WHERE usuario.usu_id=paquete_espetaculos.paqespec_paq_id AND usuario.usu_nick = ?))");
            status.setString(1, nickUsuario);
            ResultSet rs = status.executeQuery();
            while (rs.next()) {
                mapPaquetes.put(rs.getString("paq_nombre"), new Paquete(rs.getString("paq_nombre"), rs.getString("paq_descripcion"), dateToDTFecha(rs.getDate("paq_fecha_inicio")), dateToDTFecha(rs.getDate("paq_fecha_fin")),rs.getFloat("paq_costo"), rs.getFloat("paq_descuento"), dateToDTFecha(rs.getDate("paq_fecha_compra")) ,rs.getString("paq_imagen") , dateToDTFecha(rs.getDate("paq_fecha_alta")), rs.getBoolean("paq_vigente")));
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
        return mapPaquetes;
    }
    
    public Map<String, Paquete> obtenerMapPaquetesVigentesEspectaculoUsuario(String nickUsuario, String nomEspectaculo){
        Map<String, Paquete> mapPaquetesEspectaculo = getPaquetesDeEspectaculo(nomEspectaculo);
        Map<String, Paquete> mapPaquetesUsuario = getPaquetesUsuario(nickUsuario);
        for (Map.Entry entry : mapPaquetesUsuario.entrySet()) {
            if (!mapPaquetesEspectaculo.containsKey(entry.getKey())) {
                mapPaquetesUsuario.remove(entry.getKey());
            }
        }
        return mapPaquetesUsuario;
    }
    
}
