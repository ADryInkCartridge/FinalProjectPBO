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
    private Image backgroundHighScore, backMenu;
    private List<User> playerScore;

    public HighScoreMenu(JFrame referred, Image backgroundHighScore, Image backMenu) {
        super(referred);
        super.setImg(this.getImage("src/assets/background.png"));
        super.setImg(this.getImage("src/assets/Back.png"));
        this.playerScore = User.load("score.txt");
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
        g.drawImage(backMenu, 250, 450, null);

    }

    @Override
    public void stateChange(int state) {
        switch (state) {
            case 0:
                referred.setContentPane(new MainMenu(referred));
                referred.validate();
                referred.getContentPane().requestFocusInWindow();
                break;
        }
    }

}