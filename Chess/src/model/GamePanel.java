package model;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class GamePanel {

	public static void draw(Graphics g, MainMenuPanel mmp) {
		ImageIcon icon = new ImageIcon(mmp.sett_brownback ? "icons/checkered2.png" : "icons/checkered1.png");
		Image _myimage = icon.getImage();
		g.drawImage(_myimage, 0, 0, 720, 720, null);
	}
	
}
