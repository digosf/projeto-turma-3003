package RallyX;

import game.Game8;
import game.Keyboard;
import game.Scene;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class MenuRallyX extends SceneRallyX{

		BackgroundRallyX back = new BackgroundRallyX(0, 0, 800, 600, "/images/credits.png");
		@Override
		public void update()
		{
			if(Keyboard.getInstance().isKeyPressed(KeyEvent.VK_ENTER))
			{
				Game8.changeScene();
			}
		}

		@Override
		public void draw(Graphics2D g2d) {
			back.Draw(g2d);
		
		}


}
