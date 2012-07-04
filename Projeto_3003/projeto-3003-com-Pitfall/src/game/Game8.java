package game;

import java.awt.Graphics2D;

import RallyX.InstructionsRallyX;
import RallyX.LevelRallyX;
import RallyX.MenuRallyX;
import RallyX.SceneRallyX;


public class Game8 extends Scene{

	
	public static SceneRallyX sceneRx;
	private static SCENE currentScene = SCENE.Level1;
	
	public Game8()
	{
		sceneRx = new InstructionsRallyX();
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		sceneRx.update();
	}

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		sceneRx.draw(g2d);
	}
	public static SceneRallyX changeScene()
	{
			
			switch (currentScene)
			{
				case Level1:
					sceneRx = new InstructionsRallyX();
					currentScene = SCENE.INSTRUCTION;
					break;
				case INSTRUCTION:
					sceneRx = new MenuRallyX();
					currentScene = SCENE.PreGame;
					break;
				
				case PreGame:
				{
					sceneRx = new LevelRallyX();
					currentScene = SCENE.Level1;
					break;
					
				}	
			}
			return sceneRx;
	}
	
	enum SCENE
	{
		INSTRUCTION,
		PreGame,
		Level1,
	}
}
