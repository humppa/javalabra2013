
package Ristinolla;

import javax.swing.SwingUtilities;
import ui.RistinollaUI;


/**
 * 
 * @author      Paavo Rohamo
 */
public class Ristinolla {


    public static void main(String[] args) {
        Logiikka logiikka = new Logiikka();
        SwingUtilities.invokeLater(new RistinollaUI(logiikka));
    }
}
