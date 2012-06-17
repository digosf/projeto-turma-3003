package game;

import java.awt.Graphics2D;
//import java.awt.geom.Point2D;
import java.awt.Rectangle;
import java.util.LinkedList;

public class Game5 extends Scene
{
	public static LinkedList<Rectangle> list = new LinkedList<Rectangle>();

	public Game5()
	{
		super();
		list = new LinkedList<Rectangle>();
    	list.add(new Rectangle(000, 540, 800, 10));
	}

	public void update()
	{
        
    }

	public void draw(Graphics2D g2d)
	{
		
	}
}