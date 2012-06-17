package spaceInvaders;

import game.GameObject;

public class EnemySI extends GameObject
{
	
	
public EnemySI(float x, float y, int w, int h, String image) {
		super(x, y, w, h, image);
		
		
	}	

public void MoveEnemy(float x, float y)
{
	
	super.x += x;
	super.y += y;
}
	
}
