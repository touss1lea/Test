import java.util.Random;
import javax.swing.*;
import java.awt.*;
/**
 * Décrivez votre classe Angron ici.
 *
  * @author Group07
 * @version 22/11/2022 v1
 */

public class Angron extends Ennemy
{
    private int compteur =3;//Counter that allows you to know where Angron is, at 3 it is far away it can not attack you.

    /**
     * Constructeur d'objets de classe Angron
     */
    public Angron()
    {
        super("Angron","Angron is protected by a gladiator armor and wearing a cape of shiny rings encrusted with skulls.  His main characteristics are bravery and anger. He can attack only if he is in front of you,his number of damages and between 15 and 35. ",20);
        //this.ennemyImage = new ImageIcon (new ImageIcon("image_ennemy/Angron.png").getImage().getScaledInstance(600, 700, Image.SCALE_DEFAULT));//Image of the ennemy
        
    }

    /**
     * Angron attack method, he attacks with his points his number of damages and between 15 and 35. 
     * He can attack only if he is in front of you. 
     * With each attack if it gets closer until it is within your reach.
     * Nothing happens if the enemy is far away, if he is in front of the player the player loses a random number of damage.
     */
    public String attack()
    {
        if (compteur ==3) {
        compteur--;
        return "He is running \n on you, but he \n is still a long \n  way off";
    }
        else if (compteur ==2 ){
        compteur--;
        return "He is getting \n  closer!";            
    } 
         else if (compteur == 1 ){
        compteur--;
        return "He is almost \n on you !!";
    }   
        else {
        Random random = new Random(); 
        int value = random.nextInt(16)+20; //random to shoot damage between 15 and 35
        Player.decreasePV(value);
        return "Angron is on your \n melee range ! His big axe \n  is swinging on you to  \n deal " + value + " dammages !";
    }      
            
    }
        
    }