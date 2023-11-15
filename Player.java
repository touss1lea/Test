import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import javax.swing.*;
/**
 * Décrivez votre classe Player ici.
 *
 * @author Groupe 11
 * @version 16/11/2022
 */

public class Player

{   
    private static  String name;                //the name of the player. Length minimum : 3 letters. By default : Name is “Eon�?.
    private static  Room room;                  //the room where the player is. No more than 1 room, not less than 1
    private static  ArrayList<Item> inventory = new ArrayList<Item>();  //the list of the items of the inventory. Can be empty.
    
    private static final int PVMAX = 100;            //the number of maximum pv. Can’t be negative. Can’t be equal to 0. Can’t be more than 100.
    
    private static  int pv = 100;               //the current number of pv. Can’t be negative. Can’t be upper than PVMax.
    private static  int wallet = 0;             //the amount of money the player currently have
    private static  Weapon weapon = null;       //the current weapon. If it is null, it considers that the player is using his fists, without object instantiated. No more than 1 weapon equipped
    private static boolean willDodge = false;   //the boolean if the player dodge or not
    private static Ennemy ennemy;               //The ennemy in fight
    private static boolean endOfFight = false;  // Allow to detect the end of the fight
    
    /**
     * Constructeur d'objets de classe Player
     * 
     * @param name The name of the player
     */
    public Player(String name)
    {
        setName(name);
        inventory = new ArrayList<Item>();
        pv = PVMAX;
    }

    /**
     * Set the current room to the player.
     * 
     * @param currentRoom The new room to set to the player.
     */
    public static  void setRoom(Room currentRoom)
    {
        room=currentRoom;
    }
    
    // /**
     // * Set a new number of pvmax
     // * 
     // * @param newPVMax the new number of pvMax
     // */
    // public static  void setPVMax(int newPVMax)
    // {
        // if (newPVMax > 100)
            // pvMax = 100;
        // else if (newPVMax <= 0)
            // pvMax = 1;
        // else
            // pvMax = newPVMax;
    // }
    
    /**
     * Set a new number of pvmax
     * 
     * @param weapon the new number of weapon
     */
    public static void setWeapon(Weapon theItem){
        weapon = theItem;
    }
    
    /**
     * Get the current room of the player.
     * 
     * @return the current room
     */
    public static Room getRoom()
    {
        return room;
    }
    
    /**
     * Get the name of the player
     * 
     * @return name The name
     */
    public static String getName()
    {
        return name;
    }
    
    /**
     * Get the pvMax of the player
     * 
     * @return pvMax The maximum of pv
     */
    public static int getPVMax()
    {
        return PVMAX;
    }
    
    /**
     * Get the pv of the player
     * 
     * @return pv The number of pv
     */
    public static int getPV()
    {
        return pv;
    }
    
    /**
     * Get the weapon of the player
     * 
     * @return weapon The current weapon
     */
    public static Weapon getPlayerWeapon()
    {
        return weapon;
    }
    
    /**
     * Check if an item is present in the inventory
     * 
     * @param item The Item to check
     * @return boolean true if the object is present, else false
     */
    public static boolean checkItemInInventory(Item item)
    {
        if (inventory.contains(item))
            return true;
        else
            return false;
    }
    
    public  static boolean checkItemInInventoryByName(String nom){
        for(Item i : inventory){
            if (nom.equals(i.getName())){
                return true;
            }
        }
        return false;
    }
    
    public static Item getItemFromInventory(String name){
    for(Item search : inventory){
         if (search.getName() == name) {
             return search;
         }else {
         System.out.println("No such item in inventory");
        }
    }
    return null;
    }
    
    public static Weapon getWeaponFromInventory(String name){
    for(Item search : inventory){
         if (search instanceof Weapon){
             if (search.getName() == name){
                 return (Weapon)search;
             }
        }
        
    }
    System.out.println("No such item in inventory");
    return null;
    }
    
    /**
     * Add an item to the invetory.
     * Stock the item if the name are identical
     * 
     * @param item The item to add to the inventory
     */
    public static void addItem(Item item)
    {
        inventory.add(item);
    }
    
    /**
     * Use an item if this item is usable
     * 
     * @param item The item to use
     */
    public static void useItem(Item item)
    {
        
    }
    
    /**
     * Remove all the specified item
     * 
     * @param item The item to remove
     */
    public static void removeItem(Item item)
    {
        if (inventory.contains(item))
            inventory.remove(item);
        else
            System.out.println("There is no such item in the inventory");
    }   
    
    /**
     * Decrease the pv by a specific number of damage
     * 
     * @param damage The number of damage
     */
    public static void decreasePV(int damage)
    {
        if (willDodge == false) {
            if (damage >= pv){
                pv = 0;
                System.out.println("Outch");
            } else 
            {
                pv = pv - damage;
                System.out.println("You have lost " + Integer.toString(damage) + " ! ");
            }
        }  
        else 
        {
            System.out.println ("Le joueur esquive l'attaque !");
            willDodge = false;
        }
    }
    
