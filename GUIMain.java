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
 * GUIMain class
 * 
 * This class is the main graphical class. It creates the frame and change what 
 * is displayed. The frame contains only one panel (but this panel contains
 * several) and this panel changes depending on the situation in the game. 
 *
 * @author Group 7
 * @version 09-12-2022
 */
public class GUIMain
{
    Icon icon;
    JPanel mainPanel;
    private static JFrame frame;
    private static JPanel oldPanel;
    public static void main()
    {
        Game.newGame();
        frame = new JFrame("Eon's Legacy");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setPreferredSize(new Dimension(1500, 750));
        frame.setResizable(false);
    
       
        //frame.add(new JLabel(Game.getStartRoom().getName()));
        oldPanel = PanelHome.newPanelHome(); //PanelGameOver.newPanelGameOver();
        frame.add(oldPanel);
        
        
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    
    public static void newRoom()
    {
        frame.remove(oldPanel);
        oldPanel = GUIRoomManager.choosenPanel();
        frame.add(oldPanel);
        frame.pack();
        frame.setVisible(true);
    }
    
    public static JFrame getFrame()
    {
        return frame;
    }
    
    public static void setEndOfGame(boolean isVictory)
    {
        frame.remove(oldPanel);
        if (isVictory){
        oldPanel = PanelVictory.newPanelVictory();
        } else {
        oldPanel = PanelGameOver.newPanelGameOver(0);        
        }
        frame.add(oldPanel);
        frame.pack();
        frame.setVisible(true);
    }
    
    public static void notAllowed(String animal)
    {       
        JOptionPane.showMessageDialog(frame,
        "You cannot access this room, you need to find the animal : "+ animal,
        "Missing something...",
        JOptionPane.ERROR_MESSAGE);
    }
}
