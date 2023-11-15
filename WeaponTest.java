import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class WeaponTest that will test the class Weapon.
 *
 * @author  Group 7
 * @version 16-11-2022
 */
public class WeaponTest
{
    private Weapon sword, paper;

    /**
     * Default constructor for test class ItemTest
     */
    public WeaponTest()
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
        sword = new Weapon("Sword","CLAITPETDEGUILLAUME",250,10,true);
        paper = new Weapon("Paper","This is not a weapon",33,-60,true);
    }

    /**
     * Method tearDown()
     *  Tears down the test fixture
     *  Called after every test case method
     */
    @AfterEach
    public void tearDown() // throws java.lang.Exception
    {
    }
    
    /**
    *  Method testConstructor
    *   Test the constructor and getters
    *   [expected value] name -> "Sword"
    *   [expected value] description -> "CLAITPETDEGUILLAUME"
    *   [expected value] number -> 1
    *   [expected value] price -> 250
    */
    @Test
    public void testConstructor(){
        assertEquals("Sword",sword.getName());
        assertEquals("CLAITPETDEGUILLAUME",sword.getDescription());
        assertEquals(250,sword.getPrice());
    }
    
    /**
     * Test the GainHp method with a negative value
     * Should not be possible to eat something that will hurt you
     * [expected value] pvHealed -> 1
     */
    @Test
    public void testNegativDamage(){
        assertEquals(5,paper.getDamage()); 
    }
}