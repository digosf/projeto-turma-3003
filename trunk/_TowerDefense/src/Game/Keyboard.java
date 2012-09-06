package Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.ArrayList;


public class Keyboard implements KeyListener
{
	public static enum KeyState //Estados da tecla
	{
		RELEASED, // Solta
		PRESSED_ONCE, // Apertada
		PRESSED // Pressionada
	}
	private static final int KEY_COUNT = 256;
	
	private static KeyState[] keyState = new KeyState[KEY_COUNT];
	
	private static List<Integer> KeyCode = new ArrayList<Integer>();
	
	private Keyboard()
	{
		for(int i = 0; i < KEY_COUNT; i++)
		{
			keyState[i] = KeyState.RELEASED;
		}
	}
	
	private static Keyboard instance = new Keyboard();
	
	public static Keyboard getInstance()
	{
		return instance;
	}
	
	public static synchronized void UpdateKeyState()
	{
		if(KeyCode != null)
		{
			for(Integer i : KeyCode)
			{
				if(keyState[i] == KeyState.RELEASED)
				{
					keyState[i] = KeyState.PRESSED_ONCE;
				}
				else
				{
					keyState[i] = KeyState.PRESSED;
				}
			}
		}
	}
	
	public static KeyState GetKeyState(int keyCode){return keyState[keyCode];}
	
	public boolean isKeyPressed(int keyCode)
	{
		
		if(KeyCode.contains(keyCode))
		{
			return true;
		}
		
		return false;
	}
	
	public synchronized void keyReleased(int k)
	{
		//int aux = k;
		
		for (int i = 0; i < KeyCode.size(); i++)
		{
			if (KeyCode.get(i) == k)//aux)
			{
				KeyCode.remove(i);
				keyState[i] = KeyState.RELEASED;
			}
		}
	}
	
	public synchronized void clear()
	{
		KeyCode.clear();
		for(int n = 0; n > KEY_COUNT; n++)
		{
			keyState[n] = KeyState.RELEASED;
		}
	}
	
	
	public synchronized void keyPressed(KeyEvent e) 
	{
		int a = e.getKeyCode();
		
		if(KeyCode.contains(a))
		{
			return;
		}	
		KeyCode.add(a);					
	}

	public synchronized void keyReleased(KeyEvent e)
	{
		int a = e.getKeyCode();
		
		if(KeyCode.contains(a))
		{
			KeyCode.remove(KeyCode.indexOf(a));
			keyState[a] = KeyState.RELEASED;
		}				
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
