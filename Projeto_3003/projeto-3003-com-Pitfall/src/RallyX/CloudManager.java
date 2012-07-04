package RallyX;

import game.Keyboard;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.util.LinkedList;


public class CloudManager {
	static LinkedList<Cloud> listClouds = new LinkedList<Cloud>();
	int countCreate;
	Point2D carPos;
	public CloudManager(Point2D carPos)
	{		
		this.carPos = carPos;
	}
	public void Update()
	{
		
		countCreate++;
		if(Keyboard.getInstance().isKeyPressed(KeyEvent.VK_SPACE) && countCreate >= 12)
		{
			countCreate = 0 ;
			Cloud a = new Cloud((float)carPos.getX(), (float)carPos.getY(), 30, 30, "/ImagesRallyX/fumaça.png");
			//Cloud a = new Cloud(400, 300, 30, 30, "/ImagesRallyX/fumaça.png");
			listClouds.add(a);
			System.out.println("nuvem");
		}
		if(listClouds.size() > 3)
		{
			listClouds.remove(0);
		}
		for(Cloud a : listClouds)
		{
			a.Update();
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


