
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.Image.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * GUIPanelInventory class
 * 
 * This class is the graphical interface for actions and displays related to 
 * the inventory
 *
 * @author Group 7
 * @version 09-12-2022
 */
public class GUIPanelInventory extends JLabel
{
    private static JButton weaponButton;
    /**
     * Constructeur d'objets de classe GUILabel
     */
    public GUIPanelInventory()
    {
    }
    
    public static JPanel inventoryInterface()
    {
        //JPanel inventoryPanel = new JPanel(new GridLayout(5,5));
        JPanel inventoryPanel = new JPanel(new FlowLayout());
        for (Item itemName : Player.getInventory())
        {
            //ImageIcon icon = new ImageIcon("itemIcon/"+itemName.getName()+".jpg");
            //JLabel label1 = new JLabel("Image and Text",icon,JLabel.CENTER);
            
            ImageIcon icon = new ImageIcon(new ImageIcon("itemIcon/"+itemName.getName()+".jpg").getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT));            
            inventoryPanel.add(new JLabel(icon));
            inventoryPanel.add(new JLabel(itemName.getName()));
        }
        inventoryPanel.setBorder(BorderFactory.createLineBorder(Color.red));
        return inventoryPanel;
    }
    
    public static JPanel healthInterface()
    {
        JPanel healthAndWalletPanel = new JPanel();
        JPanel healthPanel = new JPanel();
        //healthPanel.setLayout(new GridLayout(3,3));
        //healthAndWalletPanel.setLayout(new BorderLayout());
        healthAndWalletPanel.setLayout(new GridLayout(2,1));
        
        JLabel healthLabel = new JLabel("Health : "+Integer.toString(Player.getPV()));
        ImageIcon icon = new ImageIcon(new ImageIcon("image_gui/trueHealth.png").getImage().getScaledInstance(1000,20,Image.SCALE_DEFAULT));
        JLabel hImgPanel = new JLabel(icon);
        hImgPanel.setPreferredSize(new Dimension(Player.getPV()*2,20));
        ImageIcon icon2 = new ImageIcon(new ImageIcon("image_gui/health.png").getImage().getScaledInstance(1000,20,Image.SCALE_DEFAULT));
        JLabel hImgPanel2 = new JLabel(icon2);
        hImgPanel2.setPreferredSize(new Dimension(Player.getPVMax()*2-Player.getPV()*2,20));
        
        JPanel walletPanel = new JPanel();
        ImageIcon icon3 = new ImageIcon(new ImageIcon("image_gui/wallet.png").getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT));
        JLabel hImgPanel3 = new JLabel(icon3);
        hImgPanel3.setPreferredSize(new Dimension(30,30));
        JLabel walletLabel = new JLabel("       Wallet : "+Integer.toString(Player.getWallet()));
        
        healthPanel.add(hImgPanel,BorderLayout.WEST);
        healthPanel.add(hImgPanel2,BorderLayout.CENTER);
        healthPanel.add(healthLabel,BorderLayout.EAST);
        
        walletPanel.add(hImgPanel3);
        walletPanel.add(walletLabel);
        
        healthAndWalletPanel.add(healthPanel,BorderLayout.NORTH);
        healthAndWalletPanel.add(walletPanel,BorderLayout.CENTER);
        healthAndWalletPanel.setBorder(BorderFactory.createLineBorder(Color.green));
 
        return healthAndWalletPanel;
    }
    
    public static JButton weaponButton()
    {
        weaponButton = new JButton("Change your Weapon");
        weaponButton.addMouseListener(new GUIActionListener());
        
        return weaponButton;
    }
    
    public static JButton getWeaponButton()
    {
        return weaponButton;
    }

    public static void displayWeapons()
    {
       JOptionPane.showMessageDialog(GUIMain.getFrame(),
        "You are now equiped with : "+ Player.getPlayerWeapon().getName(),
        "New Weapon",
        JOptionPane.INFORMATION_MESSAGE);
        GUIMain.newRoom();
    }
    
    public static JPanel showWeapon()
    {
        JPanel weaponPanel = new JPanel(new GridLayout(1,3));
        ImageIcon icon = new ImageIcon(new ImageIcon("itemIcon/"+Player.getPlayerWeapon().getName()+".jpg").getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT));            
        JLabel text = new JLabel("Current weapon : "+Player.getPlayerWeapon().getName());
        weaponPanel.add(new JLabel(icon));
        weaponPanel.add(text);
        weaponPanel.add(new JLabel(icon));
        //weaponPanel.add(new JLabel(Player.getPlayerWeapon().getName()));
        
        weaponPanel.setBorder(BorderFactory.createLineBorder(Color.blue));
        return weaponPanel;
    }
}
