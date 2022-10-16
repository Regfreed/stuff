using ModelŠahovnice;
using System;

namespace ŠahConsoleApp
{
    class Program
    {
        
       static Ploca mojaPloca ;

        static void Main(string[] args)
        {
            // vrijednost velicine ploce 
            try
            {
                Console.WriteLine("unesi kvadratnu dimenziju polja (max 8, min 3)");
                int s = int.Parse(Console.ReadLine());
                if (s < 3 || s > 8)
                {
                    Console.WriteLine("netočni podatci, defoultna vrijednost 3");
                    s = 3;
                }

                mojaPloca = new Ploca(s);


            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.Message + " defoultna vrijednost 3");
                mojaPloca = new Ploca(3);
            }
         
            
            // pokazi praznu plocu

            NacrtajPlocu(mojaPloca);

            // traui korisnika koordinate figure

            Celija trenutnaCelija = PostaviCeliju();
            trenutnaCelija.TrenutnoZauzeto = true;

            // izracunaj sve dopustene kretnje

            Console.WriteLine("odaberi figuru (Knight, King, Bishop, Tower or Queen )");
            mojaPloca.OznaciDopustenuKretnju(trenutnaCelija, Console.ReadLine());  

            // ispisi plocu i pokazi zauzeto mjesto (x) i legalno mjesto (+), prazno polje (.)

            NacrtajPlocu(mojaPloca);


            //traži enter za prekid igre

            Console.ReadLine();

        }

        private static Celija PostaviCeliju()
        {

            //uzimanje x/y koordinata i vračanje nazad.
            int i = 0;
            int trenutniRedak = 1;
            int trenutniStupac = 1;
            while ( i == 0){
                try
                {
                    Console.WriteLine("Unesi red zatim stupac polja");

                    
               
                     trenutniRedak = int.Parse(Console.ReadLine()) - 1;

                     trenutniStupac = int.Parse(Console.ReadLine()) - 1;
                    if (trenutniRedak < 8 && trenutniRedak >= 0 && trenutniStupac < 8 && trenutniStupac >= 0)
                    {
                        i++;
                    }
                    else 
                    {
                        Console.WriteLine("red ili stupac je van dosega, molimo pokuaj ponovno");
                    }
                }
                catch (Exception ex)
                {
                    Console.WriteLine("Error : "  + ex.Message + " Please try again");
                    
                }
                
                
              
            }
            return mojaPloca.MojaPloca[trenutniRedak, trenutniStupac];


        }

        private static void NacrtajPlocu(Ploca myBoard)
        {
            // printanje ploce na konzoli 
           
            for (int i = 0; i < myBoard.Velicina; i++)
            {
                for (int e = 0; e < myBoard.Velicina; e++)
                {
                    Console.Write("+---");

                }
                Console.Write("+");

                Console.WriteLine();
                for (int j = 0; j < myBoard.Velicina; j++)
                {
                    
                    Celija c = myBoard.MojaPloca[i, j];

                    if(c.TrenutnoZauzeto == true)
                    {
                        Console.Write("| x ");
                    }
                    else if (c.DopusteniPotez == true)
                    {
                        Console.Write("| + ");
                    }
                    else
                    {
                        Console.Write("|   ");
                    }

                }
                Console.Write("|");
                Console.WriteLine();
                
            }
            for (int e = 0; e < myBoard.Velicina; e++)
            {
                Console.Write("+---");

            }
            Console.Write("+");

            Console.WriteLine();
            Console.WriteLine("===================================");

        }
    }
}
