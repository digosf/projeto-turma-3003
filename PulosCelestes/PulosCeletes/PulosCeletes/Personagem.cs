using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Graphics;
using Microsoft.Xna.Framework.Input;

namespace PulosCeletes
{
    public class Personagem : GameObject
    {
        public int speed = 2;
        public string sentido = "right";
        public float puloH = 9, speedy = 4;
        public bool pular = false;
        public Personagem(Vector2 position, Texture2D texture, Vector2 framesnum)
            : base(position, texture, framesnum)
        {

        }
        public override void Update(Microsoft.Xna.Framework.Rectangle clientBounds)
        {
            Pulo();

            if (Keyboard.GetState().IsKeyDown(Keys.Left) && Position.X > 0)
            {
                Position.X -= speed;
                sentido = "left";
                Animation(1, 8);// passando os valores que o metodo animation pede a determinada linha e o tempo de espera
            }
            else if (Keyboard.GetState().IsKeyDown(Keys.Right) && Position.X < clientBounds.Width - Rectangle.Width)
            {
                Position.X += speed;
                sentido = "right";
                Animation(3, 8);// passando os valores que o metodo animation pede a determinada linha e o tempo de espera
            }
            
            base.Update(clientBounds);
        }
        public void Pulo()
        {

            if (pular == true)
            {
                Position.Y -= puloH;
                puloH -= 0.25f;
                speedy = 0;
                if (puloH <= -5)
                {
                    puloH = 9;
                    pular = false;
                    speedy = 4;

                }
            }
        }
    }
}

