package id.ac.its.bayubennettivan.snakegame;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Snake by Bayu Bennett Ivan");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		Screen gs = new MainMenu(frame);
		frame.setContentPane(gs);
		frame.setVisible(true);
		frame.pack();
		frame.setResizable(false);
	}
}
