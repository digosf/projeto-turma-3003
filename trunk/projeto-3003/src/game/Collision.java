package game;

import java.awt.Rectangle;

public class Collision {
	
	private static Rectangle r1;
    private static Rectangle r2;
	
	private Collision()
	{	
	}
    
    //Colis�o simples, apenas necessita de dois objetos e verifica a colis�oentre eles
    public static boolean CheckCollision(GameObject go1, GameObject go2)
    {
    	UpdateRect(go1, go2);
    	return (r1.intersects(r2));
    }
    
    //Colis�o mais precisa que al�m do lado necessita da velocidade do segundo corpo 
	//e a posi��o antiga do primeiro.
    /*public static boolean CheckCollision(GameObject go1, GameObject go2, float oldPosX, float oldPosY, String side, float object2Speed)
    {
        UpdateRect(go1, go2);
        if(side == "left")
        	result = (r1.intersects(r2) && (r1.x + r1.width) - (go1.x - oldPosX) - object2Speed <= r2.x);
        if(side == "top")
        	result = (r1.intersects(r2) && r1.y + r1.height - (go1.y - oldPosY) - object2Speed <= r2.y);
        if(side == "right")
    	   	result = (r1.intersects(r2) && r1.x + (oldPosX - go1.x) + object2Speed >= (r2.x + r2.height));
        if(side == "bottom")
        	result = (r1.intersects(r2) && r1.y + (oldPosY - go1.y) + object2Speed >= (r2.y + r2.height));
        return result;
    }*/
    
    //Atualiza os valores dos ret�ngulos.
    private static void UpdateRect(GameObject go1, GameObject go2)
    {
        r1 = new Rectangle((int)go1.x, (int)go1.y, go1.w, go1.h);
        r2 = new Rectangle((int)go2.x, (int)go2.y, go2.w, go2.h);
    }
}

