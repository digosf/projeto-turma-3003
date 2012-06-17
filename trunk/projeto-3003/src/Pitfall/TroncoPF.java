package Pitfall;

import java.awt.Point;
import java.awt.geom.Point2D;

public class TroncoPF extends AnimatedSprite
{


	private static final long serialVersionUID = 1L;
	boolean rolando = false;


	public TroncoPF(String img, Point2D position, Point size, float velocity, boolean rolando)
	{
		super(img, position, size, new Point(0, 0), new Point(25, 50), new Point(4, 1), 0.01f, true);
		this.rolando = rolando;
		this.setVelocity(velocity);
	}
	
	public void Update(){
		if (rolando)
		{
			pressionado = true;
			position = new Point2D.Double(position.getX() - this.getVelocity(), position.getY());
		}
		super.Update();
	}
		
	
}