package gradius;

import game.GameObject;

public class EnemyShootGR extends GameObject
{
	float speed = 15;
	
	public EnemyShootGR(float x, float y, int w, int h, String image) 
	{
		super(x, y, w, h, image);
	}
	
	@Override
	public void Update() 
	{
		super.x -= speed;
	}
}