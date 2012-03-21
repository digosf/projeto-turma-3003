package game;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;

class GameOver extends Scene
{
	private Background background;

	int i = 0;
	int Max = 100;

	public GameOver()
	{
		background = new Background(new Point2D.Double(0, 0),
					 new Point2D.Double(800, 600));
		background.load( "/images/bgGameOver.png" );
	}

	public void update()
	{
		if (i++ > Max)
			SceneManager.changeScene();
	}

	public void draw(Graphics2D g2d)
	{
		background.draw(g2d);

		g2d.drawString("GameOver: " + i, 10, 10);
	}
}