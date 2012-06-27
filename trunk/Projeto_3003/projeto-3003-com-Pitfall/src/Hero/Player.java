package Hero;

import game.Keyboard;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.util.LinkedList;

public class Player extends AnimatedSprite 
{
	private static double velocity;//ALTERAR ESSA
	Point2D speed; //NAO ALTERAR ESSA
	int posX, posY;
	float time, time2;
	public static Point2D pos;
	int x1, x2, y1, y2;
	static boolean second;
	float tempo = 0;
	public double oldPosX, oldPosY;
	public LinkedList<Granada> nade = new LinkedList<Granada>();
	public static LinkedList<Shoot> tiro = new LinkedList<Shoot>();
	float granadeTime = 120;
	float granadeTimer = 120;
	float temp = 0;
	public static int level = 0;
	public static int score = 0;
	public static  int direction = 1;
	
	public static int qtdVida;
	public static int qtdGranada;
	
	public static double getVelocity() 
	{
		return velocity;
	}
		
	public Player(int indexImage, Point pos, Point size, Point sPos,
			Point sSize, Point animationType, float timePerFrame, boolean x, int vida, int bomba)
	{
		
		super(indexImage, pos, size, sPos, sSize, animationType, timePerFrame, x);
		this.qtdVida = vida;
		this.qtdGranada = bomba;
		velocity = 8;
		speed = new Point2D.Double(10000,10000);	
	}

	public void Update()
	{
		oldPosX = this.getPosition().getX();
		oldPosY = this.getPosition().getY();
		
		this.setPosition(new Point2D.Double(this.getPosition().getX(), this.getPosition().getY() + 5));
		
		granadeTimer ++;
		temp ++;
		
		Input();
		
		for (Granada n : nade)
		{
			n.update();
		}
		
		super.Update();
	}
	
@Override
	public Point2D getPosition() 
	{
		return super.getPosition();
	}
	
	public void Input()
	{
		if(Keyboard.getInstance().isKeyPressed(KeyEvent.VK_UP))
		{
			this.setPosition(new Point2D.Double(this.getPosition().getX(), this.getPosition().getY() - 12));
			pressionado = true;
		}		
		if(Keyboard.getInstance().isKeyPressed(KeyEvent.VK_RIGHT))
		{
			direction = 1;
			this.setPosition(new Point2D.Double(this.getPosition().getX() + velocity, this.getPosition().getY()));
			animationType.y = 1;
			pressionado = true;
		}
		else if(Keyboard.getInstance().isKeyPressed(KeyEvent.VK_LEFT))
		{
			direction = 2;
			this.setPosition(new Point2D.Double(this.getPosition().getX() - velocity, this.getPosition().getY()));
			animationType.y = 2;
			pressionado = true;
		}
		
		if (Player.qtdGranada > 0 && Keyboard.getInstance().isKeyPressed(KeyEvent.VK_DOWN) && granadeTimer > granadeTime)
		{
			qtdGranada -= 1;
			granadeTimer = 0;
			nade.add(new Granada(8, new Point((int)this.getPosition().getX() + (int)this.getDimension().getX() / 2 - 10, (int)this.getPosition().getY() + (int)this.getDimension().getY() - 35), 
								new Point(25,30), new Point(0,0), new Point(25,30), new Point(5, 1), 0.4f, false));
		}
		
		if(Keyboard.getInstance().isKeyPressed(KeyEvent.VK_SPACE) && temp > 2 && direction == 1)
		{
			tiro.add(new Shoot(new Point((int)getPosition().getX() + 40, (int)getPosition().getY() + 10), new Point(10, 5), 15));
			temp = 0;
		}
		else if(Keyboard.getInstance().isKeyPressed(KeyEvent.VK_SPACE) && temp > 2 && direction == 2)
		{
			tiro.add(new Shoot(new Point((int)getPosition().getX() + 40, (int)getPosition().getY() + 10), new Point(10, 5), -15));
			temp = 0;
		}
	
		for(int i = 0; i < tiro.size(); i ++)
		{
			tiro.get(i).Update();
			if(tiro.get(i).removeFire == true)
			{
				tiro.remove(i);
			}
		}
	
	}
	@Override
	public void draw(Graphics2D g2d) 
	{	
		for (Granada n : nade)
		{
			n.draw(g2d);
		}
		
		super.draw(g2d);
		
		if(tiro.size() > 0)
		{
			for(int i = 0; i < tiro.size(); i ++)
			{
				tiro.get(i).draw(g2d);
			}
		}
	}
	private static final long serialVersionUID = 1L;
}
