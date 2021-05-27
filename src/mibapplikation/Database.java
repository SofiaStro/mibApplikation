package mibapplikation;

import java.util.logging.Level;
import java.util.logging.Logger;
import oru.inf.InfDB;
import oru.inf.InfException;

/**
 * Programmets start-klass. Upprättar en databasanslutning och öppnar upp
 * login-fönstret.
 *
 * @author Grupp 8
 *
 */
public class Database {

    private static InfDB idb;

    public static void main(String[] args) {
        try {
            idb = new InfDB("mibdb", "3306", "mibdba", "mibkey");
        } catch (InfException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        new MainWindowLogin(idb).setVisible(true);

    }

}
