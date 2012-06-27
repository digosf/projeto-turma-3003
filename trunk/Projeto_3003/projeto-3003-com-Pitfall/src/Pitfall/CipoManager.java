package Pitfall;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.LinkedList;

public class CipoManager 
{

	LinkedList<Cipo> cipoList = new LinkedList<Cipo>();
	Point pontaCipo;
	int sizeCipo;
	float rotation;
	float velRotation = 0.0f;
	final float velCipo = 0.01f;
	boolean cipoDireita = true;
	
	public CipoManager(Point pontaCipo, int sizeCipo)
	{
		this.pontaCipo = pontaCipo;
		this.sizeCipo = sizeCipo;
		cipoList.clear();
		for(int x = 0; x < this.sizeCipo; x++)
		{
			cipoList.add(new Cipo("/images/PF_pixel.png", new Point2D.Double(0, 0), new Point(2, 2)));
		}
	}
	
	
	public void update()
	{
		if(cipoDireita)
		{
			
			if(rotation > 90)
				velRotation += this.velCipo;
			else
				velRotation -= this.velCipo;
			
			rotation -= velRotation;
			if(rotation < 2)
				cipoDireita = false;
		}
		else if(!cipoDireita)
		{
			
			if(rotation > 90)
				velRotation -= this.velCipo;
			else
				velRotation += this.velCipo;
			
			
			rotation += velRotation;
			if(rotation > 178)
				cipoDireita = true;
		}
		
		
		Point2D position2 = new Point2D.Double(pontaCipo.getX(), pontaCipo.getY());
		for(int x = 0; x < this.sizeCipo; x++)
		{
			position2 = new Point2D.Double(position2.getX() + 1 * Math.cos(Math.toRadians(rotation)), 
					   position2.getY() + 1 * Math.sin(Math.toRadians(rotation)));
			
			//cipoList.add(new Cipo("/images/pixel.png", new Point2D.Double(position2.getX(), position2.getY()), new Point(2, 2)));
			cipoList.get(x).setPosition(new Point2D.Double(position2.getX(), position2.getY()));
		}
		
		
		
		
	}
	
	public void draw(Graphics2D g2d)
	{
		g2d.setColor(new Color(106, 82, 10, 255));
		for(Cipo inst : cipoList)
		{
			inst.draw(g2d);
		}
	}
	
	

}
