import java.util.ArrayList;
import javax.swing.*;
/**
 * Décrivez votre classe Weapons ici.
 *
 * @author Group 7
 * @version 16/11/2022
 */
public class Weapon extends Item
{
    private int damage;
    /**
     * Constructeur d'objets de classe Weapons
     * 
     * @param name The name of the weapon
     * @param description The description of the weapon
     * @param price The price of the weapon
     * @param damage The damage deals by this weapon
     * @param remove if the animal can be removed from the inventory
     */
    public Weapon(String name,String description,int price,int damage,boolean remove)
    {
        super(name,description,price,remove);
        setDamage(damage);
    }

    /**
     * The damages that the weapon do
     * 
     * @return The number of damages deal
     */
    public int UseWeapon(){
        return damage;
    }
    
    public int getDamage()
    {
        return this.damage;
    }
    
    public void setDamage(int damage)
    {
        if (damage < 0)
            this.damage = 5;
        else
            this.damage = damage;
    }
}
