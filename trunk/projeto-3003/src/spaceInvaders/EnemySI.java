package spaceInvaders;

import game.GameObject;
import game.SoundClip;

public class EnemySI extends GameObject
{
	
	
public EnemySI(float x, float y, int w, int h, String image, SoundClip sound) {
		super(x, y, w, h, image, sound);
		
		
	}	

public void MoveEnemy(float x, float y)
{
	
	super.x += x;
	super.y += y;
}
	
}
