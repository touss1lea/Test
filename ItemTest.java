import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class ItemTest that will test the class Item.
 *
 * @author  Group 7
 * @version 16-11-2022
 */
public class ItemTest
{
    Food item1;
    Weapon item2;
    Animal item3;

    /**
     * Default constructor for test class ItemTest
     */
    public ItemTest()
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
        item1 = new Food("Test Food","Desc",-70, 2, true);    
        item2 = new Weapon("Test Weapon 2","",100,2,true);
        item3 = new Animal("I","This is a long and very onteresting description with a mistake", 6, false, item1);
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
    *   Method testItemConstructor
    *   Tests the constructor and getters
    *   [expected value] name -> "Item Test"
    *   [expected value] number -> 1
    */
    @Test
    public void testItemConstructor()
    {
        assertEquals("Test Food",item1.getName());
        assertEquals("Desc",item1.getDescription());
    }

    /**
    *   Method testItemBadName
    *   Test an item with bad caracter (2)
    *   [expected value] name -> "Unknown"
    *   [expected value] number -> 5
    */
    @Test
    public void testItemBadName()
    {
        assertEquals("Unknown",item2.getName());
    }

    /**
    *   Method testItemShortName
    *   Test an item with a name too short (2 letters)
    *   [expected value] name -> "Unknown"
    *   [expected value] number -> 6
    */
    @Test
    public void testItemShortName()
    {
        assertEquals("Unknown",item3.getName());
    }
    
    /**
    *   Method testGetPrice
    *   Test the getter of the price
    *   [expected value] price -> 100
    */
    @Test
    public void testGetPrice(){
        assertEquals(100, item2.getPrice());
    }

    /**
    *   Method testPriceNegative
    *   Test an item with a negative price
    *   [expected value] price -> 0
    */
    @Test
    public void testPriceNegative(){
        assertEquals(100, item1.getPrice());
    }
    
    /**
    *   Method testItemShortDescription
    *   Test an item with a description too short (2 letters)
    *   [expected value] description -> "Everything is in the title"
    *   [expected value] number -> 6
    */
    @Test
    public void testItemShortDescription()
    {
        assertEquals("Everything is in the title",item2.getDescription());
        assertEquals("This is a long and very onteresting description with a mistake",item3.getDescription());
    }
}

