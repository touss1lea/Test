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
 * GUIPanelButtons class
 * 
 * This class handle the display of the 4 directionnal panels (NORTH,SOUTH,EAST,
 * WEST).
 *
 * @author Group 7
 * @version 09-12-2022
 */
public class GUIPanelButtons extends JLabel
{
    //Five of buttons used in the game, 4 used as directionnal movement and 
    //the startButton to begin the game
    private static JButton northButton,southButton,eastButton,westButton,startButton,changeWeaponButton;
    
    /**
     * Constructeur d'objets de classe GUIPanelButtons
     */
    public GUIPanelButtons()
    {

    }

    /**
     * northButtonInterface method
     * 
     * This panel mainly contains the top button to reach a northern room.
     * 
     * @return JPanel the panel that is displayed in the north of the frame
     */
    public static JPanel northButtonInterface()
    {
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(1,3));
        // JLabel emptyLabel = new JLabel("");
        JLabel emptyLabel2 = new JLabel("");
        //topPanel.add(emptyLabel);
        changeWeaponButton = GUIPanelInventory.weaponButton();
        topPanel.add(changeWeaponButton);
        if(Player.getRoom().getExits().get(Cardinality.NORTH) != null)
        {
            northButton = new JButton("North");
            northButton.setPreferredSize(new Dimension(100,100));
            northButton.setToolTipText("Click this button to go to the north");
            northButton.addMouseListener(new GUIRoomListener());
            topPanel.add(northButton);
        }
        else
        {
            JLabel emptyLabel3 = new JLabel("");
            emptyLabel3.setPreferredSize(new Dimension(100,100));
            topPanel.add(emptyLabel3);
        }
        topPanel.add(GUIPanelInventory.showWeapon());
        
        return topPanel;
    }
    
    /**
     * eastButtonInterface method
     * 
     * This panel mainly contains the east button to reach an eastern room.
     * 
     * @return JPanel the panel that is displayed in the east of the frame
     */
    public static JPanel eastButtonInterface()
    {
        JPanel eastPanel = new JPanel();
        eastPanel.setLayout(new GridLayout(3,1));
        JLabel emptyLabel3 = new JLabel("");
        JLabel emptyLabel5 = new JLabel("");
        eastPanel.add(emptyLabel3);
        
        if(Player.getRoom().getExits().get(Cardinality.EAST) != null)
        {
            eastButton = new JButton("East");
            eastButton.setPreferredSize(new Dimension(100,100));
            eastButton.addMouseListener(new GUIRoomListener());
            eastPanel.add(eastButton);
        }
        else
        {
            JLabel emptyLabel4 = new JLabel("");
            emptyLabel4.setPreferredSize(new Dimension(100,100));
            eastPanel.add(emptyLabel4);
        }
        eastPanel.add(emptyLabel5);
        
        return eastPanel;
    }
    
    /**
     * westButtonInterface method
     * 
     * This panel mainly contains the west button to reach a western room.
     * 
     * @return JPanel the panel that is displayed in the west of the frame
     */
    public static JPanel westButtonInterface()
    {
        JPanel westPanel = new JPanel();
        westPanel.setLayout(new GridLayout(3,1));
        JLabel emptyLabel5 = new JLabel("");
        JLabel emptyLabel7 = new JLabel("");
        westPanel.add(emptyLabel5);
        
        if(Player.getRoom().getExits().get(Cardinality.WEST) != null)
        {
            westButton = new JButton("West");
            westButton.setPreferredSize(new Dimension(100,100));
            westButton.addMouseListener(new GUIRoomListener());
            westPanel.add(westButton);
        }
        else
        {
            JLabel emptyLabel6 = new JLabel("");
            emptyLabel6.setPreferredSize(new Dimension(100,100));
            westPanel.add(emptyLabel6);
        }
        westPanel.add(emptyLabel7);
        
        return westPanel;
    }
    
    /**
     * southButtonInterface method
     * 
     * This panel mainly contains the south button to reach a southern room.
     * 
     * @return JPanel the panel that is displayed in the south of the frame
     */
    public static JPanel southButtonInterface()
    {
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new GridLayout(1,3));
        southPanel.add(GUIPanelInventory.inventoryInterface());
        
        if(Player.getRoom().getExits().get(Cardinality.SOUTH) != null)
        {
            southButton = new JButton("South");
            southButton.setPreferredSize(new Dimension(100,100));
            southButton.addMouseListener(new GUIRoomListener()); 
            southPanel.add(southButton);
        }
        else
        {
            JLabel emptyLabel8 = new JLabel("");
            emptyLabel8.setPreferredSize(new Dimension(100,100));
            southPanel.add(emptyLabel8);
        }
        southPanel.add(GUIPanelInventory.healthInterface());
        return southPanel;
    }
    
    /**
     * startButton method
     * 
     * This button displays "Start the game" and start the game by clicking on it
     * 
     * @return JButton the first button to start the game
     */
    public static JButton startButton()
    {    
        startButton = new JButton("<html><center<h1>Start the game</h1></center></html>");
        startButton.setPreferredSize(new Dimension(200,100));
        startButton.addMouseListener(new GUIRoomListener());
        return startButton;
    }
    
    /**
     * getStartButton method
     * 
     * @return JButton the button at the start of the game
     */
    public static JButton getStartButton(){
        return startButton;
    }
    
    /**
     * getNorthButton method
     * 
     * @return JButton the button in the north
     */
    public static JButton getNorthButton()
    {
        return northButton;
    }
    
    /**
     * getSouthButton method
     * 
     * @return JButton the button in the south
     */
    public static JButton getSouthButton()
    {
        return southButton;
    }
    
    /**
     * getEastButton method
     * 
     * @return JButton the button in the east
     */
    public static JButton getEastButton()
    {
        return eastButton;
    }
    
    /**
     * getWestButton method
     * 
     * @return JButton the button in the west
     */
    public static JButton getWestButton()
    {
        return westButton;
    }
    
    /**
     * getChangeWeaponButton method
     * 
     * @return JButton the button to change weapon
     */
    public static JButton getChangeWeaponButton()
    {
        return changeWeaponButton;
    }
    
    
}
