package RallyX;

import java.util.LinkedList;

public class EnemyManagerRallyX
{
	private LinkedList<EnemyRallyX> enemyList;
	
	public EnemyManagerRallyX(TileManagerRallyX map, int enemies)
	{
		enemyList = new LinkedList<EnemyRallyX>();
		
		for (int i = 0; i < enemies; i++) 
		{
			//enemyList.add(new EnemyRallyX(x, y, w, h, image))
		}
	}
	
	public void update(TileManagerRallyX map)
	{
		
	}
	
	public void draw()
	{
		
	}
}
