//package TicTacToe;

import java.awt.*;

public class DarkBoard implements BoardFormatter{

    @Override
    public Color formatLineColor() {
        // TODO Auto-generated method stub
        return Color.WHITE;
    }

    @Override
    public Color formatBoardColor() {
        // TODO Auto-generated method stub
        return Color.BLACK;
    }

    @Override
    public Color formatXColor() {
        // TODO Auto-generated method stub
        return Color.CYAN;
    }

    @Override
    public Color formatOColor() {
        // TODO Auto-generated method stub
        return Color.PINK;
    }
    
}