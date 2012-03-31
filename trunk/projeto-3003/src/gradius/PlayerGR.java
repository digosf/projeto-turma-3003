package gradius;

import game.Background;
import game.GameObject;
import game.Keyboard;
import game.SceneManager;
import game.SoundClip;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class PlayerGR extends GameObject
{
	private final int speed = 2;
	private int minX, minY, maxX, maxY;
	public int life;
	
	public PlayerGR(float x, float y, int w, int h, String image, String sound, int soundLoop) 
	{
		super(x, y, w, h, image, sound, soundLoop);
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
		
		this.x -= 1;
		
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
		{
			SceneManager.changeScene(1);
		}
		
		
		
		Limits();
	}
	@Override
	public void Draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		for(int i = 0; i< life; i++)
			g2d.drawImage(image,0 + (w/2)*i, 600-h/2,w/2,h/2, null);
		
		super.Draw(g2d);
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