package MoonPatrol;

//import game.Collision;
//import game.TimeXSpeedManager;

import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.Random;

public class ObstaculosManager
{
	LinkedList<Obstaculos> objetos = new LinkedList<Obstaculos>(); 
	Random rand = new Random();
	
	int platWidth;
	int platHeight;
	
	public ObstaculosManager() 
	{
		platWidth = 300;
		platHeight = 100;
		
		for (int i = 0; i < 1; i++)
		{
			if (i == 0)
				this.objetos.add(new Obstaculos(101 - platWidth / 1, 550, platWidth, platHeight, "/images/buraco.png"));
			else
				this.objetos.add(new Obstaculos(rand.nextInt(800 - platWidth), 150 + (i * 150), platWidth, platHeight, "/images/buraco.png"));
		}
	}
	
	public void Update(PlayerMoonPatrol player) 
	{
		
		for(int i = 0; i < objetos.size(); i++)
		{
			/*if (Collision.CheckCollision(player, objetos.get(i), player.oldPosX, player.oldPosY, "top", TimeXSpeedManager.speed))
				player.y = objetos.get(i).y - player.h;
			if (Collision.CheckCollision(player, objetos.get(i), player.oldPosX, player.oldPosY, "bottom", 0))
				player.y = objetos.get(i).y;
			if (Collision.CheckCollision(player, objetos.get(i), player.oldPosX, player.oldPosY, "left", 0))
				player.x = objetos.get(i).x - player.w;
			if (Collision.CheckCollision(player, objetos.get(i), player.oldPosX, player.oldPosY, "right", 0))
				player.x = objetos.get(i).x + objetos.get(i).w;/*/
			
			objetos.get(i).Update();
			
			if (objetos.get(i).y + objetos.get(i).h < 0)
			{
				objetos.remove(objetos.get(i));
				i--;
			}
		}
		
		if (objetos.getLast().x <= 0)
			AdicionarPlataforma();
	}
	
	
	public void Draw(Graphics2D g2d) 
	{	
		for (Obstaculos	p : objetos)
		{
			p.Draw(g2d);
		}
	}
	
		
	private void AdicionarPlataforma()
	{
		this.objetos.add(new Obstaculos(rand.nextInt(800 - platWidth), 550, platWidth, platHeight, "/images/buraco.png"));
	}
}
