package Agent_and_Admin;

import java.awt.Color;
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
 * Fönster för att registrera och lägga till en ny alien i databasen.
 *
 * @author Grupp 8
 */
public class JfRegAlien extends javax.swing.JFrame {

    private InfDB idb;

    public JfRegAlien(InfDB idb) {
        initComponents();
        this.idb = idb;

        //Gör att man endast kan selecta text, och ej skriva i textrutan.
        txtaMessage.setEditable(false);
        setRace();
        setLocation();
        setAgentInCharge();
        txtRaceSpecial.setVisible(false);
        lblRaceSpecial.setVisible(false);
    }

    private void setRace() {

        ArrayList<String> raceList = new ArrayList<String>();
        raceList.add("Boglodite");
        raceList.add("Squid");
        raceList.add("Worm");
        raceList.add("<Oidentifierad>");

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

        } catch (InfException ex) {
            System.out.println("Databasfel" + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Random fel" + ex.getMessage());
        }

        return newId;

    }

    private String getNewPw() {

        //Metod som returnerar en slumpmässigt sträng som innehåller bokstäver och siffror.
        String newPw = RandomStringUtils.randomAlphanumeric(6);

        return newPw;
    }

    private String getAgentInChargeId() {

        Object getListItem = cbAgentInCharge.getSelectedItem();
        String getString = String.valueOf(getListItem);
        //Metod som returnerar en del av en sträng mellan de specificerade karaktärerna.
        String agentId = StringUtils.substringBetween(getString, "(", ")");

        return agentId;
    }

    private String getSystemDate() {
        //Local date hanterar format för datum. Metoden .now returnerar
        //ditt systems nuvarande datum.
        LocalDate localDate = LocalDate.now();
        String currentDate = String.valueOf(localDate);

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
        lblMessage = new javax.swing.JLabel();

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

        lblMessage.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lblMessage.setForeground(new java.awt.Color(255, 50, 50));
        lblMessage.setText(" ");

        javax.swing.GroupLayout jpBackgroundLayout = new javax.swing.GroupLayout(jpBackground);
        jpBackground.setLayout(jpBackgroundLayout);
        jpBackgroundLayout.setHorizontalGroup(
            jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBackgroundLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpBackgroundLayout.createSequentialGroup()
                        .addGroup(jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName)
                            .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(240, 240, 240))
                    .addGroup(jpBackgroundLayout.createSequentialGroup()
                        .addGroup(jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpBackgroundLayout.createSequentialGroup()
                                .addComponent(lblRace)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(spMessageBox, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                    .addComponent(cbAgentInCharge, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblRaceSpecial)
                                    .addComponent(txtRaceSpecial, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jpBackgroundLayout.createSequentialGroup()
                                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(38, 38, 38))))
        );
        jpBackgroundLayout.setVerticalGroup(
            jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpBackgroundLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpBackgroundLayout.createSequentialGroup()
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
                        .addComponent(cbLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAgentInCharge)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbAgentInCharge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpBackgroundLayout.createSequentialGroup()
                        .addComponent(spMessageBox, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jpBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSave)
                    .addComponent(lblMessage))
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
            .addComponent(jpBackground, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed

        getAgentInChargeId();
        getLocationId();

        String getName = txtName.getText();
        //Metod som gör om första bokstaven för varje ord i en sträng till versal.
        String name = WordUtils.capitalize(getName);

        String phone = txtPhone.getText();

        Object getRaceListItem = cbRace.getSelectedItem();
        String race = getRaceListItem.toString();

        String raceSpecial = lblRaceSpecial.getText();

        if (Validation.validationTxtPhone(txtPhone, lblMessage)
                && Validation.validationTxt(txtName, lblMessage, "Ange namn")
                && Validation.validationCb(cbRace, lblMessage, "Ange Ras")
                && Validation.validationCb(cbLocation, lblMessage, "Ange plats")
                && Validation.validationCb(cbAgentInCharge, lblMessage, "Ange ansvarig agent")) {

            if (txtRaceSpecial.isShowing() == true) {
                if (!Validation.validationTxt(txtRaceSpecial, lblMessage, "Ange " + raceSpecial.substring(0, raceSpecial.length() - 1))
                        || !Validation.validationNumbers(txtRaceSpecial, lblMessage, raceSpecial.substring(0, raceSpecial.length() - 1) + " måste vara en siffra")) {

                    return;
                }
            }

            try {
                String alienId = getNewAlienId();
                String newPw = getNewPw();

                String query = "INSERT INTO alien (alien_id, registreringsdatum, losenord, namn, telefon, plats, ansvarig_agent)\n"
                        + "VALUES (" + alienId + ", "
                        + "'" + getSystemDate() + "'" + ", "
                        + "'" + newPw + "'" + ", "
                        + "'" + name + "'" + ", "
                        + "'" + phone + "'" + ", "
                        + "'" + getLocationId() + "'" + ", "
                        + "'" + getAgentInChargeId() + "'" + ")";
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
                //Ger texten i lblMessage en ny färg.
                lblMessage.setForeground(new Color(50, 255, 50));
                lblMessage.setText("Registrering slutförd!");
                txtaMessage.setText("Registrering slutförd\n"
                        + "------------------------------------------\n"
                        + "ID: " + alienId + "\n"
                        + "\n"
                        + "Namn: " + name + "\n"
                        + "\n"
                        + "Lösenord: " + newPw + "\n"
                        + "\n"
                        + "Ras: " + race + "\n"
                        + lblRaceSpecial.getText() + " " + getRaceSpecial() + "\n"
                        + "\n"
                        + "Telefon: " + phone + "\n"
                        + "\n"
                        + "Plats: " + cbLocation.getSelectedItem() + "\n"
                        + "\n"
                        + "Ansvarig agent: " + StringUtils.substringBefore(cbAgentInCharge.getSelectedItem().toString(), " (")); //Metod som
                //returnerar delen av en sträng före det angivna tecknet.

            } catch (InfException ex) {
                System.out.println("Databasfel" + ex.getMessage());
            } catch (Exception ex) {
                System.out.println("Random fel" + ex.getMessage());
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnMenuActionPerformed

    private void cbRaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbRaceActionPerformed

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
    private javax.swing.JLabel lblMessage;
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
