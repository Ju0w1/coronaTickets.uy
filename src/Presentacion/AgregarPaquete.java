package Presentacion;

import Logica.Fabrica;
import Logica.Interfaz.IControladorEspectaculo;
import Logica.Fabrica; //NUEVO
import Logica.Interfaz.IControladorEspectaculo; //NUEVO
import javax.swing.JOptionPane;

public class AgregarPaquete extends javax.swing.JInternalFrame {

    private IControladorEspectaculo ICE;
    String paq_seleccionado = "";
    String plat_seleccionada = "";
    String espec_seleccionada = "";
    int i = 0, x =0;
    public AgregarPaquete() {
        initComponents();
        this.ICE = (IControladorEspectaculo) Fabrica.getInstance().getIControladorEspectaculo();
        this.ICE = Fabrica.getInstance().getIControladorEspectaculo();

        // el sistema lista los nombres de los paquetes que tiene registrados.
        this.ICE.obtenerPaquetes(this.listPaquetes);

        // Luego, el administrador selecciona una plataforma  
        // Me va a dar todas las plataformas existentes.
        this.ICE.obtenerPlataformasToComboBox(this.comboBoxPlataformas);
        if (listPaquetes.getModel().getSize() == 0){ // SI no hay espectaculos en el sistema
            JOptionPane.showMessageDialog(null, "No existen paquetes");
        }
        this.comboBoxPlataformas.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listPaquetes = new javax.swing.JList<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        comboBoxPlataformas = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listEspectaculos = new javax.swing.JList<>();
        btnAgregarAlPaquete = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Agregar Espectáculo a Paquete ");
        setMaximumSize(new java.awt.Dimension(500, 600));
        setMinimumSize(new java.awt.Dimension(500, 540));
        setPreferredSize(new java.awt.Dimension(500, 540));

        listPaquetes.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listPaquetesValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listPaquetes);

        jLabel2.setText("Paquetes");

        jLabel1.setText("Plataforma");

        comboBoxPlataformas.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboBoxPlataformasItemStateChanged(evt);
            }
        });
        comboBoxPlataformas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxPlataformasActionPerformed(evt);
            }
        });

        jLabel5.setText("Espectáculos");

        jScrollPane2.setViewportView(listEspectaculos);

        btnAgregarAlPaquete.setText("Agregar");
        btnAgregarAlPaquete.setActionCommand("");
        btnAgregarAlPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAlPaqueteActionPerformed(evt);
            }
        });

        jButton1.setText("Cerrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnAgregarAlPaquete)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(14, 14, 14))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboBoxPlataformas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 442, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(comboBoxPlataformas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarAlPaquete)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxPlataformasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxPlataformasActionPerformed

    }//GEN-LAST:event_comboBoxPlataformasActionPerformed

    private void btnAgregarAlPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAlPaqueteActionPerformed
        if (listPaquetes.getSelectedValuesList().isEmpty()){ // SI no hay paquete seleccionado
            JOptionPane.showMessageDialog(null, "Seleccione un paquete");
        } else {
            paq_seleccionado = (String) listPaquetes.getSelectedValue();
            String nulo = "";
            //El administrador selecciona un espectáculo. 
            espec_seleccionada = (String) listEspectaculos.getSelectedValue();
            if (listEspectaculos.getSelectedValuesList().isEmpty()){ // SI no hay espectaculo seleccionado
                JOptionPane.showMessageDialog(null, "Seleccione un espectaculo");
            } else {
                //Finalmente, el sistema ingresa el espectáculo en el paquete seleccionado.
                if (plat_seleccionada.equals(nulo)==true){
                    JOptionPane.showMessageDialog(null, "Seleccione una plataforma");
                } else {
                    if (this.ICE.agregarEspectaculoAlPaquete(espec_seleccionada, paq_seleccionado) == true){
                        System.out.println("HOLAAAAAAAAAAAAAAAAAAAAAAAAAA"); 
                        JOptionPane.showMessageDialog(null, "Espectaculo " + espec_seleccionada + " agregado al paquete " + paq_seleccionado + " con exito!");
                    } else {
                        System.out.println("FALSEEEEEEEEEEEEEE"); 
                    }
                    this.ICE.obtenerEspectaculosPP(this.listEspectaculos, this.paq_seleccionado, this.plat_seleccionada);// Vuelvo a cargar los espectaculos
                }
                this.espec_seleccionada = "";
            }
        }
    }//GEN-LAST:event_btnAgregarAlPaqueteActionPerformed

    private void comboBoxPlataformasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboBoxPlataformasItemStateChanged
        if (this.i > 0) {
            paq_seleccionado = (String) listPaquetes.getSelectedValue();
            System.out.println("OBTENER ESPECTACULOS");  
            x++;
            if (x == 2){
                plat_seleccionada = (String) comboBoxPlataformas.getSelectedItem().toString();
                x = 0;
                this.ICE.obtenerEspectaculosPP(this.listEspectaculos, this.paq_seleccionado, this.plat_seleccionada);// Vuelvo a cargar los espectaculos
            }  
            this.espec_seleccionada = "";
        }
    }//GEN-LAST:event_comboBoxPlataformasItemStateChanged

    private void listPaquetesValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listPaquetesValueChanged
        this.comboBoxPlataformas.setEnabled(true);
        System.out.println("OBTENER PLATAFORMAS");  
        i++;
        this.comboBoxPlataformas.removeAllItems();
        this.ICE.obtenerPlataformasToComboBox(this.comboBoxPlataformas);
    }//GEN-LAST:event_listPaquetesValueChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarAlPaquete;
    private javax.swing.JComboBox<String> comboBoxPlataformas;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listEspectaculos;
    private javax.swing.JList<String> listPaquetes;
    // End of variables declaration//GEN-END:variables
}
