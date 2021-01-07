package id.ac.its.bayubennettivan.snakegame;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Rotten extends Food {
    private String loc = "/src/assets/rotten.png";

    public Rotten(int foodX, int foodY) {
        super(foodX, foodY);
        super.setImg(this.getImage(loc));
    }

    public Image getImage(String loc) {
        try {
            return ImageIO.read(new File(loc));
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(super.getImage(), super.getFoodX(), super.getFoodY(), null);
    }

    @Override
    public void giveCond(Snake snake) {
        snake.delBody();

    }
}
