using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Microsoft.Xna.Framework.Graphics;
using Microsoft.Xna.Framework;
namespace PulosCeletes
{
    class Shoot : GameObject
    {
        public Shoot(Vector2 position, Texture2D texture, Vector2 numeroFrames)
            : base(position, texture, numeroFrames)
        {
        }

    }
}
