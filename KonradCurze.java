import java.util.Random;
import javax.swing.*;
import java.awt.*;
/**
 * Décrivez votre classe Konrad Curze ici.
 *
 * @author (LEVELU Paul)
 * @version (22/11)
 */
public class KonradCurze extends Ennemy
{
    /**
     * Constructeur d'objets de classe Konrad Curze
     */
    public KonradCurze()
    {
        super("Konrad Curze","Konrad Curze has been tortured his entire life by terrible, dark visions of the future. His psyche damaged by the hardships of his childhood, Curze never regained his sanity. He was a brutal warrior who believed in using fear as the most powerful weapon against his enemies. It can inflict a critical attack",30);
        //this.ennemyImage = new ImageIcon(new ImageIcon("image_ennemy/KonradCruze.png").getImage().getScaledInstance(600, 700, Image.SCALE_DEFAULT));//Image of the ennemy
    }

    /**
     * KonradCurze attack method, with ability to inflict critical Hit. 
     * 
     */
    public String attack()
    {
        Random random = new Random();
        int valeur = random.nextInt(100);
        String toReturn;        
        if (valeur < 30){
            Player.decreasePV(12);
            return "Konrad Kurze \n have made a critical \n attack to deal \n you 12 HP!";
        }else{
        Player.decreasePV(6);
        return "Konrad Kurze \n attacked you to \n deal 6 HP ";
        }
        }
        
    /**
     * KonradCurze can dodge attack, with a chance of 40 % 
     * 
     */
        public void decreasePV(int damage)
    {
        Random random = new Random();
        int valeur = random.nextInt(100);
        
        if (valeur < 40){
            System.out.println("Konrad Kurze \n dodged your attack !");
        }else{
        setPV(getPV() - damage);
        }
        if (getPV() < 0) {
            setPV(0);
        }
    }
    }
        
