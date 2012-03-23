package game;

import java.awt.Graphics2D;

public class Game2 extends Scene {

	Background background;
	static public PlayerGR player;
	static EnemyManagerGR enemyManagerGR;
	int i;
	
	public Game2()
	{
		background = new Background(0, 0, 800, 600, "/images/GradiusFundo.jpg", null);
		player = new PlayerGR(10,300, 100, 30, "/images/player.png", null);
		enemyManagerGR = new EnemyManagerGR();
 	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		player.Update();
		
		FriendlyShotManagerGR.Update();
		
		enemyManagerGR.Update();
		
		if (i ++ > 9000)
			SceneManager.changeScene(0);	
		
	}
	
	@Override
	public void draw(Graphics2D g2d)
	{
		background.Draw(g2d);
		enemyManagerGR.Draw(g2d);
		FriendlyShotManagerGR.Draw(g2d);
		player.Draw(g2d);
	}
}
