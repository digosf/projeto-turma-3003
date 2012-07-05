package Hero;

import game.Time;

import java.awt.Point;

public class AnimatedSprite extends GameObject 
{
	private static final long serialVersionUID = 1L;
	protected Point animationType;
	private float timer, time;
	protected int row, column;
	private boolean input;
	protected boolean pressionado, end, automatic;
	
	public AnimatedSprite(int indexImage, Point pos, Point size, Point sPos, Point sSize, Point animationType, float timePerFrame, boolean input) 
	{
		super(pos, size, sPos, sSize);
		setImage(indexImage);
		this.time = timePerFrame;
		this.animationType = animationType;
		this.input = input;
	}
	
	public void Update()
	{
		super.Update();
		if (!input)
		{
			if (row < animationType.y)
			{
				if (column < animationType.x - 1)
				{
					if (timer > time)
					{
						this.sPos = new Point(this.sPos.x + this.sSize.x, this.sPos.y);
						column++;
						timer -= time;
					}
				}
				else
				{
					if (timer > time)
					{
						//this.sPos = new Point(0, this.sPos.y + this.sSize.y);
						row++;
						column = 0;
						timer -= time;
					}
				}
			}
			else
			{
				this.sPos = new Point(0, 0);
				row = 0;
				end = true;
			}
			
			timer += Time.getLoopTime();
		}
		else
			this.sPos.y = sSize.y * animationType.y - sSize.y;
			if (row < animationType.y)
			{
				if (column <= animationType.x - 1)
				{
					if (pressionado == true && column != animationType.x - 1 || automatic && column != animationType.x - 1)
					{
						timer += Time.getLoopTime();
						if (timer > time)
						{
							this.sPos = new Point(this.sPos.x + this.sSize.x, this.sPos.y);
							column++;
							timer = 0;
						}
						pressionado = false;
						automatic = false;
					}
					
					if (column == animationType.x - 1)
					{
						if (pressionado || automatic)
						{
							timer += Time.getLoopTime();
							if (timer > time)
							{
								column = 0;
								this.sPos = new Point(0, this.sPos.y);
								timer = 0;
							}
						}
					}
				}
			}
		}
	}