

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class PlayerTest that will test the class Player.
 *
 * @author Groupe 7
 * @version 16-11-2022
 */
public class PlayerTest
{
    /**
     * Default constructor for test class ItemTest
     */
    public PlayerTest()
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
        Player p = new Player("Eon");
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
    *   [expected value] name -> "Eon"
    */
    @Test
    public void testPlayerNameShort()
    {
        Player.setName("f");
        assertEquals("Eon",Player.getName());
    }
    
    /**
    *   Method testPlayerRoom
    *   Test the room of a player
    *   [expected value] room.getName() -> "Room Test"
    */
    @Test
    public void testPlayerRoom()
    {
        Room roomTest = new Room("Room Test", "SALLEGUILLAUME",null);
        Player.setRoom(roomTest);
        assertEquals("Room Test",Player.getRoom().getName());
    }
    
    /**
    *   Method testPVIncreased
    *   Test to increase the pv of a player when pv=pvMax
    *   [expected value] pv -> 100
    */
    @Test
    public void testPVIncreased()
    {
        Player.increasePV(5);
        assertEquals(100,Player.getPV());
    }
    
    /**
    *   Method testPVIncreased
    *   Test to decrease the pv of a player when pv<0
    *   [expected value] pv -> 0
    */
    @Test
    public void testPVDecreased()
    {
        Player.decreasePV(200);
        assertEquals(0,Player.getPV());
    }
    
    /**
    *   Method testPVDecreasedLittle
    *   Test to decrease the pv when pv=50
    *   [expected value] pv -> 45
    */
    @Test
    public void testPVDecreasedLittle()
    {
        Player.decreasePV(50);
        Player.decreasePV(5);
        assertEquals(45,Player.getPV());
    }
    
    
    /**
    *   Method testPVMax
    *   Test to change the pvMax
    *   [expected value] pvMax -> 20
    */
    @Test
    public void testPVMax()
    {
        assertEquals(100,Player.getPVMax());
    }
    
    /**
    *   Method testWeapon
    *   Test to change the weapon
    *   [expected value] weapon.getName() -> "Epee"
    */
    @Test
    public void testWeapon()
    {
        Weapon weap = new Weapon("Epee","CUNEEPEE",200, 20,true);
        Player.setWeapon(weap);
        assertEquals("Epee",Player.getPlayerWeapon().getName());
    }
    
   /**
    *   Method testWeapon
    *   Test if the player has an object in is inventory but the object is not here
    *   [expected value] inInventory -> false
    */
    @Test
    public void testPlayerNoItem()
    {
       Food itemTest = new Food("Test Food","",1, 2, true);    
       assertEquals(false,Player.checkItemInInventory(itemTest));
    }
    
    /**
    *   Method testWeapon
    *   Test if the player has an object in is inventory and the object is here
    *   [expected value] inInventory -> true
    */
    @Test
    public void testPlayerItems()
    {
       Player player1 = new Player("Eon");
       Food itemTest = new Food("Test Food","",1, 2, true);    
       Player.addItem(itemTest);    
       assertEquals(true,Player.checkItemInInventory(itemTest));
    }
}
