package id.ac.its.bayubennettivan.snakegame;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;

public abstract class Food {

    private int foodX, foodY;
    private Image foodImg;
    Music sfx = new Music();
    public abstract void render(Graphics g);

    public boolean eatenBySnake(Snake snake) {
        if (snake.headX() == this.foodX && snake.headY() == this.foodY) {
        	
            snake.addBody();
            sfx.playSFX("src\\assets\\music\\SFX\\eat.wav");
            return true;
        }
        return false;
    }

    public Food(int foodX, int foodY) {
        this.foodX = foodX;
        this.foodY = foodY;
    }

    public int getFoodX() {
        return foodX;
    }

    public void setFoodX(int foodX) {
        this.foodX = foodX;
    }

    public int getFoodY() {
        return foodY;
    }

    public void setFoodY(int foodY) {
        this.foodY = foodY;
    }

    public Image getImage() {
        return this.foodImg;
    }

    public void setImg(Image foodImg) {
        this.foodImg = foodImg;
    }

}