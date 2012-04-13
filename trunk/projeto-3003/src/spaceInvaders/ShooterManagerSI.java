package spaceInvaders;
import game.Collision;
import game.Game1;
import game.Keyboard;
import game.SoundClip;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class ShooterManagerSI

{
	LinkedList<Shot> shotSI;
	boolean collision;
	EnemyShotSI enemyShot;
	int time;
	int timeReaming;
	SoundClip shootSI;
	
	public ShooterManagerSI()
	{
		shotSI = new LinkedList<Shot>();
		timeReaming = 20;
	}
	
	public void Update()
	{
		time++;
		if(Keyboard.getInstance().isKeyPressed(KeyEvent.VK_SPACE) && time >= 30)
		{
			shotSI.add(new FriendShotSI((float)PlayerSI.getPosition().getX() + 35, (float)PlayerSI.getPosition().getY(), 10,10, "/images/tiro_inimigo.png"));
			shootSI = new SoundClip("/sounds/shoot_SI.wav", 0);
			time = 0;
		}
		
		for (Shot s : shotSI)
		{
			s.Update();
			
			for (EnemySI e : Game1.enemy.listEnemy)
			{
				if (Collision.CheckCollision(s, e))
				{
					Game1.enemy.listEnemy.remove(e);
					shotSI.remove(s);
				}
			}
		}
	}
		
	public void Draw(Graphics2D graphic)
	{
		
		for(Shot shot: shotSI)
		{
			shot.Draw(graphic);
		}
	}
}