package Pitfall;

import game.Game5;
import game.Game;
import game.SceneManager;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Point2D;

public class Level5PF extends Game5 {	
		BackgroundPF bg;
		PlayerPF player;
		JacarePF jacare;
		JacarePF jacare2;
		JacarePF jacare3;
		BuracoPF lago;
		EscorpiaoPF escorpiao;
		//Scene scene;
		SceneManagerPF sceneManager;
		
		public Level5PF()
		{
			
			list.add(new Rectangle(0, 390, 800, 10));
			
			player = new PlayerPF("/images/PF_Personagem.png", new Point2D.Double(10, 310), new Point(26, 80),
					new Point(0, 0), new Point(26, 80), new Point(2, 2), 0.05f, true); 
			bg = new BackgroundPF("/images/PF_background.png");
			escorpiao = new EscorpiaoPF("/images/PF_Escorpiao.png", new Point2D.Double(400, 520), new Point(37, 22), new Point(0, 0),
					 new Point(75, 45), new Point(3, 1), 0.01f, true);
			lago = new BuracoPF("/images/PF_lago.png", new Point2D.Double(200, 350), new Point(400, 45));
			
			jacare = new JacarePF("/images/PF_Jacare.png", new Point2D.Double(240, 345), new Point(50, 30), 100 + Game.rand.nextInt(200));
			jacare2 = new JacarePF("/images/PF_Jacare.png", new Point2D.Double(370, 345), new Point(50, 30), 100 + Game.rand.nextInt(200));
			jacare3 = new JacarePF("/images/PF_Jacare.png", new Point2D.Double(500, 345), new Point(50, 30), 100 + Game.rand.nextInt(200));
			
			list.add(new Rectangle((int)jacare.getRectangle().getX(),
					(int)jacare.getRectangle().getY() + 25,
					(int)jacare.getDimension().getX(),
					10));
			list.add(new Rectangle((int)jacare2.getRectangle().getX(),
					(int)jacare2.getRectangle().getY() + 25,
					(int)jacare2.getDimension().getX(),
					10));
			list.add(new Rectangle((int)jacare3.getRectangle().getX(),
					(int)jacare3.getRectangle().getY() + 25,
					(int)jacare3.getDimension().getX(),
					10));
			
			jacare.areaBoca = new Rectangle((int)list.get(list.size() - 3).getX(),
					(int)list.get(list.size() - 3).getY() - 10,
					(int)list.get(list.size() - 3).getWidth() - 25,
					(int)list.get(list.size() - 3).getHeight() + 10);
			jacare2.areaBoca = new Rectangle((int)list.get(list.size() - 2).getX(),
					(int)list.get(list.size() - 2).getY() - 10,
					(int)list.get(list.size() - 2).getWidth() - 25,
					(int)list.get(list.size() - 2).getHeight() + 10);
			jacare3.areaBoca = new Rectangle((int)list.get(list.size() - 1).getX(),
					(int)list.get(list.size() - 1).getY() - 10,
					(int)list.get(list.size() - 1).getWidth() - 25,
					(int)list.get(list.size() - 1).getHeight() + 10);
			
		}
		
		public void update()
		{
			
			player.Update(list, null, null);
			jacare.Update();
			jacare2.Update();
			jacare3.Update();
			lago.Update();
			escorpiao.Update(player);
			
			if (	(player.ColisaoRect(jacare.areaBoca) && jacare.bocaAberta == true) ||
					(player.ColisaoRect(jacare2.areaBoca) && jacare2.bocaAberta == true) ||
					(player.ColisaoRect(jacare3.areaBoca) && jacare3.bocaAberta == true))
			{
				SceneManager.changeScene(4);
			}
			
			if (player.ColisaoRect(new Rectangle((int)lago.getPosition().getX() + 20, (int)lago.getPosition().getY() + 35, (int)lago.getDimension().getX() - 40, 10)) || player.getRectangle().getMaxX() < 0)
			{
				SceneManager.changeScene(4);
			}
			if(player.getPosition().getX() > 799)
			{
				SceneManager.changeScene(0);
			}
			
		}
		
		public void draw(Graphics2D graphics){
			
			bg.draw(graphics);
			lago.draw(graphics);
			player.draw(graphics);
			jacare.draw(graphics);
			jacare2.draw(graphics);
			jacare3.draw(graphics);
			
			/*
			//AREA da colisao com o jacare
			graphics.fillRect(	(int)list.get(list.size() - 1).getX(),
					(int)list.get(list.size() - 1).getY(),
					(int)list.get(list.size() - 1).getWidth(),
					(int)list.get(list.size() - 1).getHeight());
			
			graphics.fillRect(	(int)list.get(list.size() - 2).getX(),
					(int)list.get(list.size() - 2).getY(),
					(int)list.get(list.size() - 2).getWidth(),
					(int)list.get(list.size() - 2).getHeight());
			
			graphics.fillRect(	(int)list.get(list.size() - 3).getX(),
					(int)list.get(list.size() - 3).getY(),
					(int)list.get(list.size() - 3).getWidth(),
					(int)list.get(list.size() - 3).getHeight());
			*/
			escorpiao.draw(graphics);
		}

	}