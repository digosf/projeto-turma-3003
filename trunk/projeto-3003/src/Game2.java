

import gradius.EnemyManagerGR;
import gradius.FriendlyShotManagerGR;
import gradius.PlayerGR;

import java.awt.Graphics2D;

import javax.sound.sampled.Clip;

public class Game2 extends Scene {

	public Background background;
	static public PlayerGR player;
	public static EnemyManagerGR enemyManagerGR;
	int i;
	float time;
	
	SoundClip bgSound;
	
	final float maxTime = 60;
	
	public Game2()
	{
		background = new Background(0, 0, 800, 600, "/images/gr_background.png", true);
		player = new PlayerGR(10,300, 100, 30, "/images/gr_personagem.png");
		enemyManagerGR = new EnemyManagerGR();
		bgSound = new SoundClip("/sounds/theme_GR.wav", Clip.LOOP_CONTINUOUSLY);
 	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		player.Update();
		background.Update();
		
		time += System.nanoTime() / 10000000000000000.0f;
		
		FriendlyShotManagerGR.Update();
		
		enemyManagerGR.Update();
		
		if (time >= maxTime)
			SceneManager.changeScene(0);
	}
	
	@Override
	public void draw(Graphics2D g2d)
	{
		background.Draw(g2d);
		enemyManagerGR.Draw(g2d);
		g2d.drawString("Tempo Restante: " + (int)(maxTime - time), 10, 30);
		FriendlyShotManagerGR.Draw(g2d);
		player.Draw(g2d);
	}
}
