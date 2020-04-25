package TicTacToe;

import java.util.*;
import java.awt.*;
import javax.swing.*;


public class Model extends Observable{
	int[][] moves;
	private int[] previousMove;
	private int[] currentMove;
	
	public Model()
	{
		moves = new int[3][3];
		currentMove = new int[2];
		previousMove = new int[2];
	}
	
	public void undo()
	{
		currentMove[0] = previousMove[0];
		currentMove[1] = previousMove[1];
		
		setChanged();
		notifyObservers();
	}
	
	public void update(int x, int y, int player)
	{
		previousMove[0] = currentMove[0];
		previousMove[1] = currentMove[1];
		currentMove[0] = x;
		currentMove[1] = y;
		
		setChanged();
		notifyObservers();
	}
}
