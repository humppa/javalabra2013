package Ristinolla;

/**
 * 
 * @author      Paavo Rohamo
 * 
 * Luo ohjelmalle toiminnallisuuden, pelialustan sekä merkit
 * Laskee pelienmäärää, voittojenmäärää sekä pelintilaa
 * Asettaa merkin ruutuun jos se on mahdollista
 */
public final class Logiikka {

    /**
     * Alustaa pelilaudan koon
     */
    private int[] pelialusta = new int [9];
    /**
     * Pelattujen pelien määrä sekä ristin ja ympyran voitot alustetaan nolliksi
     */
    private int pelinumero, ristinVoitot, ympyranVoitot = 0;
    
    /**
     * Konstruktori käynnistää uudenpelin
     */
    public Logiikka() {
        uusiPeli();
    }

    /**
     * Uusipeli alustaa pelilaudan taulukon nolliksi
     * sekä kasvattaa pelattujen pelien määrää yhdellä
     */
    public void uusiPeli() {
        for (int i = 0; i < 9; i++) {
            this.pelialusta[i] = 0;
        }
        pelinumero++;
    }

    /**
     * Tarkistaa kumpi pelaajista on pelivuorosso riippuen siitä kumpi on pelin aloittanut
     * @return palauttaa pelivuorossa olevan pelaajan (1 tai 2)
     */
    public int getPelivuorossa() {
        if (getPelinAloittaja() == 1) {
            if (this.getMerkkienMaara() % 2 == 0) {
                return 1;
            } else {
                return 2;
            }
        } else {
            if (this.getMerkkienMaara() % 2 == 0) {
                return 2;
            } else {
                return 1;
            }
        } 
    }

    /**
     * Tarkistaa kumpi pelaajista on pelinaloittaja kussakin pelissä
     * @return palauttaa pelinaloittajan (1 tai 2)
     */
    public int getPelinAloittaja() {
        if (pelinumero() > 1 && pelinumero() % 2 == 0) {
            return 2;
        } else {
            return 1;
        }
    }
    
    /**
     * Palauttaa pelilaudalla olevien merkkienmäärän
     * vain 1 ja 2 lasketaan merkeiksi
     * @return palauttaa merkkienmäärän
     */
    public int getMerkkienMaara() {
        int merkkeja = 0;
        for (int i = 0; i < 9; i++) {
            if (this.pelialusta[i] == 1 || this.pelialusta[i] == 2) {
                merkkeja++;
            }
        }
        return merkkeja;
    }

    /**
     * Tarkistaa että ruutu on pelilaudan sisäpuolella ja että ruutu on tyhjä
     * ehtojen täyttyessä ruutuun asetetaan pelivuorossa olevan pelaajan merkki
     * @param ruutu johon merkki halutaan asettaa
     */
    public void setMerkkiRuutuun(int ruutu) {
        if (ruutu >= 0 && ruutu < 9) {
            if (tarkistaLoppuikoPeli()) {
                throw new IllegalStateException("");
            } else if(this.pelialusta[ruutu] != 0) {
                throw new IllegalArgumentException("");
            } else {
                this.pelialusta[ruutu] = getPelivuorossa();
            }
        } else {
            throw new IllegalArgumentException("");
        }
    }

    public int getRuudunMerkki(int ruutu) {
        if (ruutu < 9 && ruutu >= 0) {
            return this.pelialusta[ruutu];
        } else {
            throw new IllegalArgumentException("Ruutu on pelialustan ulkopuolella");
        }
    }

    public int tarkistaVoittaja() {
        for (int i = 0; i < 3; i++) {
            if (this.pelialusta[i] != 0 && this.pelialusta[i] == this.pelialusta[i + 3] 
                    && this.pelialusta[i] == this.pelialusta[i + 6]) {
                return this.pelialusta[i];
            }
        }
        
        int x = 0;
        for (int i = 0; i < 3; i++) {
            if (this.pelialusta[x] != 0 && this.pelialusta[x] == this.pelialusta[x + 1] 
                    && this.pelialusta[x] == this.pelialusta[x + 2]) {
                return this.pelialusta[x];
            }
            x = x + 3;
        }
        
        if (this.pelialusta[0] != 0 && this.pelialusta[0] == this.pelialusta[4] 
                && this.pelialusta[0] == this.pelialusta[8]) {
            return this.pelialusta[0];
        }
        
        if (this.pelialusta[2] != 0 && this.pelialusta[2] == this.pelialusta[4] 
                && this.pelialusta[2] == this.pelialusta[6]) {
            return this.pelialusta[2];
        }
        return 0;
    }
    
    public boolean tarkistaLoppuikoPeli() {
        if (getMerkkienMaara() == 9 && tarkistaVoittaja() == 0) {
            return true;
        } else {
            if (tarkistaVoittaja() == 1 | tarkistaVoittaja() == 2) {
                kasvataVoittolaskuria(tarkistaVoittaja());
                return true;
            } else {
                return false;
            }
        }
    }

    public void kasvataVoittolaskuria(int voittaja) {
        if (voittaja == 2) {
            this.ympyranVoitot++;
        } else if (voittaja == 1) {
            this.ristinVoitot++;
        }
    }

    public int getRistinVoitot() {
        return this.ristinVoitot;
    }

    public int getYmpyranVoitot() {
        return this.ympyranVoitot;
    }

    public int pelinumero() {
        return this.pelinumero;
    }
}
