import java.util.Random;
import javax.swing.*;
import java.awt.*;
/**
 * Lorgar is the herectic priest from Drarig. He is able to heal Himself and enter in a divine mode.
 *
  * @author Paul LEVELU
 * @version 22/11/2022 v1
 */


public class Lorgar extends Ennemy
{
    private int timeHealed =0;//Counter check the number of time Lorgar healed himself to avoid infinite Heal

    /**
     * Constructeur d'objets de classe Lorgar
     */
    public Lorgar()
    {
        super("Lorgar","Lorgar is the herectic priest from Drarig. He is able to heal Himself and enter in a divine mode. H can attack and heal himself. After 5 heals, he is entering in divine mode and only strike the player but stronger than ever",30);
        //this.ennemyImage = new ImageIcon(new ImageIcon("image_ennemy/Lorgar.png").getImage().getScaledInstance(600, 700, Image.SCALE_DEFAULT)); //Image of the ennemy
        
    }

    /**
     * Lorgar attack method, he can attack and heal himself:
     * After 5 heals, he is entering in divine mode and only strike the player, but stronger than ever
     */
    public String attack()
    {   
        //Check if Lorgar is on divine mode
        if (timeHealed < 5){
        
        //Randomize the action of lorgar
        Random random = new Random();
        int valeur = random.nextInt(2);
        
        if (valeur == 0 ){
        Random random2 = new Random();
        int heal = random2.nextInt(13)+1; //Heal is a random number between 1 and 13
        this.increasePV(heal);
        timeHealed++; //Increase the number of time when Lorgar Healed
        return "Lorgar is \n  praying his \n heretic God : \n He is healing \n " + Integer.toString(heal) + " and gain his divine power !";
        
        } else {
            //Lorgar basic attack       
        Player.decreasePV(5);
        return "Lorgar is \n attacking to \n inflict 5 !";
        }} else { // If lorgar is on divine mode
        //Lorgar divine attack
        Player.decreasePV(Player.getPV()*40/100);
        return "Lorgar is on \n divine mode ! \n He is burning \n your soul to \n make you lose \n 40 % of your current HP !";
        }
    }
        
    }
