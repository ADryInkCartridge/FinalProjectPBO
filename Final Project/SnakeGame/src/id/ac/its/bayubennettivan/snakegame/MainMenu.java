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

public class MainMenu extends Screen {
    private Image backgroundMenu, newGameBtn;

    public MainMenu(JFrame referred, Image backgroundMenu, Image newGameBtn) {
        super(referred);
        super.setImg(this.getImage("src/assets/background.png"));
        super.setImg(this.getImage("src/assets/NewGame.png"));
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
        g.drawImage(backgroundMenu, 0, 0, null);
        g.drawImage(newGameBtn, 250, 325, null);
    }

    @Override
    public void stateChange(int state) {
        referred.setContentPane(new Gameplay(referred));
        referred.validate();
        referred.getContentPane().requestFocusInWindow();
        // break;
    }

}
