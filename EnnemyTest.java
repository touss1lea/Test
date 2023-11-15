import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class EnnemyTest that will test the class Ennemy.
 *
 * @author Groupe 7
 * @version 16-11-2022
 */
public class EnnemyTest
{
    Ennemy ennemy;

    /**
     * Default constructor for test class ItemTest
     */
    public EnnemyTest()
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
        ennemy = new Ennemy("","",100);
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
    *   Method testPlayerNameShort
    *   Test a player with a shorter name
    *   [expected value] name -> "Ennemy"
    *   [expected value] description -> ""
    *   [expected value] pvMax -> 100
    *   [expected value] pv -> 100
    */
    @Test
    public void testEnnemyNameShort()
    {
        Ennemy ennemyTest = new Ennemy("","",100);
        assertEquals("Ennemy",ennemyTest.getName());
        assertEquals("",ennemyTest.getDescription());
        assertEquals(100,ennemyTest.getPVMax());
        assertEquals(100,ennemyTest.getPV());
    }
    
    /**
    *   Method testEnnemyBadName
    *   Test a player with a number
    *   [expected value] name -> "Ennemy"
    *   [expected value] description -> "Il a 3 yeux"
    *   [expected value] pvMax -> 50
    *   [expected value] pv -> 50
    */
    @Test
    public void testEnnemyBadName()
    {
        Ennemy ennemyTest = new Ennemy("","",100);
        assertEquals("Ennemy",ennemyTest.getName());

    }
    
    /**
     * Method testEnnemyHigherPVMax
     * Test a number of PVMAx > 100
     * [expected value] pvMax ->100
     * [expected value] pv ->100
     */
    @Test
    public void testEnnemyHigherPVMax()
    {
        Ennemy ennemyTest = new Ennemy("","",100);
        assertEquals(100,ennemyTest.getPVMax());
        assertEquals(100,ennemyTest.getPV());
    }
    
    /**
    *   Method testPVIncreased
    *   Test to increase the pv of a player when pv=pvMax
    *   [expected value] pv -> 100
    */
    @Test
    public void testPVIncreased()
    {
        ennemy.increasePV(5);
        assertEquals(100,ennemy.getPV());
    }
    
    /**
    *   Method testPVIncreased
    *   Test to decrease the pv of a player when pv<0
    *   [expected value] pv -> 0
    */
    @Test
    public void testPVDecreased()
    {
        ennemy.decreasePV(200);
        assertEquals(0,ennemy.getPV());
    }

    /**
    *   Method testPVIncreasedLittle
    *   Test to increase the pv of a player when pv=0
    *   [expected value] pv -> 50
    */
    @Test
    public void testPVIncreasedLittle()
    {
        ennemy.decreasePV(ennemy.getPVMax());
        ennemy.increasePV(50);
        assertEquals(50,ennemy.getPV());
    }
    
    /**
    *   Method testPVDecreasedLittle
    *   Test to decrease the pv when pv=50
    *   [expected value] pv -> 45
    */
    @Test
    public void testPVDecreasedLittle()
    {
        ennemy.decreasePV(5);
        assertEquals(95,ennemy.getPV());
    }
}
