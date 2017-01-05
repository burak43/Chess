package model;

public class Game {

	public GameManager gameManager;

	public Game(String player1, String player2) {

		Player p1 = new Player(player1, Color.WHITE);
		Player p2 = new Player(player2, Color.BLACK);

		Player[] players = new Player[2];
		players[0] = p1;
		players[1] = p2;

		gameManager = new GameManager(players);

		gameManager.placeObjects();

	}

	public String[][] getPiecesPositions() {

		String[][] result = new String[32][4];
		int count = 0;
		
		for (int i = 1; i < 9; i++) {
			for (int j = 0; j < 8; j++) {
				char column = (char) ('A' + j);
				if (gameManager.board.getSquareAtLoc(i, column).isOccupied()) {

					result[count][0] = gameManager.board.getSquareAtLoc(i, column).getPlacedPiece().getClass().getName();
					result[count][1] = Character.toString(column);
					result[count][2] = Integer.toString(i);
					result[count][3] = gameManager.board.getSquareAtLoc(i, column).getPlacedPiece().getPieceColor() == Color.BLACK ? "b" : "w";

					count++;

				}
			}
		}

		return result;

	}
	
	public int getStatus() {

		if (gameManager.result.equals("not finished"))
			return 0;

		if (gameManager.result.equals(gameManager.players[0].getName() + " is the Winner!"))
			return 1;

		if (gameManager.result.equals(gameManager.players[1].getName() + " is the Winner!"))
			return 2;

		return -1;

	}

	public String[][] getPossible(char cp, int ip) {
		
		if (!gameManager.board.getSquareAtLoc(ip, cp).isOccupied()) {
			return new String[0][0];
		}
		
		Square[] allPossible = gameManager.movementManager.validMoves(gameManager.board.getSquareAtLoc(ip, cp).getPlacedPiece());

		String[][] squareToString = new String[64][2];

		for (int i = 0; i < 64; i++) {
			if (allPossible[i] == null) {
				break;
			}
			squareToString[i][0] = Character.toString(allPossible[i].getColumn());
			squareToString[i][1] = Integer.toString(allPossible[i].getRow());
		}

		if (squareToString[0][0] == null) {
			return new String[0][0];
		}

		//System.out.println("1! " + ip);
		//System.out.println("2! " + gameManager.board.getSquareAtLoc(ip, cp).getPlacedPiece().getCurrentLocation().getRow());
		
		return squareToString;
		
	}

	public boolean move(char cp1, int ip1, char cp2, int ip2) {

		if (gameManager.movePiece(cp1, ip1, cp2, ip2) == null) {
			return false;
		}
						
		return true;

	}

}
