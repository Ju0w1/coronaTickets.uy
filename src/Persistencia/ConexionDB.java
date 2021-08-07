package Persistencia;
 
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ConexionDB {
    private final String host=this.LeerProperties("host");
    private final String port=this.LeerProperties("port");
    private final String db=this.LeerProperties("db");
    private final String user=this.LeerProperties("user");
    private final String pass=this.LeerProperties("pass");
   
    
    //Para hacer ConexionDB singleton descomentar
    //private static Connection conexion=null;
    private Connection conexion=null;
    //Para hacer ConexionDB singleton descomentar
    //private ConexionDB(){};
    public ConexionDB(){};
    //Para hacer ConexionDB singleton descomentar
    //public static Connection getConexion() {
    
    public String LeerProperties(String caso) {
        
        Properties prop = new Properties();
        InputStream archivo = null;

        try {
            archivo = new FileInputStream(System.getProperty("user.dir") + "\\Config.properties");
            prop.load(archivo);

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }     
        
        switch (caso) {
            case "host":  return prop.getProperty("host");
       
            case "port":  return prop.getProperty("port");
                     
            case "db":  return prop.getProperty("db");
                     
            case "user":  return prop.getProperty("user");
                     
            case "pass":  return prop.getProperty("pass");

            default: return "";
              
        }     
    }
   
    public Connection getConexion() {
           
        if (conexion == null) {
            try {
                Driver driver = new com.mysql.jdbc.Driver();
                DriverManager.registerDriver(driver);
                conexion = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+db, user, pass);
            } catch (SQLException ex) {
                ex.printStackTrace();
                Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return conexion;
    }
    
    public void cerrar(){
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        
    }
    
}