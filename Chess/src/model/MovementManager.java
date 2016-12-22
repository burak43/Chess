package model;

/**
 * Created by berkabbasoglu on 18/12/2016.
 */
public class MovementManager {

    private Board board;

    public MovementManager(Board board) {
        this.board = board;
    }

    public boolean isCaptured(Piece piece) {

        if (piece.getCurrentLocation() == null)
            return true;

        return false;
    }

    public boolean isMoveable(Piece piece, Square destination) {

        Square currentLoc = new Square(piece.getCurrentLocation().getRow(), piece.getCurrentLocation().getColumn(), piece.getCurrentLocation().getPlacedPiece());

        // make sure destination is within board, doesn't conflict with a piece of the same colour and is not the same as currentloc
        if (destination.getColumn() > 'H')
            return false;
        if (destination.getRow() > 8)
            return false;

        if (destination.getPlacedPiece() != null) {
            if (destination.getPlacedPiece().getPieceColor() == piece.getPieceColor())
                return false;
        }

        if (destination.getRow() == currentLoc.getRow() && destination.getColumn() == currentLoc.getColumn())
            return false;

        // check for rook
        if (piece instanceof Rook) {
            return isMoveableRook(destination, currentLoc);
        }

        // check for knight
        else if (piece instanceof Knight) {
            return isMoveableKnight(destination, currentLoc);
        }

        // check for bishop
        else if (piece instanceof Bishop) {
            return isMoveableBishop(destination, currentLoc);
        }

        // check for king
        else if (piece instanceof King) {
            return isMoveableKing(destination, currentLoc);
        }

        // check for queen
        else if (piece instanceof Queen) {

            // if queen attempts rook-like movement
            if (destination.getRow() == currentLoc.getRow() && destination.getColumn() != currentLoc.getColumn())
                return isMoveableRook(destination, currentLoc);

            else if (destination.getRow() != currentLoc.getRow() && destination.getColumn() == currentLoc.getColumn())
                return isMoveableRook(destination, currentLoc);

            // if queen attempts bishop-like movement
            else if (Math.abs(destination.getRow() - currentLoc.getRow()) -
                    Math.abs(destination.getColumn() - currentLoc.getColumn()) == 0) {
                return isMoveableBishop(destination, currentLoc);
            }

            else
                return false;
        }

        // check for pawn
        else if (piece instanceof Pawn) {
            Color color = piece.getPieceColor();
            return isMoveablePawn(destination, currentLoc, color);

        }

        return false;
    }


    // recursively find if rook's path is clear
    private boolean isMoveableRook(Square destination, Square currentLoc) {

        if (destination.getColumn() != currentLoc.getColumn() && destination.getRow() != currentLoc.getRow())
            return false;

        boolean column = (currentLoc.getColumn() != destination.getColumn());

        if (currentLoc.equals(destination))
            return true;

        if (column) {
            char targetColumn = currentLoc.getColumn();

            if (destination.getColumn() > currentLoc.getColumn())
                targetColumn++;

            else
                targetColumn--;

            currentLoc.setColumn(targetColumn);

            if (currentLoc.equals(destination))
                return true;
            
            return !(board.getSquareAtLoc(currentLoc.getRow(), targetColumn).isOccupied()) && isMoveableRook(destination, currentLoc);
        }

        else {
            int targetRow = currentLoc.getRow();

            if (destination.getRow() > currentLoc.getRow())
                targetRow++;
            else
                targetRow--;

            currentLoc.setRow(targetRow);

            if (currentLoc.equals(destination))
                return true;

            return !(board.getSquareAtLoc(targetRow, currentLoc.getColumn()).isOccupied()) && isMoveableRook(destination, currentLoc);
        }

    }

    // find if knight's path is clear, check all possibilities one by one
    private boolean isMoveableKnight(Square destination, Square currentLoc) {

        if (Math.abs(currentLoc.getRow() - destination.getRow()) == 2 &&
                Math.abs(currentLoc.getColumn() - destination.getColumn()) == 1)
            return true;
        else if (Math.abs(currentLoc.getColumn() - destination.getColumn()) == 2 &&
                Math.abs(currentLoc.getRow() - destination.getRow()) == 1) {
            return true;
        }
        
       // No need for belows. They are same as aboves !!
        
       /* else if (Math.abs(currentLoc.getRow() - destination.getRow()) == 1 &&
                Math.abs(currentLoc.getColumn() - destination.getColumn()) == 2)
            return true;
        else if (Math.abs(currentLoc.getColumn() - destination.getColumn()) == 1 &&
                Math.abs(currentLoc.getRow() - destination.getRow()) == 2) {
            return true;
        }*/

        return false;

    }

