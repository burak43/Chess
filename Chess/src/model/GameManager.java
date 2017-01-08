package model;

public class GameManager {

	public Color turn;
	protected Player[] players;
	protected String result;
	public CheckStatus checkStatus;
	public boolean paused;
	protected Board board;
	protected MovementManager movementManager;

	public GameManager(Player[] players) {
		this.players = players;
		turn = Color.WHITE;
		result = "not finished";
		paused = false;

		board = new Board();

		movementManager = new MovementManager(board);
	}
	
	public boolean isChecked(Player player, Piece piece) {

		if (player.getColor() == piece.getPieceColor()) {
			return false;
		}
		
		Square[] allRoutes = movementManager.validMoves(piece);
		for (int i = 0; i < 64; i++) {
			if (allRoutes[i] == null) {
				break;
			} else if (allRoutes[i].getPlacedPiece() instanceof King) {
				return true;
			}
		}

		return false;
	
	}

	public boolean isCheckmated(Player player) {

		for (int i = 1; i < 9; i++) {
			for (int j = 0; j < 8; j++) {
				char column = (char) ('A' + j);
				if (board.getSquareAtLoc(i, column).getPlacedPiece() instanceof King) {
					if (board.getSquareAtLoc(i, column).getPlacedPiece().getPieceColor() == player.getColor()) {
						return false;
					}
				}
			}
		}

		return true;

	}

	public boolean isEnded() {
		return !(result.equals("not finished"));
	}

	public Piece movePiece(char cp1, int ip1, char cp2, int ip2) {
					
		Piece piece = board.getSquareAtLoc(ip1, cp1).getPlacedPiece();
		Square square = board.getSquareAtLoc(ip2, cp2);

		if (piece == null) { return null; }
		
		if (movementManager.isMoveable(piece, square)) {
			
			piece.getCurrentLocation().withdraw();
			square.withdraw();
			
			square.placePiece(piece);
			piece.setCurrentLocation(square);
			
			return piece;
	
		}

		return null;

	}
	
	public void placeObjects() {

		for (int i = 0; i < 8; i++) {

			char column = 'A';
			column += i;
			Pawn pawn = new Pawn(Color.WHITE, null);
			Square square = board.getSquareAtLoc(2, column);
			pawn.setCurrentLocation(square);
			board.getSquareAtLoc(2, column).placePiece(pawn);

		}

		Rook rook1 = new Rook(Color.WHITE, null);
		Square square2A = board.getSquareAtLoc(1, 'A');
		rook1.setCurrentLocation(square2A);
		board.getSquareAtLoc(1, 'A').placePiece(rook1);

		Rook rook2 = new Rook(Color.WHITE, null);
		Square square2H = board.getSquareAtLoc(1, 'H');
		rook2.setCurrentLocation(square2H);
		board.getSquareAtLoc(1, 'H').placePiece(rook2);

		Knight knight1 = new Knight(Color.WHITE, null);
		Square square2B = board.getSquareAtLoc(1, 'B');
		knight1.setCurrentLocation(square2B);
		board.getSquareAtLoc(1, 'B').placePiece(knight1);

		Knight knight2 = new Knight(Color.WHITE, null);
		Square square2G = board.getSquareAtLoc(1, 'G');
		knight2.setCurrentLocation(square2G);
		board.getSquareAtLoc(1, 'G').placePiece(knight2);

		Bishop bishop1 = new Bishop(Color.WHITE, null);
		Square square2C = board.getSquareAtLoc(1, 'C');
		bishop1.setCurrentLocation(square2C);
		board.getSquareAtLoc(1, 'C').placePiece(bishop1);

		Bishop bishop2 = new Bishop(Color.WHITE, null);
		Square square2F = board.getSquareAtLoc(1, 'F');
		bishop2.setCurrentLocation(square2F);
		board.getSquareAtLoc(1, 'F').placePiece(bishop2);

		Queen queen = new Queen(Color.WHITE, null);
		Square square2D = board.getSquareAtLoc(1, 'D');
		queen.setCurrentLocation(square2D);
		board.getSquareAtLoc(1, 'D').placePiece(queen);

		King king = new King(Color.WHITE, null);
		Square square2E = board.getSquareAtLoc(1, 'E');
		king.setCurrentLocation(square2E);
		board.getSquareAtLoc(1, 'E').placePiece(king);

		Rook rook3 = new Rook(Color.BLACK, null);
		Square square7A = board.getSquareAtLoc(8, 'A');
		rook3.setCurrentLocation(square7A);
		board.getSquareAtLoc(8, 'A').placePiece(rook3);

		Rook rook4 = new Rook(Color.BLACK, null);
		Square square7H = board.getSquareAtLoc(8, 'H');
		rook4.setCurrentLocation(square7H);
		board.getSquareAtLoc(8, 'H').placePiece(rook4);

		Knight knight3 = new Knight(Color.BLACK, null);
		Square square7B = board.getSquareAtLoc(8, 'B');
		knight3.setCurrentLocation(square7B);
		board.getSquareAtLoc(8, 'B').placePiece(knight3);

		Knight knight4 = new Knight(Color.BLACK, null);
		Square square7G = board.getSquareAtLoc(8, 'G');
		knight4.setCurrentLocation(square7G);
		board.getSquareAtLoc(8, 'G').placePiece(knight4);

		Bishop bishop3 = new Bishop(Color.BLACK, null);
		Square square7C = board.getSquareAtLoc(8, 'C');
		bishop3.setCurrentLocation(square7C);
		board.getSquareAtLoc(8, 'C').placePiece(bishop3);

		Bishop bishop4 = new Bishop(Color.BLACK, null);
		Square square7F = board.getSquareAtLoc(8, 'F');
		bishop4.setCurrentLocation(square7F);
		board.getSquareAtLoc(8, 'F').placePiece(bishop4);

		Queen queenBlack = new Queen(Color.BLACK, null);
		Square square7D = board.getSquareAtLoc(8, 'D');
		queenBlack.setCurrentLocation(square7D);
		board.getSquareAtLoc(8, 'D').placePiece(queenBlack);

		King kingBlack = new King(Color.BLACK, null);
		Square square7E = board.getSquareAtLoc(8, 'E');
		kingBlack.setCurrentLocation(square7E);
		board.getSquareAtLoc(8, 'E').placePiece(kingBlack);

		for (int i = 0; i < 8; i++) {

			char column = 'A';
			column += i;
			Pawn pawn = new Pawn(Color.BLACK, null);
			Square square = board.getSquareAtLoc(7, column);
			pawn.setCurrentLocation(square);
			board.getSquareAtLoc(7, column).placePiece(pawn);

		}

	}

	public void pauseGame() {
		paused = true;
	}

	public void resumeGame() {
		paused = false;
	}

	public void endGame(Player player) {
		paused = true;

		if (isCheckmated(players[0])) {
			result = players[1].getName() + " is the Winner!";
		} else if (isCheckmated(players[1])) {
			result = players[0].getName() + " is the Winner!";
		} else {
			result = "The game ended with Stalemate!";
		}
		
	}

}
