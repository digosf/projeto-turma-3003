package MoonPatrol;
import java.awt.Graphics2D;

import game.GameObject;

public class Background extends GameObject {

	boolean parallax;
		
	public Background(float x, float y, int w, int h, String image, boolean parallax)
	{
		 super(x, y, w, h, image);
		 
		 this.parallax = parallax;
		
	}
	
public void Update ()
{ 
	if (parallax)
	{
	  this.x -=1;	
	}
	
	if (this.x <= -800)	
	{
		this.x= 0;		
	}
	
	
}
	public void Draw (Graphics2D graphics)
	{
		if (parallax)
		{
			graphics.drawImage(this.image, (int)this.x + 800, (int)this.y, this.w, this.h, null);
			super.Draw(graphics);
		}
		
	}
	
	}
	


	
	
	

