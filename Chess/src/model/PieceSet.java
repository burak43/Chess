package model;

/**
 * @author Burak Mandira
 * @date Dec 9, 2016
 *
 */

import java.util.ArrayList;

public class PieceSet {
	private ArrayList<Piece> pieces;
	private Color playerColor;

	/**
	 * @param playerColor
	 *            Color of the player who owns this piece set
	 */
	public PieceSet(Color playerColor) {
		pieces = new ArrayList<Piece>();
		this.playerColor = playerColor;
	}

	// methods
	/**
	 * @param p
	 *            the piece which will be removed from this piece set
	 * @return a boolean that represents success or failure
	 */
	public boolean removePiece(Piece p) {
		return pieces.remove(p);
	}

	/**
	 * @param p
	 *            the piece which will be added to this piece set
	 * @return a boolean that represents success or failure
	 */
	public boolean addPiece(Piece p) {
		return pieces.add(p);
	}

	// getters & setters
	/**
	 * @return the number of pieces this piece set contains
	 */
	public int getNumOfPieces() {
		return pieces.size();
	}

	/**
	 * @return the pieces
	 */
	public ArrayList<Piece> getPieces() {
		return pieces;
	}

	/**
	 * @param pieces
	 *            the pieces to set
	 */
	public void setPieces(ArrayList<Piece> pieces) {
		this.pieces = pieces;
	}

	/**
	 * @return the playerColor
	 */
	public Color getPlayerColor() {
		return playerColor;
	}

}
