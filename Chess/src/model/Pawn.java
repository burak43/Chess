package model;

import javax.swing.ImageIcon;

public class Pawn extends Piece {

	private boolean promoted;
	private Piece promotedTo;

	/**
	 * @param color
	 *            Color of the piece
	 * @param location
	 *            Location of the piece, which is of type Square. Pass "null" if
	 *            the piece has not yet been placed to a square
	 */
	public Pawn(Color color, Square location) {
		super(color, location);

		promoted = false;
		promotedTo = null;
		if (color == Color.WHITE) {
			this.setImage(new ImageIcon("icons/w_pawn.png", "White Pawn Icon"));
		} else {
			this.setImage(new ImageIcon("icons/b_pawn.png", "Black Pawn Icon"));
		}
	}

	/**
	 * @return whether the pawn is promoted or not
	 */
	public boolean isPromoted() {
		return promoted;
	}

	/**
	 * @param promoted
	 *            the promoted to set
	 */
	public void setPromoted(boolean promoted) {
		this.promoted = promoted;
	}

	/**
	 * @param image
	 *            the image to set
	 */
	@Override
	public void setImage(ImageIcon image) {
		super.setImage(image);
	}

	/**
	 * @return the piece that the pawn was promoted to
	 */
	public Piece getPromotedTo() {
		return promotedTo;
	}

	/**
	 * @param promotedTo
	 *            a piece that the pawn is promoted to
	 */
	public void setPromotedTo(Piece promotedTo) {
		this.promotedTo = promotedTo;
	}

}
