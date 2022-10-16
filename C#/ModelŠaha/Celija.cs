using System;
using System.Collections.Generic;
using System.Text;

namespace ModelŠahovnice
{
    public class Celija
    {

        public int Redak { get; set; }
        public int Stupac { get; set; }
        public bool TrenutnoZauzeto { get; set; }
        public bool DopusteniPotez { get; set; }


        public Celija (int x, int y)
        {
            Redak = x;
            Stupac = y;
        }

    }
}
