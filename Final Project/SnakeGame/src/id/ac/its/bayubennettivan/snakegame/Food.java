package id.ac.its.bayubennettivan.snakegame;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;

public abstract class Food {
    private int foodX, foodY;

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
    
}
