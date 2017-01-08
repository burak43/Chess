package model;

import javax.swing.ImageIcon;

public class Queen extends Piece {

	/**
	 * @param color
	 *            Color of the piece
	 * @param location
	 *            Location of the piece, which is of type Square. Pass "null" if
	 *            the piece has not yet been placed to a square
	 */
	public Queen(Color color, Square location) {
		super(color, location);
		if (color == Color.WHITE) {
			this.setImage(new ImageIcon("icons/w_queen.png", "White Queen Icon"));
		} else {
			this.setImage(new ImageIcon("icons/b_queen.png", "Black Queen Icon"));
		}
	}

}
