package game;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.LinkedList;

public class FriendlyShotManagerGR {
	
	private static FriendlyShotManagerGR instance = null;
	
	public LinkedList<ShootFriendGR> ShootFriendList;
	
	public FriendlyShotManagerGR get()
	{
		if(instance == null){return new FriendlyShotManagerGR();}else{return instance;}
		
		ShootFriendList = new LinkedList<ShootFriendGR>();
		
		Shoot = new ShootFriendGR();
		
		
		
	}
	
	public void Update()
	{ 
		if(ShootFriendList.size() > 0)
		{
			for(int i = 0; i > ShootFriendList.size(); i++)
			{
				ShootFriendList.Update();
			}
		}
		
		if(Keyboard.getInstance().isKeyPressed(KeyEvent.VK_SPACE))
		{
			Fire();			
		}
	}
	
	public void Draw(Graphics graphic)
	{

		if(ShootFriendList.size() > 0)
		{
			for(int i = 0; i > ShootFriendList.size(); i++)
			{
				ShootFriendList.draw(graphic);
			}		
		}
				
	}
	
	public void Fire()
	{
		Shoot = new ShootFriend();
		ShootFriendList.add(Shoot);
		
	
	}
	
	
	
}
