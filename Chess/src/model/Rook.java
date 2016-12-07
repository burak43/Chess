package model;

import javax.swing.ImageIcon;

public class Rook extends Piece
{

	public Rook(Color color, Square location, boolean moved)
	{
		super(color, location, moved);
		if( color == Color.WHITE)
			this.setImage( new ImageIcon("file:icons/w_rook.png", "White Rook Icon"));
		else
			this.setImage( new ImageIcon("file:icons/b_rook.png", "Black Rook Icon"));
	}

}
