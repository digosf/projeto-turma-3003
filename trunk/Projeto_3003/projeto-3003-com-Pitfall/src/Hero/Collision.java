package Hero;

import java.awt.Rectangle;

public class Collision {
	
	private static Rectangle r1;
    private static Rectangle r2;
	private static boolean result;
	
	private Collision()
	{	
	}
    
    //Colisão simples, apenas necessita de dois objetos e verifica a colisão entre eles
    public static boolean CheckCollision(GameObject go1, GameObject go2)
    {
    	UpdateRect(go1, go2);
    	return (r1.intersects(r2));
    }
    
    public static boolean CheckCollision(Rectangle r1, Rectangle r2)
    {
    	return (r1.intersects(r2));
    }
    
    //Colisão mais precisa que além do lado necessita da posição antiga do objeto1 e da velocidade do objeto2.
    public static boolean CheckCollision(GameObject go1, GameObject go2, float oldPosX, float oldPosY, String side, float object2Speed)
    {
    	
        UpdateRect(go1, go2);
        if(side == "left")
        	result = (r1.intersects(r2) && (r1.x + r1.width) - (go1.getPosition().getX() - oldPosX) - object2Speed <= r2.x);
        if(side == "top")
        	result = (r1.intersects(r2) && r1.y + r1.height - (go1.getPosition().getY() - oldPosY) - object2Speed <= r2.y);
        if(side == "right")
    	   	result = (r1.intersects(r2) && r1.x + (oldPosX - go1.getPosition().getX()) + object2Speed >= (r2.x + r2.width));
        if(side == "bottom")
        	result = (r1.intersects(r2) && r1.y + (oldPosY - go1.getPosition().getY()) + object2Speed >= (r2.y + r2.height));
        return result;
    }
    
    public static boolean CheckCollision(Rectangle r1, Rectangle r2, double oldPosX, double oldPosY, String side, float object2Speed)
    {
        if(side == "left")
        	result = (r1.intersects(r2) && (r1.x + r1.width) - (r1.x - oldPosX) - object2Speed <= r2.x);
        if(side == "top")
        	result = (r1.intersects(r2) && r1.y + r1.height - (r1.y - oldPosY) - object2Speed <= r2.y);
        if(side == "right")
    	   	result = (r1.intersects(r2) && r1.x + (oldPosX - r1.x) + object2Speed >= (r2.x + r2.width));
        if(side == "bottom")
        	result = (r1.intersects(r2) && r1.y + (oldPosY - r1.y) + object2Speed >= (r2.y + r2.height));
        return result;
    }
    
    //Atualiza os valores dos retângulos.
    private static void UpdateRect(GameObject go1, GameObject go2)
    {
        r1 = new Rectangle((int)go1.getPosition().getX(), (int)go1.getPosition().getY(), (int)go1.getRectangle().getWidth(), (int)go1.getRectangle().getHeight());
        r2 = new Rectangle((int)go2.getPosition().getX(), (int)go2.getPosition().getY(), (int)go2.getRectangle().getWidth(), (int)go2.getRectangle().getHeight());
    }
}

