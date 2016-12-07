package model;

import javax.swing.ImageIcon;

public class Pawn extends Piece
{
	private boolean promoted;
	private Piece promotedTo;
	
	public Pawn(Color color, Square location, boolean moved)
	{
		super(color, location, moved);
		
		promoted = false;
		promotedTo = null;
		if( color == Color.WHITE)
			this.setImage( new ImageIcon("file:icons/w_pawn.png", "White Pawn Icon"));
		else
			this.setImage( new ImageIcon("file:icons/b_pawn.png", "Black Pawn Icon"));
	}

	/**
	 * @return whether the pawn is promoted or not
	 */
	public boolean isPromoted()
	{
		return promoted;
	}

	/**
	 * @param promoted the promoted to set
	 */
	public void setPromoted(boolean promoted)
	{
		this.promoted = promoted;
	}

	/**
	 * @return the piece that the pawn was promoted to
	 */
	public Piece getPromotedTo()
	{
		return promotedTo;
	}

	/**
	 * @param promotedTo a peice that the pawn is promoted to
	 */
	public void setPromotedTo(Piece promotedTo)
	{
		this.promotedTo = promotedTo;
	}

}
