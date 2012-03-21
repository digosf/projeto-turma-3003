package game;

public class FriendShotSI extends Shot
{
	
	
	public FriendShotSI(float x, float y, int w, int h, String image, SoundClip sound)
	{
		super(x, y, w, h, image, sound);
		speedY = 1;
			
	}
	public void Update()
	{
		 y -= speedY;
	}
}
