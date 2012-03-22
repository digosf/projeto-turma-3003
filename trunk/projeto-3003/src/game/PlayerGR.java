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
		life = 15;
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
		if(Keyboard.getInstance().isKeyPressed(KeyEvent.VK_A))
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
		
		//Limits();
	}
	
	/*private void Limits()
	{
		if(this.x > this.maxX) { this.x = this.maxX; } else if(this.x < this.minX) { this.x = this.minX; }
		if(this.y > this.maxY) { this.y = this.maxY; } else if(this.x < this.minY) { this.x = this.minY; }
	}*/
}