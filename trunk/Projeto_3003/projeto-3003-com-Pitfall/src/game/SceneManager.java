package game;

import Pitfall.SceneManagerPF;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class SceneManager 
{
	private SceneManager(){}
	
	public static Scene scene;
	private static SCENE currentScene;
	
	
	public static void setup()
	{	
		scene = new Logo();
		currentScene = SCENE.LOGO;
	}
	
	public static void changeScene(int openingScene)
	{
		SoundClip.StopAll();
		switch (currentScene)
		{
			case LOGO:
				scene = new Opening();
				currentScene = SCENE.OPENING; 
				break;
				
			case OPENING:
				switch(openingScene)
				{
					case 0:
					{
						scene = new Game1();
						currentScene = SCENE.GAME1_SPACE;
						
						break;
					}
					case 1:
					{
						scene = new Game2();
						currentScene = SCENE.GAME2_GRADIUS;
						break;
					}
					case 2:
					{
						scene = new Game3();
						currentScene = SCENE.GAME3_IF;
						break;
					}
					
					case 3:
					{
						scene = new Game4();
						currentScene = SCENE.GAME4_MP;
						break;
					}
					case 4:
					{
						scene = SceneManagerPF.ChangeScene(scene);
						currentScene = SCENE.GAME5_PF;
						break;
					}
				}
				break;

			case GAME1_SPACE:
				switch(openingScene)
				{
					case 0:
					{
						scene.StopBGSound();
						scene = new Congrats();
						currentScene = SCENE.CONGRATS;
						
						break;
					}
					case 1:
					{
						scene.StopBGSound();
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
						scene.StopBGSound();
						scene = new Congrats();
						currentScene = SCENE.CONGRATS;
						
						break;
					}
					case 1:
					{
						scene.StopBGSound();
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
						scene.StopBGSound();
						scene = new Congrats();
						currentScene = SCENE.CONGRATS;
						
						break;
					}
					case 1:
					{
						scene.StopBGSound();
						scene = new GameOver();
						currentScene = SCENE.GAMEOVER;
						break;
					}
					
					default:
						break;
			
				}
				
			case GAME4_MP:
				switch(openingScene)
				{
					case 0:
					{
						scene.StopBGSound();
						scene = new Congrats();
						currentScene = SCENE.CONGRATS;
						
						break;
					}
					case 1:
					{
						scene.StopBGSound();
						scene = new GameOver();
						currentScene = SCENE.GAMEOVER;
						break;
					}
					
					default:
						break;
			
				}
				break;
				
				
			case GAME5_PF:
				switch(openingScene)
				{
					case 0:
					{
						scene.StopBGSound();
						scene = new Congrats();
						currentScene = SCENE.CONGRATS;
						
						break;
					}
					case 1:
					{
						scene.StopBGSound();
						scene = new GameOver();
						currentScene = SCENE.GAMEOVER;
						break;
					}
					case 3:
					{
						scene.StopBGSound();
						scene = SceneManagerPF.ChangeScene(scene);
						break;
					}
					case 4:
					{
						scene.StopBGSound();
						scene = SceneManagerPF.Back(scene);
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
		
		if(Keyboard.getInstance().isKeyPressed(KeyEvent.VK_ESCAPE))
		{
			scene = new Opening();
			currentScene = SCENE.OPENING;
			SoundClip.StopAll();
		}
		
	}
	
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
		GAME4_MP,
		GAME5_PF,
		GAMEOVER,
		CONGRATS,
		CREDITS,
	}
}
