package RistinollaTest;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import Ristinolla.Logiikka;

public class LogiikkaTest {

    private Logiikka testinolla;

    public LogiikkaTest() {
    }

    @Before
    public void setUp() {
        testinolla = new Logiikka();
    }

    /**
     * Aloittaja voittaa pelin vaakarivilla
     */
    public void aloittajaVoittaaVaakarivilla() {
        testinolla.setMerkkiRuutuun(0);
        testinolla.setMerkkiRuutuun(4);
        testinolla.setMerkkiRuutuun(1);
        testinolla.setMerkkiRuutuun(5);
        testinolla.setMerkkiRuutuun(2);
    }

    /**
     * Toisena vuorossa oleva voittaa pelin vaakarivilla
     */
    public void toinenVoittaaVaakarivilla() {
        testinolla.setMerkkiRuutuun(4);
        testinolla.setMerkkiRuutuun(0);
        testinolla.setMerkkiRuutuun(5);
        testinolla.setMerkkiRuutuun(1);
        testinolla.setMerkkiRuutuun(8);
        testinolla.setMerkkiRuutuun(2);
    }

    /**
     * Peli päättyy tasan
     */
    public void tasapeli() {
        testinolla.setMerkkiRuutuun(0);
        testinolla.setMerkkiRuutuun(1);
        testinolla.setMerkkiRuutuun(2);
        testinolla.setMerkkiRuutuun(4);
        testinolla.setMerkkiRuutuun(3);
        testinolla.setMerkkiRuutuun(6);
        testinolla.setMerkkiRuutuun(5);
        testinolla.setMerkkiRuutuun(8);
        testinolla.setMerkkiRuutuun(7);
    }
    
    /**
     * Laudalta puuttuu yksi merkki
     */
    public void kahdeksanMerkkiaLaudalla() {
        testinolla.setMerkkiRuutuun(0);
        testinolla.setMerkkiRuutuun(1);
        testinolla.setMerkkiRuutuun(3);
        testinolla.setMerkkiRuutuun(4);
        testinolla.setMerkkiRuutuun(7);
        testinolla.setMerkkiRuutuun(6);
        testinolla.setMerkkiRuutuun(5);
        testinolla.setMerkkiRuutuun(8);
    }

    /**
     * Tarkistaa pelin tilan ja aloittaa uuden pelin
     */
    public void tarkistaPelintilaJaAloitaUusipeli() {
        testinolla.tarkistaLoppuikoPeli();
        testinolla.uusiPeli();
    }

    /**
     * Aloittaa uuden pelin
     * @param montako montako kertaa aloittaa uuden pelin
     */
    public void uusiPeli(int montako) {
        for (int i = 0; i < montako; i++) {
            testinolla.uusiPeli();
        }
    }

    @Test
    public void uusiPeliNollaaMerkkienMaaran() {
        testinolla.setMerkkiRuutuun(1);
        uusiPeli(1);
        Assert.assertEquals(0, testinolla.getMerkkienMaara());
    }

    @Test
    public void merkkienMaaraAlussaOnOikein() {
        Assert.assertEquals(0, testinolla.getMerkkienMaara());
    }

    @Test
    public void merkkienMaaraKasvaaOikeinYhdella() {
        testinolla.setMerkkiRuutuun(0);
        Assert.assertEquals(1, testinolla.getMerkkienMaara());
    }
    
    @Test
    public void merkkienMaaraKasvaaOikeinUsealla() {
        testinolla.setMerkkiRuutuun(0);
        testinolla.setMerkkiRuutuun(1);
        testinolla.setMerkkiRuutuun(6);
        Assert.assertEquals(3, testinolla.getMerkkienMaara());
    }

    @Test
    public void testaaPeliVuoroToimiiOikeinEkassaPelissa() {
        Assert.assertEquals(1, testinolla.getPelivuorossa());
    }

    @Test
    public void testaaPelivuoroToimiiOikeinEkassaPelissaEnsimmaisenVuoronJalkeen() {
        testinolla.setMerkkiRuutuun(0);
        Assert.assertEquals(2, testinolla.getPelivuorossa());
    }

    @Test
    public void testaaPelivuoroToimiiOikeinEkassaPelissaToisenVuoronJalkeen() {
        testinolla.setMerkkiRuutuun(0);
        testinolla.setMerkkiRuutuun(2);
        Assert.assertEquals(1, testinolla.getPelivuorossa());
    }

    @Test
    public void testaaPelivuoroToimiiOikeinEkassaPelissaViimeisellaVuorolla() {
        kahdeksanMerkkiaLaudalla();
        Assert.assertEquals(1, testinolla.getPelivuorossa());
    }

    @Test
    public void testaaPelivuoroToimiiOikeinTokassaPelissa() {
        uusiPeli(1);
        Assert.assertEquals(2, testinolla.getPelivuorossa());
    }

    @Test
    public void testaaPelivuoroToimiiOikeinTokassaPelissaEnsimmaisenVuoronJalkeen() {
        uusiPeli(1);
        testinolla.setMerkkiRuutuun(0);
        Assert.assertEquals(1, testinolla.getPelivuorossa());
    }

