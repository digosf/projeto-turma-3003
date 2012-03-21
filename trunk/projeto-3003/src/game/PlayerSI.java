package game;

import java.awt.event.KeyEvent;

public class PlayerSI extends GameObject
{
	int speed;
	
	// Construtor
	public PlayerSI(Point2D position, Point2D size)
	{
		super(position, size);	
	}
	
	public void SpeedValue(int speedValue)
	{
		this.speed = speedValue;
	}
	
	// Update
	@Override
	public void Update()
	{
		
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
		else if (this.x + this.w > 600)
			this.x = 600 - this.w;
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
