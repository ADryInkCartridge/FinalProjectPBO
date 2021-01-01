package id.ac.its.bayubennettivan.snakegame;

import java.awt.Color;
import javax.swing.JFrame;

public class GUI extends JFrame {

	private Gameplay gameplay;
	private Music bgmusic;

	private int width;
	private int height;

	public GUI(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public void setupGUI() {
		setSize(width, height);
		setTitle("Snake Game - made by 0078-0091-0172");
		setLocationRelativeTo(null);
		// setBackground(Color.DARK_GRAY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		gameplay = new Gameplay();
		bgmusic = new Music();
		add(gameplay);
		bgmusic.playbgMusic("src/assets/music/bg.wav");

		setVisible(true);
	}
}
