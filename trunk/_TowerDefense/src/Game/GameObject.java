package Game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.Point2D;

public abstract class GameObject 
{	
	private Image image;
	protected Color color;
	private boolean sizeDefined;
	protected int x, y, w, h;
	
	public GameObject(int x, int y)
	{
		this.x = x;
		this.y = y;
		color = null;
	}
	public GameObject(int x, int y, int w, int h)
	{
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		sizeDefined = true;
		color = null;
	}
	public GameObject(int x, int y, int w, int h, Color color)
	{
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		sizeDefined = true;
		this.color = color;
	}
	public GameObject(Point2D position)
	{
		x = (int)position.getX();
		y = (int)position.getY();
		color = null;
	}
	public GameObject(Point2D position, Color color)
	{
		x = (int)position.getX();
		y = (int)position.getY();
		this.color = color;
	}
	public GameObject(Point2D position, Point2D size)
	{
		x = (int)position.getX();
		y = (int)position.getY();
		w = (int)size.getX();
		h = (int)size.getY();
		sizeDefined = true;
		color = null;
	}
	public GameObject(Point2D position, Point2D size, Color color)
	{
		x = (int)position.getX();
		y = (int)position.getY();
		w = (int)size.getX();
		h = (int)size.getY();
		sizeDefined = true;
		this.color = color;
	}
	
	public void Load(String filename)
	{
		try
		{
			image = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(filename));
		}
		catch (SecurityException e)
		{
			e.printStackTrace();
			System.err.println("Erro ao carregar arquivo: " + filename);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.err.println("Erro ao carregar arquivo: " + filename);
		}
		finally
		{
			if(!sizeDefined)
			{
				w = image.getWidth(null);
				h = image.getHeight(null);
				if(w > 0 && h > 0)
					sizeDefined = true;
			}
		}		
	}

	@SuppressWarnings("finally")
	public Image Load(Image img, String filename)
	{
		try
		{
			img = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(filename));
		}
		catch (SecurityException e)
		{
			e.printStackTrace();
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.err.println("Erro ao carregar arquivo: " + filename);
		}
		finally
		{
			return img;
		}
	}
	
	public boolean CheckCollision(GameObject object)
	{
		return (this.x < object.x + object.w &&
				this.x + this.w > object.x   &&
				this.y < object.y + object.h &&
				this.y + this.h > object.y   );
	}
	
	public Rectangle getRectangle()
	{
		if(!sizeDefined)
		{
			w = image.getWidth(null);
			h = image.getHeight(null);
			if(w > 0 && h > 0)
				sizeDefined = true;
		}
		
		return new Rectangle(x, y, w, h);
	}
	
	public void Draw(Graphics g)
	{
		if(!sizeDefined)
		{
			w = image.getWidth(null);
			h = image.getHeight(null);
			if(w > 0 && h > 0)
				sizeDefined = true;
		}
		if(color == null)
			g.drawImage(image, x, y, w, h, null);
		else
			g.drawImage(image, x, y, w, h, color, null);
	}
}
