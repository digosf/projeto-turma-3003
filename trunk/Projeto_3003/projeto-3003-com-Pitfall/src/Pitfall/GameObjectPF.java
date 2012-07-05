package Pitfall;

import java.applet.Applet;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.Point2D;
import java.net.URL;

public abstract class GameObjectPF
{
	
	private static final long serialVersionUID = 1L;
	protected Point2D position;
	protected Point dimension, sSize, sPos;
	private boolean animated;
	private Rectangle rectangle;
	private Image image;
	private float velocity;
	
	
	
	public float getVelocity() {
		return velocity;
	}
	public void setVelocity(float velocity) {
		this.velocity = velocity;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}
	public Point2D getPosition() {
		return position;
	}
	public void addPosition(Point2D pos)
	{
		setPosition(new Point2D.Double(this.getPosition().getX() + pos.getX(), this.getPosition().getY() + pos.getY()));
	}
	public void setPosition(Point2D position) {
		this.position = position;
	}
	public Point2D getDimension() {
		return dimension;
	}
	public void setDimension(Point dimension) {
		this.dimension = dimension;
	}
	
	public GameObjectPF(String imageFileName, Point2D position, Point size)
	{
		this.position  = position;
		this.dimension = size;
		this.animated = false;
		this.updateBoundingBox();
		this.LoadImage(imageFileName);
	}
	
	public GameObjectPF(String imageFileName, Point2D position, Point size, Point sPos, Point sSize)
	{
		this.position  = position;
		this.dimension = size;
		this.sPos = sPos;
		this.sSize = sSize;
		this.animated = true;
		this.updateBoundingBox();
		this.LoadImage(imageFileName);
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

	public Rectangle getRectangle()
	{
		return rectangle;
	}

	public void Update()
	{
		this.updateBoundingBox();
	}
	
	public void draw(Graphics2D g2d)
	{
		
		if(!animated)
			g2d.drawImage(image, (int)this.position.getX(), (int)this.position.getY(), 
					(int)this.dimension.getX(), (int)this.dimension.getY(), null);
		
		else
			g2d.drawImage(image,(int)this.position.getX(),(int)this.position.getY(),this.dimension.x + (int)this.position.getX(),
						this.dimension.y + (int)this.position.getY(), this.sPos.x, this.sPos.y, 
						this.sSize.x + this.sPos.x, this.sSize.y + this.sPos.y,  null);
		
		
		//g2d.drawRect((int)this.getRectangle().getX(), (int)this.getRectangle().getY(), (int)this.getRectangle().getWidth(), (int)this.getRectangle().getWidth());
	
		
	}
	
	public boolean Colisao(GameObjectPF obj)
	{
		if(obj.getRectangle().intersects(this.getRectangle()))
			return true;
		
		return false;
	}
	
	public boolean ColisaoRect(Rectangle rect)
	{
		if(rect.intersects(this.getRectangle()))
			return true;
		
		return false;
	}
	
	
	private void updateBoundingBox()
	{
		this.rectangle = new Rectangle((int)this.position.getX(), (int)this.position.getY(),
							   		   (int)this.dimension.getX(), (int)this.dimension.getY());		
	}
	
}
