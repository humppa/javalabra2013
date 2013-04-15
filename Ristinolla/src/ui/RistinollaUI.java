package ui;

import Ristinolla.Logiikka;
import java.awt.*;
import javax.swing.*;

public class RistinollaUI implements Runnable {

    private JFrame ui = new JFrame("Ristinolla");
    private JButton[] pelilauta = new JButton[9];
    private Logiikka logiikka;
    private JLabel peliVuorossa;
    private int peliloppui;
    private MouseOver nappula;
    private JLabel ristinVoitot;
    private JLabel ympyranVoitot;

    public RistinollaUI(Logiikka logiikka) {
        ui.setSize(500, 550);
        ui.setLocation(1000, 400);
        ui.setResizable(false);
        ui.setLayout(new BorderLayout());
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.logiikka = logiikka;
        this.peliloppui = 0;
    }

    @Override
    public void run() {
        luoUI(ui.getContentPane());
        ui.setVisible(true);
    }

    public void luoUI(Container container) {
        JPanel ylapalkki = new JPanel();
        GridLayout ylapalkkiRuudukko = new GridLayout(1, 3);

        JButton uusiPeli = new JButton("New Game");
        uusiPeli.setBackground(Color.white);
        uusiPeli.setActionCommand("NEWGAME");
        uusiPeli.addActionListener(new RistinollaActionListener(this, logiikka));
        peliVuorossa = new JLabel("Turn: Player " + logiikka.getPelivuorossa());
        peliVuorossa.setHorizontalAlignment(JLabel.CENTER);
        JButton exit = new JButton("Exit");
        exit.setActionCommand("EXIT");
        exit.addActionListener(new RistinollaActionListener(this, logiikka));
        exit.setBackground(Color.white);

        ylapalkki.setLayout(ylapalkkiRuudukko);
        ylapalkki.add(uusiPeli);
        ylapalkki.add(peliVuorossa);
        ylapalkki.add(exit);

        JPanel pelilautaRuudukko = new JPanel();
        GridLayout ruudukonKoko = new GridLayout(3, 3);
        pelilautaRuudukko.setLayout(ruudukonKoko);

        for (int ruutu = 0; ruutu < 9; ruutu++) {
            nappula = new MouseOver(Color.WHITE, Color.BLACK);
            nappula.addActionListener(new RistinollaActionListener(this, logiikka, ruutu));
            pelilauta[ruutu] = nappula;
            pelilautaRuudukko.add(nappula);
        }

        JPanel alapalkki = new JPanel();
        ristinVoitot = new JLabel("P1: " + logiikka.getRistinVoitot());
        ympyranVoitot = new JLabel("P2: " + logiikka.getYmpyranVoitot());
        alapalkki.add(ristinVoitot);
        alapalkki.add(ympyranVoitot);

        container.add(ylapalkki, BorderLayout.NORTH);
        container.add(pelilautaRuudukko, BorderLayout.CENTER);
        container.add(alapalkki, BorderLayout.SOUTH);
    }

    public JFrame getFrame() {
        return ui;
    }

    public void paivita() {
        for (int i = 0; i<9; i++) {
            if (logiikka.getRuudunMerkki(i) == 1) {
                pelilauta[i].setText("x");
            } else if (logiikka.getRuudunMerkki(i) == 2) {
                pelilauta[i].setText("o");
            } 
        }
        if (peliloppui == 0) {
            if (logiikka.tarkistaLoppuikoPeli() == true) {
                if (logiikka.tarkistaVoittaja() == 0) {
                    JOptionPane.showMessageDialog(null, "Tie game!");
                    peliLoppui();
                } else {
                    JOptionPane.showMessageDialog(null, "Player " + logiikka.tarkistaVoittaja() + " wins!");
                    if (logiikka.tarkistaVoittaja() == 1) {
                        ristinVoitot.setText("P1: " + logiikka.getRistinVoitot());
                    } else {
                        ympyranVoitot.setText("P2: " + logiikka.getYmpyranVoitot());
                    }
                    peliLoppui();
                }
            } else {
                peliVuorossa.setText("Turn: Player " + logiikka.getPelivuorossa());
            }
        }
    }

    public void setPeliLoppui() {
        peliloppui = 0;
    }

    public void peliLoppui() {
        peliloppui = 1;
        peliVuorossa.setText("Game over");
    }
    
    public void tyhjennaPelilauta() {
        for (int i = 0; i<9; i++) {
            pelilauta[i].setText("");
        }
    }
}
