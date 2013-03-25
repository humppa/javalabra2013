
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ristinolla.Logiikka;



public class LogiikkaTest {
    
    private Logiikka testinolla;
    
    public LogiikkaTest() {
        
    }
    
    @Before
    public void setUp() {
        testinolla = new Logiikka();
    }
    
    @Test
    public void uusiPeliNollaaMerkkienMaaran() {
        testinolla.setMerkkiRuutuun(1);
        testinolla.uusiPeli();
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
        for(int i=0; i<8; i++) {
            testinolla.setMerkkiRuutuun(i);
        }
        Assert.assertEquals(1, testinolla.getPelivuorossa());
    }
    
    @Test
    public void testaaPelivuoroToimiiOikeinTokassaPelissa() {
        testinolla.uusiPeli();
        Assert.assertEquals(2, testinolla.getPelivuorossa());
    }
    
    @Test
    public void testaaPelivuoroToimiiOikeinTokassaPelissaEnsimmaisenVuoronJalkeen() {
        testinolla.uusiPeli();
        testinolla.setMerkkiRuutuun(0);
        Assert.assertEquals(1, testinolla.getPelivuorossa());
    }
    
    @Test
    public void testaaPelivuoroToimiiOikeinTokassaPelissaViimeisellaVuorolla() {
        testinolla.uusiPeli();
        for(int i=0; i<8; i++) {
            testinolla.setMerkkiRuutuun(i);
        }
        Assert.assertEquals(2, testinolla.getPelivuorossa());
    }
    
    @Test
    public void PelinumeroEkassaPelissaYksi() {
       Assert.assertEquals(1, testinolla.pelinumero());
    }
    
    @Test
    public void uusiPeliKasvattaaPelinumeroa() {
        testinolla.uusiPeli();
        Assert.assertEquals(2, testinolla.pelinumero());
    }
    
    @Test
    public void samaanRuutuunEiVoiLaittaaUseitaMerkkeja() {
        testinolla.setMerkkiRuutuun(0);
        testinolla.setMerkkiRuutuun(0);
        Assert.assertEquals(1, testinolla.getMerkkienMaara());
    }
    
    @Test
    public void samaanRuutuunEiVoiLaittaaUseitaMerkkeja2() {
        testinolla.setMerkkiRuutuun(0);
        testinolla.setMerkkiRuutuun(1);
        testinolla.setMerkkiRuutuun(8);
        testinolla.setMerkkiRuutuun(8);
        testinolla.setMerkkiRuutuun(0);
        Assert.assertEquals(3, testinolla.getMerkkienMaara());
    }
    
    @Test
    public void testaaVoittoaVaakarivillaAloittajalle() {
        testinolla.setMerkkiRuutuun(0);
        testinolla.setMerkkiRuutuun(4);
        testinolla.setMerkkiRuutuun(1);
        testinolla.setMerkkiRuutuun(5);
        testinolla.setMerkkiRuutuun(2);
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
        testinolla.setMerkkiRuutuun(4);
        testinolla.setMerkkiRuutuun(0);
        testinolla.setMerkkiRuutuun(5);
        testinolla.setMerkkiRuutuun(1);
        testinolla.setMerkkiRuutuun(8);
        testinolla.setMerkkiRuutuun(2);
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
    
    // Uudessa pelissä kakkonen aloittaa ja sen tulisi voittaa;
    @Test
    public void testaaVoittoaUudellaPelilla() {
        testinolla.uusiPeli();
        testinolla.setMerkkiRuutuun(0);
        testinolla.setMerkkiRuutuun(4);
        testinolla.setMerkkiRuutuun(1);
        testinolla.setMerkkiRuutuun(5);
        testinolla.setMerkkiRuutuun(2);
        Assert.assertEquals(2, testinolla.tarkistaVoittaja());
    }
    
    // Kolmannessa pelissä ykkönen aloittaa ja sen tulisi voittaa;
    @Test
    public void testaaVoittoaKahdenPelinJalkeen() {
        testinolla.uusiPeli();
        testinolla.uusiPeli();
        testinolla.setMerkkiRuutuun(0);
        testinolla.setMerkkiRuutuun(4);
        testinolla.setMerkkiRuutuun(1);
        testinolla.setMerkkiRuutuun(5);
        testinolla.setMerkkiRuutuun(2);
        Assert.assertEquals(1, testinolla.tarkistaVoittaja());
    }
    
    @Test
    public void tarkistaPelinTilaKunToinenVoittaa() {
        testinolla.setMerkkiRuutuun(0);
        testinolla.setMerkkiRuutuun(4);
        testinolla.setMerkkiRuutuun(1);
        testinolla.setMerkkiRuutuun(5);
        testinolla.setMerkkiRuutuun(2);
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
        testinolla.setMerkkiRuutuun(0);
        testinolla.setMerkkiRuutuun(1);
        testinolla.setMerkkiRuutuun(2);
        testinolla.setMerkkiRuutuun(4);
        testinolla.setMerkkiRuutuun(3);
        testinolla.setMerkkiRuutuun(6);
        testinolla.setMerkkiRuutuun(5);
        testinolla.setMerkkiRuutuun(8);
        testinolla.setMerkkiRuutuun(7);
        Assert.assertEquals(true, testinolla.tarkistaLoppuikoPeli());
    }
 }
