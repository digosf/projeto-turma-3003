package game;
import java.awt.Graphics2D;
import java.util.LinkedList;
import java.util.Random;

public class EnemyShotManagerSI {
	
	float shotPosiY;
	float shotPosiX;
	Random rand = new Random();
	float timer = 0;
	float timerReaming = 70;
	LinkedList<Shot> shotList = new LinkedList<Shot>();
	SoundClip shootclip;
	
	public EnemyShotManagerSI()
	{
		shootclip = new SoundClip();
		shootclip.load("/sounds/shoot_SI.wav", true);
	}
	
	public void update()
	{
		timer ++;
		if(timer > timerReaming)
		{
			timer = 0;
			AdicionarTiro();
		}
		
		for (Shot s : shotList)
		{
			s.Update();
			
			if (Collision.CheckCollision(s, Game1.player))
			{
				shotList.remove(s);
				Game1.player.life -= 1;
			}
		}
		
		if(shotList.size() > 0)
		{
			for(int i = 0; i < shotList.size(); i++)
			{
				shotList.get(i).Update();
			}
		}
	}
	
	public void draw(Graphics2D g2d)
	{
		if(shotList.size() > 0)
		{
			for(int i = 0; i < shotList.size(); i++)
			{
				shotList.get(i).Draw(g2d);
				shotList.get(i).Draw(g2d);
			}
		}
	}
	
	public void AdicionarTiro()
	{
		EnemySI enemy = EnemyManagerSI.listEnemy.get(rand.nextInt(EnemyManagerSI.listEnemy.size()));
		//shotList.add(new EnemyShotSI(enemy.x, enemy.y, enemy.w, enemy.h, "IMAGEM", null));
		shotList.add(new EnemyShotSI(enemy.x, enemy.y, 10, 10, "/images/tiro_inimigo.png", shootclip));
	}
}