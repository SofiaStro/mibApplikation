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
public class Agent {

    private static InfDB idb;

    public Agent(InfDB idb){
        this.idb = idb;
    }
    
    public static String getEquipmentType(String equipmentId) {

        String equipmentType = "";
        try {
            String qEquipmentWeapon = "SELECT utrustnings_id FROM vapen WHERE utrustnings_id = '" + equipmentId + "'";
            String equipmentWeapon = idb.fetchSingle(qEquipmentWeapon);

            String qEquipmentTech = "SELECT utrustnings_id FROM teknik WHERE utrustnings_id = '" + equipmentId + "'";
            String equipmentTech = idb.fetchSingle(qEquipmentTech);

            String qEquipmentComms = "SELECT utrustnings_id FROM kommunikation WHERE utrustnings_id = '" + equipmentId + "'";
            String equipmentComms = idb.fetchSingle(qEquipmentComms);

            if (equipmentWeapon != null) {
                equipmentType = "Vapen";
            } 
            else if (equipmentTech != null) {
                equipmentType = "Teknik";
            } 
            else if (equipmentComms != null) {
                equipmentType = "Kommunikation";
            }
        } 
        catch (InfException ex) {
            System.out.println("Databasfel" + ex.getMessage());
        } 
        catch (Exception ex) {
            System.out.println("Random fel" + ex.getMessage());
        }
        return equipmentType;
    }
}