    /**
     * Method allows the player to dodge
     */
    public static void prepareDodge()
    {
        willDodge = true;
        System.out.println ("Le joueur se prépare à esquiver !");
    }
    
    public static Ennemy getEnnemy()
    {
        return ennemy;
    }
    
    /**
     * Set the ennemy in front of the player during a fight
     * 
     * @param lennemy The ennemy during the fight
     */
    public static void setEnnemy(Ennemy lennemy)
    {
        ennemy = lennemy;
    }

     // /**
     // * Determine the action of the player during a fight. 
     // * The action is determined randomly
     // * 
     // */
    // public static int actionFight(){
            // Random random = new Random();
            // int action = random.nextInt(4);
            
            

            // switch (action){
                // //attack
                // case 1 : 
                    // int degat;
                    // Weapon transitoire = Player.getPlayerWeapon();
                    // if (transitoire == null)
                    // { degat = 50; 
                      // ennemy.decreasePV(50);
                    // } else {
                        // degat = Player.weapon.UseWeapon();
                        // ennemy.decreasePV(degat);
                    // }
                    // return degat;
                // }}
                    
    /**
     * Determine the action of the player during a fight
     * @param Action = the action of the player, called by actionlisteners. 
     * 1 = Dammages, 2 = Prepare for a dodge, 3 = Heal
     * 
     */
    public static int actionFight(int action){
            switch (action){
                //attack
                case 1 : 
                    int degat;
                    Weapon transitoire = Player.getPlayerWeapon();
                    if (transitoire == null)
                    { degat = 50; 
                      ennemy.decreasePV(50);
                    } else {
                        degat = Player.weapon.UseWeapon();
                        ennemy.decreasePV(degat);
                    }
                    return degat;
                //dodge
                case 2 : Player.prepareDodge(); return 0;
                //pray
                case 3 : int valueHeal =Player.pray();
                    Player.increasePV(valueHeal); 
                    return valueHeal;
                    
                default: break;
               
            }
        return -1;
    }
    
    public static boolean getEndOfFight(){
    return endOfFight;
    }
    
    public static void setEndOfFight(boolean bool){
     endOfFight = bool;
    }
    
    /**
     * Method allow the player to pray
     * 
     * @return val The value to add to is current HP
     */
    public static int pray()
    {
        Random random = new Random();
        int val = random.nextInt(15)+1;
        return val;
    }
    
    /**
     * Increase the pv by a specific number of damage
     * 
     * @param heal The number of pv to add
     */
    public static void increasePV(int heal)
    {
        if (heal + pv > PVMAX)
        {
            pv = PVMAX;
        } 
        else 
        {
            pv = pv + heal;
        }    
    }

    /**
     * Set up the new room for the player
     * Depends on the direction you chose to move
     */
    public static void changeRoom(String direction)
    {
        Room roomA = getRoom().leaveRoom(direction);
        if(roomA!=null){
            setRoom(roomA);
            getRoom().activeEvent(Game.getEventList());
        }
    }
    
    /** 
     * Displays the inventory
     * 
     * @param ArrayList inventory  
     */
    public static void displayInventory() 
    {
    for (Item i : inventory)
        {
            System.out.println(i.getName()); 
        }
    }
    
    /**
     * Method to get the inventory
     * 
     * @return The list of the items in the inventory
     */
    public static ArrayList<Item> getInventory()
    {
        return inventory;   
    }
    
    /**
     * Get the number of coins
     * 
     * @return The number of coins
     */
    public static int getWallet()
    {
        return wallet;
    }
    
    /**
     * Set the number of coins
     * 
     * @param The number of coins wanted
     */
    public static void addWallet(int n)
    {
        wallet +=n;
    }
    
    public static void setName(String newName)
    {
        if (newName.length() <= 3)
        {
            newName = "Eon";
        }
        name=newName;
    }
    
    public static String changeWeapon ()
    {
   
    ArrayList<Item> ownedWeapons = new ArrayList<Item>();
     for(Item search : inventory){ // Get the list of items in the player inventory
         if (search instanceof Weapon){ 
            ownedWeapons.add(search);
            }
        }
        
        String currentWeaponName = Player.getPlayerWeapon().getName();
        String nameNewWeapon = " ";
        if (ownedWeapons.size() == 1){ // If we only have one weapon in the list
        return "You are already equipped of the only weapon you have !";
        } else { // if we have multiple weapon in the list
        int localisation = 0;
        for(Item search : ownedWeapons){ //get the location ofthe item inside the list of weapons
             if (search.getName() == currentWeaponName){
                localisation = ownedWeapons.indexOf(search);
                break;
             }
        }
        
        if (localisation +1 == ownedWeapons.size())// if we are at the end of the list
        {  nameNewWeapon = ownedWeapons.get(0).getName();
        } else {
            nameNewWeapon = ownedWeapons.get(localisation +1).getName();
        }
    
}
Player.setWeapon(getWeaponFromInventory(nameNewWeapon));
return "You are now equipped \n of your "+ nameNewWeapon+" !";
}
    
    public static void resetPlayer()
    {
        inventory = new ArrayList<Item>();
        wallet=0;
        pv=PVMAX;
    }
}