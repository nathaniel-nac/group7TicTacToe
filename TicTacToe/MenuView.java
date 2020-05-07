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
		JPanel menu = new JPanel();
		JTextArea preference = new JTextArea("Choose a board style:");
		JButton light = new JButton("Light Mode");
		JButton dark = new JButton("Dark Mode");

		menu.add(preference);
		menu.add(dark);
		menu.add(light);
		frame.add(menu);
		menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
		light.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BoardFormatter lb = new LightBoard();
				Board b = new Board(lb);
				frame.getContentPane().remove(menu);
				frame.setContentPane(b);
				frame.revalidate();
		        frame.pack();
		        frame.setSize(500, 500);
			}

		});
		dark.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BoardFormatter db = new DarkBoard();
				Board b = new Board(db);
                frame.getContentPane().remove(menu);
                frame.setContentPane(b);
                frame.revalidate();
                frame.pack();
                frame.setSize(500, 500);
			}

		});

		frame.pack();
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
