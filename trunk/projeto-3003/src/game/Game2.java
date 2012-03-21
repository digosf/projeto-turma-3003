package game;

import java.awt.Graphics;
import java.awt.Graphics2D;

public class Game2 extends Scene {

	Background background;
	static public PlayerGR player;
	EnemyManagerGR enemyManagerGR;
	
	
	public Game2()
	{
		background = new Background(0, 0, 800, 600, "GradiusFundo.jpg", null);
		player = new PlayerGR(10,300, 100, 30, "player.png", null);
		enemyManagerGR = new EnemyManagerGR();
 	}
	

	@Override
	public void update() {
		// TODO Auto-generated method stub
		player.Update();
		enemyManagerGR.Update();
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		player.Draw(g2d);
		enemyManagerGR.Draw(g2d);
	}
}
