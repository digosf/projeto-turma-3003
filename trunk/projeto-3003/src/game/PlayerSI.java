package game;

import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;

public class PlayerSI extends GameObject
{
	int speed;
	private static Point2D Position;
	
	public static Point2D getPosition() {
		return Position;
	}

	public static void setPosition(Point2D position) {
		Position = position;
	}

	// Construtor
	public PlayerSI(Point2D position, Point2D size, String img)
	{
		super((int)position.getX(), (int)position.getY(), (int)size.getX(), (int)size.getY(), img, null);
		this.speed = 5;
	}
	
	public void SpeedValue(int speedValue)
	{
		this.speed = speedValue;
	}
	
	// Update
	@Override
	public void Update()
	{
		Position = new Point2D.Float(super.x, super.y);
		// Atualiza a funcao de movimentar o personagem
		this.MoveCharacter();
		// Atualiza a funcao de limitar a movimentacao do personagem
		this.FixedLimits();
		
	}
	
	// Limita a movimentacao do personagem dentro da tela de jogo
	private void FixedLimits()
	{
		if (this.x < 0)
			this.x = 0;
		else if (this.x + this.w > 800)
			this.x = 800 - this.w;
	}

	private void MoveCharacter()
	{
			
		// Movimentar o persongem
		
		
		//Move a personagem para a esquerda
		if(Keyboard.getInstance().isKeyPressed(KeyEvent.VK_LEFT))
		{ this.x -= this.speed; }
		
		//Move a personagem para a direita
		if(Keyboard.getInstance().isKeyPressed(KeyEvent.VK_RIGHT))
		{ this.x += this.speed; }
		
		//Chama a funcao de atirar
		// *** > Conferir se KeyEvent.UK_SPACE acessa o botão teclado de espaço. < ***
		if(Keyboard.getInstance().isKeyPressed(KeyEvent.VK_SPACE))
		{}
		
	}
}
