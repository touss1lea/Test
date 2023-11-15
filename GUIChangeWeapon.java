import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIChangeWeapon 
{   
    private static Weapon weapon1, weapon2, weapon3, weapon4;
    private static JLabel labelWelcome;
    public static void main() 
    {
        // Définissez le frame
        JFrame frame = new JFrame("What weapon do you want ?");
        
        JLabel myLabel = new JLabel("<html><h2><center>What weapon do you want ?<center><h2><html>");
        
        //Defining the 3 buttons that allows the player to buy on of the 3 items
        //Each button contains the picture, the name and the price of the corresponding item
        // Item 1
        JButton btn1 = new JButton(new ImageIcon("itemIcon/Bow.jpg"));
        ImageIcon imageIcon1 = new ImageIcon(new ImageIcon("itemIcon/Bow.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        btn1.setIcon(imageIcon1);
        btn1.setVerticalTextPosition(SwingConstants.BOTTOM);
        btn1.setHorizontalTextPosition(SwingConstants.CENTER);
        
        // // Item 2
        JButton btn2 = new JButton(new ImageIcon("itemIcon/Laser Gun.jpg"));
        ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("itemIcon/Laser Gun.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        btn2.setIcon(imageIcon2);
        btn2.setVerticalTextPosition(SwingConstants.BOTTOM);
        btn2.setHorizontalTextPosition(SwingConstants.CENTER);
        
        // //Item 3
        JButton btn3 = new JButton(new ImageIcon("itemIcon/Terrian Bazooka.jpg"));
        ImageIcon imageIcon3 = new ImageIcon(new ImageIcon("itemIcon/Terrian Bazooka.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        btn3.setIcon(imageIcon3);
        btn3.setVerticalTextPosition(SwingConstants.BOTTOM);
        btn3.setHorizontalTextPosition(SwingConstants.CENTER);
        
        // //Item 4
        JButton btn4 = new JButton(new ImageIcon("itemIcon/Plasma bean generator.jpg"));
        ImageIcon imageIcon4 = new ImageIcon(new ImageIcon("itemIcon/Plasma bean generator.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        btn4.setIcon(imageIcon4);
        btn4.setVerticalTextPosition(SwingConstants.BOTTOM);
        btn4.setHorizontalTextPosition(SwingConstants.CENTER);
        
        //adding interactions
        btn1.addActionListener(new ActionListener()
        {    
        public void actionPerformed(ActionEvent e){
            Player.getWeaponFromInventory("Bow");
            myLabel.setText("<html><h2><center>Now your player is equiped with<center><h2><html>"+Player.getPlayerWeapon());
        }
        });
        
        btn2.addActionListener(new ActionListener()
        {
        public void actionPerformed(ActionEvent e){
            Player.getWeaponFromInventory("Laser Gun");
            myLabel.setText("<html><h2><center>Now your player is equiped with <center><h2><html>"+Player.getPlayerWeapon());
        }
        });
        
        btn3.addActionListener(new ActionListener()
        {
        public void actionPerformed(ActionEvent e){
            Player.setWeapon(weapon3);
            myLabel.setText("<html><h2><center>Now your player is equiped with <center><h2><html>"+Player.getPlayerWeapon());
        }
        });
        
        btn4.addActionListener(new ActionListener()
        {
        public void actionPerformed(ActionEvent e){
            Player.getWeaponFromInventory("Plasma bean generator");
            myLabel.setText("<html><h2><center>Now your player is equiped with <center><h2><html>"+Player.getPlayerWeapon());
        }
        });
        
        //On définit le panel Item et on ajoute les images des 3 items au panel
        JPanel panelWeapon = new JPanel();
        panelWeapon.add(btn1);
        panelWeapon.add(btn2);
        panelWeapon.add(btn3);
        panelWeapon.add(btn4);
        
        // Ajouter label et panel au frame
        frame.add(myLabel);
        frame.add(panelWeapon, BorderLayout.SOUTH);
        
        //frame.setLayout(new GridLayout(3, 3));
        frame.pack();
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}