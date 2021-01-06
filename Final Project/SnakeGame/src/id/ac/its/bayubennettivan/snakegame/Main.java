package id.ac.its.bayubennettivan.snakegame;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import id.ac.its.bayubennettivan.snakegame.Screen;

public class Main {

	public static void main(String[] args) {
		JFrame frame = new JFrame("CovSnake");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		Screen gs = new Gameplay(frame);
		frame.setContentPane(gs);
		frame.setVisible(true);
		frame.pack();
		frame.setResizable(false);
	}
}
