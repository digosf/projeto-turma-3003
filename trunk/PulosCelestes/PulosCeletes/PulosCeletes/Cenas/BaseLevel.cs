using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Graphics;
using Microsoft.Xna.Framework.Input;

namespace PulosCeletes
{
    class BaseLevel : Scene
    {
        protected Background back;
        public Player player;
        //protected PlataformManager platManager;
        public BaseLevel(Game game)
            : base(game)
        {
            //platManager = new PlataformManager(Game);
            PlataformManager.Start(game);
            player = new Player(new Vector2(350, 0), game.Content.Load<Texture2D>("claudius"), new Vector2(4, 6));
            back = new Background(Vector2.Zero, Game.Content.Load<Texture2D>(@"Images/FundoGame"), Vector2.One, new Vector2(800, 600), false);
        }
        public override void Update(GameTime gameTime)
        {
            PlataformManager.Update(Game.Window.ClientBounds);
            back.Update(Game.Window.ClientBounds);
            player.Update(Game.Window.ClientBounds);
            foreach (Plataform a in PlataformManager.listPlat)
            {
                if (player.Collision(a) && player.Position.Y + player.Rectangle.Height >= a.Position.Y && player.Position.Y + player.Rectangle.Height <= a.Position.Y + 6)
                {
                    a.Colidiu = true;
                    float p = player.Position.X;
                    player.Position = new Vector2(p, a.Position.Y - player.Rectangle.Width);
                    if (Keyboard.GetState().IsKeyDown(Keys.Up))
                    {
                        player.pular = true;
                        player.Pulo();
                    }

                    if (a.pontoDado == false)
                    {
                        a.pontoDado = true;
                    }
                }
            }
            base.Update(gameTime);
        }
        public override void Draw(GameTime gameTime)
        {
            spriteBatch.Begin();
            back.ParalaxY(spriteBatch);
            spriteBatch.End();
            PlataformManager.Draw(spriteBatch);
            player.Draw(spriteBatch);
            base.Draw(gameTime);
        }
    }
}

