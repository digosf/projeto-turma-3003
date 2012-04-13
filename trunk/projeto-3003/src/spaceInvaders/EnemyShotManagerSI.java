package spaceInvaders;
import game.Collision;
import game.Game1;
import game.SoundClip;

import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.Random;

public class EnemyShotManagerSI {
	
	float shotPosiY;
	float shotPosiX;
	Random rand = new Random();
	float timer = 0;
	float timerReaming = 70;
	LinkedList<Shot> shotList = new LinkedList<Shot>();
	SoundClip shootSI;
	
	public EnemyShotManagerSI()
	{
	}
	
	public void update()
	{
		timer ++;
		if(timer > timerReaming)
		{
			timer = 0;
			AdicionarTiro();
		}
		
		for (Shot s : shotList)
		{
			s.Update();
			
			if (Collision.CheckCollision(s, Game1.player))
			{
				shotList.remove(s);
				Game1.player.life -= 1;
				break;
			}
		}
		
		if(shotList.size() > 0)
		{
			for(int i = 0; i < shotList.size(); i++)
			{
				shotList.get(i).Update();
			}
		}
	}
	
	public void draw(Graphics2D g2d)
	{
		if(shotList.size() > 0)
		{
			for(int i = 0; i < shotList.size(); i++)
			{
				shotList.get(i).Draw(g2d);
				shotList.get(i).Draw(g2d);
			}
		}
	}
	
	public void AdicionarTiro()
	{
		EnemySI enemy = EnemyManagerSI.listEnemy.get(rand.nextInt(EnemyManagerSI.listEnemy.size()));
		shotList.add(new EnemyShotSI(enemy.x, enemy.y, 10, 10, "/images/tiro_inimigo.png"));
		shootSI = new SoundClip("/sounds/shoot_SI.wav", 0);
	}
}