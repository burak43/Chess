package model;

import javax.swing.ImageIcon;

public class Knight extends Piece
{

	public Knight(Color color, Square location, boolean moved)
	{
		super(color, location, moved);
		if( color == Color.WHITE)
			this.setImage( new ImageIcon("file:icons/w_knight.png", "White Knight Icon"));
		else
			this.setImage( new ImageIcon("file:icons/b_knight.png", "Black Knight Icon"));
	}

}
