package RallyX;


import java.awt.Graphics2D;
import java.util.LinkedList;

public class LevelRallyX extends SceneRallyX{
	CloudManager clouds;
	TileManagerRallyX map;
	PlayerRallyX car;
	
	BackgroundRallyX background = new BackgroundRallyX(0, 0, 800, 600, "/ImagesRallyX/Parte_estrada.png");
	
	public LevelRallyX()
	{
		map = new TileManagerRallyX();
		car = new PlayerRallyX(0, 0, 30, 30, "/ImagesRallyX/tela_start.png", this.map);
		clouds = new CloudManager();
	}
	
	@Override
	public void update() 
	{
		System.out.println("Game");
		
		map.update();
		car.update();
		clouds.Update();
	}

	@Override
	public void draw(Graphics2D g2d) 
	{
		background.Draw(g2d);
		map.Draw(g2d);
		clouds.draw(g2d);
	}
}
