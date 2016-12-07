package model;

import javax.swing.ImageIcon;

public abstract class Piece
{
	private Color pieceColor;
	private Square currentLocation;
	private boolean moved;
	private ImageIcon image;
	
	public Piece( Color color, Square location, boolean moved)
	{
		pieceColor = color;
		currentLocation = location;
		this.moved = moved;
	}

	// methods
	public void updateLocation(Square newLocation)
	{
		this.currentLocation = newLocation;
	}
	
	public boolean isMoved()
	{
		return this.moved;
	}
	
	// getters & setters
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
