/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import Presentacion.MenuInicio;
//import static Presentacion.MenuInicio.jDesktopPane2;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 *
 * @author Admin
 */
public class AltaEspectaculo extends javax.swing.JInternalFrame {

    /**
     * Creates new form AltaEspectaculo
     */
    public AltaEspectaculo() {
        initComponents();
//        jLabelErrorCantidadEspectadorMaxima1.setText("");
//        jLabelErrorCantidadEspectadorMinima.setText("");
        controlCamposVacios();
        jLabelErrorCase.setForeground(Color.BLACK);
//        jLabelErrorHoras.setText("");
//        jLabelErrorMinutos.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        txtNombreArtista = new javax.swing.JTextField();
        txtCantidadMaxima = new javax.swing.JTextField();
        txtNombreEspectaculo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        txtCantidadMinima = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtMinutos = new javax.swing.JTextField();
        txtURL = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();
        jLabelErrorCase = new javax.swing.JLabel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setClosable(true);
        setTitle("Alta de Espectáculo");
        setPreferredSize(new java.awt.Dimension(740, 540));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        txtNombreArtista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreArtistaActionPerformed(evt);
            }
        });
        txtNombreArtista.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreArtistaKeyPressed(evt);
            }
        });

        txtCantidadMaxima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadMaximaActionPerformed(evt);
            }
        });
        txtCantidadMaxima.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadMaximaKeyPressed(evt);
            }
        });

        txtNombreEspectaculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreEspectaculoActionPerformed(evt);
            }
        });
        txtNombreEspectaculo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreEspectaculoKeyPressed(evt);
            }
        });

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(txtDescripcion);

        txtCantidadMinima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadMinimaActionPerformed(evt);
            }
        });
        txtCantidadMinima.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCantidadMinimaKeyPressed(evt);
            }
        });

        jLabel1.setText("Nombre del organizador");

        jLabel2.setText("Nombre del espectáculo");

        jLabel3.setText("Descripción");

        jLabel15.setText("Minutos");

        txtMinutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMinutosActionPerformed(evt);
            }
        });
        txtMinutos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMinutosKeyPressed(evt);
            }
        });

        txtURL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtURLActionPerformed(evt);
            }
        });
        txtURL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtURLKeyPressed(evt);
            }
        });

        jLabel4.setText("Duración del espectáculo");

        jLabel5.setText("Cantidad de espectadores");

        txtCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoActionPerformed(evt);
            }
        });
        txtCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCostoKeyPressed(evt);
            }
        });

        jLabel6.setText("Mínima");

        jLabel10.setText("Plataforma");

        jLabel7.setText("Máxima");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setText("URL");

        jLabel9.setText("Costo");

        jLabel11.setText("$");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(137, 137, 137)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(64, 64, 64)
                        .addComponent(txtNombreArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(62, 62, 62)
                        .addComponent(txtNombreEspectaculo, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(131, 131, 131)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(172, 172, 172)
                        .addComponent(txtURL, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(151, 151, 151)
                        .addComponent(jLabel11)
                        .addGap(6, 6, 6)
                        .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(26, 26, 26)
                                .addComponent(txtMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(29, 29, 29)
                                .addComponent(txtCantidadMinima, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtCantidadMaxima, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel10))
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel1))
                    .addComponent(txtNombreArtista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2))
                    .addComponent(txtNombreEspectaculo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel15)
                    .addComponent(txtMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(txtCantidadMinima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(txtCantidadMaxima, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel8))
                    .addComponent(txtURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)))))
        );

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        jLabelErrorCase.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabelErrorCase.setForeground(new java.awt.Color(0, 0, 0));
        jLabelErrorCase.setText("Este label será utilizado para informar de errores mediante Try-Catchs");
        jLabelErrorCase.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jLabelErrorCaseKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 145, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabelErrorCase)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnConfirmar)
                .addGap(77, 77, 77))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar)
                    .addComponent(jLabelErrorCase))
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreEspectaculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreEspectaculoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreEspectaculoActionPerformed

    private void txtNombreArtistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreArtistaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreArtistaActionPerformed

    private void txtCantidadMinimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadMinimaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadMinimaActionPerformed

    private void txtURLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtURLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtURLActionPerformed

    private void txtCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCostoActionPerformed

    private void txtCantidadMaximaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadMaximaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadMaximaActionPerformed

    private void txtCantidadMinimaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadMinimaKeyPressed
         try{
            int i=Integer.parseInt(txtCantidadMinima.getText());
            jLabelErrorCase.setText("");
            controlCamposVacios();
        }catch(NumberFormatException e){
            jLabelErrorCase.setText("ERROR: El número que digitó en el campo 'Cantidad de espectadores mínimos' es inválido.");
            jLabelErrorCase.setForeground(Color.RED);
            btnConfirmar.setEnabled(false);
        }
    }//GEN-LAST:event_txtCantidadMinimaKeyPressed

    private void jLabelErrorCaseKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jLabelErrorCaseKeyPressed

    }//GEN-LAST:event_jLabelErrorCaseKeyPressed

    private void txtCantidadMaximaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCantidadMaximaKeyPressed
         try{
            int i=Integer.parseInt(txtCantidadMaxima.getText());
            jLabelErrorCase.setText("");
            controlCamposVacios();
        }catch(NumberFormatException e){
            jLabelErrorCase.setText("ERROR: El número que digitó en el campo 'Cantidad de espectadores máximos' es inválido.");
            jLabelErrorCase.setForeground(Color.RED);
            btnConfirmar.setEnabled(false);
        }
    }//GEN-LAST:event_txtCantidadMaximaKeyPressed

    private void txtMinutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMinutosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMinutosActionPerformed

    private void txtMinutosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMinutosKeyPressed
         try{
            double i=Double.parseDouble(txtMinutos.getText());
             jLabelErrorCase.setText("");
            controlCamposVacios();   
        }catch(NumberFormatException e){
            jLabelErrorCase.setText("ERROR: El número que digitó en el campo 'Minutos' es inválido.");
            jLabelErrorCase.setForeground(Color.RED);
            btnConfirmar.setEnabled(false);
        }
    }//GEN-LAST:event_txtMinutosKeyPressed

    private void txtCostoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoKeyPressed
        try{
            double i=Double.parseDouble(txtCosto.getText());
            controlCamposVacios();
        }catch(NumberFormatException e){
            jLabelErrorCase.setText("ERROR: El número que digitó en el campo 'Costo' es inválido.");
            jLabelErrorCase.setForeground(Color.RED);
        }
    }//GEN-LAST:event_txtCostoKeyPressed

