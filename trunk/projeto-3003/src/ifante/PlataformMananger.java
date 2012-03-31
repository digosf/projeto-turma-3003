package ifante;

import game.Collision;
import game.TimeXSpeedManager;

import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.Random;

public class PlataformMananger 
{
	LinkedList<Plataform> objetos = new LinkedList<Plataform>(); 
	Random rand = new Random();
	
	int platWidth;
	int platHeight;
	
	public PlataformMananger() 
	{
		platWidth = 150;
		platHeight = 50;
		
		for (int i = 0; i < 5; i++)
		{
			if (i == 0)
				this.objetos.add(new Plataform(400 - platWidth / 2, 200, platWidth, platHeight, "/images/platforma_curva.png", null, 0));
			else
				this.objetos.add(new Plataform(rand.nextInt(800 - platWidth), 200 + (i * 150), platWidth, platHeight, "/images/platforma_curva.png", null, 0));
		}
	}
	
	public void Update(PlayerIfante player) 
	{
		
		for(int i = 0; i < objetos.size(); i++)
		{
			if (Collision.CheckCollision(player, objetos.get(i), player.oldPosX, player.oldPosY, "top", TimeXSpeedManager.speed))
				player.y = objetos.get(i).y - player.h;
			if (Collision.CheckCollision(player, objetos.get(i), player.oldPosX, player.oldPosY, "bottom", 0))
				player.y = objetos.get(i).y;
			if (Collision.CheckCollision(player, objetos.get(i), player.oldPosX, player.oldPosY, "left", 0))
				player.x = objetos.get(i).x - player.w;
			if (Collision.CheckCollision(player, objetos.get(i), player.oldPosX, player.oldPosY, "right", 0))
				player.x = objetos.get(i).x + objetos.get(i).w;
			
			objetos.get(i).Update();
			
			if (objetos.get(i).y + objetos.get(i).h < 0)
			{
				objetos.remove(objetos.get(i));
				AdicionarPlataforma();
				i--;
			}
		}
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
		this.objetos.add(new Plataform(rand.nextInt(800 - platWidth), 600, platWidth, platHeight, "/images/platforma_curva.png", null, 0));
	}
}
