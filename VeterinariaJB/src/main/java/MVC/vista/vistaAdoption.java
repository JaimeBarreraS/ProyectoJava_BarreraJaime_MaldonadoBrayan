package MVC.vista;

import MVC.controlador.AdoptionController;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class vistaAdoption extends javax.swing.JFrame {

    public vistaAdoption() {
        initComponents();
        this.setLocationRelativeTo(null);        
    }

    public JComboBox<String> getBtnOwner() {
        return btnOwner;
    }

    public JComboBox<String> getBtnPet() {
        return btnPet;
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }

    public JTable getjTable1() {
        return jTable1;
    }
    
    public void limpiarCampos(){
        btnPet.setSelectedIndex(0); 
        btnOwner.setSelectedIndex(0); 
    }
    
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    public void setController(AdoptionController controller) {
        btnList.addActionListener(e -> controller.loadTable());
        btnAdoption.addActionListener(e -> controller.RegisterAdoption());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        btnPet = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        btnAdoption = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        btnOwner = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnList = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(2, 100, 100));
        jLabel1.setText("Adoptar Mascotas");

        btnVolver.setBackground(new java.awt.Color(255, 153, 102));
        btnVolver.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.setBorderPainted(false);
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnPet.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPet.setForeground(new java.awt.Color(2, 100, 100));
        btnPet.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-------" }));
        btnPet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPetActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(2, 100, 100));
        jLabel11.setText("Mascota :");

        btnAdoption.setBackground(new java.awt.Color(2, 100, 100));
        btnAdoption.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAdoption.setForeground(new java.awt.Color(255, 255, 255));
        btnAdoption.setText("Adoptar");
        btnAdoption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdoptionActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(2, 100, 100));
        jLabel12.setText("Dueño :");

        btnOwner.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnOwner.setForeground(new java.awt.Color(2, 100, 100));
        btnOwner.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-------" }));
        btnOwner.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOwnerActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Especie", "Raza", "Sexo", "Edad"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnList.setBackground(new java.awt.Color(2, 100, 100));
        btnList.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnList.setForeground(new java.awt.Color(255, 255, 255));
        btnList.setText("Listar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(btnVolver)
                        .addGap(97, 97, 97)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnOwner, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnPet, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdoption)
                                .addGap(18, 18, 18)
                                .addComponent(btnList, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVolver)
                    .addComponent(jLabel1))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(btnPet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(btnOwner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdoption)
                    .addComponent(btnList))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        vistaEspecial vE = new vistaEspecial();
        vE.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnPetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPetActionPerformed

    private void btnOwnerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOwnerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnOwnerActionPerformed

    private void btnAdoptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdoptionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAdoptionActionPerformed

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
            java.util.logging.Logger.getLogger(vistaAdoption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(vistaAdoption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(vistaAdoption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(vistaAdoption.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistaAdoption().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAdoption;
    public javax.swing.JButton btnList;
    public javax.swing.JComboBox<String> btnOwner;
    public javax.swing.JComboBox<String> btnPet;
    public javax.swing.JButton btnVolver;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel11;
    public javax.swing.JLabel jLabel12;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
