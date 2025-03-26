/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package MVC.vista;

import MVC.controlador.VacunneVeterinaryController;
import MVC.controlador.VeterinaryConsultController;
import MVC.controlador.VeterinaryController;
import MVC.controlador.VeterinaryMedicalHistoryController;
import MVC.controlador.VeterinaryProceduresController;

/**
 *
 * @author braya
 */
public class vistaVeterinaryMascotas extends javax.swing.JFrame {

    /** Creates new form vistaVeterinary */
    public vistaVeterinaryMascotas() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnMascotas = new javax.swing.JButton();
        btnConsultMedical = new javax.swing.JButton();
        btnVacunne = new javax.swing.JButton();
        btnMedicalHistory = new javax.swing.JButton();
        btnProcedures = new javax.swing.JButton();
        Volver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(2, 100, 100));
        jLabel1.setText("VETERINARIO");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/logo.png"))); // NOI18N

        btnMascotas.setBackground(new java.awt.Color(2, 100, 100));
        btnMascotas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMascotas.setForeground(new java.awt.Color(255, 255, 255));
        btnMascotas.setText("Mascotas");
        btnMascotas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMascotasActionPerformed(evt);
            }
        });

        btnConsultMedical.setBackground(new java.awt.Color(2, 100, 100));
        btnConsultMedical.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnConsultMedical.setForeground(new java.awt.Color(255, 255, 255));
        btnConsultMedical.setText("Consultas Medicas");
        btnConsultMedical.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultMedicalActionPerformed(evt);
            }
        });

        btnVacunne.setBackground(new java.awt.Color(2, 100, 100));
        btnVacunne.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVacunne.setForeground(new java.awt.Color(255, 255, 255));
        btnVacunne.setText("Vacunas");
        btnVacunne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVacunneActionPerformed(evt);
            }
        });

        btnMedicalHistory.setBackground(new java.awt.Color(2, 100, 100));
        btnMedicalHistory.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnMedicalHistory.setForeground(new java.awt.Color(255, 255, 255));
        btnMedicalHistory.setText("Historial Medico");
        btnMedicalHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMedicalHistoryActionPerformed(evt);
            }
        });

        btnProcedures.setBackground(new java.awt.Color(2, 100, 100));
        btnProcedures.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnProcedures.setForeground(new java.awt.Color(255, 255, 255));
        btnProcedures.setText("Procedimientos");
        btnProcedures.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProceduresActionPerformed(evt);
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
                .addContainerGap(146, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConsultMedical, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMascotas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVacunne, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMedicalHistory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProcedures, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(143, 143, 143))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(Volver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(162, 162, 162))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMascotas, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnConsultMedical)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVacunne)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMedicalHistory)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnProcedures)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMascotasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMascotasActionPerformed
        vistaMascotas vgm = new vistaMascotas();
        VeterinaryController controller = new VeterinaryController(vgm);
        vgm.setController(controller);
        vgm.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnMascotasActionPerformed

    private void btnConsultMedicalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultMedicalActionPerformed
        vistaVeterinaryConsult vvc = new vistaVeterinaryConsult();
        VeterinaryConsultController controller = new VeterinaryConsultController(vvc );
        vvc .setController(controller);
        vvc .setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnConsultMedicalActionPerformed

    private void btnVacunneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVacunneActionPerformed
        vistaVacunneVeterinary vvv = new vistaVacunneVeterinary();
        VacunneVeterinaryController controller = new VacunneVeterinaryController(vvv );
        vvv .setController(controller);
        vvv .setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnVacunneActionPerformed

    private void btnMedicalHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMedicalHistoryActionPerformed
        vistaVeterinaryMedicalHistory vvhv = new vistaVeterinaryMedicalHistory ();
        VeterinaryMedicalHistoryController controller = new VeterinaryMedicalHistoryController(vvhv );
        vvhv .setController(controller);
        vvhv .setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnMedicalHistoryActionPerformed

    private void btnProceduresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProceduresActionPerformed
        vistaVeterinaryPrecedimientos vvp = new vistaVeterinaryPrecedimientos ();
        VeterinaryProceduresController controller = new VeterinaryProceduresController(vvp );
        vvp .setController(controller);
        vvp .setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnProceduresActionPerformed

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        vistaLogin vl = new vistaLogin ();
        vl.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_VolverActionPerformed

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
            java.util.logging.Logger.getLogger(vistaVeterinaryMascotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaVeterinaryMascotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaVeterinaryMascotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaVeterinaryMascotas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistaVeterinaryMascotas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Volver;
    private javax.swing.JButton btnConsultMedical;
    private javax.swing.JButton btnMascotas;
    private javax.swing.JButton btnMedicalHistory;
    private javax.swing.JButton btnProcedures;
    private javax.swing.JButton btnVacunne;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

}
