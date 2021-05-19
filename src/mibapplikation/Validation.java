/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mibapplikation;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Blazl
 */
public class Validation {
    
    public static boolean validationTxt(JTextField fieldToValidate, JLabel message)
    {
        boolean resultat = true;        
        if(fieldToValidate.getText().isEmpty()){
            message.setText("En eller flera rutor är tomma!");
            resultat = false;
            fieldToValidate.requestFocus();
        }       
        return resultat;
    }
    
    
    
    public static boolean validationTxt(JTextField fieldToValidate, JTextArea message)
    {
        boolean resultat = true;        
        if(fieldToValidate.getText().isEmpty()){
            message.setText("En eller flera rutor är tomma!");
            resultat = false;
            fieldToValidate.requestFocus();
        }       
        return resultat;
    }
    
    
    public static boolean validationCb(JComboBox fieldToValidate, JLabel message)
    {
        boolean resultat = true;        
        if(fieldToValidate.getSelectedItem().equals("-----")){
            message.setText("En eller flera rutor är tomma!");
            resultat = false;
            fieldToValidate.requestFocus();
        }       
        return resultat;
    }
    
    public static boolean validationCb(JComboBox fieldToValidate, JTextArea message)
    {
        boolean resultat = true;        
        if(fieldToValidate.getSelectedItem().equals("-----")){
            message.setText("En eller flera rutor är tomma!");
            resultat = false;
            fieldToValidate.requestFocus();
        }       
        return resultat;
    }
    
}