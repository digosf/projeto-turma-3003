package MoonPatrol;

import game.Collision;

import game.SceneManager;




import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.Random;


public class BuracoManager
{
	LinkedList<Buraco> objetos = new LinkedList<Buraco>(); 
	Random rand = new Random();
	float timer = 0;
	float limitTimer = 100;
	
	int platWidth;
	int platHeight;
	

     boolean dead;
	public BuracoManager() 
	{
		platWidth = 101;
		platHeight = 600;
		
		for (int i = 0; i < 3; i++)
		{
			if (i == 0)
				this.objetos.add(new Buraco(700 - platWidth / 1, 0, platWidth, platHeight, "/images/buraco.png"));
			else
				this.objetos.add(new Buraco(rand.nextInt(800 - platWidth), 0, platWidth, platHeight, "/images/buraco.png"));
		}
	}
	
	public void Update(PlayerMoonPatrol  player,float speed) 
	{
		timer++;
		
		for(Buraco b : objetos)
			b.x -= speed;
		
		if (timer>=limitTimer)
		{
			timer = 0;
			
		for(int i1 = 0; i1 < objetos.size(); i1++)
		{
			objetos.get(i1).Update();
			
			
			if (objetos.get(i1).y + objetos.get(i1).h < 0)
			{
				objetos.remove(objetos.get(i1));
				i1--;
				
			}
			if (Collision.CheckCollision(player, objetos.get(i1))&& player.y >= 500)
			{
			SceneManager.changeScene(1);
		} 
		}
		
		
		if (objetos.getLast().x<= 0)
			AdicionarPlataforma();
	}
	}
	
	public void Draw(Graphics2D g2d) 
	{	
		for (Buraco p : objetos)
		{
			p.Draw(g2d);
		}
	}
	
		
	private void AdicionarPlataforma()
	{
		this.objetos.add(new Buraco(rand.nextInt(800 - platWidth), 550, platWidth, platHeight, "/images/buraco.png"));
	}
}
