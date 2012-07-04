package RallyX;

import game.Scene;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;

public class LevelRallyX extends SceneRallyX{

	int [][] tiles = new int[][]{
			{0,1,2},
			{2,1,0}
	};
	int lines = 2;
	int cols = 3;
	
	TileRallyX chao = new TileRallyX(0, 0, 15, 15, "/images/Logo.png");
	TileRallyX grama = new TileRallyX(0, 0, 15, 15, "/images/Logo.png");
	
	public LevelRallyX()
	{
		
	}
	
	@Override
	public void update() 
	{
		
	}

	@Override
	public void draw(Graphics2D g2d) 
	{
		for (int i = 0; i < lines; i++)
		{
			for (int j = 0; j < cols; j++)
			{
				if (tiles[j][i] == 0)
				{
					chao.Draw(g2d);
				}
				
				if (tiles[j][i] == 1)
				{
					chao.Draw(g2d);
				}
				
				if (tiles[j][i] == 2)
				{
					chao.Draw(g2d);
				}
			}
		}
	}
}
