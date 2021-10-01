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
import Logica.Servicio.FuncionServicios;


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
        jScrollPane2 = new javax.swing.JScrollPane();
        Lista_Artistas = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();
        Boton_Agregar_Artista = new javax.swing.JButton();
        Boton_Crear = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        Fecha_Inicio_Dia = new javax.swing.JSpinner();
        Fecha_Inicio_Mes = new javax.swing.JSpinner();
        Fecha_Inicio_Anio = new javax.swing.JSpinner();
        Hora_Min = new javax.swing.JSpinner();
        Hora_Hr = new javax.swing.JSpinner();

        jScrollPane1.setViewportView(jTree1);

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Alta funcion");
        setMinimumSize(new java.awt.Dimension(340, 528));
        setPreferredSize(new java.awt.Dimension(340, 528));

        jPanel2.setPreferredSize(new java.awt.Dimension(530, 279));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setText("Plataforma:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        PlataformaBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        PlataformaBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                PlataformaBoxItemStateChanged(evt);
            }
        });
        jPanel2.add(PlataformaBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 210, -1));
        PlataformaBox.getAccessibleContext().setAccessibleName("plataformas");

        jLabel8.setText("Espetaculo:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        EspectaculoBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        EspectaculoBox.setEnabled(false);
        jPanel2.add(EspectaculoBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 210, -1));
        EspectaculoBox.getAccessibleContext().setAccessibleName("espetaculo");

        jLabel9.setText("Nombre:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        txtNombre.setName("nombretxt"); // NOI18N
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 220, -1));
        txtNombre.getAccessibleContext().setAccessibleName("nombre_text");

        jLabel10.setText("Fecha inicio");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, 20));

        jLabel11.setText("Hora inicio");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, 20));

        Lista_Artistas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(Lista_Artistas);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 188, 80));
        jScrollPane2.getAccessibleContext().setAccessibleName("actoresAsignado");

        jLabel3.setText("Seleccionar artistas invitados");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 270, -1, -1));

        Boton_Agregar_Artista.setText("Agregar Artista");
        Boton_Agregar_Artista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_Agregar_ArtistaActionPerformed(evt);
            }
        });
        jPanel2.add(Boton_Agregar_Artista, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 188, -1));

        Boton_Crear.setText("Crear");
        Boton_Crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Boton_CrearActionPerformed(evt);
            }
        });
        jPanel2.add(Boton_Crear, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, 80, -1));

        jButton3.setText("Cancelar");
        jButton3.setActionCommand("cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 430, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText(":");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 10, 20));

        Fecha_Inicio_Dia.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));
        jPanel2.add(Fecha_Inicio_Dia, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, -1, -1));

        Fecha_Inicio_Mes.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));
        jPanel2.add(Fecha_Inicio_Mes, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, -1, -1));

        Fecha_Inicio_Anio.setModel(new javax.swing.SpinnerNumberModel(2021, 2021, null, 1));
        Fecha_Inicio_Anio.setPreferredSize(new java.awt.Dimension(50, 20));
        jPanel2.add(Fecha_Inicio_Anio, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 87, 28));

        Hora_Min.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));
        jPanel2.add(Hora_Min, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, -1, -1));

        Hora_Hr.setModel(new javax.swing.SpinnerNumberModel(0, 0, 24, 1));
        jPanel2.add(Hora_Hr, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 498, Short.MAX_VALUE)
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
        System.out.println("Alta funcion estado de map artistas:"+this.artistas.isEmpty());
        DefaultListModel listModel1 = (DefaultListModel) this.Lista_Artistas.getModel();
        listModel1.removeElementAt(posicion);

    
    }//GEN-LAST:event_Boton_Agregar_ArtistaActionPerformed

    private void Boton_CrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Boton_CrearActionPerformed
        int dia_comienzo,mes_comienzo,anio_comienzo,dia_registro,mes_registro,anio_registro,hr,min,seg=00;
        String nombreEspectaculo=this.EspectaculoBox.getSelectedItem().toString();
        
        dia_comienzo=(int) Fecha_Inicio_Dia.getValue();
        mes_comienzo=(int) Fecha_Inicio_Mes.getValue();
        anio_comienzo=(int) Fecha_Inicio_Anio.getValue();
        if(Fabrica.getInstance().getIControladorUsuario().controlFecha(dia_comienzo, mes_comienzo, anio_comienzo) == false){
            JOptionPane.showMessageDialog(this, "Fecha incorrecta");
        } else {
            //hr=Hora_Hr.getValue().toString();
            hr=Integer.parseInt(Hora_Hr.getValue().toString());
            min=Integer.parseInt(Hora_Min.getValue().toString());

            DTFecha fecha_comienzo = new DTFecha(dia_comienzo,mes_comienzo,anio_comienzo);
            DTTimeStamp hora_inicio = new DTTimeStamp(fecha_comienzo,hr,min,seg);

            dia_registro=(java.time.LocalDate.now().getDayOfMonth());
            mes_registro=(java.time.LocalDate.now().getMonth().getValue());
            anio_registro=(java.time.LocalDate.now().getYear());

            DTFecha fecha_registro = new DTFecha(dia_registro,mes_registro,anio_registro);

            if (txtNombre.getText().equals("") || Fecha_Inicio_Dia.getValue().equals("") || Fecha_Inicio_Mes.getValue().equals("") || Fecha_Inicio_Anio.getValue().equals("") || Hora_Hr.getValue().toString().equals("") || Hora_Min.getValue().toString().equals("")) {
                JOptionPane.showMessageDialog(this, "Ingrese todos los datos por favor");
            }else{
                if (this.ICF.addFuncion(nombreEspectaculo,txtNombre.getText(),fecha_registro,hora_inicio,fecha_comienzo,artistas)){
                    JOptionPane.showMessageDialog(this, "Funcion agregada con exito");
                }
                this.dispose();
            }
        }
    }//GEN-LAST:event_Boton_CrearActionPerformed

    private void PlataformaBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_PlataformaBoxItemStateChanged
        // TODO add your handling code here:
       if(this.PlataformaBox.getSelectedItem() != null){
           
            this.EspectaculoBox.setEnabled(true);
            DefaultComboBoxModel modelo = (DefaultComboBoxModel) this.EspectaculoBox.getModel();
            modelo.removeAllElements();
            this.ICF.obtenerEspectaculo(EspectaculoBox, this.PlataformaBox.getSelectedItem().toString());
       }else{
           //JOptionPane.showMessageDialog(this, "Cargando plataformas");
       }
    }//GEN-LAST:event_PlataformaBoxItemStateChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed
 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Boton_Agregar_Artista;
    private javax.swing.JButton Boton_Crear;
    public static javax.swing.JComboBox<String> EspectaculoBox;
    private javax.swing.JSpinner Fecha_Inicio_Anio;
    private javax.swing.JSpinner Fecha_Inicio_Dia;
    private javax.swing.JSpinner Fecha_Inicio_Mes;
    private javax.swing.JSpinner Hora_Hr;
    private javax.swing.JSpinner Hora_Min;
    public static javax.swing.JList<String> Lista_Artistas;
    public static javax.swing.JComboBox<String> PlataformaBox;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
