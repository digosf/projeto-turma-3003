package MoonPatrol;


import game.Collision;
import game.SceneManager;


import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.Random;

import MoonPatrol.EnemyGerencMP;
import MoonPatrol.EnemyMP;
import MoonPatrol.ShotEnemy;

import MoonPatrol.ShotMP;;


public class ShotEnemyManager {
	
	float shotPosiY;
	float shotPosiX;
	Random rand = new Random();
	float timer = 0;
	float timerReaming = 70;
	LinkedList<ShotMP> shotList = new LinkedList<ShotMP>();
		
	
	public void Update(PlayerMoonPatrol player)
	{
		timer ++;
		if(timer > timerReaming)
		{
			timer = 0;
			AdicionarTiro();
		}
		
		for (ShotMP s : shotList)
		{			
			if (Collision.CheckCollision(s, player))
			{
				shotList.remove(s);
				SceneManager.changeScene(1);
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
	
	public void draw(Graphics2D g)
	{
		if(shotList.size() > 0)
		{
			for(int i = 0; i < shotList.size(); i++)
			{
				shotList.get(i).Draw(g);
			}
		}
	}
	public void AdicionarTiro()
	{
		if ( EnemyGerencMP.listEnemy.size() > 0 )
		{
		EnemyMP enemy = EnemyGerencMP.listEnemy.get(rand.nextInt(EnemyGerencMP.listEnemy.size()-1));
		shotList.add(new ShotEnemy(enemy.x, enemy.y, 25, 25, "/images/tiro_inimigo.png"));
		}
	}

}
