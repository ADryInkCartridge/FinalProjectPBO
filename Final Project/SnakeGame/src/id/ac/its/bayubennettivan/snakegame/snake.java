package id.ac.its.bayubennettivan.snakegame;

import java.io.File;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.imageio.*;

public class snake {

    private List<Integer> snakeX = new ArrayList<>();
    private List<Integer> snakeY = new ArrayList<>();
    private boolean left = false;
    private boolean right = false;
    private boolean up = false;
    private boolean down = false;
    private Image rightMouth;
    private Image leftMouth;
    private Image upMouth;
    private Image downMouth;
    private Image snakeBody;
    private int len = 3;
    private int hp;

    public snake(Float HPmodifier) {
        this.snakeX = new ArrayList<>();
        this.snakeY = new ArrayList<>();

        this.snakeX.add(250);
        this.snakeY.add(200);

        this.snakeX.add(225);
        this.snakeY.add(200);

        this.snakeX.add(200);
        this.snakeY.add(200);

        hp = (int) ((int) 100 * HPmodifier);
        this.len = 3;
        this.setDir(false, true, false, false);
        rightMouth = getImage("src/assets/rightmouth.png");
        leftMouth = getImage("src/assets/leftmouth.png");
        upMouth = getImage("src/assets/upmouth.png");
        downMouth = getImage("src/assets/downmouth.png");
        snakeBody = getImage("src/assets/snakebody.png");

    }

    public Image getImage(String loc) {
        try {
            return ImageIO.read(new File(loc));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setLen(int len) {
        this.len = len;
    }

    public int getLen() {
        return len;
    }

    public void setDir(boolean left, boolean right, boolean up, boolean down) {
        this.left = left;
        this.right = right;
        this.up = up;
        this.down = down;
    }

    public void render(Graphics g) {
        for (int i = 1; i < this.len; i++) {
            g.drawImage(snakeBody, snakeX.get(i), snakeY.get(i), null);
        }

        if (up) {
            g.drawImage(upMouth, snakeX.get(0), snakeY.get(0), null);
        } else if (down) {
            g.drawImage(downMouth, snakeX.get(0), snakeY.get(0), null);
        } else if (left) {
            g.drawImage(leftMouth, snakeX.get(0), snakeY.get(0), null);
        } else if (right) {
            g.drawImage(rightMouth, snakeX.get(0), snakeY.get(0), null);
        }
    }

    public void addBody() {
        this.snakeX.add(snakeX.get(this.len - 1));
        this.snakeY.add(snakeY.get(this.len - 1));
        this.len++;
    }

}
