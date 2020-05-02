package TicTacToe;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public class Board extends JPanel implements Observer {
	private Color c;
	public final int SQUARE_SIDE = 100;

	private Model model;
	private int[][] moves;
	private final int PLAYER_ONE = 1;
	private final int PLAYER_TWO = 2;
	private int currentPlayer;

	public static void main (String[]args)
	{
		JFrame frame = new JFrame();
		Board b = new Board(Color.BLACK);

		frame.add(b);
		frame.pack();
		frame.show();
	}

	public Board(Color c) {
		this.c = c;
		
		JButton undo = new JButton("Undo");
		undo.addActionListener(new ButtonListener());
		this.add(undo);
		model = new Model();
		moves = model.getMoves();
		model.addObserver(this);
		JTextArea player = new JTextArea();
		this.add(player);
		JTextArea winner = new JTextArea();
		this.add(winner);
		currentPlayer = PLAYER_ONE;
		this.addMouseListener(new MouseAdapter() {
			private int counter = 0;
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				//Keeps track of the current player
				try {;
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
				
				if (moves[x][y] != 0)
				{
					counter--;
				}
				else
				{
					model.update(x,y, currentPlayer);
				}
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				counter--;
			}
				counter++;
				if (counter%2==0)
				{
					currentPlayer = PLAYER_ONE;
					player.setText("Player 1's Turn");
				}
				else
				{
					currentPlayer = PLAYER_TWO;
					player.setText("Player 2's Turn");
				}
				
				if (model.getWinner()!=0)
				{
					winner.setText("Player " + model.getWinner() + " won!");
				}
				else if (model.boardIsFull() && model.getWinner()==0)
				{
					winner.setText("It's a tie!");
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
//				try {;
//					int x0 = e.getX();
//					int y0 = e.getY();
//					int x = -1;
//					int y = -1;
//					
//					//Getting the position of the player on the x - axis
//					if (x0 <= 100) {
//						x = 0;
//					} else if (x0 <= 200) {
//						x = 1;
//					} else if (x0 <= 300) {
//						x = 2;
//					}
//					
//					//Getting the position of the player on the y - axis
//					if (y0 <= 100) {
//						y = 0;
//					} else if (y0 <= 200) {
//						y = 1;
//					} else if (y0 <= 300) {
//						y = 2;
//					}
//					
//					model.update(x,y, currentPlayer);
//					
//				} catch (Exception e1) {
//					// TODO Auto-generated catch block
//				}
			}
		});
		
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		Rectangle2D.Double boardSize = new Rectangle2D.Double(0,0,300,300);
		g2.setColor(Color.PINK);
		g2.fill(boardSize);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				Rectangle2D.Double square = new Rectangle2D.Double(i * SQUARE_SIDE, j * SQUARE_SIDE, SQUARE_SIDE,
						SQUARE_SIDE);
				g2.setColor(c);
				g2.draw(square);
			}
		}
		
		//Draw x and o
		
		//g2.draw(super.playerX());

		g2.setColor(Color.BLACK);
		Font biggerFont = new Font("Arial", Font.PLAIN, 90);
		g2.setFont(biggerFont);
		for (int i = 0; i < 3; i++)
		{
			for (int j = 0; j < 3; j++)
			{
				System.out.println(i + " " +  j + " " + moves[i][j]);
				if(moves[i][j] == PLAYER_ONE)
				{
					g2.drawString("X", i*100+10, j*100+90);
				}
				else if (moves[i][j] == PLAYER_TWO)
				{
					g2.drawString("O", i*100+10, j*100+90);
				}
			}
		}
	}
		
	

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		//Check for winner and/or board is full
		moves = model.getMoves();
		repaint();
	}

	/*public static void main(String[] args) {
		Board b = new Board(Color.BLACK);
		JFrame frame = new JFrame();
		JButton undo = new JButton();
		undo.addActionListener(new ButtonListener());
		frame.add(b);
		frame.pack();
		frame.show();
	}*/

public class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			model.undo();
			if (currentPlayer == PLAYER_ONE)
			{
				currentPlayer = PLAYER_TWO;
			}
			else
			{
				currentPlayer = PLAYER_ONE;
			}
		}
	}
}
