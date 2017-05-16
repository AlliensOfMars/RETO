/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ventanas;

import com.clases.Centro;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bcastrof
 */
public class CentrosUd extends javax.swing.JFrame {

    /**
    *Variable que se utiliza para almacenar la id del centro que seleccionamos 
    *en la tabla.
     */
    private BigDecimal idCent;
    /**
    *Variable que se utiliza para almacenar el nombre del centro que seleccionamos 
    *en la tabla.
     */
    private String name;
    /**
     *Modelado de la tabla centros.
     */
    private DefaultTableModel centros;
    /**
     *Array que se ocupa de almacenar los datos de todos los centros obtenidos
     *de la base de Datos.
    */
    private List<Centro> centro;
    /**
     *Obejeto del tipo centro que utilizaremos para recuperar la informacion 
     *de un solo Centro.
    */
    private Centro c;

   /**
    *Metodo que se ocupa de rellar la tabla de la ventana, la cual recibe un
    *array con todos los datos, y se ocupa de insertarlos en la tabla.
    */
    
    private void listarCentros() {
        centros = (DefaultTableModel) jTable1.getModel();
        centro = Centro.listarCentros();

        centro.forEach((c) -> {
            centros.insertRow(centros.getRowCount(), new Object[]{c.getIDcent(), c.getNombre(),
                c.getCalle(), c.getNumero(), c.getCiudad(), c.getCodigoPostal(), c.getProvincia(), c.getTelefonos()});
        });

    }
   /**
    *Metodo que se ocupa de rellar la tabla de la ventana, la cual recibe un
    *objeto de la clase Centro (el cual hemos filtrado utilizando la variable
    *name), y se ocupa de insertarlo en la tabla, y de enseñar solamente esa
    *tupla de la cual se ha realizado la busqueda.
    */
    private void filtrarCentos() {
        centros.setRowCount(0);
        centros = (DefaultTableModel) jTable1.getModel();
        c = Centro.centroN(name);
        if (c == null) {
            listarCentros();
        } else {
            centros.insertRow(centros.getRowCount(), new Object[]{c.getIDcent(), c.getNombre(),
                c.getCalle(), c.getNumero(), c.getCiudad(), c.getCodigoPostal(), c.getProvincia(), c.getTelefonos()});
        }
    }

    public CentrosUd() {
        initComponents();
        listarCentros();
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        bname = new javax.swing.JTextField();
        filtrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        listado = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        uNombre = new javax.swing.JTextField();
        uCalle = new javax.swing.JTextField();
        uCiudad = new javax.swing.JTextField();
        uCodigoPostal = new javax.swing.JTextField();
        uNumero = new javax.swing.JTextField();
        uProvincia = new javax.swing.JTextField();
        uTelefono = new javax.swing.JTextField();
        modificar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bAltaCentro = new javax.swing.JButton();
        bVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de Centros");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "CALLE", "NUMERO", "CIUDAD", "CODIGO POSTAL", "PROVINCIA", "TELEFONO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setHeaderValue("CALLE");
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setHeaderValue("NUMERO");
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setHeaderValue("CODIGO POSTAL");
        }

        filtrar.setText("Filtrar");
        filtrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtrarActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre :");

