package Game;

import java.awt.Graphics2D;

abstract class Scene
{
	protected GameImage background;
	public abstract void Update();
	public abstract void Draw(Graphics2D g2d);
}