package spaceInvaders;

import game.GameObject;

public abstract class Shot extends GameObject
{
	public float speedX, speedY;
	
	public Shot(float x, float y, int w, int h, String image)
	{
		super(x, y, w, h, image);	
	}
	
	public void Update()
	{	
	}
}
