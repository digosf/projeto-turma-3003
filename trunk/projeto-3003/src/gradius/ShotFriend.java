package gradius;

import game.GameObject;
import game.SoundClip;

class ShotFriend extends GameObject

{  	
	float speed;
	
	public ShotFriend (float x, float y, int w, int h, float speed, String sound, int soundLoop)
	{
		super(x, y, w, h, "images/tiro_player.png", sound, soundLoop);
		
		this.speed = speed; //Add velocidade ao tiro
	}
	
	@Override
    public void Update()
    {			
		x += speed;	
		
		super.Update();
	}

	 
	

	
	
	
}

