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
		g.drawString("Length: " + len, 780, 50);

		food = new ImageIcon("src/assets/enemy.png");
		food.paintIcon(this, g, foodX[xpos], foodY[ypos]);

		// collision detection of snake head and food
		if (foodX[xpos] == snake.snakeX.get(0) && foodY[ypos] == snakeY[0]) {
			music.playSFX("src/assets/music/SFX/eat.wav");
			snake.setLen(snake.getLen() + 1);
			score += 25;
			xpos = random.nextInt(34);
			ypos = random.nextInt(23);
		}

		// collision detection for snake head and body
		for (int i = 1; i < len; i++) {
			if (snakeX[i] == snakeX[0] && snakeY[i] == snakeY[0]) {
				right = false;
				left = false;
				up = false;
				down = false;

				g.setColor(Color.WHITE);
				g.setFont(new Font("arial", Font.BOLD, 50));
				g.drawString("Game Over", 300, 300);

				g.setFont(new Font("arial", Font.BOLD, 20));
				g.drawString("Press 'Space' to Restart", 330, 340);
			}
		}

		rotten = new ImageIcon("src/assets/rotten.png");
		rotten.paintIcon(this, g, rottenX[xpos], rottenY[ypos]);

		// collision detection of snake head and rotten food
		if (rottenX[xpos] == snakeX[0] && rottenY[ypos] == snakeY[0]) {
			len--;
			score -= 25;
			xpos = random.nextInt(34);
			ypos = random.nextInt(23);
		}

		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		timer.start();
		if (right) {
			for (int i = len - 1; i >= 0; i--) {
				snakeY[i + 1] = snakeY[i];
			}
			for (int i = len; i >= 0; i--) {
				if (i == 0) {
					snakeX[0] = snakeX[0] + 25;
				} else {
					snakeX[i] = snakeX[i - 1];
				}
				if (snakeX[i] > boardRight) {
					snakeX[i] = boardLeft;
				}
			}
			repaint();
		}
		if (left) {
			for (int i = len - 1; i >= 0; i--) {
				snakeY[i + 1] = snakeY[i];
			}
			for (int i = len; i >= 0; i--) {
				if (i == 0) {
					snakeX[0] = snakeX[0] - 25;
				} else {
					snakeX[i] = snakeX[i - 1];
				}
				if (snakeX[i] < boardLeft) {
					snakeX[i] = boardRight;
				}
			}
			repaint();
		}
		if (up) {
			for (int i = len - 1; i >= 0; i--) {
				snakeX[i + 1] = snakeX[i];
			}
			for (int i = len; i >= 0; i--) {
				if (i == 0) {
					snakeY[0] = snakeY[0] - 25;
				} else {
					snakeY[i] = snakeY[i - 1];
				}
				if (snakeY[i] < boardTop) {
					snakeY[i] = boardBot;
				}
			}
			repaint();
		}
		if (down) {
			for (int i = len - 1; i >= 0; i--) {
				snakeX[i + 1] = snakeX[i];
			}
			for (int i = len; i >= 0; i--) {
				if (i == 0) {
					snakeY[0] = snakeY[0] + 25;
				} else {
					snakeY[i] = snakeY[i - 1];
				}
				if (snakeY[i] > boardBot) {
					snakeY[i] = boardTop;
				}
			}
			repaint();
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			timer.start();
			moves++;
			right = true;
			if (!left) {
				right = true;
			} else {
				right = false;
				left = true;
			}
			up = false;
			down = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			timer.start();
			moves++;
			left = true;
			if (!right) {
				left = true;
			} else {
				left = false;
				right = true;
			}
			up = false;
			down = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			timer.start();
			moves++;
			up = true;
			if (!down) {
				up = true;
			} else {
				up = false;
				down = true;
			}
			right = false;
			left = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			timer.start();
			moves++;
			down = true;
			if (!up) {
				down = true;
			} else {
				down = false;
				up = true;
			}
			right = false;
			left = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			moves = 0;
			score = 0;
			len = 3;
			repaint();
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

}
