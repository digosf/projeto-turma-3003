package RallyX;

import game.Scene;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.LinkedList;

public class LevelRallyX extends SceneRallyX{

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
	
	BackgroundRallyX background = new BackgroundRallyX(0, 0, 800, 600, "/ImagesRallyX/Parte_estrada.png");
	
	int lines = 9;
	int cols = 12;
	
	LinkedList<TileRallyX> tilesImg = new LinkedList<TileRallyX>();
	
	public LevelRallyX()
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
	
	@Override
	public void update() 
	{
		System.out.println("to no joooooogo");
//		for(TileRallyX obj : tilesImg)
//		{
//			obj.x += 5;
//		}
	}

	@Override
	public void draw(Graphics2D g2d) 
	{
		background.Draw(g2d);
		for(TileRallyX obj : tilesImg)
		{
			obj.Draw(g2d);
		}
	}
}
