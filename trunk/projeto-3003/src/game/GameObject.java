package game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

public abstract class GameObject
{
	protected Image image;
	public float x, y;
	public int w, h;
	SoundClip sound;

	public GameObject(float x, float y, int w, int h, String image, SoundClip sound)
	{
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;	
		this.sound = sound;
		Load(image);
	}
	protected URL getURL(String filename)
	{
		URL url = null;
		try
		{
			url = this.getClass().getResource(filename);
		
		}
		catch(Exception e){}
		return url;
	}
	
	public void Load(String filename)
	{
		Toolkit tk = Toolkit.getDefaultToolkit();
		image = tk.getImage(getURL(filename));
	}
	
	public void Update()
	{
		
	}

	public void Draw(Graphics graphic)
	{
		graphic.drawImage(this.image, (int)x, (int)y, w, h, null);
	}
}
