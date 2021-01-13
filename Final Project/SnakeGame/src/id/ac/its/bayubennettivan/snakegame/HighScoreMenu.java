package id.ac.its.bayubennettivan.snakegame;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.List;
import id.ac.its.bayubennettivan.snakegame.Snake;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class HighScoreMenu extends Screen {
    private final static String DEFAULT_LOCATION = "src/assets/";
    private Image backgroundHighScore, backMenu;
    private List<User> playerScore;
    Music music = new Music();

    public HighScoreMenu(JFrame referred, long musicTime) {
        super(referred);
        music.playPausedMusic(musicTime, DEFAULT_LOCATION + "music/mainmenu.wav");
        backgroundHighScore = this.loadImg("background.png");
        backMenu = this.loadImg("Back.png");
        this.playerScore = User.load("score.txt");
    }

    private Image loadImg(String filename) {
        try {
            return ImageIO.read(new File(DEFAULT_LOCATION + filename));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(backMenu, 250, 450, null);

    }

    @Override
    public void stateChange(int state) {
        switch (state) {
            case 0:
                music.stopAll();
                referred.setContentPane(new MainMenu(referred));
                referred.validate();
                referred.getContentPane().requestFocusInWindow();
                break;
        }
    }

}