package Game;

import java.awt.Color;
import java.awt.geom.Point2D;

public class GameImage extends GameObject
{
	public GameImage(int x, int y)
	{
		super(x, y);
	}
	public GameImage(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	public GameImage(int x, int y, int w, int h, Color color) {
		super(x, y, w, h, color);
	}	
	public GameImage(Point2D position) {
		super(position);
	}
	public GameImage(Point2D position, Color color) {
		super(position, color);
	}
	public GameImage(Point2D position, Point2D size) {
		super(position, size);
	}
	public GameImage(Point2D position, Point2D size, Color color) {
		super(position, size, color);
	}
}
