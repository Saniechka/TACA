package main.game.GUI;

import main.game.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import static main.game.GUI.Tray.*;
import static main.game.GUI.GUI.*;

import java.util.Arrays;
import java.util.Iterator;


public class YellowField {

    static   String[] colory  = {"blue", "yellow","green","orange","purple", "white"};

    static JButton Y11 = new JButton(); //Column 1
    static JButton Y12 = new JButton();
    static JButton Y13 = new JButton();
    static JButton Y21 = new JButton(); // Column 2
    static JButton Y22 = new JButton();
    static JButton Y24 = new JButton();
    static JButton Y31 = new JButton(); //Column 3
    static JButton Y33 = new JButton();
    static JButton Y34 = new JButton();
    static JButton Y42 = new JButton(); // Column 4
    static JButton Y43 = new JButton();
    static JButton Y44 = new JButton();
                
    public static JButton emptyYellowField(JButton button, JLayeredPane panel, String label, int x, int y, JButton button1, JButton button2, JButton button3, JButton button4, JButton button5, JButton button6) {

        button = new JButton(label);
        button.setVisible(true);
        button.setBackground(Color.white);
        button.setBounds(x, y, 39, 39);
        button.setMargin(new Insets(0, 0, 0, 0));
        panel.add(button, JLayeredPane.POPUP_LAYER);
        JButton finalButton1 = button;
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Board.addValue(,finalButton1);
                int value = -1;
                char str;
                String s;
                int length = -2;
                int valueOfDice = -5;

                ArrayList<JButton> buttons = new ArrayList<>();
                buttons.add(button1);
                buttons.add(button2);
                buttons.add(button3);
                buttons.add(button4);
                buttons.add(button5);
                buttons.add(button6);


                ArrayList<JButton> trays = new ArrayList<>();
                trays.add(tray);
                trays.add(tray1);
                trays.add(tray2);
                trays.add(tray3);
                trays.add(tray4);


                for (int i = 0; i<buttons.size(); i++) {

                    if (buttons.get(i).getName().contains("yellow")){
                        str = (buttons.get(i).getName().charAt(buttons.get(i).getName().length() - 1));
                        s = Character.toString(str);
                        value = Integer.parseInt(s);
                        length = i;
                        valueOfDice= Integer.parseInt (buttons.get(i).getName().substring(buttons.get(i).getName().length() - 1));
                    }


                    if (buttons.get(i).getName().contains("white")){
                        str = (buttons.get(i).getName().charAt(buttons.get(i).getName().length() - 1));
                        s = Character.toString(str);
                        value = Integer.parseInt(s);
                        length = i;
                    }
                }
                if( Integer.parseInt(label)== value) {
                   finalButton1.setIcon(new ImageIcon("src/GUIImages/X.png"));
                   finalButton1.setText("");
                   finalButton1.setEnabled(false);


                   ArrayList<String> list =  new ArrayList<>();
                    for (int i =0; i < length; i++) {
                        trays.get(i).setIcon(new ImageIcon("src/GUIImages/"+buttons.get(i).getName()+".png"));
                        if(Integer.parseInt(buttons.get(i).getName().substring(buttons.get(i).getName().length() - 1))<valueOfDice){
                            list.add(buttons.get(i).getName().substring(0,buttons.get(i).getName().length() - 1));
                        }

                    }

                    String[] newString = new String[colors.length];
                   GUI.colors = Arrays.copyOf(newString, colors.length-1);

                 String []   temparrayfori = list.toArray(new String[list.size()]);
                            colors = temparrayfori;
                }
           }
        });
               return button;
    }
}

