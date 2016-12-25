package model;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

public class CustomMouseListener implements MouseListener {

	String madde;
	public MainMenuPanel mc;
	public JFrame frame;
	public CustomKeyListener ckl;

	public CustomMouseListener(JFrame frame, MainMenuPanel mc, CustomKeyListener ckl) {
		this.frame = frame;
		this.mc = mc;
		this.ckl = ckl;
	}

	public void handleGameBoardClick(int x, int y) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int y0 = e.getY();
		int y = y0 + 22; // written on mac so to correct border offset, 22 added
		int x = e.getX();

		handleGameBoardClick(x, y0); // no need to add 22 because from now on
										// new codes will be written considering
										// window with no border

		if (mc.eleman == 0) {

			if (x > 300 && x < 600 && y > 145 && y < 175) {
				madde = "play";
				mc.eleman = 6;
				mc.name1 = "";
				mc.name2 = "";
				ckl.n2 = false;
				frame.repaint();
			} else if (x > 300 && x < 600 && y > 195 && y < 225) {
				madde = "past";
				Menu.displayPast(mc, frame);
			} else if (x > 300 && x < 600 && y > 235 && y < 275) {
				madde = "setting";
				Menu.displaySettings(mc, frame);
			} else if (x > 300 && x < 600 && y > 285 && y < 325) {
				madde = "credits";
				Menu.displayCredits(mc, frame);
			} else if (x > 300 && x < 420 && y > 335 && y < 375) {
				madde = "help";
				Menu.displayHelp(mc, frame);
			} else if (x > 100 && x < 250 && y > 600 && y < 650) {
				MainMenu.exitGame();
			} else
				madde = "";

		} else if (mc.eleman == 2) {
			if (x > 100 && x < 250 && y > 600 && y < 650) {
				mc.eleman = 0;
				frame.repaint();
			}
		} else if (mc.eleman == 3) {
			if (x > 550 && x < 650 && y > 310 && y < 410) {
				Menu.applySettings(mc, 0);
				frame.repaint();
			} else if (x > 550 && x < 650 && y > 210 && y < 310) {
				Menu.applySettings(mc, 1);
				frame.repaint();

			} else if (x > 100 && x < 250 && y > 600 && y < 650) {
				if (mc.settings_from_pause_menu) {
					mc.settings_from_pause_menu = false;
					mc.eleman = 7;
					frame.repaint();
				} else {
					mc.eleman = 0;
					frame.repaint();
				}
			}
		} else if (mc.eleman == 4) {
			if (x > 100 && x < 250 && y > 600 && y < 650) {
				mc.eleman = 0;
				frame.repaint();
			}
		} else if (mc.eleman == 5) {
			if (x > 100 && x < 250 && y > 600 && y < 650) {
				mc.eleman = 0;
				frame.repaint();
			}
		} else if (mc.eleman == 6) {
			if (x > 100 && x < 250 && y > 600 && y < 650) {
				mc.eleman = 0;
				frame.repaint();
			}
		} else if (mc.eleman == 7) {
			if (x > 200 && x < 500 && y > 195 && y < 225) {
				mc.eleman = 1;
				frame.repaint();
			} else if (x > 200 && x < 500 && y > 235 && y < 275) {
				mc.settings_from_pause_menu = true;
				Menu.displaySettings(mc, frame);
			} else if (x > 200 && x < 500 && y > 285 && y < 325) {
				mc.eleman = 0;
				frame.repaint();
			} else if (x > 200 && x < 400 && y > 335 && y < 375) {
				MainMenu.exitGame();
			}
		}

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}
