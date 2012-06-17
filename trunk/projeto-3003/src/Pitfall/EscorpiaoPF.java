package Pitfall;


import java.awt.Point;
import java.awt.geom.Point2D;


public class EscorpiaoPF extends AnimatedSprite {

	
	
	private static final long serialVersionUID = 1L;

	public EscorpiaoPF(String image, Point2D pos, Point size, Point sPos,
			Point sSize, Point animationType, float timePerFrame, boolean input)
	{
		super(image, pos, size, sPos, sSize, animationType, timePerFrame, input);
		super.setVelocity(0.5f);
	}
	
	public void Update(PlayerPF player)
	{
		
		
		if(player.getPosition().getX() > position.getX())
		{
			position = new Point2D.Double(position.getX() + this.getVelocity(), position.getY());
			this.animationType.y = 2;
			pressionado = true;
		}
		else if(player.getPosition().getX() < position.getX())
		{
			position = new Point2D.Double(position.getX() - this.getVelocity(), position.getY());
			this.animationType.y = 1;
			pressionado = true;
		}
		super.Update();
	}
	
	public void Draw()
	{
		
	}
	
}
