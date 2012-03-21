package game;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

public class PlataformMananger 
{
	LinkedList<GameObject> objetos; 
	Random random;
	float tempo = 0;
	
	public PlataformMananger() 
	{
	}
	
	public void Update() 
	{
		tempo += System.nanoTime() / 10000000000000000.0f;
		
		if(tempo > 4)
		{
			tempo = 0;
			AdicionarPlataforma();
		}
		
		for(int i = 0; i < objetos.size(); i++)
		{
			((Plataform)objetos.get(i)).Update();
		}
	}
	
	public void Draw(Graphics g) 
	{
		for(int i = 0; i < objetos.size(); i++)
		{
			((Plataform)objetos.get(i)).Draw(g);
		}
	}
	
		
	private void AdicionarPlataforma()
	{
		this.objetos.add(new Plataform(this.random.nextInt(800), 600, 100, 20, "NomeDaImagem", null , TimeXSpeedManager.speed));
	}
}
