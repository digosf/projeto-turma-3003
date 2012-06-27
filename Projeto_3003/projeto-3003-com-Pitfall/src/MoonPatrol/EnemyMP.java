package MoonPatrol;
 import java.util.Random;


import game.GameObject;




public class EnemyMP extends GameObject 

{

	float veloc = 3 ;
	int futureposition;
	float velocMoviment = 5;
	boolean descendo = false;
	Random rand = new Random(); 
	

	public EnemyMP(float x, float y, int w, int h, String image) 
	{
		super(x, y, w, h, image);
		
	}
public void MoveEnemy()
 {
     y++; 
	if(x < futureposition - 10 || x > futureposition +10)
	{
		if(x> futureposition)
			x -= velocMoviment;
		
		else
			x+= velocMoviment;
	}
	else
		futureposition = rand.nextInt(800);
	
	
	if(descendo)
	{
		if (y <= 450)
        {
			y --;
            }
            else
            {
                descendo = false;
            }
	}
	else
	{
		if (y <= 150)
        {
        	y++;
        }
        else
        {
            descendo = true;
        }
	}
	
	super.Update();
	  
	
	


	  
	 }
}

