package model;

public class Game {

	public GameManager gameManager;

	/*
	 * input iki tane string berk burak al return olarak game objesi dön Game g
	 * = new Game("burak", "berk"); bundan sonraki her method game objesinden
	 * çağırılacak, gameobjesi.ilgilimethod şeklinde
	 */
	public Game(String player1, String player2) {

		Player p1 = new Player(player1, Color.WHITE);
		Player p2 = new Player(player2, Color.BLACK);

		Player[] players = new Player[2];
		players[0] = p1;
		players[1] = p2;

		gameManager = new GameManager(players);

		gameManager.placeObjects(); // ecem -> berk : bu satiri ekledim ki taslar dizilsin ayrica taslar ters dizildigi icin onlari da gamemanager de duzelttim
		
	}

	/*
	 * method input yok, output bir tane array arrayin her elemanı ise üçlü
	 * array (2 boyutlu string array) [["bishop", "a", "2"], ["pawn", "h", "8"],
	 * ["bishop", "a", "2"]] (string olarak taşın tipi, string olarak char pos,
	 * string olarak int pos) String[][] piecesPos = g.getPiecesPositions();
	 */
	public String[][] getPiecesPositions() {

		String[][] result = new String[32][4];
		int count = 0;
		
		for (int i = 1; i < 9; i++) {
			for (int j = 0; j < 8; j++) {
				char column = (char) ('A' + j);
				if (gameManager.board.getSquareAtLoc(i, column).getPlacedPiece() != null) {

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
	
	/*
	 * method input yok, output 3 olasılık int olarak (player 1 kazandı -> 1 /
	 * player 2 kazandı -> 2 / oyun devam ediyor -> 0) int result =
	 * g.getStatus();
	 */
	public int getStatus() {

		if (gameManager.result.equals("not finished"))
			return 0;

		if (gameManager.result.equals(gameManager.players[0].getName() + " is the Winner!"))
			return 1;

		if (gameManager.result.equals(gameManager.players[1].getName() + " is the Winner!"))
			return 2;

		return -1;

	}

	/*
	 * method input: char ve int ('A', 2). eğer o pozisyonda bir taş varsa, o
	 * pozisyondaki taşın tipini bulup, o taşın gidebileceği pozisyonları 2d
	 * string array olarak dönecek. arraydaki her eleman ikili olacak, string
	 * olarak char pos ve string olarak int pos e.g. [["h", "8"], ["b", "4"], ["c",
	 * "6"]]. input olarak aldığı pozisyonda taş yoksa boş array dönecek.
	 * String[][] possible = g.getPossible('A', 2);
	 */
	public String[][] getPossible(char cp, int ip) {

		Square[] allPossible = gameManager.movementManager.validMoves(gameManager.board.getSquareAtLoc(ip, cp).getPlacedPiece());

		String[][] squareToString = new String[64][2];

		for (int i = 0; i < 64; i++) {
			if (allPossible[i] == null) {
				break;
			}
			squareToString[i][0] = Character.toString(allPossible[i].getColumn());
			squareToString[i][1] = Integer.toString(allPossible[i].getRow());
		}

		return squareToString;

	}

	/*
	 * method 4 input char int char int ('A', 2, 'A', 4), eğer a2 deki taşı a4 e
	 * götürebiliyorsa götürüp true dönecek; götüremiyorsa false dönecek boolean
	 * gone = g.move('A', 2, 'A', 4);
	 */
	public boolean move(char cp1, int ip1, char cp2, int ip2) {

		Piece pieceOfInterest = gameManager.board.getSquareAtLoc(ip1 + 1, cp1).getPlacedPiece();
		Square destination = gameManager.board.getSquareAtLoc(ip2 + 1, cp2);

		if (gameManager.movePiece(pieceOfInterest, destination) == null)
			return false;

		return true;

	}

}
