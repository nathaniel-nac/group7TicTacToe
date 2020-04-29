package TicTacToe;

import java.util.*;
import java.awt.*;
import javax.swing.*;


public class Model extends Observable {
	Board b;
	int[][] moves;
	private int[] previousMove;
	private int[] currentMove;
	
	public Model()
	{
		//this.b = b;
		moves = new int[3][3];
		currentMove = new int[2];
		previousMove = new int[2];
	}
	
	public int[][] getMoves()
	{
		return moves;
	}
	
	public Board getBoard()
	{
		return b;
	}
	public void undo()
	{
		moves[currentMove[0]][currentMove[1]] = 0;
		
		currentMove[0] = previousMove[0];
		currentMove[1] = previousMove[1];
		
		setChanged();
		notifyObservers();
	}
	
	public void update(int x, int y, int player)
	{
		System.out.println("update worked");
		previousMove[0] = currentMove[0];
		previousMove[1] = currentMove[1];
		currentMove[0] = x;
		currentMove[1] = y;
		
		moves[currentMove[0]][currentMove[1]] = player;
		
		setChanged();
		notifyObservers();
	}
}
