package game;

import java.awt.Graphics2D;

public class Game3 extends Scene
{
	Background background;
	PlayerIfante player;
	PlataformMananger manager;
	
	final float maxTime = 60;
	float time;
	
	public Game3()
	{
		// nao e possivel carregar a imaem de fundo do pluemet, motivo desconhecido.
		// motivo desconhecido = a imagem está corrompida.
		TimeXSpeedManager.speed = 1;
		TimeXSpeedManager.time = 0;
		TimeXSpeedManager.changeSpeedDelay = 10f;
		
		background = new Background(0,0,800,600, "/images/SpaceInvaderFundo.jpg", null);
		player = new PlayerIfante(375, 0, 50, 100, "/images/PersonagemPlumet.png", null);
		manager = new PlataformMananger();
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		TimeXSpeedManager.Update();
		player.Update();
		manager.Update(player);
		
		time += System.nanoTime() / 10000000000000000.0f;
		
		if (time >= maxTime)
			SceneManager.changeScene(0);
	}
	
	@Override
	public void draw(Graphics2D g2d) {
		background.Draw(g2d);
		manager.Draw(g2d);
		player.Draw(g2d);
		g2d.drawString("Tempo Restante: " + (int)(maxTime - time), 10, 30);
		g2d.drawString("Speed: " + TimeXSpeedManager.speed, 400, 30);
		g2d.drawString("Delay: " + (int)(TimeXSpeedManager.changeSpeedDelay - TimeXSpeedManager.time), 730, 30);
	}
}
