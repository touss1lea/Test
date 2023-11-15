import java.awt.event.*; 
import java.io.File;
import javax.swing.*;
import java.awt.*;

/**
 * The IntercativeCounter is the main class of this project.
 * It create the window and is components
 *
 * @author Groupe7
 * @version 27/12/2022
 */
public class PanelVictory extends JFrame 
{
    
      static JPanel mainMenu; //Correspond au gros pannel qui va tout contenir

    public static JPanel newPanelVictory()
    {
        
       
        mainMenu = new JPanel();
        mainMenu.setLayout(new GridLayout(1,1));
        ImageIcon icon = new ImageIcon(new ImageIcon("image_gui/victory.png").getImage().getScaledInstance(1600,800,Image.SCALE_DEFAULT));
        JButton goButton = new JButton(icon);
        //goButton.setPreferredSize(new Dimension(100,100));
        goButton.setToolTipText("Click this button to go to the menu");
        goButton.addMouseListener(new GUIMenuListener());
        
       
        mainMenu.add(goButton);
        
        return mainMenu;
    }

    // public void actionPerformed(ActionEvent e) { 
            // GUIRoomManager.choosenPanel();
            
        // }
    }


