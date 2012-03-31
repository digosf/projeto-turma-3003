package gradius;

import game.GameObject;
import game.SoundClip;

public class EnemyShootGR extends GameObject
{
	float speed = 15;
	
	public EnemyShootGR(float x, float y, int w, int h, String image, String sound, int soundLoop) 
	{
		super(x, y, w, h, image, sound, soundLoop);
	}
	
	@Override
	public void Update() 
	{
		super.x -= speed;
	}
}