package TicTacToe;

import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Model extends Observable {
	Board b;
	int[][] moves;
	private int[] previousMove;
	private int[] currentMove;
	int winner = 0;

	public Model() {
		moves = new int[3][3];
		currentMove = new int[2];
		previousMove = new int[2];
	}

	public int[][] getMoves() {
		return moves;
	}

	public Board getBoard() {
		return b;
	}

	public void undo() {
		moves[currentMove[0]][currentMove[1]] = 0;

		// Set current move to equal previous move
		currentMove[0] = previousMove[0];
		currentMove[1] = previousMove[1];

		setChanged();
		notifyObservers();
	}

	public void update(int x, int y, int player) {
		previousMove[0] = currentMove[0];
		previousMove[1] = currentMove[1];
		currentMove[0] = x;
		currentMove[1] = y;

		moves[currentMove[0]][currentMove[1]] = player;

		// Check columns
		for (int i = 0; i < 3; i++) {
			if (moves[x][i] != player) {
				break;
			}
			if (i == 2) {
				winner = player;
			}
		}

		// Check rows
		for (int i = 0; i < 3; i++) {
			if (moves[i][y] != player)
				break;
			if (i == 2) {
				winner = player;
			}
		}

		// Check top right diagonal
		if (x == y) {
			for (int i = 0; i < 3; i++) {
				if (moves[i][i] != player)
					break;
				if (i == 2) {
					winner = player;
				}
			}
		}
		if(x + y == 2){
            for(int i = 0; i < 3; i++){
                if(moves[i][2-i] != player)
                    break;
                if(i == 2){
                	winner = player;
                }
            }
        }
		//Check top left diagonal
		
		setChanged();
		notifyObservers();
	}

	public int getWinner() {
		System.out.println("Winner is " + winner);
		return winner;
	}
//		int winner = 0;
//		// Check for winner in rows
//		for (int row = 0; row < 3; row++) {
//			ArrayList<Integer> list = new ArrayList<Integer>();
//			for (int i = 0; i < 3; i++) {
//				list.add(moves[row][i]);
//			}
//			if (samePlayerMoves(list)) {
//				winner = list.get(0);
//				return winner;
//			}
//		}
//
//		// Check for winner in columns
//		for (int col = 0; col < 3; col++) {
//			ArrayList<Integer> list = new ArrayList<Integer>();
//			for (int i = 0; i < 3; i++) {
//				list.add(moves[i][col]);
//			}
//			if (samePlayerMoves(list)) {
//				winner = list.get(0);
//				return winner;
//			}
//			return winner;
//		}
//
//		// Check for winner in top left diagonal
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		for (int i = 0; i < 3; i++) {
//			list.add(moves[i][i]);
//		}
//		if (samePlayerMoves(list) == true) {
//			winner = list.get(0);
//			return winner;
//		}
//
//		// Check for winner in top right diagonal
//		ArrayList<Integer> list2 = new ArrayList<Integer>();
//		for (int i = 0; i < 3; i++) {
//			list2.add(moves[3 - i][i]);
//		}
//		if (samePlayerMoves(list2)) {
//			winner = list2.get(0);
//			return winner;
//		}
//		return winner;
//	}
//
//	public boolean samePlayerMoves(ArrayList<Integer> ints) {
//		HashSet<Integer> player = new HashSet<Integer>();
//		player.add(ints.get(0));
//		for (int i = 1; i < ints.size(); i++) {
//			if (player.add(ints.get(i)) == true || ints.get(i) == 0) {
//
//				return false;
//			}
//		}
//		return true;
//	}
//
	public boolean boardIsFull() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (moves[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}
}
