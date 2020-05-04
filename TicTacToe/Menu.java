package TicTacToe;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JPanel {
    
    JTextArea preference;
    JFrame frame;
    JButton light;
    JButton dark;
    public Menu(JFrame frame) {
        preference = new JTextArea("Choose a board style:");
        this.frame = frame;
        light = new JButton("Light Mode");
        dark = new JButton("Dark Mode");
        light.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                BoardFormatter lb = new LightBoard();
                Board b = new Board(lb);
                frame.setContentPane(b);
                frame.invalidate();
                frame.validate();
            }

        });
        dark.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                BoardFormatter db = new DarkBoard();
                Board b = new Board(db);
                frame.add(b);
                frame.setContentPane(b);
                frame.invalidate();
                frame.validate();
            }

        });
        this.setLayout(new GridLayout(3,0));
        this.add(preference);
        this.add(dark);
        this.add(light);
    }
}
