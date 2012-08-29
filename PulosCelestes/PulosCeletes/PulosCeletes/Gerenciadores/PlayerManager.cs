using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Graphics;
using Microsoft.Xna.Framework.Input;

namespace PulosCeletes
{
    public class PlayerManager
    {
        public Player player;

        public PlayerManager(Game game)
        {
            player = new Player(new Vector2(350, 0), game.Content.Load<Texture2D>("claudius"), new Vector2(4, 6));
        }
        public void Update1(Rectangle clientBounds)
        {
            player.Update(clientBounds);

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
            
        }
        public void Draw1(SpriteBatch s)
        {
            player.Draw(s);
        }
    }
}
