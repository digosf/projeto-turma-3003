package Hero;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Painel
{
	float sizePower = 400;
	float timer = 0;
	Rectangle barAmarela, barVermelha;
	Font pontuacao;
	public static boolean iniciarContagemPoints;
	public static boolean passarlevel;
	
	public Painel(int point) 
	{		
		this.sizePower = point;
		barVermelha = new Rectangle(230, 460, 400, 15);
		barAmarela = new Rectangle(230, 460, (int)sizePower, 15);
		
		pontuacao = new Font("ARIAL", 1, 20);
		passarlevel = false;
	}
	
	public void Update()
	{
		timer ++;
		
		if(timer >= 240)
		{
			sizePower -= 0.05f;
		}
		
		if(sizePower <= 0)
		{
			sizePower = 0;
			passarlevel = true;
		}
		
		if(iniciarContagemPoints == true)
		{
			sizePower -= 5;
			if(sizePower > 0)
			{
				Player.score += 35;
			}
		}
	}
	
	public void draw(Graphics2D g) 
	{		
		g.drawImage(LoadImages.getImage(4), (int)barVermelha.getX(), (int)barVermelha.getY(), (int)barVermelha.getWidth(), (int)barVermelha.getHeight(), null);
		g.drawImage(LoadImages.getImage(3), (int)barAmarela.getX(), (int)barAmarela.getY(), (int)sizePower, (int)barAmarela.getHeight(), null);
		
		g.setFont(pontuacao);
		
		if(Player.qtdVida == 1)
		{
			g.drawImage(LoadImages.getImage(12), 600, 480, 20, 40, null);
		}
		else if(Player.qtdVida == 2)
		{
			g.drawImage(LoadImages.getImage(12), 600, 480, 20, 40, null);
			g.drawImage(LoadImages.getImage(12), 550, 480, 20, 40, null);
		}
		else if(Player.qtdVida == 3)
		{
			g.drawImage(LoadImages.getImage(12), 600, 480, 20, 40, null);
			g.drawImage(LoadImages.getImage(12), 550, 480, 20, 40, null);
			g.drawImage(LoadImages.getImage(12), 500, 480, 20, 40, null);
		}
		
		
		//granada imagem
		if(Player.qtdGranada == 1)
		{
			g.drawImage(LoadImages.getImage(13), 600, 520, 20, 30, null);
		}
		else if(Player.qtdGranada == 2)
		{
			g.drawImage(LoadImages.getImage(13), 600, 520, 20, 30, null);
			g.drawImage(LoadImages.getImage(13), 550, 520, 20, 30, null);
		}
		else if(Player.qtdGranada == 3)
		{
			g.drawImage(LoadImages.getImage(13), 600, 520, 20, 30, null);
			g.drawImage(LoadImages.getImage(13), 550, 520, 20, 30, null);
			g.drawImage(LoadImages.getImage(13), 500, 520, 20, 30, null);
		}
		else if(Player.qtdGranada == 4)
		{
			g.drawImage(LoadImages.getImage(13), 600, 520, 20, 30, null);
			g.drawImage(LoadImages.getImage(13), 550, 520, 20, 30, null);
			g.drawImage(LoadImages.getImage(13), 500, 520, 20, 30, null);
			g.drawImage(LoadImages.getImage(13), 450, 520, 20, 30, null);
		}
		else if(Player.qtdGranada == 5)
		{
			g.drawImage(LoadImages.getImage(13), 600, 520, 20, 30, null);
			g.drawImage(LoadImages.getImage(13), 550, 520, 20, 30, null);
			g.drawImage(LoadImages.getImage(13), 500, 520, 20, 30, null);
			g.drawImage(LoadImages.getImage(13), 450, 520, 20, 30, null);
			g.drawImage(LoadImages.getImage(13), 400, 520, 20, 30, null);
		}
		
		
		g.setColor(Color.WHITE);
		g.drawString("" + Player.score, 450, 575);
		
	}
}
