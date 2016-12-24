package model;

import javax.swing.JFrame;

public class MenuActionListener {

	public CustomKeyListener ckl;
	public CustomMouseListener cml;

	MenuActionListener(MainMenuPanel mc, JFrame frame) {
		ckl = new CustomKeyListener(mc, frame);
		cml = new CustomMouseListener(frame, mc, ckl);
	}

}
