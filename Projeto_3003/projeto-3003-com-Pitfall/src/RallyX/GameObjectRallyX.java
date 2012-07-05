package RallyX;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

public abstract class GameObjectRallyX {

	protected Image image;
	public float x, y;
	public int w, h;

	public GameObjectRallyX(float x, float y, int w, int h, String image)
	{
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;	
		
		LoadImage(image);
	}	
	
	protected URL getURL(String filename)
	{
		URL url = null;
		try
		{
			url = this.getClass().getResource(filename);
		
		}
		catch(Exception e){}
		return url;
	}
	
	public void LoadImage(String imageFilename)
	{
		Toolkit tk = Toolkit.getDefaultToolkit();
		image = tk.getImage(getURL(imageFilename));
	}
	
	public void Update()
	{
	}

	public void Draw(Graphics2D g2d)
	{
		g2d.drawImage(this.image, (int)x, (int)y, w, h, null);
	}
	
}




	
