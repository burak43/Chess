package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class CreditsPanel {

	public static void draw(Graphics g) {
		Font myFont = new Font("Courier New", 1, 50);
		g.setFont(myFont);
		g.setColor(Color.WHITE);
		g.drawString("Credits", 300, 100);
		Font myFont2 = new Font("Courier New", 1, 40);
		g.setFont(myFont2);
		g.drawString("Burak Mandıra", 180, 200);
		g.drawString("Berk Evren Abbasoğlu", 180, 250);
		g.drawString("Kaya Yıldırım", 180, 300);
		g.drawString("Rabia Ecem Afacan", 180, 350);

		g.setFont(myFont);
		g.drawString("Back", 100, 600);

	}

}
