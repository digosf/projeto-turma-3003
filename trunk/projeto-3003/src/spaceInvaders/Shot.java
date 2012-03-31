package spaceInvaders;

import game.GameObject;
import game.SoundClip;

public abstract class Shot extends GameObject
{
	public float speedX, speedY;
	
	public Shot(float x, float y, int w, int h, String image, String sound, int soundLoop)
	{
		super(x, y, w, h, image, sound, soundLoop);	
	}
	
	public void Update()
	{	
	}
}
