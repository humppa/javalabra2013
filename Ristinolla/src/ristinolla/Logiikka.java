package ristinolla;

public final class Logiikka {

    private int[] pelialusta;
    private int pelinaloittaja;
    private int merkkienMaara;
    private int pelinumero;
    private int ristinVoitot;
    private int ympyranVoitot;

    public Logiikka() {
        this.ristinVoitot = 0;
        this.ympyranVoitot = 0;
        this.pelinumero = 0;
        this.merkkienMaara = 0;
        this.pelinaloittaja = 0;
        this.pelialusta = new int[9];
        uusiPeli();
    }

    public void uusiPeli() {
        for (int i = 0; i < pelialusta.length; i++) {
            this.pelialusta[i] = 0;
        }
        if (pelinumero == 0) {
            this.pelinaloittaja = 1;
        } else {
            if (this.pelinaloittaja == 1) {
                this.pelinaloittaja = 2;
            } else if (this.pelinaloittaja == 2) {
                this.pelinaloittaja = 1;
            } else if (this.pelinaloittaja == 0) {
                this.pelinaloittaja = 1;
            }
        }
        pelinumero++;
    }

    public int getPelivuorossa() {
        if (this.getMerkkienMaara() < 0) {
            return this.pelinaloittaja;
        } else if (this.getMerkkienMaara() == 1) {
            if (this.pelinaloittaja == 1) {
                return 2;
            } else {
                return 1;
            }
        }

        if (this.pelinaloittaja == 1) {
            if (this.getMerkkienMaara() % 2 == 0) {
                return 1;
            } else {
                return 2;
            }
        } else if (this.pelinaloittaja == 2) {
            if (this.getMerkkienMaara() % 2 == 0) {
                return 2;
            } else {
                return 1;
            }
        } else {
            return this.pelinaloittaja;
        }
    }

//    public int getPelinAloittaja() {
//        if (pelinumero > 1 && pelinumero % 2 == 0) {
//            return 2;
//        } else {
//            return 1;
//        }
//    }
    public int getMerkkienMaara() {
        int merkkeja = 0;
        for (int i = 0; i < this.pelialusta.length; i++) {
            if (this.pelialusta[i] == 1 || this.pelialusta[i] == 2) {
                merkkeja++;
            }
        }
        return merkkeja;
    }

    public void setMerkkiRuutuun(int ruutu) {
        if (this.pelialusta[ruutu] == 0) {
            if (ruutu >= 0 && ruutu < 9) {
                if (getPelivuorossa() == 1) {
                    this.pelialusta[ruutu] = 1;
                } else {
                    this.pelialusta[ruutu] = 2;
                }
            } else {
                throw new IllegalArgumentException("Ruudun tulee olla ruudukon sisällä");
            }
        } else {
            throw new IllegalArgumentException("Ruudussa on jo merkki");
        }
    }

    public int getRuudunMerkki(int ruutu) {
        if (this.pelialusta[ruutu] == 0 || ruutu < 9 || ruutu >= 0) {
            return this.pelialusta[ruutu];
        } else {
            throw new IllegalArgumentException("");
        }
    }

    public int tarkistaVoittaja() {
        if (this.getMerkkienMaara() < 5) {
            return 0;
        }
        int x = 0;
        for (int i = 0; i < 3; i++) {
            //  Tarkistaa pystyrivit
            if (this.pelialusta[i] != 0 && this.pelialusta[i] == this.pelialusta[i + 3] && this.pelialusta[i] == this.pelialusta[i + 6]) {
                return this.pelialusta[i];
            }
            //  Tarkistaa vaakarivit
            if (this.pelialusta[x] != 0 && this.pelialusta[x] == this.pelialusta[x + 1] && this.pelialusta[x] == this.pelialusta[x + 2]) {
                return this.pelialusta[x];
            }
            x = x + 3;
        }
        //  Tarkistaa vinorivin oikeelta ylhaalta vasemmalle alas
        if (this.pelialusta[0] != 0 && this.pelialusta[0] == this.pelialusta[4] && this.pelialusta[0] == this.pelialusta[8]) {
            return this.pelialusta[0];
        }
        //  Tarkistaa vinorivin vasemmalta alhaalta oikealle ylos
        if (this.pelialusta[0] != 0 && this.pelialusta[2] == this.pelialusta[4] && this.pelialusta[2] == this.pelialusta[6]) {
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
        if (voittaja == 1) {
            this.ristinVoitot++;
        } else if (voittaja == 2) {
            this.ympyranVoitot++;
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
