package Pitfall;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Point2D;

public class JacarePF extends AnimatedSprite {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	boolean bocaAberta = true;
	float timer = 0;
	int contadorMax;
	int contador;
	public Rectangle areaBoca;
	
	public JacarePF(String img, Point2D position, Point size, int contador2){
		super(img, position, size, new Point(0,0), new Point(95, 65), new Point(1, 2), 10, true);
		this.contadorMax = contador2;
	}
	
	public void Update()
	{
		contador++;
		this.pressionado = true;
		
		if(contador > contadorMax)
		{
			if(bocaAberta)
				bocaAberta = false;
			else
				bocaAberta = true;
			
			
			if(this.animationType.y == 1)
				this.animationType.y = 2;
			else if(this.animationType.y == 2)
				this.animationType.y = 1;
			contador = 0;
		}
		
		super.Update();
	}
	
	public void draw(Graphics2D g2d)
	{
		super.draw(g2d);
		
		/*
		g2d.setColor(Color.RED);
		g2d.fillRect((int)areaBoca.getX(),
				(int)areaBoca.getY(),
				(int)areaBoca.getWidth(), 
				(int)areaBoca.getHeight());
		*/
	}
}
