import java.util.ArrayList;
import javax.swing.*;
/**
 * The food is a special item that can heal the player if he wants to consume it. 
 * Also, certain type of food are necessary to allow animals to cross obstacles
 *
 * @author Group 7
 * @version 16/11/2022
 */
public class Food extends Item
{
    private int pvHealed; //The pv if the player eat the food
    
    /**
     * Constructeur d'objets de classe Food
     * 
     * @param name The name of the item
     * @param description The description of the food
     * @param price The price of the food
     * @param hp The number of hp given if the player eat the food
     */
    public Food(String name,String description,int price,int hp, boolean remove)
    {
        super(name,description,price,remove);
        setPvHealed(hp);
    }

    /**
     * Get the pv given to the player
     * 
     * @return pvH Give The number of pv the food heals
     */
    public int getPvHealed(){
        return this.pvHealed;
    }
    
    public void setPvHealed(int hp){
        if (hp < 0)
            this.pvHealed = 1;
        else 
            this.pvHealed = hp;
    }
    
}
