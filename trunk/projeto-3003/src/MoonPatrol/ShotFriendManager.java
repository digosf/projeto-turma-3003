package MoonPatrol;


//import java.awt.Graphics2D;
//import java.util.LinkedList;

public class ShotFriendManager 
{
	private static ShotFriendManager instance = null;
	
	
	
	public static ShotFriendManager getInstance()
	{
		if(instance == null)
		{
			instance = new ShotFriendManager();
		}
		
		return instance;
	}
	
	
	
}
