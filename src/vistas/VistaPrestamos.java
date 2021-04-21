/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Paulina
 */
public class VistaPrestamos extends javax.swing.JInternalFrame {
    
    public VistaPrestamos() {
        initComponents();
    }

    public JButton getBtnactualizar() {
        return btnactualizar;
    }

    public void setBtnactualizar(JButton btnactualizar) {
        this.btnactualizar = btnactualizar;
    }

    public JButton getBtnguardarpt() {
        return btnguardarpt;
    }

    public void setBtnguardarpt(JButton btnguardarpt) {
        this.btnguardarpt = btnguardarpt;
    }
    
    
    

    public JButton getBtnbuscarp() {
        return btnbuscarp;
    }

    public void setBtnbuscarp(JButton btnbuscarp) {
        this.btnbuscarp = btnbuscarp;
    }

    public JButton getBtneditarp() {
        return btneditarp;
    }

    public void setBtneditarp(JButton btneditarp) {
        this.btneditarp = btneditarp;
    }

    public JButton getBtneliminarp() {
        return btneliminarp;
    }

    public void setBtneliminarp(JButton btneliminarp) {
        this.btneliminarp = btneliminarp;
    }

    public JButton getBtnguardarp() {
        return btnguardarpt;
    }

    public void setBtnguardarp(JButton btnguardarp) {
        this.btnguardarpt = btnguardarp;
    }

    public JDateChooser getJdcFechaD() {
        return jdcFechaD;
    }

    public void setJdcFechaD(JDateChooser jdcFechaD) {
        this.jdcFechaD = jdcFechaD;
    }

    public JDateChooser getJdcFechap() {
        return jdcFechap;
    }

    public void setJdcFechap(JDateChooser jdcFechap) {
        this.jdcFechap = jdcFechap;
    }

    public JPanel getPaneldatos() {
        return paneldatos;
    }

    public void setPaneldatos(JPanel paneldatos) {
        this.paneldatos = paneldatos;
    }

    public JPanel getPanelingreso() {
        return panelingreso;
    }

    public void setPanelingreso(JPanel panelingreso) {
        this.panelingreso = panelingreso;
    }

    public JTable getTablaprestamos() {
        return tablaprestamos;
    }

    public void setTablaprestamos(JTable tablaprestamos) {
        this.tablaprestamos = tablaprestamos;
    }

    public JTextField getTxtBuscarP() {
        return txtBuscarP;
    }

    public void setTxtBuscarP(JTextField txtBuscarP) {
        this.txtBuscarP = txtBuscarP;
    }

    public JTextField getTxtID_usuario() {
        return txtID_usuario;
    }

    public void setTxtID_usuario(JTextField txtID_usuario) {
        this.txtID_usuario = txtID_usuario;
    }

    public JTextField getTxtcodigoP() {
        return txtcodigoejemplar;
    }

    public void setTxtcodigoP(JTextField txtcodigoP) {
        this.txtcodigoejemplar = txtcodigoP;
    }

    public JTextField getTxtcodigoejemplar() {
        return txtcodigop;
    }

    public void setTxtcodigoejemplar(JTextField txtcodigoejemplar) {
        this.txtcodigop = txtcodigoejemplar;
    }

  
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jYearChooser1 = new com.toedter.calendar.JYearChooser();
        paneldatos = new javax.swing.JPanel();
        txtBuscarP = new javax.swing.JTextField();
        btnbuscarp = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaprestamos = new javax.swing.JTable();
        btnactualizar = new javax.swing.JButton();
        panelingreso = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtcodigoejemplar = new javax.swing.JTextField();
        txtID_usuario = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtcodigop = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jdcFechap = new com.toedter.calendar.JDateChooser();
        jdcFechaD = new com.toedter.calendar.JDateChooser();
        jToolBar1 = new javax.swing.JToolBar();
        btnguardarpt = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btneditarp = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btneliminarp = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        paneldatos.setBackground(new java.awt.Color(255, 251, 244));
        paneldatos.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos"));

        btnbuscarp.setText("Subir informacion");

