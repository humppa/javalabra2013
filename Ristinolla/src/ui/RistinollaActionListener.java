package ui;

import Ristinolla.Logiikka;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

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
        if (cmd.equals("EXIT") || cmd.equals("NEWGAME")) {
            switch (cmd) {
                case "EXIT":
                    System.exit(0);
                    break;
                case "NEWGAME":
                    this.ui.setPeliLoppui();
                    this.logiikka.uusiPeli();
                    ui.paivita();
                    break;
            }
        } else {
            try {
                logiikka.setMerkkiRuutuun(ruutu);
            } catch (IllegalArgumentException a) {
                JOptionPane.showMessageDialog(ui.getFrame(), "SQUARE HAS MARK ALREADY, PICK ANOTHER", "GAME STATUS", JOptionPane.WARNING_MESSAGE);
            } catch (IllegalStateException b) {
                JOptionPane.showMessageDialog(ui.getFrame(), "GAME IS OVER", "GAME STATUS", JOptionPane.INFORMATION_MESSAGE);
            } catch (Throwable t) {
                JOptionPane.showMessageDialog(ui.getFrame(), "Logiika's asetaMerkki()-method throws exception: " + t, "ERROR", JOptionPane.ERROR);
            }
            ui.paivita();
        }
    }
}
