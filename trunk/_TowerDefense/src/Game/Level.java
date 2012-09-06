package Game;

import java.awt.Graphics2D;

public abstract class Level extends Scene {

	public static GameImage imgCaminho, imgBandeira;
	public static boolean ganhou, perdeu, saiu;
	public static Enemy[] inimigos;
		
	public Level()
	{
		
	}
	
	@Override
	public void Update() 
	{
		if(inimigos != null)
		{
			for(Enemy inimigo : inimigos)
			{
				inimigo.Update();
			}
		}
	}

	@Override
	public void Draw(Graphics2D g2d)
	{
		imgCaminho.Draw(g2d);
		imgBandeira.Draw(g2d);
		if(inimigos != null)
		{
			for(Enemy inimigo : inimigos)
			{
				inimigo.Draw(g2d);
			}
		}
	}

}
