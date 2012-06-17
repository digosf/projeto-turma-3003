package gradius;

import game.GameObject;
import game.SoundClip;

class ShotFriend extends GameObject

{  	
	float speed;
	
	public ShotFriend (float x, float y, int w, int h, float speed)
	{
		super(x, y, w, h, "images/gr_tiroplayer.png");
		
		this.speed = speed; //Add velocidade ao tiro
	}
	
	@Override
    public void Update()
    {			
		x += speed;	
		
		super.Update();
	}

	 
	

	
	
	
}

