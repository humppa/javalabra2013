package ui;

import Ristinolla.Logiikka;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author rohamo
 */
public class RistinollaActionListener implements ActionListener {

    private RistinollaUI ui;
    private Logiikka logiikka;
    private int ruutu;

    public RistinollaActionListener(RistinollaUI ui, Logiikka logiikka, int ruutu) {
        this.logiikka = logiikka;
        this.ui = ui;
        this.ruutu = ruutu;
    }

    public RistinollaActionListener(RistinollaUI ui, Logiikka logiikka) {
        this.logiikka = logiikka;
        this.ui = ui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if (cmd.equals("EXIT")) {
            System.exit(0);
        }
        else if (cmd.equals("NEWGAME")) {
            ui.paivita();
            ui.setPeliLoppui();
            ui.tyhjennaPelilauta();
            logiikka.uusiPeli();
            ui.paivita();
        }
        else {
            try {
                logiikka.setMerkkiRuutuun(ruutu);
                ui.paivita();
            } catch (IllegalArgumentException a) {
                JOptionPane.showMessageDialog(ui.getFrame(), "Square is marked, pick another", "Error", JOptionPane.WARNING_MESSAGE);
            } catch (IllegalStateException b) {
                JOptionPane.showMessageDialog(ui.getFrame(), "Press RESTART to play again", "Game over", JOptionPane.INFORMATION_MESSAGE);
            } catch (Throwable t) {
                JOptionPane.showMessageDialog(ui.getFrame(), "Logiika's asetaMerkki()-method throws exception: " + t, "ERROR", JOptionPane.ERROR);
            }
        }
    }
}
