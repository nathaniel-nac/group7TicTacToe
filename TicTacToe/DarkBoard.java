package TicTacToe;

import java.awt.Color;

public class DarkBoard extends Board implements BoardFormatter{

	public DarkBoard()
	{
		super(Color.WHITE);
	}
	@Override
	public void formatColor() {
		// TODO Auto-generated method stub
		this.setBackground(Color.BLACK);
	}

}
