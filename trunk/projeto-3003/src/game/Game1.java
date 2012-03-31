package game;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;

import javax.sound.sampled.Clip;

import spaceInvaders.EnemyManagerSI;
import spaceInvaders.EnemyShotManagerSI;
import spaceInvaders.PlayerSI;
import spaceInvaders.ShooterManagerSI;

public class Game1 extends Scene{
	
	public Background background;
	
	public static PlayerSI player;
	
	public static EnemyManagerSI enemy;
	
	static EnemyShotManagerSI tiroInimigo;
	
	ShooterManagerSI tiroAmigo;
	
	public Game1()
	{	
		player = new PlayerSI(new Point2D.Float(400 - 40,550),new Point2D.Float(80,40),"/images/personagemSpaceInvader.png");
		background = new Background(0,0,800,600, "/images/SpaceInvaderFundo.jpg", false, "/sounds/theme_SI.wav", Clip.LOOP_CONTINUOUSLY);
		enemy = new EnemyManagerSI(null);
		tiroInimigo = new EnemyShotManagerSI();
		tiroAmigo = new ShooterManagerSI();
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		enemy.update();
		player.Update();
		tiroInimigo.update();
		tiroAmigo.Update();
		
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		
		background.Draw(g2d);
		player.Draw(g2d);
		enemy.draw(g2d);
		tiroInimigo.draw(g2d);
		tiroAmigo.Draw(g2d);
	}
	
	public void StopBGSound()
	{
		background.clip.stop();
	}
}