package game;

import java.awt.Graphics2D;

public class Logo extends Scene 
{
	
		private Background background;

		int i = 0;
		int max = 100;

		public Logo ()
		{
			background = new Background(0, 0, 800, 600, "/images/Logo.jpg", false, null, 0);
		}

		@Override
		public void update() {
			// TODO Auto-generated method stub
						if (i++ > max)
				SceneManager.changeScene(0);
		}

		@Override
		public void draw(Graphics2D g2d) {
			// TODO Auto-generated method stub
			background.Draw(g2d);

			g2d.drawString("Logo: " + i, 10, 10);
		}
	}



