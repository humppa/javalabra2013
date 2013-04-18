/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ristinolla;

/**
 *
 * @author      rohamo
 * @since       18.04.2013
 */
public class AI {
    
    private Logiikka ai;
    
    public AI(Logiikka logiikka) {
        this.ai = logiikka;
    }

    public int getSiirto() {
        // Vaakarivien voittosiirrot
        if (ai.getRuudunMerkki(0) == 2 && ai.getRuudunMerkki(1) == 2 && ai.getRuudunMerkki(2) == 0) {
            return 2;
        } else if (ai.getRuudunMerkki(3) == 2 && ai.getRuudunMerkki(4) == 2 && ai.getRuudunMerkki(5) == 0) {
            return 5;
        } else if (ai.getRuudunMerkki(6) == 2 && ai.getRuudunMerkki(7) == 2 && ai.getRuudunMerkki(8) == 0) {
            return 8;
        }
        
        else if (ai.getRuudunMerkki(0) == 2 && ai.getRuudunMerkki(2) == 2 && ai.getRuudunMerkki(1) == 0) {
            return 1;
        } else if (ai.getRuudunMerkki(3) == 2 && ai.getRuudunMerkki(5) == 2 && ai.getRuudunMerkki(4) == 0) {
            return 4;
        } else if (ai.getRuudunMerkki(6) == 2 && ai.getRuudunMerkki(8) == 2 && ai.getRuudunMerkki(7) == 0) {
            return 7;
        }
        
        else if (ai.getRuudunMerkki(1) == 2 && ai.getRuudunMerkki(2) == 2 && ai.getRuudunMerkki(0) == 0) {
            return 0;
        } else if (ai.getRuudunMerkki(4) == 2 && ai.getRuudunMerkki(5) == 2 && ai.getRuudunMerkki(3) == 0) {
            return 3;
        } else if (ai.getRuudunMerkki(7) == 2 && ai.getRuudunMerkki(8) == 2 && ai.getRuudunMerkki(6) == 0) {
            return 6;
        }
        
        // Pystyrivien voittosiirrot
        else if (ai.getRuudunMerkki(0) == 2 && ai.getRuudunMerkki(3) == 2 && ai.getRuudunMerkki(6) == 0) {
            return 6;
        } else if (ai.getRuudunMerkki(1) == 2 && ai.getRuudunMerkki(4) == 2 && ai.getRuudunMerkki(7) == 0) {
            return 7;
        } else if (ai.getRuudunMerkki(2) == 2 && ai.getRuudunMerkki(5) == 2 && ai.getRuudunMerkki(8) == 0) {
            return 8;
        } 
        
        else if (ai.getRuudunMerkki(0) == 2 && ai.getRuudunMerkki(6) == 2 && ai.getRuudunMerkki(3) == 0) {
            return 3;
        } else if (ai.getRuudunMerkki(1) == 2 && ai.getRuudunMerkki(7) == 2 && ai.getRuudunMerkki(4) == 0) {
            return 4;
        } else if (ai.getRuudunMerkki(2) == 2 && ai.getRuudunMerkki(8) == 2 && ai.getRuudunMerkki(5) == 0) {
            return 5;
        } 
        
        else if (ai.getRuudunMerkki(3) == 2 && ai.getRuudunMerkki(6) == 2 && ai.getRuudunMerkki(0) == 0) {
            return 0;
        } else if (ai.getRuudunMerkki(4) == 2 && ai.getRuudunMerkki(7) == 2 && ai.getRuudunMerkki(1) == 0) {
            return 1;
        } else if (ai.getRuudunMerkki(5) == 2 && ai.getRuudunMerkki(8) == 2 && ai.getRuudunMerkki(2) == 0) {
            return 2;
        }  
        
        // Vinorivien voittosiirrot
        else if (ai.getRuudunMerkki(0) == 2 && ai.getRuudunMerkki(4) == 2 && ai.getRuudunMerkki(8) == 0) {
            return 8;
        } else if (ai.getRuudunMerkki(0) == 2 && ai.getRuudunMerkki(8) == 2 && ai.getRuudunMerkki(4) == 0) {
            return 4;
        } else if (ai.getRuudunMerkki(4) == 2 && ai.getRuudunMerkki(8) == 2 && ai.getRuudunMerkki(0) == 0) {
            return 0;
        }
        
        else if (ai.getRuudunMerkki(2) == 2 && ai.getRuudunMerkki(4) == 2 && ai.getRuudunMerkki(6) == 0) {
            return 6;
        } else if (ai.getRuudunMerkki(0) == 2 && ai.getRuudunMerkki(6) == 2 && ai.getRuudunMerkki(4) == 0) {
            return 4;
        } else if (ai.getRuudunMerkki(4) == 2 && ai.getRuudunMerkki(6) == 2 && ai.getRuudunMerkki(2) == 0) {
            return 2;
        } 
        
        
        // Vaakarivien puolustus
        if (ai.getRuudunMerkki(0) == 1 && ai.getRuudunMerkki(1) == 1 && ai.getRuudunMerkki(2) == 0) {
            return 2;
        } else if (ai.getRuudunMerkki(3) == 1 && ai.getRuudunMerkki(4) == 1 && ai.getRuudunMerkki(5) == 0) {
            return 5;
        } else if (ai.getRuudunMerkki(6) == 1 && ai.getRuudunMerkki(7) == 1 && ai.getRuudunMerkki(8) == 0) {
            return 8;
        }
        
        else if (ai.getRuudunMerkki(0) == 1 && ai.getRuudunMerkki(2) == 1 && ai.getRuudunMerkki(1) == 0) {
            return 1;
        } else if (ai.getRuudunMerkki(3) == 1 && ai.getRuudunMerkki(5) == 1 && ai.getRuudunMerkki(4) == 0) {
            return 4;
        } else if (ai.getRuudunMerkki(6) == 1 && ai.getRuudunMerkki(8) == 1 && ai.getRuudunMerkki(7) == 0) {
            return 7;
        }
        
        else if (ai.getRuudunMerkki(1) == 1 && ai.getRuudunMerkki(2) == 1 && ai.getRuudunMerkki(0) == 0) {
            return 0;
        } else if (ai.getRuudunMerkki(4) == 1 && ai.getRuudunMerkki(5) == 1 && ai.getRuudunMerkki(3) == 0) {
            return 3;
        } else if (ai.getRuudunMerkki(7) == 1 && ai.getRuudunMerkki(8) == 1 && ai.getRuudunMerkki(6) == 0) {
            return 6;
        }
        
        // Pystyrivien puolustus
        else if (ai.getRuudunMerkki(0) == 1 && ai.getRuudunMerkki(3) == 1 && ai.getRuudunMerkki(6) == 0) {
            return 6;
        } else if (ai.getRuudunMerkki(1) == 1 && ai.getRuudunMerkki(4) == 1 && ai.getRuudunMerkki(7) == 0) {
            return 7;
        } else if (ai.getRuudunMerkki(2) == 1 && ai.getRuudunMerkki(5) == 1 && ai.getRuudunMerkki(8) == 0) {
            return 8;
        } 
        
        else if (ai.getRuudunMerkki(0) == 1 && ai.getRuudunMerkki(6) == 1 && ai.getRuudunMerkki(3) == 0) {
            return 3;
        } else if (ai.getRuudunMerkki(1) == 1 && ai.getRuudunMerkki(7) == 1 && ai.getRuudunMerkki(4) == 0) {
            return 4;
        } else if (ai.getRuudunMerkki(2) == 1 && ai.getRuudunMerkki(8) == 1 && ai.getRuudunMerkki(5) == 0) {
            return 5;
        } 
        
        else if (ai.getRuudunMerkki(3) == 1 && ai.getRuudunMerkki(6) == 1 && ai.getRuudunMerkki(0) == 0) {
            return 0;
        } else if (ai.getRuudunMerkki(4) == 1 && ai.getRuudunMerkki(7) == 1 && ai.getRuudunMerkki(1) == 0) {
            return 1;
        } else if (ai.getRuudunMerkki(5) == 1 && ai.getRuudunMerkki(8) == 1 && ai.getRuudunMerkki(2) == 0) {
            return 2;
        }
        
        // Vinorivien puolustus
        else if (ai.getRuudunMerkki(0) == 1 && ai.getRuudunMerkki(4) == 1 && ai.getRuudunMerkki(8) == 0) {
            return 8;
        } else if (ai.getRuudunMerkki(0) == 1 && ai.getRuudunMerkki(8) == 1 && ai.getRuudunMerkki(4) == 0) {
            return 4;
        } else if (ai.getRuudunMerkki(4) == 1 && ai.getRuudunMerkki(8) == 1 && ai.getRuudunMerkki(0) == 0) {
            return 0;
        }
        
        else if (ai.getRuudunMerkki(2) == 1 && ai.getRuudunMerkki(4) == 1 && ai.getRuudunMerkki(6) == 0) {
            return 6;
        } else if (ai.getRuudunMerkki(0) == 1 && ai.getRuudunMerkki(6) == 1 && ai.getRuudunMerkki(4) == 0) {
            return 4;
        } else if (ai.getRuudunMerkki(4) == 1 && ai.getRuudunMerkki(6) == 1 && ai.getRuudunMerkki(2) == 0) {
            return 2;
        }
        
        // Vinorivien riskitilanteet
        else if (ai.getRuudunMerkki(0) == 1 && ai.getRuudunMerkki(4) == 2 && ai.getRuudunMerkki(8) == 1) {
            return 5;
        } else if (ai.getRuudunMerkki(2) == 1 && ai.getRuudunMerkki(4) == 2 && ai.getRuudunMerkki(6) == 1) {
            return 3;
        }
        
        // Ekat siirrot
        else if (ai.getRuudunMerkki(4) == 0) {
            return 4;
        } else if (ai.getRuudunMerkki(0) == 0) {
            return 0;
        }
        
        // 
        else {
            return 9;
        }
    }
}
