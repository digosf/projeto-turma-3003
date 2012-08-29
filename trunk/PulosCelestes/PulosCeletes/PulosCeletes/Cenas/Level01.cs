using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Graphics;
namespace PulosCeletes
{
    class Level01 : BaseLevel
    {
        int Count;

        public Level01(Game game)
            : base(game)
        {
        }
        public override void Update(GameTime gameTime)
        {
            PlataformManager.ControlSpeed(1);
            Count++;
            if (Count > 38)
            {
                Count = 0;
                PlataformManager.CreatePlataforms(Game);
            }
            base.Update(gameTime);
        }
        public override void Draw(GameTime gameTime)
        {
            base.Draw(gameTime);
        }
    }
}
