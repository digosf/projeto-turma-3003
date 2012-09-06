package Game;

public final class SceneManager {
	
	enum Scenes
	{
		OPENING,
		MENU,
		LEVEL01,
		CONGRATS,
		GAMEOVER
	}
	
	private static Scenes actualScene;
	public static Scene scene;
	
	private SceneManager()
	{
		
	}
	
	public static void Setup()
	{
		actualScene = Scenes.MENU;
		scene = new Menu();
	}
	
	public static void ChangeScene()
	{
		switch(actualScene)
		{
			case OPENING:
				
				break;
			case MENU:
				actualScene = Scenes.LEVEL01;
				scene = new Level01();
				break;
			case LEVEL01:
				if(Level.saiu)
				{
					scene = new Menu();
					actualScene = Scenes.MENU;
					Level.saiu = false;
				}
				else
					scene = new Level01();
				break;
			case CONGRATS:
				
				break;
			case GAMEOVER:
				
				break;
		}
	}
}