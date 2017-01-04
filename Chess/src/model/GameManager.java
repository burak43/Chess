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

	/*
	public static void main(String[] args) {

		Player p1 = new Player("Joe", Color.WHITE);
		Player p2 = new Player("Buck", Color.BLACK);
		Player[] players = new Player[2];
		players[0] = p1;
		players[1] = p2;

		GameManager gm = new GameManager(players);

		Queen queen = new Queen(Color.BLACK, null);
		queen.setCurrentLocation(gm.board.getSquareAtLoc(4, 'D'));
		gm.board.getSquareAtLoc(4, 'D').placePiece(queen);

		King king = new King(Color.WHITE, null);
		king.setCurrentLocation(gm.board.getSquareAtLoc(3, 'C'));
		gm.board.getSquareAtLoc(3, 'C').placePiece(king);

		// print all paths
		
		 * Square[] allSq = gm.movementManager.validMoves(king); for (int i = 0;
		 * i < 64; i++) {
		 * 
		 * if (allSq[i] == null) break; else System.out.println(
		 * "The knight CAN move to " + allSq[i].getRow() +
		 * allSq[i].getColumn());
		 * 
		 * }
		 

		if (gm.isChecked(p2, queen))
			System.out.println("Queen checks the king!");

		if (gm.isCheckmated(p1))
			System.out.println("P1 CHECKMATED");

		// try moving a rook -> the rook moves!
		
		 * Square target = gm.board.getSquareAtLoc(2, 'A'); System.out.println(
		 * "Target is " + target.getRow() + "" + target.getColumn());
		 * System.out.println("it's occupied: " + target.isOccupied()); if
		 * (gm.movementManager.isMoveable(rook, target)) System.out.println(
		 * "The rook CAN move to " + target.getRow() + target.getColumn()); else
		 * System.out.println("It can't");
		 

		// try moving a bishop -> the bishop moves!
		
		 * Square target = gm.board.getSquareAtLoc(1, 'A'); System.out.println(
		 * "Target is " + target.getRow() + "" + target.getColumn());
		 * System.out.println("it's occupied: " + target.isOccupied()); if
		 * (gm.movementManager.isMoveable(bishop, target)) System.out.println(
		 * "The bishop CAN move to " + target.getRow() + target.getColumn());
		 * else System.out.println("It can't");
		 

	}
	*/
	
	public boolean isChecked(Player player, Piece piece) {

		if (player.getColor() == piece.getPieceColor())
			return false;

		Square[] allRoutes = movementManager.validMoves(piece);
		for (int i = 0; i < 64; i++) {
			if (allRoutes[i] == null) {
				break;
			} else if (allRoutes[i].getPlacedPiece() instanceof King)
				return true;

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

	public Piece movePiece(Piece piece, Square square) {

		if (movementManager.isMoveable(piece, square)) {
			piece.getCurrentLocation().withdraw();
			//square.withdraw();
			square.placePiece(piece);
			return piece;
		}

		return null;

	}

	// ecem -> berk : taslarin yerini duzelttim
	
	public void placeObjects() {

		// place white pawns
		for (int i = 0; i < 8; i++) {

			char column = 'A';
			column += i;
			Square square = board.getSquareAtLoc(2, column);
			Pawn pawn = new Pawn(Color.WHITE, square);
			square.placePiece(pawn);
		}

		// place white rooks
		Square square1A = board.getSquareAtLoc(1, 'A');
		Rook rook1 = new Rook(Color.WHITE, square1A);
		square1A.placePiece(rook1);

		Square square1H = board.getSquareAtLoc(1, 'H');
		Rook rook2 = new Rook(Color.WHITE, square1H);
		square1H.placePiece(rook2);

		// place white knights
		Square square1B = board.getSquareAtLoc(1, 'B');
		Knight knight1 = new Knight(Color.WHITE, square1B);
		square1B.placePiece(knight1);

		Square square1G = board.getSquareAtLoc(1, 'G');
		Knight knight2 = new Knight(Color.WHITE, square1G);
		knight2.setCurrentLocation(square1G);
		square1G.placePiece(knight2);

		// place white bishops
		Square square1C = board.getSquareAtLoc(1, 'C');
		Bishop bishop1 = new Bishop(Color.WHITE, square1C);
		square1C.placePiece(bishop1);

		Square square1F = board.getSquareAtLoc(1, 'F');
		Bishop bishop2 = new Bishop(Color.WHITE, square1F);
		square1F.placePiece(bishop2);

		// place white queen
		Square square1D = board.getSquareAtLoc(1, 'D');
		Queen queen = new Queen(Color.WHITE, square1D);
		square1D.placePiece(queen);

		// place white king
		Square square1E = board.getSquareAtLoc(1, 'E');
		King king = new King(Color.WHITE, square1E);
		square1E.placePiece(king);

		// place black rooks
		Square square8A = board.getSquareAtLoc(8, 'A');
		Rook rook3 = new Rook(Color.WHITE, square8A);
		square8A.placePiece(rook3);

		Square square8H = board.getSquareAtLoc(8, 'H');
		Rook rook4 = new Rook(Color.WHITE, square8H);
		square8H.placePiece(rook4);

		// place black knights
		Square square8B = board.getSquareAtLoc(8, 'B');
		Knight knight3 = new Knight(Color.WHITE, square8B);
		square8B.placePiece(knight3);

		Square square8G = board.getSquareAtLoc(8, 'G');
		Knight knight4 = new Knight(Color.WHITE, square8G);
		knight4.setCurrentLocation(square8G);
		square8G.placePiece(knight4);

		// place black bishops
		Square square8C = board.getSquareAtLoc(8, 'C');
		Bishop bishop3 = new Bishop(Color.WHITE, square8C);
		square8C.placePiece(bishop3);

		Square square8F = board.getSquareAtLoc(8, 'F');
		Bishop bishop4 = new Bishop(Color.WHITE, square8F);
		square8F.placePiece(bishop4);

		// place black queen
		Square square8D = board.getSquareAtLoc(8, 'D');
		Queen queen2 = new Queen(Color.WHITE, square8D);
		square8D.placePiece(queen2);

		// place black king
		Square square8E = board.getSquareAtLoc(8, 'E');
		King king2 = new King(Color.WHITE, square8E);
		square8E.placePiece(king2);

		// place black pawns
		for (int i = 0; i < 8; i++) {
			char column = 'A';
			column += i;
			Square square = board.getSquareAtLoc(7, column);
			Pawn pawn = new Pawn(Color.BLACK, square);
			square.placePiece(pawn);
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

		if (isCheckmated(players[0]))
			result = players[1].getName() + " is the Winner!";
		else if (isCheckmated(players[1]))
			result = players[0].getName() + " is the Winner!";
		else
			result = "The game ended with Stalemate!";
	}

}
