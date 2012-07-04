package Hero;

import game.Time;

import java.awt.Point;
import java.awt.Rectangle;

public class Granada extends AnimatedSprite
{
	private static final long serialVersionUID = 1L;
	float explosionTime = 2;
	float explosionTimer;
	public boolean explode;
	public Rectangle explosionRect;
	
	public Granada(int indexImage, Point pos, Point size, Point sPos,
			Point sSize, Point animationType, float timePerFrame, boolean input) 
	{
		super(indexImage, pos, size, sPos, sSize, animationType, timePerFrame, input);
	}
	
	public void update()
	{
		explosionTimer += Time.getLoopTime();
		if (explosionTimer > explosionTime)
		{
			explosionTimer = 0;
			explosionRect = new Rectangle((int)this.getPosition().getX() - 10,(int)this.getPosition().getY(),
										  (int)this.getDimension().getX() + 60, (int)this.getDimension().getY());
			explode = true;
		}
		super.Update();
	}
}