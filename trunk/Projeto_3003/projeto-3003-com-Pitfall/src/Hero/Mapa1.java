package Hero;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.LinkedList;

public class Mapa1 extends GameObject 
{
	private static final long serialVersionUID = 1L;
	public LinkedList<Rectangle> mapPiece = new LinkedList<Rectangle>();
	public LinkedList<Rectangle> wall = new LinkedList<Rectangle>();

	public Mapa1(Point position, Point size) 
	{
		super(position, size);
		GenerateMap(0);
	}
	
	public void GenerateMap(int parteLevel)
	{		
		switch(parteLevel)
		{
			//fase 1 - parte 1
			case 0 :
					mapPiece.clear();
					wall.clear();
					mapPiece.add(new Rectangle(0,0, 125, 173));
					mapPiece.add(new Rectangle(0, 177, 56, 125));
					mapPiece.add(new Rectangle(0, 300, 351, 300));
					mapPiece.add(new Rectangle(638, 0, 162, 171));
					mapPiece.add(new Rectangle(726, 172, 74, 124));
					mapPiece.add(new Rectangle(449, 298, 351, 302));
					wall.add(new Rectangle(267, 14, 55, 298));
				break;
				// fase 1 parte 2;
			case 1 :
				mapPiece.clear();
				wall.clear();
				mapPiece.add(new Rectangle(0, 0, 351, 137));
				mapPiece.add(new Rectangle(0, 135, 126, 161));
				mapPiece.add(new Rectangle(0, 298, 800,140));
				mapPiece.add(new Rectangle(674, 132, 126, 168));
				mapPiece.add(new Rectangle(444, 0, 356, 137));
				break;
		}
	}
	
	public void draw(Graphics2D g2d)
	{
		for (Rectangle w : wall)
		{
			g2d.drawImage(LoadImages.getImage(30), w.x, w.y, w.width, w.height, null);
		}
	}
	
}
