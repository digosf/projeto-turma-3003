using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Graphics;

namespace PulosCeletes
{
    public abstract class GameObject
    {
        public Vector2 Position;
        public  Texture2D Texture;
        public Rectangle Rectangle;
        public int currentI = 0, currentJ = 0;
        public Vector2 framesNumero, tamanhoFrame;
        public GameObject(Vector2 position, Texture2D texture,Vector2 numeroFrames)
        {            
            this.Position = position;
            this.Texture = texture;
            framesNumero = numeroFrames;
            tamanhoFrame = new Vector2(Texture.Width / framesNumero.Y, Texture.Height / framesNumero.X);
            this.Rectangle = new Rectangle((int)this.Position.X,
                                           (int)this.Position.Y,
                                           this.Texture.Width / (int)framesNumero.X,
                                           this.Texture.Height / (int)framesNumero.Y);
        }

        public virtual void Update(Rectangle clientBounds)
        {
            this.Rectangle = new Rectangle((int)this.Position.X,
                                           (int)this.Position.Y,
                                           this.Rectangle.Width,
                                           this.Rectangle.Height);
        }
        int animationCount;
        // variavel movimento, pede a linha(como se fosse matriz) da imagem em que os sprites da animação esta ocorrendo - 1
        // delay é  intervalo de tempo entre a troca de frame
        public void Animation(int Movimento, int Delay)
        {
            animationCount++;           
            if (animationCount >= Delay)
            {
                if (Movimento == currentI) { } else { currentJ = 0; }
                animationCount = 0;
                currentI = Movimento;
                currentJ++;
                if (currentJ >= framesNumero.Y)
                {
                    currentJ = 1;
                }
            }
            
        }
        public void Draw(SpriteBatch spriteBatch)
        {
            spriteBatch.Begin();
            spriteBatch.Draw(Texture, Position, new Rectangle((int)(currentJ * tamanhoFrame.X),
                    (int)(currentI * tamanhoFrame.Y), (int)(tamanhoFrame.X), (int)(tamanhoFrame.Y)), Color.White);
            spriteBatch.End();
        }

        public bool Collision(GameObject gameObject)
        {
            return this.Rectangle.Intersects(gameObject.Rectangle);
        }
    }
}

