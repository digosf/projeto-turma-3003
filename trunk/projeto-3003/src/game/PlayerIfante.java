package game;

import java.awt.event.KeyEvent;

public class PlayerIfante extends GameObject{

	private int speed = 10;
	
	public PlayerIfante(float x, float y, int w, int h, String image,
			SoundClip sound) {
		super(x, y, w, h, image, sound);
	}
	
	


	public void Update()
	{
		
		if (Keyboard.getInstance().isKeyPressed(KeyEvent.VK_LEFT) && super.x > 0)
		{
			super.x -= speed;
		}
		else if (Keyboard.getInstance().isKeyPressed(KeyEvent.VK_RIGHT) && super.x < 800)
		{
			super.x += speed;
		}
		
			
      
        
	}
	
}