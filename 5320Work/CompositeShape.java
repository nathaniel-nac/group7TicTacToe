package TicTacToe;

import java.awt.*;
import java.awt.geom.*;
import java.util.*;

/**
 * A shape that is composed of several individual shapes.
 */
public class CompositeShape implements Shape {
	private ArrayList<Shape> shapes;
	public CompositeShape() {
		shapes = new ArrayList<>();
	}
	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		if (shapes.size() == 0) {
			return new Rectangle();
		}
		Shape shape = shapes.get(0);
		Rectangle rect = shape.getBounds();
		for (int i = 1; i < shapes.size(); i++) {
			shape = shapes.get(i);
			rect = rect.union(shape.getBounds());
		}
		return rect;
	}
	@Override
	public Rectangle2D getBounds2D() {
		// TODO Auto-generated method stub
		if (shapes.size() == 0) {
			return new Rectangle2D.Double();
		}
		Shape shape = shapes.get(0);
		Rectangle2D rect = shape.getBounds();
		for (int i = 1; i < shapes.size(); i++) {
			shape = shapes.get(i);
			Rectangle2D.union(rect, shape.getBounds(), rect);
		}
		return rect;
	}
	@Override
	public boolean contains(double x, double y) {
		// TODO Auto-generated method stub
		for (Shape s : shapes) {
			if (s.contains(x, y)) {
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean contains(Point2D p) {
		// TODO Auto-generated method stub
		for (Shape s : shapes) {
			if (s.contains(p)) {
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean intersects(double x, double y, double w, double h) {
		// TODO Auto-generated method stub
		for (Shape s : shapes) {
			if (s.intersects(x, y, w, h))
				return true;
		}
		return false;
	}
	@Override
	public boolean intersects(Rectangle2D r) {
		// TODO Auto-generated method stub
		for (Shape s : shapes) {
			if (s.intersects(r))
				return true;
		}
		return false;
	}
	@Override
	public boolean contains(double x, double y, double w, double h) {
		// TODO Auto-generated method stub
		for (Shape s : shapes) {
			if (s.contains(x, y, w, h)) {
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean contains(Rectangle2D r) {
		// TODO Auto-generated method stub
		for (Shape s : shapes) {
			if (s.contains(r)) {
				return true;
			}
		}
		return false;
	}
	@Override
	public PathIterator getPathIterator(AffineTransform at) {
		// TODO Auto-generated method stub
		CompositeShapePathIterator iterator = new CompositeShapePathIterator();
		for (Shape s : shapes) {
			iterator.add(s.getPathIterator(at));
		}
		return iterator;
	}
	@Override
	public PathIterator getPathIterator(AffineTransform at, double flatness) {
		// TODO Auto-generated method stub
		CompositeShapePathIterator iterator = new CompositeShapePathIterator();
		for (Shape s : shapes) {
			iterator.add(s.getPathIterator(at, flatness));
		}
		return iterator;

	}
	public void add(Shape aShape) {
		shapes.add(aShape);
	}
}