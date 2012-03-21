package game;

import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.Random;

public class EnemyShootManagerGR 
{
	public LinkedList<EnemyShootGR> shootEnemyList = new LinkedList<EnemyShootGR>();
	
	Random random = new Random();
	
	SoundClip sound;
	
	float timer = 0;
	float timerRemaining;
	
	public EnemyShootManagerGR(SoundClip sound)
	{
		this.sound = sound;
	}
	
	public void Shoot()
	{
		EnemyGR enemy = EnemyManagerGR.listEnemy.get(random.nextInt(EnemyManagerGR.listEnemy.size()));
		
		shootEnemyList.add(new EnemyShootGR(enemy.x, enemy.y, enemy.w, enemy.h,"IMAGEM", sound));
	}
	
	public void Update()
	{
		timer ++;
		
		if(timer >= timerRemaining)
		{
			Shoot();
			timer = 0;
		}
		
		for(EnemyShootGR shoot: shootEnemyList)
		{
			shoot.Update();
		}
	}
	public void Draw(Graphics2D g2d)
	{
		for(EnemyShootGR shoot: shootEnemyList)
		{
			shoot.Draw(g2d);
		}
	}
}
