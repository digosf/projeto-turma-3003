package gradius;

import game.GameObject;
import game.SoundClip;

public class ShootFriendGR extends GameObject
{
	float speed = 20;
	
	public ShootFriendGR(float x, float y, int w, int h, String image,SoundClip sound) 
	{
		super(x, y, w, h, image, sound);
	}
	
	@Override
	public void Update() 
	{
		super.x += speed;
	}	
}

