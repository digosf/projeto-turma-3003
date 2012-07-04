package game;

import java.awt.Graphics2D;

import RallyX.InstructionsRallyX;
import RallyX.LevelRallyX;
import RallyX.MenuRallyX;
import RallyX.SceneRallyX;


public class Game8 extends Scene{

	
	public static SceneRallyX scene;
	private static SCENE currentScene = SCENE.INSTRUCTION;
	
	@Override
	public void update() {
		
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		
	}
	public SceneRallyX changeScene()
	{
			
			switch (currentScene)
			{
				case INSTRUCTION:
					scene = new InstructionsRallyX();
					currentScene = SCENE.PreGame;
					break;
				case PreGame:
					scene = new MenuRallyX();
					currentScene = SCENE.Level1;
					break;
				
				case Level1:
				{
					scene = new LevelRallyX();
					currentScene = SCENE.Level1;
					break;
				}	
			}
			return scene;
		
	
		
		
	}
	
	enum SCENE
	{
		
		INSTRUCTION,
		PreGame,
		Level1,
	}
}
