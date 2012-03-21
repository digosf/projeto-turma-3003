package game;

public class EnemyGR extends GameObject
{
	boolean subindo = false;
	
	float speed = 5;
	
	float speedMoviment = 8;

	public EnemyGR(float x, float y, int w, int h, String image, SoundClip sound) 
	{
		super(x, y, w, h, image, sound);
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