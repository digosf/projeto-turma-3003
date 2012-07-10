package RallyX;


import game.Time;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;

public class LevelRallyX extends SceneRallyX{
	CloudManager clouds;
	TileManagerRallyX map;
	public PlayerRallyX car;
	EnemyManagerRallyX enemies;
	BackgroundRallyX background;
	
	int test;
	
	public LevelRallyX()
	{
		background = new BackgroundRallyX(0, 0, 800, 600, "/ImagesRallyX/vermelho.png");
		car = new PlayerRallyX(8*50, 5*50, 50, 50, "/ImagesRallyX/carro_amarelo-frente.png",
				   "/ImagesRallyX/carro_amarelo-baixo.png",
				   "/ImagesRallyX/carro_amarelo-esquerda.png",
				   "/ImagesRallyX/carro_amarelo.png");
		
		map = new TileManagerRallyX(car);
		enemies = new EnemyManagerRallyX(map, 1);
		clouds = new CloudManager(new Point2D.Double(car.x, car.y));
	}
	
	@Override
	public void update() 
	{
		//System.out.println("Game");
		
		//System.out.println("fps: " + Time.getLoopTime());
		
		car.update();
		map.update(car);
		enemies.update(map);
		clouds.Update();
	}

	@Override
	public void draw(Graphics2D g2d) 
	{
		background.Draw(g2d);
		map.Draw(g2d);
		clouds.draw(g2d);
		car.Draw(g2d);
		enemies.draw(g2d);
	}
}
