import java.util.Random;
import javax.swing.*;
import java.awt.*;
/**
 * Just a classic and innofenssive alien, with a surprise...
 *
 * @author (LEVELU Paul)
 * @version (22/11)
 */
public class Alien extends Ennemy
{
    /**
    * Constructeur d'objets de classe Alien
    */
    public Alien()
    {
        super("Alien","A tiny alien, like everything else here. It doesn't seems dangerous, you can one-shot him... But you have 1 chance in 100 to die!",6);
        //this.ennemyImage = new ImageIcon(new ImageIcon("image_ennemy/Alien.png").getImage().getScaledInstance(600, 700, Image.SCALE_DEFAULT));//Image of the ennemy

    }

    /**
     * The attack from the alien, that 
     * can 1-Shot the player with 1% chance
     *
     */
    public String attack(){
    Random random = new Random();
    int valeur = random.nextInt(100);
    
    int degat;
    if (valeur ==0) {
        degat = 100;
        return "The Alien just \n executed you ! \n He wasn't \n that innofensive ! ";
    } else {
    degat = 1;
    Player.decreasePV(degat);
    return "The Alien is \n scratching you \n to inflict 1";
    }
}
}