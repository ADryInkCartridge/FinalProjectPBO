package id.ac.its.bayubennettivan;

import id.ac.its.bayubennettivan.snakegame;

import javax.swing.ImageIcon;

public class Rotten extends Food
{
    private ImageIcon apple = new ImageIcon("/src/assets/rotten.png");

    public Rotten(int foodX, int foodY) {
        super(foodX, foodY);
    }
}
