using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Microsoft.Xna.Framework;

namespace PulosCeletes
{
    class SceneManager
    {
        static public Scenes currentScene;
        static public Scene scene = null;
        static public string mode = "LEVEL01";
        static public bool gameOver = false;
        static public void Setup(Game game)
        {
            game.Components.Clear();
            mode = "HELP";
            currentScene = Scenes.OPENING;
            scene = new Opening(game);
            game.Components.Add(SceneManager.scene);
        }
        public static void ChangeScene(Game game)
        {
            game.Components.Clear();
            switch (currentScene)
            {
                case Scenes.OPENING:
                    currentScene = Scenes.MENU;
                    scene = new Menu(game);
                    break;
                case Scenes.MENU:
                    if (mode == "RANKING")
                    {
                        currentScene = Scenes.OPENING;
                        scene = new Opening(game);
                    }
                    else if (mode == "CREDITOS")
                    {
                        currentScene = Scenes.CREDITOS;
                        scene = new Creditos(game);
                    }
                    else if (mode == "INSTRUCTIONS")
                    {
                        currentScene = Scenes.INSTRUCTIONS;
                        scene = new Instructions(game);
                    }
                    else if (mode == "LEVEL01")
                    {
                        currentScene = Scenes.LEVEL01;
                        scene = new Level01(game);
                    }
                    else if (mode == "SURVIVE")
                    {
                        currentScene = Scenes.SURVIVE;
                        scene = new Survive(game);
                    }
                    break;
                case Scenes.CREDITOS:
                    currentScene = Scenes.MENU;
                    scene = new Menu(game);
                    break;
                case Scenes.INSTRUCTIONS:
                    currentScene = Scenes.MENU;
                    scene = new Menu(game);
                    break;
                case Scenes.RANKING:
                    currentScene = Scenes.MENU;
                    scene = new Menu(game);
                    break;
                case Scenes.LEVEL01:
                    if (gameOver == false)
                    {
                        SceneManager.scene = new Level02(game);
                        SceneManager.currentScene = Scenes.LEVEL02;
                        break;
                    }
                    else
                    {
                        SceneManager.scene = new GameOver(game);
                        SceneManager.currentScene = Scenes.GAMEOVER;
                        break;
                    } 
                case Scenes.GAMEOVER:
                    SceneManager.scene = new Menu(game);
                    SceneManager.currentScene = Scenes.MENU;
                    break;
                
            }
            game.Components.Add(SceneManager.scene);
        }
        public enum Scenes
        {
            MENU,
            RANKING,
            CREDITOS,
            OPENING,
            SURVIVE,
            LEVEL01,
            LEVEL02,
            INSTRUCTIONS,
            GAMEOVER,

            

        }
    }
}
