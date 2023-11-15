import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;
/**
 * The Game class that initialize the game
 * 
 * @author Group 7
 * @version 16/11/2022
 */

public class Game extends JFrame
{
    private static ArrayList<Event> evenementsRandom; //The list of random events
    private static ArrayList<Item> listItem;    //List of the items
    private static ArrayList<Animal> listAnimal;//List of animals
    private static ArrayList<String> listRandomEnnemies;        //List of random ennemies
    private static Room startRoom;  //The starting room                                  
    
    /**
     * Create the game and initialise its internal map.
     */
    public static void newGame() 
    {
        Player.resetPlayer();
        initializeItem();
        initializeEventRandom();
        initializeRoom();
        initializeEnnemies();
        System.out.println(""+Player.getRoom().getName());
        
        //AddItem and loop to test the program
        Player.addItem(getItemByName("Bow"));
        Weapon arme = Player.getWeaponFromInventory("Bow");
        Player.setWeapon(arme);
        Player.addWallet(100);
    }
    
    /**
     * Initialization of the rooms
     * 
     * Create the rooms and set the exits
     */
    public static void initializeRoom(){
        Event findDuck = new AnimalEvent("FindDuck","Congrat you find the duck",getAnimalByName("Duck"));
        Event findCat = new AnimalEvent("FindCat","Congrat you find the cat",getAnimalByName("Cat"));
        Event findMole = new AnimalEvent("FindMole","Congrat you find the mole",getAnimalByName("Mole"));
        Event findMonkey = new AnimalEvent("FindMonkey","Congrat you find the monkey",getAnimalByName("Monkey"));
        Event shop = new ShopEvent("Shop","You are in the shop ! Do you want to buy something ? ");
        Event finalBoss = new Event("FinalBoss","You are in the last room let's fight the final boss");
        Event startEvent = new Event("StartRoomEvent","You are in the crash zone.");
        
        
        startRoom = new Room("StartRoom","Zone d'atterrissage",startEvent);
        Room finalRoom = new Room("FinalRoom","Zone de decollage",finalBoss);
        
        Room duckRoom = new Room("DuckRoom","C'est le canard coin-coin.",findDuck);
        Room catRoom = new Room("CatRoom","Miaou miaou je suis le chat ahahah miaou.",findCat);
        Room monkeyRoom = new Room("MonkeyRoom","Oulala des bananes",findMonkey);
        Room moleRoom = new Room("MoleRoom","Gratte gratte gratte",findMole);
        
        Room shopRoom = new Room("ShopRoom","Viens depenser ta thune.",shop);
        
        Room r1 = new RandomRoom("room1","Random Room",null);
        Room r2 = new RandomRoom("room2","Random Room",null);
        Room r3 = new RandomRoom("room3","Random Room",null);
        Room r4 = new RandomRoom("room4","Random Room",null);
        Room r5 = new RandomRoom("room5","Random Room",null);
        Room r6 = new RandomRoom("room6","Random Room",null);
        
        
        startRoom.getExits().put(Cardinality.NORTH,r1);
        startRoom.getExits().put(Cardinality.SOUTH,r2);
        startRoom.getExits().put(Cardinality.EAST,shopRoom);
        startRoom.getExits().put(Cardinality.WEST,r4);
        
        r1.getExits().put(Cardinality.SOUTH,startRoom);
        r1.getExits().put(Cardinality.EAST,duckRoom);
        
        duckRoom.getExits().put(Cardinality.WEST,r1);
        
        shopRoom.getExits().put(Cardinality.WEST,startRoom);
        
        r2.getExits().put(Cardinality.NORTH,startRoom);
        r2.getExits().put(Cardinality.SOUTH,r3);
        
        r3.getExits().put(Cardinality.NORTH,r2);
        r3.getExits().put(Cardinality.EAST,monkeyRoom);
        r3.getExits().put(Cardinality.WEST,moleRoom);
        
        moleRoom.getExits().put(Cardinality.EAST,r3);
        monkeyRoom.getExits().put(Cardinality.WEST,r3);
        
        r4.getExits().put(Cardinality.WEST,r5);
        r4.getExits().put(Cardinality.EAST,startRoom);
        
        r5.getExits().put(Cardinality.NORTH,catRoom);
        r5.getExits().put(Cardinality.EAST,r4);
        r5.getExits().put(Cardinality.WEST,r6);
        
        r6.getExits().put(Cardinality.EAST,r5);
        r6.getExits().put(Cardinality.SOUTH,finalRoom);
        
        catRoom.getExits().put(Cardinality.SOUTH,r5);
        
        finalRoom.getExits().put(Cardinality.NORTH,r6);
        
        Player.setRoom(startRoom);
    }
 
