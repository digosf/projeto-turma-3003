package Hero;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;

public class Inimigo_Aranha extends AnimatedSprite
{
		
	public Inimigo_Aranha(int indexImage, Point pos, Point size, Point sPos,
			Point sSize, Point animationType, float timePerFrame, boolean x)
	{
		
		super(indexImage, pos, size, sPos, sSize, animationType, timePerFrame, x);
	}
	

	public void Update()
	{		
		this.setPosition(new Point2D.Double(this.getPosition().getX(), this.getPosition().getY()));
		Animation();
		super.Update();
	}
	
	@Override
	public Point2D getPosition() 
	{
		return super.getPosition();
	}
	
	public void Animation()
	{
			this.setPosition(new Point2D.Double(this.getPosition().getX(), this.getPosition().getY()));
			animationType.y = 1;
			pressionado = true;		
	}
	
	private static final long serialVersionUID = 1L;

}
