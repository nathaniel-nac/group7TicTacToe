//package TicTacToe;

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

		Color line;
		menu.setLayout(new BoxLayout(menu, BoxLayout.Y_AXIS));
		light.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				line = Color.BLACK;
				LightBoard lb = new LightBoard();
				frame.setContentPane(lb);
				frame.invalidate();
				frame.validate(); 
				//Model model = new Model(lb);
				//BoardView bv = new BoardView(model);
				//frame.remove(menu);
				//frame.add(lb)
			}

		});
		dark.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				line = Color.WHITE;

				DarkBoard db = new DarkBoard();
				frame.setContentPane(db);
				frame.invalidate();
				frame.validate();
			}

		});

		frame.pack();
		frame.setVisible(true);
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
}