/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myhilo;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.Timer;
import static myhilo.LoginForm.username;



/**
 *
 * @author hp
 */
public class StarForm extends javax.swing.JFrame {

    /**
     * Creates new form StarForm
     */
    static LoginForm login = new LoginForm();
    static List<String> userLog = new ArrayList<>();
    static List<Integer> userMoney = new ArrayList<>();
    static List<String> userLogin = new ArrayList<>();
    static List<Integer> userMoneyShow = new ArrayList<>();
    static List<String> userLoginShow = new ArrayList<>();    
    public void fileOpen(){
         try {
            File theFile = new File("src/newfile.log");
            Scanner fileScanner = new Scanner(theFile);
            while(fileScanner.hasNextLine()){
                String[] menu = fileScanner.nextLine().replaceAll(" : ","  ").split("  ");
                if(!menu[0].equals("##")) {
             userLog.add(menu[0]);
              }
            }
               

        } catch (FileNotFoundException e) {
            System.out.print(e);
        }
        
         try {
         File theFile1 = new File("src/usernamepassword.log");
         Scanner fileScanner = new Scanner(theFile1);
          while(fileScanner.hasNextLine()){
                String[] menu = fileScanner.nextLine().replaceAll(" : ","  ").split("  ");
                if(!menu[0].equals("##")) {
                    userLogin.add(menu[0]);
                    userMoney.add(Integer.parseInt(menu[2]));
                }
                if(menu[0].equals(userLog.get(0))){
                    userMoneyShow.add(Integer.parseInt(menu[2]));
                    userLoginShow.add(menu[0]);
                }
          }
         } catch(FileNotFoundException e) {
            System.out.print(e);
         }
         setText();
        
        
    }
    public void setText(){
    String mn = Integer.toString(userMoneyShow.get(0));
        MnString.setText(mn);
        usShow.setText(userLoginShow.get(0));
//        System.out.println(userLoginShow.get(0));
}
    public StarForm() {
                backGroundAnimetion();
        backGroundAnimetion2();
        setSize(900, 500);
        this.setResizable(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        initComponents();
        fileOpen();
       
        
        
     }
    public void backGroundAnimetion2(){
        Timer t1 = new Timer(15 , new ActionListener(){
        
                public void actionPerformed(ActionEvent e ){
                    
                    if (i<-15||i>850)
                        veri  =  -veri;
                    if (j>81 || j<-8)
                        verj = -verj;
                       i += veri;
                       j += verj;
                      ship1.setLocation(i, j);     
                       }
            });
        Timer t2 = new Timer(15 , new ActionListener(){
        
                public void actionPerformed(ActionEvent e ){
                    
                    if (i2<-15||i2>850)
                        veri2  =  -veri2;
                    if (j2>81 || j2<-8)
                        verj2 = -verj2;
                       i2 += veri2;
                       j2 += verj2;
                      ship2.setLocation(i2, j2);     
                       }
            });
        Timer t3 = new Timer(15 , new ActionListener(){
        
                public void actionPerformed(ActionEvent e ){
                    
                    if (i3<-15||i3>850)
                        veri3  =  -veri3;
                    if (j3>81 || j3<-8)
                        verj3 = -verj3;
                       i3 += veri3;
                       j3 += verj3;
                      ship3.setLocation(i3, j3);     
                       }
            });
        Timer t4 = new Timer(15 , new ActionListener(){
        
                public void actionPerformed(ActionEvent e ){
                    
                    if (i4<-15||i4>850)
                        veri4  =  -veri4;
                    if (j4>81 || j4<-8)
                        verj4 = -verj4;
                       i4 += veri4;
                       j4 += verj4;
                      ship4.setLocation(i4, j4);     
                       }
            });
        Timer t5 = new Timer(15 , new ActionListener(){
        
                public void actionPerformed(ActionEvent e ){
                    
                    if (i5<-15||i5>850)
                        veri5  =  -veri5;
                    if (j5>81 || j5<-8)
                        verj5 = -verj5;
                       i5 += veri5;
                       j5 += verj5;
                      ship5.setLocation(i5, j5);     
                       }
            });
      
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        
    }
    int i = 0 , j =0, veri =2, verj =1;
    int  i2 =50 , i3 =100 , i4 =150, i5 =200;
    int  j2 =10, veri2 =2, verj2 =1;
    int  j3 =20, veri3 =2, verj3=1;
    int  j4 =30, veri4 =2, verj4 =1;
    int j5 =40, veri5 =2, verj5 =1;
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public void backGroundAnimetion(){

    Timer tm1 = new Timer(15 , new ActionListener(){
        
                public void actionPerformed(ActionEvent e ){
                    
                    if (x<0||x>890)
                        verX  =  -verX;
                    if (y>500 || y<127)
                        verY = -verY;
                       x += verX;
                       y += verY;
                      Dice1.setLocation(x, y);     
                       }
            });
    
    Timer tm2 = new Timer(15 , new ActionListener(){
       
                public void actionPerformed(ActionEvent e ){
                    
                    if (x2<0||x2>890)
                        verX2  =  -verX2;
                    if (y2>500 || y2<127)
                        verY2 = -verY2;
                       x2 += verX2;
                       y2 += verY2;
                       
                      Dice2.setLocation(x2, y2);     
                       
                }
            });
    Timer tm3 = new Timer(15 , new ActionListener(){
       
                public void actionPerformed(ActionEvent e ){
                    
                    if (x3<0||x3>890)
                        verX3  =  -verX3;
                    if (y3>500 || y3<127)
                        verY3 = -verY3;
                       x3 += verX3;
                       y3 += verY3;
                       
                      Dice3.setLocation(x3, y3);     
                       
                }
            });
    Timer tm4 = new Timer(15 , new ActionListener(){
       
                public void actionPerformed(ActionEvent e ){
                    
                    if (x4<0||x4>890)
                        verX4  =  -verX4;
                    if (y4>500 || y4<127)
                        verY4 = -verY4;
                       x4 += verX4;
                       y4 += verY4;
                       
                      Dice4.setLocation(x4, y4);     
                       
                }
            });
    Timer tm5 = new Timer(15 , new ActionListener(){
       
                public void actionPerformed(ActionEvent e ){
                    
                    if (x5<0||x5>890)
                        verX5  =  -verX5;
                    if (y5>500 || y5<127)
                        verY5 = -verY5;
                       x5 += verX5;
                       y5 += verY5;
                       
                      Dice5.setLocation(x5, y5);     
                       
                }
            });
    Timer tm6 = new Timer(15 , new ActionListener(){
       
                public void actionPerformed(ActionEvent e ){
                    
                    if (x6<0||x6>890)
                        verX6  =  -verX6;
                    if (y6>500 || y6<127)
                        verY6 = -verY6;
                       x6 += verX6;
                       y6 += verY6;
                     Dice6.setLocation(x6, y6);     
                     }
            });
    
    tm2.start();
    tm1.start();
    tm3.start();
    tm4.start();
    tm5.start();
    tm6.start();
 }
 int x = 200,y =300,verX=1, verY=3;
 int x2 = 100 , y2 = 127, verX2 = -2 , verY2 = 2;
 int x3 = 899 , y3 = 421, verX3 = -2 , verY5 = 1;
 int x4 = 700 , y5 = 432, verX4 = 1 , verY4 = 3;
 int x5 = 200 , y6 = 456, verX5 = -3 , verY6 = 2;
 int x6 = 648 , y4 = 249, verX6 = 4 , verY3 = 1;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Dice6 = new javax.swing.JLabel();
        Dice5 = new javax.swing.JLabel();
        Dice4 = new javax.swing.JLabel();
        Dice3 = new javax.swing.JLabel();
        Dice2 = new javax.swing.JLabel();
        Dice1 = new javax.swing.JLabel();
        PlayButt = new javax.swing.JButton();
        ship1 = new javax.swing.JLabel();
        ship2 = new javax.swing.JLabel();
        ship3 = new javax.swing.JLabel();
        ship4 = new javax.swing.JLabel();
        ship5 = new javax.swing.JLabel();
        HighLowtexT = new javax.swing.JTextField();
        MnString = new javax.swing.JTextField();
        Money = new javax.swing.JLabel();
        usShow = new javax.swing.JTextField();
        LogoutBut = new javax.swing.JButton();
        Background = new javax.swing.JLabel();

        Dice6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/dice6.png"))); // NOI18N

        Dice5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/dice6.png"))); // NOI18N

        Dice4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/dice4.png"))); // NOI18N

        Dice3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/dice3.png"))); // NOI18N

        Dice2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/dice2.png"))); // NOI18N

        Dice1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/dice1.png"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PlayButt.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        PlayButt.setText("Play");
        PlayButt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PlayButt.setFocusable(false);
        PlayButt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayButtActionPerformed(evt);
            }
        });
        getContentPane().add(PlayButt, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, -1, -1));

        ship1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ship200.png"))); // NOI18N
        getContentPane().add(ship1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 70, 50));

        ship2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ship100.png"))); // NOI18N
        getContentPane().add(ship2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 70, 50));

        ship3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ship50.png"))); // NOI18N
        getContentPane().add(ship3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 70, 50));

        ship4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ship20.png"))); // NOI18N
        getContentPane().add(ship4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 0, 70, 50));

        ship5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ship10.png"))); // NOI18N
        getContentPane().add(ship5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 70, 50));

        HighLowtexT.setFont(new java.awt.Font("Tahoma", 0, 80)); // NOI18N
        HighLowtexT.setText("HILO GAME");
        HighLowtexT.setBorder(null);
        HighLowtexT.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        HighLowtexT.setFocusable(false);
        getContentPane().add(HighLowtexT, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, -1, -1));

        MnString.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        MnString.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        MnString.setText("Money");
        MnString.setAutoscrolls(false);
        MnString.setBorder(null);
        MnString.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MnString.setFocusable(false);
        MnString.setRequestFocusEnabled(false);
        getContentPane().add(MnString, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 450, 100, 30));

        Money.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/money.png"))); // NOI18N
        getContentPane().add(Money, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 160, 50));

        usShow.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        usShow.setForeground(new java.awt.Color(255, 51, 51));
        usShow.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usShow.setText("Username");
        usShow.setBorder(null);
        usShow.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        usShow.setFocusable(false);
        getContentPane().add(usShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 140, 40));

        LogoutBut.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        LogoutBut.setForeground(new java.awt.Color(255, 51, 51));
        LogoutBut.setText("Logout");
        LogoutBut.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        LogoutBut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LogoutBut.setFocusPainted(false);
        LogoutBut.setFocusable(false);
        LogoutBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutButActionPerformed(evt);
            }
        });
        getContentPane().add(LogoutBut, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 460, 80, 30));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imageStart/BG.png"))); // NOI18N
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PlayButtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayButtActionPerformed
       Mygame playGame = new Mygame();
       userLog.clear();
       userLogin.clear();
       userMoney.clear();
       userLoginShow.clear();
       userMoneyShow.clear();
       playGame.setVisible(true);
       what.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_PlayButtActionPerformed

    private void LogoutButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutButActionPerformed
       LoginForm logout = new LoginForm();
       userLog.clear();
       userLogin.clear();
       userMoney.clear();
       userLoginShow.clear();
       userMoneyShow.clear();
       logout.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_LogoutButActionPerformed
 static HowToPlay what = new HowToPlay();
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StarForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StarForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StarForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StarForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StarForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JLabel Dice1;
    private javax.swing.JLabel Dice2;
    private javax.swing.JLabel Dice3;
    private javax.swing.JLabel Dice4;
    private javax.swing.JLabel Dice5;
    private javax.swing.JLabel Dice6;
    private javax.swing.JTextField HighLowtexT;
    private javax.swing.JButton LogoutBut;
    private javax.swing.JTextField MnString;
    private javax.swing.JLabel Money;
    private javax.swing.JButton PlayButt;
    private javax.swing.JLabel ship1;
    private javax.swing.JLabel ship2;
    private javax.swing.JLabel ship3;
    private javax.swing.JLabel ship4;
    private javax.swing.JLabel ship5;
    private javax.swing.JTextField usShow;
    // End of variables declaration//GEN-END:variables
}
