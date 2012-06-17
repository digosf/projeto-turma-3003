package MoonPatrol;

//import game.Collision;



import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.Random;


public class EnemyGerencMP {
	static LinkedList<EnemyMP> listEnemy = new LinkedList<EnemyMP>();
	
	int numEnemy = 3;
	
	Random rand = new Random();
	float timer = 0;
	float timerLimit = 80;
	
	
	public 	EnemyGerencMP()
	{
		 
	}
	
	public void Update()
	{
		System.out.println(""+listEnemy.size());
		timer++;
		if (timer>=timerLimit)
		{
			if(listEnemy.size() < 5 ){
			timer = 0;
			for(int i = 0; i <numEnemy;i++)
			{
				listEnemy.add(new EnemyMP(600, 200,60,60, "/images/inimigo.png"));
			}
		}
		}
		
		if (listEnemy.size() > 0)
		{
			for (int e = 0; e < listEnemy.size();e++)
			{	
				listEnemy.get(e).MoveEnemy();			
			}
		}
		if (listEnemy.size() > 0){
			for (EnemyMP e : listEnemy)
			{
				
					/*if (Collision.CheckCollision(e, s))
					{
						listEnemy.remove(e);
						break;
					
				}*/
			}
		}
	}
	public void Draw(Graphics2D g)
	{
		for (int e = 0; e < listEnemy.size();e++)
		{
			listEnemy.get(e).Draw(g);
		}
	}
	
	
	

}
