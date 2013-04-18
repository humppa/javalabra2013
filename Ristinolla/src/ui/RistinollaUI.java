package ui;

import Ristinolla.Logiikka;
import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * 
 * @author      Paavo Rohamo
 * 
 * Luo ohjelmalle käyttöliittymä näkymän ja päivittää sitä tarvittaessa
 */
public class RistinollaUI implements Runnable {

    private JFrame ui = new JFrame("Tic-tac-toe (Version 1.1)");
    private JButton[] pelilauta = new JButton[9];
    private Logiikka logiikka;
    private JLabel peliVuorossa;
    private boolean peliloppui;
    private MouseOver nappula;
    private JLabel ristinVoitot;
    private JLabel ympyranVoitot;
    private String p1;
    private String p2;

    public RistinollaUI(Logiikka logiikka) {
        ui.setSize(360, 410);
        ui.setLocation(1000, 400);
        ui.setResizable(false);
        ui.setLayout(new BorderLayout());
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.logiikka = logiikka;
        this.peliloppui = false;
    }

    @Override
    public void run() {
        p1 = "Player 1";
        p2 = "Player 2";
        luoUI(ui.getContentPane());
        ui.setVisible(true);
    }

    public void luoUI(Container container) {
        JPanel ylapalkki = new JPanel();
        GridLayout ylapalkkiRuudukko = new GridLayout(1, 3);

        JButton uusiPeli = new JButton("Restart");
        uusiPeli.setBackground(Color.LIGHT_GRAY);
        uusiPeli.setActionCommand("NEWGAME");
        uusiPeli.addActionListener(new RistinollaActionListener(this, logiikka));
        
        JButton exit = new JButton("Exit");
        exit.setActionCommand("EXIT");
        exit.addActionListener(new RistinollaActionListener(this, logiikka));
        exit.setBackground(Color.LIGHT_GRAY);

        ylapalkki.setLayout(ylapalkkiRuudukko);
        ylapalkki.add(uusiPeli);
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
        alapalkki.setBackground(Color.LIGHT_GRAY);
        GridLayout alapalkinlayout = new GridLayout(1,3);
        alapalkki.setLayout(alapalkinlayout);
        
        peliVuorossa = new JLabel("Turn: Player " + logiikka.getPelivuorossa());
        peliVuorossa.setHorizontalAlignment(JLabel.CENTER); 
        
        ristinVoitot = new JLabel(p1 + ": " + logiikka.getRistinVoitot());
        ristinVoitot.setHorizontalAlignment(JLabel.CENTER);
        ristinVoitot.setForeground(Color.BLUE);
        
        ympyranVoitot = new JLabel(p2 + ": " + logiikka.getYmpyranVoitot());
        ympyranVoitot.setHorizontalAlignment(JLabel.CENTER);
        ympyranVoitot.setForeground(Color.red);
        
        alapalkki.add(peliVuorossa);
        alapalkki.add(ristinVoitot);
        alapalkki.add(ympyranVoitot);

        container.add(ylapalkki, BorderLayout.NORTH);
        container.add(pelilautaRuudukko, BorderLayout.CENTER);
        container.add(alapalkki, BorderLayout.SOUTH);
    }

    public void paivita() {
        this.paivitaRuudut();
        if (peliloppui == false) {
            if (logiikka.tarkistaLoppuikoPeli() == true) {
                if (logiikka.tarkistaVoittaja() == 0) {
                    JOptionPane.showMessageDialog(null, "Tie game!");
                    peliLoppui();
                } else {
                    JOptionPane.showMessageDialog(getFrame(), getVoittaja() + " wins!", "Victory!", JOptionPane.INFORMATION_MESSAGE);
                    if (logiikka.tarkistaVoittaja() == 1) {
                        ristinVoitot.setText(p1 + ": " + logiikka.getRistinVoitot());
                    } else {
                        ympyranVoitot.setText(p2 + ": " + logiikka.getYmpyranVoitot());
                    }
                    peliLoppui();
                }
            } else {
                peliVuorossa.setText("Turn: Player " + logiikka.getPelivuorossa());
            }
        }
    }

    public void paivitaRuudut() {
        for (int i = 0; i<9; i++) {
            if (logiikka.getRuudunMerkki(i) == 1) {
                pelilauta[i].setIcon(new ImageIcon("src/resources/risti2.jpg"));
            } else if (logiikka.getRuudunMerkki(i) == 2) {
                pelilauta[i].setIcon(new ImageIcon("src/resources/ympyra2.jpg"));
            } 
        }
    }
    
    public void setPeliLoppui() {
        peliloppui = false;
    }

    
    
    public void tyhjennaPelilauta() {
        for (int i = 0; i<9; i++) {
            pelilauta[i].setIcon(null);
        }
    }
    
    public void peliLoppui() {
        peliloppui = true;
        peliVuorossa.setText("Game over");
    }
    
    public String getVoittaja() {
        if (logiikka.tarkistaVoittaja() == 1) {
            return p1;
        } else {
            return p2;
        }
    }
    
    public JFrame getFrame() {
        return ui;
    }
}
