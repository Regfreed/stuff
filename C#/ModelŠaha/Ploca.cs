using System;
using System.Collections.Generic;
using System.Text;

namespace ModelŠahovnice
{
    public class Ploca
    {

        public int Velicina { get; set; }

        public Celija [,]  MojaPloca  { get; set; }


        // constructor
        public Ploca (int s)
        {
            // tu uzimamo broj za plocu
            Velicina = s;
            
            // tu pravimo nove celije
            MojaPloca = new Celija[Velicina, Velicina];

           // ovdije popunjavamo plocu sa x/y koordinatama
            for (int i = 0; i < Velicina; i++)
            {
                for (int j = 0; j < Velicina; j++)
                {
                    MojaPloca[i , j] = new Celija(i, j);
                }
            }


        }

        public void OznaciDopustenuKretnju( Celija TrenutnaCelija, String chessPiece)
        {
            // step1 ocistiti plocu od prijasnjih dozvoljenih kretnji

            for (int i = 0; i < Velicina; i++)
            {
                for (int j = 0; j < Velicina; j++)
                {
                    MojaPloca[i, j].DopusteniPotez = false;
                    MojaPloca[i, j].TrenutnoZauzeto = false;

                }
            }


            // step2 pronaci sve moguce kretnje i oznaciti ih na ploci

            switch (chessPiece)
            {
                case "Knight":

                    if (AkojeSigurno(TrenutnaCelija.Redak + 2, TrenutnaCelija.Stupac + 1))
                        MojaPloca[TrenutnaCelija.Redak + 2, TrenutnaCelija.Stupac + 1].DopusteniPotez = true;
                    if (AkojeSigurno(TrenutnaCelija.Redak + 2, TrenutnaCelija.Stupac - 1))
                        MojaPloca[TrenutnaCelija.Redak + 2, TrenutnaCelija.Stupac - 1].DopusteniPotez = true;
                    if (AkojeSigurno(TrenutnaCelija.Redak - 2, TrenutnaCelija.Stupac + 1))
                        MojaPloca[TrenutnaCelija.Redak - 2, TrenutnaCelija.Stupac + 1].DopusteniPotez = true;
                    if (AkojeSigurno(TrenutnaCelija.Redak - 2, TrenutnaCelija.Stupac - 1))
                        MojaPloca[TrenutnaCelija.Redak - 2, TrenutnaCelija.Stupac - 1].DopusteniPotez = true;
                    if (AkojeSigurno(TrenutnaCelija.Redak + 1, TrenutnaCelija.Stupac + 2))
                        MojaPloca[TrenutnaCelija.Redak + 1, TrenutnaCelija.Stupac + 2].DopusteniPotez = true;
                    if (AkojeSigurno(TrenutnaCelija.Redak - 1, TrenutnaCelija.Stupac + 2))
                        MojaPloca[TrenutnaCelija.Redak - 1, TrenutnaCelija.Stupac + 2].DopusteniPotez = true;
                    if (AkojeSigurno(TrenutnaCelija.Redak + 1, TrenutnaCelija.Stupac - 2))
                        MojaPloca[TrenutnaCelija.Redak + 1, TrenutnaCelija.Stupac - 2].DopusteniPotez = true;
                    if (AkojeSigurno(TrenutnaCelija.Redak - 1, TrenutnaCelija.Stupac - 2))
                        MojaPloca[TrenutnaCelija.Redak - 1, TrenutnaCelija.Stupac - 2].DopusteniPotez = true;

                    break;

                case "King":
                    if (AkojeSigurno(TrenutnaCelija.Redak + 1, TrenutnaCelija.Stupac + 1))
                        MojaPloca[TrenutnaCelija.Redak + 1, TrenutnaCelija.Stupac + 1].DopusteniPotez = true;
                    if (AkojeSigurno(TrenutnaCelija.Redak - 1, TrenutnaCelija.Stupac + 1))
                        MojaPloca[TrenutnaCelija.Redak - 1, TrenutnaCelija.Stupac + 1].DopusteniPotez = true;
                    if (AkojeSigurno(TrenutnaCelija.Redak + 1, TrenutnaCelija.Stupac - 1))
                        MojaPloca[TrenutnaCelija.Redak + 1, TrenutnaCelija.Stupac - 1].DopusteniPotez = true;
                    if (AkojeSigurno(TrenutnaCelija.Redak - 1, TrenutnaCelija.Stupac - 1))
                        MojaPloca[TrenutnaCelija.Redak - 1, TrenutnaCelija.Stupac - 1].DopusteniPotez = true;
                    if (AkojeSigurno(TrenutnaCelija.Redak, TrenutnaCelija.Stupac + 1))
                        MojaPloca[TrenutnaCelija.Redak, TrenutnaCelija.Stupac + 1].DopusteniPotez = true;
                    if (AkojeSigurno(TrenutnaCelija.Redak, TrenutnaCelija.Stupac - 1))
                        MojaPloca[TrenutnaCelija.Redak, TrenutnaCelija.Stupac - 1].DopusteniPotez = true;
                    if (AkojeSigurno(TrenutnaCelija.Redak + 1, TrenutnaCelija.Stupac))
                        MojaPloca[TrenutnaCelija.Redak + 1, TrenutnaCelija.Stupac].DopusteniPotez = true;
                    if (AkojeSigurno(TrenutnaCelija.Redak - 1, TrenutnaCelija.Stupac))
                        MojaPloca[TrenutnaCelija.Redak - 1, TrenutnaCelija.Stupac].DopusteniPotez = true;

                    break;

                case "Bishop":
                    for (int i = 1; i < Velicina; i++)
                    {
                        if (AkojeSigurno(TrenutnaCelija.Redak + i, TrenutnaCelija.Stupac + i))
                            MojaPloca[TrenutnaCelija.Redak + i, TrenutnaCelija.Stupac + i].DopusteniPotez = true;
                    }
                    for (int i = 1; i < Velicina; i++)
                    {
                        if (AkojeSigurno(TrenutnaCelija.Redak - i, TrenutnaCelija.Stupac - i))
                            MojaPloca[TrenutnaCelija.Redak - i, TrenutnaCelija.Stupac - i].DopusteniPotez = true;
                    }
                    for (int i = 1; i < Velicina; i++)
                    {
                        if (AkojeSigurno(TrenutnaCelija.Redak - i, TrenutnaCelija.Stupac + i))
                            MojaPloca[TrenutnaCelija.Redak - i, TrenutnaCelija.Stupac + i].DopusteniPotez = true;
                    }
                    for (int i = 1; i < Velicina; i++)
                    {
                        if (AkojeSigurno(TrenutnaCelija.Redak + i, TrenutnaCelija.Stupac - i))
                            MojaPloca[TrenutnaCelija.Redak + i, TrenutnaCelija.Stupac - i].DopusteniPotez = true;
                    }
                   
                    break;

                case "Queen":
                    for (int i = 1; i < Velicina; i++)
                    {
                        if (AkojeSigurno(TrenutnaCelija.Redak + i, TrenutnaCelija.Stupac + i))
                            MojaPloca[TrenutnaCelija.Redak + i, TrenutnaCelija.Stupac + i].DopusteniPotez = true;
                    
                        if (AkojeSigurno(TrenutnaCelija.Redak - i, TrenutnaCelija.Stupac - i))
                            MojaPloca[TrenutnaCelija.Redak - i, TrenutnaCelija.Stupac - i].DopusteniPotez = true;
                    
                        if (AkojeSigurno(TrenutnaCelija.Redak - i, TrenutnaCelija.Stupac + i))
                            MojaPloca[TrenutnaCelija.Redak - i, TrenutnaCelija.Stupac + i].DopusteniPotez = true;
                  
                        if (AkojeSigurno(TrenutnaCelija.Redak + i, TrenutnaCelija.Stupac - i))
                            MojaPloca[TrenutnaCelija.Redak + i, TrenutnaCelija.Stupac - i].DopusteniPotez = true;
                
                        if (AkojeSigurno(TrenutnaCelija.Redak , TrenutnaCelija.Stupac + i))
                            MojaPloca[TrenutnaCelija.Redak , TrenutnaCelija.Stupac + i].DopusteniPotez = true;

                        if (AkojeSigurno(TrenutnaCelija.Redak, TrenutnaCelija.Stupac - i))
                            MojaPloca[TrenutnaCelija.Redak, TrenutnaCelija.Stupac - i].DopusteniPotez = true;

                        if (AkojeSigurno(TrenutnaCelija.Redak - i, TrenutnaCelija.Stupac))
                            MojaPloca[TrenutnaCelija.Redak - i, TrenutnaCelija.Stupac ].DopusteniPotez = true;

                        if (AkojeSigurno(TrenutnaCelija.Redak + i, TrenutnaCelija.Stupac))
                            MojaPloca[TrenutnaCelija.Redak + i, TrenutnaCelija.Stupac].DopusteniPotez = true;

                    }

                    break;

                case "Tower":

                    for (int i = 0; i < Velicina; i++)
                    {

                        if (AkojeSigurno(TrenutnaCelija.Redak, TrenutnaCelija.Stupac + i))
                            MojaPloca[TrenutnaCelija.Redak, TrenutnaCelija.Stupac + i].DopusteniPotez = true;

                        if (AkojeSigurno(TrenutnaCelija.Redak, TrenutnaCelija.Stupac - i))
                            MojaPloca[TrenutnaCelija.Redak, TrenutnaCelija.Stupac - i].DopusteniPotez = true;

                        if (AkojeSigurno(TrenutnaCelija.Redak - i, TrenutnaCelija.Stupac))
                            MojaPloca[TrenutnaCelija.Redak - i, TrenutnaCelija.Stupac].DopusteniPotez = true;

                        if (AkojeSigurno(TrenutnaCelija.Redak + i, TrenutnaCelija.Stupac))
                            MojaPloca[TrenutnaCelija.Redak + i, TrenutnaCelija.Stupac].DopusteniPotez = true;
                    }
                    break;

                default:

                    break;
            }
            MojaPloca[TrenutnaCelija.Redak, TrenutnaCelija.Stupac].TrenutnoZauzeto = true;
        }

        private bool AkojeSigurno(int v1, int v2)
        {
            return !(v1 < 0 || v1 > (Velicina - 1) || v2 < 0 || v2 > (Velicina - 1));
        }
    }
}