//    public static class JOptionPaneTest2 {
//
//        public static void main() {
//            JDialog.setDefaultLookAndFeelDecorated(true);
//            int response = JOptionPane.showConfirmDialog(null, "Nombre del espectáculo ya existe en el sistema. ¿Desea modificar el nombre?", "Confirm",
//                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
//            if (response == JOptionPane.NO_OPTION) {
//                this.
//                System.out.println("No button clicked");
//            } else if (response == JOptionPane.YES_OPTION) {
//                
//                System.out.println("Yes button clicked");
//            } else if (response == JOptionPane.CLOSED_OPTION) {
//                System.out.println("JOptionPane closed");
//            }
//        }
//    }
    
    
    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        String nombrePlataforma= jComboBox1.getSelectedItem().toString();
        String nombreOrganizador= txtNombreArtista.getText();
        String nombreEspectaculo= txtNombreEspectaculo.getText();
        String descripcion = txtDescripcion.getText();
        Double duracion= Double.parseDouble(txtMinutos.getText());
        int cantEspectadoresMinima = Integer.parseInt(txtCantidadMinima.getText());
        int cantEspectadoresMaxima = Integer.parseInt(txtCantidadMaxima.getText());
        String URL = txtURL.getText();
        Double Costo = Double.parseDouble(txtCosto.getText());
        if (nombreEspectaculo.equalsIgnoreCase("a")) {
//            AltaEspectaculoModificar ventanaAux = new AltaEspectaculoModificar();
//            Dimension desktopSize = jDesktopPane2.getSize();
//            Dimension jInternalFrameSize = ventanaAux.getSize();
//            ventanaAux.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
//            (desktopSize.height- jInternalFrameSize.height)/2);
//            jDesktopPane2.add(ventanaAux);
//            this.setVisible(false);
//            ventanaAux.setVisible(true);
              //JOptionPane.showInternalConfirmDialog(this, "nombre del espectáculo ya existe en el sistema. ¿Desea modificar el nombre?");
              
              //1. create a dialog object 'dialog'
              
//            JTextField firstName = new JTextField();
//            JTextField lastName = new JTextField();
//            JPasswordField password = new JPasswordField();
//            final JComponent[] inputs = new JComponent[]{
//                new JLabel("First"),};
//            int result = JOptionPane.showConfirmDialog(null, inputs, "My custom dialog", JOptionPane.PLAIN_MESSAGE);
//            if (result == JOptionPane.OK_OPTION) {
//                System.out.println("You entered "
//                        + firstName.getText() + ", "
//                        + lastName.getText() + ", "
//                        + password.getText());
//            } else {
//                System.out.println("User canceled / closed the dialog, result = " + result);
//            }

        //JOptionPaneTest2.main();

        }
        
        //JOptionPane.showMessageDialog(this, nombrePlataforma);
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        
    }//GEN-LAST:event_formMouseMoved

    private void txtNombreArtistaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreArtistaKeyPressed
        controlCamposVacios();
    }//GEN-LAST:event_txtNombreArtistaKeyPressed

    private void txtNombreEspectaculoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreEspectaculoKeyPressed
        controlCamposVacios();
    }//GEN-LAST:event_txtNombreEspectaculoKeyPressed

    private void txtDescripcionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyPressed
        controlCamposVacios();
    }//GEN-LAST:event_txtDescripcionKeyPressed

    private void txtURLKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtURLKeyPressed
        controlCamposVacios();
    }//GEN-LAST:event_txtURLKeyPressed

    public void controlCamposVacios(){
        if(txtCantidadMaxima.getText().equalsIgnoreCase("") || txtCantidadMinima.getText().equalsIgnoreCase("") || txtCosto.getText().equalsIgnoreCase("") || txtDescripcion.getText().equalsIgnoreCase("") || txtDescripcion.getText().equalsIgnoreCase("") || txtMinutos.getText().equalsIgnoreCase("") || txtNombreArtista.getText().equalsIgnoreCase("") || txtNombreEspectaculo.getText().equalsIgnoreCase("") || txtURL.getText().equalsIgnoreCase("")){
            jLabelErrorCase.setText("ADVERTENCIA: Se requiere completar todos los campos para confirmar.");
            jLabelErrorCase.setForeground(Color.BLACK);
            btnConfirmar.setEnabled(false);
        }
        else {
            if(controlCamposCorrectos()==0){
                jLabelErrorCase.setText("");
                jLabelErrorCase.setForeground(Color.BLACK);
                btnConfirmar.setEnabled(true);
            }else if(controlCamposCorrectos()==1){
                jLabelErrorCase.setText("ERROR: Uno de los campos no es correcto, verifique.");
                jLabelErrorCase.setForeground(Color.RED);
            }
            else if(controlCamposCorrectos()==-1){
                jLabelErrorCase.setText("ERROR: No puede establecer valores negativos en el campo 'Minutos'.");
                jLabelErrorCase.setForeground(Color.RED);
            }
            else if(controlCamposCorrectos()==-2){
                jLabelErrorCase.setText("ERROR: No puede establecer valores negativos en el campo 'Máxima'.");
                jLabelErrorCase.setForeground(Color.RED);
            }
            else if(controlCamposCorrectos()==-3){
                jLabelErrorCase.setText("ERROR: No puede establecer valores negativos en el campo 'Mínima'.");
                jLabelErrorCase.setForeground(Color.RED);
            }
            else if(controlCamposCorrectos()==-4){
                jLabelErrorCase.setText("ERROR: El campo 'Maxima' no puede ser menor que 'Mínima'.");
                jLabelErrorCase.setForeground(Color.RED);
            }
            else if(controlCamposCorrectos()==-5){
                jLabelErrorCase.setText("ERROR: No puede establecer valores negativos en el campo 'Costo'.");
                jLabelErrorCase.setForeground(Color.RED);
            }
        }
    }
    
    public int controlCamposCorrectos() {
        int cont = 0;
        try {
            double i = Double.parseDouble(txtCosto.getText());
            if(i<0){
                return -5;
            }
        } catch (NumberFormatException e) {
            cont++;
        }
        try {
            int i = Integer.parseInt(txtMinutos.getText());
            if(i<0){
                return -1;
            }
        } catch (NumberFormatException e) {
            cont++;
        }
        try {
            int i = Integer.parseInt(txtCantidadMaxima.getText());
            if(i<0){
                return -2;
            }
        } catch (NumberFormatException e) {
            cont++;
        }
        try {
            int i = Integer.parseInt(txtCantidadMinima.getText());
             if(i<0){
                return -3;
            }
        } catch (NumberFormatException e) {
            cont++;
        }
        try {
            int min = Integer.parseInt(txtCantidadMinima.getText());
            int max = Integer.parseInt(txtCantidadMaxima.getText());
             if(max<min){
                return -4;
            }
        } catch (NumberFormatException e) {
            cont++;
        }
        if(cont==0){
            return 0;
        }
        else{
            return 1;
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnConfirmar;
    public javax.swing.JComboBox<String> jComboBox1;
    public static javax.swing.JFrame jFrame1;
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel10;
    public static javax.swing.JLabel jLabel11;
    public static javax.swing.JLabel jLabel15;
    public static javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel5;
    public static javax.swing.JLabel jLabel6;
    public static javax.swing.JLabel jLabel7;
    public static javax.swing.JLabel jLabel8;
    public static javax.swing.JLabel jLabel9;
    public static javax.swing.JLabel jLabelErrorCase;
    public static javax.swing.JPanel jPanel1;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextField txtCantidadMaxima;
    public static javax.swing.JTextField txtCantidadMinima;
    public static javax.swing.JTextField txtCosto;
    public static javax.swing.JTextArea txtDescripcion;
    public static javax.swing.JTextField txtMinutos;
    public static javax.swing.JTextField txtNombreArtista;
    public static javax.swing.JTextField txtNombreEspectaculo;
    public static javax.swing.JTextField txtURL;
    // End of variables declaration//GEN-END:variables
}
