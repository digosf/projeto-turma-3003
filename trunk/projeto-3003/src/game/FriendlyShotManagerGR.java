package game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class FriendlyShotManagerGR {
	
	public static LinkedList<ShootFriendGR> ShootFriendList = new LinkedList<ShootFriendGR>();
	
	public FriendlyShotManagerGR()
	{
				
		
	}
	
	public void Update()
	{ 
		if(ShootFriendList.size() > 0)
		{
			for(int i = 0; i > ShootFriendList.size(); i++)
			{
				ShootFriendList.get(i).Update();
			}
		}
		
		
	}
	
	public void Draw(Graphics graphic)
	{

		if(ShootFriendList.size() > 0)
		{
			for(int i = 0; i > ShootFriendList.size(); i++)
			{
				ShootFriendList.get(i).Draw(graphic);
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
