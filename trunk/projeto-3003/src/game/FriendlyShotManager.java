package game;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.LinkedList;


public class FriendlyShotManager 
{	
	private static FriendlyShotManager instance = null;
	
	public LinkedList<ShotFriend> ShotFriendList;
	
	public static FriendlyShotManager getInstance()
	{
		if(instance == null)
		{
			instance = new FriendlyShotManager();
		}
		
		return instance;
	}
	
	public void Update(PlayerSI player)
	{ 
		if(ShotFriendList.size() > 0)
		{
			for(int i = 0; i > ShotFriendList.size(); i++)
			{
				ShotFriendList.get(i).Update();
			}
		}
		
		if(Keyboard.getInstance().isKeyPressed(KeyEvent.VK_SPACE))
		{
			ShotFriendList.add(new ShotFriend(player.x, player.y, 20, 10, null, 10));		
		}
	}
	
	public void Draw(Graphics2D g2d)
	{

		if(ShotFriendList.size() > 0)
		{
			for(int i = 0; i > ShotFriendList.size(); i++)
			{
				ShotFriendList.get(i).Draw(g2d);
			}		
		}
				
	}	
}
