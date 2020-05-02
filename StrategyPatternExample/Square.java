package test;

import java.awt.*;
import java.awt.geom.Rectangle2D;

import javax.swing.*;

public class Square implements Icon {

    private int side;
    private Rectangle2D.Double rect;
    IShapeColor shapeColor;
    
    public Square(int aBoardSide, IShapeColor shapeColor) {
        side = aBoardSide;
        rect = new Rectangle2D.Double(0, 0, side, side);
        this.shapeColor = shapeColor;
    }
    
    public Rectangle2D.Double getBoardShape() {
        return rect;
    }
    
    public int getBoardSide() {
        return side;
    }
    
    public IShapeColor getShapeColor() {
        return shapeColor;
    }
    
    /*public Color changeColor() {
        return this.shapeColor.setColor();
    }*/
    
    /*public Icon format(Icon newBoard) {
        return newBoard;
    }*/

    @Override
    public int getIconHeight() {
        // TODO Auto-generated method stub
        return side+1;
    }

    @Override
    public int getIconWidth() {
        // TODO Auto-generated method stub
        return side+1;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        // TODO Auto-generated method stub
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(this.shapeColor.setColor());
        g2.fill(rect);
        //g2.draw(rect);
    }

}
