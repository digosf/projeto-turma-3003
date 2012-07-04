package RallyX;

import game.GameObject;

import java.awt.Graphics2D;

public class TileRallyX extends GameObject
{
	int i;
	int j;
	
	public TileRallyX(float x, float y, int w, int h, String image, int i, int j) {
		super(x, y, w, h, image);
		i = this.i;
		j = this.j;
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
