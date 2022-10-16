using System;
using System.Collections.Generic;
using System.Text;

namespace AnimalsClasses
{
    class Dog : Animal , IDomesticated
    {
        public Dog(bool isAlive, int w) : base(isAlive, w)
        {

        }

        public void Talk()
        {
            Console.WriteLine("wau wau wau");
        }

        public void Sing()
        {
            Console.WriteLine("auuuuuuu");
        }

        public void Fetch(string thing)
        {
            Console.WriteLine("ok, here is your " + thing + "that was fun let's do it again");
        }

        public void Touchme()
        {
            Console.WriteLine("please more");
        }

        public void FeedMe()
        {
            Console.WriteLine("thanks for food") ;
        }
    }
}
