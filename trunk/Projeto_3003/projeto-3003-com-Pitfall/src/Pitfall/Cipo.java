package Pitfall;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;

public class Cipo extends GameObjectPF
{

	private static final long serialVersionUID = 1L;

	public Cipo(String imageFileName, Point2D position, Point size) {
		super(imageFileName, position, size);
	}
	
	public void draw(Graphics2D g2d)
	{
		
		g2d.fillRect((int)this.getPosition().getX(),
					(int)this.getPosition().getY(),
					(int)this.getDimension().getX(),
					(int)this.getDimension().getY());
	}

}
