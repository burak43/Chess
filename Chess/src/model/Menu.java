package model;

import javax.swing.JFrame;

public class Menu extends MainMenu {

	private static final long serialVersionUID = 1L;

	public Menu() {
	}

	public void switchPanel() {
	}

	public static void displayHelp(MainMenuPanel mc, JFrame frame) {
		mc.eleman = 5;
		frame.repaint();
	}

	public static void displayCredits(MainMenuPanel mc, JFrame frame) {
		mc.eleman = 4;
		frame.repaint();
	}

	public static void displaySettings(MainMenuPanel mc, JFrame frame) {
		mc.eleman = 3;
		frame.repaint();
	}

	public static void displayPast(MainMenuPanel mc, JFrame frame) {
		mc.eleman = 2;
		frame.repaint();
	}

	public static void applySettings(MainMenuPanel mc, int seti) {
		if (seti == 0) {
			mc.sett_brownback = mc.sett_brownback ? false : true;
		} else if (seti == 1) {
			mc.sett_showlegal = mc.sett_showlegal ? false : true;
		}
	}

}
