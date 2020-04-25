package TicTacToe;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

/*
 * Part of the MVC class
 */
public class BoardView extends JPanel implements Observer {

	private Model model;
	private int[] move;
	private final int PLAYER_ONE = 1;
	private final int PLAYER_TWO = 2;
	private int currentPlayer;
	
	public BoardView(Model m) {
		model = m;
		this.addMouseListener(new MouseListener() {
			private int counter = 0;
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				//Keeps track of the current player
				counter++;
				if (counter%2==0)
				{
					currentPlayer = PLAYER_ONE;
				}
				else
				{
					currentPlayer = PLAYER_TWO;
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				int x0 = e.getX();
				int y0 = e.getY();
				int x = -1;
				int y = -1;
				
				//Getting the position of the player on the x - axis
				if (x0 <= 100) {
					x = 0;
				} else if (x0 <= 200) {
					x = 1;
				} else if (x0 <= 300) {
					x = 2;
				}
				
				//Getting the position of the player on the y - axis
				if (y0 <= 100) {
					y = 0;
				} else if (y0 <= 200) {
					y = 1;
				} else if (y0 <= 300) {
					y = 2;
				}
				
				model.update(x,y, currentPlayer);
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
	}
	
	public void paintComponent(Graphics g)
	{
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		repaint();
	}

}
