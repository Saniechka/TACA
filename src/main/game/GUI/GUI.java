package main.game.GUI;
import main.game.Dice;
import main.game.Game;
import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import static main.game.GUI.BlueField.*;
import static main.game.GUI.Tray.*;
import static main.game.GUI.GreenField.*;
import static main.game.GUI.OrangeField.*;
import static main.game.GUI.PurpleField.*;
import static main.game.GUI.Tray.trayButton;
import static main.game.GUI.YellowField.*;



public class GUI {

   static   String[] colors  = {"blue", "yellow","green","orange","purple", "white"};

    static ArrayList<JButton> jButtonArrayList = new ArrayList<>();

    JButton dice(JButton button, int x, int y, JLayeredPane panel, String name) {
        button.setBounds(x, y, 54, 54);
        button.setMargin(new Insets(0, 0, 0, 0));
        panel.add(button, JLayeredPane.POPUP_LAYER);
        button.setVisible(true);
        button.setName(name);
        return button;

    }

    JFrame frame = new JFrame();
    JLayeredPane panel = new JLayeredPane();


    public GUI() {
        Tray trayObj = new Tray(0);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setSize(new Dimension(561, 830));
        frame.setTitle("That's pretty clever!");

        frame.addWindowListener( new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                JFrame frame = (JFrame)e.getSource();

                int result = JOptionPane.showConfirmDialog(
                        frame,
                        "Are you sure you want to quit the game?",
                        "Exit Application",
                        JOptionPane.YES_NO_OPTION);

                if (result == JOptionPane.YES_OPTION)
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });

        frame.setVisible( true );


        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = frame.getSize().width;
        int x = (dim.width -w)/2;
        int y = 0;
        frame.setLocation(x,y);

        JLabel background = new JLabel(new ImageIcon("src/GUIImages/board.png"));
        background.setBounds(0, 0, 561, 800);
        background.setVisible(true);

        panel.add(background, JLayeredPane.DEFAULT_LAYER);
        panel.setVisible(true);

        frame.add(panel);


        JButton roll = new JButton();
        roll.setBounds(377, 152, 118, 57);
        roll.setIcon(new ImageIcon("src/GUIImages/roll.png"));

        roll.setMargin(new Insets(0, 0, 0, 0));
        roll.setVisible(true);
        panel.add(roll, JLayeredPane.POPUP_LAYER);

        JButton button1 = new JButton();
        button1 =dice(button1,28,28,panel,"yellow1");
        button1.setIcon(new ImageIcon("src/GUIImages/black.png"));

        JButton button2 = new JButton();
        button2 =dice(button2,88,28,panel,"green");
        button2.setIcon(new ImageIcon("src/GUIImages/black.png"));

        JButton button3 = new JButton();
        button3 =dice(button3,148,28,panel,"");
        button3.setIcon(new ImageIcon("src/GUIImages/black.png"));

        JButton button4 = new JButton();
        button4 =dice(button4,208,28,panel,"");
        button4.setIcon(new ImageIcon("src/GUIImages/black.png"));

        JButton button5 = new JButton();
        button5 =dice(button5,268,28,panel,"");
        button5.setIcon(new ImageIcon("src/GUIImages/black.png"));


        JButton button6 = new JButton();
        button6 =dice(button6,328,28,panel,"");
        button6 .setIcon(new ImageIcon("src/GUIImages/black.png"));


        String[] colors1 = {"blue", "yellow","green","orange","purple"};
        Dice[] trayArray = Game.createDices(colors1);
        Dice[] dice = Game.createDices(colors1);

        ArrayList<String> trayDice = new ArrayList<>();
        tray= trayButton(tray,panel,32,155,new ImageIcon("src/GUIImages/grey.png"));
        tray1= trayButton(tray1,panel,92,155,new ImageIcon("src/GUIImages/grey.png"));
        tray2= trayButton(tray2,panel,152,155,new ImageIcon("src/GUIImages/grey.png"));
        tray3= trayButton(tray3,panel,212,155,new ImageIcon("src/GUIImages/grey.png"));
        tray4= trayButton(tray4,panel,272,155,new ImageIcon("src/GUIImages/grey.png"));




        JButton finalButton1 = button2;
        JButton finalButton2 = button3;
        JButton finalButton3 = button4;
        JButton finalButton4 = button5;
        JButton finalButton5 = button6;
        JButton finalButton = button1;

        jButtonArrayList.add(finalButton1);
        jButtonArrayList.add(finalButton2);
        jButtonArrayList.add(finalButton3);
        jButtonArrayList.add(finalButton4);
        jButtonArrayList.add(finalButton5);
        jButtonArrayList.add(finalButton);



