/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myhilo;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.*;

/**
 *
 * @author hp
 */
public class ShowDice extends JButton implements ActionListener{
    ImageIcon rollA1,rollA2,rollA3,rollA4,rollA5,rollA6;
    ImageIcon rollB1,rollB2,rollB3,rollB4,rollB5,rollB6;
    ImageIcon rollC1,rollC2,rollC3,rollC4,rollC5,rollC6;
    
    
    
    public ShowDice(){
        rollA1 = new ImageIcon(this.getClass().getResource("/Image/roll1.png"));
        rollB1 = new ImageIcon(this.getClass().getResource("/Image/roll1.png"));
        rollC1 = new ImageIcon(this.getClass().getResource("/Image/roll1.png"));
        rollA2 = new ImageIcon(this.getClass().getResource("/Image/roll2.png"));
        rollB2 = new ImageIcon(this.getClass().getResource("/Image/roll2.png"));
        rollC2 = new ImageIcon(this.getClass().getResource("/Image/roll2.png"));
        rollA3 = new ImageIcon(this.getClass().getResource("/Image/roll3.png"));
        rollB3 = new ImageIcon(this.getClass().getResource("/Image/roll3.png"));
        rollC3 = new ImageIcon(this.getClass().getResource("/Image/roll3.png"));
        rollA4 = new ImageIcon(this.getClass().getResource("/Image/roll4.png"));
        rollB4 = new ImageIcon(this.getClass().getResource("/Image/roll4.png"));
        rollC4 = new ImageIcon(this.getClass().getResource("/Image/roll4.png"));
        rollA5 = new ImageIcon(this.getClass().getResource("/Image/roll5.png"));
        rollB5 = new ImageIcon(this.getClass().getResource("/Image/roll5.png"));
        rollC5 = new ImageIcon(this.getClass().getResource("/Image/roll5.png"));
        rollA6 = new ImageIcon(this.getClass().getResource("/Image/roll6.png"));
        rollB6 = new ImageIcon(this.getClass().getResource("/Image/roll6.png"));
        rollC6 = new ImageIcon(this.getClass().getResource("/Image/roll6.png"));
        this.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        setIcon(rollA1);
    }
}
