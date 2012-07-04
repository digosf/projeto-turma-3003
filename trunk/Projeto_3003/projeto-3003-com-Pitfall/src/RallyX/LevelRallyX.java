package RallyX;


import java.awt.Graphics2D;

public class LevelRallyX extends SceneRallyX{
	CloudManager clouds;
	TileManagerRallyX map;
	public PlayerRallyX car;
	
	BackgroundRallyX background = new BackgroundRallyX(0, 0, 800, 600, "/ImagesRallyX/tela_start.png");
	
	public LevelRallyX()
	{
		map = new TileManagerRallyX();
		car = new PlayerRallyX(7*50, 10*50, 50, 50, "/ImagesRallyX/carro_amarelo.png", this.map);
		clouds = new CloudManager();
	}
	
	@Override
	public void update() 
	{
		//System.out.println("Game");
		
		map.update();
		car.update();
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
