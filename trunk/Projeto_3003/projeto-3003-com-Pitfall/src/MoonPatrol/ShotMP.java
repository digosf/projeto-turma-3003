package MoonPatrol;

import game.GameObject;

public abstract class ShotMP extends GameObject
{
	public float speedX, speedY;
	
	public ShotMP(float x, float y, int w, int h, String image)
	{
		super(x, y, w, h, image);	
	}
	
	public void Update()
	{	
	}
}
