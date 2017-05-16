/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ventanas;

import com.clases.Parte;
import com.clases.Administracion;
import com.clases.Aviso;
import com.clases.Conducen;
import com.clases.Viaje;
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

    /**
     * Modelado de la tabla partes.
     */
    private DefaultTableModel tPartesModel;
    /**
     * Array que va almacenar el listado obtenido de la base datos, para
     * posteriormente poder volvar los datos en la tabla partes.
     */
    private List<Parte> partes;
    /**
     * Modelado de la tabla viajes.
     */
    private DefaultTableModel tViajes;
    /**
     * Array que va almacenar el listado obtenido de la base datos, para
     * posteriormente poder volvar los datos en la tabla viajes.
     */
    private List<Viaje> viaje;
    /**
     * Variable que va a contener la posicion de la tupla seleccionada en la
     * tabla.
     */
    private int index;
    /**
     * Variable que va a contener la id del trabajador.
     */
    private BigDecimal idt;
    /**
     * Varible que va contener la fecha.
     */
    private String fecha;

    /**
     * Objeto ventana administracion.
     */
    private com.ventanas.Administracion administracion;

    public PartesUd() {
        initComponents();
        /**
         * coloco aqui el listar partes para cuando la ventana se abra
         * directamente saque el listado de todos los partes.
         */
        listarPartes();
    }

    /**
     * Listado de todos los partes, aqui llamamos al metodo listarPartes que
     * esta dentro de la calse partes el cual recibe la informacion que le
     * devuelve un cursor de la base de datos y vuelca dicha información,en un
     * ArrayList.
     */
    private void listarPartes() {
        tPartesModel = (DefaultTableModel) tPartes.getModel();
        partes = Parte.listarPartes();

        partes.forEach((p) -> {

            tPartesModel.insertRow(tPartesModel.getRowCount(), new Object[]{p.getIdTrabajador(), p.getFecha(),
                p.getValidado(), p.getEstado(), p.getHorasExtras(), p.getKmInicial(), p.getIncidencias(), p.getKmFinal(),
                p.getGastoPeaje(), p.getGastoDietas(), p.getGastoCombustible(), p.getGastoVarios(),
                p.getNotasAdministrativas()
            });
        });
    }

    /**
     * Listado de partes de un trabajador en un determinado rango de fechas,
     * este metodo recibe los parametros idt, fechaini, fechafin, que se recogen
     * de del cuadro de texto id y de los dos calendarios.
     */
    private void partesTFI(BigDecimal idT, String fechaIni, String fechaFin) {
        tPartesModel.setRowCount(0);
        tPartesModel = (DefaultTableModel) tPartes.getModel();
        partes = Parte.partesTFI(idT, fechaIni, fechaFin);

        partes.forEach((p) -> {

            tPartesModel.insertRow(tPartesModel.getRowCount(), new Object[]{p.getIdTrabajador(), p.getFecha(),
                p.getValidado(), p.getEstado(), p.getKmInicial(), p.getIncidencias(), p.getKmFinal(),
                p.getGastoPeaje(), p.getGastoDietas(), p.getGastoCombustible(), p.getGastoVarios(),
                p.getHorasExtras(), p.getNotasAdministrativas()
            });
        });

    }

    /**
     * Listado de partes de un trabajador en un determinado rango de fechas,
     * este metodo recibe los parametros fechaini, fechafin, que se recogen de
     * los dos calendarios.
     */
    private void partesTFF(String fechaIni, String fechaFin) {
        tPartesModel.setRowCount(0);
        tPartesModel = (DefaultTableModel) tPartes.getModel();
        partes = Parte.partesTFF(fechaIni, fechaFin);

        partes.forEach((p) -> {

            tPartesModel.insertRow(tPartesModel.getRowCount(), new Object[]{p.getIdTrabajador(), p.getFecha(),
                p.getValidado(), p.getEstado(), p.getKmInicial(), p.getIncidencias(), p.getKmFinal(),
                p.getGastoPeaje(), p.getGastoDietas(), p.getGastoCombustible(), p.getGastoVarios(),
                p.getHorasExtras(), p.getNotasAdministrativas()
            });
        });
    }

    /**
     * Listado de todos los partes abiertos hasta ese momento.
     */
    private void partesTFA() {
        tPartesModel.setRowCount(0);
        tPartesModel = (DefaultTableModel) tPartes.getModel();
        partes = Parte.partesTFA();

        partes.forEach((p) -> {

            tPartesModel.insertRow(tPartesModel.getRowCount(), new Object[]{p.getIdTrabajador(), p.getFecha(),
                p.getValidado(), p.getEstado(), p.getKmInicial(), p.getIncidencias(), p.getKmFinal(),
                p.getGastoPeaje(), p.getGastoDietas(), p.getGastoCombustible(), p.getGastoVarios(),
                p.getHorasExtras(), p.getNotasAdministrativas()
            });
        });
    }

    /**
     * Listado de todos los partes cerrados hasta ese momento.
     */
    private void partesTFC() {
        tPartesModel.setRowCount(0);
        tPartesModel = (DefaultTableModel) tPartes.getModel();
        partes = Parte.partesTFC();

        partes.forEach((p) -> {

            tPartesModel.insertRow(tPartesModel.getRowCount(), new Object[]{p.getIdTrabajador(), p.getFecha(),
                p.getValidado(), p.getEstado(), p.getKmInicial(), p.getIncidencias(), p.getKmFinal(),
                p.getGastoPeaje(), p.getGastoDietas(), p.getGastoCombustible(), p.getGastoVarios(),
                p.getHorasExtras(), p.getNotasAdministrativas()
            });
        });
    }

    /**
     * Listado de los viajes pertenecentes a un parte seleccionado en la tabla.
     */
    private void listarViajes() {

        tViajes = (DefaultTableModel) viajes.getModel();
        viaje = Viaje.logisticaViajes(idt, fecha);
        viaje.forEach((v) -> {
            tViajes.insertRow(viajes.getRowCount(), new Object[]{v.getAlabaran(), v.getHoraInicio(), v.getHoraFin()
            });
        });
    }

    /**
     * se ocupa de refrescar los datos de la tabla viajes caso seleecionen otra
     * tupla de la tabla.
     */
    private void listarViajes2() {
        tViajes.setRowCount(0);
        tViajes = (DefaultTableModel) viajes.getModel();
        viaje = Viaje.logisticaViajes(idt, fecha);
        for (Viaje v : viaje) {
            tViajes.insertRow(viajes.getRowCount(), new Object[]{v.getAlabaran(), v.getHoraInicio(), v.getHoraFin()
            });
        }
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
        volver = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        uTrabajador = new javax.swing.JTextField();
        uMatricula = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        viajes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gestión de Partes");

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
<<<<<<< Updated upstream
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
=======
<<<<<<< HEAD
>>>>>>> Stashed changes

        jButton2.setText("Lista Partes Cerrados");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

<<<<<<< Updated upstream
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

        jLabel12.setText("DATOS DEL PARTE:");

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
=======
        jLabel4.setText("Fecha:");

        uFecha1.addActionListener(new java.awt.event.ActionListener() {
=======
        jButton1.addActionListener(new java.awt.event.ActionListener() {
>>>>>>> master
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
>>>>>>> Stashed changes
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                validarActionPerformed(evt);
            }
        });

<<<<<<< Updated upstream
        avisar.setText("AVISAR");
        avisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                avisarActionPerformed(evt);
            }
        });

        volver.setText("VOLVER");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });

        jLabel3.setText("TRABAJADOR:");

