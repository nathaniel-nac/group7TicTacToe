package TicTacToe;

import java.awt.geom.PathIterator;
import java.util.ArrayList;

/**
 * A path iterator that iterates through the paths of an array list of shapes.
 */
public class CompositeShapePathIterator implements PathIterator {
	private ArrayList<PathIterator> iterators;
	private int index;

	public CompositeShapePathIterator() {
		iterators = new ArrayList<PathIterator>();
	}

	@Override
	public int getWindingRule() {
		// TODO Auto-generated method stub
		if (isDone()) {
			return 0;
		}
		PathIterator current = iterators.get(index);
		return current.getWindingRule();
	}

	@Override
	public boolean isDone() {
		// TODO Auto-generated method stub
		return index == iterators.size() ;
	}

	@Override
	public void next() {
		// TODO Auto-generated method stub
		PathIterator current = iterators.get(index);
		current.next();
		if (current.isDone()) {
			index++;
		}
	}

	@Override
	public int currentSegment(float[] coords) {
		// TODO Auto-generated method stub
		PathIterator current = iterators.get(index);
		return current.currentSegment(coords);
	}

	@Override
	public int currentSegment(double[] coords) {
		// TODO Auto-generated method stub
		PathIterator current = iterators.get(index);
		return current.currentSegment(coords);
	}

	public void add(PathIterator iterator) {
		iterators.add(iterator);
	}
}