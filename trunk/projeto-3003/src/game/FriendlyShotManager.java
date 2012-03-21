package game;

import java.awt.event.KeyEvent;
import java.util.LinkedList;


public class FriendlyShotManager {
	
	private static FriendlyShotManager instance = null;
	
	public LinkedList<ShootFriend> ShootFriendList;
	
	public FriendlyShotManager get(){
		if(instance == null){return new FriendlyShotManager();}else{return instance;}
		
		ShootFriendList = new LinkedList<ShootFriend>();
		Shoot = new ShootFriend();
		ShootFriendList.add(Shoot);
		
	}
	
	public void Update()
	{ 
		if(ShootFriendList.size() > 0)
		{
			for(int i = 0; i > ShootFriendList.size(); i++)
			{
				ShootFriendList.update();
			}
		}
		
		if(Keyboard.getInstance().isKeyPressed(KeyEvent.VK_SPACE))
		{
			Fire();			
		}
	}
	
	public void Draw()
	{

		if(ShootFriendList.size() > 0)
		{
			for(int i = 0; i > ShootFriendList.size(); i++)
			{
				ShootFriendList.draw();
			}		
		}
				
	}
	
	public void Fire()
	{
		Shoot = new ShootFriend();
		ShootFriendList.add(Shoot);
		
	
	}
	
	
	
}
