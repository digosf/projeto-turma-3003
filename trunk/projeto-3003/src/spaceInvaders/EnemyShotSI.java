package spaceInvaders;

import game.SoundClip;



public class EnemyShotSI extends Shot {
	
	
	public EnemyShotSI(float x, float y, int w, int h, String image, String sound, int soundLoop )
	{
		super(x, y, w, h, image, sound, soundLoop); 
		speedY = 3;  //torna variavel speed igual ao valor do parametro dado pelo EnemyShotManagerSI
		
	}
	
	public void Update()
	{
		y += speedY; //modifica a posicao do tiro
	}

}