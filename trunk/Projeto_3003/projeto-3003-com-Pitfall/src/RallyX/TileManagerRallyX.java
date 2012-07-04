package RallyX;

import game.Keyboard;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.util.LinkedList;

public class TileManagerRallyX 
{
	public static DIRECTION_RX currentDirection;
	
	int [][] tiles = new int[][]
	{
			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9},
			{9,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,9},
			{9,22,21,12,12,12,19,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,16,12,15,15,15,15,17,22,21,15,17,22,22,22,22,9},
			{9,22,25,14,14,14,24,22,22,22,22,22,22,22,22,22,22,22,22,21,12,19,22,22,22,26,22,22,22,22,22,22,26,22,22,22,22,22,22,9},
			{9,22,25,14,14,14,24,22,22,22,16,15,15,15,15,15,17,22,22,25,14,24,22,22,22,28,22,22,22,22,16,15,18,22,22,22,22,22,22,9},
			{9,22,20,13,13,13,18,22,22,22,22,22,22,22,22,22,22,22,22,25,14,24,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,9},
			{9,22,22,22,22,22,22,22,22,22,16,15,15,15,15,15,17,22,22,20,13,18,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,9},
			{9,22,22,22,22,21,12,19,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,21,15,15,15,12,15,15,15,15,15,12,17,22,27,22,9},
			{9,22,22,22,22,25,14,24,22,22,16,15,15,15,15,15,17,22,22,22,22,22,22,22,26,22,22,22,26,22,22,22,22,22,26,22,22,26,22,9},
			{9,22,22,22,22,20,13,18,22,22,22,22,22,22,22,22,22,22,22,22,27,22,22,22,28,22,27,22,26,22,16,15,19,22,26,22,21,24,22,9},
			{9,22,22,22,22,22,22,22,22,22,22,22,22,16,12,12,19,22,21,12,24,22,22,22,22,22,28,22,26,22,22,22,26,22,26,22,20,18,22,9},
			{9,22,21,15,15,15,15,15,15,15,15,19,22,22,25,14,24,22,25,14,24,22,22,22,27,22,22,22,20,15,17,22,26,22,28,22,22,22,22,9},
			{9,22,26,22,22,22,22,22,22,22,22,26,22,22,25,14,24,22,25,14,24,22,22,22,26,22,27,22,22,22,22,22,26,22,22,22,16,19,22,9},
			{9,22,26,22,22,22,22,22,22,22,22,26,22,22,25,13,18,22,20,13,18,22,22,22,28,22,20,15,15,15,15,15,13,15,17,22,22,28,22,9},
			{9,22,26,22,22,16,15,15,17,22,22,26,22,22,26,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,9},
			{9,22,26,22,22,22,22,22,22,22,22,26,22,22,26,22,21,15,15,15,17,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,9},
			{9,22,26,22,22,22,22,22,22,22,22,26,22,22,28,22,28,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,16,15,15,15,19,22,22,9},
			{9,22,20,15,15,19,22,22,21,15,15,18,22,22,22,22,22,22,22,22,22,22,22,21,12,19,22,22,22,22,22,22,22,22,22,22,26,22,22,9},
			{9,22,22,22,22,28,22,22,28,22,22,22,22,21,12,12,19,22,22,22,21,12,12,14,14,14,12,12,12,12,19,22,22,22,22,22,26,22,22,9},
			{9,22,22,22,22,22,22,22,22,22,22,22,22,20,13,13,18,22,22,22,20,13,13,13,13,13,14,14,14,14,24,22,22,22,22,22,26,22,22,9},
			{9,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,25,14,14,14,14,12,19,22,22,22,26,22,22,9},
			{9,22,22,21,19,22,22,22,22,22,22,21,12,12,12,12,12,19,22,22,27,22,22,22,22,22,25,14,14,14,14,14,24,22,22,22,28,22,22,9},
			{9,22,22,25,24,22,22,21,19,22,22,25,14,14,14,14,14,24,22,22,25,19,22,21,12,12,14,14,14,14,14,13,13,17,22,22,22,22,22,9},
			{9,22,22,25,24,22,22,25,24,22,22,25,14,14,14,14,14,24,22,22,25,24,22,25,14,14,14,14,14,14,24,22,22,22,22,22,22,22,22,9},
			{9,22,22,25,24,22,22,25,24,22,22,25,14,14,14,14,14,24,22,22,25,18,22,20,13,13,13,13,13,13,13,17,22,22,22,22,27,22,22,9},
			{9,22,22,25,24,22,22,25,24,22,22,20,13,13,13,13,13,18,22,22,28,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,26,22,22,9},
			{9,22,22,20,18,22,22,20,18,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,21,12,12,12,12,12,19,22,21,12,12,24,22,22,9},
			{9,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,20,13,13,13,13,13,18,22,20,13,13,18,22,22,9},
			{9,22,22,21,12,12,12,12,12,12,12,12,12,12,12,19,22,22,21,12,12,12,19,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,9},
			{9,22,22,25,14,14,14,14,14,14,14,14,14,14,13,18,22,22,25,14,14,14,24,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,9},
			{9,22,22,25,14,14,14,14,14,14,14,14,14,24,22,22,22,22,25,14,14,14,24,22,22,21,12,12,12,12,15,15,15,15,15,17,22,27,22,9},
			{9,22,22,25,14,14,14,14,14,14,14,14,14,18,22,22,22,22,25,14,14,14,24,22,22,25,14,14,14,24,22,22,22,22,22,22,22,26,22,9},
			{9,22,22,25,14,14,14,14,14,14,14,14,24,22,22,22,21,12,14,14,14,14,24,22,22,25,14,14,14,24,22,21,12,12,12,19,22,26,22,9},
			{9,22,22,20,13,13,13,13,13,13,13,13,18,22,22,22,20,13,13,13,13,13,18,22,22,25,14,14,14,24,22,25,14,14,14,24,22,26,22,9},
			{9,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,25,14,14,14,24,22,25,14,14,14,24,22,26,22,9},
			{9,22,22,22,22,22,22,22,22,22,22,22,22,22,21,12,19,22,22,22,22,22,22,22,22,25,14,14,14,24,22,25,14,14,14,24,22,26,22,9},
			{9,22,22,22,22,22,22,22,22,22,22,22,22,22,25,14,24,22,22,22,22,22,22,22,22,20,13,13,13,18,22,20,13,13,13,18,22,28,22,9},
			{9,22,21,12,12,19,22,21,12,12,19,22,22,21,14,14,14,19,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,9},
			{9,22,20,14,14,18,22,25,14,14,24,22,22,25,14,14,14,24,22,22,22,22,22,22,22,22,22,16,15,17,22,22,22,22,22,22,22,22,22,9},
			{9,22,22,25,24,22,22,25,14,14,24,22,22,25,14,14,14,24,22,22,22,21,12,19,22,22,22,22,22,22,22,22,22,21,12,12,19,22,22,9},
			{9,22,22,25,24,22,22,25,14,14,24,22,22,25,14,14,14,24,22,22,22,25,14,24,22,22,22,21,12,19,22,22,22,25,14,14,24,22,22,9},
			{9,22,22,25,24,22,22,25,14,14,24,22,22,25,14,14,14,24,22,22,22,20,13,18,22,22,22,25,14,24,22,22,22,25,14,14,24,22,22,9},
			{9,22,21,14,14,19,22,25,14,14,24,22,22,25,14,14,14,24,22,22,22,22,22,22,22,22,22,20,13,18,22,22,22,20,13,13,18,22,22,9},
			{9,22,20,13,13,18,22,25,14,14,14,19,22,25,14,14,14,24,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,9},
			{9,22,22,22,22,22,22,20,13,13,13,18,22,20,13,13,13,18,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,9},
			{9,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,21,12,12,12,12,12,12,12,19,22,22,22,22,21,12,12,19,22,22,22,9},
			{9,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,20,13,14,14,14,14,14,14,14,19,22,22,22,25,14,14,24,22,22,22,9},
			{9,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,20,13,13,13,13,13,13,18,22,22,22,25,14,14,24,22,22,22,9},
			{9,22,22,22,22,22,22,22,21,12,12,19,22,22,22,22,16,15,19,22,22,22,22,22,22,22,22,22,22,22,22,22,20,13,13,18,22,22,22,9},
			{9,22,22,21,12,12,12,12,14,14,14,14,19,22,22,22,22,22,26,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,9},
			{9,22,22,25,14,14,14,14,14,14,14,14,14,15,15,15,15,15,13,17,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,9},
			{9,22,22,25,14,14,14,14,14,14,14,14,18,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,27,22,27,22,21,12,19,22,9},
			{9,22,22,20,13,14,13,13,13,13,13,18,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,26,22,26,22,25,14,24,22,9},
			{9,22,22,22,22,26,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,22,26,22,26,22,20,13,18,22,9},
			{9,22,22,22,22,26,22,22,21,15,15,17,22,22,22,27,22,27,22,27,22,27,22,27,22,27,22,27,22,22,22,26,22,26,22,22,22,22,22,9},
			{9,22,22,22,22,26,22,22,26,22,22,22,22,22,22,26,22,26,22,26,22,26,22,26,22,26,22,26,22,22,22,26,22,26,22,21,12,19,22,9},
			{9,22,22,22,22,20,15,15,13,15,15,17,22,22,22,26,22,26,22,26,22,26,22,26,22,26,22,26,22,22,22,26,22,26,22,25,14,24,22,9},
			{9,22,22,22,22,22,22,22,22,22,22,22,22,22,22,26,22,26,22,26,22,26,22,26,22,26,22,26,22,22,22,26,22,28,22,20,13,18,22,9},
			{9,22,22,22,22,22,22,22,22,22,22,22,22,22,22,28,22,28,22,28,22,28,22,28,22,28,22,28,22,22,22,28,22,22,22,22,22,22,22,9},
			{9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9,9}
	};
	
	int lines = 60;
	int cols = 40;
	
	static int velocityMapMove;
	
	static Point2D carPosition;
	
	static Point2D mapPosition = new Point2D.Double(0,0);
	
	static float sizeTile = 50;
	
	LinkedList<TileRallyX> tilesImg = new LinkedList<TileRallyX>();
	
	public TileManagerRallyX(PlayerRallyX car)
	{
		carPosition = new Point2D.Double(car.x,car.y);
		
		velocityMapMove = 4;
		currentDirection = DIRECTION_RX.RIGHT;
		
		for (int i = 0; i < lines; i++)
		{
			for (int j = 0; j < cols; j++)
			{
				if (tiles[i][j] == 9)
					tilesImg.add(new TileRallyX(j*sizeTile, i*sizeTile, (int)sizeTile, (int)sizeTile, "/ImagesRallyX/vermelho.png", i, j));
				
				if (tiles[i][j] == 12)
					tilesImg.add(new TileRallyX(j*sizeTile, i*sizeTile, (int)sizeTile, (int)sizeTile, "/ImagesRallyX/Parte_meio-superor.png", i, j));
				
				if (tiles[i][j] == 13)
					tilesImg.add(new TileRallyX(j*sizeTile, i*sizeTile, (int)sizeTile, (int)sizeTile, "/ImagesRallyX/Parte_meio-inferior.png", i, j));
				
				if (tiles[i][j] == 14)
					tilesImg.add(new TileRallyX(j*sizeTile, i*sizeTile, (int)sizeTile, (int)sizeTile, "/ImagesRallyX/Parte_meio.png", i, j));
				
				if (tiles[i][j] == 15)
					tilesImg.add(new TileRallyX(j*sizeTile, i*sizeTile, (int)sizeTile, (int)sizeTile, "/ImagesRallyX/Parte_fina-meio.png", i, j));
				
				if (tiles[i][j] == 16)
					tilesImg.add(new TileRallyX(j*sizeTile, i*sizeTile, (int)sizeTile, (int)sizeTile, "/ImagesRallyX/Parte_fina-esquerda.png", i, j));
				
				if (tiles[i][j] == 17)
					tilesImg.add(new TileRallyX(j*sizeTile, i*sizeTile, (int)sizeTile, (int)sizeTile, "/ImagesRallyX/Parte_fina-direita.png", i, j));
				
				if (tiles[i][j] == 18)
					tilesImg.add(new TileRallyX(j*sizeTile, i*sizeTile, (int)sizeTile, (int)sizeTile, "/ImagesRallyX/Parte_direita-inferior.png", i, j));
				
				if (tiles[i][j] == 19)
					tilesImg.add(new TileRallyX(j*sizeTile, i*sizeTile, (int)sizeTile, (int)sizeTile, "/ImagesRallyX/Parte_direita-superor.png", i, j));
				
				if (tiles[i][j] == 20)
					tilesImg.add(new TileRallyX(j*sizeTile, i*sizeTile, (int)sizeTile, (int)sizeTile, "/ImagesRallyX/Parte_esquerda-inferior.png", i, j));
				
				if (tiles[i][j] == 21)
					tilesImg.add(new TileRallyX(j*sizeTile, i*sizeTile, (int)sizeTile, (int)sizeTile, "/ImagesRallyX/Parte_esquerda-superior.png", i, j));
				
				if (tiles[i][j] == 22)
					tilesImg.add(new TileRallyX(j*sizeTile, i*sizeTile, (int)sizeTile, (int)sizeTile, "/ImagesRallyX/Parte_estrada.png", i, j));
				
				if (tiles[i][j] == 23)
					tilesImg.add(new TileRallyX(j*sizeTile, i*sizeTile, (int)sizeTile, (int)sizeTile, "/ImagesRallyX/Bandeira.png", i, j));
				
				if (tiles[i][j] == 24)
					tilesImg.add(new TileRallyX(j*sizeTile, i*sizeTile, (int)sizeTile, (int)sizeTile, "/ImagesRallyX/Textura24.png", i, j));
				
				if (tiles[i][j] == 25)
					tilesImg.add(new TileRallyX(j*sizeTile, i*sizeTile, (int)sizeTile, (int)sizeTile, "/ImagesRallyX/Textura25.png", i, j));
				
				if (tiles[i][j] == 26)
					tilesImg.add(new TileRallyX(j*sizeTile, i*sizeTile, (int)sizeTile, (int)sizeTile, "/ImagesRallyX/Textura26.png", i, j));
				
				if (tiles[i][j] == 27)
					tilesImg.add(new TileRallyX(j*sizeTile, i*sizeTile, (int)sizeTile, (int)sizeTile, "/ImagesRallyX/Textura27.png", i, j));
				
				if (tiles[i][j] == 28)
					tilesImg.add(new TileRallyX(j*sizeTile, i*sizeTile, (int)sizeTile, (int)sizeTile, "/ImagesRallyX/Textura28.png", i, j));
			}
		}
	}
	public void update(PlayerRallyX car) 
	{
//		carPosition = new Point2D.Double(car.x, car.y);
		
		switch (currentDirection)
		{
			case UP:
				//System.out.println("UP");
				MoveMap();
				break;
			case DOWN:
				//System.out.println("DOWN");
				MoveMap();
				break;
			case LEFT:
				//System.out.println("LEFT");
				MoveMap();
				break;
			case RIGHT:
				//System.out.println("RIGHT");
				MoveMap();
				break;			
		}
		
		InputMap(car);
	}
	
	public void Draw(Graphics2D g2d) 
	{
		for(TileRallyX obj : tilesImg)
		{
			obj.Draw(g2d);
		}
	}
	
	public void MoveMap()
	{
		switch (currentDirection)
		{
		case UP:
			for(TileRallyX obj : tilesImg)
			{
				obj.y += velocityMapMove;
			}
			carPosition = new Point2D.Double(carPosition.getX() , carPosition.getY()- velocityMapMove) ;
			break;
		case DOWN:
			for(TileRallyX obj : tilesImg)
			{
				obj.y -= velocityMapMove;
			}
			carPosition = new Point2D.Double(carPosition.getX() , carPosition.getY()+ velocityMapMove) ;
			break;
		case LEFT:
			for(TileRallyX obj : tilesImg)
			{
				obj.x += velocityMapMove;
			}
			carPosition = new Point2D.Double(carPosition.getX() - velocityMapMove, carPosition.getY()) ;
			break;
		case RIGHT:
			for(TileRallyX obj : tilesImg)
			{
				obj.x -= velocityMapMove;
			}
			carPosition = new Point2D.Double(carPosition.getX() + velocityMapMove, carPosition.getY()) ;
			break;
		}
		//System.out.println("x: " + carPosition.getX() + " y: " + carPosition.getY());
	}
	
	public void InputMap(PlayerRallyX car)
	{
		if (Keyboard.getInstance().isKeyPressed(KeyEvent.VK_UP))
        {
            //MoveMap();
			if (tiles[car.i+1][car.j] == 22)
				currentDirection = DIRECTION_RX.UP;
			
        }
        
        if (Keyboard.getInstance().isKeyPressed(KeyEvent.VK_DOWN))
        {
            //MoveMap();
        	if (tiles[car.i-1][car.j] == 22)
        		currentDirection = DIRECTION_RX.DOWN;
        }
        
        if (Keyboard.getInstance().isKeyPressed(KeyEvent.VK_LEFT))
        {
            //MoveMap();
        	if (tiles[car.i][car.j-1] == 22)
        		currentDirection = DIRECTION_RX.LEFT;
        }
        
        if (Keyboard.getInstance().isKeyPressed(KeyEvent.VK_RIGHT))
        {
            //MoveMap();
        	if (tiles[car.i][car.j+1] == 22)
        		currentDirection = DIRECTION_RX.RIGHT;
        }
	}
	
	public enum DIRECTION_RX
	{
		UP,
		DOWN,
		LEFT,
		RIGHT;
	}
}