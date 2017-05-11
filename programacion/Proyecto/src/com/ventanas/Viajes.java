/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ventanas;

import com.clases.Parte;
import com.clases.Trabajador;
import com.clases.Viaje;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author BE
 */
public class Viajes extends javax.swing.JFrame {
    private vFinJornada finJornada;
    private Object JSpinner3;
    private SpinnerDateModel sm;
    private SpinnerDateModel sm3;
     
    private DefaultTableModel tViajes;
    private List<Viaje> viaje;
    private final BigDecimal idT = Login.idt;
    private int index;
    /**
     * Creates new form Viajes
     */
    public Viajes() {
        initComponents();
        {
            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String fecha = dateFormat.format(date);
            jLabel3.setText(fecha);
            Trabajador t = Trabajador.filtrarTrabajador2(idT);
            jLabel4.setText(t.getNombre());

            listarViajes();

        }

    }

    private void listarViajes() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = dateFormat.format(date);

        tViajes = (DefaultTableModel) viajes.getModel();
        viaje = Viaje.logisticaViajes(idT, fecha);

        for (Viaje v : viaje) {
            tViajes.insertRow(tViajes.getRowCount(), new Object[]{v.getAlabaran(), v.getHoraInicio(), v.getHoraFin()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        java.util.Date date = new java.util.Date();
        sm =
        new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        jsinicio = new javax.swing.JSpinner(sm);
        java.util.Date date3 = new java.util.Date();
        sm3 =
        new SpinnerDateModel(date3, null, null, Calendar.HOUR_OF_DAY);
        jsfin = new javax.swing.JSpinner(sm3);
        uAlbaran = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        viajes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        modificar = new javax.swing.JButton();
        borrar = new javax.swing.JButton();
        fin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setText("PARTE VIAJES DIA:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        jButton1.setText("AÑADIR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        JSpinner.DateEditor de = new JSpinner.DateEditor(jsinicio, "HH:mm");
        jsinicio.setEditor(de);

        JSpinner.DateEditor de3 = new JSpinner.DateEditor(jsfin, "HH:mm");
        jsfin.setEditor(de3);

        viajes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N.º Albarán", "Hora Inicio", "Hora Fin"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        viajes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viajesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(viajes);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel1.setText("TRABAJADOR:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        modificar.setText("MODIFICAR");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        borrar.setText("BORRAR");
        borrar.setMaximumSize(new java.awt.Dimension(91, 23));
        borrar.setMinimumSize(new java.awt.Dimension(91, 23));
        borrar.setPreferredSize(new java.awt.Dimension(91, 23));
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });

        fin.setText("TERMINAR");
        fin.setMaximumSize(new java.awt.Dimension(91, 23));
        fin.setMinimumSize(new java.awt.Dimension(91, 23));
        fin.setPreferredSize(new java.awt.Dimension(91, 23));
        fin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(uAlbaran)
                                    .addComponent(jsinicio, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                    .addComponent(jsfin))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(modificar)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 15, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(117, 117, 117)
                                .addComponent(fin, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jsinicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jsfin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(modificar)
                            .addComponent(uAlbaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jButton1)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(borrar, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fin, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        
        if (uAlbaran.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos para insertar el viaje", "Atención", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Parte p = Parte.parte(idT);
        Viaje v = new Viaje(idT, p.getFecha(), Integer.parseInt(uAlbaran.getText()), dateFormat.format(sm.getDate()), dateFormat.format(sm3.getDate()));
        p.añadirViaje(v);
        v.setParte(p);
            Viaje i = new Viaje();
            i.setHoraInicio(dateFormat.format(sm.getDate()));
            i.setHoraFin(dateFormat.format(sm3.getDate()));
            i.setAlabaran(Integer.parseInt(uAlbaran.getText()));
            i.insertarViaje(idT, p.getFecha());
            if (viaje.size() > 0) {
                tViajes.setRowCount(0);
            }
            listarViajes();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void viajesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viajesMouseClicked
        index = viajes.getSelectedRow();

        uAlbaran.setText(Integer.toString(viaje.get(index).getAlabaran()));


    }//GEN-LAST:event_viajesMouseClicked

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date fech = new Date();
        DateFormat fechaFormat = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = fechaFormat.format(fech);
        if (uAlbaran.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Debes rellenar todos los campos para modificar el viaje", "Atención", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Viaje v = new Viaje(dateFormat.format(sm.getDate()), dateFormat.format(sm3.getDate()), Integer.parseInt(uAlbaran.getText()));
            v.modificarviaje(idT, fecha);
            if (viaje.size() > 0) {
                tViajes.setRowCount(0);
            }
            listarViajes();
        }
    }//GEN-LAST:event_modificarActionPerformed

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed

        int albaranb = viaje.get(index).getAlabaran();
        String fechab = Parte.parte(idT).getFecha();

        if (JOptionPane.showConfirmDialog(null, "Este viaje va a ser eliminado. \n¿Esta seguro?", "Atención",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            Viaje.borrarViaje(fechab, albaranb, idT);
            if (viaje.size() > 0) {
                tViajes.setRowCount(0);
            }
            listarViajes();
        } 
    }//GEN-LAST:event_borrarActionPerformed

    private void finActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finActionPerformed
        // TODO add your handling code here: 
        finJornada = new vFinJornada();
        finJornada.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_finActionPerformed

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
            java.util.logging.Logger.getLogger(Viajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Viajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Viajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Viajes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Viajes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton borrar;
    private javax.swing.JButton fin;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jsfin;
    private javax.swing.JSpinner jsinicio;
    private javax.swing.JButton modificar;
    private javax.swing.JTextField uAlbaran;
    private javax.swing.JTable viajes;
    // End of variables declaration//GEN-END:variables
}
