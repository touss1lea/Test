import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelShop extends JPanel
{   
    private static Item item1;
    private static Item item2;
    private static Item item3;
    private static JLabel labelWelcome,walletLabel;
    public static JPanel newPanelShop() 
    {

        // Defining the welcome panel where messages are displayed
        
        JLabel labelWelcome = new JLabel("<html><h1><center><b>Welcome to the shop !</b><center></h1><br><h1><center>Choose the item you want to buy by clicking on it !<center><h1><html>", JLabel.CENTER);
        
        //Defining the 3 buttons that allows the player to buy on of the 3 items
        //Each button contains the picture, the name and the price of the corresponding item
        // Item 1
        item1 = ShopEvent.chooseFoodItem();
        JButton btn1 = new JButton(new ImageIcon("itemIcon/"+item1.getName()+".jpg"));
        ImageIcon imageIcon1 = new ImageIcon(new ImageIcon("itemIcon/"+item1.getName()+".jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        btn1.setIcon(imageIcon1);
        btn1.setText(item1.getName()+" : "+item1.getPrice()+"$");
        btn1.setVerticalTextPosition(SwingConstants.BOTTOM);
        btn1.setHorizontalTextPosition(SwingConstants.CENTER);
        btn1.setOpaque(false);
        btn1.setContentAreaFilled(false);
        btn1.setBorderPainted(false);
        
        // // Item 2
        item2 = ShopEvent.chooseRandomItem();
        JButton btn2 = new JButton(new ImageIcon("itemIcon/"+item2.getName()+".jpg"));
        ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("itemIcon/"+item2.getName()+".jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        btn2.setIcon(imageIcon2);
        btn2.setText(item2.getName()+" : "+item2.getPrice()+"$");
        btn2.setVerticalTextPosition(SwingConstants.BOTTOM);
        btn2.setHorizontalTextPosition(SwingConstants.CENTER);
        btn2.setOpaque(false);
        btn2.setContentAreaFilled(false);
        btn2.setBorderPainted(false);
        
        
        
        // //Item 3
        item3 = ShopEvent.chooseRandomItem();
        JButton btn3 = new JButton(new ImageIcon("itemIcon/"+item3.getName()+".jpg"));
        ImageIcon imageIcon3 = new ImageIcon(new ImageIcon("itemIcon/"+item3.getName()+".jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        btn3.setIcon(imageIcon3);
        btn3.setText(item3.getName()+": "+item3.getPrice()+"$");
        btn3.setVerticalTextPosition(SwingConstants.BOTTOM);
        btn3.setHorizontalTextPosition(SwingConstants.CENTER);
        btn3.setOpaque(false);
        btn3.setContentAreaFilled(false);
        btn3.setBorderPainted(false);
        
        //adding interactions
        btn1.addActionListener(new ActionListener()
        {    
            public void actionPerformed(ActionEvent e)
            {
                ShopEvent.buyItem(item1);
                walletLabel.setText("       Wallet : "+Integer.toString(Player.getWallet()));
                if (Player.getWallet()<item1.getPrice()){
                    labelWelcome.setText("<html><h2><center>Welcome to the shop !<center><h2><br><h3><center>Sorry, you don't have enough money, go win some !<center><h3<html>");
                }
                else  
                {
                labelWelcome.setText("<html><h2><center>Welcome to the shop !<center><h2><br><h3><center>Thank you ! You now have a <center><h3><html>"+item1.getName());
                }
            }
        });
        
        btn2.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                ShopEvent.buyItem(item2);
                walletLabel.setText("       Wallet : "+Integer.toString(Player.getWallet()));
                if (Player.getWallet()<item2.getPrice()){
                    labelWelcome.setText("<html><h2><center>Welcome to the shop !<center><h2><br><h3><center>Sorry, you don't have enough money, go win some !<center><h3><html>");
                }
                else  
                {
                labelWelcome.setText("<html><h2><center>Welcome to the shop !<center><h2><br><h3><center>Thank you ! You now have a <center><h3><html>"+item2.getName());
    
                }
            
            }
        });
        
        btn3.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                ShopEvent.buyItem(item3);
                walletLabel.setText("       Wallet : "+Integer.toString(Player.getWallet()));
                if (Player.getWallet()<item3.getPrice()){
                    labelWelcome.setText("<html><h2><center>Welcome to the shop !<center><h2><br><h3><center>Sorry, you don't have enough money, go win some !<center><h3><html>");
                }
                else 
                {
                labelWelcome.setText("<html><h2><center>Welcome to the shop !<center><h2><br><h3><center>Thank you ! You now have a <center><h3><html>"+item3.getName());
                }
            }
        });
        
        JPanel walletPanel = new JPanel();
        JPanel walletPanel2 = new JPanel();
        walletPanel2.setLayout(new GridLayout(1,3));
        JLabel label1 = new JLabel("");
        JLabel label2 = new JLabel("");
        
        ImageIcon icon3 = new ImageIcon(new ImageIcon("image_gui/wallet.png").getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT));
        JLabel hImgPanel3 = new JLabel(icon3);
        hImgPanel3.setPreferredSize(new Dimension(100,100));
        walletLabel = new JLabel("       Wallet : "+Integer.toString(Player.getWallet()));
        walletPanel.add(walletLabel);
        walletPanel.add(hImgPanel3);
        walletPanel2.add(walletPanel);
        walletPanel2.add(label1);
       
        // Defining Item Panel and adding buttons 
        JPanel panelItem = new JPanel();
        panelItem.setLayout(new GridLayout(1,7));
        JLabel empty1 = new JLabel("");
        JLabel empty2 = new JLabel("");
        JLabel empty3 = new JLabel("");
        JLabel empty4 = new JLabel("");
        
        panelItem.add(walletPanel2);
        panelItem.add(empty1);
        panelItem.add(btn1);
        panelItem.add(empty2);
        panelItem.add(btn2);
        panelItem.add(empty3);
        panelItem.add(btn3);
        panelItem.add(empty4);
        
        // Bouton de sortie
        JPanel panelExit = new JPanel();
        JLabel vide1 = new JLabel("");
        JLabel vide2 = new JLabel("");
        JLabel labelExit1 = new JLabel();
        JButton buttonExit = new JButton("Exit");
       
        // add interaction for exit button
        buttonExit.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Player.changeRoom("WEST");
                GUIMain.newRoom();
            }
        });
        
        // add button and labels
        panelExit.setLayout(new GridLayout(1, 3));
        panelExit.add(vide1);
        panelExit.add(buttonExit);
        panelExit.add(vide2);
        
        //Panel Wallet
        JLabel labelWallet = new JLabel(Player.getWallet()+"$");

        JPanel panelVide = new JPanel();
        JPanel panelVide2 = new JPanel();

        // Ajouter label et panel au frame
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 1));
        // mainPanel.add(labelWallet, BorderLayout.NORTH);
        mainPanel.add(labelWelcome);
        mainPanel.add(panelVide2);
        mainPanel.add(panelItem);
        mainPanel.add(panelVide);
        mainPanel.add(panelExit);
        
        return mainPanel;
    }
}
