package game;


import java.util.LinkedList;



public class ShooterManagerSI
{
	
	LinkedList<Shot> shotSI;
	boolean collision;
	EnemyShotSI enemyShot;
	
	public ShooterManagerSI()
	{
		
		shotSI = new LinkedList<Shot>();
		
	}
	
	public void Update()
	{
		
		
		
		for(int i = 0; i < shotSI.size(); i++)
		{
			shotSI.get(i).Update();
			
			
			
			if(Collision.CheckCollision(shotSI.get(i), enemyShot) == true)
			{
				//i--;
				shotSI.remove(i);//remover o item da lista
				
			}
		}
		
		
	}
	
	
	
}