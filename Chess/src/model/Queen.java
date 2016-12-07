package model;

import javax.swing.ImageIcon;

public class Queen extends Piece
{

	public Queen(Color color, Square location, boolean moved)
	{
		super(color, location, moved);
		if( color == Color.WHITE)
			this.setImage( new ImageIcon("file:icons/w_queen.png", "White Queen Icon"));
		else
			this.setImage( new ImageIcon("file:icons/b_queen.png", "Black Queen Icon"));
	}

}
