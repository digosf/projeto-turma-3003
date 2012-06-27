package spaceInvaders;

import game.Collision;
import game.Game1;
import game.SceneManager;
import game.SoundClip;

import java.awt.Graphics2D;
import java.util.LinkedList;

public class EnemyManagerSI {

	public static LinkedList<EnemySI> listEnemy;

	//Velocidade
	private float speedX;
	private float speedY;
	
	//tamanho objeto
	private static int sizeWidth = 40;
	private static int sizeHeight = 40;
	
	boolean collision;
	
	public EnemyManagerSI()
	{
		collision = true;
		this.speedX = 4;
		this.speedY = 30;
		//listEnemy = new LinkedList<EnemySI>();
		NewEnemy(8, 4);
	}

    public void update()
    {
    	float speedYTemp = 0;
    	
    	for(int i = 0; i < listEnemy.size(); i++)
    	{
    		if (listEnemy.get(i).x <= 0)
    		{
    			this.speedX = 2;
    			speedYTemp = this.speedY;
    			
    		}
    		else if (listEnemy.get(i).x + listEnemy.get(i).w >= 800)
    		{
    			this.speedX = -2;
    			speedYTemp = this.speedY;
    		}
    	}
    	
    	for (EnemySI s : listEnemy)
		{
			if (Collision.CheckCollision(s, Game1.player))
			{
				listEnemy.remove(s);
				Game1.player.life -= 1;
				break;
			}
		}
    	
    	//Update do inimigo
    	for(EnemySI enemy: listEnemy)
    	{
			enemy.MoveEnemy(this.speedX, speedYTemp);
    	}
    	
    	if (listEnemy.isEmpty())
    	{
			SceneManager.changeScene(0);
    	}
    }
    
	public void draw(Graphics2D g2d)
    {
		//Draw Inimigo
        for(EnemySI enemy: listEnemy)
        {
        	enemy.Draw(g2d);
        }
    }
	
	public static void NewEnemy(int numX, int numY) //Metodo para criar novos inimigos do zero determinando quantidade de linha e coluna
	{
		//Zera lista de inimigos
		listEnemy = null;
		listEnemy = new LinkedList<EnemySI>();
		
		for(int x = 0; x < numX; x++)
		{
			for(int y = 0; y < numY; y++)
			{
				//Instancia inimigo
				listEnemy.add(new EnemySI(	(x * (sizeWidth + 5)), 
											(y * (sizeHeight + 5)),
											sizeWidth, 
											sizeHeight,
											"/images/si_inimigo.png"));
			}
		}
	}
	
	public static void DestroyEnemy(int indexList)//Metodo static para destruir objeto de acordo com sua posicao na lista
	{
		listEnemy.remove(indexList);
	}
}