    @Test
    public void testaaPelivuoroToimiiOikeinTokassaPelissaViimeisellaVuorolla() {
        uusiPeli(1);
        kahdeksanMerkkiaLaudalla();
        Assert.assertEquals(2, testinolla.getPelivuorossa());
    }

    @Test
    public void pelinumeroEkassaPelissaYksi() {
        Assert.assertEquals(1, testinolla.pelinumero());
    }

    @Test
    public void uusiPeliKasvattaaPelinumeroa() {
        uusiPeli(1);
        Assert.assertEquals(2, testinolla.pelinumero());
    }

    //  Pelilaudan ulkopuolelle asetettava merkki heittää virheilmoituksen;
    @Test(expected = IllegalArgumentException.class)
    public void pelilaudanUlkopuolelleEiVoiAsettaaMerkkia() {
        testinolla.setMerkkiRuutuun(10);
    }
    
    //  Pelilaudan ulkopuolelle asetettava merkki heittää virheilmoituksen;
    @Test(expected = IllegalArgumentException.class)
    public void pelilaudanUlkopuolelleEiVoiAsettaaMerkkeja() {
        testinolla.setMerkkiRuutuun(-100);
        testinolla.setMerkkiRuutuun(77);
    }
    
    //  Jos ruudussa on jo merkki, ei voida uutta merkkiä asettaa ruutuun;
    @Test(expected = IllegalArgumentException.class)
    public void samaanRuutuunEiVoiLaittaaUseitaMerkkeja() {
        testinolla.setMerkkiRuutuun(0);
        testinolla.setMerkkiRuutuun(0);
        Assert.assertEquals(1, testinolla.getMerkkienMaara());
    }

    //  Jos ruudussa on jo merkki, ei voida uutta merkkiä asettaa ruutuun;
    @Test(expected = IllegalArgumentException.class)
    public void samaanRuutuunEiVoiLaittaaUseitaMerkkeja2() {
        testinolla.setMerkkiRuutuun(0);
        testinolla.setMerkkiRuutuun(1);
        testinolla.setMerkkiRuutuun(8);
        testinolla.setMerkkiRuutuun(8);
        testinolla.setMerkkiRuutuun(0);
        Assert.assertEquals("Merkkejä yhteensä", 3, testinolla.getMerkkienMaara());
        Assert.assertEquals("Merkki ruudussa 0 on väärä", 1, testinolla.getRuudunMerkki(0));
    }

    @Test
    public void testaaVoittoaVaakarivillaAloittajalle() {
        aloittajaVoittaaVaakarivilla();
        Assert.assertEquals(1, testinolla.tarkistaVoittaja());
    }

    @Test
    public void testaaVoittoaPystyrivillaAloittajalle() {
        testinolla.setMerkkiRuutuun(0);
        testinolla.setMerkkiRuutuun(4);
        testinolla.setMerkkiRuutuun(3);
        testinolla.setMerkkiRuutuun(5);
        testinolla.setMerkkiRuutuun(6);
        Assert.assertEquals(1, testinolla.tarkistaVoittaja());
    }

    @Test
    public void testaaVoittoaVinorivillaAloittajalle() {
        testinolla.setMerkkiRuutuun(0);
        testinolla.setMerkkiRuutuun(1);
        testinolla.setMerkkiRuutuun(4);
        testinolla.setMerkkiRuutuun(5);
        testinolla.setMerkkiRuutuun(8);
        Assert.assertEquals(1, testinolla.tarkistaVoittaja());
    }

    @Test
    public void testaaVoittoaVaakarivillaToiselle() {
        toinenVoittaaVaakarivilla();
        Assert.assertEquals(2, testinolla.tarkistaVoittaja());
    }

    @Test
    public void testaaVoittoaPystyrivillaToiselle() {
        testinolla.setMerkkiRuutuun(0);
        testinolla.setMerkkiRuutuun(1);
        testinolla.setMerkkiRuutuun(8);
        testinolla.setMerkkiRuutuun(4);
        testinolla.setMerkkiRuutuun(5);
        testinolla.setMerkkiRuutuun(7);
        Assert.assertEquals(2, testinolla.tarkistaVoittaja());
    }

    @Test
    public void testaaVoittoaVinorivillaToiselle() {
        testinolla.setMerkkiRuutuun(0);
        testinolla.setMerkkiRuutuun(4);
        testinolla.setMerkkiRuutuun(1);
        testinolla.setMerkkiRuutuun(2);
        testinolla.setMerkkiRuutuun(8);
        testinolla.setMerkkiRuutuun(6);
        Assert.assertEquals(2, testinolla.tarkistaVoittaja());
    }

    //  Uudessa pelissä kakkonen aloittaa ja sen tulisi voittaa;
    @Test
    public void testaaVoittoaUudellaPelilla() {
        uusiPeli(1);
        aloittajaVoittaaVaakarivilla();
        Assert.assertEquals(2, testinolla.tarkistaVoittaja());
    }

