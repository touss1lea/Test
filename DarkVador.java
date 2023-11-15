import java.util.Random;
import javax.swing.*;
import java.awt.*;
/**
 * Décrivez votre classe DarkVador ici.
 *
 * @author Group07
 * @version 22/11/2022 v1
 */
public class DarkVador extends Ennemy
{
    private boolean prepareAttack=false;//boolean to know if DarkVador is planning an attack
    private boolean willDodge = false;//boolean to know if the attack is dodged
    /**
     * Constructeur d'objets de classe DarkVador
     */
    public DarkVador()
    {
        super("Dark Vador","Dark Vador crowned Jedi knight then Sith lord, he is the final boss. It has 4 attack types : prepare an attack,make a small attack, dodge the attack and heal himself. After defeating this enemy you win the game!",90);
        //this.ennemyImage = new ImageIcon(new ImageIcon("image_ennemy/DarkVador.png").getImage().getScaledInstance(600, 700, Image.SCALE_DEFAULT));//Image of the ennemy
    }
    /**
     * DarkVador attack method.It has 4 attack types.
     * he can prepare an attack to do more damage next turn..
     * He can make a small attack and lose 7 damage.
     * He can dodge the attack.
     * He can heal himself by 5 pV.
     */
    
        public String attack()
        {
            //if he has not prepared his attack he chooses among different attacks
            if (prepareAttack==false){
            Random random = new Random();  //random to choose the attack of the ennemy
        
            int value = random.nextInt(4);
        
            switch(value){
            //DarkVador prepares his attack next turn a lot of damage will be inflicted
            case 0 : prepareAttack=true;
                return "Darth Vader \n is preparing \n a heavy attack";
            
            
            //DarkVador performs a small attack of 7 PV.
            case 1 :
            Player.decreasePV(7);
            return "Darth Vader \n attacked you \n by 7 !";
            
            //DarkVador will dodge the player's attack next turn
            case 2 : willDodge=true;
                return "Darth Vader \n is going to \n dodge your \n next attack"; 
            
            
            //DarkVador heals for 5 HP
            case 3 :
            setPVMax(getPVMax()+5);
            if (getPVMax() >90){
                setPVMax(90);
                return ("Darth Vader \n has tried to heal \n himself, but \n he is \n at his life \n maximum!");
            }
            else return "Darth vader \n recovered 5 pv !";
        }

        }
        //DarkVador prepared his attack in the turn before. It will therefore inflict 50 damage to the player
        else Player.decreasePV(50);
        prepareAttack=false;
        return "Darth Vader \n attacked you \n massively to \n inflict 50 \n points of \n damage on you";
    }
        
     /**
     * Decrease the pv of a certain amount of damage if our enemy did not dodge the attack.
     * 
     * @param damage The number of damage
     */
    public void decreasePV(int damage)
    {
        if (willDodge == false) {
        if (damage > getPV()){
        setPV(0);
        } else {
        setPV(getPV()- damage);
       
    }
    }  else {
    //return "DarkVador dodged the attack well!";
    willDodge = false;
    }
    }

    }