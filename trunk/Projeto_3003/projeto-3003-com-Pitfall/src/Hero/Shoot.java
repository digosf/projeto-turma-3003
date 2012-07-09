package Hero;

import java.awt.Point;
import java.awt.geom.Point2D;

public class Shoot extends GameObject
{
	private static final long serialVersionUID = 1L;
	int speed;
	Point positionSave;
	public boolean removeFire = false;
	
	public Shoot(Point position, Point size, int speed) 
	{
		super(position, size);
		this.speed = speed;
		super.setImage(7);
		this.positionSave = position;
	}
	
	public void Update()
	{
		 this.position = new Point2D.Double(this.position.getX() + speed, this.position.getY());
		 
		 if(speed > 0)
		 {
			 System.out.println(this.position.getX() - this.positionSave.getX());
			 
			 if(this.position.getX() - positionSave.x >= 150)
			 {
				 System.out.println("lol");
				 removeFire = true;
			 }
		 }
		 else
		 {
			 if(this.position.getX() - positionSave.x <= -150)
			 {
				 removeFire = true;
			 }
		 }
	}
}