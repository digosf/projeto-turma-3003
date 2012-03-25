package game;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class Credits extends Scene 
{

	//Carrega os créditos
	private GameObject background;

	int i = 0;
	int MAX = 100;

	public Credits()
	{
		background = new Background(0,0,800,2000, "/images/Creditos.png", null, false);
	}
	
	//@Overrride
	public void update()
	{
		background.y-= 0.3f;
		if(Keyboard.getInstance().isKeyPressed(KeyEvent.VK_ESCAPE) || background.y < -1600)
		{
			SceneManager.changeScene(0);
		}
	}

	//@Override
	public void draw(Graphics2D g2d) 
	{
		background.Draw(g2d);
	}	
}