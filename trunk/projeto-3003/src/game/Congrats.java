package game;

import java.awt.Graphics2D;

class Congrats extends Scene
{
	private Background background;

	int i = 0;
	int Max = 100;

	public Congrats()
	{
		//background = new Background(0, 0, 800, 600, "", null);
		//background.Load( "/imagescongratulations.png" );
		background = new Background(0,0,800,600,"/images/congratulations.png", null);
	}

	public void update()
	{
		if (i++ > Max)
			SceneManager.changeScene(0);
	}

	public void draw(Graphics2D g2d)
	{
		background.Draw(g2d);

		g2d.drawString("Congratulations: " + i, 10, 10);
	}
}