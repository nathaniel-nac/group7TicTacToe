package test;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class StrategyTester {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JButton LightButton = new JButton("Light Mode");
        JButton DarkButton = new JButton("Dark Mode");

        //JOptionPane.showMessageDialog(null,"Hello Strategy Tester","Dark Mode",JOptionPane.INFORMATION_MESSAGE,s);
        
        LightButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                IShapeColor sc = new WhiteSquare();
                Square s = new Square(50, sc);
                JOptionPane.showMessageDialog(null,"Hello Strategy Tester","Dark Mode",JOptionPane.INFORMATION_MESSAGE,s);
            }
            
        });
        
        DarkButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                IShapeColor sc = new BlackSquare();
                Square s = new Square(50, sc);
                JOptionPane.showMessageDialog(null,"Hello Strategy Tester","Light Mode",JOptionPane.INFORMATION_MESSAGE,s);
            }
            
        });
        
        frame.setLayout(new FlowLayout());
        frame.add(LightButton);
        frame.add(DarkButton);
        frame.pack();
        frame.setVisible(true);
    }

}
