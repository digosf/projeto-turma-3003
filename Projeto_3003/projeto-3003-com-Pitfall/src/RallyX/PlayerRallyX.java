package RallyX;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import game.Keyboard;

public class PlayerRallyX extends GameObjectRallyX
{
	int i;
	int j;
	
	Image carUp;
	
	public PlayerRallyX(float x, float y, int w, int h, String image) {
		super(x, y, w, h, image);
		
		
	}
	
	public void update()
	{
		
		i = (int)TileManagerRallyX.carPosition.getX()/(int)TileManagerRallyX.sizeTile;
		j = (int)TileManagerRallyX.carPosition.getY()/(int)TileManagerRallyX.sizeTile;
		
		//System.out.println("i: " + i + " j: " + j);
	}
}
