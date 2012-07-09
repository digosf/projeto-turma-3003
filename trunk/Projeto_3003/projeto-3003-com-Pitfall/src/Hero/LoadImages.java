package Hero;

import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

public class LoadImages
{
	static Image[] images;
	static LoadImages instance;
	static boolean imagensCarregadas = false;
	
	static String[] stImages = new String[]{ "/images/Hero/Opening.png" , // 0 - imagem teste Opening
		"/images/Hero/Faixa.png", // 1 - imagem teste da faixa
		"/images/Hero/AnimationPlayer.png", // 2 - imagem teste da annima��o
		"/images/Hero/PixelAmarelo.png", // 3 - imagem teste do pixel amarelo
		"/images/Hero/PixelVermelho.png", // 4 - imagem teste do pixel vermelho
		"/images/Hero/Preto.png", // 5 - imagem teste do pixel vermelho
		"/images/Hero/blackpixel.png", // 6 - pixel preto
		"/images/Hero/redpixel.png", // 7 - pixel preto
		"/images/Hero/Granada.png", // 8 - bomba
		"/images/Hero/BarraVermelha.png", // 9 - barra vermelha
		"/images/Hero/BarraAmarela.png", // 10 - barra amarela
		"/images/Hero/Level01_1.png", // 11 - fase 1 - parte 1
		"/images/Hero/iconPlayer.png", // 12 - Incone do player;
		"/images/Hero/iconGranada.png", // 13 - Incone do granada;
		"/images/Hero/Level01_2.png", // 14 - Level 1 parte 2
		"/images/Hero/Refem.png", // 15 - Refem	
		"/images/Hero/Level02_1.png", // 16 - Level 2 - parte 1
		"/images/Hero/Level02_2.png", // 17 - Level 2 - parte 2
		"/images/Hero/Level02_3.png", // 18 - Level 2 - parte 3
		"/images/Hero/Level02_4.png", // 19 - Level 2 - parte 4
		"/images/Hero/Level03_1.png", // 20 - Level 3 - parte 1
		"/images/Hero/Level03_2.png", // 21 - Level 3 - parte 2
		"/images/Hero/Level03_3.png", // 22 - Level 3 - parte 3
		"/images/Hero/Level03_4.png", // 23 - Level 3 - parte 4
		"/images/Hero/Level03_5.png", // 24 - Level 3 - parte 5
		"/images/Hero/Level03_6.png", // 25 - Level 3 - parte 6
		"/images/Hero/AnimationAranha.png", // 26 - inimigo aranha
		"/images/Hero/AnimationBarata.png", // 27 -inimigo barata
		"/images/Hero/AnimationMorcego.png", // 28 - inimigo morcego
		"/images/Hero/AnimationLampada.png", // 29 - inimigo lampada
		"/images/Hero/Plataforma1.png", // 30 - imagem plataforma falsa 1
		"/images/Hero/Plataforma2.png", // 31 - imagem plataforma falsa 2
		"/images/Hero/Plataforma3.png", // 32 - imagem plataforma falsa 3
		};
	
	public void Load()
	{
		if(LoadImages.imagensCarregadas == false)
		{
			Toolkit tk = Toolkit.getDefaultToolkit();
			
			images = new Image[stImages.length];
			
			for(int i = 0; i< stImages.length; i++)
			{
				System.out.println(i);
				images[i] = tk.getImage(getURL(stImages[i]));
			}
			imagensCarregadas = true;
		}
	}
	private LoadImages(){}
	
	public static LoadImages getInstance()
	{
		if(instance == null)
			instance = new LoadImages();
		
		return instance;
	}
	private static URL getURL(String filename)
	{
		URL url = null;
		try
		{
			url = LoadImages.getInstance().getClass().getResource(filename);
		}
		catch (Exception e) { }
		return url;
	}
	public static Image getImage(int index)
	{
		return images[index];
	}
	
}