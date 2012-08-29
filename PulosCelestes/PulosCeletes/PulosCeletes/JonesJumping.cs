using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Microsoft.Xna.Framework;
using Microsoft.Xna.Framework.Graphics;
using Microsoft.Xna.Framework.Input;

namespace PulosCeletes
{
    public class JonesJumping : GameObject
    {
        public int speed = 2;
        public string sentido = "right";
        public float puloH = 9, speedy = 4;
        public bool pular = false;
        public JonesJumping(Vector2 position, Texture2D texture, Vector2 framesnum)
            : base(position, texture, framesnum)
        {

        }
        public override void Update(Microsoft.Xna.Framework.Rectangle clientBounds)
        {
                Animation(0, 6);
            
            base.Update(clientBounds);
        }
       
    }
}

