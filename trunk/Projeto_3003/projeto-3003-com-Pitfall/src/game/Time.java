
package game;



public class Time
{
	private static Time instance;
	
	private long lastTime  = 0;
	private long loopNanoTime = 0;
	private static float loopTime = 0;
	private static float FPS  = 0;
	
	
	public static float getLoopTime() {
		return loopTime;
	}
	public static float getFPS() {
		return FPS;
	}
	
	private Time(){}
	static Time getInstance()
	{
		if(instance==null)
		{
			instance = new Time();
		}
		return instance;
	}
	
	public void UpdateLastTime()
	{
		this.lastTime = System.nanoTime();
	}
	
	public void UpdateLoopTime()
	{
		this.loopNanoTime = System.nanoTime() - this.lastTime;
		loopTime = (float)(loopNanoTime*0.000000001);
		FPS = 1f/loopTime;
		
		//System.out.println("FPS: " + FPS);
		//System.out.println("LOOPTIME: " + loopTime);
	}


	
	
	

	
	
}

	


	


	

