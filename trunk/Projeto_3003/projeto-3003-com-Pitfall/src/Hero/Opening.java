package Hero;

import game.Keyboard;
import game.Scene;
import game.SceneManager;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

class Opening extends Scene
{			
	public Opening()
	{
		
	}
	
	public void update()
	{
		if(Keyboard.getInstance().isKeyPressed(KeyEvent.VK_ENTER))
		{
			SceneManager.changeScene(10);
		}
	}
	
	public void draw(Graphics2D g2d)
	{
		g2d.drawImage(LoadImages.getImage(0), 0, 0, null);
	}
}