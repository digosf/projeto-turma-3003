using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Graphics;
namespace PulosCeletes
{
    class Background : GameObject
    {
        bool paralaxOn; Vector2 size;
        public Background(Vector2 position, Texture2D texture, Vector2 numeroFrames, Vector2 size, bool paralaxon)
            : base(position, texture, numeroFrames)
        {
            Rectangle = new Rectangle(Rectangle.X,Rectangle.Y, (int)size.X,(int)size.Y);
            paralaxOn = paralaxon;
            this.size = size;
        }
        public override void Update(Rectangle clientBounds)
        {
            Animation(0, 7);
            base.Update(clientBounds);
        }
        public void Draw1(SpriteBatch s)
        {
            if (!paralaxOn)
                s.Draw(Texture, Rectangle, Color.White);
            
            //s.Draw(Texture, Position, new Rectangle((int)(currentJ * tamanhoFrame.X),
              //      (int)(currentI * tamanhoFrame.Y), (int)(tamanhoFrame.X), (int)(tamanhoFrame.Y)), Color.White);
        }
        public void ParalaxY(SpriteBatch s)
        {
            Position.Y += 5;
            if (Position.Y >= 600)
                Position.Y = 0;
            else
            {
                s.Draw(Texture, new Rectangle((int)Position.X, (int)Position.Y, (int)size.X, (int)size.Y), Color.White);
                s.Draw(Texture, new Rectangle((int)Position.X, (int)Position.Y - 600, (int)size.X, (int)size.Y), Color.White);
            }
        }
        public void ParalaxX(SpriteBatch s)
        {
            Position.X -= 5;
            if (Position.X <= -800)
                Position.X = 0;
            else
            {
                s.Draw(Texture, new Rectangle((int)Position.X, (int)Position.Y, (int)size.X, (int)size.Y), Color.White);
                s.Draw(Texture, new Rectangle((int)Position.X + 800, (int)Position.Y, (int)size.X, (int)size.Y), Color.White);
            }
        }
    }
}
