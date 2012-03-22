package game;

import java.awt.Graphics2D;
import java.util.LinkedList;

public class FriendlyShotManagerGR {
	
	public static LinkedList<ShootFriendGR> ShootFriendList = new LinkedList<ShootFriendGR>();
	
	public FriendlyShotManagerGR()
	{
				
		
	}
	
	public static void Update()
	{ 
		if(ShootFriendList.size() > 0)
		{
			for(int i = 0; i > ShootFriendList.size(); i++)
			{
				ShootFriendList.get(i).Update();
			}
		}
		
		
	}
	
	public static void Draw(Graphics2D g2d)
	{

		if(ShootFriendList.size() > 0)
		{
			for(int i = 0; i > ShootFriendList.size(); i++)
			{
				ShootFriendList.get(i).Draw(g2d);
			}		
		}
				
	}
	
	public static void Fire()
	{
		ShootFriendGR shoot = new ShootFriendGR((float)Game2.player.x,(float)Game2.player.y,
				20,10,"tiro_player.png",null);
		ShootFriendList.add(shoot);
		
	
	}
	
	
	
}
