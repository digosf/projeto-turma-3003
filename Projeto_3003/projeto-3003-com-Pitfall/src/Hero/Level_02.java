package Hero;

import game.Scene;
import game.SceneManager;
import game.Time;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.geom.Point2D;

class Level_02 extends Scene
{
	Point positionAranha;
	Point positionMorcego;
	float time;
	Player player;
	Mapa2 mapa2;
	Painel painel;
	boolean desenhaRefen = false;
	int visualizacaoMapaLevel2 = 1;
	Inimigo_Aranha aranha;
	Inimigo_Aranha aranha02;
	Inimigo_Morcego morcego;
	Inimigo_Morcego morcego02;
	int temporizador = 0;
	boolean tirarVida = false;
	boolean PlayerColidiuBomba = false;
	boolean playerColidiuInimigoMorcego = false;
	boolean playerColidiuInimigoMorcego02 = false;
	boolean playerColidiuInimigoAranha = false;
	boolean playerColidiuInimigoAranha02 = false;
	
	public Level_02()
	{
		positionAranha = new Point(200, 150);
		morcego = new Inimigo_Morcego(28, new Point(271, 194), new Point(40, 20), new Point(0, 0), new Point(40, 20), new Point(2, 0), 0.2f, true);
		morcego02 = new Inimigo_Morcego(28, new Point(548, 186), new Point(40, 20), new Point(0, 0), new Point(40, 20), new Point(2, 0), 0.2f, true);
		aranha = new Inimigo_Aranha(26, new Point(309, 193), new Point(40, 40), new Point(0, 0), new Point(40, 40), new Point(2, 0), 0.2f, true);
		aranha02 = new Inimigo_Aranha(26,new Point(401, 330), new Point(40, 40), new Point(0, 0), new Point(40, 40), new Point(2, 0), 0.2f, true);
		painel = new Painel(400);
		mapa2 = new Mapa2(new Point(0,0), new Point(800, 450));
		player = new Player(2, new Point(150,50), new Point(50, 70), new Point(0, 0), new Point(50, 70), new Point(4,1), 0.3f, true, 3, 5);
	}

