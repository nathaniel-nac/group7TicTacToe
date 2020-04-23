package TicTacToe;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class View {
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
				// TODO Auto-generated method stub
				LightBoard lb = new LightBoard();
				frame.setContentPane(lb);
				frame.invalidate();
				frame.validate();
				//frame.remove(menu);
				//frame.add(lb);
			}

		});
		dark.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DarkBoard db = new DarkBoard();
				frame.setContentPane(db);
				frame.invalidate();
				frame.validate();
				//frame.remove(menu);
				//frame.add(db);
			}

		});
		
		frame.pack();
		frame.setVisible(true);
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
}
