package game;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class Credits extends Scene 
{

	//Carrega os cr�ditos
	private GameObject background;

	int i = 0;
	int MAX = 100;

	public Credits()
	{
		background = new Background(0,0,800,2000, "Creditos", null);
	}
	
	//@Overrride
	public void update()
	{
		background.y--;
		if(Keyboard.getInstance().isKeyPressed(KeyEvent.VK_ESCAPE) || background.y < -600)
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