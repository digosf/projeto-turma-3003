package Hero;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

public class Lampada extends AnimatedSprite
{
	private static final long serialVersionUID = 1L;
	float timer = 0;

	public Lampada(int indexImage, Point pos, Point size, Point sPos,
			Point sSize, Point animationType, float timePerFrame, boolean input) 
	{
		super(indexImage, pos, size, sPos, sSize, animationType, timePerFrame, input);
	}
	
	@Override
	public void draw(Graphics2D g2d) 
	{
		super.draw(g2d);
	}
}
