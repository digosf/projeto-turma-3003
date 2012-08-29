using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Graphics;
using Microsoft.Xna.Framework.Input;

namespace PulosCeletes
{
    public class Player : GameObject
    {
        public int Speed = 5;
        public float speedY = 5;
        float hPulo = 7;
        public bool pular = false;        
        public Player(Vector2 position, Texture2D texture, Vector2 numeroFrames)
            :base(position, texture, numeroFrames)
        {
        }
        public override void Update(Rectangle clientBounds)
        {
            Position.Y += speedY;
            if (Keyboard.GetState().IsKeyDown(Keys.Left) && Position.X >= 0)
            {
                Position.X -= Speed;
                foreach (Plataform a in PlataformManager.listPlat)
                {
                    if (Collision(a))
                    {
                        Animation(1,7);
                    }
                    else
                    {
                        Animation(2,7);
                    }
                }
            }
            else if (Keyboard.GetState().IsKeyDown(Keys.Left) && Position.X <= 0)
            {
                float value = Position.Y;
                Position = new Vector2(800 - Rectangle.Width, value);
                foreach (Plataform a in PlataformManager.listPlat)
                {
                    if (Collision(a))
                    {
                        Animation(1, 7);
                    }
                    else
                    {
                        Animation(2,7);
                    }
                }
            }
            if (Keyboard.GetState().IsKeyDown(Keys.Right) && Position.X <= 800 - Rectangle.Width)
            {
                Position.X += Speed;
                foreach (Plataform a in PlataformManager.listPlat)
                {
                    if (Collision(a))
                    {
                       Animation(3,7);
                    }
                    else
                    {
                        Animation(2,7);
                    }
                }
            }
            else if (Keyboard.GetState().IsKeyDown(Keys.Right) && Position.X >= 800 - Rectangle.Width)
            {
                float value = Position.Y;
                Position = new Vector2(0, value);
                foreach (Plataform a in PlataformManager.listPlat)
                {
                    if (Collision(a))
                    {
                        Animation(3,7);
                    }
                    else
                    {
                        Animation(2,7);
                    }
                }
            }
            Pulo();
            
            base.Update(clientBounds);
        }
        public void Pulo()
        {
            if (pular == true)
            {
                Position.Y -= hPulo;
                if (hPulo > 0)
                {
                    hPulo -= 0.2f;
                    Animation(0,7);
                }
                else
                {
                    Animation(2,7);
                    hPulo -= 0.4f;
                }
                speedY = 0;
                if (hPulo <= -5)
                {
                    hPulo = 7;
                    pular = false;
                    speedY = 5;
                }
            }
        }
    }
}
