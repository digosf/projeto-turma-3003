package game;

import java.awt.Graphics2D;

class GameOver extends Scene
{
	private Background background;

	int i = 0;
	int Max = 100;

	public GameOver()
	{
		background = new Background(0, 0, 800, 600,"LOCAL DA IMG", null);
		background.load( "/images/bgGameOver.png" );
	}

	public void update()
	{
		if (i++ > Max)
			SceneManager.changeScene(1);
	}

	public void draw(Graphics2D g2d)
	{
		background.Draw(g2d);

		g2d.drawString("GameOver: " + i, 10, 10);
	}
		
}