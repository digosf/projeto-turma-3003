package game;

class ShotFriend extends GameObject

{  	
	float speed;
	
	public ShotFriend (float x, float y, int w, int h, SoundClip sound, float speed)
	{
		super(x, y, w, h, "images/tiro_player.png",sound);
		
		this.speed = speed; //Add velocidade ao tiro
	}
	
	@Override
    public void Update()
    {			
		x += speed;	
		
		super.Update();
	}

	 
	

	
	
	
}

