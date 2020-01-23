import java.util.Scanner;
/**
 * Write a description of class Board here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Board
{
    private final int NUM_ROWS = 8;
    private final int NUM_COLS = 8;
    private char[][] checkerBoard = new char[NUM_ROWS][NUM_COLS];
    private int turn = 0;
    private int whitePiecesLeft = 12;
    private int blackPiecesLeft = 12;

    public Board()
    {
        for(int i = 0; i < NUM_COLS; i++)
        {
            for(int k = 0; k < NUM_ROWS; k++)
            {
                if((k < 3 || k > 4) && k%2 != i%2)
                {
                    if(k < 3)
                        checkerBoard[k][i] = 'x';
                    else
                        checkerBoard[k][i] = 'o';
                }
                else
                    checkerBoard[k][i] = ' ';
            }
        }
    }

    public int getWhitePieces()
    {
        return whitePiecesLeft;
    }

    public int getBlackPieces()
    {
        return blackPiecesLeft;
    }

    public void printBoard()
    {
        System.out.println("   1   2   3   4   5   6   7   8");
        int num = 1;
        for(char[] curRow: checkerBoard)
        {
            System.out.print(num);
            for(char curPiece: curRow)
            {
                if(curPiece == ' ')
                    System.out.print("|___");
                else
                    System.out.print("|_" + curPiece + "_");
            }
            System.out.println("|");
            num ++;
        }
    }

    public void makeKing()
    {
        for(int i = 0; i < NUM_COLS; i++)
        {
            if(checkerBoard[NUM_ROWS - 1][i] == 'x')
                checkerBoard[NUM_ROWS - 1][i] = 'X';
            if(checkerBoard[0][i] == 'o')
                checkerBoard[0][i] = 'O';
        }
    }

    public void movePiece()
    {
        try
        {
            printBoard();
            if(turn%2 == 0)
                System.out.println("White to move");
            else
                System.out.println("Black to move");
            System.out.println("Choose the piece you would like to move by its coordinate \nfollowed by the first letter of the direction you would like to move. \n(Ex. 2, 3, r)"); // however we tell them to move the piece
            Scanner input = new Scanner(System.in);
            String piece = input.nextLine();
            int chosenCol = Integer.parseInt(piece.substring(0,1));
            int chosenRow = Integer.parseInt(piece.substring(2,3));
            System.out.println("Choose the square you would like to move to");
            String move = input.nextLine();
            int moveCol = Integer.parseInt(move.substring(0,1));
            int moveRow = Integer.parseInt(move.substring(2,3));
                if(checkerBoard[chosenCol][chosenRow] == 'x' && turn%2 == 0)
                {
                    checkerBoard[chosenCol][chosenRow] = ' ';
                    checkerBoard[moveCol][moveRow] = 'x';
                }
                else if(checkerBoard[chosenCol][chosenRow] == 'o' && turn%2 == 1)
                {
                    checkerBoard[chosenCol][chosenRow] = ' ';
                    checkerBoard[moveCol][moveRow] = 'o';
                } 
                else
                {
                    System.out.print("Please select a valid piece");
                }
        }
        catch (NumberFormatException e)
        {
            System.out.println("Please follow the instructions");
        }
    } 
}

