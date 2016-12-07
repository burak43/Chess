package model;

import javax.swing.ImageIcon;

public class Bishop extends Piece
{

	public Bishop(Color color, Square location, boolean moved)
	{
		super(color, location, moved);
		if( color == Color.WHITE)
			this.setImage( new ImageIcon("file:icons/w_bishop.png", "White Bishop Icon"));
		else
			this.setImage( new ImageIcon("file:icons/b_bishop.png", "Black Bishop Icon"));
	}

}
