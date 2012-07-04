package Hero;

import game.Scene;
import game.SceneManager;
import game.Time;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Point2D;

class Level_03 extends Scene
{
	float time;
	Player player;
	Mapa3 mapa3;
	Painel painel;
	boolean desenhaRefen = false;
	int visualizacaoMapaLevel3 = 1;
	Inimigo_Aranha aranha;
	Inimigo_Aranha aranha2;
	Inimigo_Barata barata;
	Inimigo_Barata barata2;
	Inimigo_Barata barata3;
	Inimigo_Morcego morcego;
	Inimigo_Aranha aranha3;
	Lampada lampada;
	boolean tirarVida = false;
	int temporizador = 0;
	
	boolean PlayerColidiuBomba = false;
	
	boolean playerColidiuInimigoAranha = false;
	boolean playerColidiuInimigoBarata = false;
	boolean playerColidiuInimigoAranha02 = false;
	boolean playerColidiuInimigoMorcego = false;
	boolean playerColidiuInimigoAranha03 = false;
	boolean playerColidiuInimigoBarata02 = false;
	boolean playerColidiuInimigoBarata03= false;
	
	public Level_03()
	{
		aranha = new Inimigo_Aranha(26, new Point(232, 185), new Point(40, 40), new Point(0, 0), new Point(40, 40), new Point(2, 0), 0.2f, true);
		barata = new Inimigo_Barata(27, new Point(350, 300), new Point(40, 30), new Point(0, 0), new Point(40, 30), new Point(2, 0), 0.2f, true);
		aranha2 = new Inimigo_Aranha(26, new Point(206, 246), new Point(40, 40), new Point(0, 0), new Point(40, 40), new Point(2, 0), 0.2f, true);
		morcego = new Inimigo_Morcego(28, new Point(577, 220), new Point(40, 20), new Point(0, 0), new Point(40, 20), new Point(2, 0), 0.2f, true);
		aranha3 = new Inimigo_Aranha(26, new Point(194, 314), new Point(40, 40), new Point(0, 0), new Point(40, 40), new Point(2, 0), 0.2f, true);
		lampada = new Lampada(29, new Point(617, 80), new Point(25, 25), new Point(0, 0), new Point(25, 25), new Point(2, 0), 0.2f, true);	
		barata2 = new Inimigo_Barata(27, new Point(259, 215), new Point(40, 40), new Point(0, 0), new Point(40, 40), new Point(2, 0), 0.2f, true);
		barata3 = new Inimigo_Barata(27, new Point(250, 215), new Point(40, 30), new Point(0, 0), new Point(40, 30), new Point(2, 0), 0.2f, true);
		
		painel = new Painel(400);
		mapa3 = new Mapa3(new Point(0,0), new Point(800, 450));
		player = new Player(2, new Point(150,50), new Point(50, 70), new Point(0, 0), new Point(50, 70), new Point(4,1), 0.3f, true, 3, 5);
	}

