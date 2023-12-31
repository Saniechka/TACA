package main.game.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OrangeField {
    static JButton O1 = new JButton();
    static JButton O2 = new JButton();
    static JButton O3 = new JButton();
    static JButton O4 = new JButton();
    static JButton O5 = new JButton();
    static JButton O6 = new JButton();
    static JButton O7 = new JButton();
    static JButton O8 = new JButton();
    static JButton O9 = new JButton();
    static JButton O10 = new JButton();
    static JButton O11 = new JButton();

    OrangeField orangeField = new OrangeField();


    public static JButton emptyNumberOrangeField(JButton button, JLayeredPane panel, int index, String label, int x, int y, JButton button1, JButton button2, JButton button3, JButton button4, JButton button5, JButton button6) {

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
                                         int value =-1;
                                         char str ='q';
                                         String s ;
                                         ArrayList<JButton> buttons = new ArrayList<>();
                                         buttons.add(button1);
                                         buttons.add(button2);
                                         buttons.add(button3);
                                         buttons.add(button4);
                                         buttons.add(button5);
                                         buttons.add(button6);
                                         for (int j = 0; j<11; j++)
                                         {for (int i = 0; i<buttons.size(); i++) {

                                             if (buttons.get(i).getName().contains("orange")) {
                                                 str = (buttons.get(i).getName().charAt(buttons.get(i).getName().length() - 1));
                                                 s = Character.toString(str);
                                                 finalButton1.setText(s);
                                                 if (j == index){
                                                 finalButton1.setEnabled(false);

                                             }
                                             if (buttons.get(i).getName().contains("white")){
                                                 str = (buttons.get(i).getName().charAt(buttons.get(i).getName().length() - 1));
                                                 s = Character.toString(str);
                                                 value = Integer.parseInt(s);
                                             }}}
                                         }}});


        return button;
    }
    }

