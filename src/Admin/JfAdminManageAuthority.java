/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import mibapplikation.Validation;
import org.apache.commons.lang3.StringUtils;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author strom
 */
public class JfAdminManageAuthority extends javax.swing.JFrame {

    private String alienId;
    private InfDB idb;

    /**
     * Creates new form JfAdminManageAuthority
     */
    public JfAdminManageAuthority(InfDB idb) {
        initComponents();
        this.idb = idb;
        listAllAgentsAdmin();
        listAllAgentsHeadChief();
        listAllAgentsAreaChief();
        listAllAreas();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpBackground = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        btnMenu = new javax.swing.JButton();
        lblMessageAdmin = new javax.swing.JLabel();
        cbAdminStatusList = new javax.swing.JComboBox<>();
        lblAdminStatus = new javax.swing.JLabel();
        lblTitleAdminStatus = new javax.swing.JLabel();
        lblAdminAgent = new javax.swing.JLabel();
        cbAdminAgentList = new javax.swing.JComboBox<>();
        btnSaveAdmin = new javax.swing.JButton();
        lblMessageAreaChief = new javax.swing.JLabel();
        cbListAreas = new javax.swing.JComboBox<>();
        lblChooseArea2 = new javax.swing.JLabel();
        lblChooesArea1 = new javax.swing.JLabel();
        btnSaveAreaChief = new javax.swing.JButton();
        cbListAgentsArea = new javax.swing.JComboBox<>();
        lblNewChief2 = new javax.swing.JLabel();
        lblNewChief1 = new javax.swing.JLabel();
        lblTitleChangeAreaChief = new javax.swing.JLabel();
        lblMessageHeadChief = new javax.swing.JLabel();
        btnSaveHeadChief = new javax.swing.JButton();
        cbListAgentsHeadChief = new javax.swing.JComboBox<>();
        lblChooesHeadChief = new javax.swing.JLabel();
        lblTitleHeadChief = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Galaxal");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Icons/astronomy.png")).getImage());
        setLocationByPlatform(true);
        setResizable(false);

        jpBackground.setBackground(new java.awt.Color(40, 40, 40));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Hantera befogenhet");

        btnMenu.setText("MENY");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        lblMessageAdmin.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lblMessageAdmin.setForeground(new java.awt.Color(255, 50, 50));
        lblMessageAdmin.setText(" ");

        cbAdminStatusList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----", "JA", "NEJ" }));

        lblAdminStatus.setForeground(new java.awt.Color(255, 255, 255));
        lblAdminStatus.setText("Välj adminstatus");

        lblTitleAdminStatus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTitleAdminStatus.setForeground(new java.awt.Color(255, 255, 255));
        lblTitleAdminStatus.setText("Ändra adminstatus på agent");

        lblAdminAgent.setForeground(new java.awt.Color(255, 255, 255));
        lblAdminAgent.setText("Välj agent");

        cbAdminAgentList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----" }));

        btnSaveAdmin.setText("SPARA");
        btnSaveAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveAdminActionPerformed(evt);
            }
        });

        lblMessageAreaChief.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lblMessageAreaChief.setForeground(new java.awt.Color(255, 50, 50));
        lblMessageAreaChief.setText(" ");

        cbListAreas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----" }));

        lblChooseArea2.setForeground(new java.awt.Color(255, 255, 255));
        lblChooseArea2.setText(" valda agent ska vara chef över:");

        lblChooesArea1.setForeground(new java.awt.Color(255, 255, 255));
        lblChooesArea1.setText("Välj namnet på det område den");

        btnSaveAreaChief.setText("SPARA");
        btnSaveAreaChief.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveAreaChiefActionPerformed(evt);
            }
        });

        cbListAgentsArea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----" }));

        lblNewChief2.setForeground(new java.awt.Color(255, 255, 255));
        lblNewChief2.setText("som ska bli områdeschef:");

        lblNewChief1.setForeground(new java.awt.Color(255, 255, 255));
        lblNewChief1.setText("Välj namnet på den agent");

        lblTitleChangeAreaChief.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTitleChangeAreaChief.setForeground(new java.awt.Color(255, 255, 255));
        lblTitleChangeAreaChief.setText("Ändra områdeschef");

        lblMessageHeadChief.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lblMessageHeadChief.setForeground(new java.awt.Color(255, 50, 50));
        lblMessageHeadChief.setText(" ");

        btnSaveHeadChief.setText("SPARA");
        btnSaveHeadChief.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveHeadChiefActionPerformed(evt);
            }
        });

        cbListAgentsHeadChief.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----" }));

        lblChooesHeadChief.setForeground(new java.awt.Color(255, 255, 255));
        lblChooesHeadChief.setText("Välj namnet på den agent som ska bli kontorschef");

        lblTitleHeadChief.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTitleHeadChief.setForeground(new java.awt.Color(255, 255, 255));
        lblTitleHeadChief.setText("Ändra kontorschef");

        javax.swing.GroupLayout jpBackgroundLayout = new javax.swing.GroupLayout(jpBackground);
        jpBackground.setLayout(jpBackgroundLayout);
        jpBackgroundLayout.setHorizontalGroup(
            jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBackgroundLayout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addGroup(jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpBackgroundLayout.createSequentialGroup()
                        .addComponent(lblTitleChangeAreaChief, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jpBackgroundLayout.createSequentialGroup()
                        .addGroup(jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpBackgroundLayout.createSequentialGroup()
                                .addGroup(jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTitleAdminStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jpBackgroundLayout.createSequentialGroup()
                                        .addGroup(jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbAdminAgentList, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblAdminAgent, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(28, 28, 28)
                                        .addGroup(jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblAdminStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbAdminStatusList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jpBackgroundLayout.createSequentialGroup()
                                        .addGap(173, 173, 173)
                                        .addComponent(btnSaveAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE))
                            .addGroup(jpBackgroundLayout.createSequentialGroup()
                                .addComponent(lblMessageAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(111, 111, 111)))
                        .addGroup(jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitleHeadChief, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblChooesHeadChief)
                            .addComponent(lblMessageHeadChief, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(btnSaveHeadChief, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                                .addComponent(cbListAgentsHeadChief, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(69, 69, 69))
                    .addGroup(jpBackgroundLayout.createSequentialGroup()
                        .addGroup(jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMessageAreaChief, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jpBackgroundLayout.createSequentialGroup()
                                .addGroup(jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNewChief2)
                                    .addComponent(lblNewChief1)
                                    .addComponent(cbListAgentsArea, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblChooseArea2)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpBackgroundLayout.createSequentialGroup()
                                            .addGap(4, 4, 4)
                                            .addComponent(lblChooesArea1)))
                                    .addComponent(cbListAreas, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSaveAreaChief, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jpBackgroundLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(btnMenu)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jpBackgroundLayout.setVerticalGroup(
            jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBackgroundLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpBackgroundLayout.createSequentialGroup()
                        .addComponent(lblTitleAdminStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAdminAgent)
                            .addComponent(lblAdminStatus))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbAdminAgentList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbAdminStatusList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnSaveAdmin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMessageAdmin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                        .addComponent(lblTitleChangeAreaChief, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpBackgroundLayout.createSequentialGroup()
                                .addComponent(lblNewChief1)
                                .addGap(1, 1, 1)
                                .addComponent(lblNewChief2))
                            .addGroup(jpBackgroundLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lblChooseArea2))
                            .addComponent(lblChooesArea1))
                        .addGap(18, 18, 18)
                        .addGroup(jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbListAreas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbListAgentsArea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnSaveAreaChief)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblMessageAreaChief)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnMenu)
                        .addGap(34, 34, 34))
                    .addGroup(jpBackgroundLayout.createSequentialGroup()
                        .addComponent(lblTitleHeadChief, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblChooesHeadChief)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbListAgentsHeadChief, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSaveHeadChief)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblMessageHeadChief)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBackground, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jpBackground, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listAllAgentsAdmin() {

        try {
            String query
                    = "SELECT agent_id, namn, benamning FROM agent a\n"
                    + "JOIN omrade o ON a.omrade = o.omrades_id\n"
                    + "ORDER BY benamning, namn";
            ArrayList<HashMap<String, String>> agentList = idb.fetchRows(query);

            for (HashMap<String, String> element : agentList) {
                cbAdminAgentList.addItem(element.get("namn") + " (" + element.get("agent_id") + ") " + element.get("benamning"));
            }
        } catch (InfException ex) {
            System.out.println("Databasfel" + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Random fel" + ex.getMessage());
        }
    }

    private void listAllAgentsHeadChief() {

        try {
            String query
                    = "SELECT agent_id, namn, benamning FROM agent a\n"
                    + "JOIN omrade o ON a.omrade = o.omrades_id\n"
                    + "ORDER BY benamning, namn";
            ArrayList<HashMap<String, String>> agentList = idb.fetchRows(query);

            for (HashMap<String, String> element : agentList) {
                cbListAgentsHeadChief.addItem(element.get("namn") + " (" + element.get("agent_id") + ") " + element.get("benamning"));
            }
        } catch (InfException ex) {
            System.out.println("Databasfel" + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Random fel" + ex.getMessage());
        }
    }

    private void listAllAgentsAreaChief() {

        try {
            String query
                    = "SELECT agent_id, namn, benamning FROM agent a\n"
                    + "JOIN omrade o ON a.omrade = o.omrades_id\n"
                    + "ORDER BY benamning, namn";
            ArrayList<HashMap<String, String>> agentList = idb.fetchRows(query);

            for (HashMap<String, String> element : agentList) {
                cbListAgentsArea.addItem(element.get("namn") + " (" + element.get("agent_id") + ") " + element.get("benamning"));
            }
        } catch (InfException ex) {
            System.out.println("Databasfel" + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Random fel" + ex.getMessage());
        }
    }

    public void listAllAreas() {

        try {
            String query = "Select benamning from omrade";
            ArrayList<String> result = idb.fetchColumn(query);

            for (String element : result) {
                cbListAreas.addItem(element);

            }
        } catch (InfException ex) {
            System.out.println("Databasfel" + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Random fel" + ex.getMessage());
        }

    }

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        //dispose();
    }//GEN-LAST:event_btnMenuActionPerformed

    private void btnSaveAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveAdminActionPerformed
        String status = "";
        lblMessageAdmin.setText(" ");
        lblMessageAreaChief.setText(" ");
        lblMessageHeadChief.setText(" ");
        lblMessageAdmin.setForeground(new Color(255,50,50));

        if (!cbAdminAgentList.getSelectedItem().equals("-----") && !cbAdminStatusList.getSelectedItem().equals("-----")) {

            lblMessageAdmin.setForeground(new Color(50,255,50));
            lblMessageAdmin.setText("Du har nu bytt status!");

            if (cbAdminStatusList.getSelectedItem().equals("JA")) {
                status = "J";
            } else if (cbAdminStatusList.getSelectedItem().equals("NEJ")) {
                status = "N";
            }

            Object getAgentListItem = cbAdminAgentList.getSelectedItem();
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
        } else if (cbAdminAgentList.getSelectedItem().equals("-----") && !cbAdminStatusList.getSelectedItem().equals("-----")) {
            lblMessageAdmin.setText("Du måste välja en agent!");
        } else if (!cbAdminAgentList.getSelectedItem().equals("-----") && cbAdminStatusList.getSelectedItem().equals("-----")) {
            lblMessageAdmin.setText("Du måste välja en status!");
        } else {
            lblMessageAdmin.setText("Du måste välja en agent och en status!");
        }
    }//GEN-LAST:event_btnSaveAdminActionPerformed

    private void btnSaveAreaChiefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveAreaChiefActionPerformed
        lblMessageAdmin.setText(" ");
        lblMessageAreaChief.setText(" ");
        lblMessageHeadChief.setText(" ");
        lblMessageAreaChief.setForeground(new Color(255,50,50));
        boolean isChief = false;

        if (Validation.validationCb(cbListAgentsArea, lblMessageAreaChief)
                && Validation.validationCb(cbListAreas, lblMessageAreaChief)) {

            try {

                Object getAgentListItem = cbListAgentsArea.getSelectedItem();
                String agentListItem = getAgentListItem.toString();
                String agentid = StringUtils.substringBetween(agentListItem, "(", ")");

                String qCurrentChief = "SELECT a.agent_id FROM AGENT a \n "
                        + "JOIN omradeschef oc ON a.agent_id = oc.agent_id\n"
                        + "JOIN omrade o on oc.omrade = o.omrades_id\n"
                        + "WHERE benamning =" + "'" + cbListAreas.getSelectedItem() + "'";

                String currentChief = idb.fetchSingle(qCurrentChief);

                String allChiefs = "SELECT agent_id FROM AGENT JOIN omradeschef USING (agent_id)";

                ArrayList<String> chiefs = idb.fetchColumn(allChiefs);

                for (String element : chiefs) {
                    if (element.equals(agentid)) {
                        isChief = true;
                        System.out.println(element);
                        break;
                    }
                }

                if (isChief == false) {

                    String qUpdate = "UPDATE Omradeschef SET AGENT_ID = '" + agentid + "'WHERE Agent_ID = '" + currentChief + "'";
                    idb.update(qUpdate);
                    lblMessageAreaChief.setForeground(new Color(50,255,50));
                    lblMessageAreaChief.setText("Områdeschefen är uppdaterad!");

                } else {
                    lblMessageAreaChief.setText("Agenten är redan chef för ett område");
                }

            } catch (InfException ex) {
                System.out.println("Databasfel" + ex.getMessage());
            } catch (Exception ex) {
                System.out.println("Random fel" + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnSaveAreaChiefActionPerformed

    private void btnSaveHeadChiefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveHeadChiefActionPerformed
        lblMessageAdmin.setText(" ");
        lblMessageAreaChief.setText(" ");
        lblMessageHeadChief.setText(" ");
        lblMessageHeadChief.setForeground(new Color(255,50,50));
        if (Validation.validationCb(cbListAgentsHeadChief, lblMessageHeadChief)) {

            Object getAgentListItem = cbListAgentsHeadChief.getSelectedItem();
            String agentListItem = getAgentListItem.toString();
            String agentid = StringUtils.substringBetween(agentListItem, "(", ")");
            try {
                String qHeadChief = "SELECT agent_id from agent JOIN kontorschef USING (agent_ID)";
                String chief = idb.fetchSingle(qHeadChief);

                if (chief.equals(agentid)) {
                    lblMessageHeadChief.setText("Den här agenten är redan kontorschef");
                } else {

                    String qUpdate = "UPDATE kontorschef SET AGENT_ID = '" + agentid + "'WHERE Agent_ID = '" + chief + "'";
                    idb.update(qUpdate);
                    lblMessageHeadChief.setForeground(new Color(50,255,50));
                    lblMessageHeadChief.setText("Agenten har registrerats som kontorschef");
                }

            } catch (InfException ex) {
                System.out.println("Databasfel" + ex.getMessage());
            } catch (Exception ex) {
                System.out.println("Random fel" + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnSaveHeadChiefActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnSaveAdmin;
    private javax.swing.JButton btnSaveAreaChief;
    private javax.swing.JButton btnSaveHeadChief;
    private javax.swing.JComboBox<String> cbAdminAgentList;
    private javax.swing.JComboBox<String> cbAdminStatusList;
    private javax.swing.JComboBox<String> cbListAgentsArea;
    private javax.swing.JComboBox<String> cbListAgentsHeadChief;
    private javax.swing.JComboBox<String> cbListAreas;
    private javax.swing.JPanel jpBackground;
    private javax.swing.JLabel lblAdminAgent;
    private javax.swing.JLabel lblAdminStatus;
    private javax.swing.JLabel lblChooesArea1;
    private javax.swing.JLabel lblChooesHeadChief;
    private javax.swing.JLabel lblChooseArea2;
    private javax.swing.JLabel lblMessageAdmin;
    private javax.swing.JLabel lblMessageAreaChief;
    private javax.swing.JLabel lblMessageHeadChief;
    private javax.swing.JLabel lblNewChief1;
    private javax.swing.JLabel lblNewChief2;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTitleAdminStatus;
    private javax.swing.JLabel lblTitleChangeAreaChief;
    private javax.swing.JLabel lblTitleHeadChief;
    // End of variables declaration//GEN-END:variables
}