        listado.setText("Listar Todos");
        listado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listadoActionPerformed(evt);
            }
        });

        eliminar.setText("Eliminar Centro Seleccionado");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        modificar.setText("Modificar Centro");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        jLabel10.setText("CENTROS DE TRABAJO");

        jLabel3.setText("Nombre : *");

        jLabel4.setText("Calle : *");

        jLabel5.setText("Ciudad : *");

        jLabel8.setText("Provincia : *");

        jLabel6.setText("Telefono : *");

        jLabel7.setText("Numero : *");

        jLabel9.setText("Codigo Postal : *");

        jLabel11.setForeground(new java.awt.Color(255, 51, 51));
        jLabel11.setText("* Campos obligatorios");

        jLabel2.setText("Datos del Centro Seleccionado :");

        bAltaCentro.setText("Nuevo Centro");
        bAltaCentro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAltaCentroActionPerformed(evt);
            }
        });

        bVolver.setText("Volver");
        bVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(bname, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(filtrar)
                                .addGap(77, 77, 77)
                                .addComponent(eliminar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                                .addComponent(listado))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addComponent(jLabel8))
                            .addComponent(jLabel6)
                            .addComponent(jLabel2))
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(uNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(uTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(modificar))
                                    .addComponent(uProvincia, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(uCiudad, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(uCalle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(39, 39, 39)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel7)
                                                .addComponent(jLabel9))
                                            .addComponent(bAltaCentro))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(uNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(uCodigoPostal, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(69, 69, 69)
                                                .addComponent(bVolver))))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel11)
                                        .addGap(33, 33, 33))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(309, 309, 309)
                        .addComponent(jLabel10)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bname, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filtrar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(listado, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(uNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(uCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(uNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(uCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(uCodigoPostal, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modificar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bAltaCentro, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
     
    /**
     * 
     * Evento que se ocupa de recoger el dato que ha insertado el usuario
     * y de pasarlo al metodo filtrarCentos.
     */
    private void filtrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtrarActionPerformed
       
        name = bname.getText();
        filtrarCentos();
    }//GEN-LAST:event_filtrarActionPerformed
/**
 * 
 * Evento que e ocupa de volver a listar todos los centros haciendo la llamada
 * al metodo listarCentros.
 */
    private void listadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listadoActionPerformed
        centros.setRowCount(0);
        listarCentros();
    }//GEN-LAST:event_listadoActionPerformed
/**
 * 
 * Evento que se ocupa de rellenar todos los campos con los difrentes datos,
 * de la tupla que hayamos seleccionado en la tabla.
 */
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // mapeo los campos de la fila seleccionada
        int index = jTable1.getSelectedRow();
        // centros = (DefaultTableModel) jTable1.getModel();
        idCent = new BigDecimal(centros.getValueAt(index, 0).toString());

        //mapeo y translado de los valores a los diferentes campos del formulario
        uNombre.setText(centro.get(index).getNombre());
        uCalle.setText(centros.getValueAt(index, 2).toString());
        uNumero.setText(centros.getValueAt(index, 3).toString());
        uCiudad.setText(centros.getValueAt(index, 4).toString());
        uCodigoPostal.setText(centros.getValueAt(index, 5).toString());
        uProvincia.setText(centros.getValueAt(index, 6).toString());
        uTelefono.setText(centros.getValueAt(index, 7).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    public void limpiarFormulario() {
        uNombre.setText("");
        uCalle.setText("");
        uNumero.setText("");
        uCiudad.setText("");
        uCodigoPostal.setText("");
        uProvincia.setText("");
        uTelefono.setText("");
    }
/**
 * 
 * Evento que se ocupa de recoger los datos de las cjas de texto, y a su vez
 * hace la llamada el metodo modificarCentro el cual se ocupara de modificar 
 * los datos en nuestra base datos caso hayamos realizado algun cambio.
 */
    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed

        //creo centro para pasar al metodo modificar.
        Centro centro = new Centro(uNombre.getText(), uCalle.getText(), new BigDecimal(uNumero.getText()),
                uCiudad.getText(), new BigDecimal(uCodigoPostal.getText()),
                uProvincia.getText(), new BigDecimal(uTelefono.getText()));

        boolean modifcar = centro.modificarCentro(idCent);

        if (modifcar) {
            JOptionPane.showMessageDialog(null, "Centro modificado correctamente", "Modificado", JOptionPane.INFORMATION_MESSAGE);
        }
        //limpio tabla
        centros.setRowCount(0);
        //cargo lista actualizada
        listarCentros();
        //limpio formulario
        limpiarFormulario();
    }//GEN-LAST:event_modificarActionPerformed
/**
 * 
 *Evento que se ocupa de recoger la id del centro que hayamos elegido, para 
 * pasarlo al metodo bajaCentro el cual se ocupara de dar de baja en nuestra
 * base de datos el centro seleccionado.
 */
    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed

        if (JOptionPane.showConfirmDialog(null, "Este centro va a ser eliminado. \n¿Esta seguro?", "Atención",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            Centro.bajaCenro(idCent);
            if (centro.size() > 0) {
                centros.setRowCount(0);
            }
            listarCentros();
        }
        //limpio formulario
        limpiarFormulario();
    }//GEN-LAST:event_eliminarActionPerformed

    private void bAltaCentroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAltaCentroActionPerformed
        AltaCentros abrir = new AltaCentros();
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bAltaCentroActionPerformed

    private void bVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bVolverActionPerformed
        //Vuelve a la ventana de gestión

        Administracion abrir = new Administracion();
        abrir.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bVolverActionPerformed

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
            java.util.logging.Logger.getLogger(CentrosUd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CentrosUd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CentrosUd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CentrosUd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CentrosUd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAltaCentro;
    private javax.swing.JButton bVolver;
    private javax.swing.JTextField bname;
    private javax.swing.JButton eliminar;
    private javax.swing.JButton filtrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton listado;
    private javax.swing.JButton modificar;
    private javax.swing.JTextField uCalle;
    private javax.swing.JTextField uCiudad;
    private javax.swing.JTextField uCodigoPostal;
    private javax.swing.JTextField uNombre;
    private javax.swing.JTextField uNumero;
    private javax.swing.JTextField uProvincia;
    private javax.swing.JTextField uTelefono;
    // End of variables declaration//GEN-END:variables
}
