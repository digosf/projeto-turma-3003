package game;

public class Plataform extends GameObject {
	
	public Plataform(float x, float y, int w, int h, String image,
			SoundClip sound) {
		super(x, y, w, h, image, sound);

		// TODO Auto-generated constructor stub
	}
	
	public void Update()
	{
		this.y -= TimeXSpeedManager.speed;
	}
}
