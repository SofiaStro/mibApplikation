package mibapplikation;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 * Olika typer av validationer för komponenter.
 *
 * @author Grupp 8
 */
public class Validation {

    /**
     * Ger en JLabel en röd färg.
     *
     * @param message JLabel vars textfärg ska förändras.
     */
    public static void setErrorColor(JLabel message) {
        message.setForeground(new Color(255, 50, 50));
    }

    /**
     * Kollar om ett textfält är tomt.
     */
    public static boolean validationTxt(JTextField fieldToValidate, JLabel message, String messageText) {
        boolean result = true;
        if (fieldToValidate.getText().isEmpty()) {
            setErrorColor(message);
            message.setText(messageText);
            result = false;
            fieldToValidate.requestFocus();
        }
        return result;
    }

    /**
     * Kollar om ett textfält har rätt format för datum(yyyy-mm-dd).
     */
    public static boolean validationTxtDate(JTextField fieldToValidate, JLabel message) {
        boolean result = true;
        String fullDate = fieldToValidate.getText();

        if (fullDate.length() != 10) {
            setErrorColor(message);
            message.setText("Datumet är felaktigt!");
            result = false;
        } else {
            String year = fullDate.substring(0, 4);
            String month = fullDate.substring(5, 7);
            String day = fullDate.substring(8, 10);
            String lineOne = fullDate.substring(4, 5);
            String lineTwo = fullDate.substring(7, 8);

            String regex = "\\d+"; //Kontrollerar att det er ett tal från 0 eller större

            //matchers metoden kollar om strängen innehåller det som regex uttrycket anger
            //och returnerar sant eller falskt.
            Boolean yearCheck = year.matches(regex);
            Boolean monthCheck = month.matches(regex);
            Boolean dayCheck = day.matches(regex);

            if (yearCheck && monthCheck && dayCheck
                    && lineOne.equals("-") && lineTwo.equals("-")
                    && Integer.parseInt(month) >= 1 && Integer.parseInt(month) <= 12
                    && Integer.parseInt(day) >= 1 && Integer.parseInt(day) <= 31) {
            } else {
                result = false;
                setErrorColor(message);
                message.setText("Datumet är felaktigt!");
                fieldToValidate.requestFocus();
            }
        }
        return result;
    }

    /**
     * Kollar om ett textfält enbart innehåller siffror.
     */
    public static boolean validationNumbers(JTextField fieldToValidate, JLabel message, String messageText) {
        boolean result = false;
        if (fieldToValidate.getText().matches("[0-9]+")) {

            result = true;

        } else {
            setErrorColor(message);
            message.setText(messageText);
            fieldToValidate.requestFocus();

        }
        return result;
    }

    /**
     * Kollar om ett textfält ej innehåller andra tecken än de som står i regex
     * uttrycket.
     */
    public static boolean validationTxtPhone(JTextField fieldToValidate, JLabel message) {
        boolean result = false;
        //Regex uttrycket "[+() [0-9]-]+" betyder: "+" "-" "(" ")" "mellanslag" "tal 1-9"
        if (fieldToValidate.getText().matches("[+() [0-9]-]+") || fieldToValidate.getText().matches("")) {

            result = true;

        } else {
            setErrorColor(message);
            message.setText("Telefonnumret har fel format!");
            fieldToValidate.requestFocus();
        }
        return result;
    }

    /**
     * Kollar om en JComboBox är tom(-----).
     */
    public static boolean validationCb(JComboBox fieldToValidate, JLabel message, String messageText) {
        boolean result = true;
        if (fieldToValidate.getSelectedItem().equals("-----")) {
            setErrorColor(message);
            message.setText(messageText);
            result = false;
            fieldToValidate.requestFocus();
        }
        return result;
    }

    /**
     * Kollar om ett textfält ej innehåller fler karaktärer än den angivna
     * parametern maxChars.
     */
    public static boolean validationTxtNrOfChar(JTextField fieldToValidate, JLabel message, int maxChars, String messageText) {
        boolean result = false;
        if (fieldToValidate.getText().length() <= maxChars) {

            result = true;
            fieldToValidate.requestFocus();

        } else {
            setErrorColor(message);
            message.setText(messageText);
        }
        return result;
    }
}