	public void update()
	{		
		if(Player.qtdVida <= 0)
			SceneManager.changeScene(1);
		
		time += Time.getLoopTime();
		
		if(visualizacaoMapaLevel2 == 2)
		{
			positionAranha = new Point(200, 150);
		}
		else if(visualizacaoMapaLevel2 == 3)
		{
			positionAranha = new Point(400, 300);	
		}

		if(Painel.iniciarContagemPoints == false && PlayerColidiuBomba == false)
			player.Update();
		
		painel.Update();
		
		if(visualizacaoMapaLevel2 == 3 && playerColidiuInimigoMorcego == false)
			morcego.Update();
		if(visualizacaoMapaLevel2 == 4 && playerColidiuInimigoMorcego02 == false)
			morcego02.Update();
		if(visualizacaoMapaLevel2 == 2 && playerColidiuInimigoAranha == false)
			aranha.Update();
		if(visualizacaoMapaLevel2 == 3 && playerColidiuInimigoAranha02 == false)
			aranha02.Update();
		
		if (playerColidiuInimigoAranha == false && visualizacaoMapaLevel2 == 2 && Collision.CheckCollision(new Rectangle((int)aranha.getPosition().getX(), (int)aranha.getPosition().getY(), (int)aranha.getDimension().getX(), (int)aranha.getDimension().getY()), new Rectangle((int)player.getPosition().getX(), (int)player.getPosition().getY(), (int)player.getDimension().getX(), (int)player.getDimension().getY())))
		{
			Player.qtdVida -=1;
			playerColidiuInimigoAranha = true;
		}
		if (playerColidiuInimigoAranha02 == false && visualizacaoMapaLevel2 == 3 && Collision.CheckCollision(new Rectangle((int)aranha02.getPosition().getX(), (int)aranha02.getPosition().getY(), (int)aranha02.getDimension().getX(), (int)aranha02.getDimension().getY()), new Rectangle((int)player.getPosition().getX(), (int)player.getPosition().getY(), (int)player.getDimension().getX(), (int)player.getDimension().getY())))
		{
			Player.qtdVida -=1;
			playerColidiuInimigoAranha02 = true;
		}
		if (playerColidiuInimigoMorcego == false && visualizacaoMapaLevel2 == 3 && Collision.CheckCollision(new Rectangle((int)morcego.getPosition().getX(), (int)morcego.getPosition().getY(), (int)morcego.getDimension().getX(), (int)morcego.getDimension().getY()), new Rectangle((int)player.getPosition().getX(), (int)player.getPosition().getY(), (int)player.getDimension().getX(), (int)player.getDimension().getY())))
		{
			Player.qtdVida -=1;
			playerColidiuInimigoMorcego = true;
		}
		if (playerColidiuInimigoMorcego02 == false && visualizacaoMapaLevel2 == 4 && Collision.CheckCollision(new Rectangle((int)morcego02.getPosition().getX(), (int)morcego02.getPosition().getY(), (int)morcego02.getDimension().getX(), (int)morcego02.getDimension().getY()), new Rectangle((int)player.getPosition().getX(), (int)player.getPosition().getY(), (int)player.getDimension().getX(), (int)player.getDimension().getY())))
		{
			playerColidiuInimigoMorcego02 = true;
			Player.qtdVida -=1;
		}
		
		System.out.println("" + visualizacaoMapaLevel2);
		
		//CENA 1 DESCENDO PRA CENA 2
		if(visualizacaoMapaLevel2 == 1 && (int)player.getPosition().getY() >= 450 + player.getDimension().getY())
		{
			player.setPosition(new Point2D.Double(player.getPosition().getX(), 0 - player.getDimension().getY()));
			mapa2.GenerateMap(1);
			visualizacaoMapaLevel2 = 2;
		}
		//CENA 2 SUBINDO PRA CENA 1
		if(visualizacaoMapaLevel2 == 2 && (int)player.getPosition().getY() <= 0 - player.getDimension().getY() - 1)
		{
			visualizacaoMapaLevel2 = 1;
			player.setPosition(new Point2D.Double(player.getPosition().getX(), 450));
			mapa2.GenerateMap(0);
		}
		//CENA 2 DESCENDO PRA CENA 3
		
		if((int)player.getPosition().getY() >= 450 + player.getDimension().getY() && visualizacaoMapaLevel2 == 2)
		{
			visualizacaoMapaLevel2 = 3;
			player.setPosition(new Point2D.Double(player.getPosition().getX(), 0 - player.getDimension().getY()));
			mapa2.GenerateMap(2);
		}
		//CENA 3 SUBINDO PRA CENA 2
		if(visualizacaoMapaLevel2 == 3 && (int)player.getPosition().getY() <= 0 - player.getDimension().getY() - 1)
		{
			player.setPosition(new Point2D.Double(player.getPosition().getX(), 450));
			mapa2.GenerateMap(1);
			visualizacaoMapaLevel2 = 2;
		}
		//CENA 3 DESCENDO PRA CENA 4
		if(visualizacaoMapaLevel2 == 3 && (int)player.getPosition().getY() >= 450 + player.getDimension().getY())
		{
			player.setPosition(new Point2D.Double(player.getPosition().getX(), 0 - player.getDimension().getY()));
			mapa2.GenerateMap(3);
			visualizacaoMapaLevel2 = 4;
		}
		//CENA 4 SUBINDO PRA CENA 3
		if(visualizacaoMapaLevel2 == 4 && (int)player.getPosition().getY() <= 0 - player.getDimension().getY() - 1)
		{
			player.setPosition(new Point2D.Double(player.getPosition().getX(), 450));
			mapa2.GenerateMap(2);
			visualizacaoMapaLevel2 = 3;
		}
		
		for (int i = 0; i < mapa2.mapPiece.size(); i++)
		{
			if (Collision.CheckCollision(new Rectangle((int)player.getPosition().getX(), (int)player.getPosition().getY(), (int)player.getDimension().getX(), (int)player.getDimension().getY()),
					mapa2.mapPiece.get(i), player.oldPosX, player.oldPosY, "top", 0))
			{
				player.setPosition(new Point2D.Double(player.getPosition().getX(), mapa2.mapPiece.get(i).y - player.getDimension().getY()));
			}
			
			
			if (Collision.CheckCollision(new Rectangle((int)player.getPosition().getX(), (int)player.getPosition().getY(), (int)player.getDimension().getX(), (int)player.getDimension().getY()),
					mapa2.mapPiece.get(i), player.oldPosX, player.oldPosY, "left", 0))
			{
				player.setPosition(new Point2D.Double(mapa2.mapPiece.get(i).x - player.getDimension().getX(), player.getPosition().getY()));
			}
			
			
			if (Collision.CheckCollision(new Rectangle((int)player.getPosition().getX(), (int)player.getPosition().getY(), (int)player.getDimension().getX(), (int)player.getDimension().getY()),
					mapa2.mapPiece.get(i), player.oldPosX, player.oldPosY, "bottom", 0))
			{
				player.setPosition(new Point2D.Double(player.getPosition().getX(), mapa2.mapPiece.get(i).y + mapa2.mapPiece.get(i).height));
			}
			
			
			if (Collision.CheckCollision(new Rectangle((int)player.getPosition().getX(), (int)player.getPosition().getY(), (int)player.getDimension().getX(), (int)player.getDimension().getY()),
					mapa2.mapPiece.get(i), player.oldPosX, player.oldPosY, "right", 0))
			{
				player.setPosition(new Point2D.Double(mapa2.mapPiece.get(i).x + mapa2.mapPiece.get(i).width, player.getPosition().getY()));
			}
		}
		
		for (int i = 0; i < mapa2.wall.size(); i++)
		{
			if (Collision.CheckCollision(new Rectangle((int)player.getPosition().getX(), (int)player.getPosition().getY(), (int)player.getDimension().getX(), (int)player.getDimension().getY()),
					mapa2.wall.get(i), player.oldPosX, player.oldPosY, "top", 0))
			{
				player.setPosition(new Point2D.Double(player.getPosition().getX(), mapa2.wall.get(i).y - player.getDimension().getY()));
			}
			
			if (Collision.CheckCollision(new Rectangle((int)player.getPosition().getX(), (int)player.getPosition().getY(), (int)player.getDimension().getX(), (int)player.getDimension().getY()),
					mapa2.wall.get(i), player.oldPosX, player.oldPosY, "left", 0))
			{
				player.setPosition(new Point2D.Double(mapa2.wall.get(i).x - player.getDimension().getX(), player.getPosition().getY()));
			}
			
			if (Collision.CheckCollision(new Rectangle((int)player.getPosition().getX(), (int)player.getPosition().getY(), (int)player.getDimension().getX(), (int)player.getDimension().getY()),
					mapa2.wall.get(i), player.oldPosX, player.oldPosY, "bottom", 0))
			{
				player.setPosition(new Point2D.Double(player.getPosition().getX(), mapa2.wall.get(i).y + mapa2.wall.get(i).height));
			}
			
			if (Collision.CheckCollision(new Rectangle((int)player.getPosition().getX(), (int)player.getPosition().getY(), (int)player.getDimension().getX(), (int)player.getDimension().getY()),
					mapa2.wall.get(i), player.oldPosX, player.oldPosY, "right", 0))
			{
				player.setPosition(new Point2D.Double(mapa2.wall.get(i).x + mapa2.wall.get(i).width, player.getPosition().getY()));
			}
		}
		for (int i = 0; i < player.nade.size(); i++)
		{
			if (player.nade.get(i).explode == true)
			{
				for (int j = 0; j < mapa2.wall.size(); j++)
				{
					if (Collision.CheckCollision(player.nade.get(i).explosionRect, mapa2.wall.get(j)))
					{
						Player.score += 75;
						mapa2.wall.remove(mapa2.wall.get(j));
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
			if(playerColidiuInimigoAranha == false && visualizacaoMapaLevel2 == 2 && Collision.CheckCollision(new Rectangle((int)aranha.getPosition().getX(), (int)aranha.getPosition().getY(), (int)aranha.getDimension().getX(), (int)aranha.getDimension().getY()), new Rectangle((int)Player.tiro.get(i).getPosition().getX(), (int)Player.tiro.get(i).getPosition().getY(), (int)Player.tiro.get(i).getDimension().getX(), (int)Player.tiro.get(i).getDimension().getY())))
			{
				playerColidiuInimigoAranha = true;
				Player.score += 50;
			}
			if(playerColidiuInimigoAranha02 == false && visualizacaoMapaLevel2 == 3 && Collision.CheckCollision(new Rectangle((int)aranha02.getPosition().getX(), (int)aranha02.getPosition().getY(), (int)aranha02.getDimension().getX(), (int)aranha02.getDimension().getY()), new Rectangle((int)Player.tiro.get(i).getPosition().getX(), (int)Player.tiro.get(i).getPosition().getY(), (int)Player.tiro.get(i).getDimension().getX(), (int)Player.tiro.get(i).getDimension().getY())))
			{
				playerColidiuInimigoAranha02 = true;
				Player.score += 50;
			}
			if(playerColidiuInimigoMorcego == false && visualizacaoMapaLevel2 == 3 && Collision.CheckCollision(new Rectangle((int)morcego.getPosition().getX(), (int)morcego.getPosition().getY(), (int)morcego.getDimension().getX(), (int)morcego.getDimension().getY()), new Rectangle((int)Player.tiro.get(i).getPosition().getX(), (int)Player.tiro.get(i).getPosition().getY(), (int)Player.tiro.get(i).getDimension().getX(), (int)Player.tiro.get(i).getDimension().getY())))
			{
				playerColidiuInimigoMorcego = true;
				Player.score += 50;
			}
			if(playerColidiuInimigoMorcego02 == false && visualizacaoMapaLevel2 == 4 && Collision.CheckCollision(new Rectangle((int)morcego02.getPosition().getX(), (int)morcego02.getPosition().getY(), (int)morcego02.getDimension().getX(), (int)morcego02.getDimension().getY()), new Rectangle((int)Player.tiro.get(i).getPosition().getX(), (int)Player.tiro.get(i).getPosition().getY(), (int)Player.tiro.get(i).getDimension().getX(), (int)Player.tiro.get(i).getDimension().getY())))
			{
				playerColidiuInimigoMorcego02 = true;
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
		
		if(visualizacaoMapaLevel2 ==  4 && Collision.CheckCollision(new Rectangle((int)player.getPosition().getX(), (int)player.getPosition().getY(), (int)player.getDimension().getX(), (int)player.getDimension().getY()), new Rectangle(623, 249, 61, 47)))
		{
			Painel.iniciarContagemPoints = true;
			if(Painel.passarlevel == true)
			{
				Painel.iniciarContagemPoints = false;
				SceneManager.changeScene(3);
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
		switch(visualizacaoMapaLevel2)
		{
			case 1:
				g2d.drawImage(LoadImages.getImage(16), 0, 0, null);
				break;
			case 2:
				g2d.drawImage(LoadImages.getImage(17), 0, 0, null);
				if(playerColidiuInimigoAranha == false)
					aranha.draw(g2d);
				break;
			case 3:
				g2d.drawImage(LoadImages.getImage(18), 0, 0, null);
				if(playerColidiuInimigoAranha02 == false)
					aranha02.draw(g2d);
				if(playerColidiuInimigoMorcego == false)
					morcego.draw(g2d);
				break;
			case 4:
				g2d.drawImage(LoadImages.getImage(19), 0, 0, null);
				if(playerColidiuInimigoMorcego02 == false)
					morcego02.draw(g2d);
				break;
		}
		player.draw(g2d);
		g2d.drawImage(LoadImages.getImage(1), 0, 450, null);
		mapa2.draw(g2d);
		painel.draw(g2d);
	}
}