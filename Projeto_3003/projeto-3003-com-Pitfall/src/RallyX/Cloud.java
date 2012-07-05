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
		if (TileManagerRallyX.currentDirection == TileManagerRallyX.DIRECTION_RX.UP)
		{
			y +=  TileManagerRallyX.velocityMapMove;
		}
		
		if (TileManagerRallyX.currentDirection == TileManagerRallyX.DIRECTION_RX.DOWN)
		{
			y -=  TileManagerRallyX.velocityMapMove;
		}
		
		if (TileManagerRallyX.currentDirection == TileManagerRallyX.DIRECTION_RX.LEFT)
		{
			x +=  TileManagerRallyX.velocityMapMove;
		}
		
		if (TileManagerRallyX.currentDirection == TileManagerRallyX.DIRECTION_RX.RIGHT)
		{
			x -=  TileManagerRallyX.velocityMapMove;
		}
	}

}
