package Game;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Mouse implements MouseListener, MouseMotionListener
{
	
	private static Mouse instance = new Mouse();
	
	private static int timer;
	private static final int MAX_TIME = 2;
	
	public static boolean isPressed;
	public static Point lastPressedPosition;
	
	public static boolean clicked;
	public static Point lastClickedPosition;
	
	public static boolean isDragging;
	public static Point actualPosition;
	
	public static boolean isOutsideScreen;
	
	public static Mouse getInstance()
	{
		return instance;
	}
	
	private Mouse()
	{
		isPressed = false;
		lastPressedPosition = null;
		lastClickedPosition = null;
		actualPosition = new Point(0, 0);
		//System.out.println("Iniciou Mouse Listener");
	}
	
	public synchronized static void Update()
	{
		if(clicked)
		{
			if(timer++ == MAX_TIME)
			{
				clicked = false;
			}
		}
	}

	@Override
	public synchronized void mouseClicked(MouseEvent e) {
		lastClickedPosition = new Point(e.getX(), e.getY());
		actualPosition = new Point(e.getX(), e.getY());
		clicked = true;
		timer = 0;
	}

	@Override
	public synchronized void mouseEntered(MouseEvent e)
	{
		actualPosition = new Point(e.getX(), e.getY());
	}

	@Override
	public synchronized void mouseExited(MouseEvent e) 
	{
		isOutsideScreen = true;
		actualPosition = new Point(e.getX(), e.getY());
	}

	@Override
	public synchronized void mousePressed(MouseEvent e) {
		isPressed = true;
		lastPressedPosition = new Point(e.getX(), e.getY());
		actualPosition = new Point(e.getX(), e.getY());
	}

	@Override
	public synchronized void mouseReleased(MouseEvent e) {
		isPressed = false;
		isDragging = false;
		actualPosition = new Point(e.getX(), e.getY());
	}

	@Override
	public synchronized void mouseDragged(MouseEvent e) 
	{
		isDragging = true;
		actualPosition = new Point(e.getX(), e.getY());
	}

	@Override
	public synchronized void mouseMoved(MouseEvent e) 
	{
		actualPosition = new Point(e.getX(), e.getY());
	}

}