        roll.addActionListener(new ActionListener() {
                                   @Override
                                   public void actionPerformed(ActionEvent e) {
                                      // colors = colory;
                                       Dice[] dice = Game.createDices(colors);
                                       ArrayList<Dice> diceArrayList= Game.sort(dice);
                                       int length = diceArrayList.size();

                                       switch(length){
                                           case 1:
                                               finalButton.setIcon(new ImageIcon("src/GUIImages/" + diceArrayList.get(0).getColor() +   diceArrayList.get(0).getValue() + ".png"));
                                               finalButton.setName(diceArrayList.get(0).getColor()+ Integer.toString(diceArrayList.get(0).getValue()));

                                               finalButton1.setIcon(new ImageIcon("src/GUIImages/black.png"));

                                               finalButton2.setIcon(new ImageIcon("src/GUIImages/black.png" ));

                                               finalButton3.setIcon(new ImageIcon("src/GUIImages/black.png"));

                                               finalButton4.setIcon(new ImageIcon("src/GUIImages/black.png"));

                                               finalButton5.setIcon(new ImageIcon("src/GUIImages/black.png"));

                                               break;


                                           case 2:
                                               finalButton.setIcon(new ImageIcon("src/GUIImages/" + diceArrayList.get(0).getColor() +  diceArrayList.get(0).getValue() + ".png"));
                                               finalButton.setName(diceArrayList.get(0).getColor()+ Integer.toString( diceArrayList.get(0).getValue()));

                                               finalButton1.setIcon(new ImageIcon("src/GUIImages/" + diceArrayList.get(1).getColor() +  diceArrayList.get(1).getValue() + ".png"));
                                               finalButton1.setName(diceArrayList.get(1).getColor()+ Integer.toString( diceArrayList.get(1).getValue()));

                                               finalButton2.setIcon(new ImageIcon("src/GUIImages/black.png" ));

                                               finalButton3.setIcon(new ImageIcon("src/GUIImages/black.png" ));

                                               finalButton4.setIcon(new ImageIcon("src/GUIImages/black.png" ));

                                               finalButton5.setIcon(new ImageIcon("src/GUIImages/black.png" ));
                                               break;


                                           case 3:
                                               finalButton.setIcon(new ImageIcon("src/GUIImages/" + diceArrayList.get(0).getColor() +  diceArrayList.get(0).getValue() + ".png"));
                                               finalButton.setName(diceArrayList.get(0).getColor()+ Integer.toString( diceArrayList.get(0).getValue()));

                                               finalButton1.setIcon(new ImageIcon("src/GUIImages/" + diceArrayList.get(1).getColor() +  diceArrayList.get(1).getValue() + ".png"));
                                               finalButton1.setName(diceArrayList.get(1).getColor()+ Integer.toString( diceArrayList.get(1).getValue()));

                                               finalButton2.setIcon(new ImageIcon("src/GUIImages/" +  diceArrayList.get(2).getColor() +  diceArrayList.get(2).getValue() + ".png"));
                                               finalButton2.setName(diceArrayList.get(2).getColor()+ Integer.toString(  diceArrayList.get(2).getValue()));

                                               finalButton3.setIcon(new ImageIcon("src/GUIImages/black.png"));

                                               finalButton4.setIcon(new ImageIcon("src/GUIImages/black.png"));

                                               finalButton5.setIcon(new ImageIcon("src/GUIImages/black.png"));
                                               break;


                                           case 4:
                                               finalButton.setIcon(new ImageIcon("src/GUIImages/" + diceArrayList.get(0).getColor() +  diceArrayList.get(0).getValue() + ".png"));
                                               finalButton.setName(diceArrayList.get(0).getColor()+ Integer.toString( diceArrayList.get(0).getValue()));

                                               finalButton1.setIcon(new ImageIcon("src/GUIImages/" + diceArrayList.get(1).getColor() +  diceArrayList.get(1).getValue() + ".png"));
                                               finalButton1.setName(diceArrayList.get(1).getColor()+ Integer.toString( diceArrayList.get(1).getValue()));

                                               finalButton2.setIcon(new ImageIcon("src/GUIImages/" +  diceArrayList.get(2).getColor() +  diceArrayList.get(2).getValue() + ".png"));
                                               finalButton2.setName(diceArrayList.get(2).getColor()+ Integer.toString(  diceArrayList.get(2).getValue()));

                                               finalButton3.setIcon(new ImageIcon("src/GUIImages/" + diceArrayList.get(3).getColor() + diceArrayList.get(3).getValue() + ".png"));
                                               finalButton3.setName(diceArrayList.get(3).getColor()+ Integer.toString( diceArrayList.get(3).getValue()));

                                               finalButton4.setIcon(new ImageIcon("src/GUIImages/black.png"));

                                               finalButton5.setIcon(new ImageIcon("src/GUIImages/black.png"));
                                               break;


                                           case 5:
                                               finalButton.setIcon(new ImageIcon("src/GUIImages/" + diceArrayList.get(0).getColor() +  diceArrayList.get(0).getValue() + ".png"));
                                               finalButton.setName(diceArrayList.get(0).getColor()+ Integer.toString( diceArrayList.get(0).getValue()));

                                               finalButton1.setIcon(new ImageIcon("src/GUIImages/" + diceArrayList.get(1).getColor() +  diceArrayList.get(1).getValue() + ".png"));
                                               finalButton1.setName(diceArrayList.get(1).getColor()+ Integer.toString( diceArrayList.get(1).getValue()));

                                               finalButton2.setIcon(new ImageIcon("src/GUIImages/" +  diceArrayList.get(2).getColor() +  diceArrayList.get(2).getValue() + ".png"));
                                               finalButton2.setName(diceArrayList.get(2).getColor()+ Integer.toString(  diceArrayList.get(2).getValue()));

                                               finalButton3.setIcon(new ImageIcon("src/GUIImages/" + diceArrayList.get(3).getColor() + diceArrayList.get(3).getValue() + ".png"));
                                               finalButton3.setName(diceArrayList.get(3).getColor()+ Integer.toString( diceArrayList.get(3).getValue()));

                                               finalButton4.setIcon(new ImageIcon("src/GUIImages/" + diceArrayList.get(4).getColor() + diceArrayList.get(4).getValue() + ".png"));
                                               finalButton4.setName(diceArrayList.get(4).getColor()+ Integer.toString( diceArrayList.get(4).getValue()));

                                               finalButton5.setIcon(new ImageIcon("src/GUIImages/black.png" ));
                                               break;


                                           case 6:

                                               finalButton.setIcon(new ImageIcon("src/GUIImages/" + diceArrayList.get(0).getColor() +  diceArrayList.get(0).getValue() + ".png"));
                                               finalButton.setName(diceArrayList.get(0).getColor()+ Integer.toString( diceArrayList.get(0).getValue()));

                                               finalButton1.setIcon(new ImageIcon("src/GUIImages/" + diceArrayList.get(1).getColor() +  diceArrayList.get(1).getValue() + ".png"));
                                               finalButton1.setName(diceArrayList.get(1).getColor()+ Integer.toString( diceArrayList.get(1).getValue()));

                                               finalButton2.setIcon(new ImageIcon("src/GUIImages/" +  diceArrayList.get(2).getColor() +  diceArrayList.get(2).getValue() + ".png"));
                                               finalButton2.setName(diceArrayList.get(2).getColor()+ Integer.toString(  diceArrayList.get(2).getValue()));

                                               finalButton3.setIcon(new ImageIcon("src/GUIImages/" + diceArrayList.get(3).getColor() + diceArrayList.get(3).getValue() + ".png"));
                                               finalButton3.setName(diceArrayList.get(3).getColor()+ Integer.toString( diceArrayList.get(3).getValue()));

                                               finalButton4.setIcon(new ImageIcon("src/GUIImages/" + diceArrayList.get(4).getColor() + diceArrayList.get(4).getValue() + ".png"));
                                               finalButton4.setName(diceArrayList.get(4).getColor()+ Integer.toString( diceArrayList.get(4).getValue()));

                                               finalButton5.setIcon(new ImageIcon("src/GUIImages/" + diceArrayList.get(5).getColor() + diceArrayList.get(5).getValue() + ".png"));
                                               finalButton5.setName(diceArrayList.get(5).getColor()+ Integer.toString( diceArrayList.get(5).getValue()));
                                               break;
                                       }

                                   }
                               }
        );




