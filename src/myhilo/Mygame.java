/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myhilo;
import java.awt.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
     

public class Mygame extends JFrame {
    
    static List<Integer> userMoney = new ArrayList<>();
    static List<String> password = new ArrayList<>();
    static List<String> userLogin = new ArrayList<>();
    static List<Integer> userMoneyShow = new ArrayList<>();
    static List<String> userLoginShow = new ArrayList<>();
    static List<String> userLog = new ArrayList<>();
    
    
    public void setArrayList(){
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
                    password.add(menu[1]);
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
        
        String mn = Integer.toString(userMoneyShow.get(0));
        MnString.setText(mn);
        usShow.setText(userLoginShow.get(0));
        money = userMoneyShow.get(0);
    }
    
    public void setSaveStatus(){
        String logFilePath = "src/usernamepassword.log";
        OutputStream os = null;
        try {
            os = new FileOutputStream(logFilePath);
        } catch (FileNotFoundException ex) {
            System.out.println("Couldn't open output file " + logFilePath);
            return;
        }
        PrintStream logSave = new PrintStream(os);
        
        for (int i = 0 ; i < userLogin.size() ; i++){
            if(userLoginShow.get(0).equals(userLogin.get(i))){
                userMoney.set(i,money);
            }
            logSave.printf("%s : %s : %s%n",userLogin.get(i),password.get(i),userMoney.get(i));
        }
        logSave.close();
    }
    
    static Random rd = new Random();
    static int rollA,rollB,rollC,roll;
    static MyHiLO hilo = new MyHiLO();
    
    static StarForm user = new StarForm();
    
    static int money = 1000;
    static boolean check;
    static int bet,gotBet;
    
    int betMoney = 0;
    String setBetMoney = " ";
      public void setMoney(){
          String mn = Integer.toString(money);
          MnString.setText(mn);
          
      }
      public void setRoll(){
          String rollS = Integer.toString(roll);
          totalBox.setText(rollS);
      }
          
