package game;

import java.awt.Graphics2D;

import javax.sound.sampled.Clip;

public class Background extends GameObject{
			
	boolean parallax;
	
	public Background(float x, float y, int w, int h, String image, boolean parallax, String sound, int soundLoop)
	{
		 super(x, y, w, h, image, sound, soundLoop );
		 this.parallax = parallax;
	}
	
	public void Update()
	{
		if (parallax)
			this.x -= 1;
			
		if (this.x <= -800)
			this.x = 0;
	}
	
	public void Draw(Graphics2D g2d)
	{
		if (parallax)
			g2d.drawImage(this.image, (int)this.x + 800, (int)this.y, this.w, this.h, null);
		super.Draw(g2d);
	}
}
	
	
