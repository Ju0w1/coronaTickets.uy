/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.DataTypes.DTFecha;
import Logica.Fabrica;
import Logica.Interfaz.IControladorPaquete;
import Logica.Interfaz.IControladorEspectaculo;
import java.awt.Component;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pabli
 */
public class ConsultaPaquete extends javax.swing.JInternalFrame {

    /**
     * Creates new form ConsultaUsuario
     */
    private IControladorPaquete ICU;
    
    public ConsultaPaquete() {
        initComponents();
        //DefaultListModel modelo = (DefaultListModel) listUsuarios.getModel();
        this.ICU = Fabrica.getInstance().getIControladorPaquete();
        this.ICU.obtenerPaquete(this.listPaquetes);
        
        
        
    }
    
    //this.getContentPane().setLayout(new FlowLayout());

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listPaquetes = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listEspectaculos = new javax.swing.JList<>();
        jPanel12 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtNombreArtista = new javax.swing.JLabel();
        txtNombreEspectaculo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtNombreEspectaculos = new javax.swing.JLabel();
        txtDuracion = new javax.swing.JLabel();
        txtCantEspectadoresMinima = new javax.swing.JLabel();
        txtCantEspectadoresMaxima = new javax.swing.JLabel();
        txtURL = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtCosto2 = new javax.swing.JLabel();
        txtFechaRegistro = new javax.swing.JLabel();
        txtNombre2 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDescripcion2 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtFechaInicio = new javax.swing.JTextField();
        txtFechaFin = new javax.swing.JTextField();
        txtDescuento = new javax.swing.JTextField();
        txtFechaCompra = new javax.swing.JTextField();
        txtCosto = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Consulta de Paquete");
        setMaximumSize(new java.awt.Dimension(720, 620));
        setMinimumSize(new java.awt.Dimension(720, 620));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(720, 620));

        listPaquetes.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                listPaquetesFocusGained(evt);
            }
        });
        listPaquetes.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listPaquetesValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listPaquetes);

        jLabel1.setText("Lista de paquetes");

        listEspectaculos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listEspectaculosValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(listEspectaculos);

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        jLabel2.setText("Artista Organizador:");

        txtNombreArtista.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N

        txtNombreEspectaculo.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        txtNombreEspectaculo.setText("Nombre del espect??culo:");

        jLabel5.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        jLabel5.setText("Duraci??n en minutos:");

        jLabel12.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        jLabel12.setText("Cantidad de espectadores m??nima:");

        jLabel14.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        jLabel14.setText("Cantidad de espectadores m??xima:");

        jLabel15.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        jLabel15.setText("Costo");

        txtNombreEspectaculos.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        txtNombreEspectaculos.setText(" ");

        txtDuracion.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        txtDuracion.setText(" ");

        txtCantEspectadoresMinima.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        txtCantEspectadoresMinima.setText(" ");

        txtCantEspectadoresMaxima.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        txtCantEspectadoresMaxima.setText(" ");

        txtURL.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        txtURL.setText(" ");

        jLabel16.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        jLabel16.setText("URL:");

        jLabel17.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        jLabel17.setText("Fecha de registro:");

        txtCosto2.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        txtCosto2.setText(" ");

        txtFechaRegistro.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        txtFechaRegistro.setText(" ");

        txtNombre2.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        txtNombre2.setText("     ");

        jLabel13.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        jLabel13.setText("Descripci??n del espect??culo:");

        txtDescripcion2.setEditable(false);
        txtDescripcion2.setColumns(20);
        txtDescripcion2.setLineWrap(true);
        txtDescripcion2.setRows(5);
        jScrollPane3.setViewportView(txtDescripcion2);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(txtNombreEspectaculo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreEspectaculos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtURL, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCosto2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel13)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCantEspectadoresMaxima, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(txtCantEspectadoresMinima, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreArtista)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombre2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel12Layout.createSequentialGroup()
                            .addComponent(jLabel17)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtFechaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombreArtista)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtNombre2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombreEspectaculos)
                    .addComponent(txtNombreEspectaculo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDuracion)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCantEspectadoresMinima)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCantEspectadoresMaxima)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtURL)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCosto2)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFechaRegistro)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3))
        );

        jLabel3.setText("Espectaculos del paquete");

        jLabel4.setText("Nombre");

        txtNombre.setEditable(false);

        jLabel6.setText("Descripcion");

        txtDescripcion.setEditable(false);
        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });

        jLabel7.setText("Fecha Inicio");

        jLabel10.setText("Fecha Final");

        txtFechaInicio.setEditable(false);
        txtFechaInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaInicioActionPerformed(evt);
            }
        });

        txtFechaFin.setEditable(false);
        txtFechaFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaFinActionPerformed(evt);
            }
        });

        txtDescuento.setEditable(false);
        txtDescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescuentoActionPerformed(evt);
            }
        });

        txtFechaCompra.setEditable(false);
        txtFechaCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFechaCompraActionPerformed(evt);
            }
        });

        txtCosto.setEditable(false);
        txtCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoActionPerformed(evt);
            }
        });

        jLabel11.setText("Fecha Compra");

        jLabel9.setText("Descuento");

        jLabel8.setText("Costo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFechaCompra))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(12, 12, 12))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtDescuento, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFechaInicio, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCosto)
                            .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFechaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void txtFechaInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaInicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaInicioActionPerformed

    private void txtCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCostoActionPerformed

    private void listPaquetesFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_listPaquetesFocusGained
        // TODO add your handling code here:
        
    }//GEN-LAST:event_listPaquetesFocusGained

    private void listPaquetesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listPaquetesValueChanged
        // TODO add your handling code here:
        if(this.listPaquetes.getSelectedValue() != null){
            this.ICU.cargarDatosConsultaPaquete(this.listPaquetes.getSelectedValue(),this.txtNombre, this.txtDescripcion, this.txtFechaInicio, this.txtFechaFin, this.txtCosto, this.txtDescuento, this.txtFechaCompra);
//            this.btnModificar.setEnabled(true);
//            this.btnGuardar.setEnabled(true);
//            this.btnCancelar.setEnabled(true);
            String nombrePaquete = this.listPaquetes.getSelectedValue();
            
            if (Fabrica.getInstance().getIControladorPaquete().getEspectaculos(nombrePaquete, listEspectaculos)){
                //System.out.println("Funciona");
            }
        }else{
            System.out.println("No hay ning??n Paquete seleccionado");
        }
    }//GEN-LAST:event_listPaquetesValueChanged

    private void txtFechaFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaFinActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaFinActionPerformed

    private void txtFechaCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaCompraActionPerformed

    private void txtDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescuentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescuentoActionPerformed

    private void listEspectaculosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listEspectaculosValueChanged
        // TODO add your handling code here:
        IControladorEspectaculo ICE = Fabrica.getInstance().getIControladorEspectaculo();
        ICE.llenarEspectaculos();
        ICE.cargarDatosConsultaEspectaculo(listEspectaculos.getSelectedValue(), this.txtNombre2, this.txtNombreEspectaculos, this.txtDuracion, this.txtCantEspectadoresMinima, this.txtCantEspectadoresMaxima, this.txtURL, this.txtCosto2, this.txtFechaRegistro, this.txtDescripcion2);
    }//GEN-LAST:event_listEspectaculosValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> listEspectaculos;
    private javax.swing.JList<String> listPaquetes;
    private javax.swing.JLabel txtCantEspectadoresMaxima;
    private javax.swing.JLabel txtCantEspectadoresMinima;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JLabel txtCosto2;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextArea txtDescripcion2;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JLabel txtDuracion;
    private javax.swing.JTextField txtFechaCompra;
    private javax.swing.JTextField txtFechaFin;
    private javax.swing.JTextField txtFechaInicio;
    private javax.swing.JLabel txtFechaRegistro;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JLabel txtNombre2;
    private javax.swing.JLabel txtNombreArtista;
    private javax.swing.JLabel txtNombreEspectaculo;
    private javax.swing.JLabel txtNombreEspectaculos;
    private javax.swing.JLabel txtURL;
    // End of variables declaration//GEN-END:variables
}
