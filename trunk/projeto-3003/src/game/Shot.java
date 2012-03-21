package game;

public abstract class Shot extends GameObject
{
	public float speedX, speedY;
	
	public Shot(float x, float y, int w, int h, String image, SoundClip sound)
	{
		super(x, y, w, h, image, sound);
		
	}
	
	public void Update()
	{
		
	}

}
