using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Input;
using Microsoft.Xna.Framework.Graphics;

namespace PulosCeletes
{
    class Menu : Scene
    {
        Background background { get; set; }
        Texture2D imgHelp, imgInicio, imgExit, imgRanking, imgHistory, imgSurvive;
        bool chosingLevel = false;
        int count;
        Rectangle AreaMenuInicio = new Rectangle(30, 230, 270, 80),
             AreaMenuHelp = new Rectangle(30, 330, 270, 80),
             AreaMenuRanking = new Rectangle(30, 430, 270, 80),
             AreaMenuExit = new Rectangle(550, 500, 270, 80),
             AreaMenuHistory = new Rectangle(265, 300, 270, 80),
             AreaMenuSurvive = new Rectangle(265, 500, 270, 80);
        public Menu(Game game)
            : base(game)
        {
            background = new Background(Vector2.Zero, Game.Content.Load<Texture2D>(@"Images/FundoMenu"),Vector2.One, new Vector2(800, 600),false);
            imgHelp = Game.Content.Load<Texture2D>(@"Images/Instruções");
            imgInicio = Game.Content.Load<Texture2D>(@"Images/Novo Jogo");
            imgRanking = Game.Content.Load<Texture2D>(@"Images/Ranking");
            imgExit = Game.Content.Load<Texture2D>(@"Images/Sair");
            imgHistory = Game.Content.Load<Texture2D>(@"Images/Novo Jogo");
            imgSurvive = Game.Content.Load<Texture2D>(@"Images/Novo Jogo");
        }
        public override void Update(GameTime gameTime)
        {
            imgHelp = Game.Content.Load<Texture2D>(@"Images/Instruções");
            imgInicio = Game.Content.Load<Texture2D>(@"Images/Novo Jogo");
            imgRanking = Game.Content.Load<Texture2D>(@"Images/Ranking");
            imgExit = Game.Content.Load<Texture2D>(@"Images/Sair");


            imgHistory = Game.Content.Load<Texture2D>(@"Images/Novo Jogo");
            imgSurvive = Game.Content.Load<Texture2D>(@"Images/Novo Jogo");
            count++;
            MouseState mouse = Mouse.GetState();
            if (!chosingLevel)
            {
                if (AreaMenuHelp.Contains(mouse.X, mouse.Y))
                {
                    imgHelp = Game.Content.Load<Texture2D>(@"Images/InstruçõesUp");
                    if (mouse.LeftButton == ButtonState.Pressed)
                    {
                        SceneManager.mode = "INSTRUCTIONS";
                        SceneManager.ChangeScene(Game);
                    }
                }
                if (AreaMenuInicio.Contains(mouse.X, mouse.Y))
                {
                    imgInicio = Game.Content.Load<Texture2D>(@"Images/Novo JogoUp");
                    if (mouse.LeftButton == ButtonState.Pressed)
                    {
                        chosingLevel = true;
                    }

                }
                if (AreaMenuRanking.Contains(mouse.X, mouse.Y))
                {
                    imgRanking = Game.Content.Load<Texture2D>(@"Images/RankingUp");
                    if (mouse.LeftButton == ButtonState.Pressed)
                    {
                        SceneManager.mode = "CREDITOS";
                        SceneManager.ChangeScene(Game);
                    }

                }

                if (AreaMenuExit.Contains(mouse.X, mouse.Y))
                {
                    imgExit = Game.Content.Load<Texture2D>(@"Images/SairUp");
                    if (mouse.LeftButton == ButtonState.Pressed && count > 20)
                        this.Game.Exit();
                }
            }
            else
            {
                if (AreaMenuSurvive.Contains(mouse.X, mouse.Y)) 
                {
                    imgSurvive = Game.Content.Load<Texture2D>(@"Images/InstruçõesUp");
                    if (mouse.LeftButton == ButtonState.Pressed)
                    {
                        SceneManager.mode = "SURVIVE";
                        SceneManager.ChangeScene(Game);
                    }
                }
                if (AreaMenuHistory.Contains(mouse.X, mouse.Y))
                {
                    imgHistory = Game.Content.Load<Texture2D>(@"Images/InstruçõesUp");
                    if (mouse.LeftButton == ButtonState.Pressed)
                    {
                        SceneManager.mode = "LEVEL01";
                        SceneManager.ChangeScene(Game);
                    }
                }
            }
            if (Keyboard.GetState().IsKeyDown(Keys.Escape))
            {
                chosingLevel = false;
            }
            
            background.Update(Game.Window.ClientBounds);
            base.Update(gameTime);
        }
        public override void Draw(GameTime gameTime)
        {
            spriteBatch.Begin();
            this.background.Draw1(spriteBatch);
            if (!chosingLevel)
            {
                spriteBatch.Draw(imgInicio, AreaMenuInicio, Color.White);
                spriteBatch.Draw(imgHelp, AreaMenuHelp, Color.White);
                spriteBatch.Draw(imgRanking, AreaMenuRanking, Color.White);
                spriteBatch.Draw(imgExit, AreaMenuExit, Color.White);
            }
            else
            {
                spriteBatch.Draw(imgSurvive, AreaMenuSurvive, Color.White);
                spriteBatch.Draw(imgHistory, AreaMenuHistory, Color.White);
            }
            spriteBatch.End();
            base.Draw(gameTime);
        }
    }
}
