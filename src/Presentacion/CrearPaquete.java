
package Presentacion;
import Logica.Fabrica;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();

        setClosable(true);
        setResizable(true);
        setTitle("Crear Paquete Espectáculo");
        setMaximumSize(new java.awt.Dimension(435, 455));
        setMinimumSize(new java.awt.Dimension(435, 455));
        setPreferredSize(new java.awt.Dimension(435, 455));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Descripcion.setText("Descripcion");
        getContentPane().add(Descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 216, -1, -1));

        Nombre.setText("Nombre");
        getContentPane().add(Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 36, -1, -1));

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 30, 237, -1));

        jLabel5.setText("Fecha Inicio");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        fechaInicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        iMes.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));
        fechaInicio.add(iMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 5, -1, -1));

        iDia.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));
        fechaInicio.add(iDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 5, -1, -1));

        iAnio.setModel(new javax.swing.SpinnerNumberModel(2021, 2021, null, 1));
        iAnio.setPreferredSize(new java.awt.Dimension(50, 20));
        fechaInicio.add(iAnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 6, 87, 28));

        getContentPane().add(fechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, -1, -1));

        jLabel6.setText("Fecha Fin");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 120, -1, -1));

        fechaFin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fDia.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));
        fechaFin.add(fDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 5, -1, -1));

        fMes.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));
        fechaFin.add(fMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(86, 5, -1, -1));

        fAnio.setModel(new javax.swing.SpinnerNumberModel(2021, 2021, null, 1));
        fAnio.setPreferredSize(new java.awt.Dimension(50, 20));
        fechaFin.add(fAnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(145, 6, 87, 28));

        getContentPane().add(fechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 116, -1, -1));

        jLabel3.setText("Descuento");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, -1, -1));

        aceptar.setText("Agregar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });
        getContentPane().add(aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(207, 366, -1, -1));

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(296, 366, -1, -1));

        spDescuento.setModel(new javax.swing.SpinnerNumberModel(0, null, 100, 1));
        getContentPane().add(spDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 54, -1));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(49, 250, 325, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarActionPerformed
        /* Cuando se le da click a  */
        
        JTextField nombreTf = (JTextField)txtNombre; 
        JTextArea descripcionTf = (JTextArea)txtDescripcion; 
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    
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
    private javax.swing.JSpinner iAnio;
    private javax.swing.JSpinner iDia;
    private javax.swing.JSpinner iMes;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spDescuento;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
