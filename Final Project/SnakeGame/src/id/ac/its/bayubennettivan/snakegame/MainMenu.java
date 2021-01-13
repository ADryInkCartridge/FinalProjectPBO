package id.ac.its.bayubennettivan.snakegame;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MainMenu extends Screen {
    private final static String DEFAULT_LOCATION = "src/assets/";
    private Image backgroundMenu, newGameBtn, hScoreMenu, snakeTitle;
    Music music = new Music();

    public MainMenu(JFrame referred) {
        super(referred);
        music.playbgMusic(DEFAULT_LOCATION + "music/mainmenu.wav");
        backgroundMenu = this.loadImg("background.png");
        newGameBtn = this.loadImg("NewGame.png");
        hScoreMenu = this.loadImg("HighScore.png");
        snakeTitle = this.loadImg("snaketitle.png");

        addMouseListener((MouseListener) new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                // untuk newGameBtn
                if (e.getPoint().x >= 295 && e.getPoint().x <= 550 && e.getPoint().y >= 265 && e.getPoint().y <= 345) {
                    stateChange(1);
                }
                ;

                // untuk highScoreBtn
                if (e.getPoint().x >= 295 && e.getPoint().x <= 550 && e.getPoint().y >= 355 && e.getPoint().y <= 435) {
                    stateChange(2);
                }
                ;
            }
        });
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
        g.drawImage(snakeTitle, 25, 11, null);
        g.drawImage(backgroundMenu, 25, 75, null);
        g.drawImage(newGameBtn, 295, 265, null);
        g.drawImage(hScoreMenu, 295, 355, null);
    }

    @Override
    public void stateChange(int state) {
        switch (state) {
            case 1:
                referred.setContentPane(new LevelSelect(referred, music.pauseMusic()));
                referred.validate();
                referred.getContentPane().requestFocusInWindow();
                break;
            case 2:
                referred.setContentPane(new HighScoreMenu(referred, music.pauseMusic()));
                referred.validate();
                referred.getContentPane().requestFocusInWindow();
                break;
        }
    }

}
