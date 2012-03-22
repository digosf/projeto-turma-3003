package game;

import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.Random;

public class PlataformMananger 
{
	LinkedList<Plataform> objetos; 
	Random random;
	float tempo = 0;
	
	public PlataformMananger() 
	{
	}
	
	public void Update(PlayerIfante player) 
	{
		tempo += System.nanoTime() / 10000000000000000.0f;
		
		//if(tempo > 4)
		//{
		//tempo = 0;
		AdicionarPlataforma();
		//}
		
		/*for(int i = 0; i < objetos.size(); i++)
		{
			((Plataform)objetos.get(i)).Update();
			if (Collision.CheckCollision(player, (Plataform)objetos.get(i), player.oldPosX, player.oldPosY, "top", TimeXSpeedManager.speed))
				player.y = objetos.get(i).y - player.h;
			/*if (Collision.CheckCollision(player, (Plataform)objetos.get(i), player.oldPosX, player.oldPosY, "bottom", 0))
				player.y = objetos.get(i).y;
			if (Collision.CheckCollision(player, (Plataform)objetos.get(i), player.oldPosX, player.oldPosY, "left", 0))
				player.x = objetos.get(i).x - player.w;
			if (Collision.CheckCollision(player, (Plataform)objetos.get(i), player.oldPosX, player.oldPosY, "right", 0))
				player.x = objetos.get(i).x + objetos.get(i).w;
		}*/
	}
	
	
	public void Draw(Graphics2D g2d) 
	{
		/*for(int i = 0; i < objetos.size(); i++)
		{
			((Plataform)objetos.get(i)).Draw(g2d);
		}*/
		
		//if (!objetos.isEmpty())
		//	objetos.get(0).Draw(g2d);
		
		for (Plataform p : objetos)
		{
			p.Draw(g2d);
		}
	}
	
		
	private void AdicionarPlataforma()
	{
		this.objetos.add(new Plataform(400, 300, 417, 94, "/images/banner.png", null , 1));
	}
}
