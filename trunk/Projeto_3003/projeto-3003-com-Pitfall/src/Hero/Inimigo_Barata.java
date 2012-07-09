package Hero;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;

public class Inimigo_Barata extends AnimatedSprite
{
	boolean direita = true;
	float temporizador = 0;
	
	public Inimigo_Barata(int indexImage, Point pos, Point size, Point sPos,
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
		if(direita)
		{
			this.setPosition(new Point2D.Double(this.getPosition().getX() + 3, this.getPosition().getY()));
			temporizador ++;
			animationType.y = 1;
			pressionado = true;
			if(temporizador >= 40)
			{
				direita = false;
				temporizador = 0;
			}
		}
		else
		{
			this.setPosition(new Point2D.Double(this.getPosition().getX() - 3, this.getPosition().getY()));
			temporizador ++;
			animationType.y = 1;
			pressionado = true;
			
			if(temporizador >= 40)
			{
				direita = true;
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