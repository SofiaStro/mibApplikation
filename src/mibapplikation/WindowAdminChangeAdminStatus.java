/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mibapplikation;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.lang3.StringUtils;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author strom
 */
public class WindowAdminChangeAdminStatus extends javax.swing.JFrame {

    private InfDB idb;

    /**
     * Creates new form WindowAlienChangePw
     */
    public WindowAdminChangeAdminStatus(InfDB idb) {
        initComponents();
        this.idb = idb;
        listAllAgents();
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
        lblTitle = new javax.swing.JLabel();
        lblMessage = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();
        cbAgentList = new javax.swing.JComboBox<>();
        cbStatusList = new javax.swing.JComboBox<>();
        lblAgent = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Galaxal");
        setLocationByPlatform(true);
        setResizable(false);

        background.setBackground(new java.awt.Color(40, 40, 40));
        background.setForeground(new java.awt.Color(255, 255, 255));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Ändra adminstatus på agent");

        lblMessage.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lblMessage.setForeground(new java.awt.Color(255, 96, 96));
        lblMessage.setText(" ");

        btnSave.setText("SPARA");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnMenu.setText("MENY");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        cbAgentList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----" }));

        cbStatusList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----", "JA", "NEJ" }));

        lblAgent.setForeground(new java.awt.Color(255, 255, 255));
        lblAgent.setText("Välj agent");

        lblStatus.setForeground(new java.awt.Color(255, 255, 255));
        lblStatus.setText("Välj adminstatus");

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(backgroundLayout.createSequentialGroup()
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblAgent, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbAgentList, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSave))
                                .addGap(28, 28, 28)
                                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbStatusList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnMenu)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAgent)
                    .addComponent(lblStatus))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbAgentList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbStatusList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnSave)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                .addComponent(btnMenu)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listAllAgents() {

        try {
            String query = 
                    "SELECT agent_id, namn, benamning FROM agent a\n"
                    + "JOIN omrade o ON a.omrade = o.omrades_id\n"
                    + "ORDER BY benamning, namn";
            ArrayList<HashMap<String, String>> agentList = idb.fetchRows(query);

            for (HashMap<String, String> element : agentList) {
                cbAgentList.addItem(element.get("namn") + " (" + element.get("agent_id") + ") " + element.get("benamning"));
            }
        } catch (InfException ex) {
            System.out.println("Databasfel" + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Random fel" + ex.getMessage());
        }
    }

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        String status = "";
        lblMessage.setText("");
        lblMessage.setForeground(Color.RED);

        if (!cbAgentList.getSelectedItem().equals("-----") && !cbStatusList.getSelectedItem().equals("-----")) {

            lblMessage.setForeground(Color.GREEN);
            lblMessage.setText("Du har nu bytt status!");

            if (cbStatusList.getSelectedItem().equals("JA")) {
                status = "J";
            } else if (cbStatusList.getSelectedItem().equals("NEJ")) {
                status = "N";
            }

            Object getAgentListItem = cbAgentList.getSelectedItem();
            String agentListItem = getAgentListItem.toString();
            String agentId = StringUtils.substringBetween(agentListItem, "(", ")");

            try {
                String query = "UPDATE agent SET administrator = '" + status + "' WHERE agent_id = '" + agentId + "'";
                idb.update(query);
            } catch (InfException ex) {
                System.out.println("Databasfel" + ex.getMessage());
            } catch (Exception ex) {
                System.out.println("Random fel" + ex.getMessage());
            }
        } else if (cbAgentList.getSelectedItem().equals("-----") && !cbStatusList.getSelectedItem().equals("-----")) {
            lblMessage.setText("Du måste välja en agent!");
        } else if (!cbAgentList.getSelectedItem().equals("-----") && cbStatusList.getSelectedItem().equals("-----")) {
            lblMessage.setText("Du måste välja en status!");
        } else {
            lblMessage.setText("Du måste välja en agent och en status!");
        }    
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        //dispose();
    }//GEN-LAST:event_btnMenuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel background;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbAgentList;
    private javax.swing.JComboBox<String> cbStatusList;
    private javax.swing.JLabel lblAgent;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}