package id.ac.its.bayubennettivan.snakegame;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.Graphics;

public class Fire extends SpriteNonBuffered {

    String loc = "src/assets/sprite/Fire2/1_";
    int framecount = 0;
    Music sfx = new Music();

    public void framecounter() {
        if (framecount > 118) {
            this.loop++;
            framecount = 0;
        } else {
            framecount++;
        }
        super.setCurrentImage(this.getImage(loc + framecount + ".png"));
    }

    public Fire(int tick, int spriteX, int spriteY) {
        super(tick, spriteX, spriteY);
        super.setCurrentImage(this.getImage(loc + framecount + ".png"));
        // System.out.printf("%d %d %n", spriteX, spriteY);
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
        g.drawImage(super.getCurrentImage(), super.getSpriteX() - 30, super.getSpriteY() - 40, null);
    }

    @Override
    public void giveCond(Snake snake) {
        if (snake.getLen() > 1) {
            snake.delBody();
        } else {
            snake.setHp(0);
        }
        sfx.playSFX("src/assets/music/SFX/snake hurt.wav");
    }

}
