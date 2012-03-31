package gradius;


import java.awt.Graphics2D;
import java.util.LinkedList;


public class FriendlyShotManager 
{	
	private static FriendlyShotManager instance = null;
	
	public static LinkedList<ShotFriend> ShotFriendList;
	
	public static FriendlyShotManager getInstance()
	{
		if(instance == null)
		{
			instance = new FriendlyShotManager();
		}
		
		return instance;
	}
	
	public static void Update()
	{ 
		if(ShotFriendList.size() > 0)
		{
			for(int i = 0; i > ShotFriendList.size(); i++)
			{
				ShotFriendList.get(i).Update();
			}
		}
	}
	
	public static void Draw(Graphics2D g2d)
	{

		if(ShotFriendList.size() > 0)
		{
			for(int i = 0; i > ShotFriendList.size(); i++)
			{
				ShotFriendList.get(i).Draw(g2d);
			}		
		}				
	}
	
	public static void Fire(PlayerGR player)
	{
		ShotFriendList.add(new ShotFriend(player.x, player.y, 20, 10, 10, "/sounds/shoot_GR.wav", 0));
	}
}
