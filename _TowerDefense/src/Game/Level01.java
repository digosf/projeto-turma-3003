package Game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import Game.Enemy.Colors;
import Game.Keyboard.KeyState;

public class Level01 extends Level
{
	public Level01()
	{
		imgCaminho = new GameImage(0, 0, TowerDefense.screenWidth, TowerDefense.screenHeight, Color.white);
		imgCaminho.Load("/Images/caminho.png");
		
		imgBandeira = new GameImage(0, 0, 800, 150, Color.white);
		imgBandeira.Load("/Images/bandeira.png");
		
		inimigos = new Enemy[]
				{
					new Enemy(300, Colors.BLUE),
					new Enemy(400, Colors.YELLOW),
					new Enemy(50, Colors.RED)
				};
	}
	
	public void Update()
	{
		if(Keyboard.GetKeyState(KeyEvent.VK_R) == KeyState.PRESSED_ONCE)
		{
			inimigos = new Enemy[]
					{
						new Enemy(300, Colors.BLUE),
						new Enemy(400, Colors.YELLOW),
						new Enemy(50, Colors.RED)
					};
		}
		if(Keyboard.GetKeyState(KeyEvent.VK_ESCAPE) == KeyState.PRESSED_ONCE)
		{
			saiu = true;
			SceneManager.ChangeScene();
		}
		
		super.Update();
	}
	public void Draw(Graphics2D g2d)
	{
		super.Draw(g2d);
		g2d.setColor(Color.black);
		g2d.drawString("Aperte R para recomeçar", 10, 10);
	}
}