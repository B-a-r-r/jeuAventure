package jeuaventure;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import jeuaventure.JeuAventure;

/**
 *
 * @author tcastillo
 */
public class TestJeuAventure {
    
    @Test
    public void testJeuDevin_nbMax(){
        assertEquals(10,JeuAventure.jeuDevin_nbMax(1));
        assertEquals(50,JeuAventure.jeuDevin_nbMax(2));
        assertEquals(100,JeuAventure.jeuDevin_nbMax(3));
    }
    
    @Test
    public void testJeuDevin_nbCoupMax(){
        assertEquals(5,JeuAventure.jeuDevin_nbCoupsMax(1));
        assertEquals(10,JeuAventure.jeuDevin_nbCoupsMax(2));
        assertEquals(10,JeuAventure.jeuDevin_nbCoupsMax(3));
        
    }
    
    @Test
    public void testJeuSuite_correction(){
        assertEquals('t', JeuAventure.jeuSuite_formeCorrecte(1));
        assertEquals('c', JeuAventure.jeuSuite_formeCorrecte(2));
        assertEquals('c', JeuAventure.jeuSuite_formeCorrecte(3));
    }
}


