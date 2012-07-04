package RallyX;

import game.Keyboard;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class TileManagerRallyX 
{
	int [][] tiles = new int[][]
	{
			{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1},
			{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
			{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1},
			{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
			{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1},
			{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
			{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1},
			{1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0},
			{0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1}
	};
	
	int lines = 9;
	int cols = 12;
	
	LinkedList<TileRallyX> tilesImg = new LinkedList<TileRallyX>();
	
	public TileManagerRallyX()
	{
		for (int i = 0; i < lines; i++)
		{
			for (int j = 0; j < cols; j++)
			{
				if (tiles[i][j] == 0)
				{
					tilesImg.add(new TileRallyX(j* 30, i*30, 30, 30, "/ImagesRallyX/Parte_estrada.png"));
				}
				
				if (tiles[i][j] == 1)
				{
					tilesImg.add(new TileRallyX(j*30, i*30, 30, 30, "/ImagesRallyX/Parte_meio.png"));
				}
			}
		}
	}
	
	public void update() 
	{
		if (Keyboard.getInstance().isKeyPressed(KeyEvent.VK_UP))
		{
			MoveMap(0);
		}
		
		if (Keyboard.getInstance().isKeyPressed(KeyEvent.VK_DOWN))
		{
			MoveMap(1);
		}
		
		if (Keyboard.getInstance().isKeyPressed(KeyEvent.VK_LEFT))
		{
			MoveMap(2);
		}
		
		if (Keyboard.getInstance().isKeyPressed(KeyEvent.VK_RIGHT))
		{
			MoveMap(3);
		}
	}
	
	public void Draw(Graphics2D g2d) 
	{
		for(TileRallyX obj : tilesImg)
		{
			obj.Draw(g2d);
		}
	}
	
	public void MoveMap(int direction)
	{
		switch (direction)
		{
		case 0:
			for(TileRallyX obj : tilesImg)
			{
				obj.y += 15;
			}
			break;
		case 1:
			for(TileRallyX obj : tilesImg)
			{
				obj.y -= 1;
			}
			break;
		case 2:
			for(TileRallyX obj : tilesImg)
			{
				obj.x += 1;
			}
			break;
		case 3:
			for(TileRallyX obj : tilesImg)
			{
				obj.x -= 1;
			}
			break;
		}
	}
}
