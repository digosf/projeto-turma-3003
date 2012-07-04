package Hero;

import java.applet.Applet;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.net.URL;

abstract class GameObject extends Applet
{
	
	private static final long serialVersionUID = 1L;
	private int indexImage;
	protected Point2D position;
	protected Point dimension, sSize, sPos;
	private boolean animated;
	public static Point2D velMapa = new Point2D.Double(0, 0);

	public GameObject(Point position, Point size)
	{
		this.position  = position;
		this.dimension = size;
		this.animated = false;
	}
	public GameObject(Point position, Point size, Point sPos, Point sSize)
	{
		this.position  = position;
		this.dimension = size;
		this.sPos = sPos;
		this.sSize = sSize;
		this.animated = true;	
	}
	public Image getImage() {
		return LoadImages.getImage(indexImage);
	}

	public void setImage(int index) {
		this.indexImage = index;
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

	protected URL getURL(String filename)
	{
		URL url = null;
		try
		{
			url = this.getClass().getResource(filename);
		}
		catch (Exception e) { }
		return url;
	}

	public Rectangle getRectangle()
	{
		return new Rectangle((int)this.getPosition().getX(), (int)this.getPosition().getY(), (int)this.getDimension().getX(), (int)this.getDimension().getX());
	}

	public void Update()
	{
		this.addPosition(GameObject.velMapa);
	}
	
	public void draw(Graphics2D g2d)
	{
		
		if(!animated)
		g2d.drawImage(LoadImages.getImage(indexImage), (int)this.position.getX(), (int)this.position.getY(), 
				(int)this.dimension.getX(), (int)this.dimension.getY(), this);
		
		else
		g2d.drawImage(LoadImages.getImage(indexImage),(int)this.position.getX(),(int)this.position.getY(),this.dimension.x + (int)this.position.getX(),
					this.dimension.y + (int)this.position.getY(), this.sPos.x, this.sPos.y, 
					this.sSize.x + this.sPos.x, this.sSize.y + this.sPos.y,  this);
	}
	
	public boolean Colisao(GameObject obj)
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
	
	/*
	private void updateBoundingBox()
	{
		this.rectangle = new Rectangle((int)this.position.getX(), (int)this.position.getY(),
							   		   (int)this.dimension.getX(), (int)this.dimension.getY());		
	}
	*/
}