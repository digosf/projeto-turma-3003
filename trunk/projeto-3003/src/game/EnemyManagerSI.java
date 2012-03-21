package game;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.util.LinkedList;

public class EnemyManagerSI {

	public static LinkedList<EnemySI> listEnemy= new LinkedList<EnemySI>();

	//Velocidade
	private float speedX;
	private float speedY;
	
	//tamanho objeto
	private static int sizeWidth = 40;
	private static int sizeHeight = 40;
	
	private static SoundClip sound;
	
	public EnemyManagerSI(SoundClip sound)
	{
		this.speedX = 1;
		this.speedY = 20;
		this.sound = sound;
	}

    public void update()
    {
    	//variavel que resulta o teste de que o objeto tocou nas bordas
    	boolean collision = false;
    	
    	for(int i = 0; i < listEnemy.size(); i++)
    	{
    		//Teste da colisao com as bordas
    		if(listEnemy.get(i).x <= 0 || listEnemy.get(i).x + listEnemy.get(i).w >= 800)
    		{
    			collision = true;
    		}
    	}
    	
    	//Variavel resultante da velocidade Y que sera adicionada apenas quando o inimigo tocar na tela
    	float speedYTemp = 0;
    	if(collision)
    	{
    		this.speedX *= -1;	//Inverte direcao X 
    		speedYTemp = this.speedY;
    	}
    	
    	//Update do inimigo
    	for(EnemySI enemy: listEnemy)
    	{
			enemy.MoveEnemy(this.speedX, speedYTemp);
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
											"/images/inimigos_1.png",
											sound));
			}
		}
	}
	
	public static void DestroyEnemy(int indexList)//Metodo static para destruir objeto de acordo com sua posicao na lista
	{
		listEnemy.remove(indexList);
	}
}
