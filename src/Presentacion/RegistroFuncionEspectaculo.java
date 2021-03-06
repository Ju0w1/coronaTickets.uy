/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion; //New


import Logica.Fabrica;
import Logica.Interfaz.IControladorEspectaculo;
import Logica.Interfaz.IControladorFuncion;
import Logica.Interfaz.IControladorUsuario;
import static Presentacion.AltaEspectaculo.jFrameBuscarArtista;
import static Presentacion.MenuInicio.jDesktopPane2;
import java.awt.Dimension;
import java.io.Console;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Admin
 */
public class RegistroFuncionEspectaculo extends javax.swing.JInternalFrame {
    private IControladorEspectaculo ICE;
    private IControladorUsuario ICU;
    private IControladorFuncion ICF;
    /**
     * Creates new form RegistroFuncionEspectaculo2
     */
    public RegistroFuncionEspectaculo() {
        initComponents();
        this.ICE = Fabrica.getInstance().getIControladorEspectaculo();
        this.ICU = Fabrica.getInstance().getIControladorUsuario();
        this.ICF = Fabrica.getInstance().getIControladorFuncion();
        this.ICE.obtenerPlataformasToComboBox(plat);
        //this.ICE.o obtener (espec); //Renombrar el de federico en el cotrolador
        this.ICU.obtenerEspectadores((DefaultTableModel) this.listViewers.getModel());
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRegistrosPrevios = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        registroSeleccionado1 = new javax.swing.JTextField();
        registroSeleccionado2 = new javax.swing.JTextField();
        registroSeleccionado3 = new javax.swing.JTextField();
        btnBorrar1 = new javax.swing.JButton();
        btnBorrar2 = new javax.swing.JButton();
        btnBorrar3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        espec = new javax.swing.JList<>();
        jLabel9 = new javax.swing.JLabel();
        plat = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        funcTable = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtFuncion = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        dia = new javax.swing.JSpinner();
        mes = new javax.swing.JSpinner();
        anio = new javax.swing.JSpinner();
        jScrollPane7 = new javax.swing.JScrollPane();
        listViewers = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        txtBuscador = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();

        jFrame1.setTitle("PROMO: Canjear tres registros por uno");
        jFrame1.setMinimumSize(new java.awt.Dimension(516, 448));
        jFrame1.setResizable(false);

        jLabel1.setText("Espectador:");

        jTableRegistrosPrevios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Funcion", "Fecha Registro", "Canjeado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableRegistrosPrevios);
        if (jTableRegistrosPrevios.getColumnModel().getColumnCount() > 0) {
            jTableRegistrosPrevios.getColumnModel().getColumn(0).setResizable(false);
            jTableRegistrosPrevios.getColumnModel().getColumn(1).setResizable(false);
            jTableRegistrosPrevios.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel2.setText("Registros previos sin canjear:");

        jButton2.setText("Seleccionar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setText("Registros a canjear:");

        jButton3.setText("Canjear");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton7.setText("Cancelar");

        jTextField1.setEditable(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        registroSeleccionado1.setEditable(false);

        registroSeleccionado2.setEditable(false);

        registroSeleccionado3.setEditable(false);

        btnBorrar1.setText("Borrar seleccion");
        btnBorrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrar1ActionPerformed(evt);
            }
        });

