package id.ac.its.bayubennettivan.snakegame;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class Apple extends Food
{
    private ImageIcon apple = new ImageIcon("/src/assets/enemy.png");
    
    public Apple(int foodX, int foodY) {
        super(foodX, foodY);
    }
    
}
