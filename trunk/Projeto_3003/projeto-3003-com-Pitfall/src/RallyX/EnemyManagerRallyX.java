package RallyX;

import java.awt.Graphics2D;
import java.util.LinkedList;

public class EnemyManagerRallyX
{
	private LinkedList<EnemyRallyX> enemyList;
	
	public EnemyManagerRallyX(TileManagerRallyX map, int enemies)
	{
		enemyList = new LinkedList<EnemyRallyX>();
		
		for (int i = 0; i < enemies; i++) 
		{
			enemyList.add(new EnemyRallyX(8*50, 5*50, 50, 50, "/ImagesRallyX/carro_vermelho.png"));
		}
	}
	
	public void update(TileManagerRallyX map)
	{
		for (EnemyRallyX obj : enemyList)
		{
			obj.update(map);
			
			switch (TileManagerRallyX.currentDirection)
			{
				case UP:
					obj.y += TileManagerRallyX.velocityMapMove;
					break;
				case DOWN:
					obj.y -= TileManagerRallyX.velocityMapMove;
					break;
				case LEFT:
					obj.x += TileManagerRallyX.velocityMapMove;
					break;
				case RIGHT:
					obj.x -= TileManagerRallyX.velocityMapMove;
					break;			
			}
		}
	}
	
	public void draw(Graphics2D g2d)
	{
		for (EnemyRallyX obj : enemyList)
			obj.Draw(g2d);
	}
}
