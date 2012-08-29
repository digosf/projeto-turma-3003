using System;
using System.Collections.Generic;
using System.Linq;
using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Audio;
using Microsoft.Xna.Framework.Content;
using Microsoft.Xna.Framework.GamerServices;
using Microsoft.Xna.Framework.Graphics;
using Microsoft.Xna.Framework.Input;
using Microsoft.Xna.Framework.Media;

namespace PulosCeletes
{
    public class Game1 : Microsoft.Xna.Framework.Game
    {
        GraphicsDeviceManager graphics;
        SpriteBatch spriteBatch;
        //Personagem p;
        //JonesJumping j;
        public Game1()
        {
            graphics = new GraphicsDeviceManager(this);
            Content.RootDirectory = "Content";
            graphics.PreferredBackBufferWidth = 800;
            graphics.PreferredBackBufferHeight = 600;
        }
        protected override void Initialize()
        {
            IsMouseVisible = true;
            SceneManager.Setup(this);
            base.Initialize();
        }
        protected override void LoadContent()
        {
            spriteBatch = new SpriteBatch(GraphicsDevice);
            //p = new Personagem(new Vector2(400, 400), Content.Load<Texture2D>("claudius"), new Vector2(4, 6));// 4 é o numero de linhas q tem a imagem e 6 o de colunas
            //j = new JonesJumping(new Vector2(400, 300), Content.Load<Texture2D>("Jump"), new Vector2(1,11));
        }
        protected override void UnloadContent()
        {
        }
        protected override void Update(GameTime gameTime)
        {
            if (GamePad.GetState(PlayerIndex.One).Buttons.Back == ButtonState.Pressed)
                this.Exit();
            //p.Update(Window.ClientBounds);
            //j.Update(Window.ClientBounds);
            base.Update(gameTime);
        }
        protected override void Draw(GameTime gameTime)
        {
            GraphicsDevice.Clear(Color.CornflowerBlue);
            //p.Draw(spriteBatch);
            //j.Draw(spriteBatch);
            base.Draw(gameTime);
        }
    }
}
