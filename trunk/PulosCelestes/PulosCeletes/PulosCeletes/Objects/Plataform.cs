using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Graphics;

namespace PulosCeletes
{
    public class Plataform : GameObject
    {
        public int contador;
        public bool Colidiu = false;
        public bool pontoDado = false;
        public float Speed;
        public Plataform(Vector2 position, Texture2D texture,Vector2 numeroFrames, float speed)
            :base(position, texture, numeroFrames)
        {
            Speed = speed;
        }
        public override void Update(Rectangle clientBounds)
        {
            if (Colidiu == true)
            {
                contador++;
            }
            Position.Y += Speed;
            base.Update(clientBounds);
        }
    }
}
