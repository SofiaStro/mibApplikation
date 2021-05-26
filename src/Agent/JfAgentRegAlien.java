/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agent;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import mibapplikation.Validation;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author strom
 */
public class JfAgentRegAlien extends javax.swing.JFrame {

    
    private InfDB idb;
    

    /**
     * Creates new form WindowAlienChangePw
     */
    public JfAgentRegAlien(InfDB idb) {
        initComponents();
        this.idb = idb;
        
        txtaMessage.setEditable(false);
        setRace();
        setLocation();
        setAgentInCharge();
        txtRaceSpecial.setVisible(false);
        lblRaceSpecial.setVisible(false);
    }

    private void setRace() {

        ArrayList<String> raceList = new ArrayList<String>();
        raceList.add("<Oidentifierad>");
        raceList.add("Boglodite");
        raceList.add("Squid");
        raceList.add("Worm");

        for (String element : raceList) {
            cbRace.addItem(element);
        }

    }

    private void setLocation() {
        try {
            String query = "SELECT benamning FROM plats";
            ArrayList<String> result = idb.fetchColumn(query);
            for (String element : result) {
                cbLocation.addItem(element);
            }
        } catch (InfException ex) {
            System.out.println("Databasfel" + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Random fel" + ex.getMessage());
        }

    }

    private void setAgentInCharge() {
        try {
            String query = "SELECT namn, agent_id, benamning FROM agent a\n"
                    + "JOIN omrade o on a.Omrade = o.Omrades_ID\n"
                    + "ORDER BY Benamning;";
            ArrayList<HashMap<String, String>> result = idb.fetchRows(query);

            for (HashMap<String, String> element : result) {
                cbAgentInCharge.addItem(element.get("namn") + " (" + element.get("agent_id") + ") (" + element.get("benamning") + ")");
            }
        } catch (InfException ex) {
            System.out.println("Databasfel" + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Random fel" + ex.getMessage());
        }

    }

    private String getNewAlienId() {
        int lastNr = 0;
        String newId = "";

        try {
            String query = "SELECT alien_id FROM alien";
            ArrayList<String> result = idb.fetchColumn(query);
            int[] intResult = new int[result.size()];
            System.out.println("intResult = " + intResult.length);

            for (int i = 0; i < result.size(); i++) {
                intResult[i] = Integer.parseInt(result.get(i));
            }
            for (int element : intResult) {
                if (element >= lastNr) {
                    lastNr = element;
                }
            }
            int newIdInt = lastNr + 1;
            newId = String.valueOf(newIdInt);

            System.out.println("Nytt alien ID: " + newId);

        } catch (InfException ex) {
            System.out.println("Databasfel" + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Random fel" + ex.getMessage());
        }

        return newId;

    }

    private String getNewPw() {
        String newPw = RandomStringUtils.randomAlphanumeric(6);

        System.out.println("Lösen: " + newPw);

        return newPw;
    }

    private String getAgentInCharge() {

        Object getListItem = cbAgentInCharge.getSelectedItem();
        String getString = String.valueOf(getListItem);
        String agentId = StringUtils.substringBetween(getString, "(", ")");

        System.out.println("Agent ID: " + agentId);
        return agentId;
    }

    private String getSystemDate() {
        LocalDate localDate = LocalDate.now();
        String currentDate = String.valueOf(localDate);
        System.out.println("Datum: " + currentDate);

        return currentDate;
    }

    private String getLocationId() {
        String locationId = "";
        Object getListItem = cbLocation.getSelectedItem();
        String location = String.valueOf(getListItem);
        String query = "SELECT plats_id FROM plats WHERE benamning = " + "'" + location + "'";

        try {
            String getLocationId = idb.fetchSingle(query);
            locationId = getLocationId;
            System.out.println("Plats ID: " + "(" + locationId + ")");

        } catch (InfException ex) {
            System.out.println("Databasfel" + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Random fel" + ex.getMessage());
        }
        return locationId;
    }

    private String getRaceSpecial() {
        String raceSpecial = txtRaceSpecial.getText();

        return raceSpecial;
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
        btnSave = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();
        txtName = new javax.swing.JTextField();
        cbLocation = new javax.swing.JComboBox<>();
        cbAgentInCharge = new javax.swing.JComboBox<>();
        cbRace = new javax.swing.JComboBox<>();
        txtPhone = new javax.swing.JTextField();
        spMessageBox = new javax.swing.JScrollPane();
        txtaMessage = new javax.swing.JTextArea();
        lblName = new javax.swing.JLabel();
        lblRace = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        lblLocation = new javax.swing.JLabel();
        lblAgentInCharge = new javax.swing.JLabel();
        txtRaceSpecial = new javax.swing.JTextField();
        lblRaceSpecial = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Galaxal");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Icons/astronomy.png")).getImage());
        setLocationByPlatform(true);
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        jpBackground.setBackground(new java.awt.Color(40, 40, 40));
        jpBackground.setPreferredSize(new java.awt.Dimension(400, 350));

        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Registrera en alien");

        btnSave.setText("REGISTRERA");
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

        txtName.setColumns(5);

        cbLocation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----" }));

        cbAgentInCharge.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----" }));

        cbRace.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----" }));
        cbRace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbRaceActionPerformed(evt);
            }
        });

        txtPhone.setColumns(6);

        spMessageBox.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        spMessageBox.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        spMessageBox.setPreferredSize(new java.awt.Dimension(178, 86));

        txtaMessage.setBackground(new java.awt.Color(79, 79, 79));
        txtaMessage.setColumns(10);
        txtaMessage.setForeground(new java.awt.Color(255, 255, 255));
        txtaMessage.setRows(5);
        txtaMessage.setRequestFocusEnabled(false);
        spMessageBox.setViewportView(txtaMessage);

        lblName.setForeground(new java.awt.Color(255, 255, 255));
        lblName.setText("Namn:");

        lblRace.setForeground(new java.awt.Color(255, 255, 255));
        lblRace.setText("Ras:");

        lblPhone.setForeground(new java.awt.Color(255, 255, 255));
        lblPhone.setText("Telefon:");

        lblLocation.setForeground(new java.awt.Color(255, 255, 255));
        lblLocation.setText("Plats:");

        lblAgentInCharge.setForeground(new java.awt.Color(255, 255, 255));
        lblAgentInCharge.setText("Ansvarig agent:");

        txtRaceSpecial.setColumns(5);

        lblRaceSpecial.setForeground(new java.awt.Color(255, 255, 255));
        lblRaceSpecial.setText("Antal xxx:");

        javax.swing.GroupLayout jpBackgroundLayout = new javax.swing.GroupLayout(jpBackground);
        jpBackground.setLayout(jpBackgroundLayout);
        jpBackgroundLayout.setHorizontalGroup(
            jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBackgroundLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpBackgroundLayout.createSequentialGroup()
                        .addGroup(jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblRace)
                            .addComponent(lblName)
                            .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(240, 240, 240))
                    .addGroup(jpBackgroundLayout.createSequentialGroup()
                        .addGroup(jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtName, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbRace, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbLocation, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblPhone, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPhone, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnMenu, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAgentInCharge, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblLocation, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbAgentInCharge, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSave, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpBackgroundLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblRaceSpecial)
                                    .addComponent(txtRaceSpecial, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpBackgroundLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(spMessageBox, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(55, 55, 55))))
        );
        jpBackgroundLayout.setVerticalGroup(
            jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBackgroundLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRace)
                    .addComponent(lblRaceSpecial))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbRace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRaceSpecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblPhone)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLocation)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpBackgroundLayout.createSequentialGroup()
                        .addComponent(cbLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAgentInCharge)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbAgentInCharge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSave))
                    .addComponent(spMessageBox, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(btnMenu)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpBackground, javax.swing.GroupLayout.PREFERRED_SIZE, 468, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        //TODO: INSERT INTO alien. 
        //1. KLAR Auto incr ID efter den högsta nuvarande
        //2. KLAR Nuvarande datum.

        //3.KLAR Ett random lösenord.
        //4. KLAR Namn från txtField.
        //5. KLAR Telefon från txtField.
        //6. KLAR Plats ID, måste hämta ID genom plats namn från ComboBox.
        //7. KLAR Ansvarig agent ID, samma sätt som ovan.
        //8. INSERT alien ID och unik ras specifikation INTO en ras tabell beroende på val av ras.
        // När man väljer en ras ska den unika specifikationsnamnet dyka upp 
        // + ett textField där man kan skriva in en INT.
        getAgentInCharge();
        getLocationId();

        String getName = txtName.getText();
        String name = WordUtils.capitalize(getName);

        String phone = txtPhone.getText();
        System.out.println("Alien namn: " + name);
        System.out.println("Alien telefonnr: " + phone);

        Object getRaceListItem = cbRace.getSelectedItem();
        String race = getRaceListItem.toString();

       

        if (Validation.validationTxtPhone(txtPhone, txtaMessage) //kolla om databasen får ett värde om man endast skriver mellanslag
                && Validation.validationTxt(txtName, txtaMessage)
                && Validation.validationCb(cbLocation, txtaMessage)
                && Validation.validationCb(cbRace, txtaMessage)
                && Validation.validationCb(cbAgentInCharge, txtaMessage)) {

            if (txtRaceSpecial.isShowing() == true) {
                if (!Validation.validationTxt(txtRaceSpecial, txtaMessage)
                        || !Validation.validationNumbers(txtRaceSpecial, txtaMessage, lblRaceSpecial.getText() + " måste vara\nen siffra!")) {

                    return;
                }
            }

            try {
                String alienId = getNewAlienId();
                String newPw = getNewPw();

                //String queryTest ="INSERT INTO alien (alien_id, namn, plats, ansvarig_agent)\n" +
                //                  "VALUES (6, " + "'" + name + "'" + ", " + "'" + getLocationId() + "'" + ", '1')";
                String query = "INSERT INTO alien (alien_id, registreringsdatum, losenord, namn, telefon, plats, ansvarig_agent)\n"
                        + "VALUES (" + alienId + ", "
                        + "'" + getSystemDate() + "'" + ", "
                        + "'" + newPw + "'" + ", "
                        + "'" + name + "'" + ", "
                        + "'" + phone + "'" + ", "
                        + "'" + getLocationId() + "'" + ", "
                        + "'" + getAgentInCharge() + "'" + ")";
                String querySquid = "INSERT INTO squid (alien_id, antal_armar)\n"
                        + "VALUES ("
                        + alienId + ", "
                        + "'" + getRaceSpecial() + "'" + ")";
                String queryBoglodite = "INSERT INTO boglodite (alien_id, antal_boogies)\n"
                        + "VALUES ("
                        + alienId + ", "
                        + "'" + getRaceSpecial() + "'" + ")";
                String queryWorm = "INSERT INTO worm (alien_id)\n"
                        + "VALUES ("
                        + alienId + ")";

                idb.insert(query);
                //idb.insert(queryBoglodite);

                switch (race) {
                    case "Squid":
                        idb.insert(querySquid);
                        break;
                    case "Boglodite":
                        idb.insert(queryBoglodite);
                        break;
                    case "Worm":
                        idb.insert(queryWorm);
                        break;
                }

                txtaMessage.setText("Registrering slutförd!\n"
                        + "Skriv ner informationen nedan.\n"
                        + "------------------------------------------\n"
                        + "ID: " + alienId + "\n"
                        + "Lösenord: " + newPw);

            } catch (InfException ex) {
                System.out.println("Databasfel" + ex.getMessage());
            } catch (Exception ex) {
                System.out.println("Random fel" + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        // TODO add your handling code here:
        setVisible(false);

        //dispose();
    }//GEN-LAST:event_btnMenuActionPerformed

    private void cbRaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRaceActionPerformed
        // TODO add your handling code here:
        if (cbRace.getSelectedItem().equals("Squid") || cbRace.getSelectedItem().equals("Boglodite")) {
            txtRaceSpecial.setVisible(true);
            lblRaceSpecial.setVisible(true);

            if (cbRace.getSelectedItem().equals("Squid")) {
                lblRaceSpecial.setText("Antal armar:");
            }
            if (cbRace.getSelectedItem().equals("Boglodite")) {
                lblRaceSpecial.setText("Antal boogies:");
            }

        } else {
            txtRaceSpecial.setVisible(false);
            lblRaceSpecial.setVisible(false);
        }

    }//GEN-LAST:event_cbRaceActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnSave;
    private javax.swing.JComboBox<String> cbAgentInCharge;
    private javax.swing.JComboBox<String> cbLocation;
    private javax.swing.JComboBox<String> cbRace;
    private javax.swing.JPanel jpBackground;
    private javax.swing.JLabel lblAgentInCharge;
    private javax.swing.JLabel lblLocation;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblRace;
    private javax.swing.JLabel lblRaceSpecial;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JScrollPane spMessageBox;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    private javax.swing.JTextField txtRaceSpecial;
    private javax.swing.JTextArea txtaMessage;
    // End of variables declaration//GEN-END:variables
}
