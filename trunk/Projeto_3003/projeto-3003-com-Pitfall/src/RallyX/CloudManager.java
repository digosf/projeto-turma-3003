package RallyX;

import game.Keyboard;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.LinkedList;


public class CloudManager {
	static LinkedList<Cloud> listClouds = new LinkedList<Cloud>();
	public CloudManager()
	{		
	}
	public void Update()
	{
		if(Keyboard.getInstance().isKeyPressed(KeyEvent.VK_SPACE))
		{
			//Cloud a = new Cloud(LevelRallyX.player.x, LevelRallyX.player.y, 30, 30, null);
			Cloud a = new Cloud(400, 300, 30, 30, "/ImagesRallyX/fumaça.png");
			listClouds.add(a);
			System.out.println("nuvem");
		}
		if(listClouds.size() > 2)
		{
			listClouds.remove(0);
		}
	}
	public void draw(Graphics2D g)
	{
		for(Cloud a : listClouds)
		{
			a.Draw(g);
		}
	}
	public static void DeleteCloud()
	{
		for(Cloud a : listClouds)
		{
			if(a.count > 100)
			{
				listClouds.remove(a);
			}				
		}
	}
}


