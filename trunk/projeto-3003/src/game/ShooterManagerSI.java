package game;
import java.awt.Graphics2D;
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
	}
	
	public void Update()
	{
		time++;
		if(time > timeReaming)
		{
			time = 0;
			shotSI.add(new FriendShotSI((float)PlayerSI.getPosition().getX(), (float)PlayerSI.getPosition().getY(), 10,10, "tiro_player.png", null ));
		}
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
		
		public void Draw(Graphics2D graphic)
		{
			
			for(Shot shot: shotSI)
				shot.Draw(graphic);
			
		}
		
	
	
	
	
}