=======
        jLabel8.setText("Id Trabajador: ");

        uIdTrab.setPreferredSize(new java.awt.Dimension(6, 30));

        jLabel9.setText("Fecha 1 : *");

        jLabel10.setText("Fecha 2: * ");

        jLabel11.setForeground(new java.awt.Color(255, 51, 51));
        jLabel11.setText("* Campos obligatorios");

        jLabel12.setText("DATOS DEL PARTE:");

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

        volver.setText("VOLVER");
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });

        jLabel3.setText("TRABAJADOR:");

>>>>>>> Stashed changes
        jLabel4.setText("MATRICULA VEHICULO:");

        uTrabajador.setEditable(false);

        uMatricula.setEditable(false);

        jLabel5.setText("jLabel5");
<<<<<<< Updated upstream

        viajes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

=======

        viajes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

>>>>>>> Stashed changes
            },
            new String [] {
                "Albaran", "Hora Inicio", "Hora fin"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(viajes);

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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(uTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(uMatricula, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addGroup(layout.createSequentialGroup()
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
                            .addComponent(jLabel12)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                                        .addComponent(jScrollPane3))
                                    .addComponent(jLabel19))
                                .addGap(76, 76, 76)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(validar)
                                        .addGap(18, 18, 18)
                                        .addComponent(avisar)
                                        .addGap(18, 18, 18)
                                        .addComponent(volver))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(165, 165, 165)
                                        .addComponent(jLabel11)))))
                        .addContainerGap(47, Short.MAX_VALUE))))
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(uTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(uMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel15))
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(uPeaje, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(uDietas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(23, 23, 23)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(13, 13, 13)
                                .addComponent(uOtros, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(13, 13, 13)
                                .addComponent(uCombustible, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel18)
                        .addGap(13, 13, 13)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(validar)
                            .addComponent(avisar)
                            .addComponent(volver))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
     *
     * Evento que se ocupa de desencadenar la busqueda de los partes, esta
     * compuesto de dos partes, la primera realiza la busqueda en un rango de
     * fechas y la segunda en rango de fechas mas la id del trabajador, el
     * simple dataFormat se usa para dar el formato correcto a la fecha
     * seleccionada en el calendario.
     */
    private void bBuscarPartesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bBuscarPartesActionPerformed

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        if (uIdTrab.getText().equalsIgnoreCase("")) {
            partesTFF(dateFormat.format(jDateChooser1.getDate()), dateFormat.format(jDateChooser2.getDate()));
        } else {

            partesTFI(new BigDecimal(uIdTrab.getText()), dateFormat.format(jDateChooser1.getDate()), dateFormat.format(jDateChooser2.getDate()));
        }
        limpiarFormulario();
    }//GEN-LAST:event_bBuscarPartesActionPerformed
    /**
     *
     * evento que se ocupa de volver a listar todos los partes.
     */
    private void listarPartesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarPartesActionPerformed

        listarPartes();
        limpiarFormulario();
    }//GEN-LAST:event_listarPartesActionPerformed

    /**
     *
     * evento que se ocupa de volver a listar todos los partes abiertos.
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        partesTFA();
        limpiarFormulario();
    }//GEN-LAST:event_jButton1ActionPerformed
    /**
     *
     * evento que se ocupa de volver a listar todos los partes cerrados.
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
<<<<<<< Updated upstream
=======

        partesTFC();
        limpiarFormulario();
    }//GEN-LAST:event_jButton2ActionPerformed
    /**
     *
     * Evento que se ocupa de la validacion del parte por parte de la
     * administracion, antes de ser validado se le pregunta al usuario si
     * realmente quiere hacer dicha validación y en caso de ser positiva se
     * envia el objeto creado al metodo gestionParte.
     */
    private void validarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validarActionPerformed
        // TODO add your handling code here:
        Parte p = new Parte(partes.get(index).getFecha(), partes.get(index).getIdTrabajador(), procesarCampo(uNotasAdministrativas));
        if (!partes.get(index).getValidado().equalsIgnoreCase("si")) {
            if (Administracion.gestionParte(p) == true) {
                JOptionPane.showMessageDialog(null, "Parte validado correctamente.", "Validado", JOptionPane.INFORMATION_MESSAGE);
                listarPartes();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Este parte ya ha sido validado.", "Validado", JOptionPane.INFORMATION_MESSAGE);
            listarPartes();
            limpiarFormulario();
        }

    }//GEN-LAST:event_validarActionPerformed
    /**
     *
     * Evento se ocupa de rellenar los campos del formulario con los datos de la
     * tupla seleccionada.
     */
    private void tPartesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tPartesMouseClicked

        index = tPartes.getSelectedRow();
        uPeaje.setText(partes.get(index).getGastoPeaje().toString());
        uDietas.setText(partes.get(index).getGastoDietas().toString());
        uCombustible.setText(partes.get(index).getGastoCombustible().toString());
        uOtros.setText(partes.get(index).getGastoVarios().toString());
        uIncidencias.setText(partes.get(index).getIncidencias());
        fecha = partes.get(index).getFecha();
        idt = partes.get(index).getIdTrabajador();
        uTrabajador.setText(Conducen.listar(idt, fecha).getNombret());
        uMatricula.setText(Conducen.listar(idt, fecha).getMatricula());

        listarViajes();

        if (viaje.size() > 0) {
            listarViajes2();
        }

    }//GEN-LAST:event_tPartesMouseClicked
    /**
     *
     * Evento que se ocupa de mostrar un cuadro de texto para que el
     * administrativo, pueda escribir un aviso al trabajador de logistica cuando
     * este no ha cerrado un parte.
     */
    private void avisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avisarActionPerformed
        String resultado = JOptionPane.showInputDialog(null, "Aviso", "Generar aviso", JOptionPane.YES_OPTION);
        if (resultado != null) {
            Aviso a = new Aviso(resultado, partes.get(index).getIdTrabajador(), partes.get(index).getFecha());
            if (Administracion.gestionarAviso(a) == true) {
                JOptionPane.showMessageDialog(null, "Aviso enviado correctamente.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
            limpiarFormulario();
        }
    }//GEN-LAST:event_avisarActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed

        administracion = new com.ventanas.Administracion();
        administracion.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_volverActionPerformed

    public void limpiarFormulario() {
        uPeaje.setText("");
        uDietas.setText("");
        uCombustible.setText("");
        uOtros.setText("");
        uIncidencias.setText("");
        uTrabajador.setText("");
        uMatricula.setText("");
    }

    public String procesarCampo(JTextArea t) {

        String cadena = "";

        if (t.getText().equalsIgnoreCase("")) {
            cadena = "No Procede";
        } else {
            cadena = t.getText();
        }
        return cadena;
    }
>>>>>>> Stashed changes

        partesTFC();
        limpiarFormulario();
    }//GEN-LAST:event_jButton2ActionPerformed
    /**
     *
     * Evento que se ocupa de la validacion del parte por parte de la
     * administracion, antes de ser validado se le pregunta al usuario si
     * realmente quiere hacer dicha validación y en caso de ser positiva se
     * envia el objeto creado al metodo gestionParte.
     */
    private void validarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_validarActionPerformed
        // TODO add your handling code here:
        Parte p = new Parte(partes.get(index).getFecha(), partes.get(index).getIdTrabajador(), procesarCampo(uNotasAdministrativas));
        if (!partes.get(index).getValidado().equalsIgnoreCase("si")) {
            if (Administracion.gestionParte(p) == true) {
                JOptionPane.showMessageDialog(null, "Parte validado correctamente.", "Validado", JOptionPane.INFORMATION_MESSAGE);
                listarPartes();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Este parte ya ha sido validado.", "Validado", JOptionPane.INFORMATION_MESSAGE);
            listarPartes();
            limpiarFormulario();
        }

    }//GEN-LAST:event_validarActionPerformed
    /**
     *
     * Evento se ocupa de rellenar los campos del formulario con los datos de la
     * tupla seleccionada.
     */
    private void tPartesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tPartesMouseClicked

        index = tPartes.getSelectedRow();
        uPeaje.setText(partes.get(index).getGastoPeaje().toString());
        uDietas.setText(partes.get(index).getGastoDietas().toString());
        uCombustible.setText(partes.get(index).getGastoCombustible().toString());
        uOtros.setText(partes.get(index).getGastoVarios().toString());
        uIncidencias.setText(partes.get(index).getIncidencias());
        fecha = partes.get(index).getFecha();
        idt = partes.get(index).getIdTrabajador();
        uTrabajador.setText(Conducen.listar(idt, fecha).getNombret());
        uMatricula.setText(Conducen.listar(idt, fecha).getMatricula());

        listarViajes();

        if (viaje.size() > 0) {
            listarViajes2();
        }

    }//GEN-LAST:event_tPartesMouseClicked
    /**
     *
     * Evento que se ocupa de mostrar un cuadro de texto para que el
     * administrativo, pueda escribir un aviso al trabajador de logistica cuando
     * este no ha cerrado un parte.
     */
    private void avisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_avisarActionPerformed
        String resultado = JOptionPane.showInputDialog(null, "Aviso", "Generar aviso", JOptionPane.YES_OPTION);
        if (resultado != null) {
            Aviso a = new Aviso(resultado, partes.get(index).getIdTrabajador(), partes.get(index).getFecha());
            if (Administracion.gestionarAviso(a) == true) {
                JOptionPane.showMessageDialog(null, "Aviso enviado correctamente.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
            limpiarFormulario();
        }
    }//GEN-LAST:event_avisarActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed

        administracion = new com.ventanas.Administracion();
        administracion.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_volverActionPerformed

    public void limpiarFormulario() {
        uPeaje.setText("");
        uDietas.setText("");
        uCombustible.setText("");
        uOtros.setText("");
        uIncidencias.setText("");
        uTrabajador.setText("");
        uMatricula.setText("");
    }

    public String procesarCampo(JTextArea t) {

        String cadena = "";

        if (t.getText().equalsIgnoreCase("")) {
            cadena = "No Procede";
        } else {
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton listarPartes;
    private javax.swing.JTable tPartes;
    private javax.swing.JTextField uCombustible;
    private javax.swing.JTextField uDietas;
    private javax.swing.JTextField uIdTrab;
    private javax.swing.JTextArea uIncidencias;
    private javax.swing.JTextField uMatricula;
    private javax.swing.JTextArea uNotasAdministrativas;
    private javax.swing.JTextField uOtros;
    private javax.swing.JTextField uPeaje;
    private javax.swing.JTextField uTrabajador;
    private javax.swing.JButton validar;
    private javax.swing.JTable viajes;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
