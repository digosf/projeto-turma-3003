using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Graphics;

namespace PulosCeletes
{
    public abstract class Scene : Microsoft.Xna.Framework.DrawableGameComponent
    {
        protected SpriteBatch spriteBatch;
        public Scene(Game game)
            : base(game)
        {
            spriteBatch = new SpriteBatch(Game.GraphicsDevice);
        }

    }
}
