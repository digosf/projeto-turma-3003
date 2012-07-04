package Hero;

import game.Scene;
import game.SceneManager;
import game.Time;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Point2D;

class Level_01 extends Scene
{
	float time;
	Player player;
	Mapa1 mapa;
	Painel painel;
	boolean desenhaRefen = false;
	int visualizacaoMapaLevel1 = 1;
	Inimigo_Aranha aranha;
	int temporizador = 0;
	boolean PlayerColidiuBomba = false;
	boolean playerColidiuInimigoAranha = false;
	boolean tirarVida = false;
	
	public Level_01()
	{		
		aranha = new Inimigo_Aranha(26, new Point(215, 205), new Point(40, 40), new Point(0, 0), new Point(40, 40), new Point(2, 0), 0.2f, true);
		painel = new Painel(400);
		mapa = new Mapa1(new Point(0,0), new Point(800, 450));
		player = new Player(2, new Point(120,50), new Point(50, 70), new Point(0, 0), new Point(50, 70), new Point(4,1), 0.3f, true, 3, 5);
	}

	public void update()
	{
		time += Time.getLoopTime();
		
		if(Painel.iniciarContagemPoints == false && PlayerColidiuBomba == false)
			player.Update();
		
		if(visualizacaoMapaLevel1 == 2 && playerColidiuInimigoAranha == false)
			aranha.Update();
		
		painel.Update();
		
		if(Player.qtdVida <= 0)
			SceneManager.changeScene(1);
		
		//CENA 1 DESCEDO PRA CENA 2
		if((int)player.getPosition().getY() >= 450 + player.getDimension().getY())
		{
			player.setPosition(new Point2D.Double(player.getPosition().getX(), 0 - player.getDimension().getY()));
			mapa.GenerateMap(1);
			visualizacaoMapaLevel1 = 2;
		}
		//CENA 2 SUBINDO PRA CENA 1
		if(visualizacaoMapaLevel1 == 2 && (int)player.getPosition().getY() <= 0 - player.getDimension().getY() - 1)
		{
			player.setPosition(new Point2D.Double(player.getPosition().getX(), 450));
			mapa.GenerateMap(0);
			visualizacaoMapaLevel1 = 1;
			desenhaRefen = false;
		}		
		
		if (playerColidiuInimigoAranha == false && visualizacaoMapaLevel1 == 2 && Collision.CheckCollision(new Rectangle((int)aranha.getPosition().getX(), (int)aranha.getPosition().getY(), (int)aranha.getDimension().getX(), (int)aranha.getDimension().getY()), new Rectangle((int)player.getPosition().getX(), (int)player.getPosition().getY(), (int)player.getDimension().getX(), (int)player.getDimension().getY())))
		{
			playerColidiuInimigoAranha = true;
			Player.qtdVida -=1;
		}		
		
		for (int i = 0; i < mapa.mapPiece.size(); i++)
		{
			if (Collision.CheckCollision(new Rectangle((int)player.getPosition().getX(), (int)player.getPosition().getY(), (int)player.getDimension().getX(), (int)player.getDimension().getY()),
										mapa.mapPiece.get(i), player.oldPosX, player.oldPosY, "top", 0))
			{
				player.setPosition(new Point2D.Double(player.getPosition().getX(), mapa.mapPiece.get(i).y - player.getDimension().getY()));
			}		
			if (Collision.CheckCollision(new Rectangle((int)player.getPosition().getX(), (int)player.getPosition().getY(), (int)player.getDimension().getX(), (int)player.getDimension().getY()),
					mapa.mapPiece.get(i), player.oldPosX, player.oldPosY, "left", 0))
			{
				player.setPosition(new Point2D.Double(mapa.mapPiece.get(i).x - player.getDimension().getX(), player.getPosition().getY()));
			}
			if (Collision.CheckCollision(new Rectangle((int)player.getPosition().getX(), (int)player.getPosition().getY(), (int)player.getDimension().getX(), (int)player.getDimension().getY()),
					mapa.mapPiece.get(i), player.oldPosX, player.oldPosY, "bottom", 0))
			{
				player.setPosition(new Point2D.Double(player.getPosition().getX(), mapa.mapPiece.get(i).y + mapa.mapPiece.get(i).height));
			}
			if (Collision.CheckCollision(new Rectangle((int)player.getPosition().getX(), (int)player.getPosition().getY(), (int)player.getDimension().getX(), (int)player.getDimension().getY()),
			mapa.mapPiece.get(i), player.oldPosX, player.oldPosY, "right", 0))
			{
				player.setPosition(new Point2D.Double(mapa.mapPiece.get(i).x + mapa.mapPiece.get(i).width, player.getPosition().getY()));
			}
		}
		
		for (int i = 0; i < mapa.wall.size(); i++)
		{
			if (Collision.CheckCollision(new Rectangle((int)player.getPosition().getX(), (int)player.getPosition().getY(), (int)player.getDimension().getX(), (int)player.getDimension().getY()),
										mapa.wall.get(i), player.oldPosX, player.oldPosY, "top", 0))
			{
				player.setPosition(new Point2D.Double(player.getPosition().getX(), mapa.wall.get(i).y - player.getDimension().getY()));
			}
			if (Collision.CheckCollision(new Rectangle((int)player.getPosition().getX(), (int)player.getPosition().getY(), (int)player.getDimension().getX(), (int)player.getDimension().getY()),
					mapa.wall.get(i), player.oldPosX, player.oldPosY, "left", 0))
			{
				player.setPosition(new Point2D.Double(mapa.wall.get(i).x - player.getDimension().getX(), player.getPosition().getY()));
			}
			if (Collision.CheckCollision(new Rectangle((int)player.getPosition().getX(), (int)player.getPosition().getY(), (int)player.getDimension().getX(), (int)player.getDimension().getY()),
					mapa.wall.get(i), player.oldPosX, player.oldPosY, "bottom", 0))
			{
				player.setPosition(new Point2D.Double(player.getPosition().getX(), mapa.wall.get(i).y + mapa.wall.get(i).height));
			}
			if (Collision.CheckCollision(new Rectangle((int)player.getPosition().getX(), (int)player.getPosition().getY(), (int)player.getDimension().getX(), (int)player.getDimension().getY()),
			mapa.wall.get(i), player.oldPosX, player.oldPosY, "right", 0))
			{
				player.setPosition(new Point2D.Double(mapa.wall.get(i).x + mapa.wall.get(i).width, player.getPosition().getY()));
			}
		}
		for (int i = 0; i < player.nade.size(); i++)
		{
			if (player.nade.get(i).explode == true)
			{
				for (int j = 0; j < mapa.wall.size(); j++)
				{
					if (Collision.CheckCollision(player.nade.get(i).explosionRect, mapa.wall.get(j)))
					{
						Player.score += 75;
						mapa.wall.remove(mapa.wall.get(j));
					}
				}
				if (PlayerColidiuBomba == false && Collision.CheckCollision(player.nade.get(i).explosionRect, new Rectangle((int)player.getPosition().getX(), (int)player.getPosition().getY(), (int)player.getDimension().getX(), (int)player.getDimension().getY())))
				{
					PlayerColidiuBomba = true;
					Player.qtdVida -= 1;
				}
				player.nade.remove(player.nade.get(i));
			}
		}
		
		for(int i = 0; i < Player.tiro.size(); i ++)
		{
			if(playerColidiuInimigoAranha == false && visualizacaoMapaLevel1 == 2 && Collision.CheckCollision(new Rectangle((int)aranha.getPosition().getX(), (int)aranha.getPosition().getY(), (int)aranha.getDimension().getX(), (int)aranha.getDimension().getY()), new Rectangle((int)Player.tiro.get(i).getPosition().getX(), (int)Player.tiro.get(i).getPosition().getY(), (int)Player.tiro.get(i).getDimension().getX(), (int)Player.tiro.get(i).getDimension().getY())))
			{
				playerColidiuInimigoAranha = true;
				Player.score += 50;
			}
		}
		
		if(PlayerColidiuBomba == true)
			temporizador ++;
		
		if(temporizador >= 120)
		{
			temporizador = 0;
			PlayerColidiuBomba = false;
		}
		
		if(visualizacaoMapaLevel1 == 2 & Collision.CheckCollision(new Rectangle((int)player.getPosition().getX(), (int)player.getPosition().getY(), (int)player.getDimension().getX(), (int)player.getDimension().getY()), new Rectangle(128, 247, 61, 50)))
		{
			Painel.iniciarContagemPoints = true;
			if(Painel.passarlevel == true)
			{
				Painel.iniciarContagemPoints = false;
				SceneManager.changeScene(2);
			}
		}	
	}
	
	public void draw(Graphics2D g2d)
	{
		switch(visualizacaoMapaLevel1)
		{
			case 1:
				g2d.drawImage(LoadImages.getImage(11), 0, 0, null);
				break;
			case 2:
				g2d.drawImage(LoadImages.getImage(14), 0, 0, null);
				
				if(playerColidiuInimigoAranha == false)
				{
					System.out.println("Desenhando");
					aranha.draw(g2d);
				}
				break;
		}
		player.draw(g2d);
		g2d.drawImage(LoadImages.getImage(1), 0, 450, null);
		mapa.draw(g2d);
		painel.draw(g2d);
	}
}