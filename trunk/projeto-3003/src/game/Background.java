package game;

import java.awt.Graphics2D;

public class Background extends GameObject{
			
	boolean parallax;
	
	public Background(float x, float y, int w, int h, String image, SoundClip sound, boolean parallax)
	{
		 super(x, y, w, h, image,sound);
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
	
	
