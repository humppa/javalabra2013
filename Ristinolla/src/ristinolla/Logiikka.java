package ristinolla;

public class Logiikka {

    private int[] pelialusta;
    private int pelinaloittaja;
    private int merkkienMaara;

    public Logiikka() {
        merkkienMaara = 0;
        pelinaloittaja = 0;
        pelialusta = new int[9];
        uusiPeli();
    }
    
    public void uusiPeli() {       
        for (int i=0; i<pelialusta.length; i++) {
            pelialusta[i] = 0;
        }
        if (pelinaloittaja == 1) {
            pelinaloittaja = 2;
        } else if (pelinaloittaja == 2 ) {
            pelinaloittaja = 1;
        } else {
            pelinaloittaja = 1;
        }
    }
    
    public int getPeliVuorossa() {
        if (pelinaloittaja == 1) {
            if (merkkienMaara % 2 == 0) {
                return 2;
            } else {
                return 1;
            }
        } else if (pelinaloittaja == 2) {
            if (merkkienMaara % 2 == 0) {
                return 1;
            } else {
                return 2;
            }
        } else {
            return pelinaloittaja;
        }
    }
    
    public int merkkienMaara() {
        for (int i=0; i<pelialusta.length; i++) {
            if (pelialusta[i] == 1 || pelialusta[i] == 2) {
                merkkienMaara++;
            }
        }
        return merkkienMaara;
    }
    
    
}