        tablaprestamos.setBackground(new java.awt.Color(240, 170, 4));
        tablaprestamos.setForeground(new java.awt.Color(0, 51, 153));
        tablaprestamos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código Registro", "Fecha Préstamo", "Fecha Devolución", "Código Ejemplar", "ID_Usuario"
            }
        ));
        tablaprestamos.setAutoscrolls(false);
        tablaprestamos.setGridColor(new java.awt.Color(204, 204, 204));
        jScrollPane1.setViewportView(tablaprestamos);

        btnactualizar.setText("Actualizar");

        javax.swing.GroupLayout paneldatosLayout = new javax.swing.GroupLayout(paneldatos);
        paneldatos.setLayout(paneldatosLayout);
        paneldatosLayout.setHorizontalGroup(
            paneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneldatosLayout.createSequentialGroup()
                .addGroup(paneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(paneldatosLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 781, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(paneldatosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtBuscarP, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(138, 138, 138)
                        .addComponent(btnbuscarp)
                        .addGap(52, 52, 52)
                        .addComponent(btnactualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        paneldatosLayout.setVerticalGroup(
            paneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneldatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(paneldatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbuscarp)
                    .addComponent(btnactualizar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );

        getContentPane().add(paneldatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 850, -1));

        panelingreso.setBackground(new java.awt.Color(255, 251, 244));
        panelingreso.setBorder(javax.swing.BorderFactory.createTitledBorder("Ingreso de datos"));
        panelingreso.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setText("Código Registro");
        panelingreso.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 56, 121, -1));

        jLabel16.setText("Fecha Préstamo");
        panelingreso.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 93, 114, -1));
        panelingreso.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 216, 121, -1));

        jLabel18.setText("ID_Usuario");
        panelingreso.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(351, 56, 77, -1));
        panelingreso.add(txtcodigoejemplar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 90, -1));
        panelingreso.add(txtID_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(446, 53, 127, -1));

        jLabel21.setText("Fecha Devolución");
        panelingreso.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 107, -1));
        panelingreso.add(txtcodigop, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 90, -1));

        jLabel22.setText("Código Ejemplar");
        panelingreso.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 182, -1, -1));
        panelingreso.add(jdcFechap, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 90, -1, -1));
        panelingreso.add(jdcFechaD, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, -1, -1));

        jToolBar1.setBackground(new java.awt.Color(239, 170, 4));
        jToolBar1.setRollover(true);

        btnguardarpt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/guardar.png"))); // NOI18N
        btnguardarpt.setToolTipText("GUARDAR");
        btnguardarpt.setBorderPainted(false);
        btnguardarpt.setContentAreaFilled(false);
        jToolBar1.add(btnguardarpt);

        jLabel2.setText("Guardar");
        jToolBar1.add(jLabel2);

        btneditarp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/Listalibro.png"))); // NOI18N
        btneditarp.setFocusable(false);
        btneditarp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btneditarp.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btneditarp);

        jLabel3.setText("Editar");
        jToolBar1.add(jLabel3);

        btneliminarp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/bote-de-basura-abierto.png"))); // NOI18N
        btneliminarp.setFocusable(false);
        btneliminarp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btneliminarp.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(btneliminarp);

        jLabel4.setText("Eliminar");
        jToolBar1.add(jLabel4);

        panelingreso.add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 100, 380, 81));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vistas/imagenes/logoliceo.png"))); // NOI18N
        panelingreso.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, 80, 80));

        getContentPane().add(panelingreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 846, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnactualizar;
    private javax.swing.JButton btnbuscarp;
    private javax.swing.JButton btneditarp;
    private javax.swing.JButton btneliminarp;
    private javax.swing.JButton btnguardarpt;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private com.toedter.calendar.JDateChooser jdcFechaD;
    private com.toedter.calendar.JDateChooser jdcFechap;
    private javax.swing.JPanel paneldatos;
    private javax.swing.JPanel panelingreso;
    private javax.swing.JTable tablaprestamos;
    private javax.swing.JTextField txtBuscarP;
    private javax.swing.JTextField txtID_usuario;
    private javax.swing.JTextField txtcodigoejemplar;
    private javax.swing.JTextField txtcodigop;
    // End of variables declaration//GEN-END:variables
}
