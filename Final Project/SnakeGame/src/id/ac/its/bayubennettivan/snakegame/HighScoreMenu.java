package id.ac.its.bayubennettivan.snakegame;

import java.awt.Graphics;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import java.util.ArrayList;
import java.util.List;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class HighScoreMenu extends Screen {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private final static String DEFAULT_LOCATION = "src/assets/";
    private Image backgroundHS, backMenu, snakeTitle;
    private List<Player> playerScore;
    Music music = new Music();

    public HighScoreMenu(JFrame referred, long musicTime) {
        super(referred);
        music.playPausedMusic(musicTime, DEFAULT_LOCATION + "music/mainmenu.wav");
        backgroundHS = loadImg("background.png");
        backMenu = loadImg("Back.png");
        snakeTitle = loadImg("snaketitle.png");

        this.playerScore = Player.load("score.txt");
        if (playerScore == null) {
            playerScore = new ArrayList<>();
        }

        addMouseListener((MouseListener) new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                // untuk newGameBtn
                if (e.getPoint().x >= 295 && e.getPoint().x <= 550 && e.getPoint().y >= 550 && e.getPoint().y <= 630) {
                    stateChange(0);
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
        g.drawImage(backgroundHS, 25, 75, null);
        g.drawImage(backMenu, 295, 550, null);
        g.setFont(new Font("arial", Font.BOLD, 50));
        g.setColor(Color.WHITE);
        int startX = 255, startY = 275;
        for (int i = 0; i < playerScore.size() && i < 5; i++) {
            StringBuffer sb = new StringBuffer();
            sb.append(i + 1 + ". " + playerScore.get(i).getNama() + " " + playerScore.get(i).getScore() + " points");
            g.drawString(sb.toString(), startX, startY + 50 * i);
        }
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