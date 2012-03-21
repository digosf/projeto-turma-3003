package game;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;

public class Opening extends Scene {

	Background background;
	public Opening ()
	{
		background = new Background(0,0,800,600,"/images/Opening.png", null);
		
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
		if(Keyboard.getInstance().isKeyPressed(KeyEvent.VK_1))
		{
			SceneManager.changeScene(0);
		}
		
		if(Keyboard.getInstance().isKeyPressed(KeyEvent.VK_2))
		{
			SceneManager.changeScene(1);
		}
		
		if(Keyboard.getInstance().isKeyPressed(KeyEvent.VK_3))
		{
			SceneManager.changeScene(2);
		}
	}
		

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		
	}
	
}