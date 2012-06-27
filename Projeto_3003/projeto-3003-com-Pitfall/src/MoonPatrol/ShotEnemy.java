package MoonPatrol;

//import game.GameObject;

public class ShotEnemy extends ShotMP {
	
		float speed = 2;
		
		public ShotEnemy(float x, float y, int w, int h, String image) 
		{
			super(x, y, w, h, image);
		}
		
		@Override
		public void Update() 
		{
			y += speed;
		}
	
}
