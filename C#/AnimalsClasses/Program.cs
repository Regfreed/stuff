using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace AnimalsClasses
{
    class Program
    {
        static void Main(string[] args)
        {

            Dog fido = new Dog(false, 50);

            fido.Greet();
            fido.Sing();
            fido.Talk();
            fido.Fetch("stick");
            fido.Touchme();
            fido.FeedMe();

            Robin red = new Robin();
            red.Talk();
            red.Sing();
            Console.WriteLine(fido.ToString());

            Console.ReadLine();

        }
    }
}
