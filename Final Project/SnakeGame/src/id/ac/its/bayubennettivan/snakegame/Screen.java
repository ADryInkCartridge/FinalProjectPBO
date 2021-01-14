package id.ac.its.bayubennettivan.snakegame;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class Screen extends JPanel {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JFrame referred;
    public final static int PANEL_WIDTH = 905, PANEL_HEIGHT = 700;
    protected Image screenImg;

    public Screen(JFrame referred) {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.referred = referred;
    }

    public abstract void render(Graphics g);

    public abstract void stateChange(int state);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        render(g);
    }

    public Image getImage() {
        return this.screenImg;
    }

    public void setImg(Image screenImg) {
        this.screenImg = screenImg;
    }

}
