package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

public class MainMenuPanel extends JComponent {

	private static final long serialVersionUID = 1L;
	public int eleman = 0;
	public String name1;
	public String name2;

	public boolean sett_brownback = false;
	public boolean sett_showlegal = true;

	public boolean settings_from_pause_menu = false;

	public Game g;
	
	public char c1_c;
	public int c1_i;
	public char c2_c;
	public int c2_i;
	public boolean c1 = false;
	public boolean c2 = false;
	
	MainMenuPanel(int e) {
		eleman = e;
	}
	
	public void startGame() {
		g = new Game(name1, name2);	
	}
	
	@Override
	public void paint(Graphics g) {

		ImageIcon icon = new ImageIcon("icons/stockvault-glass-chess137890.jpg");
		Image _myimage = icon.getImage();
		g.drawImage(_myimage, 0, 0, 720, 720, null);

		if (eleman == 1) {

			GamePanel.draw(g, this);

		} else if (eleman == 2) {

			HighScorePanel.draw(g);

		} else if (eleman == 3) {

			ChangeSettingsPanel.draw(g, sett_brownback, sett_showlegal);

		} else if (eleman == 4) {

			CreditsPanel.draw(g);

		} else if (eleman == 5) {

			HelpPanel.draw(g);

		} else if (eleman == 6) {

			Font myFont = new Font("Courier New", 1, 50);
			g.setFont(myFont);
			g.setColor(Color.WHITE);
			g.drawString("Enter names", 250, 100);

			g.drawString(name1, 300, 250);
			g.drawString(name2, 300, 350);

			g.drawRect(290, 210, 280, 50);
			g.drawRect(290, 310, 280, 50);

			g.drawString("Back", 100, 600);
			
			Font myFont2 = new Font("Courier New", 1, 25);
			g.setFont(myFont2);
			g.drawString("For pause menu, press esc.", 260, 540);

		} else if (eleman == 7) {

			PauseMenuPanel.draw(g);

		} else {

			Font myFont = new Font("Courier New", 1, 50);
			g.setFont(myFont);
			g.setColor(Color.WHITE);

			g.drawString("CHESS", 300, 100);
			g.drawString("Play Game", 300, 150);
			g.drawString("Past Winners", 300, 200);
			g.drawString("Settings", 300, 250);
			g.drawString("Credits", 300, 300);
			g.drawString("Help", 300, 350);

			g.drawString("Exit", 100, 600);

			// Graphics2D g2 = (Graphics2D) g;
			// g2.setStroke(new BasicStroke(30));
			// g.drawLine(400, 35, 400, 35);

		}
	}
}