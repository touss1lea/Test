import java.util.ArrayList;
import java.util.Random;

/**
 * The ShopEvent class where the player can buy several items with money.
 * 3 items are displayed with their associated price
 *
 * @author Group07
 * @version 22/11/2022
 */
public class ShopEvent extends Event
{
    private static ArrayList<Item> listItem; //The list of items in the shop
    private static ArrayList<Item> listInventory; //The list of item in the inventory of the player
    private int choice; // the integer choice is either equal to 1, 2 or 3 according to the item the player wants to buy
    private Item item1, item2, item3; // the 3 random items the player can buy at the shop
    /**
     * Constructor of the ShopEvent class
     * 
     * @param name The name of the event
     * @param description The description of the event
     */
    public ShopEvent(String name, String description)
    {
        super(name,description);
    }
    
    /**
     *  Method which return a random item. This item cannot be a removable item (it cannot be an animal)
     *  
     *  @return The random item
     */
    public static Item chooseRandomItem()
    {
        Item randomItem = null;
        listItem = Game.getListItem();
        Random rand = new Random();
        int n = rand.nextInt(8);
        randomItem = listItem.get(n);
            
        while (!randomItem.getRemove())
        {
            n = rand.nextInt(8);
            randomItem = listItem.get(n);
        }
        return randomItem;
    }
    
    /**
     * chooseFoodItem method
     * The food the player will need next is return to be displayed in the shop
     * 
     * @return the food item associated
     */
    public static Item chooseFoodItem()
    {
        Item randomItem2 = null;
        listItem = Game.getListItem();
        Random rand2 = new Random();
        
        if (!searchAnimal("Duck") && !searchAnimal("Cat") && !searchAnimal("Monkey") && !searchAnimal("Mole")){
            randomItem2 = Game.getItemByName("Bread");
        }
        else if (searchAnimal("Duck") && !searchAnimal("Cat") && !searchAnimal("Monkey") && !searchAnimal("Mole")){
           randomItem2 = Game.getItemByName("Croquettes");
        }
        else if (searchAnimal("Duck") && searchAnimal("Cat") && !searchAnimal("Monkey") && !searchAnimal("Mole")){
            randomItem2 = Game.getItemByName("Banana");
        }
        else if (searchAnimal("Duck") && searchAnimal("Cat") && searchAnimal("Monkey") && !searchAnimal("Mole")){

            randomItem2 = Game.getItemByName("Worms");
        }
        else {
            while (!randomItem2.getRemove())
            {
                int n = rand2.nextInt(12);
                randomItem2 = listItem.get(n);
            }
            return randomItem2;
        }
        return randomItem2;
    }
    
    /**
     * searchAnimal method
     * 
     * @param String animal, the animal searched in the player's inventory
     * @return True if the player has the animal in his inventory
     */
    public static boolean searchAnimal(String animal)
    {
        listInventory = Player.getInventory();
        for (int i = 0; i < listInventory.size(); i ++)
        {
            if (listInventory.contains(animal))
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * displayItem method
     * Method which display the trade
     */
    public void displayItem()
    {
        item1 = chooseFoodItem();
        item2 = chooseRandomItem();
        item3 = chooseRandomItem();
        
        System.out.println("Welcome to the shop");
        System.out.println("Here are the 3 items I can sell you");
        System.out.println("1 : "+ item1.getName());
        System.out.println("2 : "+ item2.getName());
        System.out.println("3 : "+ item3.getName());
    }
    
    /**
     * Method to buy an item
     * 
     * @param The item to buy
     */
    public static void buyItem(Item item)
    {
        if (Player.getWallet() >= item.getPrice())
        {
            Player.getInventory().add(item);
            Player.addWallet(- item.getPrice()); 
        }
        else
            System.out.println("You don't have enough money");
    }
    
    /**
     * What the event do
     */
    public void action()
    {
        displayItem();
        System.out.println("What article do you wanna buy");
        System.out.println("Enter the corresponding number : 1, 2 or 3");
        switch(getChoice()) {
            case 1:
               buyItem(item1);
            case 2 :
                buyItem(item2);
            case 3 :
                buyItem(item3);
            default :
                System.out.println("Erreur de saisie");
           
        }
    }
    
    /**
     * What the event do
     * Get the choice of the player corresponding to an item
     * 
     * @ return the choice
     */
    public int getChoice()
    {
        return choice;
    }
}