
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ristinolla.Logiikka;



public class LogiikkaTest {
    
    public LogiikkaTest() {
    }
    
    
    @Before
    public void setUp() {
        
    }
    
    @Test
    public void merkkienMaaraAlussaOnOikein() {
        Logiikka testinolla = new Logiikka();
        Assert.assertEquals(0, testinolla.merkkienMaara());
    }
    
    @Test
    public void merkkienMaaraKasvaaOikeinYhdella() {
        Logiikka testinolla = new Logiikka();
        
        Assert.assertEquals(1, testinolla.merkkienMaara());
    }
    
    @Test
    public void testaaPeliVuoroToimiiOikein() {
        
    }
}
