package Game;

import java.awt.Graphics;
import java.awt.Image;

public class Button extends GameImage
{
	Image selectedImg; int sW, sH;
	public boolean isSelected;
	
	public Button(int x, int y, String unselectedImgURL, String selectedImgURL) 
	{
		super(x, y);
		Load(unselectedImgURL);
		selectedImg = Load(selectedImg, selectedImgURL);
		sW = selectedImg.getWidth(null);
		sH = selectedImg.getHeight(null);
	}
	
	public boolean isMouseColliding()
	{
		return this.getRectangle().contains(Mouse.actualPosition);
	}
	
	@Override
	public void Draw(Graphics g)
	{
		if(!isSelected)
		{
			super.Draw(g);
		}
		else
		{
			sW = selectedImg.getWidth(null);
			sH = selectedImg.getHeight(null);
			g.drawImage(selectedImg, x, y, sW, sH, null);
		}
	}

}
