import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 * Décrivez votre classe GUIMenuListener ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class GUIMenuListener extends MouseAdapter
{
    
    private GUIPanelButtons buttons;

    /**
     * Constructeur d'objets de classe GUIMenuListener
     */
    public GUIMenuListener()
    {
    }

    public void mousePressed(MouseEvent evt)
    {
        GUIMain.getFrame().dispose();
        GUIMain.main();
    }
}
