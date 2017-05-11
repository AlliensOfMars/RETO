/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ventanas;

import com.clases.Centro;
import java.math.BigDecimal;
import javax.swing.JOptionPane;

/**
 *
 * @author bcastrof
 */
public class AltaCentros extends javax.swing.JFrame {

    /**
     * Creates new form AltaCentros
     */
    public AltaCentros() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        nombre = new javax.swing.JTextField();
        calle = new javax.swing.JTextField();
        numero = new javax.swing.JTextField();
        ciudad = new javax.swing.JTextField();
        codigoPostal = new javax.swing.JTextField();
        provincia = new javax.swing.JTextField();
        telefono = new javax.swing.JTextField();
        alta = new javax.swing.JButton();
        limpiar = new javax.swing.JButton();
        volver = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Alta Centros");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nombre: *");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, -1, 26));
        jLabel1.getAccessibleContext().setAccessibleDescription("");

        jLabel2.setText("Calle: *");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, -1, 26));
        jLabel2.getAccessibleContext().setAccessibleDescription("");

        jLabel3.setText("Numero: *");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, -1, 26));
        jLabel3.getAccessibleContext().setAccessibleDescription("");

        jLabel4.setText("Ciudad: *");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, -1, 26));
        jLabel4.getAccessibleContext().setAccessibleDescription("");

        jLabel5.setText("Codigo Postal: *");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, -1, 26));
        jLabel5.getAccessibleContext().setAccessibleDescription("");

        jLabel6.setText("Provincia: *");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 360, -1, 26));
        jLabel6.getAccessibleContext().setAccessibleDescription("");

        jLabel7.setText("Telefono: *");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 410, -1, 26));
        jLabel7.getAccessibleContext().setAccessibleDescription("");

        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });
        getContentPane().add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 184, 26));
        nombre.getAccessibleContext().setAccessibleDescription("");

        getContentPane().add(calle, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 184, 26));
        calle.getAccessibleContext().setAccessibleDescription("");

        getContentPane().add(numero, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 184, 26));
        numero.getAccessibleContext().setAccessibleDescription("");

        getContentPane().add(ciudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 260, 184, 26));
        ciudad.getAccessibleContext().setAccessibleDescription("");

        getContentPane().add(codigoPostal, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 310, 184, 26));
        codigoPostal.getAccessibleContext().setAccessibleDescription("");

        getContentPane().add(provincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 360, 184, 26));
        provincia.getAccessibleContext().setAccessibleDescription("");

        getContentPane().add(telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 410, 184, 26));
        telefono.getAccessibleContext().setAccessibleDescription("");

        alta.setText("Alta");
        alta.setPreferredSize(new java.awt.Dimension(97, 23));
        alta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                altaActionPerformed(evt);
            }
        });
        getContentPane().add(alta, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 480, -1, -1));

        limpiar.setText("Limpiar");
        limpiar.setPreferredSize(new java.awt.Dimension(97, 23));
        limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });
        getContentPane().add(limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 480, -1, -1));

        volver.setText("Volver");
        volver.setPreferredSize(new java.awt.Dimension(97, 23));
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        getContentPane().add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 480, -1, -1));

        jLabel8.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        jLabel8.setText("ALTA DE CENTROS DE TRABAJO");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 30, -1, -1));

        jLabel11.setForeground(new java.awt.Color(255, 51, 51));
        jLabel11.setText("* Campos obligatorios");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 510, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
//ESTO FUNCIONA
    private void altaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_altaActionPerformed

       
       
        String name = nombre.getText();
        String street = calle.getText();
        BigDecimal number = new BigDecimal(numero.getText());
        String city = ciudad.getText();
        BigDecimal postalCode=new BigDecimal(codigoPostal.getText());
        String province = provincia.getText();
        BigDecimal phone = new BigDecimal(telefono.getText());
        Centro c = new Centro (name, street, number, city, postalCode, province, phone);
       
        boolean guardado = c.gestionCentros();

        if (guardado) {
            //todo intentar poner este mensaje mas guapo
            JOptionPane.showMessageDialog(null, "Centro dado de alta correctamente", "Alta", JOptionPane.INFORMATION_MESSAGE);
        }

        limpiarFormulario();
    }//GEN-LAST:event_altaActionPerformed

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limpiarActionPerformed
        limpiarFormulario();
    }//GEN-LAST:event_limpiarActionPerformed

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed
        CentrosUd abrir = new CentrosUd();
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_volverActionPerformed

    private void limpiarFormulario() {

        nombre.setText("");
        calle.setText("");
        numero.setText("");
        ciudad.setText("");
        codigoPostal.setText("");
        provincia.setText("");
        telefono.setText("");

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AltaCentros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AltaCentros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AltaCentros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AltaCentros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AltaCentros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alta;
    private javax.swing.JTextField calle;
    private javax.swing.JTextField ciudad;
    private javax.swing.JTextField codigoPostal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JButton limpiar;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField numero;
    private javax.swing.JTextField provincia;
    private javax.swing.JTextField telefono;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables

}
