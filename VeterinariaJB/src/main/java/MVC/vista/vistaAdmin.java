/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MVC.vista;

import MVC.controlador.*;

/**
 *
 * @author braya
 */
public class vistaAdmin extends javax.swing.JFrame {

    /**
     * Creates new form vistaAdmin
     */
    public vistaAdmin() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnOwner = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnConsultMedical = new javax.swing.JButton();
        btnPet = new javax.swing.JButton();
        btnHistoryMedical = new javax.swing.JButton();
        btnVaccine = new javax.swing.JButton();
        btnInventory = new javax.swing.JButton();
        btnInvoice = new javax.swing.JButton();
        Volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(2, 100, 100));
        jLabel1.setText("ADMINISTRADOR");

        btnOwner.setBackground(new java.awt.Color(2, 100, 100));
        btnOwner.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnOwner.setForeground(new java.awt.Color(255, 255, 255));
        btnOwner.setText("Gestion Personas");
        btnOwner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOwnerActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/logo.png"))); // NOI18N

        btnConsultMedical.setBackground(new java.awt.Color(2, 100, 100));
        btnConsultMedical.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnConsultMedical.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultMedical.setText("Gestion Consulta Medica");

        btnPet.setBackground(new java.awt.Color(2, 100, 100));
        btnPet.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPet.setForeground(new java.awt.Color(255, 255, 255));
        btnPet.setText("Gestion Mascotas");
        btnPet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPetActionPerformed(evt);
            }
        });

        btnHistoryMedical.setBackground(new java.awt.Color(2, 100, 100));
        btnHistoryMedical.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnHistoryMedical.setForeground(new java.awt.Color(255, 255, 255));
        btnHistoryMedical.setText("Gestion Historial Medico");
        btnHistoryMedical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistoryMedicalActionPerformed(evt);
            }
        });

        btnVaccine.setBackground(new java.awt.Color(2, 100, 100));
        btnVaccine.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVaccine.setForeground(new java.awt.Color(255, 255, 255));
        btnVaccine.setText("Gestion Vacunas");
        btnVaccine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVaccineActionPerformed(evt);
            }
        });

        btnInventory.setBackground(new java.awt.Color(2, 100, 100));
        btnInventory.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnInventory.setForeground(new java.awt.Color(255, 255, 255));
        btnInventory.setText("Gestion Inventario");
        btnInventory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventoryActionPerformed(evt);
            }
        });

        btnInvoice.setBackground(new java.awt.Color(2, 100, 100));
        btnInvoice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnInvoice.setForeground(new java.awt.Color(255, 255, 255));
        btnInvoice.setText("Gestion Facturas");
        btnInvoice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInvoiceActionPerformed(evt);
            }
        });

        Volver.setBackground(new java.awt.Color(255, 153, 102));
        Volver.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Volver.setForeground(new java.awt.Color(255, 255, 255));
        Volver.setText("Volver");
        Volver.setBorderPainted(false);
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVaccine, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHistoryMedical, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConsultMedical, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOwner, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPet, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(129, 129, 129))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(Volver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(157, 157, 157))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(Volver)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPet, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOwner, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultMedical, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHistoryMedical, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVaccine, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInventory, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnInvoice, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPetActionPerformed
        vistaGestionMascotas vgm = new vistaGestionMascotas();
        PetController controller = new PetController(vgm);
        vgm.setController(controller);
        vgm.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnPetActionPerformed

    private void btnOwnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOwnerActionPerformed
        vistaGestionOwners vgo = new vistaGestionOwners();
        CustomerController  Ccontroller = new CustomerController(vgo);
        vgo.setController(Ccontroller);
        vgo.setVisible(true);
        this.setVisible(false);
        this.dispose();  
    }//GEN-LAST:event_btnOwnerActionPerformed

    private void btnVaccineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVaccineActionPerformed
        vistaVacunneAdmin vva = new vistaVacunneAdmin ();
        VacunneAdminController pcontroller = new VacunneAdminController(vva);
        vva.setController(pcontroller);
        vva.setVisible(true);
        this.setVisible(false);
        this.dispose(); 
    }//GEN-LAST:event_btnVaccineActionPerformed

    private void btnInventoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventoryActionPerformed
        vistaGestionInventory vgi = new vistaGestionInventory();
        InventoryController Icontroller = new InventoryController(vgi);
        vgi.setController(Icontroller);
        vgi.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnInventoryActionPerformed

    private void btnInvoiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInvoiceActionPerformed
        vistaGestionFacturas vgf = new vistaGestionFacturas();
        InvoicesController controller = new InvoicesController(vgf);
        vgf.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnInvoiceActionPerformed

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        vistaLogin vl = new vistaLogin ();
        vl.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_VolverActionPerformed

    private void btnHistoryMedicalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistoryMedicalActionPerformed
        vistaAdminMedicalHistory vgm = new vistaAdminMedicalHistory();
        MedicalHistoryAdminController mcontroller = new MedicalHistoryAdminController(vgm);
        vgm.setController(mcontroller);
        vgm.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnHistoryMedicalActionPerformed
    
    public void setController(LoginController controller) {
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
            java.util.logging.Logger.getLogger(vistaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistaAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Volver;
    private javax.swing.JButton btnConsultMedical;
    private javax.swing.JButton btnHistoryMedical;
    private javax.swing.JButton btnInventory;
    private javax.swing.JButton btnInvoice;
    private javax.swing.JButton btnOwner;
    private javax.swing.JButton btnPet;
    private javax.swing.JButton btnVaccine;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
