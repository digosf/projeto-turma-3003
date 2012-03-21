package game;

import java.awt.Graphics2D;

public class SceneManager 
{
	private SceneManager(){}
	
	public static Scene scene;
	private static SCENE currentScene;
	
	
	public static void setup()
	{	
		scene = new Game3();
		currentScene = SCENE.GAME3_IF;
	}
	
	public static void changeScene(int openingScene)
	{	
		switch (currentScene)
		{
			case LOGO:
				scene = new Game3();
				currentScene = SCENE.GAME3_IF; 
				break;
				
			case OPENING:
				switch(openingScene)
				{
					case 0:
					{
						//scene = new Game1();
						currentScene = SCENE.GAME1_SPACE;
						
						break;
					}
					case 1:
					{
						//scene = new Game2();
						currentScene = SCENE.GAME2_GRADIUS;
						break;
					}
					
					default:
					{
						scene = new Game3();
						currentScene = SCENE.GAME3_IF;
						break;
					}
				}
				break;

			case GAME1_SPACE:
				switch(openingScene)
				{
					case 0:
					{
						scene = new Congrats();
						currentScene = SCENE.CONGRATS;
						
						break;
					}
					case 1:
					{
						scene = new GameOver();
						currentScene = SCENE.GAMEOVER;
						break;
					}
					
					default:
						break;
					
				}
				break;
				
			case GAME2_GRADIUS:
				switch(openingScene)
				{
					case 0:
					{
						scene = new Congrats();
						currentScene = SCENE.CONGRATS;
						
						break;
					}
					case 1:
					{
						scene = new GameOver();
						currentScene = SCENE.GAMEOVER;
						break;
					}
					
					default:
						break;
			
				}
				break;
		
			case GAME3_IF:
				switch(openingScene)
				{
					case 0:
					{
						scene = new Congrats();
						currentScene = SCENE.CONGRATS;
						
						break;
					}
					case 1:
					{
						scene = new GameOver();
						currentScene = SCENE.GAMEOVER;
						break;
					}
					
					default:
						break;
			
				}
				
				break;
				
			case GAMEOVER:
				scene = new Credits();
				currentScene = SCENE.CREDITS; 
				break;
								
			case CONGRATS:
				scene = new Credits();
				currentScene = SCENE.CREDITS; 
				break;			
								
			case CREDITS:
				scene = new Opening();
				currentScene = SCENE.OPENING; 
				break;		
				
			default:
				break;
		}    
	}
	

	public static void update()
	{
		scene.update();	
	}
	
	public static void draw(Graphics2D g)
	public static void draw(Graphics2D g2d)
	{
		scene.draw(g2d);	
	}	

	enum SCENE
	{
		LOGO,
		OPENING,
		GAME1_SPACE,
		GAME2_GRADIUS,
		GAME3_IF,
		GAMEOVER,
		CONGRATS,
		CREDITS,
	}
}
