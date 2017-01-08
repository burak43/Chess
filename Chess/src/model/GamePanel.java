package model;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;

public class GamePanel {

	public static int gx(char c) {
		return (((int) c) - 65) * 90 + 15;
	};

	public static int gy(int i) {
		return (8 - i) * 90 + 15;
	};

	public static int gx2(char c) {
		return (((int) c) - 65) * 90;
	};

	public static int gy2(int i) {
		return (8 - i) * 90;
	};

	public static void draw(Graphics g, MainMenuPanel mmp) {

		g.drawImage((new ImageIcon(mmp.sett_brownback ? "icons/checkered2.png" : "icons/checkered1.png")).getImage(), 0, 0, 720, 720, null);
	
		if (mmp.c1 && mmp.g.gameManager.board.getSquareAtLoc(mmp.c1_i, mmp.c1_c).isOccupied()) {
			if (((mmp.g.gameManager.board.getSquareAtLoc(mmp.c1_i, mmp.c1_c).getPlacedPiece().getPieceColor() == model.Color.BLACK) && mmp.turn_black) || ((mmp.g.gameManager.board.getSquareAtLoc(mmp.c1_i, mmp.c1_c).getPlacedPiece().getPieceColor() == model.Color.WHITE) && !mmp.turn_black)) {	
				g.setColor(new Color(0.66f, 0.76f, 0.07f, 1.0f));
				g.fillRect(gx2(mmp.c1_c), gy2(mmp.c1_i), 90, 90);
				if (mmp.sett_showlegal) {
					g.setColor(new Color(0.93f, 0.28f, 0.37f, 1.0f));
					String[][] possible = mmp.g.getPossible(mmp.c1_c, mmp.c1_i);
					for (int i = 0; i < possible.length; i++) {
						if (possible[i][0] == null) {
							break;
						}
						g.fillRect(gx2(possible[i][0].charAt(0)), gy2(Integer.parseInt(possible[i][1])), 90, 90);
					}
				}
			}
		}
				
		if (mmp.c2) {
			mmp.c2 = false;
			if (mmp.g.gameManager.board.getSquareAtLoc(mmp.c1_i, mmp.c1_c).isOccupied()) {
				if (((mmp.g.gameManager.board.getSquareAtLoc(mmp.c1_i, mmp.c1_c).getPlacedPiece().getPieceColor() == model.Color.BLACK) && mmp.turn_black) || ((mmp.g.gameManager.board.getSquareAtLoc(mmp.c1_i, mmp.c1_c).getPlacedPiece().getPieceColor() == model.Color.WHITE) && !mmp.turn_black)) {
					if (mmp.g.move(mmp.c1_c, mmp.c1_i, mmp.c2_c, mmp.c2_i)) {
						mmp.turn_black = mmp.turn_black ? false : true;
					}
				}
			}
		}

		Graphics2D g2 = (Graphics2D)g;
		String[][] piecesPos = mmp.g.getPiecesPositions();
		for (int i = 0; i < piecesPos.length; i++) {
			if (piecesPos[i][0] != null) {
				g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, ((piecesPos[i][3] == "b" && mmp.turn_black) || (piecesPos[i][3] == "w" && !mmp.turn_black)) ? 1.0f : 0.5f));
				g.drawImage((new ImageIcon("icons/" + piecesPos[i][3] + "_" + piecesPos[i][0].split(Pattern.quote("."))[1].toLowerCase() + ".png")).getImage(), gx(piecesPos[i][1].charAt(0)), gy(Integer.parseInt(piecesPos[i][2])), 60, 60, null);			
			}
		}
		
		if (mmp.g.getStatus() == 1) {
			System.out.println("win 1");
		} else if (mmp.g.getStatus() == 2) {
			System.out.println("win 2");
		}
		
	}

}
