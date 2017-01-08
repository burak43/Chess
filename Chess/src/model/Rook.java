package model;

import javax.swing.ImageIcon;

public class Rook extends Piece {

	/**
	 * @param color
	 *            Color of the piece
	 * @param location
	 *            Location of the piece, which is of type Square. Pass "null" if
	 *            the piece has not yet been placed to a square
	 */
	public Rook(Color color, Square location) {
		super(color, location);
		if (color == Color.WHITE) {
			this.setImage(new ImageIcon("icons/w_rook.png", "White Rook Icon"));
		} else {
			this.setImage(new ImageIcon("icons/b_rook.png", "Black Rook Icon"));
		}
	}

}
