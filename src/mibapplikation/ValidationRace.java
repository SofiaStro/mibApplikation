package mibapplikation;

import oru.inf.InfDB;
import oru.inf.InfException;

/**
 * Validation för en aliens ras.
 *
 * @author Grup 8
 */
public class ValidationRace {

    private static InfDB idb;

    public ValidationRace(InfDB idb) {
        this.idb = idb;
    }

    /**
     * Tar reda på vad för ras en alien har.
     *
     * @return Returnerar den angiva aliens ras som en sträng.
     */
    public static String getRace(String alienId) {

        String ras = "";
        try {
            String qAlienSquid = "SELECT alien_id FROM squid WHERE alien_id = '" + alienId + "'";
            String alienSquid = idb.fetchSingle(qAlienSquid);

            String qAlienBoglodite = "SELECT alien_id FROM boglodite WHERE alien_id = '" + alienId + "'";
            String alienBoglodite = idb.fetchSingle(qAlienBoglodite);

            String qAlienWorm = "SELECT alien_id FROM worm WHERE alien_id = '" + alienId + "'";
            String alienWorm = idb.fetchSingle(qAlienWorm);

            if (alienSquid != null) {
                ras = "Squid";
            } else if (alienBoglodite != null) {
                ras = "Boglodite";
            } else if (alienWorm != null) {
                ras = "Worm";
            } else if (ras.equals("")){
                ras = "<Oidentifierad>";
            }

        } catch (InfException ex) {
            System.out.println("Databasfel" + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Random fel" + ex.getMessage());
        }
        return ras;
    }

}
