//package TicTacToe;

import javax.swing.*;
import java.awt.*;

public class LightBoard implements BoardFormatter {

    @Override
    public Color formatLineColor() {
        // TODO Auto-generated method stub
        return Color.BLACK;
    }

    @Override
    public Color formatBoardColor() {
        // TODO Auto-generated method stub
        return Color.WHITE;
    }

    @Override
    public Color formatXColor() {
        // TODO Auto-generated method stub
        return Color.BLUE;
    }

    @Override
    public Color formatOColor() {
        // TODO Auto-generated method stub
        return Color.MAGENTA;
    }

}