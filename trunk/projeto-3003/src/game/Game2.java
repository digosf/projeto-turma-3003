package game;

import java.awt.Graphics;

public class Game2 {

	Background background;
	static public PlayerGR player;
	EnemyManagerGR enemyManagerGR;
	
	
	public Game2()
	{
		background = new Background(0, 0, 800, 600, image, sound);
		player = new PlayerGR(10,300, w, h, image, null);
		enemyManagerGR = new EnemyManagerGR();
 	}
	
	public void Update()
	{
		player.Update();
		enemyManagerGR.Update();
		
	
	}
	
	public void Draw(Graphics g)
	{
		player.Draw(g);
		enemyManagerGR.Draw(g);
	}
}
