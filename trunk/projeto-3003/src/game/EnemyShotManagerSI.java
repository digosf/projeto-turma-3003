package game;
import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.Random;


public class EnemyShotManagerSI {
	
	float shotPosiY;
	float shotPosiX;
	Random rand = new Random();
	float timer = 0;
	float timerReaming = 70;
	LinkedList<Shot> shotList = new LinkedList<Shot>();
	
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
		
		if(shotList.size() > 0)
		{
			for(int i = 0; i < shotList.size(); i++)
			{
				shotList.get(i).update();
			}
		}
	}
	
	public void draw(Graphics graphic)
	{
		if(shotList.size() > 0)
		{
			for(int i = 0; i < shotList.size(); i++)
			{
				shotList.get(i).draw(graphic);
			}
		}
	}
	
	public void AdicionarTiro()
	{
		EnemySI enemy = EnemyManagerSI.listEnemy.get(rand.nextInt(EnemyManagerSI.listEnemy.size()));
		shotList.add(new Shot(enemy.x, enemy.y, enemy.w, enemy.h, "IMAGEM", null));
	}
	


}