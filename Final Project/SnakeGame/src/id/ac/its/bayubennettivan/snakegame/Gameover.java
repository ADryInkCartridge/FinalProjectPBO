package id.ac.its.bayubennettivan.snakegame;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import id.ac.its.bayubennettivan.snakegame.Snake;

public class Gameover extends Screen {
    private Snake snake;
    private static final String DEFAULT_LOCATION = "src/com/blazingduet/covsnake/resources/gameplay/";
    public static final int HEADER_START_POSITION_X = 0, HEADER_START_POSITION_Y = 0;
    private static Image gameOverBanner, okayButton;

    public Gameover(JFrame referred) {
        super(referred);
        okayButton = loadImg("OKButton.png");
        gameOverBanner = loadImg("GameOver.png");

    }

    private Image loadImg(String string) {
        try {
            return ImageIO.read(new File(DEFAULT_LOCATION + filename));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void render(Graphics g) {
		if (snake.getHp() <= 0) {
			g.drawImage(gameOverBanner, 0, 260, null);
			else g.drawImage(okayButton, 560, 305, null);
		}

    }

    @Override
    public void stateChange(int state) {
        // TODO Auto-generated method stub

    }

    
}
