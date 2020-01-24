/**
 * Write a description of class PieceMovement here.
 *
 * @author Alex
 * @version (a version number or a date)
 */
public class Piece
{
    private char boardPiece;
    private boolean isKingPiece;
    
    public Piece(char p)
    {
        boardPiece = p; // this is either 'x' or 'o'
        isKingPiece = false;
    }
    
    public char getBoardPiece()
    {
        return boardPiece;
    }
    
    public boolean isItAKing()
    {
        return isKingPiece;
    }
}
