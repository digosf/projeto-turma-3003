package ifante;

import game.GameObject;
import game.Keyboard;
import game.SceneManager;
import game.SoundClip;

import java.awt.event.KeyEvent;

public class PlayerIfante extends GameObject{

	private int speed = 5;
	
	public float oldPosX;
	public float oldPosY;
	
	public PlayerIfante(float x, float y, int w, int h, String image,
			String sound, int soundLoop) {
		super(x, y, w, h, image, sound, soundLoop);
	}
	
	@Override
	public void Update()
	{
		//posicao antiga utilizada na colisao
		oldPosX = this.x;
		oldPosY = this.y;
		
		//para o jogador cair caso não esteja colidindo
		this.y += speed;
		
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
		
		//Caso ultrapasse as duas extremidades da vertical chamará GameOver
		if (y + h < 0 || y > 600 - h)
			SceneManager.changeScene(1);
        
	}
}