package game;

public class Plataform extends GameObject {

	float speed;
	
	public Plataform(float x, float y, int w, int h, String image,
			SoundClip sound, float speed) {
		super(x, y, w, h, image, sound);
		
		this.speed = speed;
		// TODO Auto-generated constructor stub
	}
	
	public void Update()
	{
		this.y += this.speed;
	}
}
