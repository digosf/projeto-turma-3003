package game;

import java.awt.Graphics2D;

import RallyX.InstructionsRallyX;
import RallyX.LevelRallyX;
import RallyX.MenuRallyX;
import RallyX.SceneRallyX;


public class Game8 extends Scene{

	
	public static SceneRallyX sceneRx;
	public static SCENE currentScene = SCENE.INSTRUCTION;
	
	public Game8()
	{
		changeScene();
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
				case INSTRUCTION :
					sceneRx = new InstructionsRallyX();
					currentScene = SCENE.PreGame;
					break;
				case PreGame:
					sceneRx = new MenuRallyX();
					currentScene = SCENE.Level1;
					break;
				
				case Level1 :
				{
					sceneRx = new LevelRallyX();
					currentScene = SCENE.INSTRUCTION;
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
