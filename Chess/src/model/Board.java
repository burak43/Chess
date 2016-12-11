/**
 * @author Burak Mandira
 * @date Dec 10, 2016
 *
 */
package model;

import javax.swing.ImageIcon;

public class Board
{
	private Square[][] squares;
	private PieceSet[] pieceSets;
	private ImageIcon boardImage;
	
	/**
	 * @param boardImage the boardImage of this board
	 */
	public Board( ImageIcon boardImage)
	{
		squares = new Square[8][8];
		for( int i = 0; i < 8; ++i)
		{
			int row = i+1;
			squares[i] = new Square[8];
			for(int j = 0; i < 8; ++j)
			{
				char column = (char) ('A' + j);
				squares[i][j] = new Square( row, column, null);
			}
		}
		pieceSets = new PieceSet[2];
		pieceSets[0] = new PieceSet( Color.WHITE);
		pieceSets[1] = new PieceSet( Color.BLACK);
		this.boardImage = boardImage;
	}

	// getters & setters
	/**
	 * @param color the player's color whose pieceSet is wanted.
	 * @return the pieceSet of the specified player
	 */
	public PieceSet getPieceSet( Color color)
	{
		if( color == Color.WHITE)
			return pieceSets[0];
		else
			return pieceSets[1];
	}
	
	/**
	 * @return the boardImage
	 */
	public ImageIcon getBoardImage()
	{
		return boardImage;
	}

	/**
	 * @param boardImage the boardImage to set
	 */
	public void setBoardImage(ImageIcon boardImage)
	{
		this.boardImage = boardImage;
	}

}