        Y11 = emptyYellowField(Y11, panel, "3", 30, 286,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5 );
        Y12 = emptyYellowField(Y12, panel, "2", 30, 332,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        Y13 = emptyYellowField(Y13, panel, "1", 30, 378,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        Y21 = emptyYellowField(Y21, panel, "6", 78, 286,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        Y22 = emptyYellowField(Y22, panel, "1", 78, 332,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        Y24 = emptyYellowField(Y24, panel, "3", 78, 424,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        Y31 = emptyYellowField(Y31, panel, "5", 127, 286,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        Y33 = emptyYellowField(Y33, panel, "2", 127, 378,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        Y34 = emptyYellowField(Y34, panel, "4", 127, 424,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        Y42 = emptyYellowField(Y42, panel, "5", 175, 332,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        Y43 = emptyYellowField(Y43, panel, "4", 175, 378,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        Y44 = emptyYellowField(Y44, panel, "6", 175, 424,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);





        B12 = emptyBlueField(B12, panel, "5", 302, 383,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        B13 = emptyBlueField(B13, panel, "9", 302, 430,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        B21 = emptyBlueField(B21, panel, "2", 351, 338,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        B22 = emptyBlueField(B22, panel, "6", 351, 384,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        B23 = emptyBlueField(B23, panel, "10",351, 430,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        B31 = emptyBlueField(B31, panel, "3", 399, 338,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        B32 = emptyBlueField(B32, panel, "7", 399, 384,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        B33 = emptyBlueField(B33, panel, "11",399, 430,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        B41 = emptyBlueField(B41, panel, "4", 448, 338,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        B42 = emptyBlueField(B42, panel, "8", 448, 384,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        B43 = emptyBlueField(B43, panel, "12",448, 430,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);


        G1 = emptyGreenField(G1, panel, "≥", "1", 72, 562,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        G2 = emptyGreenField(G2, panel, "≥","2", 114, 562,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        G3 = emptyGreenField(G3, panel, "≥","3", 157, 562,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        G4 = emptyGreenField(G4, panel, "≥","4", 200, 562,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        G5 = emptyGreenField(G5, panel, "≥","5", 242, 562,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        G6 = emptyGreenField(G6, panel, "≥","1", 284, 562,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        G7 = emptyGreenField(G7, panel, "≥","2", 327, 562,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        G8 = emptyGreenField(G8, panel, "≥","3", 369, 562,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        G9 = emptyGreenField(G9, panel, "≥","4", 411, 562,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        G10 = emptyGreenField(G10, panel, "≥","5", 454, 562,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        G11 = emptyGreenField(G11, panel, "≥","6", 496, 562,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);

        O1 = emptyNumberOrangeField(O1, panel, 1,"", 72, 642,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        O2 = emptyNumberOrangeField(O2, panel, 2,"", 114, 642,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        O3 = emptyNumberOrangeField(O3, panel, 3,"", 157, 642,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        O4 = emptyNumberOrangeField(O4, panel, 4,"x2", 200, 642,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        O5 = emptyNumberOrangeField(O5, panel, 5,"", 242, 642,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        O6 = emptyNumberOrangeField(O6, panel, 6,"", 284, 642,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        O7 = emptyNumberOrangeField(O7, panel, 7,"x2", 327, 642,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        O8 = emptyNumberOrangeField(O8, panel, 8,"", 369, 642,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        O9 = emptyNumberOrangeField(O9, panel, 9,"x2", 411, 642,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        O10 = emptyNumberOrangeField(O10, panel, 10,"", 454, 642,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        O11 = emptyNumberOrangeField(O11, panel, 11,"x3", 496, 642,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);


        P1 = emptyNumberPurpleField(P1, panel,  "", 72, 722,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        P2 = emptyNumberPurpleField(P2, panel,  "", 114, 722,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        P3 = emptyNumberPurpleField(P3, panel,  "", 157, 722,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        P4 = emptyNumberPurpleField(P4, panel,  "", 200, 722,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        P5 = emptyNumberPurpleField(P5, panel,  "", 242, 722,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        P6 = emptyNumberPurpleField(P6, panel,  "", 284, 722,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        P7 = emptyNumberPurpleField(P7, panel,  "", 327, 722,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        P8 = emptyNumberPurpleField(P8, panel,   "", 369, 722,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        P9 = emptyNumberPurpleField(P9, panel,  "", 411, 722,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        P10 = emptyNumberPurpleField(P10, panel, "", 454, 722,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);
        P11 = emptyNumberPurpleField(P11, panel, "", 496, 722,finalButton, finalButton1, finalButton2, finalButton3, finalButton4, finalButton5);



    }


    public static void main(String[] args) throws InterruptedException {
        Dice dice1 = new Dice("orange");
        Dice dice2 = new Dice("blue");
        Dice dice3 = new Dice("yellow");
        Dice dice4 = new Dice("white");
        Dice dice5 = new Dice("purple");
        Dice dice6 = new Dice("green");

        Dice[] dices = new Dice[6];
        dices[0] = dice1;
        dices[1] = dice2;
        dices[2] = dice3;
        dices[3] = dice4;
        dices[4] = dice5;
        dices[5] = dice6;

        Dice[] tray = new Dice[5];
        dices[0] = dice1;
        dices[1] = dice2;
        dices[2] = dice3;
        dices[3] = dice4;
        dices[4] = dice5;


        new GUI();
    }

}


