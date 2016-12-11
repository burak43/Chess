package model;

import javax.swing.ImageIcon;

public class Bishop extends Piece
{

	/**
	 * @param color Color of the piece
	 * @param location Location of the piece, which is of type Square.
	 * 					Pass "null" if the piece has not yet been placed to a square
	 */
	public Bishop(Color color, Square location)
	{
		super(color, location);
		if( color == Color.WHITE)
			this.setImage( new ImageIcon("file:icons/w_bishop.png", "White Bishop Icon"));
		else
			this.setImage( new ImageIcon("file:icons/b_bishop.png", "Black Bishop Icon"));
	}

}
