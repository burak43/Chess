package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class PauseMenu {

	public static void draw(Graphics g) {
		Font myFont = new Font("Courier New", 1, 50);
		g.setFont(myFont);
		g.setColor(Color.WHITE);
		g.drawString("Pause Menu", 300, 100);
		
		Font myFont2 = new Font("Courier New", 1, 35);
		g.setFont(myFont2);
		g.drawString("Continue Game", 200, 200);
		g.drawString("Settings", 200, 250);
		g.drawString("Return to Main Menu", 200, 300);
		g.drawString("Exit Game", 200, 350);

	}

}
