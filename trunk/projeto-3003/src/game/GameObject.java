package game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.sound.sampled.*;

public abstract class GameObject
{
	private AudioInputStream sound;
	protected Clip clip;
	protected Image image;
	public float x, y;
	public int w, h;
	public int soundLoop;

	public GameObject(float x, float y, int w, int h, String image, String sound, int soundLoop)
	{
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;	
		this.soundLoop = soundLoop;
		
		LoadImage(image);
		LoadSound(sound);
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
	
	public void LoadImage(String imageFilename)
	{
		Toolkit tk = Toolkit.getDefaultToolkit();
		image = tk.getImage(getURL(imageFilename));
	}
	
	public void LoadSound(String soundFilename)
	{
		try
		{
			sound = AudioSystem.getAudioInputStream(getURL(soundFilename));
			clip = AudioSystem.getClip();
			clip.open(sound);
			clip.loop(soundLoop);
		}
		catch (Exception e) {}
	}
	
	public void Update()
	{
		
	}

	public void Draw(Graphics2D g2d)
	{
		g2d.drawImage(this.image, (int)x, (int)y, w, h, null);
	}
}
