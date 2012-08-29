using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Graphics;

namespace PulosCeletes
{
    class Enemy : GameObject
    {
        public Enemy(Vector2 position, Texture2D texture, Vector2 numeroFrames)
            : base(position, texture, numeroFrames)
        {
        }
    }
}
