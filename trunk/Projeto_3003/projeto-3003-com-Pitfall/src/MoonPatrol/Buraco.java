package MoonPatrol;


import java.awt.Graphics2D;

import game.GameObject;
//import game.SoundClip;
import game.TimeXSpeedManager;

public class Buraco extends GameObject {
	
	public Buraco(float x, float y, int w, int h, String image) {
		super(x, y, w, h, image);

		// TODO Auto-generated constructor stub
	}
	
	public void Update()
	{
		this.x -= TimeXSpeedManager.speed;
	}
	
	@Override
	public void Draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		super.Draw(g2d);
	}
}
