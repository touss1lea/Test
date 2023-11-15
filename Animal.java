import java.util.ArrayList;
import javax.swing.*;
/**
 * Décrivez votre classe Animal ici.
 *
 * @author Groupe 7
 * @version 23/11/2022
 */
public class Animal extends Item
{
    private Food alimentation; //The food of the animal

    /**
     * Constructeur d'objets de classe Animal
     * 
     * @param name The name of the animal
     * @param description The description of the animal
     * @param price The price of the animal
     * @param remove if the animal can be removed from the inventory
     * @param food The food associated to the animal
     */
    public Animal(String name,String description, int price, boolean remove, Food food)
    {
        super(name,description,price,remove);
        alimentation=food;
    }
    
    /**
     * Get the food
     * 
     * @return The food associated to the animal
     */
    public Food getAlimentation(){
        return this.alimentation;
    }
}
