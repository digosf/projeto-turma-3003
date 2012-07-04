package RallyX;

import java.awt.event.KeyEvent;

import game.Keyboard;

public class PlayerRallyX extends GameObjectRallyX
{
	TileManagerRallyX map;
	
	public PlayerRallyX(float x, float y, int w, int h, String image, TileManagerRallyX map) {
		super(x, y, w, h, image);
		map = this.map;
	}
	
	public void update()
	{
	}
}
