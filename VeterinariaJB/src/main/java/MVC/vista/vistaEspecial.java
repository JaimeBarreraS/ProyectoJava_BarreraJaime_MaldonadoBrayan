/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MVC.vista;

import MVC.controlador.AddAdoptionController;
import MVC.controlador.AdoptionController;

/**
 *
 * @author braya
 */
public class vistaEspecial extends javax.swing.JFrame {

    /**
     * Creates new form vistaAddAdoption
     */
    public vistaEspecial() {
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

        jLabel1 = new javax.swing.JLabel();
        btnPet = new javax.swing.JButton();
        Volver = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnAdoption = new javax.swing.JButton();
        Return = new javax.swing.JButton();
        btnAdoption1 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(2, 100, 100));
        jLabel1.setText("ADMINISTRADOR");

        btnPet.setBackground(new java.awt.Color(2, 100, 100));
        btnPet.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPet.setForeground(new java.awt.Color(255, 255, 255));
        btnPet.setText("Gestion Mascotas");
        btnPet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPetActionPerformed(evt);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(2, 100, 100));
        jLabel2.setText("ACTIVIDADES ESPECIALES");

        btnAdoption.setBackground(new java.awt.Color(2, 100, 100));
        btnAdoption.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdoption.setForeground(new java.awt.Color(255, 255, 255));
        btnAdoption.setText("Registrar Para Adopción");
        btnAdoption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdoptionActionPerformed(evt);
            }
        });

        Return.setBackground(new java.awt.Color(255, 153, 102));
        Return.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Return.setForeground(new java.awt.Color(255, 255, 255));
        Return.setText("Volver");
        Return.setBorderPainted(false);
        Return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReturnActionPerformed(evt);
            }
        });

        btnAdoption1.setBackground(new java.awt.Color(2, 100, 100));
        btnAdoption1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAdoption1.setForeground(new java.awt.Color(255, 255, 255));
        btnAdoption1.setText("Dar En Adopción");
        btnAdoption1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdoption1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Return)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel2)
                        .addContainerGap(59, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAdoption1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdoption))
                        .addGap(123, 123, 123))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Return)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addComponent(btnAdoption, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAdoption1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPetActionPerformed
        
    }//GEN-LAST:event_btnPetActionPerformed

    private void btnAdoptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdoptionActionPerformed
        vistaAddAdoption vAd = new vistaAddAdoption(); 
        AddAdoptionController controller = new AddAdoptionController(vAd);
        vAd.setController(controller);
        vAd.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnAdoptionActionPerformed

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        vistaLogin vl = new vistaLogin ();
        vl.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_VolverActionPerformed

    private void ReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReturnActionPerformed
        vistaAdmin vAdmin = new vistaAdmin();
        vAdmin.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_ReturnActionPerformed

    private void btnAdoption1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdoption1ActionPerformed
        vistaAdoption vA = new vistaAdoption(); 
        AdoptionController controller = new AdoptionController(vA);
        vA.setController(controller);
        vA.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnAdoption1ActionPerformed

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
            java.util.logging.Logger.getLogger(vistaEspecial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaEspecial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaEspecial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaEspecial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistaEspecial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton Return;
    public javax.swing.JButton Volver;
    private javax.swing.JButton btnAdoption;
    private javax.swing.JButton btnAdoption1;
    private javax.swing.JButton btnPet;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
