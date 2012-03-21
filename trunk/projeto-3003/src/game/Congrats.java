package game;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;

class Congrats extends Scene
{
	private Background background;

	int i = 0;
	int Max = 100;

	public Congrats()
	{
		background = new Background(new Point2D.Double(0, 0),
									new Point2D.Double(800, 600));
		background.load( "/images/bgCongrats.png" );
	}

	public void update()
	{
		if (i++ > Max)
			SceneManager.changeScene(0);
	}

	public void draw(Graphics2D g2d)
	{
		background.draw(g2d);

		g2d.drawString("Congratulations: " + i, 10, 10);
	}
}