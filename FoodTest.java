

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class FoodTest that will test the class Food.
 *
 * @author Groupe 7
 * @version 16-11-2022
 */
public class FoodTest
{
    private Food pomme, rock;

    /**
     * Default constructor for test class ItemTest
     */
    public FoodTest()
    {
    }

    /**
     * Method setUp()
     *  Sets up the test fixture
     *  Called before every test case method
     */
    @BeforeEach
    public void setUp() // throws java.lang.Exception
    {
        //Initialisez ici vos engagements
        pomme = new Food("Pomme","CLAPOMMEDEGUILLAUME",200,45,true);
        rock = new Food("Rock","Don't eat this",5,-20,true);
    }

    /**
     * Method tearDown()
     *  Tears down the test fixture
     *  Called after every test case method
     */
    @AfterEach
    public void tearDown() // throws java.lang.Exception
    {
        //Libérez ici les ressources engagées par setUp()
    }
    
    /**
     * Test the hp given parameter
     * [expected value] hpGive -> 45
     */
    @Test
    public void testGainHp(){
        assertEquals(45,pomme.getPvHealed()); 
    }
    
    /**
     * Test the GainHp method with a negative value
     * Should not be possible to eat something that will hurt you
     * [expected value] pvHealed -> 1
     */
    @Test
    public void testNegativGainHp(){
        assertEquals(1,rock.getPvHealed()); 
    }
}
