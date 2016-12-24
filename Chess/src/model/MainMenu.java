package model;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainMenu extends JPanel {

	private static final long serialVersionUID = 1L;

	private MainMenuPanel mc;

	public MainMenu() {
		JFrame frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		mc = new MainMenuPanel(0);

		MenuActionListener mal = new MenuActionListener(mc, frame);
		frame.addKeyListener(mal.ckl);
		frame.addMouseListener(mal.cml);

		frame.add(mc);

		frame.setSize(720, 720);
		frame.setVisible(true);
	}

	public static void startGame() {
		System.out.println("start");
	}

	public static void exitGame() {
		System.exit(0);
	}

}
