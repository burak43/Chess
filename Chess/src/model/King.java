package model;

import javax.swing.ImageIcon;

public class King extends Piece {

	/**
	 * @param color
	 *            Color of the piece
	 * @param location
	 *            Location of the piece, which is of type Square. Pass "null" if
	 *            the piece has not yet been placed to a square
	 */
	public King(Color color, Square location) {
		super(color, location);
		if (color == Color.WHITE)
			this.setImage(new ImageIcon("icons/w_king.png", "White King Icon"));
		else
			this.setImage(new ImageIcon("icons/b_king.png", "Black King Icon"));
	}

}