    //  Kolmannessa pelissä ykkönen aloittaa ja sen tulisi voittaa;
    @Test
    public void testaaVoittoaKahdenPelinJalkeen() {
        uusiPeli(2);
        aloittajaVoittaaVaakarivilla();
        Assert.assertEquals(1, testinolla.tarkistaVoittaja());
    }

    //  Tarkistetaan pelintila kun toinen voittaa
    @Test
    public void tarkistaPelinTilaKunToinenVoittaa() {
        aloittajaVoittaaVaakarivilla();
        Assert.assertEquals(true, testinolla.tarkistaLoppuikoPeli());
    }

    @Test
    public void tarkistaPelinTilaKunSeitsemanMerkkiaLaudalla() {
        testinolla.setMerkkiRuutuun(0);
        testinolla.setMerkkiRuutuun(4);
        testinolla.setMerkkiRuutuun(1);
        testinolla.setMerkkiRuutuun(5);
        testinolla.setMerkkiRuutuun(8);
        testinolla.setMerkkiRuutuun(2);
        testinolla.setMerkkiRuutuun(7);
        Assert.assertEquals(false, testinolla.tarkistaLoppuikoPeli());
    }

    @Test
    public void tarkistaPelinTilaKunYhdeksanMerkkiaLaudalla() {
        tasapeli();
        Assert.assertEquals(true, testinolla.tarkistaLoppuikoPeli());
    }

    //  Risti aloittaa ja voittaa pelin;
    @Test
    public void testaaKasvataVoittoja() {
        aloittajaVoittaaVaakarivilla();
        tarkistaPelintilaJaAloitaUusipeli();
        Assert.assertEquals(1, testinolla.getRistinVoitot());
    }

    @Test
    public void testaaKasvataVoittojaUseassaPelissa() {
        for (int i = 0; i < 3; i++) {
            aloittajaVoittaaVaakarivilla();
            tarkistaPelintilaJaAloitaUusipeli();
        }
        Assert.assertEquals("RistinVoitot", 2, testinolla.getRistinVoitot());
        Assert.assertEquals("YmpyranVoitot", 1, testinolla.getYmpyranVoitot());
    }

    // Pelataan 11 peliä joissa aina aloittaja voittaa, risti 6 ja ympyra 5
    @Test
    public void testaaKasvataVoittojaUseassaPelissa2() {
        for (int i = 0; i < 11; i++) {
            aloittajaVoittaaVaakarivilla();
            tarkistaPelintilaJaAloitaUusipeli();
        }
        Assert.assertEquals("YmpyranVoitot", 5, testinolla.getYmpyranVoitot());
        Assert.assertEquals("RistinVoitot", 6, testinolla.getRistinVoitot());
    }

    @Test
    public void testaaTasapelejaJaVoittojaKunToinenVoittaa() {
        aloittajaVoittaaVaakarivilla();
        tarkistaPelintilaJaAloitaUusipeli();
        tasapeli();
        tarkistaPelintilaJaAloitaUusipeli();
        aloittajaVoittaaVaakarivilla();
        tarkistaPelintilaJaAloitaUusipeli();
        Assert.assertEquals("YmpyranVoitot", 0, testinolla.getYmpyranVoitot());
        Assert.assertEquals("RistinVoitot", 2, testinolla.getRistinVoitot());
    }

    @Test
    public void testaaTasapeliJaVoittojenMaara() {
        tasapeli();
        tarkistaPelintilaJaAloitaUusipeli();
        tasapeli();
        tarkistaPelintilaJaAloitaUusipeli();
        Assert.assertEquals("YmpyranVoitot", 0, testinolla.getYmpyranVoitot());
        Assert.assertEquals("RistinVoitot", 0, testinolla.getRistinVoitot());
    }
    
    @Test
    public void testaaTasapeliJaVoittojenMaaraUseassaPelissa() {
        for (int i = 0; i<100; i++) {
            tasapeli();
            tarkistaPelintilaJaAloitaUusipeli();
        }
        Assert.assertEquals("YmpyranVoitot", 0, testinolla.getYmpyranVoitot());
        Assert.assertEquals("RistinVoitot", 0, testinolla.getRistinVoitot());
    }
    
    
    @Test
    public void testaaVoittoJossaVoittoMahdollisuuksiaUseita() {
        testinolla.setMerkkiRuutuun(0);
        testinolla.setMerkkiRuutuun(1);
        testinolla.setMerkkiRuutuun(2);
        testinolla.setMerkkiRuutuun(5);
        testinolla.setMerkkiRuutuun(8);
        testinolla.setMerkkiRuutuun(7);
        testinolla.setMerkkiRuutuun(6);
        testinolla.setMerkkiRuutuun(3);
        testinolla.setMerkkiRuutuun(4);
        tarkistaPelintilaJaAloitaUusipeli();
        Assert.assertEquals("RistinVoitot", 1, testinolla.getRistinVoitot()); 
    }
}
