package game;

import java.awt.Graphics2D;

public abstract class Scene
{
	public abstract void update();
	public abstract void draw(Graphics2D g2d);
	public void StopBGSound()
	{
	}
}