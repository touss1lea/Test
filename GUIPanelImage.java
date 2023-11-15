
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.Image.*;
import java.util.ArrayList;

/**
 * Décrivez votre classe GUIPanelImage ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class GUIPanelImage extends JPanel
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private static JLabel textLabel = new JLabel();
    
    /**
     * Constructeur d'objets de classe GUIPanelImage
     */
    public GUIPanelImage()
    {
       
    }

    public static JPanel newPanelImage()
    {
        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new BorderLayout());
        
        ImageIcon icon = new ImageIcon(new ImageIcon("image_room/"+Player.getRoom().getName()+".jpg").getImage().getScaledInstance(1000,400,Image.SCALE_DEFAULT));
        imagePanel.add(new JLabel(icon),BorderLayout.NORTH);
        
        if (Player.getRoom().getEvent().getFinalDescription() != null)
            if (Player.getRoom().getEvent().getName() != "Fight")
            {
                String eventDesc = Player.getRoom().getEvent().getFinalDescription();
                textLabel.setText("<html><center><h1>"+eventDesc+"</h1></center></html>");
                textLabel.setHorizontalAlignment(SwingConstants.CENTER);
                imagePanel.add(textLabel,BorderLayout.CENTER);
                
            }
        
         
            
        return imagePanel;
    }
    
    public static void changeText(String newText)
    {
        textLabel.setText(newText);
        textLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }
}
