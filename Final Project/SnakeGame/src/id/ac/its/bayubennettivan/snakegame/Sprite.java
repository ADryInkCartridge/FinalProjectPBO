package id.ac.its.bayubennettivan.snakegame;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;
import java.awt.image.BufferedImage;

public abstract class Sprite {

    private int spriteX, spriteY;
    private BufferedImage spriteImage;
    Music sfx = new Music();

    public abstract void giveCond(Snake snake);

    public boolean eatenBySnake(Snake snake) {
        if (snake.headX() == this.spriteX && snake.headY() == this.spriteY) {
            this.giveCond(snake);
            sfx.playSFX("src/assets/music/SFX/eat.wav");
            return true;
        }
        return false;
    }

    public Sprite(int spriteX, int spriteY) {
        this.spriteX = spriteX;
        this.spriteY = spriteY;
    }

    public int getFoodX() {
        return spriteX;
    }

    public void setFoodX(int spriteX) {
        this.spriteX = spriteX;
    }

    public int getFoodY() {
        return spriteY;
    }

    public void setFoodY(int spriteY) {
        this.spriteY = spriteY;
    }

    public Image getImage() {
        return this.spriteImage;
    }

    public void setImg(BufferedImage spriteImage) {
        this.spriteImage = spriteImage;
    }

}
