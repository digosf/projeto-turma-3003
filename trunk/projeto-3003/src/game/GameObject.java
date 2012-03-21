package game;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public abstract class GameObject
{
	protected Image image;
	protected float x, y;
	protected int w, h;
	SoundClip sound;

	public GameObject(float x, float y, int w, int h, String image, SoundClip sound)
	{
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;	
		this.sound = sound;
		this.image = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource(image));
	}

	public void Draw(Graphics graphic)
	{
		graphic.drawImage(this.image, (int)x, (int)y, w, h, null);
	}
}
