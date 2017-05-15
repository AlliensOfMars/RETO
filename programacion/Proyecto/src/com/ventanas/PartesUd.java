/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ventanas;

import com.clases.Parte;
import com.clases.Administracion;
import com.clases.Aviso;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import javax.swing.table.DefaultTableModel;



/**
 *
 * @author Miriam
 */
public class PartesUd extends javax.swing.JFrame {

  private DefaultTableModel tPartesModel;
  private List<Parte>partes;
  private static int index;
   
    public PartesUd() {
        initComponents();
        /* coloco aqui el listar partes para cuando la ventana se abra directamente saque el listado de todos
        /los partes*/
        listarPartes();
    }

    /*listado de todos los partes, aqui llamamos al metodo listarPartes que esta dentro de la calse partes 
  el cual recibe la informacion que le devuelve un cursor de la base de datos y vuelca dicha información, en 
  un Array List*/
  
  private void listarPartes(){
      tPartesModel=(DefaultTableModel) tPartes.getModel();
      partes=Parte.listarPartes();
      
      partes.forEach((p) -> {
     
          tPartesModel.insertRow(tPartesModel.getRowCount(), new Object[]{p.getIdTrabajador(),p.getFecha(),
              p.getValidado(),p.getEstado(),p.getHorasExtras(),p.getKmInicial(),p.getIncidencias(),p.getKmFinal(),
              p.getGastoPeaje(),p.getGastoDietas(),p.getGastoCombustible(),p.getGastoVarios(),
              p.getNotasAdministrativas()
          });
      });
  }
  
  private void partesTFI(BigDecimal idT, String fechaIni, String fechaFin){
      tPartesModel.setRowCount(0);
      tPartesModel=(DefaultTableModel) tPartes.getModel();
      partes=Parte.partesTFI(idT, fechaIni, fechaFin);
      
      partes.forEach((p) -> {
      
          tPartesModel.insertRow(tPartesModel.getRowCount(), new Object[]{p.getIdTrabajador(),p.getFecha(),
              p.getValidado(),p.getEstado(),p.getKmInicial(),p.getIncidencias(),p.getKmFinal(),
              p.getGastoPeaje(),p.getGastoDietas(),p.getGastoCombustible(),p.getGastoVarios(),
              p.getHorasExtras(),p.getNotasAdministrativas()
          });
      });
      
  }
    private void partesTFF(String fechaIni, String fechaFin){
      tPartesModel.setRowCount(0);
      tPartesModel=(DefaultTableModel) tPartes.getModel();
      partes=Parte.partesTFF(fechaIni, fechaFin);
      
      partes.forEach((p) -> {
      
          tPartesModel.insertRow(tPartesModel.getRowCount(), new Object[]{p.getIdTrabajador(),p.getFecha(),
              p.getValidado(),p.getEstado(),p.getKmInicial(),p.getIncidencias(),p.getKmFinal(),
              p.getGastoPeaje(),p.getGastoDietas(),p.getGastoCombustible(),p.getGastoVarios(),
              p.getHorasExtras(),p.getNotasAdministrativas()
          });
      });   
  }
        private void partesTFA(){
      tPartesModel.setRowCount(0);
      tPartesModel=(DefaultTableModel) tPartes.getModel();
      partes=Parte.partesTFA();
      
      partes.forEach((p) -> {
      
          tPartesModel.insertRow(tPartesModel.getRowCount(), new Object[]{p.getIdTrabajador(),p.getFecha(),
              p.getValidado(),p.getEstado(),p.getKmInicial(),p.getIncidencias(),p.getKmFinal(),
              p.getGastoPeaje(),p.getGastoDietas(),p.getGastoCombustible(),p.getGastoVarios(),
              p.getHorasExtras(),p.getNotasAdministrativas()
          });
      });   
  }
              private void partesTFC(){
      tPartesModel.setRowCount(0);
      tPartesModel=(DefaultTableModel) tPartes.getModel();
      partes=Parte.partesTFC();
      
      partes.forEach((p) -> {
      
          tPartesModel.insertRow(tPartesModel.getRowCount(), new Object[]{p.getIdTrabajador(),p.getFecha(),
              p.getValidado(),p.getEstado(),p.getKmInicial(),p.getIncidencias(),p.getKmFinal(),
              p.getGastoPeaje(),p.getGastoDietas(),p.getGastoCombustible(),p.getGastoVarios(),
              p.getHorasExtras(),p.getNotasAdministrativas()
          });
      });   
  }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tPartes = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        listarPartes = new javax.swing.JButton();
        bBuscarPartes = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        uIdTrab = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jLabel12 = new javax.swing.JLabel();
        uPeaje = new javax.swing.JTextField();
        uDietas = new javax.swing.JTextField();
        uCombustible = new javax.swing.JTextField();
        uOtros = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        uIncidencias = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        uNotasAdministrativas = new javax.swing.JTextArea();
        jLabel19 = new javax.swing.JLabel();
        validar = new javax.swing.JButton();
        avisar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Andalus", 1, 24)); // NOI18N
        jLabel1.setText("GESTION DE PARTES");

        tPartes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id trabajador", "Fecha", "Validado", "Estado", "Horas Extras"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tPartes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tPartesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tPartes);

