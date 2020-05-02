//package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class LightBoard extends Board implements BoardFormatter {

	public LightBoard()
	{
		super(Color.BLACK);
	}
	
	@Override
	public void formatColor() {
		// TODO Auto-generated method stub
		this.setBackground(Color.CYAN);
	}

}