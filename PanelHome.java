import java.awt.event.*; 
import java.io.File;
import javax.swing.*;
import java.awt.*;

/**
 * The IntercativeCounter is the main class of this project.
 * It create the window and is components
 *
 * @author Louis Marquet
 * @version 22/11/2022
 */
public class PanelHome extends JFrame 
{
    
      static JPanel mainMenu; //Correspond au gros pannel qui va tout contenir
      static JLabel ImageCenter,Welcome;//Image au centre
      static JPanel panelImage,panelUp,panelDescription;
      static JButton startButton;
    public static JPanel newPanelHome()
    {
        
       
        mainMenu = new JPanel();
        mainMenu.setLayout(new BorderLayout());
        // mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // mainMenu.setLocationRelativeTo(null);
        
        
        
        
        JLabel empty1 = new JLabel("");
        JLabel empty2 = new JLabel("");
        Welcome = new JLabel("<html><center><h1>Welcome to Eon's Adventure<h1></center></html>");
        panelUp = new JPanel();
        panelUp.setLayout(new GridLayout(1,3));
        panelUp.add(empty1);
        panelUp.add(Welcome);
        panelUp.add(empty2);
        
        
        
        
        JLabel Description = new JLabel("<html><center><h2>Few hours ago, you and all your puppies crashed on a new planet...<br> You are tired but you have to get out of there.But where are your puppies you need to find them quick !<br> But be careful you are not alone on that planet.</h2></center></html>", JLabel.CENTER);
        panelDescription = new JPanel();
        panelDescription.setLayout(new GridLayout(2,1));
        panelDescription.add(Description);
        
        
        
               
        JLabel empty5 = new JLabel("");
        JLabel empty6 = new JLabel("");
        ImageCenter= new JLabel(new ImageIcon("image_room/Home.jpg"));
        panelImage = new JPanel();
        ImageCenter.setPreferredSize(new Dimension(700,400));
        // panelImage.setLayout(new GridLayout(1,3));
        // panelImage.add(empty5);
        panelImage.add(ImageCenter);
        
        
        // panelImage.add(empty6);
        
       
        
        JLabel empty3 = new JLabel("");
        JLabel empty4 = new JLabel("");
        JPanel panelButton = new JPanel();
        // panelButton.setLayout(new GridLayout(1,3));
        // startButton = new JButton("<html><center<h2>Start the game</h2></center></html>");
        
        
        panelButton.add(empty3);
        panelButton.add(GUIPanelButtons.startButton());
        panelButton.add(empty4);
       
        
        
    
        
        panelDescription.add(panelButton);
        
        mainMenu.add(panelUp,BorderLayout.NORTH);
        mainMenu.add(panelImage,BorderLayout.CENTER);
        mainMenu.add(panelDescription, BorderLayout.SOUTH);
        mainMenu.setPreferredSize(new Dimension(850,700));
       
      
        // mainMenu.pack();
        // mainMenu.setResizable(false);
        // mainMenu.setVisible(true);
        return mainMenu;
    }

    // public void actionPerformed(ActionEvent e) { 
            // GUIRoomManager.choosenPanel();
            
        // }
    }


