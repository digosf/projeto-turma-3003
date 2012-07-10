package RallyX;

import game.Game;
import game.Time;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;

import RallyX.TileManagerRallyX.DIRECTION_RX;

public class EnemyRallyX extends GameObjectRallyX
{
	int i;
	int j;
	
	static Point2D position;
	
	public DIRECTION_ENEMY currentDirection;
	private int temp;
	private float velocity;
	
	public EnemyRallyX(float x, float y, int w, int h, String image)
	{
		super(x, y, w, h, image);
		currentDirection = DIRECTION_ENEMY.RIGHT;
		
		velocity = 5;
		
		int tempx = 13*50;
		int tempy = 45*50;

//		x+=tempx;
//		y+=tempy;
		
		position = new Point2D.Double(this.x+tempx, this.y+tempy);
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
			verifyBack(map);
			break;
		case LEFT:
			verifyLeft(map);
			break;
		case RIGHT:
			verifyRight(map);
			break;
		}
		//System.out.println("enemy i: " + i + "  j: " +j);
	}
	
	public void verifyFront(TileManagerRallyX map)
	{
		if (map.tiles[j-1][i] == 22)
		{
			this.y-=velocity;
			
			temp++;
			
			if (temp >= 10)
			{
				position = new Point2D.Double(position.getX() , position.getY()- velocity*temp);
				temp = 0;
			}
		}
		else if (map.tiles[j][i-1] == 22)
			currentDirection = DIRECTION_ENEMY.LEFT;
		else if (map.tiles[j][i+1] == 22)
			currentDirection = DIRECTION_ENEMY.RIGHT;
		else
			currentDirection = DIRECTION_ENEMY.DOWN;
	}
	
	public void verifyBack(TileManagerRallyX map)
	{
		if (map.tiles[j+1][i] == 22)
		{
			this.y+=5;
			
			temp++;
			
			if (temp >= 10)
			{
				position = new Point2D.Double(position.getX() , position.getY()+ velocity*temp);
				temp = 0;
			}
		}
		else if (map.tiles[j][i-1] == 22)
			currentDirection = DIRECTION_ENEMY.LEFT;
		else if (map.tiles[j][i+1] == 22)
			currentDirection = DIRECTION_ENEMY.RIGHT;
		else
			currentDirection = DIRECTION_ENEMY.UP;
	}
	
	public void verifyRight(TileManagerRallyX map)
	{
		if (map.tiles[j][i+1] == 22)
		{
			this.x+=5;
			
			temp++;
			
			if (temp >= 10)
			{
				position = new Point2D.Double(position.getX()+ velocity*temp , position.getY());
				temp = 0;
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
			this.x-=5;
			
			temp++;
			
			if (temp >= 10)
			{
				position = new Point2D.Double(position.getX()- velocity*temp , position.getY());
				temp = 0;
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
//		i = (int)this.x/(int)TileManagerRallyX.sizeTile;
//		j = (int)this.y/(int)TileManagerRallyX.sizeTile;
		i = (int)this.position.getX()/(int)TileManagerRallyX.sizeTile;
		j = (int)this.position.getY()/(int)TileManagerRallyX.sizeTile;
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
