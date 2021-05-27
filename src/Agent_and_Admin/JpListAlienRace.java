package Agent_and_Admin;

import java.util.ArrayList;
import mibapplikation.ValidationRace;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 * Panel som listar alla aliens för en vald ras
 * 
 * @author Grupp 8
 */
public class JpListAlienRace extends javax.swing.JPanel {
    
    private InfDB idb;

    public JpListAlienRace(InfDB idb) {
        initComponents();
        this.idb = idb;
        // Metoden .setEditable(false) gör så att man endast kan "selecta" text och inte skriva i text arean.
        txtaShowAliens.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblSelectRace = new javax.swing.JLabel();
        cbListRace = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtaShowAliens = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(40, 40, 40));

        lblSelectRace.setForeground(new java.awt.Color(255, 255, 255));
        lblSelectRace.setText("Välj en ras:");

        cbListRace.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----", "Squid", "Boglodite", "Worm", "<Oidentifierad>" }));
        cbListRace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbListRaceActionPerformed(evt);
            }
        });

        txtaShowAliens.setBackground(new java.awt.Color(79, 79, 79));
        txtaShowAliens.setColumns(19);
        txtaShowAliens.setForeground(new java.awt.Color(255, 255, 255));
        txtaShowAliens.setRows(5);
        jScrollPane1.setViewportView(txtaShowAliens);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSelectRace, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbListRace, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSelectRace)
                    .addComponent(cbListRace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(123, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbListRaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbListRaceActionPerformed

        txtaShowAliens.setText("");

        try {
            String qAlienId = "SELECT alien_id FROM alien";
            ArrayList<String> listAlienId = idb.fetchColumn(qAlienId);

            txtaShowAliens.append(" ALIEN ID\tNAMN\n "
                + "------------\t------------\n");

            for(String alienId : listAlienId){
                String race = ValidationRace.getRace(alienId);
                String qAlienName = "SELECT namn FROM alien WHERE alien_id = '" + alienId + "'";
                String alienName = idb.fetchSingle(qAlienName);

                if(cbListRace.getSelectedItem().equals(race)){
                    txtaShowAliens.append(" " + alienId + "\t" + alienName + "\n");
                }
            }
        } catch (InfException ex) {
            System.out.println("Databasfel" + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Random fel" + ex.getMessage());
        }
    }//GEN-LAST:event_cbListRaceActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbListRace;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSelectRace;
    private javax.swing.JTextArea txtaShowAliens;
    // End of variables declaration//GEN-END:variables
}
