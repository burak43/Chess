package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class ChangeSettingsPanel {

	public static void draw(Graphics g, boolean sett_brownback, boolean sett_showlegal) {

		Font myFont = new Font("Courier New", 1, 50);
		g.setFont(myFont);
		g.setColor(Color.WHITE);
		g.drawString("Settings", 300, 100);

		Font myFont2 = new Font("Courier New", 1, 40);
		g.setFont(myFont2);
		g.drawString("Show legal movements ", 60, 250);
		g.drawString("Use brown backgroud", 60, 350);

		if (sett_showlegal) {
			g.fillRect(550, 210, 50, 50);
		} else {
			g.drawRect(550, 210, 50, 50);
		}
		if (sett_brownback) {
			g.fillRect(550, 310, 50, 50);
		} else {
			g.drawRect(550, 310, 50, 50);
		}

		g.setFont(myFont);
		g.drawString("Back", 100, 600);

	}

}
