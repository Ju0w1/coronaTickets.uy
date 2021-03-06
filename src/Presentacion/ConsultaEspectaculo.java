/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;

import Logica.Fabrica;
import Logica.Interfaz.IControladorEspectaculo;
import Logica.Interfaz.IControladorPaquete;
import static Presentacion.MenuInicio.jDesktopPane2;
import java.awt.Dimension;
import java.io.Console;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class ConsultaEspectaculo extends javax.swing.JInternalFrame {

    private IControladorEspectaculo ICE;
    private IControladorPaquete ICP;
    
    public ConsultaEspectaculo() {
        initComponents();
        setLabelsTxtNotVisible();
        this.ICE = Fabrica.getInstance().getIControladorEspectaculo();
        this.ICP = Fabrica.getInstance().getIControladorPaquete();
        this.ICE.obtenerPlataformasToList(this.listPlataformas);
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
        jScrollPane6 = new javax.swing.JScrollPane();
        listPlataformas = new javax.swing.JList<>();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        listEspectaculos = new javax.swing.JList<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        btnSelecionar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        listFunciones = new javax.swing.JList<>();
        btnFuncion = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        listPaquetes = new javax.swing.JList<>();
        jLabel12 = new javax.swing.JLabel();
        btnFuncion1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNombreArtista = new javax.swing.JLabel();
        txtNombreEspectaculo = new javax.swing.JLabel();
        txtDuracion = new javax.swing.JLabel();
        txtCantEspectadoresMinima = new javax.swing.JLabel();
        txtCantEspectadoresMaxima = new javax.swing.JLabel();
        txtURL = new javax.swing.JLabel();
        txtCosto = new javax.swing.JLabel();
        txtFechaRegistro = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        listEspectaculosDePaquete = new javax.swing.JList<>();
        labelPaqueteEspectaculos = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        txtNombreFP = new javax.swing.JLabel();
        txtDescripcionP_FechaF = new javax.swing.JLabel();
        txtFechaInicioP_HoraInicioF = new javax.swing.JLabel();
        txtFechaFinP_FechaRegistroF = new javax.swing.JLabel();
        txtCostoP = new javax.swing.JLabel();
        txtDescuentoP = new javax.swing.JLabel();
        labelNombreFP = new javax.swing.JLabel();
        labelDescripcionP_FechaF = new javax.swing.JLabel();
        labelFechaInicioP_HoraInicioF = new javax.swing.JLabel();
        labelFechaFinP_FechaRegistroF = new javax.swing.JLabel();
        labelCostoP = new javax.swing.JLabel();
        labelDescuentoP = new javax.swing.JLabel();

        jFrame1.setTitle("Seleccionar plataformas");
        jFrame1.setMinimumSize(new java.awt.Dimension(370, 190));
        jFrame1.setResizable(false);

        listPlataformas.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Facebook Live", "Amazon live premiun 4k", "test", "Item 4", "Item 5", "test2", "test3", "test4", "asd" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane6.setViewportView(listPlataformas);

        jButton1.setText("Seleccionar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jFrame1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Consultar espect??culo");
        setMaximumSize(new java.awt.Dimension(600, 660));
        setMinimumSize(new java.awt.Dimension(600, 660));
        setPreferredSize(new java.awt.Dimension(600, 660));

        jScrollPane2.setViewportView(listEspectaculos);

        txtDescripcion.setEditable(false);
        txtDescripcion.setColumns(20);
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        jLabel10.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel10.setText("Espect??culos:");

        btnSelecionar.setText("Seleccionar");
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(listFunciones);

        btnFuncion.setText("Seleccionar");
        btnFuncion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFuncionActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel11.setText("Funciones:");

        jScrollPane4.setViewportView(listPaquetes);

        jLabel12.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel12.setText("Paquetes:");

        btnFuncion1.setText("Seleccionar");
        btnFuncion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFuncion1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel1.setText("Artista organizador:");

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel2.setText("Nombre del espect??culo:");

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel4.setText("Duraci??n en minutos:");

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel5.setText("Cantidad de espectadores m??nima:");

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel6.setText("Cantidad de espectadores m??xima:");

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel7.setText("URL:");

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel8.setText("Costo:");

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel9.setText("Fecha de registro:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtURL, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCantEspectadoresMaxima, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFechaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtCantEspectadoresMinima, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNombreEspectaculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtNombreArtista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombreEspectaculo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtDuracion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCantEspectadoresMinima, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtCantEspectadoresMaxima, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(txtURL, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(txtFechaRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        jButton2.setText("Plataforma");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField1.setEditable(false);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel13.setText("Descripci??n del espect??culo:");

        jPanel2.setPreferredSize(new java.awt.Dimension(268, 275));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane5.setViewportView(listEspectaculosDePaquete);

        jPanel2.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 31, 250, 118));

        labelPaqueteEspectaculos.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        labelPaqueteEspectaculos.setText("Espect??culos que ofrece el paquete:");
        jPanel2.add(labelPaqueteEspectaculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, -1));

        txtNombreFP.setText("txtNombreFP");

        txtDescripcionP_FechaF.setText("Variable2");

        txtFechaInicioP_HoraInicioF.setText("Variable3");

        txtFechaFinP_FechaRegistroF.setText("Variable4");

        txtCostoP.setText("Variable5");

        txtDescuentoP.setText("Variable6");

        labelNombreFP.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        labelNombreFP.setText("Nombre de funci??n:");

        labelDescripcionP_FechaF.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        labelDescripcionP_FechaF.setText("labelDescripcionP_FechaF:");

        labelFechaInicioP_HoraInicioF.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        labelFechaInicioP_HoraInicioF.setText("labelFechaInicioP_HoraInicioF:");

        labelFechaFinP_FechaRegistroF.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        labelFechaFinP_FechaRegistroF.setText("labelFechaFinP_FechaRegistroF:");

        labelCostoP.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        labelCostoP.setText("labelCostoP:");

        labelDescuentoP.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        labelDescuentoP.setText("labelDescuentoP:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(labelDescripcionP_FechaF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescripcionP_FechaF))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(labelNombreFP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreFP))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(labelFechaInicioP_HoraInicioF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFechaInicioP_HoraInicioF))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(labelDescuentoP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtDescuentoP))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(labelCostoP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCostoP))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(labelFechaFinP_FechaRegistroF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtFechaFinP_FechaRegistroF)))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtFechaInicioP_HoraInicioF)
                            .addComponent(labelFechaInicioP_HoraInicioF))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtFechaFinP_FechaRegistroF)
                                .addComponent(labelFechaFinP_FechaRegistroF))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(labelCostoP)
                                    .addComponent(txtCostoP))))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelDescuentoP)
                            .addComponent(txtDescuentoP)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombreFP)
                            .addComponent(labelNombreFP))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDescripcionP_FechaF)
                            .addComponent(labelDescripcionP_FechaF))))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(15, 15, 15)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(btnSelecionar))
                            .addComponent(jLabel13)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnFuncion)
                                    .addComponent(btnFuncion1))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addComponent(jLabel10)
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(btnSelecionar)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel13)
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel11)
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnFuncion)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel12)
                        .addGap(4, 4, 4)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(btnFuncion1)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFuncionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFuncionActionPerformed
        if (listFunciones.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this, "No ha seleccionado ninguna funci??n.");
        }else{
            this.ICE.cargarDatosFuncionConsultaEspectaculo(listFunciones.getSelectedValue(),txtNombreFP,txtDescripcionP_FechaF, txtFechaInicioP_HoraInicioF, txtFechaFinP_FechaRegistroF);
            labelNombreFP.setText("Nombre de funci??n:");
            labelDescripcionP_FechaF.setText("Fecha de funci??n:");
            labelFechaInicioP_HoraInicioF.setText("Hora de inicio:");
            labelFechaFinP_FechaRegistroF.setText("Fecha de registro:");

            labelNombreFP.setVisible(true);
            labelDescripcionP_FechaF.setVisible(true);
            labelFechaInicioP_HoraInicioF.setVisible(true);
            labelFechaFinP_FechaRegistroF.setVisible(true);
            txtNombreFP.setVisible(true);
            txtDescripcionP_FechaF.setVisible(true);
            txtFechaInicioP_HoraInicioF.setVisible(true);
            txtFechaFinP_FechaRegistroF.setVisible(true);

            labelDescuentoP.setVisible(false);
            labelCostoP.setVisible(false);
            txtDescuentoP.setVisible(false);
            txtCostoP.setVisible(false);
            
            jPanel2.setVisible(false);
        }

    }//GEN-LAST:event_btnFuncionActionPerformed

    private void btnFuncion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFuncion1ActionPerformed
        if(listPaquetes.isSelectionEmpty()){
            JOptionPane.showMessageDialog(this, "No ha seleccionado ning??n paquete.");
        }else{
            this.ICE.cargarDatosPaqueteConsultaEspectaculo(txtNombreEspectaculo.getText(), listPaquetes.getSelectedValue(),txtNombreFP,txtDescripcionP_FechaF, txtFechaInicioP_HoraInicioF, txtFechaFinP_FechaRegistroF, txtCostoP, txtDescuentoP, listEspectaculosDePaquete);
            labelNombreFP.setText("Nombre del paquete:");
            labelDescripcionP_FechaF.setText("Descripci??n:");
            labelFechaInicioP_HoraInicioF.setText("Fecha de inicio:");
            labelFechaFinP_FechaRegistroF.setText("Fecha de fin:");
            labelCostoP.setText("Costo: $");
            labelDescuentoP.setText("Descuento: %");
            
            labelNombreFP.setVisible(true);
            labelDescripcionP_FechaF.setVisible(true);
            labelFechaInicioP_HoraInicioF.setVisible(true);
            labelFechaFinP_FechaRegistroF.setVisible(true);
            labelDescuentoP.setVisible(true);
            labelCostoP.setVisible(true);
            txtNombreFP.setVisible(true);
            txtDescripcionP_FechaF.setVisible(true);
            txtFechaInicioP_HoraInicioF.setVisible(true);
            txtFechaFinP_FechaRegistroF.setVisible(true);
            txtDescuentoP.setVisible(true);
            txtCostoP.setVisible(true);
            jPanel2.setVisible(true);
//            labelPaqueteEspectaculos.setVisible(true);
//            listEspectaculosDePaquete.setVisible(true);
        }
    }//GEN-LAST:event_btnFuncion1ActionPerformed

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed
        if (jTextField1.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No ha seleccionado ninguna plataforma.");
        } else if (listEspectaculos.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this, "No ha seleccionado ningun espectaculo.");
        }
        else{//JLabel nombreApellido, JLabel nombreEspectaculo, JLabel duracion, JLabel espectMin, JLabel espectMax, JLabel URL, JLabel costo, JLabel fecha, JTextArea descrip);
                        labelNombreFP.setVisible(false);
            labelDescripcionP_FechaF.setVisible(false);
            labelFechaInicioP_HoraInicioF.setVisible(false);
            labelFechaFinP_FechaRegistroF.setVisible(false);
            txtNombreFP.setVisible(false);
            txtDescripcionP_FechaF.setVisible(false);
            txtFechaInicioP_HoraInicioF.setVisible(false);
            txtFechaFinP_FechaRegistroF.setVisible(false);

            labelDescuentoP.setVisible(false);
            labelCostoP.setVisible(false);
            txtDescuentoP.setVisible(false);
            txtCostoP.setVisible(false);
            
            jPanel2.setVisible(false);
            
            this.ICE.cargarDatosConsultaEspectaculo(listEspectaculos.getSelectedValue(), txtNombreArtista, txtNombreEspectaculo, txtDuracion, txtCantEspectadoresMinima, txtCantEspectadoresMaxima, txtURL, txtCosto, txtFechaRegistro, txtDescripcion);
            this.ICE.obtenerListaFunciones(listFunciones);
            String espectNombre = listEspectaculos.getSelectedValue();
            this.ICP.obtenerPaqueteEspectaculo(listPaquetes, listEspectaculos.getSelectedValue());
        }
    }//GEN-LAST:event_btnSelecionarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        Dimension desktopSize = jDesktopPane2.getSize();
        Dimension jInternalFrameSize = jFrame1.getSize();
        jFrame1.setLocation((desktopSize.width - jInternalFrameSize.width)/2,
        (desktopSize.height- jInternalFrameSize.height)/2);
        jFrame1.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jTextField1.setText(listPlataformas.getSelectedValue());
        this.ICE.obtenerEspectaculosPorPlataforma(listEspectaculos, jTextField1.getText());
        jFrame1.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    public void setLabelsTxtNotVisible(){
        labelNombreFP.setVisible(false);
        labelDescripcionP_FechaF.setVisible(false);
        labelFechaInicioP_HoraInicioF.setVisible(false);
        labelFechaFinP_FechaRegistroF.setVisible(false);
        labelDescuentoP.setVisible(false);
        labelCostoP.setVisible(false);
        txtNombreFP.setVisible(false);
        txtDescripcionP_FechaF.setVisible(false);
        txtFechaInicioP_HoraInicioF.setVisible(false);
        txtFechaFinP_FechaRegistroF.setVisible(false);
        txtDescuentoP.setVisible(false);
        txtCostoP.setVisible(false);
        jPanel2.setVisible(false);
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFuncion;
    private javax.swing.JButton btnFuncion1;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel labelCostoP;
    private javax.swing.JLabel labelDescripcionP_FechaF;
    private javax.swing.JLabel labelDescuentoP;
    private javax.swing.JLabel labelFechaFinP_FechaRegistroF;
    private javax.swing.JLabel labelFechaInicioP_HoraInicioF;
    private javax.swing.JLabel labelNombreFP;
    private javax.swing.JLabel labelPaqueteEspectaculos;
    private javax.swing.JList<String> listEspectaculos;
    private javax.swing.JList<String> listEspectaculosDePaquete;
    private javax.swing.JList<String> listFunciones;
    private javax.swing.JList<String> listPaquetes;
    private javax.swing.JList<String> listPlataformas;
    private javax.swing.JLabel txtCantEspectadoresMaxima;
    private javax.swing.JLabel txtCantEspectadoresMinima;
    private javax.swing.JLabel txtCosto;
    private javax.swing.JLabel txtCostoP;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JLabel txtDescripcionP_FechaF;
    private javax.swing.JLabel txtDescuentoP;
    private javax.swing.JLabel txtDuracion;
    private javax.swing.JLabel txtFechaFinP_FechaRegistroF;
    private javax.swing.JLabel txtFechaInicioP_HoraInicioF;
    private javax.swing.JLabel txtFechaRegistro;
    public static javax.swing.JLabel txtNombreArtista;
    public static javax.swing.JLabel txtNombreEspectaculo;
    private javax.swing.JLabel txtNombreFP;
    private javax.swing.JLabel txtURL;
    // End of variables declaration//GEN-END:variables
}
