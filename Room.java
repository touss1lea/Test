import java.util.HashMap;
import java.util.Set;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.ArrayList;
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
public class Room 
{
    private String description;                 //The description of the room
    private String name;                        //The description of the name. It cannot contain only characters from A-Z and a-z and characters with accent but no numbers and no special characters. More than 2 characters
    private HashMap<Cardinality, Room> exits;   //The exists of the room
    private Event event;                        //The event of the room
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * 
     * @param name The room's name
     * @param description The room's description.
     * @param event The event of the room
     */
    public Room(String name, String description, Event event) 
    {
        setDescription(description);
        setName(name);
        this.event = event;
        exits = new HashMap<>();
    }
        
    /**
     * Method leaveRoom: returns the room that we reach in the given direction
     * If there is no room in that direction, returns null
     *
     * @param direction The exit's direction
     * @return The room in the given direction
     * 
     */
    public Room leaveRoom(String direction){
        String S = ""; 
        Scanner reader = new Scanner(System.in);
        
        for(Cardinality c : this.exits.keySet()){
            S += (c+":"+selectRoom(c).getName()+"\n");
        }
        //System.out.println(S);
        //String input = reader.nextLine();

        //System.out.println(input);
        for(Cardinality c : this.exits.keySet()){
            if (c.toString().equals(direction)){
                if(name=="room3"&& direction.equals("WEST")|direction.equals("EAST")){  
                    if(Player.checkItemInInventoryByName("Duck")){
                            return (selectRoom(c));
                    }
                }
                else if(name=="StartRoom" && direction.equals("WEST")){  
                    if(Player.checkItemInInventoryByName("Monkey")){
                            return (selectRoom(c));
                    }
                }
                else if(name=="room5"&& direction.equals("NORTH")){  
                    if(Player.checkItemInInventoryByName("Mole")){
                            return (selectRoom(c));
                    }
                }
                else if(name=="room6"&& direction.equals("SOUTH")){  
                    if(Player.checkItemInInventoryByName("Cat")){
                            return (selectRoom(c));
                    }
                }
               else return(selectRoom(c)); 
            }
        }
        return null;
    }
    
    /**
     * Method to get the exists hashmap
     * 
     * @return The hashmap with directions and rooms associed
     */
    public HashMap<Cardinality, Room> getExits(){
             return this.exits;
    }
        
    /**
     * Get the description of the room
     * 
     * @return description The description of the room.
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * Get the event of the room
     * 
     * @return event The event of the room.
     */
    public Event getEvent()
    {
        return event;
    }
    
    /**
     * Get the name of the room
     * 
     * @return name The name of the room.
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Get the room to set up the new current room
     * 
     * @ return the room
     */
    public Room selectRoom(Cardinality card)
    {
        return exits.get(card);
    }
    
    /**
     * Set a new event to the room
     * 
     * @param event The new event
     */
    public void setEvent(Event event)
    {
        this.event=event;
    }
    
    /**
     * The action to do when the player enter in the room
     * 
     * @param events The list of random events
     */
    public void activeEvent(ArrayList<Event> events)
    {
        if (event != null)
        {
            event.action();
        }
    }
    
    private void setName(String newName)
    {
        if (newName.length() <= 3)
        {
            newName = "Basic Room";
        }
        name=newName;
    }
    
    private void setDescription(String newDesc)
    {
        if (newDesc.length() <= 3)
        {
            newDesc = "Not much here";
        }
        description=newDesc;
    }
}