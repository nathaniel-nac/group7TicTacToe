package TicTacToe;

import java.awt.*;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class Board extends JPanel {
	private Color c;
	public final int SQUARE_SIDE = 100;

	public Board(Color c)
	{
		this.c = c;
	}
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				Rectangle2D.Double square = new Rectangle2D.Double(i * SQUARE_SIDE, j * SQUARE_SIDE, SQUARE_SIDE,
						SQUARE_SIDE);
				g2.setColor(c);
				g2.draw(square);
			}
		}
	}
	
//	public static void main(String[] args)
//	{
//		Board b = new Board();
//		JFrame frame = new JFrame();
//		frame.add(b);
//		frame.pack();
//		frame.show();		
//	}
}
