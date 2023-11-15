import java.util.Random;
import java.util.ArrayList;

/**
 * 
 * Modified versions
 * 
 * @author Groupe 7
 *
 * @version 16/11/2022
 * This is our Class Room. It will allow us to create new rooms. A room will
 * be described with : a name, a description, a hashpmap to create link bet
 * ween rooms, an event. 
 *  */
public class RandomRoom extends Room
{
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * 
     * @param name The name of the room
     * @param description The room's description.
     * @param event The event associed to the room
     */
    public RandomRoom(String name, String description,Event event) 
    {
        super(name,description,event);
    }
    
    /**
     * Set a random event to the room
     * 
     * @param The list of random events
     */
    public void activeEvent(ArrayList<Event> events)
    {
        Random rand = new Random(); 
        int rEvent = rand.nextInt(events.size());
        setEvent(events.get(rEvent));
        getEvent().action();
    }
}