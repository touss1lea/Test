import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Décrivez votre classe GUIRoomListener ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class GUIRoomListener extends MouseAdapter
{
    
    private GUIPanelButtons buttons;

    /**
     * Constructeur d'objets de classe GUIRoomListener
     */
    public GUIRoomListener()
    {
    }

    public void mousePressed(MouseEvent evt)
    {
        if (evt.getSource() == GUIPanelButtons.getNorthButton())
        {
            if (Player.getRoom().getName()=="room5" && !Player.checkItemInInventoryByName("Mole"))
                GUIMain.notAllowed("DUCK");
            else
                Player.changeRoom("NORTH");
        }
        else if (evt.getSource() == GUIPanelButtons.getSouthButton())
        { 
            if (Player.getRoom().getName()=="room6" && !Player.checkItemInInventoryByName("Cat"))
                GUIMain.notAllowed("CAT");
            else
                Player.changeRoom("SOUTH");
        }
        else if (evt.getSource() == GUIPanelButtons.getEastButton())
        {    
            if (Player.getRoom().getName()=="room3" && !Player.checkItemInInventoryByName("Duck"))
                GUIMain.notAllowed("DUCK");
            else
                Player.changeRoom("EAST");
        }    
        else if (evt.getSource() == GUIPanelButtons.getWestButton())
        {
            if (Player.getRoom().getName()=="room3" && !Player.checkItemInInventoryByName("Duck"))
                GUIMain.notAllowed("DUCK");
            else if (Player.getRoom().getName()=="StartRoom" && !Player.checkItemInInventoryByName("Monkey"))
                GUIMain.notAllowed("MONKEY");
            else    
                Player.changeRoom("WEST");
        }           
        else if (evt.getSource() == GUIPanelButtons.getStartButton()){
        }
        GUIMain.newRoom();
    }
}
