package model;

import javax.swing.ImageIcon;

public class Knight extends Piece
{

	/**
	 * @param color Color of the piece
	 * @param location Location of the piece, which is of type Square.
	 * 					Pass "null" if the piece has not yet been placed to a square
	 */
	public Knight(Color color, Square location)
	{
		super(color, location);
		if( color == Color.WHITE)
			this.setImage( new ImageIcon("file:icons/w_knight.png", "White Knight Icon"));
		else
			this.setImage( new ImageIcon("file:icons/b_knight.png", "Black Knight Icon"));
	}

}
