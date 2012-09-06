package Game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Enemy extends GameObject
{
	public enum Colors
	{
		YELLOW,
		BLUE,
		RED
	}
	
	Colors color;

	float velocity;
	boolean dead;
	
	Random r = new Random();
	
	public Enemy(int x, Colors color) 
	{
		super(x, 600, 50, 50, color == Colors.RED ? Color.RED : color == Colors.BLUE ? Color.BLUE : Color.YELLOW);
		Load("/Images/square.png");
		
		this.color = color;
		
		velocity = Math.min(Math.max(r.nextFloat() * 10, 2), 6);
	}
	
	public void Update()
	{		
		if(!dead)
		{			
			if(Mouse.clicked)
			{
				if(getRectangle().contains(Mouse.lastClickedPosition))
				 {
					dead = true;
					System.out.println("colidiu " + color.toString());
				}
			}
			
			y -= velocity;
			
			switch(color)
			{
				case BLUE:
					if(y < Level.imgBandeira.y + Level.imgBandeira.h) 
					{
						Level.perdeu = true; 
						SceneManager.ChangeScene();
					}
					break;
				case YELLOW:
					if(r.nextInt(50) == 1)
					{
						if(r.nextInt(2) == 1)
						{						
							if(x + 200 < 800)
							{
								x += 200;
							}
						}
						else
						{						
							if(x - 200 > 0)
							{
								x -= 200;
							}
						}
					}
					if(y < Level.imgBandeira.y + Level.imgBandeira.h) 
					{
						Level.perdeu = true; 
						SceneManager.ChangeScene();
					}
					break;
				case RED:
					if(r.nextInt(20) == 1)
					{
						if(r.nextInt(2) == 1)
						{						
							if(x + 200 < 800)
							{
								x += 200;
							}
						}
						else
						{						
							if(x - 200 > 0)
							{
								x -= 200;
							}
						}
					}
					if(y < Level.imgBandeira.y + Level.imgBandeira.h) 
					{
						Level.perdeu = true; 
						SceneManager.ChangeScene();
					}
					break;
			}
		}
	}
	
	public void Draw(Graphics2D g2d)
	{
		if(!dead)
		{
			super.Draw(g2d);
		}
	}
}
