package id.ac.its.bayubennettivan.snakegame;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import id.ac.its.bayubennettivan.snakegame.Snake;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Gameover extends Screen {
    private Snake snake;
    public static final int HEADER_START_POSITION_X = 0, HEADER_START_POSITION_Y = 0;
    private static Image gameOverBanner, okayButton;

    public Gameover(JFrame referred) {
        super(referred);
        super.setImg(this.getImage("src/assets/GameOver.jpg"));
        super.setImg(this.getImage("src/assets/OKButton.png"));

    }

    private Image getImage(String filename) {
        try {
            return ImageIO.read(new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void render(Graphics g) {
        if (snake.getHp() <= 0) {
            g.drawImage(gameOverBanner, 0, 260, null);
        } else
            g.drawImage(okayButton, 560, 305, null);
    }

    @Override
    public void stateChange(int state) {
        if(state == 0) {
			referred.setContentPane(new MainMenu(referred, screenImg, screenImg));
			referred.validate();
			referred.getContentPane().requestFocusInWindow();
		}

    }

}
