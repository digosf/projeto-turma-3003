package Pitfall;

import game.Game5;
import game.SceneManager;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.util.LinkedList;
//import java.util.*;

class Level1PF extends Game5
{
	BackgroundPF background;
	PlayerPF player;
	TroncoPF tronco;
	EscorpiaoPF escorpiao;
	

	
	
	public Level1PF()
	{
		super();
		list = new LinkedList<Rectangle>();
    	list.add(new Rectangle(000, 540, 800, 10));
		list.add(new Rectangle(0, 390, 800, 10));
		String image = "/images/PF_background.png";
		background = new BackgroundPF(image);
		escorpiao = new EscorpiaoPF("/images/PF_Escorpiao.png", new Point2D.Double(400, 520), new Point(37, 22), new Point(0, 0),
				 new Point(75, 45), new Point(3, 1), true);
		player = new PlayerPF("/images/PF_Personagem.png", new Point2D.Double(10, 310), new Point(26, 80),
				new Point(0, 0), new Point(26, 80), new Point(2, 2), true); 
		tronco = new TroncoPF("/images/PF_Tronco.png", new Point2D.Double(400, 340), new Point(25, 50), 0.5f, false);
		

	
	}

    public void update()
    {
    	
    	tronco.Update();
    	player.Update(list, null, null);
    	escorpiao.Update(player);
    	
    	
    	if(player.Colisao(tronco))
		{
			if(player.getRectangle().getMaxX() < tronco.getRectangle().getMaxX())
				player.addPosition(new Point(-2,0));
			else
				player.addPosition(new Point(1,0));
		}
		
	
    	
    	if(player.getRectangle().getMaxX() < 0)
		{
    		SceneManager.changeScene(4);
		}
		
		if(player.getPosition().getX() > 799)
		{
			SceneManager.changeScene(3);
		}
    	
    	super.update();
    }

	public void draw(Graphics2D g2d)
    {
		
        background.draw(g2d);
     
        escorpiao.draw(g2d);
        tronco.draw(g2d);
		
        player.draw(g2d);
		super.draw(g2d);
    }
}
