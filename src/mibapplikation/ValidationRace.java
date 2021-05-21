/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mibapplikation;

import oru.inf.InfDB;
import oru.inf.InfException;

/**
 *
 * @author strom
 */
public class ValidationRace {

    public static String getRace(InfDB idbIncoming, String alienId) {
        InfDB idb = idbIncoming;
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
            } 
            else if (alienBoglodite != null) {
                ras = "Boglodite";
            } 
            else if (alienWorm != null) {
                ras = "Worm";
            }

        } 
        catch (InfException ex) {
            System.out.println("Databasfel" + ex.getMessage());
        } 
        catch (Exception ex) {
            System.out.println("Random fel" + ex.getMessage());
        }
        return ras;
    }

}
