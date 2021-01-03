package id.ac.its.bayubennettivan.snakegame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener {

	Music music = new Music();

	private ImageIcon titleImage;

	private int[] foodX = { 25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 47,
			500, 525, 550, 575, 600, 625, 650, 675, 700, 725, 750, 775, 800, 825, 850 };
	private int[] foodY = { 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 47, 500, 525,
			550, 575, 600, 625 };

	private int[] rottenX = { 25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 47,
			500, 525, 550, 575, 600, 625, 650, 675, 700, 725, 750, 775, 800, 825, 850 };
	private int[] rottenY = { 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 47, 500,
			525, 550, 575, 600, 625 };

	private ImageIcon food;
	private ImageIcon rotten;
	private Snake snake;
	private Random random = new Random();
	private detectCollision detect = new detectCollision();
	private int xpos = random.nextInt(34);
	private int ypos = random.nextInt(23);

	private int moves = 0;
	private int score = 0;

	private Timer timer;
	private int delay = 50;

	private int width = 851;
	private int height = 55;
	private int x = 24;
	private int y = 10;
	private int boardRight = 850;
	private int boardLeft = 25;
	private int boardTop = 75;
	private int boardBot = 625;

	public Gameplay() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
	}

	@Override
	public void paint(Graphics g) {
		// snake position (snakeX[0] and snakeY[0] is head

		// draw title image border
		g.setColor(Color.WHITE);
		g.drawRect(x, y, width, height);

		// draw title image
		titleImage = new ImageIcon("src/assets/snaketitle.jpg");
		titleImage.paintIcon(this, g, x + 1, y + 1);

		// draw gameplay border
		g.setColor(Color.WHITE);
		g.drawRect(x, 74, width, height + 522);

		// draw background
		g.setColor(Color.BLACK);
		g.fillRect(x + 1, 75, width - 1, height + 520);

		// draw scores
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial", Font.PLAIN, 14));
		g.drawString("Score: " + score, 780, 30);

		// draw length of snake
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial", Font.PLAIN, 14));
		g.drawString("Length: " + snake.getLen(), 780, 50);

		food = new ImageIcon("src/assets/enemy.png");
		food.paintIcon(this, g, foodX[xpos], foodY[ypos]);

		// collision detection of snake head and food
		if () {
			music.playSFX("src/assets/music/SFX/eat.wav");
			snake.setLen(snake.getLen() + 1);
			score += 25;
			xpos = random.nextInt(34);
			ypos = random.nextInt(23);
		}

		if (snake.getHp() == 0) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("arial", Font.BOLD, 50));
			g.drawString("Game Over", 300, 300);
			g.setFont(new Font("arial", Font.BOLD, 20));
			g.drawString("Press 'Space' to Restart", 330, 340);
		}

		snake.render(g);

		rotten = new ImageIcon("src/assets/rotten.png");
		rotten.paintIcon(this, g, rottenX[xpos], rottenY[ypos]);

		// collision detection of snake head and rotten food
		if (rottenX[xpos] == snake.snakeX.get(0) && rottenY[ypos] == snake.snakeY.get(0)) {
			snake.setLen(snake.getLen() - 1);
			score -= 25;
			xpos = random.nextInt(34);
			ypos = random.nextInt(23);
		}

		g.dispose();
	}

	Thread movement = new Thread();

	public void runGame() {
		while (snake.getHp() > 0) {
			snake.move();
			repaint();
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}movement.start();

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			snake.setDir(false, false, true, false);
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			snake.setDir(true, false, false, false);
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			snake.setDir(false, false, false, true);
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			snake.setDir(false, true, false, false);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
