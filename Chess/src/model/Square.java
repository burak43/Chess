package model;

public class Square {
	private int row;
	private char column;
	private boolean occupied;
	public Piece placedPiece;

	/**
	 * Initializes this Square according to given parameters. If 'placedPiece'
	 * is not null, then 'occupied' is set as true.
	 * 
	 * @param row
	 * @param column
	 * @param placedPiece
	 *            the piece that this Square contains. Pass "null" if currently
	 *            no piece is placed.
	 */
	
	public Square(int row, char column, Piece placedPiece) {
		this.row = row;
		this.column = column;
		this.placedPiece = placedPiece;
		if (this.placedPiece != null)
			this.occupied = true;
	}
		
	/**
	 * Places a piece to this square and marks it as occupied
	 * 
	 * @param p
	 *            the piece which will be placed to this square
	 * @return a boolean that indicates success or failure
	 */
	public boolean placePiece(Piece p) {
		placedPiece = p;
		return this.occupy();
	}

	/**
	 * @return the placedPiece
	 */
	public Piece getPlacedPiece() {
		if (placedPiece == null) { return null; }
		return placedPiece;
	}

	/**
	 * Sets 'occupied' as true and returns 'occupied'
	 */
	public boolean occupy() {
		return this.occupied = true;
	}

	/**
	 * Sets 'occupied' as false and returns 'occupied'
	 * 
	 * @return new value of 'occupied'
	 */
	public boolean withdraw() {
		placedPiece = null;
		this.occupied = false;
		return this.occupied;
	}

	/**
	 * @return the occupied
	 */
	public boolean isOccupied() {
		return occupied;
	}

	/**
	 * @return the row
	 */
	public int getRow() {
		return row;
	}

	/**
	 * @return the column
	 */
	public char getColumn() {
		return column;
	}

	public void setRow(int i) {
		this.row = i;
	}

	public void setColumn(char c) {
		this.column = c;
	}

	public boolean equals(Square s) {
		return this.getRow() == s.getRow() && this.getColumn() == s.getColumn();
	}

}