        btnBorrar2.setText("Borrar seleccion");
        btnBorrar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrar2ActionPerformed(evt);
            }
        });

        btnBorrar3.setText("Borrar seleccion");
        btnBorrar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrar3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jFrame1Layout.createSequentialGroup()
                        .addComponent(registroSeleccionado3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBorrar3))
                    .addGroup(jFrame1Layout.createSequentialGroup()
                        .addComponent(registroSeleccionado2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBorrar2))
                    .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jFrame1Layout.createSequentialGroup()
                            .addComponent(jButton7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3))
                        .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton2)
                                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2)
                                    .addGroup(jFrame1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jFrame1Layout.createSequentialGroup()
                        .addComponent(registroSeleccionado1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBorrar1)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(3, 3, 3)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registroSeleccionado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrar1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registroSeleccionado2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrar2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registroSeleccionado3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBorrar3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton7))
                .addGap(30, 30, 30))
        );

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Registrar espectador a funci??n");
        setPreferredSize(new java.awt.Dimension(527, 711));

        jLabel4.setText("Plataforma");

        jLabel8.setText("Espectaculos disponibles");

        jScrollPane3.setViewportView(espec);

        jLabel9.setText("Funciones");

        plat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                platActionPerformed(evt);
            }
        });

        jButton4.setText("Seleccionar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton1.setText("Seleccionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        funcTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "Espectaculo", "Fecha", "Hora de Inicio"
            }
        ));
        jScrollPane5.setViewportView(funcTable);

        jLabel10.setText("Seleccionar espectador");

        btnCancelar.setText("Cancelar");
        btnCancelar.setActionCommand("btnCancelarPlat");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnRegistrar.setText("Registrar");
        btnRegistrar.setActionCommand("btnCrearPlat");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setText("Funcion");
        jPanel7.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        txtFuncion.setEditable(false);
        jPanel7.add(txtFuncion, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, 97, -1));

        jLabel12.setText("Fecha");
        jPanel7.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, -1, -1));

        dia.setEnabled(false);
        jPanel7.add(dia, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 50, -1));

        mes.setEnabled(false);
        jPanel7.add(mes, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 50, -1));

        anio.setEnabled(false);
        jPanel7.add(anio, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 80, -1));

        listViewers.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nick", "Nombre", "Apellido", "Email"
            }
        ));
        jScrollPane7.setViewportView(listViewers);

        jButton6.setText("Seleccionar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        txtBuscador.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtBuscadorCaretUpdate(evt);
            }
        });
        txtBuscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscadorActionPerformed(evt);
            }
        });

        jLabel5.setText("Filtro por nickname");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(plat, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 1, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(plat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(16, 16, 16)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jButton4)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel5)
                    .addComponent(txtBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnRegistrar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       // TODO add your handling code here:
       if(this.espec.getSelectedValue()==null){
           JOptionPane.showMessageDialog(this, "Debe seleccionar algune espetct??culo");
       }else{
        String nomEspectaculo= espec.getSelectedValue();
        System.out.print(nomEspectaculo);
        this.ICE.obtenerTablaFunciones((DefaultTableModel) this.funcTable.getModel(), nomEspectaculo);
           
       }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        
        if (plat.getSelectedIndex()==-1){
            JOptionPane.showMessageDialog(this, "No ha seleccionado ninguna plataforma.");
        }
        else {
            if (espec.getSelectedIndex()==-1){
                 JOptionPane.showMessageDialog(this, "No ha seleccionado ningun espectaculo.");
            }
            else{
                if(txtFuncion.getText().equals("")){
                    JOptionPane.showMessageDialog(this, "No ha seleccionado ninguna funcion.");
                }
                else{
                    if(listViewers.getSelectedRow()==-1){
                        JOptionPane.showMessageDialog(this, "No ha seleccionado ningun espectador.");
                    }
                    else{
                        if((int) dia.getValue()==0 || (int) mes.getValue()==0 || (int) anio.getValue()==0){
                            JOptionPane.showMessageDialog(this, "La fecha ingresada no es valida.");
                        }
                        else{
                            String getFunc= txtFuncion.getText();
                            String getPlat= (String) plat.getSelectedItem();
                            String getEspec= espec.getSelectedValue();
                            //this.jTable2.getModel().getValueAt(this.jTable2.getSelectedRow(),3).toString();
                            String getViewer= listViewers.getModel().getValueAt(listViewers.getSelectedRow(),0).toString();
                            Date date= new Date((int) dia.getValue(), (int) mes.getValue(), (int) anio.getValue());
                            System.out.println("fun:"+getFunc);
                            System.out.println("viewer:"+getViewer);
                            System.out.println("fecha:"+date.getDay()+"/"+date.getMonth()+"/"+date.getYear());
                            
                            switch (this.ICE.registroFuncionEspectaculo(getFunc, getViewer, date)){
                                case 0: //Ya se realiz?? el registro
                                    JOptionPane.showMessageDialog(this, "Registro a funci??n agregado correctamente");
                                    break;
                                case 1: //llamar a ventaja de canje
                                    Dimension desktopSize = jDesktopPane2.getSize();
                                    Dimension jInternalFrameSize = jFrame1.getSize();
                                    jFrame1.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
                                    (desktopSize.height- jInternalFrameSize.height)/2);
                                    jFrame1.setVisible(true);
                                    jTextField1.setText(getViewer);
                                    this.ICE.canjearTresRegistrosPrevios(getFunc, getViewer, date, (DefaultTableModel) jTableRegistrosPrevios.getModel());
                                    break;
                                case 2: //El espectador seleccionado ya est?? registrado
                                    JOptionPane.showMessageDialog(this, "El espectador seleccionado ya est?? registrado a la funcion.");
                                    break;
                                case 3: //El limite de registros para la funcion fue alcanzado 
                                    JOptionPane.showMessageDialog(this, "Se ha alcanzado el limite de registros para la funcion seleccionada.");
                                    break;            
                            }
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        if(this.funcTable.getSelectedRow() == -1){
            JOptionPane.showMessageDialog(this, "Debe seleccionar alguna fila de la tabla de funciones");
        }else{
            LocalDateTime now = LocalDateTime.now();
            String fun= this.funcTable.getModel().getValueAt(this.funcTable.getSelectedRow(),0).toString();
            this.txtFuncion.setText(fun);
            this.dia.setValue(now.getDayOfMonth());
            this.mes.setValue(now.getMonthValue());
            this.anio.setValue(now.getYear());
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    if(jTableRegistrosPrevios.getValueAt(jTableRegistrosPrevios.getSelectedRow(), 0).toString().equals(registroSeleccionado1.getText()) || jTableRegistrosPrevios.getValueAt(jTableRegistrosPrevios.getSelectedRow(), 0).toString().equals(registroSeleccionado2.getText()) || jTableRegistrosPrevios.getValueAt(jTableRegistrosPrevios.getSelectedRow(), 0).toString().equals(registroSeleccionado3.getText())){
        JOptionPane.showMessageDialog(this, "No puede seleccionar el mismo registro.");
    }else{
        if(registroSeleccionado1.getText().equals("")){
            registroSeleccionado1.setText(jTableRegistrosPrevios.getValueAt(jTableRegistrosPrevios.getSelectedRow(), 0).toString());
        }
        else if(registroSeleccionado2.getText().equals("")){
            registroSeleccionado2.setText(jTableRegistrosPrevios.getValueAt(jTableRegistrosPrevios.getSelectedRow(), 0).toString());
        }
        else if(registroSeleccionado3.getText().equals("")){
            registroSeleccionado3.setText(jTableRegistrosPrevios.getValueAt(jTableRegistrosPrevios.getSelectedRow(), 0).toString());
        }
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnBorrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrar1ActionPerformed
        registroSeleccionado1.setText("");
    }//GEN-LAST:event_btnBorrar1ActionPerformed

    private void btnBorrar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrar2ActionPerformed
        registroSeleccionado2.setText("");
    }//GEN-LAST:event_btnBorrar2ActionPerformed

    private void btnBorrar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrar3ActionPerformed
        registroSeleccionado3.setText("");
    }//GEN-LAST:event_btnBorrar3ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(registroSeleccionado1.getText().equals("") || registroSeleccionado2.getText().equals("") || registroSeleccionado3.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Debe seleccionar 3 registros para canjear.");
        }
        else{
            String getViewer= listViewers.getModel().getValueAt(listViewers.getSelectedRow(),0).toString();
            Date date= new Date((int) dia.getValue(), (int) mes.getValue(), (int) anio.getValue());
            this.ICE.actualizarEstadoDeRegistros(txtFuncion.getText(),registroSeleccionado1.getText(), registroSeleccionado2.getText(), registroSeleccionado3.getText(), getViewer, date);
            this.jFrame1.dispose();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.ICE.obtenerEspectaculosPorPlataforma(espec, plat.getSelectedItem().toString());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void platActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_platActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_platActionPerformed

    private void txtBuscadorCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtBuscadorCaretUpdate
        // TODO add your handling code here:
        this.ICU.obtenerEspectadoresBuscador((DefaultTableModel) this.listViewers.getModel(), this.txtBuscador.getText());
        //this.ICU.obtenerEspectadoresBuscador((DefaultTableModel) this.jTable2.getModel(), );
    }//GEN-LAST:event_txtBuscadorCaretUpdate

    private void txtBuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscadorActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner anio;
    private javax.swing.JButton btnBorrar1;
    private javax.swing.JButton btnBorrar2;
    private javax.swing.JButton btnBorrar3;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JSpinner dia;
    private javax.swing.JList<String> espec;
    private javax.swing.JTable funcTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTableRegistrosPrevios;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable listViewers;
    private javax.swing.JSpinner mes;
    private javax.swing.JComboBox<String> plat;
    private javax.swing.JTextField registroSeleccionado1;
    private javax.swing.JTextField registroSeleccionado2;
    private javax.swing.JTextField registroSeleccionado3;
    private javax.swing.JTextField txtBuscador;
    private javax.swing.JTextField txtFuncion;
    // End of variables declaration//GEN-END:variables
}
