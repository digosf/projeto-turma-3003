package game;

import java.awt.Graphics2D;

public class Game3 extends Scene
{
	Background background;
	PlayerIfante player;
	PlataformMananger manager;
	
	public Game3()
	{
		background = new Background(0, 0, 800, 600, "images/PlumetFundo", null);
		player = new PlayerIfante(400, 0, 148, 268, "images/PersonagemPlumet.png", null);
		manager = new PlataformMananger();
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		TimeXSpeedManager.Update();
		player.Update();
		manager.Update(player);
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		player.Draw(g2d);
		manager.Draw(g2d);
		
	}

}
