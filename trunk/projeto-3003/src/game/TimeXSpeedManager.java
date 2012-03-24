package game;

public class TimeXSpeedManager 
{
	private static TimeXSpeedManager instance;	
	
	public static float changeSpeedDelay = 20f; //Delay para o aumento de velocidade (segundos).
	public static float time = 0;
	
	public static int speed = 1; //Velocidade inicial.
	
	private TimeXSpeedManager() 
	{
		
	}
	//Singleton
	public static TimeXSpeedManager getInstance() 
	{
		if(instance == null)
		{
			instance = new TimeXSpeedManager();
		}		
		return instance;
	}
	
	//Atualiza o tempo e a velocidade.
	public static void Update() 
	{
		time += System.nanoTime() / 1000000000000000.0f; //Tempo de duração do frame atual + tempo atual.
		
		if(time >= changeSpeedDelay) // Se tempo for maior que o delay, tempo = 0 e velocidade aumenta (1).
		{
			time = 0;
			speed++;
		}
	}
}
