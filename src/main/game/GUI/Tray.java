package main.game.GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Tray {

    public int space;

    public Tray( int space) {
        this.space = space;
    }

    public int getSpace() {
        return space;
    }

    static JButton tray = new JButton(); // Column 1
    static JButton tray1 = new JButton();
    static JButton tray2 = new JButton(); // Column 2
    static JButton tray3 = new JButton();
    static JButton tray4 = new JButton();




    public static JButton trayButton(JButton button, JLayeredPane panel, int x, int y,ImageIcon icon) {
        button.setIcon(icon);
        button.setVisible(true);
        button.setBackground(Color.white);
        button.setBounds(x, y, 54, 54);
        button.setMargin(new Insets(0, 0, 0, 0));
        panel.add(button, JLayeredPane.POPUP_LAYER);
        JButton finalButton1 = button;
        return button;}

}
