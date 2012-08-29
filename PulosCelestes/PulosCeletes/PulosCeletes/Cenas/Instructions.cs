using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Input;
using Microsoft.Xna.Framework.Graphics;

namespace PulosCeletes
{
    class Instructions : Scene
    {
        Background back;
        Background voltar;
        public Instructions(Game game)
            : base(game)
        {
            back = new Background(Vector2.Zero, Game.Content.Load<Texture2D>(@"Images/FundoInstrucao"), Vector2.One, new Vector2(800,600), false);
            voltar = new Background(new Vector2 (550, 500), Game.Content.Load<Texture2D>(@"Images/Voltar"), Vector2.One, new Vector2(270, 80),false);
        }
        public override void Update(GameTime gameTime)
        {
            voltar.Update(Game.Window.ClientBounds);
            back.Update(Game.Window.ClientBounds);
            voltar.Texture = Game.Content.Load<Texture2D>(@"Images/Voltar");
            if (voltar.Rectangle.Contains(Mouse.GetState().X, Mouse.GetState().Y))
            {
                voltar.Texture = Game.Content.Load<Texture2D>(@"Images/VoltarUp");
                if (Mouse.GetState().LeftButton == ButtonState.Pressed)
                {
                    SceneManager.ChangeScene(Game);
                }
            }
            base.Update(gameTime);
        }
        public override void Draw(GameTime gameTime)
        {
            spriteBatch.Begin();
            back.Draw1(spriteBatch);
            voltar.Draw1(spriteBatch);
            spriteBatch.End();
            base.Draw(gameTime);
        }
    }
}
