package Pitfall;

import game.Game;
import game.SceneManager;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Point2D;
import java.util.LinkedList;
//import java.util.*;
import game.Game5;
class Level3PF extends Game5
{
	BackgroundPF background;
	PlayerPF player;
	EscorpiaoPF escorpiao;
	BuracoPF buraco;
	
	int contador = 0;
	int contadorMax;
	boolean diminuirBuraco = false;
	float sizeBuraco = 275;
	final int sizeBuracoMax = 275;
	float velBuraco = 2f;
	
	LinkedList<Rectangle> escada = new LinkedList<Rectangle>();
	
	public Level3PF()
	{
		super();
		
		for(int x = 0; x < 15; x++)
		{
			escada.add(new Rectangle(10, 385 + (x*10) , 40, 5));
		}
		contadorMax = 25 + Game.random.nextInt(75);

		
		list.add(new Rectangle(0, 390, 800, 10));
		list.add(new Rectangle(0, 390, 400, 10));
		
		String image = "/images/PF_background.png";
		
		background = new BackgroundPF(image);
		
		escorpiao = new EscorpiaoPF("/images/PF_Escorpiao.png", new Point2D.Double(400, 520), new Point(37, 22), new Point(0, 0),
				 new Point(75, 45), new Point(3, 1), true);
		
		player = new PlayerPF("/images/PF_Personagem.png", new Point2D.Double(10, 310), new Point(26, 80),
				new Point(0, 0), new Point(26, 80), new Point(2, 2), true); 
		
		
		buraco = new BuracoPF("/images/PF_buraco.png", new Point2D.Double(sizeBuraco, 350), new Point(250, 45));
	
	}

    public void update()
    {
    	list.get(list.size() - 1).setSize((int)(400 - (this.sizeBuraco/2)), (int)list.get(list.size() - 1).getSize().getHeight());
    	list.get(list.size() - 2).setLocation((int)(400 + (this.sizeBuraco/2)), (int)list.get(list.size() - 2).getLocation().getY());
    	
    	if(diminuirBuraco)
    	{
    		if(sizeBuraco <= 0)
    		{
    			contador += 1;
    			sizeBuraco = 0;
    		}
    		else
    		{
    			sizeBuraco -= velBuraco;
    		}
    		
    		if(contador > contadorMax)
    		{
    			contador = 0;
    			diminuirBuraco = false;
    		}
    	}
    	
    	if(diminuirBuraco == false)
    	{
    		if(sizeBuraco >= sizeBuracoMax)
    			contador++;
    		else
    		{
    			sizeBuraco += velBuraco;
    		}
    		
    		if(contador > contadorMax)
    		{
    			contador = 0;
    			diminuirBuraco = true;
    		}
    	}
    	
    	
    	buraco.setDimension(new Point((int)this.sizeBuraco, (int)buraco.getDimension().getY()));
    	buraco.setPosition(new Point2D.Double(400 - (int)(this.sizeBuraco/2), buraco.getPosition().getY()));
    	
    	buraco.Update();
    	player.Update(list, null, escada);
    	escorpiao.Update(player);
    	
    	
    	if(player.getRectangle().getMaxX() < 0)
		{
    		SceneManager.changeScene(4);
		}
    	if(player.Colisao(escorpiao))
		{
    		SceneManager.changeScene(4);
		}
		
		if(player.getPosition().getX() > 799)
		{
			if(player.getRectangle().getMaxY() > 400)
				SceneManager.changeScene(4);
			else
				SceneManager.changeScene(3);
		}
    	
    	super.update();
    }

	public void draw(Graphics2D g2d)
    {
		
        background.draw(g2d);
     
        buraco.draw(g2d);
        escorpiao.draw(g2d);
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0, 350, 60, 40);
        
        g2d.setColor(Color.YELLOW);
		for(Rectangle inst : escada)
		{
			g2d.fillRect((int)inst.getX(), (int)inst.getY(), (int)inst.getWidth(),(int)inst.getHeight());
		}
        player.draw(g2d);
        
        g2d.setColor(new Color(189, 93, 38, 255));
        g2d.fillRect(0, 395, 800, 46);
        
        //g2d.setColor(Color.BLACK);
        //g2d.fillRect((int)buraco.getPosition().getX(), (int)buraco.getPosition().getY() + 25, (int)buraco.getSize().getWidth(), 10);
        
		super.draw(g2d);
    }
}
