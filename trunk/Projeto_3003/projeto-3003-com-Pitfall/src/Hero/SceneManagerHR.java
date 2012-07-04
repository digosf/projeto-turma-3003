package Hero;

import game.Scene;

import java.util.Random;

public class SceneManagerHR
{
    static public SCENE currentScene = SCENE.SCN_OPENING;
    static Random rand = new Random();

	static public Scene changeScene(int currentScene)
	{
		Scene scene = null;
		switch (currentScene)
		{	
			case 10:
				SceneManagerHR.currentScene = SCENE.SCN_LEVEL_01;
				scene = new Level_01();
				break;
			case 2:
				SceneManagerHR.currentScene = SCENE.SCN_LEVEL_02;
				scene = new Level_02();
				break;
			case 3:
				SceneManagerHR.currentScene = SCENE.SCN_LEVEL_03;
				scene = new Level_03();
				break;
			case 4:
				LoadImages.getInstance().Load();
				SceneManagerHR.currentScene = SCENE.SCN_OPENING;
				scene = new Opening();
				break;
		}
		return scene;
	}
	
	public static enum SCENE
	{
		SCN_OPENING,
		SCN_LEVEL_01,
		SCN_LEVEL_02,
		SCN_LEVEL_03,
	}
}