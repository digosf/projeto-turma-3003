package RallyX;


import java.awt.Graphics2D;
import java.awt.geom.Point2D;

public class LevelRallyX extends SceneRallyX{
	CloudManager clouds;
	TileManagerRallyX map;
	public PlayerRallyX car;
	
	BackgroundRallyX background = new BackgroundRallyX(0, 0, 800, 600, "/ImagesRallyX/tela_start.png");
	
	public LevelRallyX()
	{
		car = new PlayerRallyX(7*50, 10*50, 50, 50, "/ImagesRallyX/carro_amarelo.png");
		map = new TileManagerRallyX(car);
		clouds = new CloudManager(new Point2D.Double(car.x, car.y));
	}
	
	@Override
	public void update() 
	{
		//System.out.println("Game");
		
		map.update(car);
		car.update(map);
		clouds.Update();
	}

	@Override
	public void draw(Graphics2D g2d) 
	{
		background.Draw(g2d);
		map.Draw(g2d);
		car.Draw(g2d);
		clouds.draw(g2d);
	}
}
