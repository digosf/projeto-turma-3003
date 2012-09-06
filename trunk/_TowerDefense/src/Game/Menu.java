package Game;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import Game.Keyboard.KeyState;

public class Menu extends Scene
{
	enum MenuScreens
	{
		MAIN,
		PLAY,
		INSTRUCTIONS,
		CREDITS
	}
	
	MenuScreens actualScreen;
	
	//Botões do MAIN
	Button btnPlay, btnCredits, btnInstructions, btnExit;
	
	public Menu()
	{
		background = new GameImage(0, 0);
		background.Load("/Images/menu.png");
		actualScreen = MenuScreens.MAIN;
		
		//Carrega os botões do MAIN
		btnPlay = new Button((int)(TowerDefense.screenWidth * 0.5f), 245, "/Images/btn_play.png", "/Images/btn_play2.png");
		btnPlay.isSelected = true;
		btnInstructions = new Button((int)(TowerDefense.screenWidth * 0.5f), 320, "/Images/btn_instructions.png", "/Images/btn_instructions2.png");
		btnCredits = new Button((int)(TowerDefense.screenWidth * 0.5f), 390, "/Images/btn_credits.png", "/Images/btn_credits2.png");
		btnExit = new Button((int)(TowerDefense.screenWidth * 0.5f), 450, "/Images/btn_exit.png", "/Images/btn_exit2.png");
	}
	
	@Override
	public void Update()
	{
		switch(actualScreen)
		{
		case MAIN:
			if(btnPlay.isMouseColliding())
			{
				btnPlay.isSelected = true;
				btnInstructions.isSelected = false;
				btnCredits.isSelected = false;
				btnExit.isSelected = false;
			}
			else if(btnInstructions.isMouseColliding())
			{
				btnPlay.isSelected = false;
				btnInstructions.isSelected = true;
				btnCredits.isSelected = false;
				btnExit.isSelected = false;
			}
			else if(btnCredits.isMouseColliding())
			{
				btnPlay.isSelected = false;
				btnInstructions.isSelected = false;
				btnCredits.isSelected = true;
				btnExit.isSelected = false;
			}
			else if(btnExit.isMouseColliding())
			{
				btnPlay.isSelected = false;
				btnInstructions.isSelected = false;
				btnCredits.isSelected = false;
				btnExit.isSelected = true;
			}
			
			if(Mouse.clicked)
			{
				if(btnPlay.isSelected)
				{
					SceneManager.ChangeScene();
				}
				else if(btnInstructions.isSelected)
				{
					
				}
				else if(btnCredits.isSelected)
				{
					
				}
				else if(btnExit.isSelected)
				{
					System.exit(0);
				}
			}
			if(Keyboard.GetKeyState(KeyEvent.VK_UP) == KeyState.PRESSED_ONCE)
			{
				if(btnPlay.isSelected)
				{
					btnPlay.isSelected = false;
					btnExit.isSelected = true;
				}
				else if(btnInstructions.isSelected)
				{
					btnInstructions.isSelected = false;
					btnPlay.isSelected = true;
				}
				else if(btnCredits.isSelected)
				{
					btnCredits.isSelected = false;
					btnInstructions.isSelected = true;
				}
				else if(btnExit.isSelected)
				{
					btnExit.isSelected = false;
					btnCredits.isSelected = true;
				}
			}
			else if(Keyboard.GetKeyState(KeyEvent.VK_DOWN) == KeyState.PRESSED_ONCE)
			{
				if(btnPlay.isSelected)
				{
					btnPlay.isSelected = false;
					btnInstructions.isSelected = true;
				}
				else if(btnInstructions.isSelected)
				{
					btnInstructions.isSelected = false;
					btnCredits.isSelected = true;
				}
				else if(btnCredits.isSelected)
				{
					btnCredits.isSelected = false;
					btnExit.isSelected = true;
				}
				else if(btnExit.isSelected)
				{
					btnExit.isSelected = false;
					btnPlay.isSelected = true;
				}
			}
			if(Keyboard.GetKeyState(KeyEvent.VK_ENTER) == KeyState.PRESSED_ONCE)
			{
				if(btnPlay.isSelected)
				{
					SceneManager.ChangeScene();
				}
				else if(btnInstructions.isSelected)
				{
					
				}
				else if(btnCredits.isSelected)
				{
					
				}
				else if(btnExit.isSelected)
				{
					System.exit(0);
				}
			}
			if(Keyboard.GetKeyState(KeyEvent.VK_ESCAPE) == KeyState.PRESSED_ONCE)
			{
				System.exit(0);
			}
			break;
		case PLAY:
			
			break;
		case INSTRUCTIONS:
			
			break;
		case CREDITS:
			
			break;
		}
	}

	@Override
	public void Draw(Graphics2D g2d) 
	{
		background.Draw(g2d);
		
		switch(actualScreen)
		{
		case MAIN:
			btnPlay.Draw(g2d);
			btnInstructions.Draw(g2d);
			btnCredits.Draw(g2d);
			btnExit.Draw(g2d);
			break;
		case PLAY:
			
			break;
		case INSTRUCTIONS:
			
			break;
		case CREDITS:
			
			break;
		}
	}
}