       public void diceRolling(){
        rollA = rd.nextInt(6)+1;
        rollB = rd.nextInt(6)+1;
        rollC = rd.nextInt(6)+1;
//        check triple
//        rollA = 1; rollB = 1; rollC=1;
        roll = rollA+rollB+rollC;
    }
       public void betTime(){
           bet = betMoney;
           gotBet = timeToGot();
           if (!null1.isSelected() && !null2.isSelected()){
               if(check){
                   LoseWin.setForeground(Color.GREEN);
                   LoseWin.setText("YOU WIN!");
                   losewinbar.setForeground(Color.BLACK);
                   losewinbar.setText("You win money");
                   howmuchlostwin.setForeground(Color.GREEN);
                   howmuchlostwin.setText(Integer.toString(bet*gotBet) +" Bath.");
                   money += bet*gotBet;
               }else{
                   LoseWin.setForeground(Color.RED);
                   LoseWin.setText("YOU LOSE!");
                   losewinbar.setForeground(Color.BLACK);
                   losewinbar.setText("You lose money");
                   howmuchlostwin.setForeground(Color.RED);
                   howmuchlostwin.setText(Integer.toString(bet)+" Bath.");
                   money -= bet;
               }
           } 
           if(money<=0){
               money = 1000;
               betMoney=0;
               setBetMoney = Integer.toString(betMoney);
               whatSelectShip.setText(setBetMoney+" BATH");
               GetFreeMoney get = new GetFreeMoney();
               get.setVisible(true);
           }
           if(betMoney > money){
           betMoney = money;
           setBetMoney = Integer.toString(betMoney);
           whatSelectShip.setText(setBetMoney+" BATH");
           }
           setMoney();
           setSaveStatus();
       }
//       public int howMuchBet(){
//           if(ship10select.isSelected()){
//               return 10;
//           }if (ship20select.isSelected()){
//               return 20;
//           }if (ship50select.isSelected()){
//               return 50;
//           }if (ship100select.isSelected()){
//               return 100;
//           }if (ship200select.isSelected()){
//               return 200;
//           }
//           return 0;
//       }
       public int timeToGot(){
           if(oneOrfiveselect.isSelected()){
            return 2;
         }if(fivelowselect.isSelected()){
             return 3;
         }if(elevenHiLowselect.isSelected()){
             return 3;
         }if(sixlowselect.isSelected()){
            return 3;
         }if(sixOrtwoselect.isSelected()){
             return 2;
         }if(oneOrsixselect.isSelected() || sixOroneselect.isSelected()){
             return 2;
         }if(oneselect.isSelected()){
             return 1;
         }if(lowselect.isSelected()){
             return 1;
         }if(highselect.isSelected()){
             return 1;
         }if(sixselect.isSelected()){
             return 1;
         }if(twoOrfiveselect.isSelected() || fiveOrtwoselect.isSelected()){
            return 2;
         }if(twoselect.isSelected()){
             return 1;
         }if(threeselect.isSelected()){
             return 1;
         }if(fourselect.isSelected()){
             return 1;
         }if(fiveselect.isSelected()){
             return 1;
         }if(onetwothreeselect.isSelected()){
             return 5;
         }if(threeOrsixselect.isSelected()){
             return 2;
         }if(twoOrfourselect.isSelected()){
             return 2;
         }if(threeOrfiveselect.isSelected()){
             return 2;
         }if(fourOroneselect.isSelected()){
             return 2;
         }if(fourfivesixselect.isSelected()){
             return 5;
         }
         return 0;
       }
     public void whatSelected(){
         if(rollA == rollB && rollA == rollC && rollB == rollC){
             check = false;
         }else{
         if(oneOrfiveselect.isSelected()){
            check = hilo.is1and5(rollA, rollB, rollC);
         }if(fivelowselect.isSelected()){
             check = hilo.is5lo(rollA, rollB, rollC, roll);
         }if(elevenHiLowselect.isSelected()){
             check = hilo.is11hilo(roll);
         }if(sixlowselect.isSelected()){
             check = hilo.is6lo(rollA, rollB, rollC, roll);
         }if(sixOrtwoselect.isSelected()){
             check = hilo.is6and2(rollA, rollB, rollC);
         }if(oneOrsixselect.isSelected() || sixOroneselect.isSelected()){
             check = hilo.is1and6(rollA, rollB, rollC);
         }if(oneselect.isSelected()){
             check = hilo.isFace1(rollA, rollB, rollC);
         }if(lowselect.isSelected()){
             check = hilo.isLow(roll);
         }if(highselect.isSelected()){
             check = hilo.isHigh(roll);
         }if(sixselect.isSelected()){
             check = hilo.isFace6(rollA, rollB, rollC);
         }if(twoOrfiveselect.isSelected() || fiveOrtwoselect.isSelected()){
             check = hilo.is2and5(rollA, rollB, rollC);
         }if(twoselect.isSelected()){
             check = hilo.isFace2(rollA, rollB, rollC);
         }if(threeselect.isSelected()){
             check = hilo.isFace3(rollA, rollB, rollC);
         }if(fourselect.isSelected()){
             check = hilo.isFace4(rollA, rollB, rollC);
         }if(fiveselect.isSelected()){
             check = hilo.isFace5(rollA, rollB, rollC);
         }if(onetwothreeselect.isSelected()){
             check = hilo.is123(rollA, rollB, rollC);
         }if(threeOrsixselect.isSelected()){
             check = hilo.is3and6(rollA, rollB, rollC);
         }if(twoOrfourselect.isSelected()){
             check = hilo.is2and4(rollA, rollB, rollC);
         }if(threeOrfiveselect.isSelected()){
             check = hilo.is3and5(rollA, rollB, rollC);
         }if(fourOroneselect.isSelected()){
             check = hilo.is4and1(rollA, rollB, rollC);
         }if(fourfivesixselect.isSelected()){
             check = hilo.is456(rollA, rollB, rollC);
         }
         }
     } 
    public void rollDice(){
        if(rollA==1){
             diceShow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/roll1.png")));
             dice1.setIcon(new ImageIcon(getClass().getResource("/Image/dice1.png")));
        }if(rollA==2){
             diceShow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/roll2.png")));
             dice1.setIcon(new ImageIcon(getClass().getResource("/Image/dice2.png")));
        }if(rollA==3){
             diceShow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/roll3.png")));
             dice1.setIcon(new ImageIcon(getClass().getResource("/Image/dice3.png")));
        }if(rollA==4){
             diceShow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/roll4.png")));
             dice1.setIcon(new ImageIcon(getClass().getResource("/Image/dice4.png")));
        }if(rollA==5){
             diceShow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/roll5.png")));
             dice1.setIcon(new ImageIcon(getClass().getResource("/Image/dice5.png")));
        }if(rollA==6){
             diceShow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/roll6.png")));
             dice1.setIcon(new ImageIcon(getClass().getResource("/Image/dice6.png")));
        }
         if(rollB==1){
             diceShow2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/roll1.png")));
             dice2.setIcon(new ImageIcon(getClass().getResource("/Image/dice1.png")));
        }if(rollB==2){
             diceShow2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/roll2.png")));
             dice2.setIcon(new ImageIcon(getClass().getResource("/Image/dice2.png")));
        }if(rollB==3){
             diceShow2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/roll3.png")));
             dice2.setIcon(new ImageIcon(getClass().getResource("/Image/dice3.png")));
        }if(rollB==4){
             diceShow2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/roll4.png")));
             dice2.setIcon(new ImageIcon(getClass().getResource("/Image/dice4.png")));
        }if(rollB==5){
             diceShow2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/roll5.png")));
             dice2.setIcon(new ImageIcon(getClass().getResource("/Image/dice5.png")));
        }if(rollB==6){
             diceShow2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/roll6.png")));
             dice2.setIcon(new ImageIcon(getClass().getResource("/Image/dice6.png")));
        }
         if(rollC==1){
             diceShow3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/roll1.png")));
             dice3.setIcon(new ImageIcon(getClass().getResource("/Image/dice1.png")));
        }if(rollC==2){
             diceShow3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/roll2.png")));
             dice3.setIcon(new ImageIcon(getClass().getResource("/Image/dice2.png")));
        }if(rollC==3){
             diceShow3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/roll3.png")));
             dice3.setIcon(new ImageIcon(getClass().getResource("/Image/dice3.png")));
        }if(rollC==4){
             diceShow3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/roll4.png")));
             dice3.setIcon(new ImageIcon(getClass().getResource("/Image/dice4.png")));
        }if(rollC==5){
             diceShow3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/roll5.png")));
             dice3.setIcon(new ImageIcon(getClass().getResource("/Image/dice5.png")));
        }if(rollC==6){
             diceShow3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/roll6.png")));
             dice3.setIcon(new ImageIcon(getClass().getResource("/Image/dice6.png")));
        }
        setRoll();
    }
    public void setWindow(){
        setBackground(Color.LIGHT_GRAY);
        setSize(1024, 768);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }
    public Mygame() {
        setWindow();
        setMoney();
        setArrayList();
       null1.setSelected(rootPaneCheckingEnabled);
       null2.setSelected(rootPaneCheckingEnabled);
        
    }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        HiLoSelect = new javax.swing.ButtonGroup();
        shipselect = new javax.swing.ButtonGroup();
        six = new javax.swing.JLabel();
        cover = new javax.swing.JLabel();
        dice1 = new javax.swing.JLabel();
        dice2 = new javax.swing.JLabel();
        dice3 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        diceShow3 = new javax.swing.JLabel();
        diceShow2 = new javax.swing.JLabel();
        diceShow1 = new javax.swing.JLabel();
        Reset = new javax.swing.JButton();
        MnString = new javax.swing.JTextField();
        Money = new javax.swing.JLabel();
        ship20 = new javax.swing.JLabel();
        ship50 = new javax.swing.JLabel();
        ship100 = new javax.swing.JLabel();
        ship200 = new javax.swing.JLabel();
        ship10 = new javax.swing.JLabel();
        elevenHiLo = new javax.swing.JLabel();
        fivelow = new javax.swing.JLabel();
        sixlow = new javax.swing.JLabel();
        threeOrsix = new javax.swing.JLabel();
        high = new javax.swing.JLabel();
        low = new javax.swing.JLabel();
        one = new javax.swing.JLabel();
        oneOrsix = new javax.swing.JLabel();
        fiveOrtwo = new javax.swing.JLabel();
        two = new javax.swing.JLabel();
        five = new javax.swing.JLabel();
        three = new javax.swing.JLabel();
        four = new javax.swing.JLabel();
        twoOrfive = new javax.swing.JLabel();
        oneORfive = new javax.swing.JLabel();
        onetwothree = new javax.swing.JLabel();
        fourfivesix = new javax.swing.JLabel();
        fourOrone = new javax.swing.JLabel();
        threeOrfive = new javax.swing.JLabel();
        twoOrfour = new javax.swing.JLabel();
        sixOrone = new javax.swing.JLabel();
        sixOrtwo = new javax.swing.JLabel();
        oneORfive21 = new javax.swing.JLabel();
        Hilo = new javax.swing.JLabel();
        Plate = new javax.swing.JLabel();
        totalText = new javax.swing.JTextField();
        totalBox = new javax.swing.JTextField();
        whatSelectBet = new javax.swing.JTextField();
        whatSelectShip = new javax.swing.JTextField();
        BetText = new javax.swing.JTextField();
        BetText1 = new javax.swing.JTextField();
        LoseWin = new javax.swing.JTextField();
        howmuchlostwin = new javax.swing.JTextField();
        losewinbar = new javax.swing.JTextField();
        What = new javax.swing.JTextField();
        usShow = new javax.swing.JTextField();
        Back = new javax.swing.JLabel();
        background = new javax.swing.JLabel();
        oneOrfiveselect = new javax.swing.JRadioButton();
        fivelowselect = new javax.swing.JRadioButton();
        elevenHiLowselect = new javax.swing.JRadioButton();
        sixlowselect = new javax.swing.JRadioButton();
        sixOrtwoselect = new javax.swing.JRadioButton();
        oneOrsixselect = new javax.swing.JRadioButton();
        oneselect = new javax.swing.JRadioButton();
        lowselect = new javax.swing.JRadioButton();
        highselect = new javax.swing.JRadioButton();
        sixselect = new javax.swing.JRadioButton();
        sixOroneselect = new javax.swing.JRadioButton();
        twoOrfiveselect = new javax.swing.JRadioButton();
        twoselect = new javax.swing.JRadioButton();
        threeselect = new javax.swing.JRadioButton();
        fourselect = new javax.swing.JRadioButton();
        fiveselect = new javax.swing.JRadioButton();
        fiveOrtwoselect = new javax.swing.JRadioButton();
        onetwothreeselect = new javax.swing.JRadioButton();
        threeOrsixselect = new javax.swing.JRadioButton();
        twoOrfourselect = new javax.swing.JRadioButton();
        threeOrfiveselect = new javax.swing.JRadioButton();
        fourOroneselect = new javax.swing.JRadioButton();
        fourfivesixselect = new javax.swing.JRadioButton();
        null1 = new javax.swing.JRadioButton();
        null2 = new javax.swing.JRadioButton();
        ship200select = new javax.swing.JRadioButton();
        ship100select = new javax.swing.JRadioButton();
        ship50select = new javax.swing.JRadioButton();
        ship20select = new javax.swing.JRadioButton();
        ship10select = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        six.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        six.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sixMouseClicked(evt);
            }
        });
        getContentPane().add(six, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 330, 100, 90));

        cover.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cover.png"))); // NOI18N
        getContentPane().add(cover, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, -1, -1));

        dice1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/dice1.png"))); // NOI18N
        getContentPane().add(dice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(496, 100, 20, -1));

        dice2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/dice1.png"))); // NOI18N
        getContentPane().add(dice2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, -1, -1));

        dice3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/dice1.png"))); // NOI18N
        getContentPane().add(dice3, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 100, -1, -1));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jButton2.setText("Roll");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 150, 90));

        diceShow3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/rolll.png"))); // NOI18N
        getContentPane().add(diceShow3, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 80, -1, -1));

        diceShow2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/rolll.png"))); // NOI18N
        getContentPane().add(diceShow2, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 80, -1, -1));

        diceShow1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/rolll.png"))); // NOI18N
        getContentPane().add(diceShow1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 80, -1, -1));

        Reset.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Reset.setText("Reset");
        Reset.setToolTipText("");
        Reset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetActionPerformed(evt);
            }
        });
        getContentPane().add(Reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(693, 640, 120, 70));

        MnString.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        MnString.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        MnString.setText("Money");
        MnString.setAutoscrolls(false);
        MnString.setBorder(null);
        MnString.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        MnString.setFocusable(false);
        MnString.setRequestFocusEnabled(false);
        getContentPane().add(MnString, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 100, 30));

        Money.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/money.png"))); // NOI18N
        getContentPane().add(Money, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 160, 50));

        ship20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ship20.png"))); // NOI18N
        ship20.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ship20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ship20MouseClicked(evt);
            }
        });
        getContentPane().add(ship20, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 650, -1, -1));

        ship50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ship50.png"))); // NOI18N
        ship50.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ship50.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ship50MouseClicked(evt);
            }
        });
        getContentPane().add(ship50, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 650, -1, -1));

        ship100.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ship100.png"))); // NOI18N
        ship100.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ship100.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ship100MouseClicked(evt);
            }
        });
        getContentPane().add(ship100, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 650, -1, -1));

        ship200.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ship200.png"))); // NOI18N
        ship200.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ship200.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ship200MouseClicked(evt);
            }
        });
        getContentPane().add(ship200, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 650, -1, -1));

        ship10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/ship10.png"))); // NOI18N
        ship10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ship10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ship10MouseClicked(evt);
            }
        });
        getContentPane().add(ship10, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 650, -1, -1));

        elevenHiLo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        elevenHiLo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                elevenHiLoMouseClicked(evt);
            }
        });
        getContentPane().add(elevenHiLo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 200, 90));

        fivelow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fivelow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fivelowMouseClicked(evt);
            }
        });
        getContentPane().add(fivelow, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 100, 90));

        sixlow.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sixlow.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sixlowMouseClicked(evt);
            }
        });
        getContentPane().add(sixlow, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 230, 90, 90));

        threeOrsix.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        threeOrsix.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                threeOrsixMouseClicked(evt);
            }
        });
        getContentPane().add(threeOrsix, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 520, 100, 100));

        high.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        high.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                highMouseClicked(evt);
            }
        });
        getContentPane().add(high, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 330, 90, 90));

        low.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        low.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lowMouseClicked(evt);
            }
        });
        getContentPane().add(low, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 330, 100, 90));

        one.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        one.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                oneMouseClicked(evt);
            }
        });
        getContentPane().add(one, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 100, 90));

        oneOrsix.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        oneOrsix.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                oneOrsixMouseClicked(evt);
            }
        });
        getContentPane().add(oneOrsix, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 330, 100, 90));

        fiveOrtwo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fiveOrtwo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fiveOrtwoMouseClicked(evt);
            }
        });
        getContentPane().add(fiveOrtwo, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 420, 100, 100));

        two.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        two.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                twoMouseClicked(evt);
            }
        });
        getContentPane().add(two, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 420, 100, 100));

        five.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        five.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fiveMouseClicked(evt);
            }
        });
        getContentPane().add(five, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 420, 100, 100));

        three.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        three.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                threeMouseClicked(evt);
            }
        });
        getContentPane().add(three, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 420, 100, 100));

        four.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        four.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fourMouseClicked(evt);
            }
        });
        getContentPane().add(four, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 420, 90, 100));

        twoOrfive.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        twoOrfive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                twoOrfiveMouseClicked(evt);
            }
        });
        getContentPane().add(twoOrfive, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 420, 100, 100));

        oneORfive.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        oneORfive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                oneORfiveMouseClicked(evt);
            }
        });
        getContentPane().add(oneORfive, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 100, 90));

        onetwothree.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        onetwothree.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                onetwothreeMouseClicked(evt);
            }
        });
        getContentPane().add(onetwothree, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 520, 100, 100));

        fourfivesix.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fourfivesix.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fourfivesixMouseClicked(evt);
            }
        });
        getContentPane().add(fourfivesix, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 520, 100, 100));

        fourOrone.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        fourOrone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fourOroneMouseClicked(evt);
            }
        });
        getContentPane().add(fourOrone, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 520, 100, 100));

        threeOrfive.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        threeOrfive.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                threeOrfiveMouseClicked(evt);
            }
        });
        getContentPane().add(threeOrfive, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 520, 110, 100));

        twoOrfour.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        twoOrfour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                twoOrfourMouseClicked(evt);
            }
        });
        getContentPane().add(twoOrfour, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 520, 100, 100));

        sixOrone.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sixOrone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sixOroneMouseClicked(evt);
            }
        });
        getContentPane().add(sixOrone, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 330, 100, 90));

        sixOrtwo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sixOrtwo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sixOrtwoMouseClicked(evt);
            }
        });
        getContentPane().add(sixOrtwo, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 230, 100, 90));

        oneORfive21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                oneORfive21MouseClicked(evt);
            }
        });
        getContentPane().add(oneORfive21, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 240, 80, 70));

        Hilo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/hilo.png"))); // NOI18N
        Hilo.setText("jLabel1");
        getContentPane().add(Hilo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, 650, 420));

        Plate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/plate.png"))); // NOI18N
        getContentPane().add(Plate, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 230, -1));

        totalText.setBackground(new java.awt.Color(86, 57, 57));
        totalText.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        totalText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totalText.setText("Totals");
        totalText.setBorder(null);
        totalText.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        totalText.setFocusable(false);
        getContentPane().add(totalText, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 210, 160, 50));

        totalBox.setBackground(new java.awt.Color(86, 57, 57));
        totalBox.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        totalBox.setForeground(new java.awt.Color(255, 0, 0));
        totalBox.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        totalBox.setText("0");
        totalBox.setBorder(null);
        totalBox.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        totalBox.setFocusable(false);
        getContentPane().add(totalBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 260, 100, 50));

        whatSelectBet.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        whatSelectBet.setForeground(new java.awt.Color(204, 204, 204));
        whatSelectBet.setText("bet selected");
        whatSelectBet.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        whatSelectBet.setFocusable(false);
        getContentPane().add(whatSelectBet, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 340, 110, 40));

        whatSelectShip.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        whatSelectShip.setForeground(new java.awt.Color(204, 204, 204));
        whatSelectShip.setText("Ship selected");
        whatSelectShip.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        whatSelectShip.setFocusable(false);
        getContentPane().add(whatSelectShip, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 390, 110, 30));

        BetText.setBackground(new java.awt.Color(86, 57, 57));
        BetText.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        BetText.setText("Bet :");
        BetText.setBorder(null);
        BetText.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BetText.setFocusable(false);
        getContentPane().add(BetText, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 340, 70, 40));

        BetText1.setBackground(new java.awt.Color(86, 57, 57));
        BetText1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        BetText1.setText("Ship :");
        BetText1.setBorder(null);
        BetText1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        BetText1.setFocusable(false);
        getContentPane().add(BetText1, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 390, 70, 30));

        LoseWin.setBackground(new java.awt.Color(86, 57, 57));
        LoseWin.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        LoseWin.setForeground(new java.awt.Color(86, 57, 57));
        LoseWin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        LoseWin.setText("YOU LOSE!");
        LoseWin.setToolTipText("");
        LoseWin.setBorder(null);
        LoseWin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        LoseWin.setFocusable(false);
        getContentPane().add(LoseWin, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 460, 190, -1));

        howmuchlostwin.setBackground(new java.awt.Color(86, 57, 57));
        howmuchlostwin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        howmuchlostwin.setForeground(new java.awt.Color(86, 57, 57));
        howmuchlostwin.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        howmuchlostwin.setText("1000 bath.");
        howmuchlostwin.setBorder(null);
        howmuchlostwin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        howmuchlostwin.setFocusable(false);
        getContentPane().add(howmuchlostwin, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 560, 170, -1));

        losewinbar.setBackground(new java.awt.Color(86, 57, 57));
        losewinbar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        losewinbar.setForeground(new java.awt.Color(86, 57, 57));
        losewinbar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        losewinbar.setText("YOU LOST MONEY:");
        losewinbar.setBorder(null);
        losewinbar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        losewinbar.setFocusable(false);
        getContentPane().add(losewinbar, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 530, 170, -1));

        What.setBackground(new java.awt.Color(86, 57, 57));
        What.setFont(new java.awt.Font("Yu Gothic UI Semilight", 1, 100)); // NOI18N
        What.setForeground(new java.awt.Color(255, 51, 51));
        What.setText("?");
        What.setBorder(null);
        What.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        What.setFocusable(false);
        What.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                WhatMouseClicked(evt);
            }
        });
        getContentPane().add(What, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 660, 50, 90));

        usShow.setBackground(new java.awt.Color(86, 57, 57));
        usShow.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        usShow.setForeground(new java.awt.Color(255, 51, 51));
        usShow.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        usShow.setText("Username");
        usShow.setBorder(null);
        usShow.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        usShow.setFocusable(false);
        getContentPane().add(usShow, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 150, 40));

        Back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/backas.png"))); // NOI18N
        Back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Back.setFocusable(false);
        Back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BackMouseClicked(evt);
            }
        });
        getContentPane().add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 680, 120, 90));

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/pathHiLo.png"))); // NOI18N
        getContentPane().add(background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, -1));

        HiLoSelect.add(oneOrfiveselect);
        getContentPane().add(oneOrfiveselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HiLoSelect.add(fivelowselect);
        fivelowselect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fivelowselectActionPerformed(evt);
            }
        });
        getContentPane().add(fivelowselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HiLoSelect.add(elevenHiLowselect);
        getContentPane().add(elevenHiLowselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HiLoSelect.add(sixlowselect);
        getContentPane().add(sixlowselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HiLoSelect.add(sixOrtwoselect);
        getContentPane().add(sixOrtwoselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HiLoSelect.add(oneOrsixselect);
        getContentPane().add(oneOrsixselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HiLoSelect.add(oneselect);
        getContentPane().add(oneselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HiLoSelect.add(lowselect);
        getContentPane().add(lowselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HiLoSelect.add(highselect);
        getContentPane().add(highselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HiLoSelect.add(sixselect);
        getContentPane().add(sixselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HiLoSelect.add(sixOroneselect);
        getContentPane().add(sixOroneselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HiLoSelect.add(twoOrfiveselect);
        getContentPane().add(twoOrfiveselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HiLoSelect.add(twoselect);
        getContentPane().add(twoselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HiLoSelect.add(threeselect);
        getContentPane().add(threeselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HiLoSelect.add(fourselect);
        getContentPane().add(fourselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HiLoSelect.add(fiveselect);
        getContentPane().add(fiveselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HiLoSelect.add(fiveOrtwoselect);
        getContentPane().add(fiveOrtwoselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HiLoSelect.add(onetwothreeselect);
        getContentPane().add(onetwothreeselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HiLoSelect.add(threeOrsixselect);
        getContentPane().add(threeOrsixselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HiLoSelect.add(twoOrfourselect);
        getContentPane().add(twoOrfourselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HiLoSelect.add(threeOrfiveselect);
        getContentPane().add(threeOrfiveselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HiLoSelect.add(fourOroneselect);
        getContentPane().add(fourOroneselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HiLoSelect.add(fourfivesixselect);
        getContentPane().add(fourfivesixselect, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        HiLoSelect.add(null1);
        null1.setText("jRadioButton1");
        getContentPane().add(null1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        shipselect.add(null2);
        null2.setText("jRadioButton1");
        getContentPane().add(null2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        shipselect.add(ship200select);
        getContentPane().add(ship200select, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        shipselect.add(ship100select);
        getContentPane().add(ship100select, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        shipselect.add(ship50select);
        getContentPane().add(ship50select, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        shipselect.add(ship20select);
        getContentPane().add(ship20select, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        shipselect.add(ship10select);
        getContentPane().add(ship10select, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            
        
//            jLabel6.setIcon(new ImageIcon(getClass().getResource("/Image/rolll.png")));
//            jLabel7.setIcon(new ImageIcon(getClass().getResource("/Image/rolll.png")));
//            jLabel8.setIcon(new ImageIcon(getClass().getResource("/Image/rolll.png")));
           
            Timer tm2 = new Timer (30,new ActionListener(){
                
                public void actionPerformed(ActionEvent e ){
                    if ( j == 430){
                        diceRolling();
                    rollDice();
                    }
                    j-=10;
                    cover.setLocation(j, 40);
                    
                    if(j==230){
                        whatSelected();
                        betTime();
                       ((Timer)evt.getSource()).stop();
                    }
                   i = 250;
                }
            });
                   
            Timer tm1 = new Timer(30 , new ActionListener(){
                public void actionPerformed(ActionEvent e ){
                    i+=10;
                    cover.setLocation(i, 40);
                    
                    if(i==430){
                        tm2.start();
                        ((Timer)evt.getSource()).stop();
                        
                        }
                   j = 430;
                }
            });
           
                tm1.start();
            
                    
                          
    }//GEN-LAST:event_jButton2ActionPerformed
    int i = 250; 
    int j = 430;
    private void sixMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sixMouseClicked
       sixselect.setSelected(rootPaneCheckingEnabled);
       whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("FACE 6");
    }//GEN-LAST:event_sixMouseClicked

    private void elevenHiLoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_elevenHiLoMouseClicked
        elevenHiLowselect.setSelected(rootPaneCheckingEnabled);
        whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("HILO");
    }//GEN-LAST:event_elevenHiLoMouseClicked

    private void fivelowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fivelowMouseClicked
       fivelowselect.setSelected(rootPaneCheckingEnabled);
       whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("5 LOW");
    }//GEN-LAST:event_fivelowMouseClicked

    private void sixlowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sixlowMouseClicked
       sixlowselect.setSelected(rootPaneCheckingEnabled);
       whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("6 LOW");
    }//GEN-LAST:event_sixlowMouseClicked

    private void threeOrsixMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_threeOrsixMouseClicked
        threeOrsixselect.setSelected(rootPaneCheckingEnabled);
        whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("3 AND 6");
    }//GEN-LAST:event_threeOrsixMouseClicked

    private void highMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_highMouseClicked
        highselect.setSelected(rootPaneCheckingEnabled);
        whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("HIGH");
    }//GEN-LAST:event_highMouseClicked

    private void lowMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lowMouseClicked
        lowselect.setSelected(rootPaneCheckingEnabled);
        whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("LOW");
    }//GEN-LAST:event_lowMouseClicked

    private void oneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oneMouseClicked
       oneselect.setSelected(rootPaneCheckingEnabled);
       whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("FACE 1");
    }//GEN-LAST:event_oneMouseClicked

    private void oneOrsixMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oneOrsixMouseClicked
      oneOrsixselect.setSelected(rootPaneCheckingEnabled);
      whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("1 AND 6");
    }//GEN-LAST:event_oneOrsixMouseClicked

    private void fiveOrtwoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fiveOrtwoMouseClicked
        fiveOrtwoselect.setSelected(rootPaneCheckingEnabled);
        whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("5 AND 2");
    }//GEN-LAST:event_fiveOrtwoMouseClicked

    private void twoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_twoMouseClicked
       twoselect.setSelected(rootPaneCheckingEnabled);
       whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("FACE 2");
    }//GEN-LAST:event_twoMouseClicked

    private void fiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fiveMouseClicked
        fiveselect.setSelected(rootPaneCheckingEnabled);
        whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("FACE 5");
    }//GEN-LAST:event_fiveMouseClicked

    private void threeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_threeMouseClicked
        threeselect.setSelected(rootPaneCheckingEnabled);
        whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("FACE 3");
    }//GEN-LAST:event_threeMouseClicked

    private void fourMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fourMouseClicked
        fourselect.setSelected(rootPaneCheckingEnabled);
        whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("FACE 4");
    }//GEN-LAST:event_fourMouseClicked

    private void twoOrfiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_twoOrfiveMouseClicked
       twoOrfiveselect.setSelected(rootPaneCheckingEnabled);
       whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("2 AND 5");
    }//GEN-LAST:event_twoOrfiveMouseClicked

    private void onetwothreeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_onetwothreeMouseClicked
        onetwothreeselect.setSelected(rootPaneCheckingEnabled);
        whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("1 2 3");
    }//GEN-LAST:event_onetwothreeMouseClicked

    private void fourfivesixMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fourfivesixMouseClicked
        fourfivesixselect.setSelected(rootPaneCheckingEnabled);
        whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("4 5 6 ");
    }//GEN-LAST:event_fourfivesixMouseClicked

    private void fourOroneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fourOroneMouseClicked
        fourOroneselect.setSelected(rootPaneCheckingEnabled);
        whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("4 AND 1");
    }//GEN-LAST:event_fourOroneMouseClicked

    private void threeOrfiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_threeOrfiveMouseClicked
        threeOrfiveselect.setSelected(rootPaneCheckingEnabled);
        whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("3 AND 5");
    }//GEN-LAST:event_threeOrfiveMouseClicked

    private void twoOrfourMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_twoOrfourMouseClicked
        twoOrfourselect.setSelected(rootPaneCheckingEnabled);
        whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("2 AND 4");
    }//GEN-LAST:event_twoOrfourMouseClicked

    private void sixOrtwoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sixOrtwoMouseClicked
        sixOrtwoselect.setSelected(rootPaneCheckingEnabled);
        whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("6 AND 2");
    }//GEN-LAST:event_sixOrtwoMouseClicked

    private void oneORfive21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oneORfive21MouseClicked
        oneOrfiveselect.setSelected(rootPaneCheckingEnabled);
        whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("1 AND 5");
    }//GEN-LAST:event_oneORfive21MouseClicked

    private void sixOroneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sixOroneMouseClicked
        sixOroneselect.setSelected(rootPaneCheckingEnabled);
        whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("6 AND 1");
    }//GEN-LAST:event_sixOroneMouseClicked

    private void oneORfiveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_oneORfiveMouseClicked
        oneOrfiveselect.setSelected(rootPaneCheckingEnabled);
        whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("1 AND 5");
    }//GEN-LAST:event_oneORfiveMouseClicked

    private void fivelowselectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fivelowselectActionPerformed
        fivelowselect.setSelected(rootPaneCheckingEnabled);
        whatSelectBet.setForeground(Color.BLACK);
       whatSelectBet.setText("5 LOW");
    }//GEN-LAST:event_fivelowselectActionPerformed

    private void ship10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ship10MouseClicked
        ship10select.setSelected(rootPaneCheckingEnabled);
        whatSelectShip.setForeground(Color.BLACK);
        if(betMoney >= money){
            betMoney += 0;
        }else{
        betMoney += 10;
        }
        setBetMoney = Integer.toString(betMoney);
        whatSelectShip.setText(setBetMoney+" BATH");
    }//GEN-LAST:event_ship10MouseClicked

    private void ship20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ship20MouseClicked
        ship20select.setSelected(rootPaneCheckingEnabled);
        whatSelectShip.setForeground(Color.BLACK);
        if(betMoney >= money){
            betMoney += 0;
        }else{
        betMoney += 20;
        }
        setBetMoney = Integer.toString(betMoney);
        whatSelectShip.setText(setBetMoney+" BATH");
    }//GEN-LAST:event_ship20MouseClicked

    private void ship50MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ship50MouseClicked
        ship50select.setSelected(rootPaneCheckingEnabled);
        whatSelectShip.setForeground(Color.BLACK);
        if(betMoney >= money){
            betMoney += 0;
        }else{
        betMoney += 50;
        }
        setBetMoney = Integer.toString(betMoney);
        whatSelectShip.setText(setBetMoney+" BATH");
    }//GEN-LAST:event_ship50MouseClicked

    private void ship100MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ship100MouseClicked
        ship100select.setSelected(rootPaneCheckingEnabled);
        whatSelectShip.setForeground(Color.BLACK);
        if(betMoney >= money){
            betMoney += 0;
        }else{
        betMoney += 100;
        }
        setBetMoney = Integer.toString(betMoney);
        whatSelectShip.setText(setBetMoney+" BATH");
    }//GEN-LAST:event_ship100MouseClicked

    private void ship200MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ship200MouseClicked
       ship200select.setSelected(rootPaneCheckingEnabled);
       whatSelectShip.setForeground(Color.BLACK);
       if(betMoney >= money){
            betMoney += 0;
        }else{
       betMoney += 200;
       }
       setBetMoney = Integer.toString(betMoney);
        whatSelectShip.setText(setBetMoney+" BATH");
    }//GEN-LAST:event_ship200MouseClicked

    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetActionPerformed
       whatSelectBet.setForeground(Color.LIGHT_GRAY);
       whatSelectBet.setText("bet selected");
       whatSelectShip.setForeground(Color.lightGray);
       whatSelectShip.setText("Ship selected");
       LoseWin.setForeground(new java.awt.Color(86, 57, 57));
       howmuchlostwin.setForeground(new java.awt.Color(86, 57, 57));
       losewinbar.setForeground(new java.awt.Color(86, 57, 57));
       betMoney = 0;
       null1.setSelected(rootPaneCheckingEnabled);
       null2.setSelected(rootPaneCheckingEnabled);
    }//GEN-LAST:event_ResetActionPerformed

    private void WhatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_WhatMouseClicked
        HowToPlay what = new HowToPlay();
        what.setVisible(true);
    }//GEN-LAST:event_WhatMouseClicked

    private void BackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BackMouseClicked
        null1.setSelected(rootPaneCheckingEnabled);
        null2.setSelected(rootPaneCheckingEnabled);
        StarForm star = new StarForm();
        userLog.clear();
        userLogin.clear();
        userLoginShow.clear();
        userMoney.clear();
        userMoneyShow.clear();
        password.clear();
        star.userLog.clear();
        star.userLogin.clear();
        star.userLoginShow.clear();
        star.userMoney.clear();
        star.userMoneyShow.clear();
        this.setVisible(false);
        star.setVisible(true);
        
    }//GEN-LAST:event_BackMouseClicked
     
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
            java.util.logging.Logger.getLogger(Mygame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mygame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mygame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mygame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fol
       

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new Mygame().setVisible(true);
            }
        }); 
        
       
    }
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Back;
    private javax.swing.JTextField BetText;
    private javax.swing.JTextField BetText1;
    private javax.swing.ButtonGroup HiLoSelect;
    private javax.swing.JLabel Hilo;
    private javax.swing.JTextField LoseWin;
    private javax.swing.JTextField MnString;
    private javax.swing.JLabel Money;
    private javax.swing.JLabel Plate;
    private javax.swing.JButton Reset;
    private javax.swing.JTextField What;
    private javax.swing.JLabel background;
    private javax.swing.JLabel cover;
    private javax.swing.JLabel dice1;
    private javax.swing.JLabel dice2;
    private javax.swing.JLabel dice3;
    private javax.swing.JLabel diceShow1;
    private javax.swing.JLabel diceShow2;
    private javax.swing.JLabel diceShow3;
    private javax.swing.JLabel elevenHiLo;
    private javax.swing.JRadioButton elevenHiLowselect;
    private javax.swing.JLabel five;
    private javax.swing.JLabel fiveOrtwo;
    private javax.swing.JRadioButton fiveOrtwoselect;
    private javax.swing.JLabel fivelow;
    private javax.swing.JRadioButton fivelowselect;
    private javax.swing.JRadioButton fiveselect;
    private javax.swing.JLabel four;
    private javax.swing.JLabel fourOrone;
    private javax.swing.JRadioButton fourOroneselect;
    private javax.swing.JLabel fourfivesix;
    private javax.swing.JRadioButton fourfivesixselect;
    private javax.swing.JRadioButton fourselect;
    private javax.swing.JLabel high;
    private javax.swing.JRadioButton highselect;
    private javax.swing.JTextField howmuchlostwin;
    private javax.swing.JButton jButton2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTextField losewinbar;
    private javax.swing.JLabel low;
    private javax.swing.JRadioButton lowselect;
    private javax.swing.JRadioButton null1;
    private javax.swing.JRadioButton null2;
    private javax.swing.JLabel one;
    private javax.swing.JLabel oneORfive;
    private javax.swing.JLabel oneORfive21;
    private javax.swing.JRadioButton oneOrfiveselect;
    private javax.swing.JLabel oneOrsix;
    private javax.swing.JRadioButton oneOrsixselect;
    private javax.swing.JRadioButton oneselect;
    private javax.swing.JLabel onetwothree;
    private javax.swing.JRadioButton onetwothreeselect;
    private javax.swing.JLabel ship10;
    private javax.swing.JLabel ship100;
    private javax.swing.JRadioButton ship100select;
    private javax.swing.JRadioButton ship10select;
    private javax.swing.JLabel ship20;
    private javax.swing.JLabel ship200;
    private javax.swing.JRadioButton ship200select;
    private javax.swing.JRadioButton ship20select;
    private javax.swing.JLabel ship50;
    private javax.swing.JRadioButton ship50select;
    private javax.swing.ButtonGroup shipselect;
    private javax.swing.JLabel six;
    private javax.swing.JLabel sixOrone;
    private javax.swing.JRadioButton sixOroneselect;
    private javax.swing.JLabel sixOrtwo;
    private javax.swing.JRadioButton sixOrtwoselect;
    private javax.swing.JLabel sixlow;
    private javax.swing.JRadioButton sixlowselect;
    private javax.swing.JRadioButton sixselect;
    private javax.swing.JLabel three;
    private javax.swing.JLabel threeOrfive;
    private javax.swing.JRadioButton threeOrfiveselect;
    private javax.swing.JLabel threeOrsix;
    private javax.swing.JRadioButton threeOrsixselect;
    private javax.swing.JRadioButton threeselect;
    private javax.swing.JTextField totalBox;
    private javax.swing.JTextField totalText;
    private javax.swing.JLabel two;
    private javax.swing.JLabel twoOrfive;
    private javax.swing.JRadioButton twoOrfiveselect;
    private javax.swing.JLabel twoOrfour;
    private javax.swing.JRadioButton twoOrfourselect;
    private javax.swing.JRadioButton twoselect;
    private javax.swing.JTextField usShow;
    private javax.swing.JTextField whatSelectBet;
    private javax.swing.JTextField whatSelectShip;
    // End of variables declaration//GEN-END:variables
}
