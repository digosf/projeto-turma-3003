package Hero;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.LinkedList;

public class Explosao 
{
	private static LinkedList<AnimatedSprite> ExplosaoNormal;
	private static LinkedList<AnimatedSprite> ExplosaoBlack;
	private static LinkedList<AnimatedSprite> ExplosaoRed;
	
	public static LinkedList<AnimatedSprite> getExplosaoNormal() {
		return ExplosaoNormal;
	}
	
	public static LinkedList<AnimatedSprite> getExplosaoBlack()
	{
		return ExplosaoBlack;
	}
	public static LinkedList<AnimatedSprite> getExplosaoRed()
	{
		return ExplosaoRed;
	}

	public static void Iniciar()
	{
		ExplosaoNormal = new LinkedList<AnimatedSprite>();
		ExplosaoBlack = new LinkedList<AnimatedSprite>();
		ExplosaoRed = new LinkedList<AnimatedSprite>();
	}
	
	public static void Update()
	{
		for(int i = 0; i < ExplosaoNormal.size(); i++)
		{
			ExplosaoNormal.get(i).Update();
			if(ExplosaoNormal.get(i).end)
			{
				ExplosaoNormal.remove(i);
			}
		}
		
		for(int i = 0; i < ExplosaoBlack.size(); i++)
		{
			ExplosaoBlack.get(i).Update();
			if(ExplosaoBlack.get(i).end)
			{
				ExplosaoBlack.remove(i);
			}
		}
		for(int i = 0; i < ExplosaoRed.size(); i++)
		{
			ExplosaoRed.get(i).Update();
			if(ExplosaoRed.get(i).end)
			{
				ExplosaoRed.remove(i);
			}
		}
	}
	
	public static void Draw(Graphics2D g2d)
	{
		for(int i = 0; i < ExplosaoNormal.size(); i++)
		{
			ExplosaoNormal.get(i).draw(g2d);
		}
		for(int i = 0; i < ExplosaoBlack.size(); i++)
		{
			ExplosaoBlack.get(i).draw(g2d);
		}
		
		for(int i = 0; i < ExplosaoRed.size(); i++)
		{
			ExplosaoRed.get(i).draw(g2d);
		}
	}
	
	public static void IniciarExplosao(Rectangle rect, float timeAnimation)
	{
		if(ExplosaoNormal == null)
		{
			ExplosaoNormal = new LinkedList<AnimatedSprite>();
		}
		ExplosaoNormal.add(new AnimatedSprite(0,new Point((int)rect.getX(), (int)rect.getY()), new Point((int)rect.getWidth(),(int)rect.getHeight()), new Point(0,0), new Point(64,64), new Point(5,5), timeAnimation, false));
	
	}
	
	public static void IniciarExplosaoBlack(Rectangle rect, float timeAnimation)
	{
		if(ExplosaoBlack == null)
		{
			ExplosaoBlack = new LinkedList<AnimatedSprite>();
		}
		ExplosaoBlack.add(new AnimatedSprite(72,new Point((int)rect.getX(), (int)rect.getY()), new Point((int)rect.getWidth(),(int)rect.getHeight()), new Point(0,0), new Point(64,64), new Point(5,5), timeAnimation, false));
	
	}
	public static void IniciarExplosaoRed(Rectangle rect, float timeAnimation)
	{
		if(ExplosaoNormal == null)
		{
			ExplosaoRed = new LinkedList<AnimatedSprite>();
		}
		ExplosaoNormal.add(new AnimatedSprite(73,new Point((int)rect.getX(), (int)rect.getY()), new Point((int)rect.getWidth(),(int)rect.getHeight()), new Point(0,0), new Point(64,64), new Point(5,5), timeAnimation, false));
	}
}
