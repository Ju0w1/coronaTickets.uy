
package Presentacion;
import Logica.Fabrica;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import Logica.Interfaz.IControladorEspectaculo;
import Logica.DataTypes.DTFecha;
import java.util.Date;
import javax.swing.JFrame;

public class CrearPaquete extends javax.swing.JInternalFrame {
    
    private IControladorEspectaculo ICE;
    private boolean modifica;
    public CrearPaquete() {
        initComponents();
        this.modifica = false;
        this.ICE = Fabrica.getInstance().getIControladorEspectaculo();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Descripcion = new javax.swing.JLabel();
        Nombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        fechaInicio = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        fechaFin = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        aceptar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        spDescuento = new javax.swing.JSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        iMes = new javax.swing.JSpinner();
        iDia = new javax.swing.JSpinner();
        iAnio = new javax.swing.JSpinner();
        fDia = new javax.swing.JSpinner();
        fMes = new javax.swing.JSpinner();
        fAnio = new javax.swing.JSpinner();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Crear Paquete de Espectáculo");
        setMaximumSize(new java.awt.Dimension(380, 420));
        setMinimumSize(new java.awt.Dimension(380, 420));
        setPreferredSize(new java.awt.Dimension(380, 420));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Descripcion.setText("Descripcion");
        getContentPane().add(Descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        Nombre.setText("Nombre");
        getContentPane().add(Nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 237, 30));

        jLabel5.setText("Fecha Inicio");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        fechaInicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(fechaInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, -1, -1));

        jLabel6.setText("Fecha Fin");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        fechaFin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(fechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 116, -1, -1));

        jLabel3.setText("  Descuento");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 70, -1));

        aceptar.setText("Agregar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });
        getContentPane().add(aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, -1, -1));

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 350, -1, -1));

        spDescuento.setModel(new javax.swing.SpinnerNumberModel(0, null, 100, 1));
        getContentPane().add(spDescuento, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 54, 30));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 330, 130));

        iMes.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));
        getContentPane().add(iMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, -1, 30));

        iDia.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));
        getContentPane().add(iDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, -1, 30));

        iAnio.setModel(new javax.swing.SpinnerNumberModel(2021, 2021, null, 1));
        iAnio.setPreferredSize(new java.awt.Dimension(50, 20));
        getContentPane().add(iAnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 80, 30));

        fDia.setModel(new javax.swing.SpinnerNumberModel(1, 1, 31, 1));
        getContentPane().add(fDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, -1, 30));

        fMes.setModel(new javax.swing.SpinnerNumberModel(1, 1, 12, 1));
        getContentPane().add(fMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, -1, 30));

        fAnio.setModel(new javax.swing.SpinnerNumberModel(2021, 2021, null, 1));
        fAnio.setPreferredSize(new java.awt.Dimension(50, 20));
        getContentPane().add(fAnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 80, 30));

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
        if (nombre.equals("") || descripcion.equals("")){
            JOptionPane.showMessageDialog(this, "Complete todos los campos por favor"); 
        } else {
            int descuento = (int) descuentoTf.getValue();

            int anioi = Integer.parseInt(anioIS.getValue().toString());
            int mesi = Integer.parseInt(mesIS.getValue().toString());
            int diai = Integer.parseInt(diaIS.getValue().toString()); 
            if (this.ICE.controlFecha(diai, mesi, anioi) == false ){
               JOptionPane.showMessageDialog(this, "Fecha de inicio incorrecta"); 
            } else {
                DTFecha fechaInicio = new DTFecha(diai,mesi,anioi);

                int aniof = Integer.parseInt(anioFS.getValue().toString());
                int mesf = Integer.parseInt(mesFS.getValue().toString());
                int diaf = Integer.parseInt(diaFS.getValue().toString());
                if (this.ICE.controlFecha(diaf, mesf, aniof) == false ){
                    JOptionPane.showMessageDialog(this, "Fecha de finalizacion incorrecta"); 
                } else {
                    if (this.ICE.fechaInicioMayor(diaf, mesf, aniof,diai, mesi, anioi) == false ){
                        JOptionPane.showMessageDialog(this, "Fecha de inicio debe ser menor o igual fecha de finalizacion"); 
                    } else {
                        DTFecha fechaFin = new DTFecha(diaf,mesf,aniof);
                        System.out.println(this.modifica);
                        if(this.modifica) //Entra acá porque modificamos la que encontramos
                        {
                            if(this.ICE.actualizarPaquete(nombre, fechaInicio, fechaFin, descuento, descripcion)) // Se creo correctamente
                            {
                                JOptionPane.showMessageDialog(this, "Actualizo correctamente");    
                                this.limpiarFormulario();
                                this.modifica = false;
                            }
                        }else{
                            if(this.ICE.crearPaquete(nombre, fechaInicio, fechaFin, descuento, descripcion)) // Se creo correctamente
                            {
                                JOptionPane.showMessageDialog(this, "Agregado correctamente");    
                            }else{ //Lo encontro lleno los datos y dejo para modificarla
                                
                                JFrame frame = new JFrame();
                                Object[] options = {"Si", "No"};
                                int n = JOptionPane.showOptionDialog(frame,
                                "Ya existe un paquete con ese nombre ",
                                "Modificarlo?",
                                JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE,
                                null,     //do not use a custom Icon
                                options,  //the titles of buttons
                                options[0]); //default button title
                                
                                if(n == 0){
                                    this.llenamosCampos(nombre);
                                this.modifica = true;
                                } else {
                                    this.limpiarFormulario();
                                }
                            }
                        }
                    }
                }
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
