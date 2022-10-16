using System;
using System.Collections.Generic;
using System.Text;

namespace CarClassLibrary
{
   public class Car
    {
        public String  Make { get; set; }
        public String Model { get; set; }
        public Decimal Price { get; set; }

        public Car ()
        {
            Make = "none";
            Model = "none";
            Price = 1200M;

        }

        public Car(String a, String b, decimal c)
        {
            Make = a;
            Model = b;
            Price = c;
        }

       override public string ToString()
        {
            return " Make: " + Make + " Model: " + Model + " Price= $" + Price;
        }

    }


}
