

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class EventTest that will test the class Event.
 *
 * @author Groupe 7
 * @version 16-11-2022
 */
public class EventTest
{
    private Event event1;

    /**
     * Default constructor for test class EventTest
     */
    public EventTest()
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
        event1 = new Event("AttaqueDeGuillaume","Guillaume est en colère il passe à l'attaque");
        
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
     *  [expected value] name -> "AttaqueDeGuillaume"
     */
    @Test
    public void testGetName(){
        assertEquals("AttaqueDeGuillaume", event1.getName());
    }
    
    /**
     * Method testGetDescription
     *  Test the getDescription() function
     *  [expected value] description -> "Guillaume est en colère il passe à l'attaque"
     */
    @Test
    public void testGetDescription(){
        assertEquals("Guillaume est en colère il passe à l'attaque", event1.getDescription());
    }
}
