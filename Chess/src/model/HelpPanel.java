package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HelpPanel {

	public static void draw(Graphics g) {

		Font myFont = new Font("Courier New", 1, 50);
		g.setFont(myFont);
		g.setColor(Color.WHITE);
		g.drawString("Help", 300, 100);

		Font myFont2 = new Font("Courier New", 1, 20);
		g.setFont(myFont2);

		g.drawString("Chess is a two-player strategy board game played ", 20, 150);
		g.drawString("on a chessboard, a checkered gameboard with 64 squares ", 20, 180);
		g.drawString("arranged in an eight-by-eight grid.", 20, 210);
		g.drawString("Each player begins the game with 16 pieces:", 20, 240);
		g.drawString("one king, one queen, two rooks, two knights,", 20, 270);
		g.drawString("two bishops, and eight pawns.", 20, 300);

		g.setFont(myFont);
		g.drawString("Back", 100, 600);

	}

}
