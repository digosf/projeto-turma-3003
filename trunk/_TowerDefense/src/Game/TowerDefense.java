package Game;

import java.applet.*;
import java.awt.*;
import java.awt.image.*;

public class TowerDefense extends Applet implements Runnable 
{
	private static final long serialVersionUID = 1L;
	public static final int screenWidth = 800;
	public static final int screenHeight = 600;
	
	long time;
	BufferedImage backbuffer;
	Graphics2D g2d;
	
	Thread gameLoop;
	
	GameImage background;
	
	public void init()
	{
		this.backbuffer = new BufferedImage(screenWidth, screenHeight, BufferedImage.TYPE_INT_RGB);
		
		this.g2d = backbuffer.createGraphics();
		
		addKeyListener(Keyboard.getInstance());
		addMouseListener(Mouse.getInstance());
		addMouseMotionListener(Mouse.getInstance());
		
		setFocusable(true);
	}
	
	public void start()
	{
		this.gameLoop = new Thread(this);
		this.gameLoop.start();
		SceneManager.Setup();
	}
	
	public void stop()
	{
		this.gameLoop = null;
	}
	
	public void run()
	{
		Thread t = Thread.currentThread();
		
		while (t == gameLoop)
		{
			try
			{
				Thread.sleep(33);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			
			repaint();			
			
			//time = System.currentTimeMillis();
			
			//SceneManager.scene.update();			
		}
	}
	
	public void update(Graphics g)
	{
		Keyboard.UpdateKeyState();
		Mouse.Update();
		SceneManager.scene.Update();
		paint(g);
	}
	
	public void paint(Graphics g)
	{
		SceneManager.scene.Draw(g2d);
		g.drawImage(backbuffer, 0, 0,this);
	}
}