package game;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;

public class Game1 extends Scene{
	
	Background background;
	PlayerSI player;
	EnemyManagerSI enemy;
	EnemyShotManagerSI tiroInimigo;
	ShooterManagerSI tiroAmigo;	
	SoundClip themeclip;
	
	public Game1()
	{
		themeclip = new SoundClip();
		themeclip.load("/sounds/theme_SI.wav", true);
		
		player = new PlayerSI(new Point2D.Float(2,2),new Point2D.Float(2,2),"/images/personagemSpaceInvader.png");
		background = new Background(0,0,800,600, "/images/SpaceInvaderFundo.jpg", themeclip);
		enemy = new EnemyManagerSI (null);
		tiroInimigo = new EnemyShotManagerSI();
		tiroAmigo = new ShooterManagerSI();
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		enemy.update();
		background.Update();
		player.Update();
		tiroInimigo.update();
		tiroAmigo.Update();
		
	}
	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		background.Draw(g2d);
		enemy.draw(g2d);
		player.Draw(g2d);
		tiroInimigo.draw(g2d);
		tiroAmigo.Draw(g2d);
	}
	
}