        jButton1.setText("Lista Partes Abiertos");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Lista Partes Cerrados");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        listarPartes.setText("Ver todos los partes");
        listarPartes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarPartesActionPerformed(evt);
            }
        });

        bBuscarPartes.setText("Buscar Partes");
        bBuscarPartes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bBuscarPartesActionPerformed(evt);
            }
        });

        jLabel8.setText("Id Trabajador: ");

        uIdTrab.setPreferredSize(new java.awt.Dimension(6, 30));

        jLabel9.setText("Fecha 1 : *");

        jLabel10.setText("Fecha 2: * ");

        jLabel11.setForeground(new java.awt.Color(255, 51, 51));
        jLabel11.setText("* Campos obligatorios");

        jLabel12.setText("DATOS DEL PARTE");

        uPeaje.setEditable(false);

        uDietas.setEditable(false);

        uCombustible.setEditable(false);

        uOtros.setEditable(false);

        uIncidencias.setEditable(false);
        uIncidencias.setColumns(20);
        uIncidencias.setRows(5);
        jScrollPane2.setViewportView(uIncidencias);

        jLabel13.setText("GASTOS:");

        jLabel14.setText("PEAJE");

        jLabel15.setText("DIETAS");

        jLabel16.setText("COMBUSTIBLE");

        jLabel17.setText("OTROS");

        jLabel18.setText("INCIDENCIAS");

        uNotasAdministrativas.setColumns(20);
        uNotasAdministrativas.setRows(5);
        jScrollPane3.setViewportView(uNotasAdministrativas);

        jLabel19.setText("NOTAS ADMINISTRATIVAS");

        validar.setText("VALIDAR");
        validar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validarActionPerformed(evt);
            }
        });

        avisar.setText("AVISAR");
        avisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(255, 255, 255)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(uIdTrab, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bBuscarPartes, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(listarPartes, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1)
                                    .addComponent(jButton2)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(uPeaje, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(uDietas, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel15)))
                                                .addComponent(jLabel14))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(uCombustible, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel16))
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(uOtros, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel17)))
                                        .addComponent(jLabel13)
                                        .addComponent(jLabel12)
                                        .addComponent(jScrollPane3))
                                    .addComponent(jLabel19))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(validar)
                                        .addGap(18, 18, 18)
                                        .addComponent(avisar)))))
                        .addContainerGap(77, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(listarPartes)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(uIdTrab, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bBuscarPartes))
                            .addComponent(jLabel9)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2)))
                .addGap(25, 25, 25)
                .addComponent(jLabel12)
                .addGap(13, 13, 13)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel18))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(validar)
                                    .addComponent(avisar)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(uPeaje, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(uDietas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(13, 13, 13)
                        .addComponent(uOtros, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(13, 13, 13)
                        .addComponent(uCombustible, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bBuscarPartesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarPartesActionPerformed

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        
        if (uIdTrab.getText().equalsIgnoreCase("")) {
            partesTFF(dateFormat.format(jDateChooser1.getDate()), dateFormat.format(jDateChooser2.getDate()));
        }else{    
           
            partesTFI(new BigDecimal(uIdTrab.getText()), dateFormat.format(jDateChooser1.getDate()), dateFormat.format(jDateChooser2.getDate()));
        }
    
    }//GEN-LAST:event_bBuscarPartesActionPerformed

    private void listarPartesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarPartesActionPerformed
        // TODO add your handling code here:
        listarPartes();
    }//GEN-LAST:event_listarPartesActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        partesTFA();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        partesTFC();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void validarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validarActionPerformed
        // TODO add your handling code here:
        Parte p = new Parte(partes.get(index).getFecha(), partes.get(index).getIdTrabajador(), procesarCampo(uNotasAdministrativas));
       if(!partes.get(index).getValidado().equalsIgnoreCase("si")){
              if( Administracion.gestionParte(p)==true){
             JOptionPane.showMessageDialog(null, "Parte validado correctamente.", "Validado", JOptionPane.INFORMATION_MESSAGE);
        }
       }else{
           JOptionPane.showMessageDialog(null, "Este parte ya ha sido validado.", "Validado", JOptionPane.INFORMATION_MESSAGE); 
       }
     
    }//GEN-LAST:event_validarActionPerformed

    private void tPartesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tPartesMouseClicked
        // TODO add your handling code here:
        
        index = tPartes.getSelectedRow();
        uPeaje.setText(partes.get(index).getGastoPeaje().toString());
        uDietas.setText(partes.get(index).getGastoDietas().toString());
        uCombustible.setText(partes.get(index).getGastoCombustible().toString());
        uOtros.setText(partes.get(index).getGastoVarios().toString());
        uIncidencias.setText(partes.get(index).getIncidencias());
        
    }//GEN-LAST:event_tPartesMouseClicked

    private void avisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avisarActionPerformed
      String resultado= JOptionPane.showInputDialog(null,"Aviso","Generar aviso",JOptionPane.YES_OPTION);
if (resultado!=null){
    Aviso a = new Aviso(resultado, partes.get(index).getIdTrabajador(), partes.get(index).getFecha());
    if(Administracion.gestionarAviso(a)==true){
         JOptionPane.showMessageDialog(null, "Aviso enviado correctamente.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
    }
    
   
}
    }//GEN-LAST:event_avisarActionPerformed

        public String procesarCampo(JTextArea t){
  
            String cadena="";
        
     if (t.getText().equalsIgnoreCase("")){
          cadena = "No Procede";
        }else{
     cadena = t.getText();
     }
    return cadena;
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
            java.util.logging.Logger.getLogger(PartesUd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PartesUd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PartesUd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PartesUd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PartesUd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton avisar;
    private javax.swing.JButton bBuscarPartes;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton listarPartes;
    private javax.swing.JTable tPartes;
    private javax.swing.JTextField uCombustible;
    private javax.swing.JTextField uDietas;
    private javax.swing.JTextField uIdTrab;
    private javax.swing.JTextArea uIncidencias;
    private javax.swing.JTextArea uNotasAdministrativas;
    private javax.swing.JTextField uOtros;
    private javax.swing.JTextField uPeaje;
    private javax.swing.JButton validar;
    // End of variables declaration//GEN-END:variables
}
