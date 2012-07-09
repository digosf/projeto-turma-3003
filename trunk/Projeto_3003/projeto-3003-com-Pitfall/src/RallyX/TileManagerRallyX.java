package RallyX;

import game.Game;
import game.Keyboard;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.util.LinkedList;

public class TileManagerRallyX 
{
	public static DIRECTION_RX currentDirection;
	public static DIRECTION_RX nextDirection;
	
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
	
	public int temp;
	
	LinkedList<TileRallyX> tilesImg = new LinkedList<TileRallyX>();
	private boolean startt = false;
	
	public TileManagerRallyX(PlayerRallyX car)
	{
		carPosition = new Point2D.Double(car.x,car.y);
		
		velocityMapMove = 5;
		
		currentDirection = DIRECTION_RX.RIGHT;
		nextDirection = DIRECTION_RX.NULL;
		
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
		setInitialTilemapPosition();
	}
	
	public void update(PlayerRallyX car) 
	{	
		switch (currentDirection)
		{
			case UP:
				MoveMap(car);
				break;
			case DOWN:
				MoveMap(car);
				break;
			case LEFT:
				MoveMap(car);
				break;
			case RIGHT:
				MoveMap(car);
				break;			
		}
		
		InputMap(car);
//		System.out.println(
//				   "up: " + tiles[car.j-1][car.i] + 
//				   ", down: " + tiles[car.j+1][car.i] +
//				   ", left: " + tiles[car.j][car.i-1] +
//				   ", right: " + tiles[car.j][car.i+1] +
//				   "    current: " + tiles[car.j][car.i] +
//				   "    nextDirection: " + nextDirection);
	}
	
	public void Draw(Graphics2D g2d) 
	{
		for(TileRallyX obj : tilesImg)
		{
			obj.Draw(g2d);
		}
	}
	
	public void MoveMap(PlayerRallyX car)
	{
		switch (currentDirection)
		{
		case UP:
			verifyFront(car);
			break;
		case DOWN:
			verifyBack(car);
			break;
		case LEFT:
			verifyLeft(car);
			break;
		case RIGHT:
			verifyRight(car);
			break;
		}
		//System.out.println("x: " + carPosition.getX() + " y: " + carPosition.getY());
	}
	
	public void InputMap(PlayerRallyX car)
	{
		if (Keyboard.getInstance().isKeyPressed(KeyEvent.VK_UP))
        {
			if (tiles[car.j-1][car.i] == 22 && temp == 0)
			{
				currentDirection = DIRECTION_RX.UP;
			}
			else
				nextDirection = DIRECTION_RX.UP;
        }
        
        if (Keyboard.getInstance().isKeyPressed(KeyEvent.VK_DOWN))
        {
        	if (tiles[car.j+1][car.i] == 22 && temp == 0)
        	{
        		currentDirection = DIRECTION_RX.DOWN;
        	}
        	else
				nextDirection = DIRECTION_RX.DOWN;
        }
        
        if (Keyboard.getInstance().isKeyPressed(KeyEvent.VK_LEFT))
        {
        	if (tiles[car.j][car.i-1] == 22 && temp == 0)
        	{
        		currentDirection = DIRECTION_RX.LEFT;
        	}
        	else
				nextDirection = DIRECTION_RX.LEFT;
        }
        
        if (Keyboard.getInstance().isKeyPressed(KeyEvent.VK_RIGHT))
        {
        	if (tiles[car.j][car.i+1] == 22 && temp == 0)
        	{
        		currentDirection = DIRECTION_RX.RIGHT;
        	}
        	else
				nextDirection = DIRECTION_RX.RIGHT;
        }
	}
	
	public void reVerify()
	{
		if (nextDirection != DIRECTION_RX.NULL && nextDirection != DIRECTION_RX.NONE)
		{
			currentDirection = nextDirection;
		}
	}
	
	public void verifyFront(PlayerRallyX car)
	{
		if (tiles[car.j-1][car.i] == 22)
		{
			for(TileRallyX obj : tilesImg)
				obj.y += velocityMapMove;
			
			temp++;
			
			if (temp >= 10)
			{
				carPosition = new Point2D.Double(carPosition.getX() , carPosition.getY()- velocityMapMove*temp);
				temp = 0;
				reVerify();
				nextDirection = DIRECTION_RX.NULL;
			}
		}
		else if (tiles[car.j][car.i-1] == 22)
			currentDirection = DIRECTION_RX.LEFT;
		else if (tiles[car.j][car.i+1] == 22)
			currentDirection = DIRECTION_RX.RIGHT;
		else
			currentDirection = DIRECTION_RX.DOWN;
	}
	
	public void verifyBack(PlayerRallyX car)
	{
		if (tiles[car.j+1][car.i] == 22)
		{
			for(TileRallyX obj : tilesImg)
				obj.y -= velocityMapMove;
			
			temp++;
			
			if (temp >= 10)
			{
				carPosition = new Point2D.Double(carPosition.getX() , carPosition.getY()+ velocityMapMove*temp);
				temp = 0;
				reVerify();
				nextDirection = DIRECTION_RX.NULL;
			}
		}
		else if (tiles[car.j][car.i-1] == 22)
			currentDirection = DIRECTION_RX.LEFT;
		else if (tiles[car.j][car.i+1] == 22)
			currentDirection = DIRECTION_RX.RIGHT;
		else
			currentDirection = DIRECTION_RX.UP;
	}
	
	public void verifyLeft(PlayerRallyX car)
	{
		if (tiles[car.j][car.i-1] == 22)
		{
			for(TileRallyX obj : tilesImg)
				obj.x += velocityMapMove;
			
			temp++;
			
			if (temp >= 10)
			{
				carPosition = new Point2D.Double(carPosition.getX() - velocityMapMove*temp, carPosition.getY());
				temp = 0;
				reVerify();
				nextDirection = DIRECTION_RX.NULL;
			}
		}
		else if (tiles[car.j-1][car.i] == 22)
			currentDirection = DIRECTION_RX.UP;
		else if (tiles[car.j+1][car.i] == 22)
			currentDirection = DIRECTION_RX.DOWN;
		else
			currentDirection = DIRECTION_RX.RIGHT;
	}
	
	public void verifyRight(PlayerRallyX car)
	{
//		System.out.println(car.j + "    " +car.i+1);
		if (tiles[car.j][car.i+1] == 22)
		{
			for(TileRallyX obj : tilesImg)
				obj.x -= velocityMapMove;

			temp++;
			
			if (temp >= 10)
			{
				carPosition = new Point2D.Double(carPosition.getX() + velocityMapMove*temp, carPosition.getY());
				temp = 0;
				reVerify();
				nextDirection = DIRECTION_RX.NULL;
			}
		}
		else if (tiles[car.j-1][car.i] == 22)
			currentDirection = DIRECTION_RX.UP;
		else if (tiles[car.j+1][car.i] == 22)
			currentDirection = DIRECTION_RX.DOWN;
		else
			currentDirection = DIRECTION_RX.LEFT;
	}
	
	public void setInitialTilemapPosition()
	{
		int tempx = 13*50;
		int tempy = 45*50;
		
		for(TileRallyX obj : tilesImg)
		{
			obj.x -= tempx;
			obj.y -= tempy;
		}
		
		carPosition = new Point2D.Double(carPosition.getX() + tempx, carPosition.getY() + tempy);	
	}
	
	public enum DIRECTION_RX
	{
		UP,
		DOWN,
		LEFT,
		RIGHT,
		NONE,
		NULL
	}
}
