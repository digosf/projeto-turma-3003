package gradius;

import game.Collision;
import game.Game2;
import game.SoundClip;

import java.awt.Graphics2D;
import java.util.LinkedList;

public class FriendlyShotManagerGR {
	
	public static LinkedList<ShootFriendGR> ShootFriendList = new LinkedList<ShootFriendGR>();
	
	static int contador = 0;
	
	static SoundClip shootGR;

	public FriendlyShotManagerGR()
	{
	}
	
	public static void Update()
	{ 
		for (ShootFriendGR s : ShootFriendList)
		{
			s.Update();
			
			// Checando colisao do tiro do player com as naves inimigas
			for (EnemyGR e : Game2.enemyManagerGR.listEnemy)
			{
				if (Collision.CheckCollision(s, e))
				{
					ShootFriendList.remove(s);
					Game2.enemyManagerGR.listEnemy.remove(e);
					break;
				}
			}
		}
		
		contador ++;
	}
	
	public static void Draw(Graphics2D g2d)
	{
		for (ShootFriendGR s : ShootFriendList)
		{
			s.Draw(g2d);
		}
	}
	
	public static void Fire()
	{
		ShootFriendGR shoot = new ShootFriendGR((float)Game2.player.x,(float)Game2.player.y + 15,
				20,10,"/images/gr_tiroplayer.png");
		if(contador >= 30)
		{
			ShootFriendList.add(shoot);
			shootGR = new SoundClip("/sounds/shoot_GR.wav", 0);
			contador = 0;
		}
	}
}
