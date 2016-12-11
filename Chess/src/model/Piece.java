package model;

import javax.swing.ImageIcon;

public abstract class Piece
{
	private Color pieceColor;
	private Square currentLocation;
	private boolean moved;
	private ImageIcon image;
	
	/**
	 * @param color Color of the piece
	 * @param location Location of the piece, which is of type Square.
	 * 					Pass "null" if the piece has not yet been placed to a square
	 */
	public Piece( Color color, Square location)
	{
		pieceColor = color;
		currentLocation = location;
	}

	// methods
	/**
	 * Updates the current location of this piece and marks
	 * it as moved.
	 * 
	 * @param newLocation New location of this piece.
	 */
	public void updateLocation(Square newLocation)
	{
		this.currentLocation = newLocation;
		this.setMoved();
	}
	
	// getters & setters
	/**
	 * @return the moved
	 */
	public boolean isMoved()
	{
		return this.moved;
	}
	
	/**
	 * @return the pieceColor
	 */
	public Color getPieceColor()
	{
		return pieceColor;
	}

	/**
	 * @param pieceColor the pieceColor to set
	 */
	public void setPieceColor(Color pieceColor)
	{
		this.pieceColor = pieceColor;
	}

	/**
	 * @return the currentLocation
	 */
	public Square getCurrentLocation()
	{
		return currentLocation;
	}
	
	/**
	 * @param location the location to set
	 */
	public void setCurrentLocation( Square location)
	{
		this.currentLocation = location;
	}

	/**
	 * Marks the piece as moved.
	 */
	public void setMoved()
	{
		this.moved = true;
	}

	/**
	 * @return the image
	 */
	public ImageIcon getImage()
	{
		return image;
	}

	/**
	 * @param image the image to set
	 */
	protected void setImage(ImageIcon image)
	{
		this.image = image;
	}

}
