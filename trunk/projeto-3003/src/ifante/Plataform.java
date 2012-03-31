package ifante;

import game.GameObject;
import game.SoundClip;
import game.TimeXSpeedManager;

public class Plataform extends GameObject {
	
	public Plataform(float x, float y, int w, int h, String image,
			String sound, int soundLoop) {
		super(x, y, w, h, image, sound, soundLoop);

		// TODO Auto-generated constructor stub
	}
	
	public void Update()
	{
		this.y -= TimeXSpeedManager.speed;
	}
}
