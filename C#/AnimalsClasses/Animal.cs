using System;
using System.Collections.Generic;
using System.Text;

namespace AnimalsClasses
{
    abstract class Animal
    {
        Boolean isAlive { get; set; }
        int weight { get; set; }

        public Animal()
        {
            Console.WriteLine("animal constractor");

        }
        public Animal(Boolean isAlive, int w)
        {
            this.isAlive = isAlive;
            this.weight = w;

        }

        public void Greet()
        {
            Console.WriteLine("hello");
        }

        public void Talk()
        {
            Console.WriteLine("animal talking");
        }

        public void Sing()
        {
            Console.WriteLine("lalala");
        }

        public string ToString()
        {
            return "Status: " + isAlive + " weight: " + weight;
        }

    }
}
