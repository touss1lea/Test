import java.util.Random;
import java.util.ArrayList;
/**
 * This class is describing an event that can 
 * happen when the player enter in a room. 
 * It can be for example a fight, a fall in a 
 * hole or the discovering of an apple which is healing
 * the player
 *
 * @author Group 7
 * @version 16/11/2022
 */
public class Event
{
    private String name;        //The name of the event. Can’t be null. It cannot contain only characters from A-Z and a-z and characters with accent but no numbers and no special characters. More than 2 characters
    private String description; //The description of the event
    private String finalDescription; //The description displayed

    /**
     * Constructeur d'objets de classe Event
     * 
     * @param name The name of the event
     * @param description The description of the event
     */
    public Event(String name, String description)
    {
        // initialisation des variables d'instance
        this.name = name;
        this.description = description;
    }
    
    /**
     * Get the name of the event
     * 
     * @return name The name of the event
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * Get the description of the event
     * 
     * @return description The description of the event
     */
    public String getDescription()
    {
        return description;
    }
    
    public String getFinalDescription()
    {
        return finalDescription;
    }
    
    public void setFinalDescription(String desc)
    {
        finalDescription = desc;
    }

    /**
     * Initialise a fight with an ennemy.
     * @param int : choose a fighter among the different ennemies. For a random ennemy, write "-1". For a specific, write his index. 0 = FinalBoss
     * @return boolean. True = fight win.
     */
    public void combat(int indexEnnemy)
    {
        //Instanciate the futur ennemy
        Ennemy ennemy = new Ennemy("","",100);
        int size = Game.getListRandomEnnemies().size();
        int index = -999; // valeur sentinelle
        
        if (0 <= indexEnnemy && indexEnnemy < size){ // Si l'index existe dans la liste
        index = indexEnnemy; //affectation a index
         
         } else if (indexEnnemy == -2) { // si l'index du boss est sélectionné
          ennemy = new DarkVador(); // Final boss
        
         } else if (indexEnnemy == -1){ // si on veut un ennemy random
          Random random = new Random(); // Get a random ennemy
          index = random.nextInt(size);// tirage aléatoire et affectation à index
         
         } else{
              System.out.println("No ennemy with this index");
         }
         
        if (index == -999){ 
            System.out.println("Index Unknown for ennemy choice");
        }else{// Si la valeur sentinelle est modifiée
            
        String ennemyName = Game.getListRandomEnnemies().get(index);
        System.out.println("Vous affrontez " + ennemyName);// obtention le nom localisé à cet index
        switch (ennemyName){ //Instanciation selon le nom tiré
                    case "Alien": ennemy = new Alien(); break;
                    case "Mortarion": ennemy = new Mortarion(); break;
                    case "Angron": ennemy = new Angron(); break;
                    case "Perturabo": ennemy = new Perturabo(); break;
                    case "Konrad Curze": ennemy = new KonradCurze(); break;
                    case "Lorgar": ennemy = new Lorgar(); break;
        }
        }  
        String enName = ennemy.getName();
        Player.setEnnemy(ennemy);
        boolean stateFight = false;
        while (stateFight = false){
        stateFight = Player.getEndOfFight();
        }
        Player.setEndOfFight(false);
        GUIMain.newRoom();
    }
                
    
    
    /**
     * What the event do
     * This action depends of the event
     * The events here are not random
     */
    public void action()
    {
        System.out.println(getDescription());
        if (name =="Trap") 
        {
                Game.getStartRoom().getEvent().setFinalDescription(description);
                Player.setRoom(Game.getStartRoom());
                //finalDescription = description;
        }
        else if (name == "LuckyEvent")
        {
            int number = random(Player.getPVMax());
            Player.increasePV(number);
            finalDescription = description + " You win "+ number+" HP";
        }
        else if (name == "UnluckyEvent")
        {
            int number = random(21);
            Player.decreasePV(number);
            finalDescription = description + " You lose "+ number+" HP";
        }
        else if (name == "Fight")
        {
            combat(-1);
            finalDescription = description;
        }
        else if (name == "FinalBoss"){
        combat(-2); // Summon Dark Vador
        finalDescription = description;
        }
        
        else
            finalDescription = description;
            
        
    }
    
    /**
     * A random method between a wanted maximum value-1 and 0
     * 
     * @param The maximum value less 1
     * @return The random value
     */
    public int random(int max)
    {
        Random rand = new Random(); 
        int number = rand.nextInt(max);
        return number;
    }
}
