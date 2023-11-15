import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.Image.*;
import java.util.ArrayList;
import java.util.*;

/**
 * GUIManager class
 * 
 * This class check the situation in game (in a fight, exploration or in the
 * shop) and returns the matching display.
 *
 * @author Group 7
 * @version 09-12-2022
 */
public class GUIRoomManager extends JPanel
{
    /**
     * Constructeur d'objets de classe GUIManager
     */
    public GUIRoomManager()
    {
    }

    public static JPanel choosenPanel()
    {
        JPanel choosenPanel = new JPanel(); 
        choosenPanel.setLayout(new BorderLayout());
        if(Player.getRoom().getEvent() != null)
        {
            if(Player.getRoom().getEvent().getName().equals("Fight"))
            {
                if (Player.getEnnemy().getPV() == 0)
                {
                    choosenPanel.add(GUIPanelButtons.southButtonInterface(),BorderLayout.SOUTH);
                    choosenPanel.add(GUIPanelButtons.northButtonInterface(),BorderLayout.NORTH);
                    choosenPanel.add(GUIPanelButtons.eastButtonInterface(),BorderLayout.EAST);
                    choosenPanel.add(GUIPanelButtons.westButtonInterface(),BorderLayout.WEST);    
                    choosenPanel.add(GUIPanelImage.newPanelImage());
                }
                else
                {
                    PanelFight lePanel = new PanelFight();
                    choosenPanel = lePanel;
                }
            }
            else if (Player.getRoom().getEvent().getName().equals("Shop"))
            {
                System.out.println("shop");
                choosenPanel = PanelShop.newPanelShop();
            }
            else if (Player.getRoom().getEvent().getName().equals("FinalBoss")){
                PanelFight lePanel = new PanelFight();
                choosenPanel = lePanel;
            }
            else
            {
                choosenPanel.add(GUIPanelButtons.southButtonInterface(),BorderLayout.SOUTH);   
                choosenPanel.add(GUIPanelButtons.northButtonInterface(),BorderLayout.NORTH);
                choosenPanel.add(GUIPanelButtons.eastButtonInterface(),BorderLayout.EAST);
                choosenPanel.add(GUIPanelButtons.westButtonInterface(),BorderLayout.WEST);
                choosenPanel.add(GUIPanelImage.newPanelImage());
            }
        }
        else
        {
            choosenPanel.add(GUIPanelButtons.southButtonInterface(),BorderLayout.SOUTH);
            choosenPanel.add(GUIPanelButtons.northButtonInterface(),BorderLayout.NORTH);
            choosenPanel.add(GUIPanelButtons.eastButtonInterface(),BorderLayout.EAST);
            choosenPanel.add(GUIPanelButtons.westButtonInterface(),BorderLayout.WEST);    
            choosenPanel.add(GUIPanelImage.newPanelImage());
        }
        
        if (Player.getPV() <=0) choosenPanel = PanelGameOver.newPanelGameOver(1);   
        
        return choosenPanel;
    }
}
