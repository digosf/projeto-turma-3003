package RallyX;

import game.Scene;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.LinkedList;

public class LevelRallyX extends SceneRallyX{

	TileManagerRallyX map;
	PlayerRallyX car;
	
	BackgroundRallyX background = new BackgroundRallyX(0, 0, 800, 600, "/ImagesRallyX/Parte_estrada.png");
	
	public LevelRallyX()
	{
		map = new TileManagerRallyX();
		car = new PlayerRallyX(0, 0, 30, 30, "/ImagesRallyX/tela_start.png", this.map);
	}
	
	@Override
	public void update() 
	{
		System.out.println("Game");
		
		map.update();
		car.update();
	}

	@Override
	public void draw(Graphics2D g2d) 
	{
		background.Draw(g2d);
		map.Draw(g2d);
	}
}
