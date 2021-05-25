/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mibapplikation;

import java.util.ArrayList;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author Blazl
 */
public class WindowAgentStart extends javax.swing.JFrame {

    private  InfDB idb;
    private  String agentId;
    private  String username;
    
    

    /**
     * Creates new form MainWindow
     */
    public WindowAgentStart(InfDB idb, String agentId, String username) {
        initComponents();
        this.idb = idb;
        this.agentId = agentId;
        this.username = username;
        lblWelcome.setText("Välkommen " + username + "!");
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        btnEquipment = new javax.swing.JButton();
        btnAreaChief = new javax.swing.JButton();
        btnRegAlien = new javax.swing.JButton();
        btn4 = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();
        btnChangePw = new javax.swing.JButton();
        btnAlienLists = new javax.swing.JButton();
        lblWelcome = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Galaxal");
        setLocationByPlatform(true);
        setResizable(false);

        background.setBackground(new java.awt.Color(40, 40, 40));

        btnEquipment.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnEquipment.setText("Utrustning");
        btnEquipment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEquipmentActionPerformed(evt);
            }
        });

        btnAreaChief.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnAreaChief.setText("Sök områdeschef");
        btnAreaChief.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAreaChiefActionPerformed(evt);
            }
        });

        btnRegAlien.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnRegAlien.setText("Registrera alien");
        btnRegAlien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegAlienActionPerformed(evt);
            }
        });

        btn4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btn4.setText("Hantera alien");
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });

        btnLogout.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnLogout.setText("Logga ut");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        btnChangePw.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnChangePw.setText("Byt lösenord");
        btnChangePw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePwActionPerformed(evt);
            }
        });

        btnAlienLists.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        btnAlienLists.setText("Listor för aliens");
        btnAlienLists.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlienListsActionPerformed(evt);
            }
        });

        lblWelcome.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        lblWelcome.setForeground(new java.awt.Color(255, 255, 255));
        lblWelcome.setText("Välkommen");

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnRegAlien, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAreaChief, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEquipment, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnAlienLists, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChangePw, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(btnRegAlien)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn4))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(btnEquipment)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAreaChief)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAlienLists)
                .addGap(62, 62, 62)
                .addComponent(btnChangePw)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnLogout)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        agentId = "";
        setVisible(false);
        new MainWindowLogin(idb).setVisible(true);
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnChangePwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePwActionPerformed
        // TODO add your handling code here:
        new WindowAgentChangePw(idb, agentId).setVisible(true);
    }//GEN-LAST:event_btnChangePwActionPerformed

    private void btnEquipmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquipmentActionPerformed
        // TODO add your handling code here:
        new WindowAgentEquipment(idb, agentId).setVisible(true);
    }//GEN-LAST:event_btnEquipmentActionPerformed

    private void btnAreaChiefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAreaChiefActionPerformed
        // TODO add your handling code here:
        new WindowAgentAreaChief(idb).setVisible(true);
    }//GEN-LAST:event_btnAreaChiefActionPerformed

    private void btnRegAlienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegAlienActionPerformed
        // TODO add your handling code here:
        new WindowAgentRegAlien(idb).setVisible(true);
    }//GEN-LAST:event_btnRegAlienActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
       new WindowAgentUpdateAlienInfo(idb).setVisible(true); 
    }//GEN-LAST:event_btn4ActionPerformed

    private void btnAlienListsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlienListsActionPerformed
        // TODO add your handling code here:
        new WindowAgentListAliens(idb).setVisible(true);
    }//GEN-LAST:event_btnAlienListsActionPerformed


    /**
     * @param args the command line arguments
     */
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btnAlienLists;
    private javax.swing.JButton btnAreaChief;
    private javax.swing.JButton btnChangePw;
    private javax.swing.JButton btnEquipment;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnRegAlien;
    private javax.swing.JLabel lblWelcome;
    // End of variables declaration//GEN-END:variables
}
