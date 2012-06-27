package Pitfall;

import game.Game5;
import game.SceneManager;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
//import java.util.*;

class Level4PF extends Game5
{
	BackgroundPF background;
	PlayerPF player;
	EscorpiaoPF escorpiao;
	CipoManager cipo;
	BuracoPF lago;
	

	
	
	public Level4PF()
	{
		super();
		
		list.add(new Rectangle(0, 390, 800, 10));
		String image = "/images/PF_background.png";
		background = new BackgroundPF(image);
		escorpiao = new EscorpiaoPF("/images/PF_Escorpiao.png", new Point2D.Double(400, 520), new Point(37, 22), new Point(0, 0),
				 new Point(75, 45), new Point(3, 1), true);
		player = new PlayerPF("/images/PF_Personagem.png", new Point2D.Double(10, 310), new Point(26, 80),
				new Point(0, 0), new Point(26, 80), new Point(2, 2), true); 
		cipo = new CipoManager(new Point(400, 173), 130);
		
		lago = new BuracoPF("/images/PF_lago.png", new Point2D.Double(275, 350), new Point(250, 45));
		

	
	}

    public void update()
    {
    	
    	
    	
    	cipo.update();
    	player.Update(list, cipo, null);
    	escorpiao.Update(player);

		lago.Update();
    	
    
	
		if (player.ColisaoRect(new Rectangle((int)lago.getPosition().getX() + 20, (int)lago.getPosition().getY() + 35, (int)lago.getDimension().getX() - 40, 10)) || player.getRectangle().getMaxX() < 0)
		{
			SceneManager.changeScene(4);
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

        lago.draw(g2d);
        player.draw(g2d);
        cipo.draw(g2d);
		super.draw(g2d);
    }
}
