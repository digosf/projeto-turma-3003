package Pitfall;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.util.LinkedList;
import game.Game5;
import game.SceneManager;

public class Level2PF extends Game5 {
	
	PlayerPF player;
	BackgroundPF bg;
	EscorpiaoPF escorpiao;
	LinkedList<TroncoPF> tronco = new LinkedList<TroncoPF>();
	//SceneManagerPF sceneManager;
	int contador = 0;
	
	public Level2PF()
	{
    	list.add(new Rectangle(0, 390, 800, 10));
    	player = new PlayerPF("/images/PF_Personagem.png", new Point2D.Double(10, 310), new Point(26, 80),
				new Point(0, 0), new Point(26, 80), new Point(2, 2), 0.05f, true); 
		 bg = new BackgroundPF("/images/PF_background.png");
		 escorpiao = new EscorpiaoPF("/images/PF_Escorpiao.png", new Point2D.Double(400, 520), new Point(37, 22), new Point(0, 0),
				 new Point(75, 45), new Point(3, 1), 0.01f, true);
		 tronco.add(new TroncoPF("/images/PF_Tronco.png", new Point2D.Double(800, 340), new Point(25, 50), 0.5f, true));
		 
	}
	
	public void update()
	{
		
		if(contador++ > 200)
		{

			 tronco.add(new TroncoPF("/images/PF_Tronco.png", new Point2D.Double(800, 340), new Point(25, 50), 0.5f, true));
			 contador = 0;
		}
		
		player.Update(list, null, null);
		escorpiao.Update(player);
		for(TroncoPF inst : tronco)
		{
			inst.Update();
			
			
			if(player.Colisao(inst))
			{
				if(player.getRectangle().getMaxX() < inst.getRectangle().getMaxX())
					player.addPosition(new Point(-2,0));
				else
					player.addPosition(new Point(1,0));
			}
		}
		
		
		
		if(player.getRectangle().getMaxX() < 0)
		{
			SceneManager.changeScene(4);
		}
		
		if(player.getPosition().getX() > 799)
		{
			SceneManager.changeScene(3);
		}
	}
	
	public void draw(Graphics2D graphics)
	{
		
		bg.draw(graphics);
		player.draw(graphics);
		escorpiao.draw(graphics);
		for(TroncoPF inst : tronco)
		{
			inst.draw(graphics);
		}
	}


}
