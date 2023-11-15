import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Décrivez votre classe GUIRoomListener ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class GUIActionListener extends MouseAdapter
{
    
    // private GUIPanelButtons buttons;

    /**
     * Constructeur d'objets de classe GUIActionListener
     */
    public GUIActionListener()
    {
    }
    
    public void mousePressed(MouseEvent evt)
    {
        if (evt.getSource() == GUIPanelInventory.getWeaponButton())   
        {   
            Player.changeWeapon();
            GUIPanelInventory.displayWeapons();
        }
    }
    
}
