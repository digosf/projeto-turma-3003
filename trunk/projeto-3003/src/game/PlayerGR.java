package game;

import java.awt.event.KeyEvent;

public class PlayerGR extends GameObject
{
	private final int speed = 2;
	private int minX, minY, maxX, maxY;
	public int life;
	
	public PlayerGR(float x, float y, int w, int h, String image, SoundClip sound) 
	{
		super(x, y, w, h, image, sound);
		life = 5;
	}
	
	public void ChangeBounds(int minX, int maxX, int minY, int maxY)
	{
		this.minX = minX;
		this.maxX = maxX;
		this.minY = minY;
		this.maxY = maxY;
	}
	
	@Override
	public void Update()
	{
		//Atirar
		if(Keyboard.getInstance().isKeyPressed(KeyEvent.VK_SPACE))
		{ 
			FriendlyShotManagerGR.Fire();
		}
		
		//if(Keyboard.getInstance().isKeyPressed(KeyEvent.VK_ENTER)) { FriendlyShotManager.Fire(this); }
		
		//Movimentação horizontal.
		if(Keyboard.getInstance().isKeyPressed(KeyEvent.VK_RIGHT)) { this.x += this.speed; }
		else if(Keyboard.getInstance().isKeyPressed(KeyEvent.VK_LEFT)) { this.x -= this.speed; }
		
		//Movimentação vertical.
		if(Keyboard.getInstance().isKeyPressed(KeyEvent.VK_UP)) { this.y -= this.speed; }
		else if(Keyboard.getInstance().isKeyPressed(KeyEvent.VK_DOWN)) { this.y += this.speed; }
		
		if (life <= 0)
			SceneManager.changeScene(1);
		
		
		
		Limits();
	}
	
	private void Limits()
	{
		if(this.x >= 800 - this.w) 
		{ 
			this.x = 800 - this.w;
		}
		if(this.x <= 0) 
		{ 
			this.x = 0; 
		}
		if(this.y <= 0) 
		{ 
			this.y = 0; 
		}
		if(this.y >= 600 - this.h) 
		{ 
			this.y = 600 - this.h;; 
		}
	}
}