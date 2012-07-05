package Hero;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;

public class Inimigo_Morcego extends AnimatedSprite
{
	boolean cima = true;
	float temporizador = 0;
	
	public Inimigo_Morcego(int indexImage, Point pos, Point size, Point sPos,
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
		if(cima)
		{
			this.setPosition(new Point2D.Double(this.getPosition().getX(), this.getPosition().getY() + 1));
			temporizador ++;
			animationType.y = 1;
			pressionado = true;
			if(temporizador >= 20)
			{
				cima = false;
				temporizador = 0;
			}
		}
		else
		{
			this.setPosition(new Point2D.Double(this.getPosition().getX(), this.getPosition().getY()- 1));
			temporizador ++;
			animationType.y = 1;
			pressionado = true;
			
			if(temporizador >= 20)
			{
				cima = true;
				temporizador = 0;
			}
		}
	}
	@Override
	public void draw(Graphics2D g2d) 
	{
		super.draw(g2d);
	}
	private static final long serialVersionUID = 1L;

}
