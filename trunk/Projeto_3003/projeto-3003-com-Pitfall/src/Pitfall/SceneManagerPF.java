package Pitfall;

import game.Opening;
import game.Scene;

import java.awt.Graphics2D;



public class SceneManagerPF {

	private static SCENE currentScene = SCENE.INSTRUCTION;
	
	public static Scene ChangeScene(Scene scene)
	{
		switch (currentScene)
		{
			case INSTRUCTION:
			{
				scene = new Level1PF();
				currentScene = SCENE.Level1;
				break;
			}
			
			case Level1:
			{
				scene = new Level2PF();
				currentScene = SCENE.Level2;
				break;
			}	
			case Level2:
			{
				scene = new Level3PF();
				currentScene = SCENE.Level3;
				break;
			}	
			case Level3:
			{
				scene = new Level4PF();
				currentScene = SCENE.Level4;
				break;
			}	
			case Level4:
			{
				scene = new Level5PF();
				currentScene = SCENE.Level5;
				break;
			}	
			case Level5:
			{
				scene = new Opening();
				currentScene = SCENE.INSTRUCTION;
				break;
			}
		}
		return scene;
	}
	
	public static Scene Back(Scene scene)
	{
		switch (currentScene)
		{
			case INSTRUCTION:
				scene = new Opening();
			break;
			
			case Level1:
			{
				scene = new Level1PF();
				currentScene = SCENE.Level1;
				break;
			}	
			case Level2:
			{
				scene = new Level2PF();
				currentScene = SCENE.Level2;
				break;
			}	
			case Level3:
			{
				scene = new Level3PF();
				currentScene = SCENE.Level3;
				break;
			}
			case Level4:
			{
				scene = new Level4PF();
				currentScene = SCENE.Level4;
				break;
			}
			case Level5:
			{
				scene = new Level5PF();
				currentScene = SCENE.Level5;
				break;
			}
		}
		return scene;
	}
	
	public static void Draw(Graphics2D graphics)
	{
		
	}
	
	enum SCENE
	{
		
		INSTRUCTION,
		Level1,
		Level2,
		Level3,
		Level4,
		Level5,
	}
	
}
