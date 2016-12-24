package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class HighScorePanel {

	public static void draw(Graphics g) {
		Font myFont = new Font("Courier New", 1, 50);
		g.setFont(myFont);
		g.setColor(Color.WHITE);
		g.drawString("Past Winners", 250, 100);
		Font myFont2 = new Font("Courier New", 1, 40);
		g.setFont(myFont2);
		g.drawString("Ali", 300, 200);
		g.drawString("Veli", 300, 250);
		g.drawString("Deli", 300, 300);

		g.setFont(myFont);
		g.drawString("Back", 100, 600);

	}

}
