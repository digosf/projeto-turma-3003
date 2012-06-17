package game;
import MoonPatrol.BuracoManager;
import MoonPatrol.EnemyGerencMP;
import MoonPatrol.PlayerMoonPatrol;
import MoonPatrol.GerenciadorPlayer;
import MoonPatrol.Background;
import MoonPatrol.ShotEnemyManager;

import ifante.PlataformMananger;
import ifante.PlayerIfante;

import java.awt.Graphics2D;
import java.awt.Point;



public class Game4 extends Scene{
	
	public Background background;
	public Background background2;
	public Background background3;
	public Background background4;
	GerenciadorPlayer manager;
	PlayerMoonPatrol player;
	EnemyGerencMP inimigo;
	BuracoManager buraco;
	ShotEnemyManager tiroini;
	

	final float maxTime = 60;
	float time;
	
	public Game4()
	{
		player = new PlayerMoonPatrol(new Point(0, 500),new Point(83, 50), "/images/personagem1.png");
		background = new Background(0,0,800,600, "/images/chao.png", true);
		background2 = new Background(0,0,800,600, "/images/fundo_azul.png", true);
		background3 = new Background(0,0,800,600, "/images/fundo_verde.png", true);
		background4 = new Background(0,0,800,600, "/images/fundo_estrelado.png", true);
		manager = new GerenciadorPlayer(800, 600 ,0 , 0, "/images/fundo_estrelado.png");
		inimigo= new EnemyGerencMP();
		buraco= new BuracoManager();
				tiroini = new ShotEnemyManager ();
				
				
		
	}
	
	@Override
		public void update()
		{
			TimeXSpeedManager.Update();
			player.Update();
			manager.Update();
			inimigo.Update();
			background.Update();
			background2.Update();
			background3.Update();
			background4.Update();
			tiroini.Update(player);
			buraco.Update(player, 1);
			
			time += System.nanoTime() / 10000000000000000.0f;
			
			if (time >= maxTime)
				SceneManager.changeScene(0);
			
			
			
			
			
		}
	
	@Override
		public void draw(Graphics2D g){
		
			background4.Draw(g);			
			background2.Draw(g);
			background3.Draw(g);
			background.Draw(g);
			player.Draw(g);
			inimigo.Draw(g);
			buraco.Draw(g);
			tiroini.draw(g);
			
		}
	
}


