package MoonPatrol;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;

import game.GameObject;
import game.Keyboard;

public class PlayerMoonPatrol extends GameObject {
	
 int speed=5;
 int pulo;
//private static Point2D Position;
 
 
public PlayerMoonPatrol (Point2D position, Point2D size,String image)
 {
	super((int)position.getX(), (int)position.getY(), (int)size.getX(), (int)size.getY(), image);
		this.pulo = 90;
 }
 


public void SpeedValue(int speedValue)
{
	this.speed = speedValue;
}
public void FixedLimits() 
{// limitação do personagem
	if (this.x < 0)
		this.x = 0;
	else if (this.x + this.w > 800)
		this.x = 800 - this.w;
}


public void MoveCharacter()
{// movimentação do personagem 
	if (y < 500)
		y++;
	
	//Move a personagem para a direita
			if(Keyboard.getInstance().isKeyPressed(KeyEvent.VK_RIGHT))
			{ this.x += this.speed; }
			
			else if(Keyboard.getInstance().isKeyPressed(KeyEvent.VK_LEFT))
			{ this.x -= this.speed; }
			
	// personagem pula
			if (Keyboard.getInstance().isKeyPressed(KeyEvent.VK_UP) && y ==500)
			{ this.y -= this.pulo;}
				
			
}
public void Update ()
{
	// Atualiza a funcao de movimentar o personagem
			this.MoveCharacter();
			// Atualiza a funcao de limitar a movimentacao do personagem
			this.FixedLimits();
}
}



