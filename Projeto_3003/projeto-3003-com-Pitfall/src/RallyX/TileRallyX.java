package RallyX;

import game.GameObject;

import java.awt.Graphics2D;
import javax.sound.sampled.Clip;

public class TileRallyX extends GameObject
{

	public TileRallyX(float x, float y, int w, int h, String image) {
		super(x, y, w, h, image);
		// TODO Auto-generated constructor stub
	}
	
	public void Update()
	{
		
	}

	public void Draw(Graphics2D g2d)
	{
		g2d.drawImage(this.image,  (int)this.x, (int)this.y, this.w, this.h, null);
		super.Draw(g2d);
	}
}
