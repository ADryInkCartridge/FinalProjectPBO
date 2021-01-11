package id.ac.its.bayubennettivan.snakegame;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import id.ac.its.bayubennettivan.snakegame.Snake;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MainMenu extends Screen {
    private final static String DEFAULT_LOCATION = "src/assets/";
    private Image backgroundMenu, newGameBtn, hScoreMenu;

    public MainMenu(JFrame referred) {
        super(referred);
        backgroundMenu = this.loadImg("background.png");
        newGameBtn = this.loadImg("NewGame.png");
        hScoreMenu = this.loadImg("HighScore.png");

        addMouseListener((MouseListener) new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//untuk newGameBtn
				if(e.getPoint().x >=250 && e.getPoint().x <=550 && e.getPoint().y >= 325 && e.getPoint().y <= 405){
					stateChange(1);
				};
				
				//untuk highScoreBtn
				if(e.getPoint().x >=250 && e.getPoint().x <=550 && e.getPoint().y >= 425 && e.getPoint().y <= 505){
					stateChange(2);
				};
			}
		});
    }

    private Image loadImg(String filename) {
		try {
			return ImageIO.read(new File(DEFAULT_LOCATION+filename));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

    @Override
    public void render(Graphics g) {
        g.drawImage(backgroundMenu, 0, 0, null);
        g.drawImage(newGameBtn, 250, 325, null);
        g.drawImage(hScoreMenu, 250, 425, null);
    }

    @Override
    public void stateChange(int state) {
        switch(state) {
            case 1:
                referred.setContentPane(new Gameplay(referred));
                referred.validate();
                referred.getContentPane().requestFocusInWindow();
                break;
            case 2:
                referred.setContentPane(new HighScoreMenu(referred));
                referred.validate();
                referred.getContentPane().requestFocusInWindow();
            }
    }

}