    // recursively find if bishop's path is clear
    private boolean isMoveableBishop(Square destination, Square currentLoc) {

        if (currentLoc.equals(destination))
            return true;

        char targetColumn = currentLoc.getColumn();
        int targetRow = currentLoc.getRow();

        if (currentLoc.getColumn() < destination.getColumn() &&
                currentLoc.getRow() < destination.getRow()) {
            targetColumn++;
            targetRow++;

            currentLoc.setRow(targetRow);
            currentLoc.setColumn(targetColumn);

            if (currentLoc.equals(destination))
                return true;

            return !(board.getSquareAtLoc(targetRow, targetColumn).isOccupied()) && isMoveableBishop(destination, currentLoc);
        }

        else if (currentLoc.getColumn() < destination.getColumn() &&
                currentLoc.getRow() > destination.getRow()) {
            targetColumn++;
            targetRow--;

            currentLoc.setRow(targetRow);
            currentLoc.setColumn(targetColumn);

            if (currentLoc.equals(destination))
                return true;

            return !(board.getSquareAtLoc(targetRow, targetColumn).isOccupied()) && isMoveableBishop(destination, currentLoc);
        }

        else if (currentLoc.getColumn() > destination.getColumn() &&
                currentLoc.getRow() < destination.getRow()) {
            targetColumn--;
            targetRow++;

            currentLoc.setRow(targetRow);
            currentLoc.setColumn(targetColumn);

            if (currentLoc.equals(destination))
                return true;

            return !(board.getSquareAtLoc(targetRow, targetColumn).isOccupied()) && isMoveableBishop(destination, currentLoc);
        }

        else if (currentLoc.getColumn() > destination.getColumn() &&
                currentLoc.getRow() > destination.getRow()) {
            targetColumn--;
            targetRow--;

            currentLoc.setRow(targetRow);
            currentLoc.setColumn(targetColumn);

            if (currentLoc.equals(destination))
                return true;

            return !(board.getSquareAtLoc(targetRow, targetColumn).isOccupied()) && isMoveableBishop(destination, currentLoc);
        }

        return false;

    }

    // find if king's path is clear, check all possibilities one by one
    private boolean isMoveableKing(Square destination, Square currentLoc) {

        if (destination.getColumn() == currentLoc.getColumn() &&
                Math.abs(destination.getRow() - currentLoc.getRow()) == 1)
            return true;

        else if ((Math.abs(destination.getColumn() - currentLoc.getColumn()) == 1 )&&
                destination.getRow() == currentLoc.getRow())
            return true;

        else if ((Math.abs(currentLoc.getColumn() - destination.getColumn()) == 1 )&&
                (Math.abs(currentLoc.getRow() - destination.getRow()) == 1))
            return true;

        return false;
    }

    private boolean isMoveablePawn(Square destination, Square currentLoc, Color color) {

        if (color == Color.WHITE) {

            if ((Math.abs(destination.getColumn() - currentLoc.getColumn())) == 1 && ((destination.getRow() - currentLoc.getRow()) == 1)) {
                return destination.isOccupied();
            }

            else if ((destination.getRow() - currentLoc.getRow() == 1) && (destination.getColumn() == currentLoc.getColumn())) {
                return !destination.isOccupied();
            }
        }

        else {

            if (Math.abs(destination.getColumn() - currentLoc.getColumn()) == 1 &&
                    currentLoc.getRow() - destination.getRow() == 1) {
                return destination.isOccupied();
            }

            else if ((currentLoc.getRow() - destination.getRow() == 1) && (destination.getColumn() == currentLoc.getColumn())) {
                return !destination.isOccupied();
            }
        }

        return false;
    }

    public Square[] validMoves(Piece piece) {

        Square[] allSquares = new Square[64];
        int count = 0;

        for( int i = 1; i < 9; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                char column = (char) ('A' + j);

                if (isMoveable(piece, board.getSquareAtLoc(i, column))) {
                    allSquares[count] = board.getSquareAtLoc(i, column);
                    count++;
                }

            }
        }

        return allSquares;
    }

    public boolean isPromoted(Pawn pawn) {
        if (pawn.getPieceColor() == Color.WHITE && pawn.getCurrentLocation().getRow() == 0)
            return true;
        if (pawn.getPieceColor() == Color.BLACK && pawn.getCurrentLocation().getRow() == 7)
            return true;
        return false;

    }

    public boolean isRookable(King king, Rook rook) {

        if (king.isMoved() == true)
            return false;
        if (rook.isMoved() == true)
            return false;
        
        if (isMoveableRook(king.getCurrentLocation(), rook.getCurrentLocation()))
            return true;
        
        return false;
    }

    public boolean removePiece(Piece piece) {

        piece.updateLocation(null);
        return !piece.getCurrentLocation().withdraw();
    }

    public boolean addPiece(Piece piece) {

        if (piece instanceof Pawn) {
            if (((Pawn) piece).isPromoted()) {

                Square pawnLoc = piece.getCurrentLocation();
                Color color = piece.getPieceColor();
                removePiece(piece);

                Queen queen = new Queen(color, pawnLoc);
                pawnLoc.placePiece(queen);
                
                /*
                 * Here pawn still remains in the pieceSet of the player. Even worse,
                 * you do not add the new piece, which is a queen, to the peiceSet of the player.
                 * It may or may not cause a problem !!!
                 */
                
                return true;

            }
        }
        return false;
    }

}