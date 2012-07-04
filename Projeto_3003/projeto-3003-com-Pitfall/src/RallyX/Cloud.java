package RallyX;

public class Cloud extends GameObjectRallyX{

	public int count;
	public Cloud(float x, float y, int w, int h, String image) {
		super(x, y, w, h, image);
		
		// TODO Auto-generated constructor stub
	}
	public void Update()
	{
		count++;
		if(count > 100)
		{
			CloudManager.DeleteCloud();
		}
	}

}
