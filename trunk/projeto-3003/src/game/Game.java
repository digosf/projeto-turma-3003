package game;

import java.awt.*;
import java.awt.image.*;
import java.applet.*;
import java.util.*;

public class Game extends Applet implements Runnable
{
	/**
	 
	 */
	private static final long serialVersionUID = 1L;
	public static final int screenWidth  = 800;
	public static final int screenHeigth = 600;
	
	BufferedImage backbuffer;
	Graphics2D g2d;

	Thread gameLoop;
	Random rand = new Random();

	public void init()
	{
		this.backbuffer = new BufferedImage(screenWidth, screenHeigth, BufferedImage.TYPE_INT_RGB);

		this.g2d = backbuffer.createGraphics();
		
		setFocusable(true);

		//run();
	}

	public void start()
	{
		this.gameLoop = new Thread(this);
		this.gameLoop.start();
	}

	public void stop()
	{
		this.gameLoop = null;
	}

	public void run()
	{
		Thread t = Thread.currentThread();

		while (t == this.gameLoop)
		{
			try
			{
				Thread.sleep(10);				
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}	
			
			//Time.Update();	
						
			repaint();
		}
	}

	public void update(Graphics g)
	{	
		paint(g);
	}

	public void paint(Graphics g)
	{		
		g.drawImage(backbuffer, 0, 0, this);
	}
}