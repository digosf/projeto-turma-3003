package gradius;

import game.GameObject;
import game.SoundClip;

public class EnemyGR extends GameObject
{
	boolean subindo = false;
	
	float speed = 3;
	
	float speedMoviment = 5;

	public EnemyGR(float x, float y, int w, int h, String image, String sound, int soundLoop) 
	{
		super(x, y, w, h, image, sound, soundLoop);
	}
	
	@Override
	public void Update() 
	{
		{
			x -= speed;
			
			if(subindo)
			{
				if (super.y > 50)
	            {
	            	super.y -= speedMoviment;
	            }
	            else
	            {
	                subindo = false;
	            }
			}
			else
			{
				if (super.y + super.w < 600)
	            {
	            	super.y += speedMoviment;
	            }
	            else
	            {
	                subindo = true;
	            }
			}
		
		super.Update();
	}
	
	/*@Override
	public void Draw(Graphics graphic) 
	{
		super.Draw(graphic);
	}*/
	}
}
