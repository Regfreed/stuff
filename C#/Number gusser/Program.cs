using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Number_gusser
{
    // main class
    class Program
    {
        // Entry point method
        static void Main(string[] args)
        {
            GetAppInfo();

            ReadUser();


            while (true)
            {
                Random random = new Random();

                int correctNumber = random.Next(1, 10);

                int guess = 0;

                Console.WriteLine("Guess a number between 1  and 10 ");

                while (guess != correctNumber)
                {
                    string input = Console.ReadLine();
                    if (!int.TryParse(input, out guess))
                    {
                        Console.ForegroundColor = ConsoleColor.Red;
                        Console.WriteLine(" please enter a nummber");
                        Console.ResetColor();
                        continue;
                    }

                    guess = Int32.Parse(input);

                    if (guess != correctNumber)
                    {
                        Console.ForegroundColor = ConsoleColor.Red;
                        Console.WriteLine("Wrong nummber, please try again");
                        Console.ResetColor();
                    }

                }

                Console.ForegroundColor = ConsoleColor.Yellow;
                Console.WriteLine("right answer");
                Console.ResetColor();

                Console.WriteLine("play again? [Y, N] ");
                string answer = Console.ReadLine().ToUpper();

                if (answer == "Y")
                {
                    continue;
                } else if (answer == "N")
                {
                    return;
                }
                else
                {
                    return;
                }
            }
        }

        static void GetAppInfo() 
        {
        

    String appName = "NummberGuesser ";
    String appVersion = "1.0.0 ";
    String appAutore = "Matej Pavic ";

    Console.ForegroundColor = ConsoleColor.Green;

            Console.WriteLine("{0}: Version {1} by {2}", appName, appVersion, appAutore);

            Console.ResetColor();
        }

        static void ReadUser()
        {
            Console.WriteLine("What is your name");
            String inputName = Console.ReadLine();

            Console.WriteLine("Hello {0}, let's play a game... ", inputName);
        }
    }
} 
