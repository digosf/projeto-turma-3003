package game;

import java.awt.geom.Point2D;



class ShotFriend extends GameObject

{  	
	float speed;
	
	public ShotFriend (Point2D position, Point2D dimension, SoundClip sound, float speed)
	{
		super(position, dimension, sound);
		
		this.speed = speed; //Add velocidade ao tiro
	}
	
	@Override
    public void Update()
    {
		//Add posicao do tiro
		this.setPosition(new Point2D.Double(this.getPosition().getX() + speed, this.getPosition().getY()));
		
		
		
		 super.Update();
	}

	 
	

	
	
	
}

