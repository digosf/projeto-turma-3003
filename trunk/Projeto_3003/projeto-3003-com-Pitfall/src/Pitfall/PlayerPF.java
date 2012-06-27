package Pitfall;

import game.Keyboard;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.util.LinkedList;

public class PlayerPF extends AnimatedSprite
{

	private static final long serialVersionUID = 1L;
	private double velPulo = 0;
	private final double pulo = 2;
	private boolean podeCipo = true;
	private boolean estaNoCipo = false; 
	private int indexCipo;
	private Point2D positionSave;
	private Point2D posSaveCipo;
	private boolean estaNaEscada = false;
	
	

	public PlayerPF(String image, Point2D pos, Point size, Point sPos,
			Point sSize, Point animationType, boolean input) 
	{
		super(image, pos, size, sPos, sSize, animationType, 0.1f, input);
		super.setVelocity(1);
	}
	
	public void Update(LinkedList<Rectangle> listPiso, CipoManager cipoManager, LinkedList<Rectangle> escada)
	{
		
		
		if(velPulo > 0)
		{
			for(Rectangle inst : listPiso)
			{
				if(this.ColisaoRect(inst))
				{
					if(inst.getY() > this.getRectangle().getMaxY() - 7)
					{
						this.setPosition(new Point2D.Double(this.getPosition().getX(), inst.getY() - this.getDimension().getY()));
						velPulo = 0;
						break;
					}
				}
			}
		}
		
		if(velPulo < 0)
		{
			for(Rectangle inst : listPiso)
			{
				if(this.ColisaoRect(inst))
				{
					//this.setPosition(new Point2D.Double(this.getPosition().getX(), inst.getMaxY()));
					velPulo = 0.001f;
					break;
				}
			}
		}
		
		if(velPulo != 0 && estaNoCipo == false && estaNaEscada == false)
		{
			velPulo += 0.03;
			
			if(podeCipo && cipoManager != null)
			{
				for(int x = cipoManager.cipoList.size() - 1; x > 0 ; x--)
				{
					if(this.ColisaoRect(new Rectangle((int)cipoManager.cipoList.get(x).getPosition().getX(),
														(int)cipoManager.cipoList.get(x).getPosition().getY(),
														(int)cipoManager.cipoList.get(x).getDimension().getX(), 
														(int)cipoManager.cipoList.get(x).getDimension().getY())))
					{
						this.posSaveCipo = cipoManager.cipoList.get(x).getPosition();
						this.estaNoCipo = true;
						this.indexCipo = x;
						this.positionSave = this.getPosition();
						this.podeCipo = false;
						this.velPulo = 0;
						break;
					}
				}
			}
		}
		
		if(estaNoCipo == true)
		{
			this.setPosition(new Point2D.Double(this.positionSave.getX() - (this.posSaveCipo.getX() - cipoManager.cipoList.get(indexCipo).getPosition().getX()),
						this.positionSave.getY() - (this.posSaveCipo.getY() - cipoManager.cipoList.get(indexCipo).getPosition().getY())));
		}
		
		
		
		if(velPulo == 0 && estaNoCipo == false)
		{
			boolean estaNoChao = false;
			
			for(Rectangle inst : listPiso)
			{
				if(this.ColisaoRect(inst))
				{
					this.podeCipo = true;
					estaNoChao = true;
					break;
				}
			}
			if(estaNoChao == false)
			{
				velPulo = 0.001f;
			}
		}
		
		
		this.addPosition(new Point2D.Double(0, velPulo));
		
		
		
		if(escada != null)
		{
			if(Keyboard.getInstance().isKeyPressed(KeyEvent.VK_UP))
			{
				if(this.getRectangle().getMinX() > escada.getFirst().getMinX() && this.getRectangle().getMaxX() < escada.getFirst().getMaxX())
				{
					for(Rectangle degrau : escada)
					{
						if(ColisaoRect(degrau))
						{
							estaNaEscada = true;
							this.addPosition(new Point2D.Double(0, -1));
						}
					}
				}
			}
			
			
			if(this.getRectangle().getMinX() > escada.getFirst().getMinX() && this.getRectangle().getMaxX() < escada.getFirst().getMaxX())
				estaNaEscada = true; 
			else
			{
				estaNaEscada = false;
			}
		}
		
		
		
		Input(listPiso);
		
		super.Update();
	}
	
	public void Input(LinkedList<Rectangle> listPiso)
	{	
		
		
		if(Keyboard.getInstance().isKeyPressed(KeyEvent.VK_LEFT))
		{
			super.addPosition(new Point2D.Double(-this.getVelocity(), 0));
			animationType.y = 2;
			pressionado = true;
		}
		else if(Keyboard.getInstance().isKeyPressed(KeyEvent.VK_RIGHT))
		{
			super.addPosition(new Point2D.Double(this.getVelocity(), 0));
			animationType.y = 1;
			pressionado = true;
		}
		
		if(Keyboard.getInstance().isKeyPressed(KeyEvent.VK_SPACE) && this.velPulo == 0)
		{
			if(this.estaNoCipo)
				estaNoCipo = false;
			else
				this.velPulo = -pulo;
		}
	}
}
