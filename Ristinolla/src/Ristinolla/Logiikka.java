package Ristinolla;

public final class Logiikka {

    private int[] pelialusta = new int [9];
    private int pelinaloittaja, pelinumero, ristinVoitot, ympyranVoitot = 0;
    
    public Logiikka() {
        uusiPeli();
    }

    public void uusiPeli() {
        for (int i = 0; i < 9; i++) {
            this.pelialusta[i] = 0;
        }
        pelinumero++;
        this.pelinaloittaja = getPelinAloittaja();
    }

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

    public int getPelinAloittaja() {
        if (pelinumero() > 1 && pelinumero() % 2 == 0) {
            return 2;
        } else {
            return 1;
        }
    }
    public int getMerkkienMaara() {
        int merkkeja = 0;
        for (int i = 0; i < 9; i++) {
            if (this.pelialusta[i] == 1 || this.pelialusta[i] == 2) {
                merkkeja++;
            }
        }
        return merkkeja;
    }

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
        if (this.getMerkkienMaara() < 5) {
            return 0;
        } else {
            return tarkistaPystyrivit() + tarkistaVaakarivit() + tarkistaVinorivit();
        }
    }
    
    public int tarkistaPystyrivit() {
        for (int i = 0; i < 3; i++) {
            if (this.pelialusta[i] != 0 && this.pelialusta[i] == this.pelialusta[i + 3] && this.pelialusta[i] == this.pelialusta[i + 6]) {
                return this.pelialusta[i];
            }
        }
        return 0;
    }
    
    public int tarkistaVaakarivit() {
        int x = 0;
        for (int i = 0; i < 3; i++) {
            if (this.pelialusta[x] != 0 && this.pelialusta[x] == this.pelialusta[x + 1] && this.pelialusta[x] == this.pelialusta[x + 2]) {
                return this.pelialusta[x];
            }
            x = x + 3;
        }
        return 0;
    }
    
    public int tarkistaVinorivit() {
        if (this.pelialusta[0] != 0 && this.pelialusta[0] == this.pelialusta[4] && this.pelialusta[0] == this.pelialusta[8]) {
            return this.pelialusta[0];
        }
        if (this.pelialusta[2] != 0 && this.pelialusta[2] == this.pelialusta[4] && this.pelialusta[2] == this.pelialusta[6]) {
            return this.pelialusta[2];
        }
        return 0;
    }

    public boolean tarkistaLoppuikoPeli() {
        if (getMerkkienMaara() == 9) {
            return true;
        } else {
            if (tarkistaVoittaja() == 1 || tarkistaVoittaja() == 2) {
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
