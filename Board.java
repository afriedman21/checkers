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
    private Piece[][] checkerBoard = new Piece[NUM_ROWS][NUM_COLS]; 
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
                        checkerBoard[k][i] = new Piece('x');
                    else
                        checkerBoard[k][i] = new Piece('o');
                }
                else
                    checkerBoard[k][i] = null;
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
        for(Piece[] curRow: checkerBoard)
        {
            System.out.print(num);
            for(Piece curPiece: curRow)
            {
                if(curPiece == null)
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
            if(checkerBoard[NUM_ROWS - 1][i].getBoardPiece() == 'x')
                checkerBoard[NUM_ROWS - 1][i] = new Piece('X');
            if(checkerBoard[0][i].getBoardPiece() == 'o')
                checkerBoard[0][i] = new Piece('O');
        }
    }

    public void movePiece()
    {
        try
        {
            if(turn%2 == 0)
                System.out.println("White to move");
            else
                System.out.println("Black to move");
            System.out.println("Choose the piece you would like to move by its coordinate");
            Scanner input = new Scanner(System.in);
            String piece = input.nextLine();
            int chosenCol = Integer.parseInt(piece.substring(0,1));
            int chosenRow = Integer.parseInt(piece.substring(2,3));
            System.out.println("Choose the square you would like to move to");
            String move = input.nextLine();
            int moveCol = Integer.parseInt(move.substring(0,1));
            int moveRow = Integer.parseInt(move.substring(2,3));
            if(moveRow > 0 && moveRow < 9 && moveCol > 0 && moveCol < 9)
            {
                System.out.print("Not a valid move");
                return;
            }
            if(checkerBoard[chosenRow][chosenCol].getBoardPiece() == 'x' && turn%2 ==0)
            {
                if(checkerBoard[moveRow][moveCol].getBoardPiece() == 'x' || checkerBoard[moveRow][moveCol].getBoardPiece() == 'X')
                {    
                    System.out.println("Not a valid move");
                    return;
                }
                else if(checkerBoard[moveRow][moveCol] == null)
                    if(moveRow - chosenRow == 1 && Math.abs(chosenCol - moveCol) == 1)                                                
                    {
                        checkerBoard[moveRow][moveCol] = new Piece('x');
                        checkerBoard[chosenRow][chosenCol] = null;
                    }
                    else
                    {
                        System.out.println("Not a valid move");
                        return;
                    }
                else
                {
                    if(moveRow - chosenRow == 2 && Math.abs(chosenCol - moveCol) == 1)                                                
                    {
                        checkerBoard[moveRow][moveCol] = new Piece('x');
                        checkerBoard[chosenRow][chosenCol] = null;
                    }
                    else
                    {
                        System.out.println("Not a valid move");
                        return;
                    }
                }
            }           
            //else if(checkerBoard[chosenRow][chosenCol].getBoardPiece() == 'o' && turn%2 ==1)
            
            //else
            //System.out.println("Choose a valid piece");
            }
            catch (NumberFormatException e)
            {
            System.out.println("Please follow the instructions");
        }
    }

    public void removePiece(int r, int c)
    {
        if (checkerBoard[r][c].getBoardPiece() == 'x')
        {
            checkerBoard[r][c] = null;
            whitePiecesLeft --;
        }
        else if (checkerBoard[r][c].getBoardPiece() == 'o')
        {
            checkerBoard[r][c] = null;
            blackPiecesLeft--;
        }     
    }

} 

