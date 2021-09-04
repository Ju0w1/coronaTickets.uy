package Presentacion;

import Logica.Fabrica;
import Logica.Interfaz.IControladorEspectaculo;
import Logica.Fabrica; //NUEVO
import Logica.Interfaz.IControladorEspectaculo; //NUEVO

public class AgregarPaquete extends javax.swing.JInternalFrame {

    private IControladorEspectaculo ICE;
    String paq_seleccionado;
    String plat_seleccionada;
    String espec_seleccionada;

    public AgregarPaquete() {
        initComponents();
        this.ICE = (IControladorEspectaculo) Fabrica.getInstance().getIControladorEspectaculo();
        this.ICE = Fabrica.getInstance().getIControladorEspectaculo();

        // el sistema lista los nombres de los paquetes que tiene registrados.
        this.ICE.obtenerPaquetes(this.listPaquetes);

        // Luego, el administrador selecciona una plataforma  
        // Me va a dar todas las plataformas existentes.
        this.ICE.obtenerPlataformasToComboBox(this.comboBoxPlataformas);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listPaquetes = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        listEspectaculos = new javax.swing.JList<>();
        comboBoxPlataformas = new javax.swing.JComboBox<>();
        btnRecordarPaquete = new javax.swing.JButton();
        btnObtenerEspectaculos = new javax.swing.JButton();
        btnAgregarAlPaquete = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setResizable(true);
        setTitle("Agregar Paquete Espectáculo");
        setPreferredSize(new java.awt.Dimension(500, 600));

        jLabel2.setText("Paquetes");

        jScrollPane1.setViewportView(listPaquetes);

        jLabel1.setText("Plataforma");

        jLabel5.setText("Espectáculos");

        jScrollPane2.setViewportView(listEspectaculos);

        comboBoxPlataformas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxPlataformasActionPerformed(evt);
            }
        });

        btnRecordarPaquete.setText("Seleccionar");
        btnRecordarPaquete.setActionCommand("Seleccionar");
        btnRecordarPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecordarPaqueteActionPerformed(evt);
            }
        });

        btnObtenerEspectaculos.setText(" Mostrar");
        btnObtenerEspectaculos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObtenerEspectaculosActionPerformed(evt);
            }
        });

        btnAgregarAlPaquete.setText("Agregar");
        btnAgregarAlPaquete.setActionCommand("");
        btnAgregarAlPaquete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarAlPaqueteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(jLabel1))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboBoxPlataformas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRecordarPaquete)
                            .addComponent(btnObtenerEspectaculos)
                            .addComponent(btnAgregarAlPaquete))))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRecordarPaquete))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboBoxPlataformas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(btnObtenerEspectaculos)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addComponent(btnAgregarAlPaquete)
                        .addGap(116, 116, 116))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboBoxPlataformasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxPlataformasActionPerformed
        // Guarda lo que se selecciono en el combobox de plataforma
        this.plat_seleccionada = comboBoxPlataformas.getSelectedItem().toString();
    }//GEN-LAST:event_comboBoxPlataformasActionPerformed

    private void btnRecordarPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecordarPaqueteActionPerformed
        // Guarda lo que se selecciono en el list de paquetes
        paq_seleccionado = (String) listPaquetes.getSelectedValue();
    }//GEN-LAST:event_btnRecordarPaqueteActionPerformed

    private void btnObtenerEspectaculosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObtenerEspectaculosActionPerformed
        // y el sistema lista los espectáculos existentes en esa plataforma
        // que no forman parte del paquete seleccionado.
        this.ICE.obtenerEspectaculosPP(this.listEspectaculos, this.paq_seleccionado, this.plat_seleccionada);
    }//GEN-LAST:event_btnObtenerEspectaculosActionPerformed

    private void btnAgregarAlPaqueteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarAlPaqueteActionPerformed

        //El administrador selecciona un espectáculo. 
        espec_seleccionada = (String) listEspectaculos.getSelectedValue();
        //Finalmente, el sistema ingresa el espectáculo en el paquete seleccionado.
        this.ICE.agregarEspectaculoAlPaquete(espec_seleccionada, paq_seleccionado);


    }//GEN-LAST:event_btnAgregarAlPaqueteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarAlPaquete;
    private javax.swing.JButton btnObtenerEspectaculos;
    private javax.swing.JButton btnRecordarPaquete;
    private javax.swing.JComboBox<String> comboBoxPlataformas;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> listEspectaculos;
    private javax.swing.JList<String> listPaquetes;
    // End of variables declaration//GEN-END:variables
}
