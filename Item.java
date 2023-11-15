import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
/**
 * Décrivez votre classe Item ici.
 *
 * @author Group 7
 * @version 16/11/2022
 */
public abstract class Item
{
    private String name;        //the name of the item. It can not contain only characters from A-Z and a-z and characters with accents but no numbers and no special characters. Else the name is Eon. More than 2 characters. Cannot be negative.
    private String description; //the description of the item
    private int price;          //the price of the item. Cannot be negative
    private boolean remove;     // if TRUE the item can be deleted from the inventory, if FALSE it cannot
    /**
     * Constructeur d'objets de classe Item
     * 
     * @param name The name of the item
     * @param description The description of the item
     * @param price The price of the item
     */
    public Item(String name, String description,int price, boolean remove)
    {
        setName(name);
        setDescription(description);
        setPrice(price);
        this.remove=remove;
    }
    
    /**
     * Get the name of the item
     * 
     * @return name The name of the item.
     */
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        boolean isDigit = false;
        if (name.length() <= 2)
        {
            this.name = "Unknown";
        }
        else
        {
            for (int i = 0; i < name.length(); ++i) 
            {
                if (Character.isDigit(name.charAt(i))) 
                {
                    isDigit = true;
                }
            }
            if (!isDigit)
                this.name=name;
            else
                this.name = "Unknown";
        }
    }
    
    /**
     * Get the description of the item
     * 
     * @return description The description of the item.
     */
    public String getDescription()
    {
        return description;
    }
    
    public void setDescription(String description)
    {
        if (description.length()<= 2)
            this.description = "Everything is in the title";
        else
            this.description = description;
    }
    
    /**
     * Get the price of the item
     * 
     * @return price The price of the item
     */
    public int getPrice(){
        return this.price;
    }
    
    public void setPrice(int price)
    {
        if(price<0)
        {
            this.price = 100;
        }
        else
            this.price = price;
    }
    
    /**
     * Method used to know if the item can be removed from the inventory
     * 
     * @return remove The boolean if the item can be removed from the inventory
     */
    public boolean getRemove()
    {
        return this.remove;
    }
}
