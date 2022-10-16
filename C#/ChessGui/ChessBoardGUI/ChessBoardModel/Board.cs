using System;
using System.Collections.Generic;
using System.Text;

namespace ChessBoardModel
{
    public class Board
    {

        public int Size { get; set; }

        public Cell [,]  theGrid  { get; set; }


        // constructor
        public Board (int s)
        {
            // tu uzimamo broj za plocu
            Size = s;
            
            // tu pravimo nove celije
            theGrid = new Cell[Size, Size];

           // ovdije popunjavamo plocu sa x/y koordinatama
            for (int i = 0; i < Size; i++)
            {
                for (int j = 0; j < Size; j++)
                {
                    theGrid[i , j] = new Cell(i, j);
                }
            }


        }

        public void MarkNextLegalMoves( Cell currentCell, String chessPiece)
        {
            // step1 ocistiti plocu od prijasnjih dozvoljenih kretnji

            for (int i = 0; i < Size; i++)
            {
                for (int j = 0; j < Size; j++)
                {
                    theGrid[i, j].LegalNextMove = false;
                    theGrid[i, j].CurrentlyOccupied = false;

                }
            }


            // step2 pronaci sve moguce kretnje i oznaciti ih na ploci

            switch (chessPiece)
            {
                case "Knight":

                    if (ifSafe(currentCell.RowNumber + 2, currentCell.ColumnNumber + 1))
                        theGrid[currentCell.RowNumber + 2, currentCell.ColumnNumber + 1].LegalNextMove = true;
                    if (ifSafe(currentCell.RowNumber + 2, currentCell.ColumnNumber - 1))
                        theGrid[currentCell.RowNumber + 2, currentCell.ColumnNumber - 1].LegalNextMove = true;
                    if (ifSafe(currentCell.RowNumber - 2, currentCell.ColumnNumber + 1))
                        theGrid[currentCell.RowNumber - 2, currentCell.ColumnNumber + 1].LegalNextMove = true;
                    if (ifSafe(currentCell.RowNumber - 2, currentCell.ColumnNumber - 1))
                        theGrid[currentCell.RowNumber - 2, currentCell.ColumnNumber - 1].LegalNextMove = true;
                    if (ifSafe(currentCell.RowNumber + 1, currentCell.ColumnNumber + 2))
                        theGrid[currentCell.RowNumber + 1, currentCell.ColumnNumber + 2].LegalNextMove = true;
                    if (ifSafe(currentCell.RowNumber - 1, currentCell.ColumnNumber + 2))
                        theGrid[currentCell.RowNumber - 1, currentCell.ColumnNumber + 2].LegalNextMove = true;
                    if (ifSafe(currentCell.RowNumber + 1, currentCell.ColumnNumber - 2))
                        theGrid[currentCell.RowNumber + 1, currentCell.ColumnNumber - 2].LegalNextMove = true;
                    if (ifSafe(currentCell.RowNumber - 1, currentCell.ColumnNumber - 2))
                        theGrid[currentCell.RowNumber - 1, currentCell.ColumnNumber - 2].LegalNextMove = true;

                    break;

                case "King":
                    if (ifSafe(currentCell.RowNumber + 1, currentCell.ColumnNumber + 1))
                        theGrid[currentCell.RowNumber + 1, currentCell.ColumnNumber + 1].LegalNextMove = true;
                    if (ifSafe(currentCell.RowNumber - 1, currentCell.ColumnNumber + 1))
                        theGrid[currentCell.RowNumber - 1, currentCell.ColumnNumber + 1].LegalNextMove = true;
                    if (ifSafe(currentCell.RowNumber + 1, currentCell.ColumnNumber - 1))
                        theGrid[currentCell.RowNumber + 1, currentCell.ColumnNumber - 1].LegalNextMove = true;
                    if (ifSafe(currentCell.RowNumber - 1, currentCell.ColumnNumber - 1))
                        theGrid[currentCell.RowNumber - 1, currentCell.ColumnNumber - 1].LegalNextMove = true;
                    if (ifSafe(currentCell.RowNumber, currentCell.ColumnNumber + 1))
                        theGrid[currentCell.RowNumber, currentCell.ColumnNumber + 1].LegalNextMove = true;
                    if (ifSafe(currentCell.RowNumber, currentCell.ColumnNumber - 1))
                        theGrid[currentCell.RowNumber, currentCell.ColumnNumber - 1].LegalNextMove = true;
                    if (ifSafe(currentCell.RowNumber + 1, currentCell.ColumnNumber))
                        theGrid[currentCell.RowNumber + 1, currentCell.ColumnNumber].LegalNextMove = true;
                    if (ifSafe(currentCell.RowNumber - 1, currentCell.ColumnNumber))
                        theGrid[currentCell.RowNumber - 1, currentCell.ColumnNumber].LegalNextMove = true;

                    break;

                case "Bishop":
                    for (int i = 1; i < Size; i++)
                    {
                        if (ifSafe(currentCell.RowNumber + i, currentCell.ColumnNumber + i))
                            theGrid[currentCell.RowNumber + i, currentCell.ColumnNumber + i].LegalNextMove = true;
                    }
                    for (int i = 1; i < Size; i++)
                    {
                        if (ifSafe(currentCell.RowNumber - i, currentCell.ColumnNumber - i))
                            theGrid[currentCell.RowNumber - i, currentCell.ColumnNumber - i].LegalNextMove = true;
                    }
                    for (int i = 1; i < Size; i++)
                    {
                        if (ifSafe(currentCell.RowNumber - i, currentCell.ColumnNumber + i))
                            theGrid[currentCell.RowNumber - i, currentCell.ColumnNumber + i].LegalNextMove = true;
                    }
                    for (int i = 1; i < Size; i++)
                    {
                        if (ifSafe(currentCell.RowNumber + i, currentCell.ColumnNumber - i))
                            theGrid[currentCell.RowNumber + i, currentCell.ColumnNumber - i].LegalNextMove = true;
                    }
                   
                    break;

                case "Queen":
                    for (int i = 1; i < Size; i++)
                    {
                        if (ifSafe(currentCell.RowNumber + i, currentCell.ColumnNumber + i))
                            theGrid[currentCell.RowNumber + i, currentCell.ColumnNumber + i].LegalNextMove = true;
                    
                        if (ifSafe(currentCell.RowNumber - i, currentCell.ColumnNumber - i))
                            theGrid[currentCell.RowNumber - i, currentCell.ColumnNumber - i].LegalNextMove = true;
                    
                        if (ifSafe(currentCell.RowNumber - i, currentCell.ColumnNumber + i))
                            theGrid[currentCell.RowNumber - i, currentCell.ColumnNumber + i].LegalNextMove = true;
                  
                        if (ifSafe(currentCell.RowNumber + i, currentCell.ColumnNumber - i))
                            theGrid[currentCell.RowNumber + i, currentCell.ColumnNumber - i].LegalNextMove = true;
                
                        if (ifSafe(currentCell.RowNumber , currentCell.ColumnNumber + i))
                            theGrid[currentCell.RowNumber , currentCell.ColumnNumber + i].LegalNextMove = true;

                        if (ifSafe(currentCell.RowNumber, currentCell.ColumnNumber - i))
                            theGrid[currentCell.RowNumber, currentCell.ColumnNumber - i].LegalNextMove = true;

                        if (ifSafe(currentCell.RowNumber - i, currentCell.ColumnNumber))
                            theGrid[currentCell.RowNumber - i, currentCell.ColumnNumber ].LegalNextMove = true;

                        if (ifSafe(currentCell.RowNumber + i, currentCell.ColumnNumber))
                            theGrid[currentCell.RowNumber + i, currentCell.ColumnNumber].LegalNextMove = true;

                    }

                    break;

                case "Tower":

                    for (int i = 0; i < Size; i++)
                    {

                        if (ifSafe(currentCell.RowNumber, currentCell.ColumnNumber + i))
                            theGrid[currentCell.RowNumber, currentCell.ColumnNumber + i].LegalNextMove = true;

                        if (ifSafe(currentCell.RowNumber, currentCell.ColumnNumber - i))
                            theGrid[currentCell.RowNumber, currentCell.ColumnNumber - i].LegalNextMove = true;

                        if (ifSafe(currentCell.RowNumber - i, currentCell.ColumnNumber))
                            theGrid[currentCell.RowNumber - i, currentCell.ColumnNumber].LegalNextMove = true;

                        if (ifSafe(currentCell.RowNumber + i, currentCell.ColumnNumber))
                            theGrid[currentCell.RowNumber + i, currentCell.ColumnNumber].LegalNextMove = true;
                    }
                    break;

                default:

                    break;
            }
            theGrid[currentCell.RowNumber, currentCell.ColumnNumber].CurrentlyOccupied = true;
        }

        private bool ifSafe(int v1, int v2)
        {
            return !(v1 < 0 || v1 > (Size - 1) || v2 < 0 || v2 > (Size - 1));
        }
    }
}
