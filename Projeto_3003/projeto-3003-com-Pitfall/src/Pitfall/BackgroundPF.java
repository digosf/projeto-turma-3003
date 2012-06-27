package Pitfall;


import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;

import javax.sound.sampled.Clip;

public class BackgroundPF extends GameObjectPF
{
			

	private static final long serialVersionUID = 1L;

	public BackgroundPF(String image)
	{	
		super(image, new Point2D.Double(0,0) , new Point(800,600));
	}
	
}
	
	
