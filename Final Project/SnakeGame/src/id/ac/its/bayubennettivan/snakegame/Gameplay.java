package id.ac.its.bayubennettivan.snakegame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Gameplay extends Screen implements KeyListener, ActionListener {
	JFrame dp = new JFrame();
	private int[] foodX = { 25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 47,
			500, 525, 550, 575, 600, 625, 650, 675, 700, 725, 750, 775, 800, 825, 850 };
	private int[] foodY = { 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 47, 500, 525,
			550, 575, 600, 625 };

	Music music = new Music();

	private ImageIcon titleImage;

	private Snake snake = new Snake(1);
	private detectCollision detect = new detectCollision();
	private int moves = 0;
	private int score = 0;
	private Timer timer;
	private int delay = 50;
	private int width = 851;
	private int height = 55;
	private int x = 24;
	private int y = 10;
	List<Food> food = new ArrayList<>();
	List<Character> userinput = new ArrayList<>();

	public Gameplay(JFrame referred) {
		super(referred);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
		music.playbgMusic("bin/assets/music/bg.wav");
		startThread();
	}

	@Override
	public void render(Graphics g) {
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

		if (snake.getHp() == 0) {
			g.setColor(Color.WHITE);
			g.setFont(new Font("arial", Font.BOLD, 50));
			g.drawString("Game Over", 300, 300);
			g.setFont(new Font("arial", Font.BOLD, 20));
			g.drawString("Press 'Space' to Restart", 330, 340);
		}
		for (Food i : food) {
			//System.out.println("food");
			i.render(g);
		}
		snake.render(g);
		//System.out.println("repaint");
	}

	public void startThread() {
		food.add(appleGen());
		//System.out.println("aaaa");
		Thread movement = new Thread() {
			public void run() {
				while (snake.getHp()>0) {
					snake.move();
					foodGen();
					System.out.println(food);
					repaint();
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				if (snake.getHp()==0)
				{
					music.stopAll();
					music.playSFX("src/assets/music/dead.wav");
				}
			}
		};
		movement.start();
	}
	

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP && snake.down!=true) {
			snake.setDir(false, false, true, false);
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT && snake.right!=true) {
			snake.setDir(true, false, false, false);
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN && snake.up!=true) {
			snake.setDir(false, false, false, true);
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT && snake.left!=true) {
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

	public void foodGen() {
		List<Integer> eaten = new ArrayList<>();

		for (int i = 0; i < food.size(); i++) {
			if (food.get(i).eatenBySnake(snake)) {
				eaten.add(i);

				if (food.get(i) instanceof Apple) {
					food.add(appleGen());
				}
			}
		}

		for (int i : eaten) {
			food.remove(i);
		}
	}

	public Apple appleGen() {
		Random rng = new Random();
		int x = rng.nextInt(34);
		int y = rng.nextInt(22);
		return new Apple(foodX[x], foodY[y]);
	}

	public Rotten rottenGen() {
		Random rng = new Random();
		int x = rng.nextInt(34);
		int y = rng.nextInt(22);
		return new Rotten(foodX[x], foodY[y]);
	}

	@Override
	public void stateChange(int state) {
	}

}
