package id.ac.its.bayubennettivan.snakegame;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class Screen extends JPanel {

    JFrame referred;
    public final static int PANEL_WIDTH = 905, PANEL_HEIGHT = 700;

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

}
