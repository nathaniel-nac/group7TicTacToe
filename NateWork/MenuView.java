package TicTacToe;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/*
 * Previously view class
 * This is where we handle all the user's action
 */
public class MenuView {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Menu menu = new Menu(frame);
		
        frame.add(menu);
        frame.setContentPane(menu);
		frame.pack();
		frame.setVisible(true);
		frame.setSize(317,340);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
}
	}
