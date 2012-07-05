package RallyX;


import java.awt.Graphics2D;
import java.awt.geom.Point2D;

public class LevelRallyX extends SceneRallyX{
	CloudManager clouds;
	TileManagerRallyX map;
	public PlayerRallyX car;
	
	BackgroundRallyX background = new BackgroundRallyX(0, 0, 800, 600, "/ImagesRallyX/vermelho.png");
	
	public LevelRallyX()
	{
		car = new PlayerRallyX(8*50, 5*50, 50, 50, "/ImagesRallyX/carro_amarelo.png");
		map = new TileManagerRallyX(car);
		clouds = new CloudManager(new Point2D.Double(car.x, car.y));
	}
	
	@Override
	public void update() 
	{
		//System.out.println("Game");
		
		car.update();
		map.update(car);
		clouds.Update();
	}

	@Override
	public void draw(Graphics2D g2d) 
	{
		background.Draw(g2d);
		map.Draw(g2d);
		clouds.draw(g2d);
		car.Draw(g2d);
	}
}