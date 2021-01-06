package id.ac.its.bayubennettivan.snakegame;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.Image;

public class Apple extends Food {

    public Apple(int foodX, int foodY) {
        super(foodX, foodY);
        super.setImg(this.getImage("src/assets/enemy.png"));
    }

    public Image getImage(String loc) {
        try {
            return ImageIO.read(new File(loc));
        } catch (IOException e) {
        	e.printStackTrace();
            return null;
        }
    }

    @Override
    public void render(Graphics g) {
    	System.out.println("apple");
        g.drawImage(super.getImage(), super.getFoodX(), super.getFoodY(), null);
    }

}
