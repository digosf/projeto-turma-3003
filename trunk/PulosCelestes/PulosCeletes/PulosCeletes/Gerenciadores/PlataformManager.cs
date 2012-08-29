using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Graphics;
using Microsoft.Xna.Framework.Input;

namespace PulosCeletes
{
    static public class PlataformManager 
    {
        static public List<Plataform> listPlat = new List<Plataform>();
        static float Speed = 2, count;
        static Random rand = new Random();
        static public void Start(Game game)
        {
            listPlat = new List<Plataform>();
            Plataform plat = new Plataform(new Vector2(350, 80), game.Content.Load<Texture2D>("BlocoPlataforma"), Vector2.One, Speed);
            listPlat.Add(plat);
            listPlat[0].contador = -900;
        }
        static public void Update(Rectangle clientsBounds)
        {
            foreach(Plataform p in listPlat)
            {
                p.Update(clientsBounds);                
            }
            try
            {
                foreach (Plataform p in listPlat)
                    if (p.contador >= 100)
                    {
                        listPlat.Remove(p);
                    }
            }
            catch
            {
                return;
            }

        }
        static public void CreatePlataforms(Game game)
        {
            Plataform plat = new Plataform(new Vector2(rand.Next(750), -30), game.Content.Load<Texture2D>("BlocoPlataforma"),Vector2.One, Speed);
            listPlat.Add(plat);
        }
        static public void Draw(SpriteBatch s)
        {
            foreach (Plataform p in listPlat)
            {
               p.Draw(s);
            }

        }
        static public void ControlSpeed(int Level)
        {
            if (Level == 1)
            {
                count++;
                if (count > 250)
                {
                    count = 0;
                    Speed += 0.085f;
                }
            }
            if (Level == 2)
            {
                count++;
                if (count > 210)
                {
                    Speed += 0.160f;
                }
            }
            if (Level == 3)//survive
            {
                count++;
                if (count > 240)
                {
                    Speed += 0.145f;
                }
            }
        }
    }
}
