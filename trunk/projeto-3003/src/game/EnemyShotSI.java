package game;



public class EnemyShotSI extends Shot {
	
	
	public EnemyShotSI(float x, float y, int w, int h, String image, SoundClip sound )
	{
		super(x, y, w, h, image, sound); 
		speedY = 1;  //torna variavel speed igual ao valor do parametro dado pelo EnemyShotManagerSI
		
	}
	
	public void Update()
	{
		y += speedY; //modifica a posicao do tiro
	}

}