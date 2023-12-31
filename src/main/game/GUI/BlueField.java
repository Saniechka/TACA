package main.game.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class BlueField {

    static JButton B12 = new JButton(); // Column 1
    static JButton B13 = new JButton();
    static JButton B21 = new JButton(); // Column 2
    static JButton B22 = new JButton();
    static JButton B23 = new JButton();
    static JButton B31 = new JButton(); // Column 3
    static JButton B32 = new JButton();
    static JButton B33 = new JButton();
    static JButton B41 = new JButton(); // Column 4
    static JButton B42 = new JButton();
    static JButton B43 = new JButton();

    public static JButton emptyBlueField(JButton button, JLayeredPane panel, String label, int x, int y, JButton button1, JButton button2, JButton button3, JButton button4, JButton button5, JButton button6) {
        button = new JButton(label);
        button.setVisible(true);
        button.setBackground(Color.white);
        button.setBounds(x, y, 39, 39);
        button.setMargin(new Insets(0, 0, 0, 0));
        panel.add(button, JLayeredPane.POPUP_LAYER);
        JButton finalButton = button;
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int value = 0;
                int value2 = 0;
                char str = 'q';
                String s = "";
                char str2 = 'q';
                String s2 = "";

                ArrayList<JButton> buttons = new ArrayList<>();
                buttons.add(button1);
                buttons.add(button2);
                buttons.add(button3);
                buttons.add(button4);
                buttons.add(button5);
                buttons.add(button6);

                for (int i = 0; i < buttons.size(); i++) {

                    if (buttons.get(i).getName().contains("blue")) {

                        str = (buttons.get(i).getName().charAt(buttons.get(i).getName().length() - 1));
                        s = Character.toString(str);
                        value = Integer.parseInt(s);
                    }

                            if (buttons.get(i).getName().contains("white")) {

                                str2 = (buttons.get(i).getName().charAt(buttons.get(i).getName().length() - 1));
                                s2 = Character.toString(str2);
                                value2 = Integer.parseInt(s2);
                            }

                    }
                    if (Integer.valueOf(label) == (value + value2)) {
                        finalButton.setIcon(new ImageIcon("src/GUIImages/X.png"));
                        finalButton.setText("");
                        finalButton.setEnabled(false);
                    }

            }});
               return button;
        }
    }


