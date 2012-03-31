package spaceInvaders;

import game.GameObject;
import game.SoundClip;

public class EnemySI extends GameObject
{
	
	
public EnemySI(float x, float y, int w, int h, String image, String sound, int soundLoop) {
		super(x, y, w, h, image, sound, soundLoop);
		
		
	}	

public void MoveEnemy(float x, float y)
{
	
	super.x += x;
	super.y += y;
}
	
}
