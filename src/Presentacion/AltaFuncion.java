/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.Clases.Artista;
import Logica.DataTypes.DTFecha;
import Logica.DataTypes.DTTimeStamp;
import Logica.Fabrica;
import Logica.Interfaz.IControladorEspectaculo;
import Logica.Interfaz.IControladorFuncion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import Logica.Servicios.FuncionServicios;


public class AltaFuncion extends javax.swing.JInternalFrame {
    
    //private FuncionServicios servicioFuncion;
    private IControladorFuncion ICF;
    Map<String, Artista> artistas = new HashMap<>();
    
    public AltaFuncion(){
        initComponents();
        
        PlataformaBox.removeAllItems();
        EspectaculoBox.removeAllItems();
        this.ICF = Fabrica.getInstance().getIControladorFuncion();
        this.ICF.obtenerPlataformas(PlataformaBox);
        this.ICF.obtenerArtistas(Lista_Artistas);
        
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        PlataformaBox = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        EspectaculoBox = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Fecha_Inicio_Dia = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        Fecha_Inicio_Mes = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        Fecha_Inicio_Anio = new javax.swing.JTextField();
        Hora_Hr = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Hora_Min = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        Lista_Artistas = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        Boton_Agregar_Artista = new javax.swing.JButton();
        Boton_Crear = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();

        jScrollPane1.setViewportView(jTree1);

        setTitle("Alta funcion");
        setPreferredSize(new java.awt.Dimension(500, 600));

        jLabel7.setText("Plataforma:");

        PlataformaBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setText("Espetaculo:");

        EspectaculoBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        EspectaculoBox.setEnabled(false);

        jLabel9.setText("Nombre:");

        txtNombre.setName("nombretxt"); // NOI18N

        jLabel10.setText("Fecha inicio");

        jLabel11.setText("Hora inicio");

        Fecha_Inicio_Dia.setToolTipText("");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("/");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("/");

        jLabel2.setText(":");

        Lista_Artistas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(Lista_Artistas);

        jLabel3.setText("Artistas invitados:");

        Boton_Agregar_Artista.setText("Agregar Artista");
        Boton_Agregar_Artista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_Agregar_ArtistaActionPerformed(evt);
            }
        });

        Boton_Crear.setText("Crear");
        Boton_Crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_CrearActionPerformed(evt);
            }
        });

        jButton3.setText("Cancelar");
        jButton3.setActionCommand("cancelar");

        btnBuscar.setText("Buscar");
        btnBuscar.setActionCommand("cancelar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(PlataformaBox, 0, 132, Short.MAX_VALUE)
                                    .addComponent(txtNombre)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Hora_Hr, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                                    .addComponent(Fecha_Inicio_Dia))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Fecha_Inicio_Mes, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Hora_Min)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Fecha_Inicio_Anio, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBuscar)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(EspectaculoBox, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Boton_Agregar_Artista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(18, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(Boton_Crear)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(PlataformaBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(EspectaculoBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(Fecha_Inicio_Dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(Fecha_Inicio_Mes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(Fecha_Inicio_Anio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Hora_Hr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(Hora_Min, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Boton_Agregar_Artista)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 287, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Boton_Crear)
                    .addComponent(jButton3))
                .addContainerGap())
        );

        PlataformaBox.getAccessibleContext().setAccessibleName("plataformas");
        EspectaculoBox.getAccessibleContext().setAccessibleName("espetaculo");
        txtNombre.getAccessibleContext().setAccessibleName("nombre_text");
        Fecha_Inicio_Dia.getAccessibleContext().setAccessibleName("fechaDia");
        Fecha_Inicio_Mes.getAccessibleContext().setAccessibleName("fechaMes");
        Fecha_Inicio_Anio.getAccessibleContext().setAccessibleName("fechaAnio");
        Hora_Hr.getAccessibleContext().setAccessibleName("fechaHora");
        Hora_Min.getAccessibleContext().setAccessibleName("fechaMinuto");
        jScrollPane2.getAccessibleContext().setAccessibleName("actoresAsignado");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Boton_Agregar_ArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_Agregar_ArtistaActionPerformed
        //System.out.println(this.Lista_Artistas.getSelectedValue());
        Artista art;
        String artista =this.Lista_Artistas.getSelectedValue();
        int posicion = this.Lista_Artistas.getSelectedIndex();
        art = this.ICF.obtenerArtista(artista);
        this.artistas.put(artista, art);
        DefaultListModel listModel1 = (DefaultListModel) this.Lista_Artistas.getModel();
        
        listModel1.removeElementAt(posicion);
        //System.out.println(this.artistas.isEmpty());
//        int dia=0,mes=0,anio=0;
//        if (txtNombre.getText().equals("") || Fecha_Inicio_Dia.getText().equals("") || Fecha_Inicio_Mes.getText().equals("") || Fecha_Inicio_Anio.getText().equals("") || Hora_Hr.getText().equals("") || Hora_Min.getText().equals("")) {
//            JOptionPane.showMessageDialog(this, "Ingrese todos los datos por favor");
//        }else{
//            //System.out.println(this.Lista_Artistas.getSelectedValue().toString());
//            String nombre_artista=this.Lista_Artistas.getSelectedValue().toString();
//            String nombre_funcion=txtNombre.getText();
//            String id_funcion="";
//            String id_artista="";
//            dia=Integer.parseInt(Fecha_Inicio_Dia.getText());
//            mes=Integer.parseInt(Fecha_Inicio_Mes.getText());
//            anio=Integer.parseInt(Fecha_Inicio_Anio.getText());
//            DTFecha funcion_vigente= new DTFecha(dia,mes,anio);
//            this.ICF.Prueba(nombre_artista,id_funcion,id_artista,nombre_funcion,funcion_vigente);
//            //funart_id funart_art_id fun_nombre funart_vigente  
//        }
        
    
    }//GEN-LAST:event_Boton_Agregar_ArtistaActionPerformed

    private void Boton_CrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_CrearActionPerformed
        int dia_comienzo,mes_comienzo,anio_comienzo,dia_registro,mes_registro,anio_registro,hr,min,seg=00;
        String nombreEspectaculo=this.EspectaculoBox.getSelectedItem().toString();
        
        dia_comienzo=Integer.parseInt(Fecha_Inicio_Dia.getText());
        mes_comienzo=Integer.parseInt(Fecha_Inicio_Mes.getText());
        anio_comienzo=Integer.parseInt(Fecha_Inicio_Anio.getText());
        
        hr=Integer.parseInt(Hora_Hr.getText());
        min=Integer.parseInt(Hora_Min.getText());
        
        DTFecha fecha_comienzo = new DTFecha(dia_comienzo,mes_comienzo,anio_comienzo);
        DTTimeStamp hora_inicio = new DTTimeStamp(fecha_comienzo,hr,min,seg);
        
        dia_registro=(java.time.LocalDate.now().getDayOfMonth());
        mes_registro=(java.time.LocalDate.now().getMonth().getValue());
        anio_registro=(java.time.LocalDate.now().getYear());
        
        DTFecha fecha_registro = new DTFecha(dia_registro,mes_registro,anio_registro);
        
        if (txtNombre.getText().equals("") || Fecha_Inicio_Dia.getText().equals("") || Fecha_Inicio_Mes.getText().equals("") || Fecha_Inicio_Anio.getText().equals("") || Hora_Hr.getText().equals("") || Hora_Min.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Ingrese todos los datos por favor");
        }else{
            this.ICF.addFuncion(nombreEspectaculo,txtNombre.getText(),fecha_registro,hora_inicio,fecha_comienzo,artistas);
        }
    }//GEN-LAST:event_Boton_CrearActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
       // System.out.println(this.PlataformaBox.getSelectedItem().toString());
       this.EspectaculoBox.setEnabled(true);
       DefaultComboBoxModel modelo = (DefaultComboBoxModel) this.EspectaculoBox.getModel();
       modelo.removeAllElements();
       this.ICF.obtenerEspectaculo(EspectaculoBox, this.PlataformaBox.getSelectedItem().toString());
        
    }//GEN-LAST:event_btnBuscarActionPerformed
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Boton_Agregar_Artista;
    private javax.swing.JButton Boton_Crear;
    public static javax.swing.JComboBox<String> EspectaculoBox;
    private javax.swing.JTextField Fecha_Inicio_Anio;
    private javax.swing.JTextField Fecha_Inicio_Dia;
    private javax.swing.JTextField Fecha_Inicio_Mes;
    private javax.swing.JTextField Hora_Hr;
    private javax.swing.JTextField Hora_Min;
    public static javax.swing.JList<String> Lista_Artistas;
    public static javax.swing.JComboBox<String> PlataformaBox;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTree jTree1;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
