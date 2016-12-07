package model;

import javax.swing.ImageIcon;

public class King extends Piece
{

	public King( Color color, Square location, boolean moved)
	{
		super(color, location, moved);
		if( color == Color.WHITE)
			this.setImage( new ImageIcon("file:icons/w_king.png", "White King Icon"));
		else
			this.setImage( new ImageIcon("file:icons/b_king.png", "Black King Icon"));
	}

}
