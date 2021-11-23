/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica.Servicio;

import Persistencia.ConexionDB;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pabli
 */
public class DatosDePruebaServicio {
    private Connection conexion = new ConexionDB().getConexion();
    
    public DatosDePruebaServicio() {
    }
    
    public void cargarDatosDePrueba(){
        try {
            System.out.println("Cargando");
            
            Statement s = conexion.createStatement();
            
            String sql1 = "DELETE FROM usuario_funcion";
            String sql2 = "DELETE FROM funcion_artista";
            String sql3 = "DELETE FROM premios_espectadores";
            String sql4 = "DELETE FROM favoritos";
            String sql5 = "DELETE FROM paquete_espetaculos";
            String sql6 = "DELETE FROM categorias_espectaculosa";
            String sql7 = "DELETE FROM espetaculos";
            String sql8 = "DELETE FROM artistas";
            String sql9 = "DELETE FROM compra_linea";
            String sql10 = "DELETE FROM compra";
            String sql11 = "DELETE FROM categorias";
            String sql12 = "DELETE FROM compra_paquetes";
            String sql13 = "DELETE FROM paquetes";
            String sql14 = "DELETE FROM funcion";
            String sql15 = "DELETE FROM seguidores";
            String sql16 = "DELETE FROM usuario";
            String sql17 = "DELETE FROM valores_tipo";
            
            String sql18 = "ALTER TABLE artistas AUTO_INCREMENT = 0";
            String sql19 = "ALTER TABLE categorias AUTO_INCREMENT = 0";
            String sql20 = "ALTER TABLE compra AUTO_INCREMENT = 0";
            String sql21 = "ALTER TABLE compra_linea AUTO_INCREMENT = 0";
            String sql22 = "ALTER TABLE compra_paquetes AUTO_INCREMENT = 0";
            String sql23 = "ALTER TABLE espetaculos AUTO_INCREMENT = 0";
            String sql24 = "ALTER TABLE favoritos AUTO_INCREMENT = 0";
            String sql25 = "ALTER TABLE funcion AUTO_INCREMENT = 0";
            String sql26 = "ALTER TABLE compra_paquetes AUTO_INCREMENT = 0";
            String sql27 = "ALTER TABLE paquetes AUTO_INCREMENT = 0";
            String sql28 = "ALTER TABLE premios AUTO_INCREMENT = 0";
            String sql29 = "ALTER TABLE premios_espectadores AUTO_INCREMENT = 0";
            String sql30 = "ALTER TABLE usuario AUTO_INCREMENT = 0";
            String sql31 = "ALTER TABLE usuario_funcion AUTO_INCREMENT = 0";
            String sql32 = "ALTER TABLE valores_tipo AUTO_INCREMENT = 0";
            
            String sql33 = "INSERT INTO usuario (usu_nick, usu_nombre, usu_apellido, usu_mail, usu_nacimiento, usu_contrasenia) VALUES\n" +
                    "    ('eleven11','Eleven','Ten','eleven11@gmail.com','1971-12-31 00:00:00',SHA2('root', 256)),\n" +
                    "    ('costas','Gerardo','Costas','gcostas@gmail.com','1983-11-15 00:00:00',SHA2('root', 256)),\n" +
                    "    ('waston','Emma','Watson','e.watson@gmail.com','1990-04-15 00:00:00',SHA2('root', 256)),\n" +
                    "    ('house','Gregory','House','greghouse@gmail.com','1959-05-15 00:00:00',SHA2('root', 256)),\n" +
                    "    ('sergiop','Sergio','Puglia','puglia@alpanpan.com.uy','1950-01-28 00:00:00',SHA2('root', 256)),\n" +
                    "    ('chino','Alvaro','Recoba','chino@trico.org.uy','1976-03-17 00:00:00',SHA2('root', 256)),\n" +
                    "    ('tonyp','Antonio','Pacheco','eltony@manya.org.uy','1955-02-14 00:00:00',SHA2('root', 256)),\n" +
                    "    ('lachiqui','Mirtha','Legrand','lachiqui@hotmail.com.ar','1927-02-23 00:00:00',SHA2('root', 256)),\n" +
                    "    ('cbochinche','Cacho','Bochinche','cbochinche@vera.com.uy','1937-05-08 00:00:00',SHA2('root', 256)),\n" +
                    "    ('vpeople','Village','People','vpeople@tuta.io','1977-01-01 00:00:00',SHA2('root', 256)),\n" +
                    "    ('dmode','Depeche','Mode','dmode@tuta.io','1980-06-14 00:00:00',SHA2('root', 256)),\n" +
                    "    ('clauper','Cyndi','Lauper','clauper@hotmail.com','1953-06-22 00:00:00',SHA2('root', 256)),\n" +
                    "    ('bruceTheBoss','Bruce','Springsteen','bruceTheBoss@gmail.com','1949-09-23 00:00:00',SHA2('root', 256)),\n" +
                    "    ('tripleNelson','La Triple','Nelson','tripleNelson@tuta.io','1998-01-01 00:00:00',SHA2('root', 256)),\n" +
                    "    ('la_ley','La','Ley','la_ley@tuta.io','1987-02-14 00:00:00',SHA2('root', 256)),\n" +
                    "    ('lospimpi','Pimpinela','Pimpinela','lospimpi@gmail.com','1981-08-13 00:00:00',SHA2('root', 256)),\n" +
                    "    ('dyangounchained','Dyango','Ango','dyangounchained@gmail.com','1940-03-05 00:00:00',SHA2('root', 256)),\n" +
                    "    ('alcides','Alcides','Violeta','alcides@tuta.io','1952-07-17 00:00:00',SHA2('root', 256))";
            String sql34 = "INSERT INTO artistas (art_usu, art_descripcion, art_biografia, art_url) VALUES\n" +
                    "    (10,'Village People es una innovadora formacion musical de estilo disco de finales de los anios 70. Fue famosa tanto por sus peculiares disfraces, como por sus canciones pegadizas, con letras sugerentes y llenas de dobles sentidos.','Grupo americano del disco creado por Jacques Morali y Henry Belolo en 1977. Segun Marjorie Burgess, todo comenzo cuando Morali fue a un bar gay de Nueva York una noche y noto al bailarin Felipe Rose vestido como un nativo americano.','www.officialvillagepeople.com'),\n" +
                    "    (11,'Depeche Mode es un grupo ingles de musica electronica formado en Basildon, Essex, en 1980 por Vicent Clarke y Andrew John Fletcher, a los que se unieron Martin Lee Gore y poco despues David Gahan. Actualmente se le considera como grupo de musica alternativa.',\"\",'www.depechemode.com'),\n" +
                    "    (12,'Cynthia Ann Stephanie Lauper, conocida simplemente como Cyndi Lauper, es una cantautora, actriz y empresaria estadounidense. Despues de participar en el grupo musical, Blue Angel, en 1983 firmo con Portrait Records (filial de Epic Records) y lanzo su exitoso album debut She''s So Unusual a finales de ese mismo anio. Siguio lanzando una serie de albumes en los que encontro una inmensa popularidad, superando los limites de contenido de las letras de sus canciones.','Cynthia Ann Stephanie Lauper​ (Brooklyn, Nueva York; 22 de junio de 1953).','cyndilauper.com'),\n" +
                    "    (13,'Bruce Frederick Joseph Springsteen (Long Branch, Nueva Jersey, 23 de septiembre de 1949),​ mas conocido como Bruce Springsteen, es un cantante, musico y compositor estadounidense.',\"\",'brucespringsteen.net'),\n" +
                    "    (14,'La Triple Nelson es un grupo de rock uruguayo formado en enero de 1998 e integrado inicialmente por Christian Cary (guitarra y voz), Fernando \"Paco\" Pintos (bajo y coros) y Ruben Otonello (actualmente su nuevo baterista es Rafael Ugo).',\"\",'www.latriplenelson.uy'),\n" +
                    "    (15,'La Ley fue una banda chilena de rock formada en 1987 por iniciativa del tecladista y guitarrista. En un principio, La Ley tenia la aspiración de ser un grupo de musica tecno. Este disco resulta ser un exito de ventas y reciben una invitacion al Festival Internacional de Vinia del Mar de febrero de 1994.',\"\",'www.lasleyesdenewton.com'),\n" +
                    "    (16,'Pimpinela es un duo musical argentino compuesto por los hermanos Lucia Galan y Joaquin Galan. Pimpinela ha editado veinticuatro discos',\"\",'www.pimpinela.net'),\n" +
                    "    (17,'Jose Gomez Romero, conocido artisticamente como Dyango es un cantante espaniol de musica romantica.',\"\",\"\"),\n" +
                    "    (18,'Su carrera comienza en 1976 cuando forma la banda Los Playeros junto a su hermano Victor. Al poco tiempo se mudan a San Luis donde comienzan a hacerse conocidos en la escena musical. Su exito a nivel nacional llega a comienzos de los anios 1990 cuando desembarca en Buenos Aires y graba el exito \"Violeta\", originalmente compuesta e interpretada en 1985 por el musico brasilenio Luiz Caldas bajo el titulo \"Fricote\".',\"\",\"\")";
            String sql35 = "INSERT INTO valores_tipo (tp_id, vp_nombre, vp_valor_2, vp_valor_1) VALUES\n" +
                    "    (1.0,'Instagram Live','Funcionalidad de la red social Instagram, con la que los usuarios pueden transmitir videos en vivo.','https://www.instagram.com/liveoficial'),\n" +
                    "    (1.0,'Facebook Watch','Servicio de video bajo demanda operado por Facebook.','https://www.facebook.com/watch/'),\n" +
                    "    (1.0,'Twitter Live','Aplicacion de Twitter para la transmision de video en directo (streaming).','https://twitter.com/'),\n" +
                    "    (1.0,'Youtube','Sitio web de origen estadounidense dedicado a compartir videos.','https://www.youtube.com/')";
            String sql36 = "INSERT INTO espetaculos (espec_artista, espec_plataforma, espec_nombre, espec_descripcion, espec_duracion, espec_cant_min_espect, espec_cant_max_espect, espec_url, espec_costo, espec_fecha_registro, espec_estado) VALUES    \n" +
                    "    (1.0,1.0,'Los Village Volvieron','Espectaculo de retorno de los Village People.',90.0,10.0,800.0,'https://www.instagram.com/realvillagepeople/',550.0,'2020-03-31 00:00:00','a'),\n" +
                    "    (2.0,2.0,'Global Spirit','Espectaculo donde se presenta el album Spirit.',120.0,30.0,1300.0,'https://es-la.facebook.com/depechemode/',750.0,'2020-04-20 00:00:00','a'),\n" +
                    "    (3.0,3.0,'Memphis Blues World','Espectaculo promoviendo album Memphis Blues.',110.0,5.0,1000.0,'https://twitter.com/cyndilauper',800.0,'2020-05-30 00:00:00','a'),\n" +
                    "    (4.0,4.0,'Springsteen on Broadway','Springsteen tocando guitarra o piano y relatando anecdotas recogidas en su autobiografia de 2016, Born to Run.',100.0,100.0,1500.0,'https://www.youtube.com/BruceSpringsteen',980.0,'2020-06-07 00:00:00','a'),\n" +
                    "    (6.0,3.0,'Bien de Familia','El duo estara presentando sus mas sonados exitos y tambien nuevas canciones .',150.0,10.0,500.0,'https://twitter.com/PimpinelaNet',500.0,'2020-07-08 00:00:00','a'),\n" +
                    "    (9.0,3.0,'30 anios','Espectaculo conmemorando los 30 anios de Violeta.',80.0,30.0,150.0,'https://twitter.com/alcides_shows',450.0,'2020-07-31 00:00:00','a')";
            String sql37 = "INSERT INTO funcion (fun_espec_id,fun_nombre,fun_fecha_inicio,fun_hora_inicio,  fun_fecha_registro) VALUES\n" +
                    "    (1.0,'Los Village Volvieron - 1','2020-04-15 00:00:00','15:30:00','2020-03-31 00:00:00'),\n" +
                    "    (1.0,'Los Village Volvieron - 2','2020-05-01 00:00:00','17:00:00','2020-03-31 00:00:00'),\n" +
                    "    (1.0,'Los Village Volvieron - 3','2020-06-01 00:00:00','18:00:00','2020-03-31 00:00:00'),\n" +
                    "    (2.0,'Global Spirit (I)','2020-06-10 00:00:00','19:00:00','2020-04-20 00:00:00'),\n" +
                    "    (2.0,'Global Spirit (II)','2020-07-10 00:00:00','20:00:00','2020-04-20 00:00:00'),\n" +
                    "    (2.0,'Global Spirit (III)','2020-08-10 00:00:00','17:45:00','2020-04-20 00:00:00'),\n" +
                    "    (3.0,'Memphis Blues World - A','2020-08-15 00:00:00','16:30:00','2020-05-30 00:00:00'),\n" +
                    "    (3.0,'Memphis Blues World - B','2020-08-31 00:00:00','19:30:00','2020-05-30 00:00:00'),\n" +
                    "    (3.0,'Memphis Blues World - C','2020-09-30 00:00:00','20:00:00','2020-05-30 00:00:00'),\n" +
                    "    (4.0,'Springsteen on Broadway - i','2020-09-01 00:00:00','19:30:00','2020-06-07 00:00:00'),\n" +
                    "    (4.0,'Springsteen on Broadway - ii','2020-09-30 00:00:00','17:00:00','2020-06-07 00:00:00'),\n" +
                    "    (4.0,'Springsteen on Broadway - iii','2020-10-15 00:00:00','20:00:00','2020-06-07 00:00:00'),\n" +
                    "    (5.0,'Bien de Familia - A','2020-09-25 00:00:00','19:00:00','2020-07-08 00:00:00'),\n" +
                    "    (5.0,'Bien de Familia - B','2020-10-25 00:00:00','18:30:00','2020-07-08 00:00:00'),\n" +
                    "    (5.0,'Bien de Familia - C','2020-11-25 00:00:00','17:45:00','2020-07-08 00:00:00'),\n" +
                    "    (6.0,'30 anios - 1','2020-09-01 00:00:00','21:00:00','2020-07-31 00:00:00'),\n" +
                    "    (6.0,'30 anios - 2','2020-10-01 00:00:00','21:00:00','2020-07-31 00:00:00')";
            String sql38 = "INSERT INTO funcion_artista (funart_fun_id, funart_art_id) VALUES\n" +
                    "    (1,3.0),\n" +
                    "    (2,4.0),\n" +
                    "    (2,4.0),\n" +
                    "    (3,3.0),\n" +
                    "    (4,1.0),\n" +
                    "    (5,3.0),\n" +
                    "    (5,4.0),\n" +
                    "    (6,7.0),\n" +
                    "    (7,4.0),\n" +
                    "    (8,4.0),\n" +
                    "    (8,2.0),\n" +
                    "    (9,7.0),\n" +
                    "    (9,4.0),\n" +
                    "    (10,2.0),\n" +
                    "    (10,5.0),\n" +
                    "    (11,5.0),\n" +
                    "    (11,6.0),\n" +
                    "    (12,6.0),\n" +
                    "    (13,9.0),\n" +
                    "    (14,5.0),\n" +
                    "    (16,8.0),\n" +
                    "    (17,7.0),\n" +
                    "    (17,8.0)";
            String sql39 = "INSERT INTO usuario_funcion(funcion_id, usu_id, fechaRegistro, canjeado) VALUES\n" +
                    "    (1,2,'2020-04-09 00:00:00',1.0),\n" +
                    "    (1,5,'2020-04-10 00:00:00',1.0),\n" +
                    "    (1,6,'2020-04-12 00:00:00',1.0),\n" +
                    "    (2,6,'2020-04-15 00:00:00',1.0),\n" +
                    "    (2,7,'2020-04-20 00:00:00',0.0),\n" +
                    "    (2,2,'2020-04-25 00:00:00',1.0),\n" +
                    "    (2,8,'2020-04-28 00:00:00',1.0),\n" +
                    "    (3,9,'2020-04-16 00:00:00',0.0),\n" +
                    "    (3,2,'2020-05-15 00:00:00',1.0),\n" +
                    "    (3,8,'2020-05-20 00:00:00',1.0),\n" +
                    "    (4,1,'2020-05-05 00:00:00',0.0),\n" +
                    "    (4,3,'2020-05-10 00:00:00',0.0),\n" +
                    "    (4,5,'2020-05-15 00:00:00',1.0),\n" +
                    "    (4,7,'2020-05-20 00:00:00',0.0),\n" +
                    "    (5,4,'2020-06-08 00:00:00',0.0),\n" +
                    "    (5,3,'2020-06-13 00:00:00',0.0),\n" +
                    "    (5,8,'2020-06-25 00:00:00',1.0),\n" +
                    "    (6,9,'2020-07-05 00:00:00',0.0),\n" +
                    "    (6,5,'2020-07-11 00:00:00',1.0),\n" +
                    "    (6,6,'2020-07-18 00:00:00',1.0),\n" +
                    "    (7,8,'2020-07-19 00:00:00',0.0),\n" +
                    "    (8,1,'2020-08-17 00:00:00',0.0),\n" +
                    "    (8,4,'2020-08-20 00:00:00',0.0),\n" +
                    "    (8,6,'2020-08-23 00:00:00',0.0),\n" +
                    "    (9,2,'2020-08-15 00:00:00',0.0),\n" +
                    "    (9,3,'2020-08-26 00:00:00',0.0),\n" +
                    "    (10,6,'2020-07-19 00:00:00',0.0),\n" +
                    "    (10,7,'2020-08-16 00:00:00',0.0),\n" +
                    "    (10,8,'2020-08-24 00:00:00',0.0),\n" +
                    "    (11,5,'2020-08-01 00:00:00',0.0),\n" +
                    "    (11,4,'2020-08-30 00:00:00',0.0),\n" +
                    "    (12,1,'2020-08-16 00:00:00',0.0),\n" +
                    "    (12,2,'2020-08-16 00:00:00',0.0),\n" +
                    "    (12,3,'2020-09-01 00:00:00',0.0),\n" +
                    "    (12,5,'2020-09-05 00:00:00',0.0),\n" +
                    "    (13,4,'2020-08-16 00:00:00',0.0),\n" +
                    "    (13,9,'2020-09-03 00:00:00',0.0),\n" +
                    "    (14,1,'2020-08-16 00:00:00',0.0),\n" +
                    "    (14,9,'2020-09-06 00:00:00',0.0),\n" +
                    "    (15,2,'2020-09-01 00:00:00',0.0),\n" +
                    "    (16,5,'2020-08-16 00:00:00',0.0),\n" +
                    "    (16,1,'2020-08-20 00:00:00',0.0),\n" +
                    "    (16,7,'2020-08-31 00:00:00',0.0),\n" +
                    "    (17,6,'2020-08-16 00:00:00',0.0),\n" +
                    "    (17,7,'2020-08-20 00:00:00',0.0),\n" +
                    "    (17,2,'2020-09-02 00:00:00',0.0)";
            String sql40 = "INSERT INTO paquetes (paq_nombre, paq_descripcion, paq_descuento, paq_fecha_inicio, paq_fecha_fin,paq_fecha_alta) VALUES\n" +
                    "    ('Paquete de Bandas','Paquete de bandas musicales.',20.0,'2020-05-01 00:00:00','2020-07-31 00:00:00','2020-04-30 00:00:00'),\n" +
                    "    ('Paquete Solistas','Paquete de solistas.',30.0,'2020-08-01 00:00:00','2020-09-30 00:00:00','2020-07-15 00:00:00'),\n" +
                    "    ('Paquete Latino','Paquete de espectáculos latinos.',15.0,'2020-08-15 00:00:00','2020-11-15 00:00:00','2020-08-01 00:00:00')";
            String sql41 = "INSERT INTO paquete_espetaculos (paqespec_paq_id, paqespec_espec_id) VALUES\n" +
                    "    (1.0,1.0),\n" +
                    "    (1.0,2.0),\n" +
                    "    (2.0,3.0),\n" +
                    "    (2.0,4.0),\n" +
                    "    (3.0,5.0),\n" +
                    "    (3.0,6.0)";
            
            s.addBatch(sql1);
            s.addBatch(sql2);
            s.addBatch(sql3);
            s.addBatch(sql4);
            s.addBatch(sql5);
            s.addBatch(sql6);
            s.addBatch(sql7);
            s.addBatch(sql8);
            s.addBatch(sql9);
            s.addBatch(sql10);
            s.addBatch(sql11);
            s.addBatch(sql12);
            s.addBatch(sql13);
            s.addBatch(sql14);
            s.addBatch(sql15);
            s.addBatch(sql16);
            s.addBatch(sql17);
            s.addBatch(sql18);
            s.addBatch(sql19);
            s.addBatch(sql20);
            s.addBatch(sql21);
            s.addBatch(sql22);
            s.addBatch(sql23);
            s.addBatch(sql24);
            s.addBatch(sql25);
            s.addBatch(sql26);
            s.addBatch(sql27);
            s.addBatch(sql28);
            s.addBatch(sql29);
            s.addBatch(sql30);
            s.addBatch(sql31);
            s.addBatch(sql32);
            s.addBatch(sql33);
            s.addBatch(sql34);
            s.addBatch(sql35);
            s.addBatch(sql36);
            s.addBatch(sql37);
            s.addBatch(sql38);
            s.addBatch(sql39);
            s.addBatch(sql40);
            s.addBatch(sql41);
            
            s.executeBatch();
            System.out.println("Finalizado");
        } catch (SQLException ex) {
            System.err.println(ex);
            Logger.getLogger(DatosDePruebaServicio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
