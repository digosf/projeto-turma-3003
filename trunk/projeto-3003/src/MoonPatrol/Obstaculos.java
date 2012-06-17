package MoonPatrol;


import game.GameObject;
import game.SoundClip;
import game.TimeXSpeedManager;

public class Obstaculos extends GameObject {
	
	public Obstaculos(float x, float y, int w, int h, String image) {
		super(x, y, w, h, image);

		// TODO Auto-generated constructor stub
	}
	
	public void Update()
	{
		this.x -= TimeXSpeedManager.speed;
	}
}
