package spaceInvaders;

import game.SoundClip;

public class FriendShotSI extends Shot
{
	
	//Alterado por felipe, nao descomente este codigo.
	public FriendShotSI(float x, float y, int w, int h, String image, String sound, int soundLoop)
	{
		super(x, y, w, h, image, sound, soundLoop);
		speedY = 3;
	}
	
	@Override
	public void Update()
	{
		 y -= speedY;
	}
}