    /**
     * Initialization of the ennemies
     * 
     * Create ennemies and add to the list
     */
     public static void initializeEnnemies(){
        listRandomEnnemies = new ArrayList<String>();
        listRandomEnnemies.add("Alien"); 
        listRandomEnnemies.add("Mortarion"); 
        listRandomEnnemies.add("Angron"); 
        listRandomEnnemies.add("Perturabo"); 
        listRandomEnnemies.add("Konrad Curze");
        listRandomEnnemies.add("Lorgar"); 
        
    }

    /**
     * Method to initialise events
     * 
     * Instantiation of the events and fill the event list
     */
    public static void initializeEventRandom(){
        evenementsRandom = new ArrayList<Event>();
        evenementsRandom.add(new Event("Fight","It's time for THE BAGGARE."));
        evenementsRandom.add(new Event("LuckyEvent","Ho ! that's nice you found a free apple."));
        evenementsRandom.add(new Event("UnluckyEvent","Ho ! you felt in the bush."));
        evenementsRandom.add(new Event("Trap","You are in a trap ! You return to the crash zone."));
    }
    
    /**
     * Method to initialize items
     * 
     * Instantiation of the items and fill the item list
     */
    public static void initializeItem()
    {
        
        listItem = new ArrayList<Item>();
        listAnimal = new ArrayList<Animal>();
        
        listItem.add(new Weapon("Laser Gun", "A simple blaster like others in the galaxy", 200,15,true));
        listItem.add(new Weapon("Terrian Bazooka", "Like in human cinematography, a bazooka is always destructive !", 200,20,true));
        listItem.add(new Weapon("Plasma bean generator","Cast a laser bean at 1 million celsius degree",300, 50,true));
        listItem.add(new Weapon("Bow","A medieval bow, why is it on Drarig ?",100, 12,true));
        
        Food croq = new Food("Croquettes", "Cat's food", 10, 5, true);
        Food banana = new Food("Banana", "Monkey's food", 10, 5, true);
        Food worms = new Food("Worms", "Mole's food", 10, 5, true);
        Food bread = new Food("Bread", "Duck's food", 10, 5, true);
        listItem.add(croq);
        listItem.add(banana);
        listItem.add(worms);
        listItem.add(bread);
        
        listAnimal.add(new Animal("Cat", "this is the cat", 0,false,croq));
        listAnimal.add(new Animal("Monkey", "this is the monkey", 0,false,banana));
        listAnimal.add(new Animal("Mole", "this is the mole", 0,false,worms));
        listAnimal.add(new Animal("Duck", "the is the duck", 0,false,bread));
    }
    
    /**
     * Get the list of the items
     * 
     * @return The list of the items
     */
    public static ArrayList<Item> getListItem()
    {
        return listItem;
    }
    
    /**
     * Get the list of the ennemies
     * 
     * @return The list of the ennemies
     */
    public static ArrayList<String> getListRandomEnnemies(){
        return listRandomEnnemies;
    }    
    
    /**
     * Get the list of the events
     * 
     * @return The list of the events
     */
    public static ArrayList<Event> getEventList()
    {
        return evenementsRandom;
    }
    
    /**
     * Get the starting room
     * 
     * @return The starting room
     */
    public static Room getStartRoom()
    {
        return startRoom;
    }
    
    /**
     * Method to get a specific animal by it name
     * 
     * @return Animal researched by name
     */
    public static Animal getAnimalByName(String nom){
        for(Animal a : listAnimal){
            if (nom.equals(a.getName())){
                return a;
            }
        }
        return null;
    }
    
    /**
     * Method to get a specific item by it name
     * 
     * @return Item researched by name
     */
    public static Item getItemByName(String nom){
        for(Item i : listItem){
            if (nom.equals(i.getName())){
                return i;
            }
        }
        return null;
    }
}
