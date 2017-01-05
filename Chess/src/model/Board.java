package model;

public class Board {
	public Square[][] squares;
	private PieceSet[] pieceSets;

	public Board() {

		squares = new Square[8][8];
		for (int i = 0; i < 8; i++) {
			int row = i + 1;
			for (int j = 0; j < 8; j++) {
				char column = (char) ('A' + j);
				squares[i][j] = new Square(row, column, null);
			}
		}
		pieceSets = new PieceSet[2];
		pieceSets[0] = new PieceSet(Color.WHITE);
		pieceSets[1] = new PieceSet(Color.BLACK);
	}

	/**
	 * @param color
	 *            the player's color whose pieceSet is wanted.
	 * @return the pieceSet of the specified player
	 */
	public PieceSet getPieceSet(Color color) {
		if (color == Color.WHITE)
			return pieceSets[0];
		else
			return pieceSets[1];
	}

	public Square getSquareAtLoc(int i, char c) {
		return squares[i - 1][(Character.getNumericValue(c) - 10)];
	}

}
