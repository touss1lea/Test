import javax.swing.*;
/**
 * Décrivez votre classe Ennemy ici.
 *
 * @author Groupe 7
 * @version 16/11/2022
 */
public class Ennemy
{
    private String name;          //The name of the ennemy. Can’t be null. It can contain only characters from A-Z and a-z and characters with accent but no numbers and no special characters. More than 2 characters.
    private String description;   //The description of the ennemy
    private int pvMax;            //the number of maximum pv. Can’t be negative. Can’t be equal to 0. Can’t be more than 100
    private int pv;               //The number of current pv. Can’t be negative. Can’t be upper than PVMax.           
    private Icon ennemyImage;     //Image of the ennemy
    
    /**
     * Constructeur d'objets de classe Ennemy
     * 
     * @param name The name of the ennemy
     * @param description The description of the ennemy
     * @param pvMax The maximum of pv of the ennemy (equals to the pv of the ennemy)
     */
    public Ennemy(String newName, String newDesc, int newPvmax)
    {
        setName(newName);
        pvMax=newPvmax;
        pv=pvMax;
        description=newDesc;
    }

    /**
     * Get the name of the ennemy
     * 
     * @return name The name of the ennemy
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Get the pvMax of the ennemy
     * 
     * @return pvMax The maximum of pv of the ennemy
     */
    public int getPVMax()
    {
        return pvMax;
    }
    
    /**
     * Get the pv of the ennemy
     * 
     * @return pv The current pv of the ennemy
     */
    public int getPV()
    {
        return pv;
    }
    
    /**
     * Get the description of the ennemy
     * 
     * @return description The description of the ennemy
     */
    public String getDescription()
    {
        return description;
    }
    
    
    /**
     * Decrease the number of pv by a number of damage
     * 
     * @param damage The number of damage
     */
    public void decreasePV(int damage)
    {
         if (damage > this.pv){
        this.pv = 0;
        } else {
        this.pv = this.pv - damage;
    }
    }
    
    /**
     * Decrease the number of pv by a number of pv
     * 
     * @param damage The number of pv to add to the pv
     */
    public void increasePV(int heal)
    {
        if (heal + this.pv > this.pvMax){
        this.pv = this.pvMax;
        } else {
        this.pv = this.pv + heal;
        
    }
    }
    
    public String attack(){
    return "";
    }
    
    public void setName(String newName)
    {
        if (newName.length() <= 3)
        {
            newName = "Ennemy";
        }
        name=newName;
    }
    
    public void setPV(int newPv)
    {
        pv = newPv;
    }
    
    public void setPVMax(int newPvMax)
    {
        pvMax = newPvMax;
    }
    
    public void setDescription(String newDesc)
    {
        description = newDesc;
    }
}
