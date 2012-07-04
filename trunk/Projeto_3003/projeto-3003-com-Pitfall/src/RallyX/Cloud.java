package RallyX;

import game.Keyboard;

import java.awt.event.KeyEvent;

public class Cloud extends GameObjectRallyX{

	public int count;
	public Cloud(float x, float y, int w, int h, String image) {
		super(x, y, w, h, image);
		
		// TODO Auto-generated constructor stub
	}
	public void Update()
	{
		count++;
		if(count > 100)
		{
			CloudManager.DeleteCloud();
		}
		if (Keyboard.getInstance().isKeyPressed(KeyEvent.VK_UP))
		{
			y +=  TileManagerRallyX.velocityMapMove;
		}
		
		if (Keyboard.getInstance().isKeyPressed(KeyEvent.VK_DOWN))
		{
			y -=  TileManagerRallyX.velocityMapMove;
		}
		
		if (Keyboard.getInstance().isKeyPressed(KeyEvent.VK_LEFT))
		{
			x +=  TileManagerRallyX.velocityMapMove;
		}
		
		if (Keyboard.getInstance().isKeyPressed(KeyEvent.VK_RIGHT))
		{
			x -=  TileManagerRallyX.velocityMapMove;
		}
	}

}
