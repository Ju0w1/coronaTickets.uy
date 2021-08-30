
package Presentacion;
import Logica.Fabrica;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import logica.Interfaz.IControladorEspetaculo;
import logica.Clases.DTFecha;

public class CrearPaquete extends javax.swing.JInternalFrame {
    private IControladorEspetaculo ICE;
    private boolean modifica;
    public CrearPaquete() {
        initComponents();
        this.modifica = false;
        this.ICE = Fabrica.getInstance().getIControladorEspetaculo();        
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        filler7 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        filler19 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        filler8 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        filler17 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        filler16 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        filler12 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        filler13 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        filler18 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        filler20 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        filler21 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        jPanel2 = new javax.swing.JPanel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        filler10 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        filler14 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        filler15 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 10), new java.awt.Dimension(0, 10), new java.awt.Dimension(32767, 10));
        txtDescripcion = new javax.swing.JTextField();
        Descripcion = new javax.swing.JLabel();
        Nombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        fechaInicio = new javax.swing.JPanel();
        iMes = new javax.swing.JSpinner();
        iDia = new javax.swing.JSpinner();
        iAnio = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        fechaFin = new javax.swing.JPanel();
        fDia = new javax.swing.JSpinner();
        fMes = new javax.swing.JSpinner();
        fAnio = new javax.swing.JSpinner();
        jLabel3 = new javax.swing.JLabel();
        aceptar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        spDescuento = new javax.swing.JSpinner();

        setResizable(true);
        setTitle("Crear Paquete Espectáculo");
        setPreferredSize(new java.awt.Dimension(500, 600));

        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.Y_AXIS));
        jPanel4.add(filler5);
        jPanel4.add(filler7);
        jPanel4.add(filler19);
        jPanel4.add(filler8);
        jPanel4.add(filler17);
        jPanel4.add(filler16);
        jPanel4.add(filler12);
        jPanel4.add(filler13);
        jPanel4.add(filler18);
        jPanel4.add(filler20);
        jPanel4.add(filler21);

        jPanel3.add(jPanel4);

        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));
        jPanel2.add(filler1);
        jPanel2.add(filler2);
        jPanel2.add(filler10);
        jPanel2.add(filler14);
        jPanel2.add(filler15);

        jPanel3.add(jPanel2);

        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });

        Descripcion.setText("Descripcion");

        Nombre.setText("Nombre");

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });

        jLabel5.setText("Fecha Inicio");

        iMes.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));
        fechaInicio.add(iMes);

        iDia.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));
        fechaInicio.add(iDia);

        iAnio.setModel(new javax.swing.SpinnerNumberModel(2021, 2021, null, 1));
        iAnio.setPreferredSize(new java.awt.Dimension(50, 20));
        fechaInicio.add(iAnio);

        jLabel6.setText("Fecha Fin");

        fDia.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));
        fechaFin.add(fDia);

        fMes.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));
        fechaFin.add(fMes);

        fAnio.setModel(new javax.swing.SpinnerNumberModel(2021, 2021, null, 1));
        fAnio.setPreferredSize(new java.awt.Dimension(50, 20));
        fechaFin.add(fAnio);

        jLabel3.setText("Descuento");

        aceptar.setText("Agregar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        jButton2.setText("Cancelar");

        spDescuento.setModel(new javax.swing.SpinnerNumberModel(0, null, 100, 1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addGap(5, 5, 5))
                                        .addComponent(jLabel3))
                                    .addComponent(Nombre)
                                    .addComponent(jLabel5))
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
                                    .addComponent(spDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(fechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(fechaFin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(Descripcion)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(49, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(aceptar)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(spDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(Descripcion)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptar)
                    .addComponent(jButton2))
                .addContainerGap(97, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        /* Cuando se le da click a  */
        
        JTextField nombreTf = (JTextField)txtNombre; 
        JTextField descripcionTf = (JTextField)txtDescripcion; 
        JSpinner descuentoTf = (JSpinner)spDescuento; 
        JSpinner diaIS = (JSpinner)iDia;
        JSpinner mesIS = (JSpinner)iMes;
        JSpinner anioIS = (JSpinner)iAnio;
        
        JSpinner diaFS = (JSpinner)fDia;
        JSpinner mesFS = (JSpinner)fMes;
        JSpinner anioFS = (JSpinner)fAnio;
        
        String nombre = nombreTf.getText();
        String descripcion = descripcionTf.getText();
        
        int descuento = (int) descuentoTf.getValue();
        
        int anioi = Integer.parseInt(anioIS.getValue().toString());
        int mesi = Integer.parseInt(mesIS.getValue().toString());
        int diai = Integer.parseInt(diaIS.getValue().toString()); 
        DTFecha fechaInicio = new DTFecha(diai,mesi,anioi);
        
        int aniof = Integer.parseInt(anioFS.getValue().toString());
        int mesf = Integer.parseInt(mesFS.getValue().toString());
        int diaf = Integer.parseInt(diaFS.getValue().toString());
        
        DTFecha fechaFin = new DTFecha(diaf,mesf,aniof);
        System.out.println(this.modifica);
        if(this.modifica) //Entra acá porque modificamos la que encontramos
        {
            if(this.ICE.actualizarPaquete(nombre, fechaInicio, fechaFin, descuento, descripcion)) // Se creo correctamente
            {
                JOptionPane.showMessageDialog(this, "Actualizo correctamente");    
                this.limpiarFormulario();
            }
        }else{
            if(this.ICE.crearPaquete(nombre, fechaInicio, fechaFin, descuento, descripcion)) // Se creo correctamente
            {
                JOptionPane.showMessageDialog(this, "Agregado correctamente");    
            }else{ //Lo encontro lleno los datos y dejo para modificarla
                this.llenamosCampos(nombre);
                this.modifica = true;
            }    
        }
        
    }//GEN-LAST:event_aceptarActionPerformed

    
    void llenamosCampos(String nombre) //Con el nombre mandamos porque es unico en el sistema
    {   
        this.aceptar.setText("Modifcar");     
        this.txtNombre.setEditable(false);
        this.txtNombre.setEnabled(false);
        this.txtDescripcion.setText(this.ICE.obtenerDescripcion(nombre));
        String[] fechaInicio = this.ICE.obtenerFecha(nombre, 1);
        int anioI = Integer.parseInt(fechaInicio[0]);
        int mesI = Integer.parseInt(fechaInicio[1]);
        int diaI = Integer.parseInt(fechaInicio[2]);
        String[] fechaFin = this.ICE.obtenerFecha(nombre, 2);
        int anioF = Integer.parseInt(fechaFin[0]);
        int mesF = Integer.parseInt(fechaFin[1]);
        int diaF = Integer.parseInt(fechaFin[2]);
        this.iDia.setValue(diaI);
        this.iMes.setValue(mesI);
        this.iAnio.setValue(anioI);
        this.fDia.setValue(diaF);
        this.fMes.setValue(mesF);
        this.fAnio.setValue(anioF);
        this.spDescuento.setValue(this.ICE.obtenerDescuento(nombre));
    }
    
    void limpiarFormulario()
    {
        this.txtNombre.setEditable(true);
        this.txtNombre.setEnabled(true);
        this.txtNombre.setText("");
        this.txtDescripcion.setText("");
        this.spDescuento.setValue(1);
        this.iDia.setValue(1);
        this.iMes.setValue(1);
        this.iAnio.setValue(2021);
        this.fDia.setValue(1);
        this.fMes.setValue(1);
        this.fAnio.setValue(2021);
        this.aceptar.setText("Agregar");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Descripcion;
    private javax.swing.JLabel Nombre;
    private javax.swing.JButton aceptar;
    private javax.swing.JSpinner fAnio;
    private javax.swing.JSpinner fDia;
    private javax.swing.JSpinner fMes;
    private javax.swing.JPanel fechaFin;
    private javax.swing.JPanel fechaInicio;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler10;
    private javax.swing.Box.Filler filler12;
    private javax.swing.Box.Filler filler13;
    private javax.swing.Box.Filler filler14;
    private javax.swing.Box.Filler filler15;
    private javax.swing.Box.Filler filler16;
    private javax.swing.Box.Filler filler17;
    private javax.swing.Box.Filler filler18;
    private javax.swing.Box.Filler filler19;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler20;
    private javax.swing.Box.Filler filler21;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler7;
    private javax.swing.Box.Filler filler8;
    private javax.swing.JSpinner iAnio;
    private javax.swing.JSpinner iDia;
    private javax.swing.JSpinner iMes;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSpinner spDescuento;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
