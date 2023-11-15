import java.util.Random;
import javax.swing.*;
import java.awt.*;
/**
 * Décrivez votre classe Mortarion ici.
 *
 * @author (Groupe07)
 * @version (21/11/2022)
 */
public class Mortarion extends Ennemy
{
    private int currentDamage =1;//Counter that allows to see the number of turn passed, increasing the power of Mortarion through time .

    /**
     * Constructeur d'objets de classe Mortarion
     */
    public Mortarion()
    {
        super("Mortarion","Mortarion Lord of putrefaction, decay and death. He was raised in a world of mechanical horrors where humans were hunted like animals. In his world everything slowly and inexorably decays, and only Mortarion remains eternal. With each attack it inflicts 3 additional damages",100);
        //this.ennemyImage = new ImageIcon(new ImageIcon("image_ennemy/Mortarion.png").getImage().getScaledInstance(600, 700, Image.SCALE_DEFAULT));
    }

    /**
     * Mortarion attack method.
     * He gain power each turn ( damage rising by 3 )
     */
    public String attack()
    {
        Player.decreasePV(currentDamage);
        currentDamage = currentDamage+3;
        return "Mortarion attack you \n  to deal " + currentDamage+ " \n dammages !";
            
    }
        
}

