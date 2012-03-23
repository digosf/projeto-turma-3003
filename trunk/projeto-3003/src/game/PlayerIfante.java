package game;

import java.awt.event.KeyEvent;

public class PlayerIfante extends GameObject{

	private int speed = 10;
	
	public float oldPosX;
	public float oldPosY;
	
	public PlayerIfante(float x, float y, int w, int h, String image,
			SoundClip sound) {
		super(x, y, w, h, image, sound);
	}
	
	@Override
	public void Update()
	{
		oldPosX = x;
		oldPosY = y;
		
		if (Keyboard.getInstance().isKeyPressed(KeyEvent.VK_LEFT) && super.x > 0)
		{
			super.x -= speed;
		}
		else if (Keyboard.getInstance().isKeyPressed(KeyEvent.VK_RIGHT) && super.x < 800)
		{
			super.x += speed;
		}			
        
		if (x < 0)
			x = 0;
		if (x + w > 800)
			x = 800 - w;
		
		if (y < 0 || y > 600 - h)
			SceneManager.changeScene(1);
        
	}
}