import javax.swing.*;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.Image.*;
import java.lang.Thread;
import java.lang.System;
/**
 * Décrivez votre classe PanelFight ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class PanelFight extends JPanel implements ActionListener
{
    private static Ennemy ennemy;
    private static JPanel pTop, PMidTop, PMidDown, PDown;
    private JLabel screenPlayer, screenEnnemy, myHP, enHP;
    private JButton buttonAttack, buttonDodge, buttonHeal, buttonChangeWeapon;

    /**
    * Constructeur d'objets de classe PanelFight
    */
    public PanelFight()
    {        
        //Création de l'écran
        screenPlayer = new JLabel("Player Screen", JLabel.CENTER);
        screenEnnemy = new JLabel("Ennemy Screen", JLabel.CENTER);

         
        //Création des boutons
        ennemy = Player.getEnnemy();
        buttonAttack = new JButton("<html><h1>Attack</h1></html>");
        buttonDodge = new JButton("<html><h1>Dodge</h1></html>");
        buttonHeal = new JButton("<html><h1>Heal</h1></html>");
        buttonChangeWeapon = new JButton("<html><h1>Change \n Weapon</h1></html>");
        System.out.println("image_ennemy/"+ennemy.getName()+".png");
        ImageIcon icon = new ImageIcon(new ImageIcon("image_ennemy/"+ennemy.getName()+".png").getImage().getScaledInstance(600, 700, Image.SCALE_DEFAULT));//Image of the ennemy
        JLabel labelImage = new JLabel(icon);//ennemy.ennemyImage);
        myHP = new JLabel("Your HP : \n "+ Integer.toString(Player.getPV()), JLabel.CENTER);
        enHP = new JLabel("Ennemy HP : \n "+ Integer.toString(ennemy.getPV()), JLabel.CENTER);

        
        //addInteractions
        buttonAttack.addActionListener(this);
        buttonDodge.addActionListener(this);
        buttonHeal.addActionListener(this);
        buttonChangeWeapon.addActionListener(this);

        
        //Ajout des boutons
        JPanel pLeft = new JPanel(); 
        pLeft.setLayout(new GridLayout(4,1));
        pLeft.add(new JLabel ("<html><center>"+ennemy.getDescription() + "</center></html>"));
        
        JPanel pLeftMiddleTop = new JPanel();
        pLeftMiddleTop.setLayout(new GridLayout(1,2));
        pLeftMiddleTop.add(myHP);
        pLeftMiddleTop.add(enHP);
        pLeft.add(pLeftMiddleTop);
        
        JPanel pLeftMiddleBot = new JPanel();
        pLeftMiddleBot.setLayout(new GridLayout(1,2));
        pLeftMiddleBot.add(screenPlayer);
        pLeftMiddleBot.add(screenEnnemy);
        pLeft.add(pLeftMiddleBot);
               
        JPanel pLeftDown = new JPanel();
        pLeftDown.setLayout(new GridLayout(1,4));
        pLeftDown.add(buttonAttack);
        pLeftDown.add(buttonDodge);
        pLeftDown.add(buttonHeal);
        pLeftDown.add(buttonChangeWeapon);

        pLeft.add(pLeftDown);
        
        this.setLayout(new GridLayout(1,2));
        this.add(pLeft);
        this.add(labelImage);
        }




    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()==buttonAttack) 
        {
            int degat = Player.actionFight(1);    
            screenPlayer.setText("<html><h3>You are attacking the \n ennemy and dealt \n" + degat +" dammage(s)!</h3></html>");
            
            if (Player.getEnnemy().getPV() == 0)
            {
                GUIMain.newRoom();
            }
        } 
        else if (ae.getSource()==buttonDodge)
        {
            screenPlayer.setText("<html><h3>You are \n preparing \n to dodge the \n next attack !</h3></html>");
            Player.actionFight(2);
        } 
        else if (ae.getSource()==buttonHeal)
        {
            int heal =Player.actionFight(3);
            screenPlayer.setText("<html><h3>You are praying \n to heal yourself! \n You restored \n " + heal + " HP </h3></html>");
        } 
        
        
        else if (ae.getSource()==buttonChangeWeapon)
        {
            String text = Player.changeWeapon();
            screenPlayer.setText("<html><h3>" + text +"</h3></html>");
        }

        updatePV();
        if (ennemy.getPV() <= 0){// ennemy defeated;
            if (Player.getRoom().getEvent().getName().equals("FinalBoss")){
            GUIMain.setEndOfGame(true); // Go to the victory panel
            } else {
            screenPlayer.setText("Victory !!");
            Player.addWallet(20);
            //Player.getRoom().setEvent(null); // Return back to the panel
            GUIMain.newRoom();
        }
        }
        else 
        {
            String result = ennemy.attack();
            screenEnnemy.setText("<html><h3>"+result+"</h3></html>");
            updatePV();
            if (Player.getPV() <= 0 )
            {
                screenPlayer.setText("<html>You have been slain..</html>");
                GUIMain.setEndOfGame(false);
                 // Exit the system indicating a successful termination ( 1 = error, 2 = error with exception )
            }
        }
    } 

    private void setEnnemy(Ennemy patate){
    ennemy=patate;
}

    public void updatePV(){
        myHP.setText("<html><h2>Your HP : \n "+ Integer.toString(Player.getPV())+"</h4></html>");
        enHP.setText("<html><h2>Ennemy HP : \n "+ Integer.toString(ennemy.getPV())+"</h4></html>");
    }  
}
