using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Graphics;

namespace PulosCeletes
{
    class Opening : Scene
    {
        Background back;
        int Count;
        public Opening(Game game)
            : base(game)
        {
            // logo da escola
            back = new Background(Vector2.Zero, Game.Content.Load<Texture2D>(@"Images/FundoMenu"), Vector2.One, new Vector2(800,600), false);
        }
        public override void Update(GameTime gameTime)
        {
            back.Update(Game.Window.ClientBounds);
            Count++;
            if (Count >= 60)
            {
                //Imagem da Marca da empresa
                back.Texture = Game.Content.Load<Texture2D>(@"Images/empresa");
                back.framesNumero = new Vector2(1, 1);
            }
            if (Count > 130)
            {
                SceneManager.ChangeScene(Game);
            }
            base.Update(gameTime);
        }
        public override void Draw(GameTime gameTime)
        {
            spriteBatch.Begin();
            back.Draw1(spriteBatch);
            spriteBatch.End();
            base.Draw(gameTime);
        }
    }
}
