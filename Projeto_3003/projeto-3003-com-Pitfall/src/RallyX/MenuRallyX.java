package RallyX;

import game.Game8;
import game.Keyboard;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class MenuRallyX extends SceneRallyX{
		int count;
		BackgroundRallyX back = new BackgroundRallyX(0, 0, 800, 600, "/ImagesRallyX/tela_start2.png");
		
		@Override
		public void update()
		{
			count++;
			if(Keyboard.getInstance().isKeyPressed(KeyEvent.VK_ENTER) && count > 30)
			{
				Game8.changeScene();
			}
		}

		@Override
		public void draw(Graphics2D g2d) {
			back.Draw(g2d);
		
		}
}
