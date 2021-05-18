/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mibapplikation;

import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Blazl
 */
public class Validation {
    
    public static boolean textFaltHarVarde(JTextField fieldToValidate, JLabel message)
    {
        boolean resultat = true;        
        if(fieldToValidate.getText().isEmpty()){
            message.setText("En eller flera rutor är tomma!");
            resultat = false;
            fieldToValidate.requestFocus();
        }       
        return resultat;
    }
    
}
