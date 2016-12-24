package model;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class CustomKeyListener implements KeyListener {

	private MainMenuPanel dm;
	private JFrame frame;

	boolean n2 = false;

	public CustomKeyListener(MainMenuPanel dm, JFrame frame) {
		this.dm = dm;
		this.frame = frame;

		dm.name1 = "";
		dm.name2 = "";
		frame.repaint();

	}

	int count = 0;

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if (n2 && dm.name2.length() > 0) {
				MainMenu.startGame();
			}
			if (dm.name1.length() > 0) {
				n2 = true;
			}
		} else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {

			if (!n2) {
				int end = dm.name1.length() - 1;
				if (end < 0) {
					end = 0;
				}
				dm.name1 = dm.name1.substring(0, end);
			} else {
				int end = dm.name2.length() - 1;
				if (end < 0) {
					end = 0;
				}
				dm.name2 = dm.name2.substring(0, end);
			}

			frame.repaint();

		}
		// else if(e.getKeyCode() == KeyEvent.VK_ESCAPE){System.exit(0);}
		else {

			if (!n2) {
				dm.name1 += (char) e.getKeyCode();
			} else {
				dm.name2 += (char) e.getKeyCode();
			}

			frame.repaint();

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}
