package RallyX;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import game.Keyboard;

public class PlayerRallyX extends GameObjectRallyX
{
	int i;
	int j;
	
//	Image carUp;
//	Image carDown;
//	Image carLeft;
//	Image carRight;
	
	public PlayerRallyX(float x, float y, int w, int h, String imageUp, String imageDown, String imageLeft, String imageRight) {
		super(x, y, w, h, imageUp, imageDown, imageLeft, imageRight);
		image = carRight;
		
//		i = (int)x-650/(int)50;
//		j = (int)y-2250/(int)50;
	}
	
	public void update()
	{
		
		switch (TileManagerRallyX.currentDirection)
		{
		case UP:
			image = carUp;
			break;
		case DOWN:
			image = carDown;
			break;
		case LEFT:
			image = carLeft;
			break;
		case RIGHT:
			image = carRight;
			break;
		}
		
		//System.out.println(" i: "+i+"    j: "+j);
		
		updateIJ();
	}
	
	public void updateIJ()
	{
		i = (int)TileManagerRallyX.carPosition.getX()/(int)TileManagerRallyX.sizeTile;
		j = (int)TileManagerRallyX.carPosition.getY()/(int)TileManagerRallyX.sizeTile;
//		System.out.println("car i: " + i + "  j: " +j);
	}
}
