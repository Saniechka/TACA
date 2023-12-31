package main.game.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GreenField {

    static JButton G1 = new JButton();
    static JButton G2 = new JButton();
    static JButton G3 = new JButton();
    static JButton G4 = new JButton();
    static JButton G5 = new JButton();
    static JButton G6 = new JButton();
    static JButton G7 = new JButton();
    static JButton G8 = new JButton();
    static JButton G9 = new JButton();
    static JButton G10 = new JButton();
    static JButton G11 = new JButton();

        public static JButton emptyGreenField(JButton button, JLayeredPane panel, String sign, String label, int x, int y, JButton button1, JButton button2, JButton button3, JButton button4, JButton button5, JButton button6) {
            button = new JButton(sign + label);
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
                                             String s = "" ;
                                            int j ;
                                             ArrayList<JButton> buttons = new ArrayList<>();
                                             buttons.add(button1);
                                             buttons.add(button2);
                                             buttons.add(button3);
                                             buttons.add(button4);
                                             buttons.add(button5);
                                             buttons.add(button6);

                                             for (int i = 0; i<buttons.size(); i++) {

                                                 if (buttons.get(i).getName().contains("green")) {
                                                     str = (buttons.get(i).getName().charAt(buttons.get(i).getName().length() - 1));
                                                     s = Character.toString(str);

                                                 }
                                             }
                                             if (Integer.parseInt(s) >= Integer.parseInt(label)){
                                                 finalButton1.setText(s);
                                                 finalButton1.setEnabled(false);}

                                         }});
            return button;
        }
}