	public void update()
	{
		if(Player.qtdVida <= 0)
		{
			Player.score = 0;
			SceneManager.changeScene(0);
		}
		
		if(Painel.iniciarContagemPoints == false && PlayerColidiuBomba == false)
			player.Update();
		
		lampada.Update();
		
		if(visualizacaoMapaLevel3 == 2 && playerColidiuInimigoAranha == false)
			aranha.Update();
		if(visualizacaoMapaLevel3 == 2 && playerColidiuInimigoBarata == false)
			barata.Update();
		if(visualizacaoMapaLevel3 == 3 && playerColidiuInimigoAranha02 == false)
			aranha2.Update();
		if(visualizacaoMapaLevel3 == 4 && playerColidiuInimigoMorcego == false)
			morcego.Update();
		if(visualizacaoMapaLevel3 == 4 && playerColidiuInimigoAranha03 == false)
			aranha3.Update();
		if(visualizacaoMapaLevel3 == 5 && playerColidiuInimigoBarata02 == false)
			barata2.Update();
		if(visualizacaoMapaLevel3 == 6 && playerColidiuInimigoBarata03 == false)
			barata3.Update();
		
		time += Time.getLoopTime();

		painel.Update();
	
		if (playerColidiuInimigoAranha == false && visualizacaoMapaLevel3 == 2 && Collision.CheckCollision(new Rectangle((int)aranha.getPosition().getX(), (int)aranha.getPosition().getY(), (int)aranha.getDimension().getX(), (int)aranha.getDimension().getY()), new Rectangle((int)player.getPosition().getX(), (int)player.getPosition().getY(), (int)player.getDimension().getX(), (int)player.getDimension().getY())))
		{
			Player.qtdVida -=1;
			playerColidiuInimigoAranha = true;
		}
		if (playerColidiuInimigoBarata == false && visualizacaoMapaLevel3 == 2 && Collision.CheckCollision(new Rectangle((int)barata.getPosition().getX(), (int)barata.getPosition().getY(), (int)barata.getDimension().getX(), (int)barata.getDimension().getY()), new Rectangle((int)player.getPosition().getX(), (int)player.getPosition().getY(), (int)player.getDimension().getX(), (int)player.getDimension().getY())))
		{
			Player.qtdVida -=1;
			playerColidiuInimigoBarata = true;
		}
		if (playerColidiuInimigoAranha02 == false && visualizacaoMapaLevel3 == 3 && Collision.CheckCollision(new Rectangle((int)aranha2.getPosition().getX(), (int)aranha2.getPosition().getY(), (int)aranha2.getDimension().getX(), (int)aranha2.getDimension().getY()), new Rectangle((int)player.getPosition().getX(), (int)player.getPosition().getY(), (int)player.getDimension().getX(), (int)player.getDimension().getY())))
		{
			Player.qtdVida -=1;
			playerColidiuInimigoAranha02 = true;
		}
		if (playerColidiuInimigoMorcego == false && visualizacaoMapaLevel3 == 4 && Collision.CheckCollision(new Rectangle((int)morcego.getPosition().getX(), (int)morcego.getPosition().getY(), (int)morcego.getDimension().getX(), (int)morcego.getDimension().getY()), new Rectangle((int)player.getPosition().getX(), (int)player.getPosition().getY(), (int)player.getDimension().getX(), (int)player.getDimension().getY())))
		{
			Player.qtdVida -=1;
			playerColidiuInimigoMorcego = true;
		}
		if (playerColidiuInimigoAranha03 == false && visualizacaoMapaLevel3 == 4 && Collision.CheckCollision(new Rectangle((int)aranha3.getPosition().getX(), (int)aranha3.getPosition().getY(), (int)aranha3.getDimension().getX(), (int)aranha3.getDimension().getY()), new Rectangle((int)player.getPosition().getX(), (int)player.getPosition().getY(), (int)player.getDimension().getX(), (int)player.getDimension().getY())))
		{
			Player.qtdVida -=1;
			playerColidiuInimigoAranha03 = true;
		}
		if (playerColidiuInimigoBarata02 == false && visualizacaoMapaLevel3 == 5 && Collision.CheckCollision(new Rectangle((int)barata2.getPosition().getX(), (int)barata2.getPosition().getY(), (int)barata2.getDimension().getX(), (int)barata2.getDimension().getY()), new Rectangle((int)player.getPosition().getX(), (int)player.getPosition().getY(), (int)player.getDimension().getX(), (int)player.getDimension().getY())))
		{
			Player.qtdVida -=1;
			playerColidiuInimigoBarata02 = true;
		}
		if (playerColidiuInimigoBarata03 == false && visualizacaoMapaLevel3 == 6 && Collision.CheckCollision(new Rectangle((int)barata3.getPosition().getX(), (int)barata3.getPosition().getY(), (int)barata3.getDimension().getX(), (int)barata3.getDimension().getY()), new Rectangle((int)player.getPosition().getX(), (int)player.getPosition().getY(), (int)player.getDimension().getX(), (int)player.getDimension().getY())))
		{
			Player.qtdVida -=1;
			playerColidiuInimigoBarata03 = true;
		}
		
		System.out.println("" + visualizacaoMapaLevel3);
		
		//CENA 1 DESCENDO PRA CENA 2
		if(visualizacaoMapaLevel3 == 1 && (int)player.getPosition().getY() >= 450 + player.getDimension().getY())
		{
			player.setPosition(new Point2D.Double(player.getPosition().getX(), 0 - player.getDimension().getY()));
			mapa3.GenerateMap(1);
			visualizacaoMapaLevel3 = 2;
		}
		//CENA 2 SUBINDO PRA CENA 1
		if(visualizacaoMapaLevel3 == 2 && (int)player.getPosition().getY() <= 0 - player.getDimension().getY() - 1)
		{
			visualizacaoMapaLevel3 = 1;
			player.setPosition(new Point2D.Double(player.getPosition().getX(), 450));
			mapa3.GenerateMap(0);
		}
		//CENA 2 DESCENDO PRA CENA 3
		
		if((int)player.getPosition().getY() >= 450 + player.getDimension().getY() && visualizacaoMapaLevel3 == 2)
		{
			visualizacaoMapaLevel3 = 3;
			player.setPosition(new Point2D.Double(player.getPosition().getX(), 0 - player.getDimension().getY()));
			mapa3.GenerateMap(2);
		}
		//CENA 3 SUBINDO PRA CENA 2
		if(visualizacaoMapaLevel3 == 3 && (int)player.getPosition().getY() <= 0 - player.getDimension().getY() - 1)
		{
			player.setPosition(new Point2D.Double(player.getPosition().getX(), 450));
			mapa3.GenerateMap(1);
			visualizacaoMapaLevel3 = 2;
		}
		//CENA 3 DESCENDO PRA CENA 4
		if(visualizacaoMapaLevel3 == 3 && (int)player.getPosition().getY() >= 450 + player.getDimension().getY())
		{
			player.setPosition(new Point2D.Double(player.getPosition().getX(), 0 - player.getDimension().getY()));
			mapa3.GenerateMap(3);
			visualizacaoMapaLevel3 = 4;
		}
		//CENA 4 SUBINDO PRA CENA 3
		if(visualizacaoMapaLevel3 == 4 && (int)player.getPosition().getY() <= 0 - player.getDimension().getY() - 1)
		{
			player.setPosition(new Point2D.Double(player.getPosition().getX(), 450));
			mapa3.GenerateMap(2);
			visualizacaoMapaLevel3 = 3;
		}
		//CENA 4 DESCENDO PRA CENA 5
		if(visualizacaoMapaLevel3 == 4 && (int)player.getPosition().getY() >= 450 + player.getDimension().getY())
		{
			player.setPosition(new Point2D.Double(player.getPosition().getX(), 0 - player.getDimension().getY()));
			mapa3.GenerateMap(4);
			visualizacaoMapaLevel3 = 5;
		}
		//CENA 5 SUBINDO PRA CENA 4
		if(visualizacaoMapaLevel3 == 5 && (int)player.getPosition().getY() <= 0 - player.getDimension().getY() - 1)
		{
			player.setPosition(new Point2D.Double(player.getPosition().getX(), 450));
			mapa3.GenerateMap(3);
			visualizacaoMapaLevel3 = 3;
		}
		//CENA 5 DESCENDO PRA CENA 6
		if(visualizacaoMapaLevel3 == 5 && (int)player.getPosition().getY() >= 450 + player.getDimension().getY())
		{
			player.setPosition(new Point2D.Double(player.getPosition().getX(), 0 - player.getDimension().getY()));
			mapa3.GenerateMap(5);
			visualizacaoMapaLevel3 = 6;
		}		
		
		//CENA 6 SUBINDO PARA CENA 5
		if(visualizacaoMapaLevel3 == 6 && (int)player.getPosition().getY() <= 0 - player.getDimension().getY() - 1)
		{
			player.setPosition(new Point2D.Double(player.getPosition().getX(), 0 - player.getDimension().getY()));
			mapa3.GenerateMap(2);
			visualizacaoMapaLevel3 = 5;
		}
		
		
		for (int i = 0; i < mapa3.mapPiece.size(); i++)
		{
			if (Collision.CheckCollision(new Rectangle((int)player.getPosition().getX(), (int)player.getPosition().getY(), (int)player.getDimension().getX(), (int)player.getDimension().getY()),
					mapa3.mapPiece.get(i), player.oldPosX, player.oldPosY, "top", 0))
			{
				player.setPosition(new Point2D.Double(player.getPosition().getX(), mapa3.mapPiece.get(i).y - player.getDimension().getY()));
			}
			
			
			if (Collision.CheckCollision(new Rectangle((int)player.getPosition().getX(), (int)player.getPosition().getY(), (int)player.getDimension().getX(), (int)player.getDimension().getY()),
					mapa3.mapPiece.get(i), player.oldPosX, player.oldPosY, "left", 0))
			{
				player.setPosition(new Point2D.Double(mapa3.mapPiece.get(i).x - player.getDimension().getX(), player.getPosition().getY()));
			}
			
			
			if (Collision.CheckCollision(new Rectangle((int)player.getPosition().getX(), (int)player.getPosition().getY(), (int)player.getDimension().getX(), (int)player.getDimension().getY()),
					mapa3.mapPiece.get(i), player.oldPosX, player.oldPosY, "bottom", 0))
			{
				player.setPosition(new Point2D.Double(player.getPosition().getX(), mapa3.mapPiece.get(i).y + mapa3.mapPiece.get(i).height));
			}
			
			
			if (Collision.CheckCollision(new Rectangle((int)player.getPosition().getX(), (int)player.getPosition().getY(), (int)player.getDimension().getX(), (int)player.getDimension().getY()),
					mapa3.mapPiece.get(i), player.oldPosX, player.oldPosY, "right", 0))
			{
				player.setPosition(new Point2D.Double(mapa3.mapPiece.get(i).x + mapa3.mapPiece.get(i).width, player.getPosition().getY()));
			}
		}
		
		for (int i = 0; i < mapa3.wall.size(); i++)
		{
			if (Collision.CheckCollision(new Rectangle((int)player.getPosition().getX(), (int)player.getPosition().getY(), (int)player.getDimension().getX(), (int)player.getDimension().getY()),
					mapa3.wall.get(i), player.oldPosX, player.oldPosY, "top", 0))
			{
				player.setPosition(new Point2D.Double(player.getPosition().getX(), mapa3.wall.get(i).y - player.getDimension().getY()));
			}
			
			if (Collision.CheckCollision(new Rectangle((int)player.getPosition().getX(), (int)player.getPosition().getY(), (int)player.getDimension().getX(), (int)player.getDimension().getY()),
					mapa3.wall.get(i), player.oldPosX, player.oldPosY, "left", 0))
			{
				player.setPosition(new Point2D.Double(mapa3.wall.get(i).x - player.getDimension().getX(), player.getPosition().getY()));
			}
			
			if (Collision.CheckCollision(new Rectangle((int)player.getPosition().getX(), (int)player.getPosition().getY(), (int)player.getDimension().getX(), (int)player.getDimension().getY()),
					mapa3.wall.get(i), player.oldPosX, player.oldPosY, "bottom", 0))
			{
				player.setPosition(new Point2D.Double(player.getPosition().getX(), mapa3.wall.get(i).y + mapa3.wall.get(i).height));
			}
			
			if (Collision.CheckCollision(new Rectangle((int)player.getPosition().getX(), (int)player.getPosition().getY(), (int)player.getDimension().getX(), (int)player.getDimension().getY()),
					mapa3.wall.get(i), player.oldPosX, player.oldPosY, "right", 0))
			{
				player.setPosition(new Point2D.Double(mapa3.wall.get(i).x + mapa3.wall.get(i).width, player.getPosition().getY()));
			}
		}
		for (int i = 0; i < player.nade.size(); i++)
		{
			if (player.nade.get(i).explode == true)
			{
				for (int j = 0; j < mapa3.wall.size(); j++)
				{
					if (Collision.CheckCollision(player.nade.get(i).explosionRect, mapa3.wall.get(j)))
					{
						Player.score += 75;
						mapa3.wall.remove(mapa3.wall.get(j));
					}
					
					if (PlayerColidiuBomba == false && Collision.CheckCollision(player.nade.get(i).explosionRect, new Rectangle((int)player.getPosition().getX(), (int)player.getPosition().getY(), (int)player.getDimension().getX(), (int)player.getDimension().getY())))
					{
						PlayerColidiuBomba = true;
						Player.qtdVida -= 1;
					}
				}
				player.nade.remove(player.nade.get(i));
			}
		}
		
		for(int i = 0; i < Player.tiro.size(); i ++)
		{
			if(playerColidiuInimigoAranha == false && visualizacaoMapaLevel3 == 2 && Collision.CheckCollision(new Rectangle((int)aranha.getPosition().getX(), (int)aranha.getPosition().getY(), (int)aranha.getDimension().getX(), (int)aranha.getDimension().getY()), new Rectangle((int)Player.tiro.get(i).getPosition().getX(), (int)Player.tiro.get(i).getPosition().getY(), (int)Player.tiro.get(i).getDimension().getX(), (int)Player.tiro.get(i).getDimension().getY())))
			{
				playerColidiuInimigoAranha = true;
				Player.score += 50;
			}
			if(playerColidiuInimigoBarata == false && visualizacaoMapaLevel3 == 2 && Collision.CheckCollision(new Rectangle((int)barata.getPosition().getX(), (int)barata.getPosition().getY(), (int)barata.getDimension().getX(), (int)barata.getDimension().getY()), new Rectangle((int)Player.tiro.get(i).getPosition().getX(), (int)Player.tiro.get(i).getPosition().getY(), (int)Player.tiro.get(i).getDimension().getX(), (int)Player.tiro.get(i).getDimension().getY())))
			{
				playerColidiuInimigoBarata = true;
				Player.score += 50;
			}
			if(playerColidiuInimigoAranha02 == false && visualizacaoMapaLevel3 == 3 && Collision.CheckCollision(new Rectangle((int)aranha2.getPosition().getX(), (int)aranha2.getPosition().getY(), (int)aranha2.getDimension().getX(), (int)aranha2.getDimension().getY()), new Rectangle((int)Player.tiro.get(i).getPosition().getX(), (int)Player.tiro.get(i).getPosition().getY(), (int)Player.tiro.get(i).getDimension().getX(), (int)Player.tiro.get(i).getDimension().getY())))
			{
				playerColidiuInimigoAranha02 = true;
				Player.score += 50;
			}
			if(playerColidiuInimigoMorcego == false && visualizacaoMapaLevel3 == 4 && Collision.CheckCollision(new Rectangle((int)morcego.getPosition().getX(), (int)morcego.getPosition().getY(), (int)morcego.getDimension().getX(), (int)morcego.getDimension().getY()), new Rectangle((int)Player.tiro.get(i).getPosition().getX(), (int)Player.tiro.get(i).getPosition().getY(), (int)Player.tiro.get(i).getDimension().getX(), (int)Player.tiro.get(i).getDimension().getY())))
			{
				playerColidiuInimigoMorcego = true;
				Player.score += 50;
			}
			if(playerColidiuInimigoAranha03 == false && visualizacaoMapaLevel3 == 4 && Collision.CheckCollision(new Rectangle((int)aranha3.getPosition().getX(), (int)aranha3.getPosition().getY(), (int)aranha3.getDimension().getX(), (int)aranha3.getDimension().getY()), new Rectangle((int)Player.tiro.get(i).getPosition().getX(), (int)Player.tiro.get(i).getPosition().getY(), (int)Player.tiro.get(i).getDimension().getX(), (int)Player.tiro.get(i).getDimension().getY())))
			{
				playerColidiuInimigoAranha03 = true;
				Player.score += 50;
			}
			if(playerColidiuInimigoBarata02 == false && visualizacaoMapaLevel3 == 5 && Collision.CheckCollision(new Rectangle((int)barata2.getPosition().getX(), (int)barata2.getPosition().getY(), (int)barata2.getDimension().getX(), (int)barata2.getDimension().getY()), new Rectangle((int)Player.tiro.get(i).getPosition().getX(), (int)Player.tiro.get(i).getPosition().getY(), (int)Player.tiro.get(i).getDimension().getX(), (int)Player.tiro.get(i).getDimension().getY())))
			{
				playerColidiuInimigoBarata02 = true;
				Player.score += 50;
			}
			if(playerColidiuInimigoBarata03 == false && visualizacaoMapaLevel3 == 6 && Collision.CheckCollision(new Rectangle((int)barata3.getPosition().getX(), (int)barata3.getPosition().getY(), (int)barata3.getDimension().getX(), (int)barata3.getDimension().getY()), new Rectangle((int)Player.tiro.get(i).getPosition().getX(), (int)Player.tiro.get(i).getPosition().getY(), (int)Player.tiro.get(i).getDimension().getX(), (int)Player.tiro.get(i).getDimension().getY())))
			{
				playerColidiuInimigoBarata03 = true;
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
		
		if(visualizacaoMapaLevel3 == 6 & Collision.CheckCollision(new Rectangle((int)player.getPosition().getX(), (int)player.getPosition().getY(), (int)player.getDimension().getX(), (int)player.getDimension().getY()), new Rectangle(104, 254, 52, 50)))
		{
			Painel.iniciarContagemPoints = true;
			if(Painel.passarlevel == true)
			{
				SceneManager.changeScene(1);
			}
		}	
		
		if(tirarVida == true)
		{
			Player.qtdVida -= 1;
			tirarVida = false;
		}
	}
	
	public void draw(Graphics2D g2d)
	{
		switch(visualizacaoMapaLevel3)
		{
		case 1:
			g2d.drawImage(LoadImages.getImage(20), 0, 0, null);
			break;
		case 2:
			g2d.drawImage(LoadImages.getImage(21), 0, 0, null);
			
			if(playerColidiuInimigoAranha == false)
				aranha.draw(g2d);
			
			if(playerColidiuInimigoBarata == false)
				barata.draw(g2d);
			
			break;
		case 3:
			g2d.drawImage(LoadImages.getImage(22), 0, 0, null);
			if(playerColidiuInimigoAranha02 == false)
				aranha2.draw(g2d);
			break;
		case 4:
			g2d.drawImage(LoadImages.getImage(23), 0, 0, null);
			if(playerColidiuInimigoMorcego == false)
				morcego.draw(g2d);
			if(playerColidiuInimigoAranha03 == false)
				aranha3.draw(g2d);
			lampada.draw(g2d);
			break;
		case 5:
			g2d.drawImage(LoadImages.getImage(24), 0, 0, null);
			
			if(playerColidiuInimigoBarata02 == false)
				barata2.draw(g2d);
			break;
		case 6:
			g2d.drawImage(LoadImages.getImage(25), 0, 0, null);
			
			if(playerColidiuInimigoBarata03 == false)
				barata3.draw(g2d);
			
			break;
		}
		
		//mapa.draw(g2d);
		player.draw(g2d);
		g2d.drawImage(LoadImages.getImage(1), 0, 450, null);
		mapa3.draw(g2d);
		painel.draw(g2d);
		
	}
}