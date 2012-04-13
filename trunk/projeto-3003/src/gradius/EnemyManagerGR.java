package gradius;

import game.Collision;
import game.Game2;

import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.Random;


public class EnemyManagerGR
{
	static LinkedList<EnemyGR> listEnemy = new LinkedList<EnemyGR>();
	
	int numEnemy = 3;
	
	Random rand = new Random();
	
	float timer = 0;
	
	float timerLimit = 100;
	
	public 	EnemyManagerGR()
	{
		 
	}
	public void Update()
	{
		timer++;
		
		if (timer >= timerLimit)
		{
			timer = 0;
			for(int i = 0; i <rand.nextInt(4);i++)
			{
				listEnemy.add(new EnemyGR(800, rand.nextInt(600), 50,50, "/images/inimigos_2.png"));
			}
		}
		
		if (listEnemy.size() > 0)
		{
			for (int e = 0; e < listEnemy.size();e++)
			{	
				listEnemy.get(e).Update();			
			}
		}
		
		for (EnemyGR e : listEnemy)
		{
			if (Collision.CheckCollision(e, Game2.player))
			{
				listEnemy.remove(e);
				Game2.player.life -= 1;
				break;
			}
		}
	}
	
	public void  Draw(Graphics2D g2d)
	{
		if (listEnemy.size() > 0)
		{
			for(int i = 0; i < listEnemy.size();i++)
			{
				listEnemy.get(i).Draw(g2d);
			}
		}
	}
}
