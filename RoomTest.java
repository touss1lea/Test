import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class RoomTest that will test the class Room.
 *
 * @author Groupe 7
 * @version 16-11-2022
 */
public class RoomTest
{
    private Room room1;
    private Room room2;
    private Event event1;

    /**
     * Default constructor for test class RoomTest
     */
    public RoomTest()
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
        room1 = new Room("CLENOM","CLADESCRIPTION",null);
        room2 = new Room("CTLOLLYCTLOLLYCTLOLOCTLOLA","CLADESCRIPTIONDEGUILLAUME",null);
        event1 = new Event("Evenement1","CLEPREMIER");    
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
     * Method testGetName
     *  Test the getName() function
     *  [expected value] name -> "CLENOM"
     */
    @Test
    public void testGetName(){
        assertEquals("CLENOM",room1.getName());
    }
    
    /**
     * Method testGetDescription
     *  Test the getDescription() function
     *  [expected value] description -> "CLADESCRIPTION"
     */
    @Test
    public void testGetDescription(){
        assertEquals("CLADESCRIPTION",room1.getDescription());
    }
   
       /**
     * Method testNullName
     *  Test the name set in the constructor
     *  [expected value] name -> "Basic Room"
     */
    @Test
    public void testNullName(){
        Room room3 = new Room("","CLADESCRIPTION",null);
        assertEquals("Basic Room",room3.getName());
    }
    
    /**
     * Method testLengthName
     *  Test the length of the name in the constructor
     *  [expected value] name -> "Basic Room"
     */
    @Test
    public void testLengthName(){
        Room room3 = new Room("A","CLADESCRIPTION",null);
        assertEquals("Basic Room",room3.getName());
    }
    
    /**
     * Method testNullDescription
     *  Test the description set in the constructor
     *  [expected value] description -> "Not much here"
     */
    @Test
    public void testNullDescription(){
        Room room3 = new Room("Basic Room","",null);
        assertEquals("Not much here",room3.getDescription());
    }
}
   


