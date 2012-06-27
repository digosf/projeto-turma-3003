package Hero;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.LinkedList;

public class Mapa2 extends GameObject
{
	private static final long serialVersionUID = 1L;
	public LinkedList<Rectangle> mapPiece = new LinkedList<Rectangle>();
	public LinkedList<Rectangle> wall = new LinkedList<Rectangle>();

	public Mapa2(Point position, Point size) 
	{
		super(position, size);
		GenerateMap(0);
	}
	
	public void GenerateMap(int parteLevel)
	{		
		switch(parteLevel)
		{
			//fase 2 - parte 1
			case 0 :
					System.out.println("Fase2-1");
					mapPiece.clear();
					wall.clear();
					mapPiece.add(new Rectangle(0, 0, 126, 175));
					mapPiece.add(new Rectangle(636, 0, 164, 174));
					mapPiece.add(new Rectangle(0, 176, 57, 126));
					mapPiece.add(new Rectangle(724, 176, 76, 124));
					mapPiece.add(new Rectangle(0, 300, 352, 300));
					mapPiece.add(new Rectangle(450, 300, 350, 300));
					wall.add(new Rectangle(267, 14, 55, 298));
				break;
				// fase 2 parte 2;
			case 1 :
					System.out.println("Fase2-2");
					mapPiece.clear();
					wall.clear();
					mapPiece.add(new Rectangle(0, 0, 353, 177));
					mapPiece.add(new Rectangle(0, 178, 56, 122));
					mapPiece.add(new Rectangle(0, 300, 171, 300));
					mapPiece.add(new Rectangle(251, 300, 320, 300));
					mapPiece.add(new Rectangle(654, 300, 146, 300));
					mapPiece.add(new Rectangle(728, 177, 72, 123));
					mapPiece.add(new Rectangle(447, 0, 353, 176));
					wall.add(new Rectangle(256, 171, 40, 135));
				break;
				//fase 2 - parte 3
			case 2 :
					System.out.println("Fase2-3");
					mapPiece.clear();
					wall.clear();
					mapPiece.add(new Rectangle(0, 0, 168, 170));
					mapPiece.add(new Rectangle(0, 174, 104, 123));
					mapPiece.add(new Rectangle(0, 298, 237, 300));
					mapPiece.add(new Rectangle(256, 0, 318, 168));
					mapPiece.add(new Rectangle(322, 172, 240, 133));
					mapPiece.add(new Rectangle(654, 0, 146, 168));
					mapPiece.add(new Rectangle(725, 171, 75, 126));
					mapPiece.add(new Rectangle(551, 300, 250, 300));
				break;
				// fase 2 parte 4;
			case 3 :
					System.out.println("Fase2-4");
					mapPiece.clear();
					wall.clear();
					mapPiece.add(new Rectangle(0, 0, 240, 174));
					mapPiece.add(new Rectangle(548, 0, 252, 176));
					mapPiece.add(new Rectangle(684, 174, 116, 123));
					mapPiece.add(new Rectangle(0, 174, 89, 128));
					mapPiece.add(new Rectangle(0, 304, 8000, 250));
				break;
		}
	}
	
	public void draw(Graphics2D g2d)
	{
		for (Rectangle w : wall)
		{
			g2d.drawImage(LoadImages.getImage(31), w.x, w.y, w.width, w.height, null);
		}
	}
}
