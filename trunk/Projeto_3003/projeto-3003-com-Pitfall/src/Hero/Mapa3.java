package Hero;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.LinkedList;

public class Mapa3 extends GameObject
{
	private static final long serialVersionUID = 1L;
	public LinkedList<Rectangle> mapPiece = new LinkedList<Rectangle>();
	public LinkedList<Rectangle> wall = new LinkedList<Rectangle>();

	public Mapa3(Point position, Point size) 
	{
		super(position, size);
		GenerateMap(0);
	}
	
	public void GenerateMap(int parteLevel)
	{		
		switch(parteLevel)
		{
		//fase 3 - parte 1
		case 0 :
			mapPiece.clear();
			wall.clear();
			System.out.println("Segunda fase2");
			mapPiece.add(new Rectangle(0, 0, 126, 177));
			mapPiece.add(new Rectangle(0, 177, 53, 123));
			mapPiece.add(new Rectangle(0, 300, 350, 300));
			mapPiece.add(new Rectangle(449, 300, 350, 300));
			mapPiece.add(new Rectangle(723, 174, 77, 126));
			mapPiece.add(new Rectangle(683, 0, 162, 173));
			wall.add(new Rectangle(267, 14, 55, 298));
			break;
			// fase 3 parte 2;
		case 1 :
			mapPiece.clear();
			wall.clear();
				System.out.println("Segunda fase2");
				mapPiece.add(new Rectangle(0, 0, 350, 165));
				mapPiece.add(new Rectangle(455, 0, 345, 165));
				mapPiece.add(new Rectangle(0, 168, 63, 128));
				mapPiece.add(new Rectangle(0, 300, 123, 305));
				mapPiece.add(new Rectangle(723, 169, 77, 124));
				mapPiece.add(new Rectangle(647, 300, 153, 305));
			break;
			//fase 3 - parte 3
		case 2 :
			mapPiece.clear();
			wall.clear();
			mapPiece.add(new Rectangle(0, 0, 117, 173));
			mapPiece.add(new Rectangle(0, 174, 62, 131));
			mapPiece.add(new Rectangle(0, 301, 180, 299));
			mapPiece.add(new Rectangle(268, 300, 288, 300));
			mapPiece.add(new Rectangle(642, 300, 158, 300));
			mapPiece.add(new Rectangle(728, 171, 72, 128));
			mapPiece.add(new Rectangle(650, 0, 150, 170));
			break;
			// fase 3 parte 4;
		case 3 :
				System.out.println("Segunda fase2");
				mapPiece.clear();
				wall.clear();
				mapPiece.add(new Rectangle(0, 0, 185, 177));
				mapPiece.add(new Rectangle(274, 0, 282, 176));
				mapPiece.add(new Rectangle(644, 0, 156, 176));
				mapPiece.add(new Rectangle(732, 180, 68, 126));
				mapPiece.add(new Rectangle(0, 187, 62, 121));
				mapPiece.add(new Rectangle(0, 310, 174, 290));
				mapPiece.add(new Rectangle(259, 310, 309, 290));
				mapPiece.add(new Rectangle(660, 310, 140, 290));
				wall.add(new Rectangle(361, 177, 51, 134));
			break;
			//fase 3 - parte 5
		case 4 :
				mapPiece.clear();
				wall.clear();
				mapPiece.add(new Rectangle(0, 0, 177, 173));
				mapPiece.add(new Rectangle(0, 175, 63, 127));
				mapPiece.add(new Rectangle(0, 300, 317, 300));
				mapPiece.add(new Rectangle(256, 0, 311, 171));
				mapPiece.add(new Rectangle(662, 0, 138,171));
				mapPiece.add(new Rectangle(725, 175, 75, 125));
				mapPiece.add(new Rectangle(506, 300, 194, 300));
				wall.add(new Rectangle(521, 160, 31, 145));
			break;
			// fase 3 parte 6;
		case 5 :
				System.out.println("Segunda fase2");
				mapPiece.clear();
				wall.clear();
				mapPiece.add(new Rectangle(0, 0, 318, 174));
				mapPiece.add(new Rectangle(0, 172, 103, 131));
				mapPiece.add(new Rectangle(508, 0, 292, 175));
				mapPiece.add(new Rectangle(684, 175, 116, 128));
				mapPiece.add(new Rectangle(0, 301, 800, 189));
			break;
		}
	}
	
	public void draw(Graphics2D g2d)
	{
		for (Rectangle w : wall)
		{
			g2d.drawImage(LoadImages.getImage(32), w.x, w.y, w.width, w.height, null);
		}
	}
}
