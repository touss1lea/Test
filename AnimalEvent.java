/**
 * Decrivez votre classe AnimalEvent ici.
 *
 * @author Group07
 * @version 22/11/2022
 */
public class AnimalEvent extends Event
{
    private Animal animal;  //The animal in the event
    
    /**
     * Constructeur d'objets de classe AnimalEvent
     * 
     * @param name The name of the event
     * @param description The description of the event
     * @param ani The animal associed to the event
     */
    public AnimalEvent(String name, String description, Animal ani)
    {
        super(name,description);
        animal = ani;
    }
    
    /**
     * What the event do
     * If the player has the animal, nothing happen
     * If the player has not the animal neither the necessary food, he can't tame the animal
     * With food, he can tame the animal and get it as an item
     */
    public void action()
    {
        if (Player.checkItemInInventory(animal))
        {
            setFinalDescription("You have already come to this room, you already own :"+animal.getName()+".");
        }
        else
        {
            String firstSentence = "There is a " + animal.getName() + " in this room !";
            if (Player.checkItemInInventory(animal.getAlimentation()))
            {
                setFinalDescription(firstSentence+" You tamed : " + animal.getName() +".");
                Player.addItem(animal);
                Player.removeItem(animal.getAlimentation());
            }
            else
            {
                setFinalDescription(firstSentence+" Come back when you have something to tame the animal.");
            }
        }
    }
}
