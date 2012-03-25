package spaceInvaders;
import game.Collision;
import game.Game1;
import game.Keyboard;

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
	
	public ShooterManagerSI()
	{
		shotSI = new LinkedList<Shot>();
		timeReaming = 20;
	}
	
	public void Update()
	{
		/*time++;
		if(time > timeReaming)
		{
			time = 0;
			shotSI.add(new FriendShotSI((float)PlayerSI.getPosition().getX(), (float)PlayerSI.getPosition().getY(), 10,10, "/images/tiro_inimigo.png", null ));
		}*/
		time++;
		if(Keyboard.getInstance().isKeyPressed(KeyEvent.VK_SPACE) && time >= 30)
		{
			shotSI.add(new FriendShotSI((float)PlayerSI.getPosition().getX() + 35, (float)PlayerSI.getPosition().getY(), 10,10, "/images/tiro_inimigo.png", null ));
			time = 0;
		}
		
		/*for(int i = 0; i < shotSI.size(); i++)
		{
			shotSI.get(i).Update();
			
			if(Collision.CheckCollision(shotSI.get(i), enemyShot) == true)
			{
				shotSI.remove(i);//remover o item da lista	
			}
		}*/
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