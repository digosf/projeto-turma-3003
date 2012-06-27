package Pitfall;

import game.Keyboard;
import game.Scene;
import game.SceneManager;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;

class Instruction extends Scene
{
	private BackgroundPF background;

	int i = 0;
	int MAX = 400;

	public Instruction()
	{
		String image = "/images/bgOpening.png";
		background = new BackgroundPF(image);
	}

	public void update()
	{
		if (Keyboard.getInstance().isKeyPressed(KeyEvent.VK_ENTER))
			SceneManager.changeScene(3);
		if (Keyboard.getInstance().isKeyPressed(KeyEvent.VK_ESCAPE))
			SceneManager.changeScene(4);
	}

	public void draw(Graphics2D g2d)
	{
		background.draw(g2d);
		g2d.drawString("Opening: " + i, 10, 10);
	}
}
