import java.util.Random;
import javax.swing.*;
import java.awt.*;
/**
 * Décrivez votre classe Perturabo ici.
 *
 * @author Group7
 * @version 22/11/2022 v1
 */
public class Perturabo extends Ennemy
{
    private int playerBurned =0;//Counter that allows you to know where Perturabo is, at 3 it is far away it can not attack you.

    /**
     * Constructeur d'objets de classe Perturabo
     */
    public Perturabo()
    {
        super("Perturabo","Perturabo is a military genius, able to bring down any fortress with his techniques, he  has 3 different type of attack flamethrower,submachine, rocket launcher, its attack is random.",30);
        //this.ennemyImage =new ImageIcon(new ImageIcon("image_ennemy/Perturabo.png").getImage().getScaledInstance(600, 700, Image.SCALE_DEFAULT));//Image of the ennemy
    }

    /**
     * Perturabo attack method, It has 3 different type of attack, its attack is random.
     * He can attack with a Flamethrower, a machine gun and a rocket launcher.
     * The flamethrower causes 1 damage and burns the player for 3 turns.
     * The submachine gun hits the player with 5 bullets. Causing 1 damage with each bullet.
     * The Rocket launcher 1 in 4 risk of being hit, if the player is hit he loses 15% of his life max.
     */
    public String attack()
    {

        Random random = new Random();  //random to choose the weapon of the ennemy
        String début ="";
        int value = random.nextInt(3);

        switch(value){
    
            case 0 : 
            //The player receives 1 burn damage but remains burnt for 3 turns.
            Player.decreasePV(1);
            
            playerBurned=3;
            début = "Flamethrower mode activated :\n  You are burned ! \n You will receive \n 3 dammage each turns .";
            break;
            
            case 1 : 
            //the player is hit by 5 machine gun bullets and loses 1 damage per bullet.
            for (int i=0; i < 5; i++) {
            Player.decreasePV(1);
            }
            début = "Machine gun mode  activated : \n you are getting shot 5 \n times to deal 1 dammage each !";
            break;
        
            case 2 : 
            //The rocket launcher has a 25% chance of hitting the player. If he is hit, he loses 15% of his PVmax damage.
            int touch = random.nextInt(4); 
            début = "Rocket launcher activated";
            if (touch ==3) {
                Player.decreasePV(Player.getPVMax()*15/100);     
            }
            else{  début = début +"\n Perturbo missed ! \n You have not been \n  hit by the rocket";
            }
            break;
        
        };
         
        //if the player is burned he loses two damage
        if (playerBurned > 0){
        Player.decreasePV(2);
        playerBurned--;

        return début +"\nYou have lost two HP from the burn";
        } else {
        return début;
        }
        
        }
    
    /**
     * Perturabo is armored, so he reduce damage inflicted by 2.
     */
    public void decreasePV(int damage)
    {
    if (damage > 2)
    { // prevent heal if damage = 1 or 0
        System.out.println("Perturabo is armored ! \n  He reduce your \n damage by 2");
        damage = damage -2;
    }
        
         if (damage > getPV()){
        setPV(0);
        } else {
        setPV(getPV()-damage);
    }
    }
}