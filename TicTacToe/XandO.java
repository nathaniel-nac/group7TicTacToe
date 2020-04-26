package TicTacToe;

import java.awt.*;
import java.awt.Shape;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;

public class XandO {
	public Shape playerX() {
		String letter = "X";
		FontRenderContext context = new FontRenderContext() {
		};
		Font f = new Font("SansSerif", Font.BOLD, 24);
		TextLayout layout = new TextLayout(letter, f, context);
		AffineTransform transform = AffineTransform.getTranslateInstance(0, layout.getAscent());
		return layout.getOutline(transform);
	}
	
	public Shape playerO() {
		String letter = "O";
		FontRenderContext context = new FontRenderContext() {
		};
		Font f = new Font("SansSerif", Font.BOLD, 24);
		TextLayout layout = new TextLayout(letter, f, context);
		AffineTransform transform = AffineTransform.getTranslateInstance(0, layout.getAscent());
		return layout.getOutline(transform);
	}
}
