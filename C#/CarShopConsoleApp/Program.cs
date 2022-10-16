using CarClassLibrary;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CarShopConsoleApp
{
    class Program
    {
        static void Main(string[] args)
        {

            Store s = new Store();

            Console.WriteLine("welcome to shop");

            int action = chooseAction();

            while ( action != 0)
            {

                Console.WriteLine("You choose " + action);

                switch( action)
                {
                    case 1:
                        Console.WriteLine("You chouse to add new car to inventory");

                        string carMake ="" ;
                        string carModel = "";
                        decimal carPrice = 0;

                        Console.WriteLine("what car? ford, nissan,...");
                        carMake = Console.ReadLine();

                        Console.WriteLine("what model?");

                        carModel = Console.ReadLine();

                        Console.WriteLine("what is price?");

                        carPrice = int.Parse(Console.ReadLine());

                        Car newCar = new Car(carMake, carModel, carPrice);

                        s.CarList.Add(newCar);

                        printInventory(s);
                        break;

                    case 2:

                        Console.WriteLine("choose to add a car to shooping cart");
                        printInventory(s);
                        Console.WriteLine("which item would you like to buy? (number)");

                        int carChosen = int.Parse(Console.ReadLine());

                        s.ShoppingList.Add(s.CarList[carChosen]);
                        PrintShoppingCart(s);

                        break;


                   case 3:
                        PrintShoppingCart(s);
                        Console.WriteLine("the total cost is: $" + s.Checkout());

                        break;

                }

                action = chooseAction();
            }

        }

        private static void PrintShoppingCart(Store s)
        {
            Console.WriteLine("cars you have choose to buy");
            for (int i = 0; i < s.ShoppingList.Count; i++)
            {
                Console.WriteLine("car # : " + i + " " + s.ShoppingList[i]);
            }
        }

        private static void printInventory(Store s)
        {
           for(int i = 0; i < s.CarList.Count ; i++)
            {
                Console.WriteLine("car # : "+ i + " " + s.CarList[i]);
            }
        }

        static public int chooseAction()
        {
            int choice = 0;
            Console.WriteLine("choose action: (0) = quit, (1) = add a car to invenntory, (2) = ad a car to cart, (3) = checkout" );

            choice = int.Parse(Console.ReadLine());
            return choice;
        }

    }
}
