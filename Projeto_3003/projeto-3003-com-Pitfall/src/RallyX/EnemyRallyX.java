package RallyX;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;

import RallyX.TileManagerRallyX.DIRECTION_RX;

public class EnemyRallyX extends GameObjectRallyX
{
	int i;
	int j;
	
	public DIRECTION_ENEMY currentDirection;
	private int temp;
	
	public EnemyRallyX(float x, float y, int w, int h, String image)
	{
		super(x, y, w, h, image);
		currentDirection = DIRECTION_ENEMY.RIGHT;
		
		int tempx = 13*50;
		int tempy = 45*50;
		
		x+=tempx;
		y+=tempy;
	}
	
	public void update(TileManagerRallyX map)
	{
		updateIJ();

		switch (currentDirection)
		{
		case UP:
			verifyFront(map);
			break;
		case DOWN:
			break;
		case LEFT:
			break;
		case RIGHT:
			verifyRight(map);
			break;
		}
		System.out.println("enemy i: " + i + "  j: " +j);
	}
	
	public void verifyFront(TileManagerRallyX map)
	{
		if (map.tiles[j-1][i] == 22)
		{
			temp++;
			y+=5;
			if (temp >= 10)
			{
				temp = 0;
//				reVerify();
//				nextDirection = DIRECTION_RX.NULL;
			}
		}
		else if (map.tiles[j][i-1] == 22)
			currentDirection = DIRECTION_ENEMY.LEFT;
		else if (map.tiles[j][i+1] == 22)
			currentDirection = DIRECTION_ENEMY.RIGHT;
		else
			currentDirection = DIRECTION_ENEMY.DOWN;
	}
	
	public void verifyRight(TileManagerRallyX map)
	{
//		System.out.println(car.j + "    " +car.i+1);
		if (map.tiles[j][i+1] == 22)
		{
			temp++;
			x+=5;
			if (temp >= 10)
			{
//				reVerify();
//				nextDirection = DIRECTION_RX.NULL;
			}
		}
		else if (map.tiles[j-1][i] == 22)
			currentDirection = DIRECTION_ENEMY.UP;
		else if (map.tiles[j+1][i] == 22)
			currentDirection = DIRECTION_ENEMY.DOWN;
		else
			currentDirection = DIRECTION_ENEMY.LEFT;
	}
	
	public void verifyLeft(TileManagerRallyX map)
	{
		if (map.tiles[j][i-1] == 22)
		{
			temp++;
			x-=5;
			if (temp >= 10)
			{
				temp = 0;
//				reVerify();
//				nextDirection = DIRECTION_RX.NULL;
			}
		}
		else if (map.tiles[j-1][i] == 22)
			currentDirection = DIRECTION_ENEMY.UP;
		else if (map.tiles[j+1][i] == 22)
			currentDirection = DIRECTION_ENEMY.DOWN;
		else
			currentDirection = DIRECTION_ENEMY.RIGHT;
	}
	
	public void updateIJ()
	{
		i = (int)this.x/(int)TileManagerRallyX.sizeTile;
		j = (int)this.y/(int)TileManagerRallyX.sizeTile;
	}
	
	@Override
	public void Draw(Graphics2D g2d)
	{
		super.Draw(g2d);
	}
	
	public enum DIRECTION_ENEMY
	{
		UP,
		DOWN,
		LEFT,
		RIGHT,
		NONE
	}
}
