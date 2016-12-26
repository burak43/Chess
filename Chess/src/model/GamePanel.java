package model;

import java.awt.Color;
import java.awt.Graphics;

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

		g.drawImage((new ImageIcon(mmp.sett_brownback ? "icons/checkered2.png" : "icons/checkered1.png")).getImage(), 0,
				0, 720, 720, null);

		g.setColor(new Color(0.93f, 0.28f, 0.37f, 1.0f));

		g.fillRect(gx2('A'), gy2(8), 90, 90);
		g.fillRect(gx2('B'), gy2(7), 90, 90);
		g.fillRect(gx2('B'), gy2(6), 90, 90);
		g.fillRect(gx2('H'), gy2(8), 90, 90);
		g.fillRect(gx2('G'), gy2(7), 90, 90);
		g.fillRect(gx2('F'), gy2(6), 90, 90);
		g.fillRect(gx2('E'), gy2(5), 90, 90);
		g.fillRect(gx2('D'), gy2(4), 90, 90);
		g.fillRect(gx2('D'), gy2(5), 90, 90);
		g.fillRect(gx2('C'), gy2(3), 90, 90);
		g.fillRect(gx2('B'), gy2(2), 90, 90);
		g.fillRect(gx2('A'), gy2(1), 90, 90);

		g.drawImage((new ImageIcon("icons/b_bishop.png")).getImage(), gx('A'), gy(8), 60, 60, null);
		g.drawImage((new ImageIcon("icons/w_bishop.png")).getImage(), gx('B'), gy(7), 60, 60, null);
		g.drawImage((new ImageIcon("icons/b_bishop.png")).getImage(), gx('B'), gy(6), 60, 60, null);
		g.drawImage((new ImageIcon("icons/w_bishop.png")).getImage(), gx('D'), gy(5), 60, 60, null);
		g.drawImage((new ImageIcon("icons/b_bishop.png")).getImage(), gx('E'), gy(4), 60, 60, null);
		g.drawImage((new ImageIcon("icons/w_bishop.png")).getImage(), gx('F'), gy(3), 60, 60, null);
		g.drawImage((new ImageIcon("icons/b_bishop.png")).getImage(), gx('G'), gy(2), 60, 60, null);
		g.drawImage((new ImageIcon("icons/w_bishop.png")).getImage(), gx('H'), gy(1), 60, 60, null);

	}

}
