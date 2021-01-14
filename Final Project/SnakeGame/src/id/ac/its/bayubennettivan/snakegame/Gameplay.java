package id.ac.its.bayubennettivan.snakegame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Collections;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Gameplay extends Screen implements KeyListener, ActionListener {
	private static final long serialVersionUID = 1L;
	JFrame dp = new JFrame();
	private final static String DEFAULT_LOCATION = "src/assets/";
	private int[] foodX = { 25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 475,
			500, 525, 550, 575, 600, 625, 650, 675, 700, 725, 750, 775, 800, 825, 850 };
	private int[] foodY = { 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 475, 500,
			525, 550, 575, 600, 625 };

	Music music = new Music();

	private ImageIcon titleImage;
	private ImageIcon background;
	private Image okButton;
	private boolean isPaused = false;
	protected int difficulty = 2;
	private Snake snake = new Snake(1);
	long pauseTime = 0;
	private int width = 851;
	private int height = 55;
	private int x = 24;
	private int y = 10;
	List<Food> food = new ArrayList<>();
	List<SpriteNonBuffered> spriteNonBuffer = new ArrayList<>();
	private JTextField playerName;

	public Gameplay(JFrame referred, int diff) {
		super(referred);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		difficulty = diff;
		setMusic();
		startThread();
		spriteThread();
		okButton = loadImg("OKButton.png");
		playerName = new JTextField();
	}

	@Override
	public void render(Graphics g) {

		// draw title image border
		g.setColor(Color.WHITE);
		g.drawRect(x, y, width, height);

		// draw title image
		titleImage = new ImageIcon("src/assets/snaketitle.png");
		titleImage.paintIcon(this, g, x + 1, y + 1);

		// draw gameplay border
		g.setColor(Color.WHITE);
		g.drawRect(x, 74, width, height + 522);

		// draw background
		// System.out.println(difficulty + "Render");
		switch (difficulty) {
			case 1:
				background = new ImageIcon("src/assets/background.png");
				break;
			case 2:
				background = new ImageIcon("src/assets/LavaBG.png");
				break;
		}
		background.paintIcon(this, g, x + 1, 75);

		// draw length of snake
		g.setColor(Color.WHITE);
		g.setFont(new Font("arial", Font.BOLD, 25));
		g.drawString("Length: " + snake.getLen(), 740, 45);

		g.setColor(Color.WHITE);
		g.setFont(new Font("arial", Font.BOLD, 25));
		g.drawString("Press ESC to pause", 40, 45);
		for (Food i : food) {
			i.render(g);
		}
		snake.render(g);

		for (Food i : food) {
			i.render(g);
		}
		for (SpriteNonBuffered i : spriteNonBuffer) {
			i.render(g);
		}
		snake.render(g);
		if (isPaused) {
			System.out.println("Paused");
			g.setColor(Color.WHITE);
			g.setFont(new Font("arial", Font.BOLD, 70));
			g.drawString("Paused", 315, 340);
			g.setFont(new Font("arial", Font.BOLD, 35));
			g.drawString("Press ESC to unpause", 260, 380);
		}
		if (snake.getHp() == 0) {
			g.drawImage(okButton, 665, 335, null);
			g.setColor(Color.WHITE);
			g.setFont(new Font("arial", Font.BOLD, 70));
			g.drawString("Game Over", 265, 150);
			g.setFont(new Font("arial", Font.BOLD, 35));
			g.drawString("Enter Your Name", 155, 360);
		}
	}

	private Image loadImg(String filename) {
		try {
			return ImageIO.read(new File(DEFAULT_LOCATION + filename));
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void spriteThread() {
		Thread sprites = new Thread(new Runnable() {
			public void run() {
				while (snake.getHp() > 0) {
					for (SpriteNonBuffered i : spriteNonBuffer) {
						i.framecounter();
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		sprites.start();
	}

	public void startThread() {
		food.add(appleGen());
		Thread movement = new Thread(new Runnable() {
			public void run() {
				while (snake.getHp() > 0) {
					System.out.println(isPaused);
					if (isPaused == false) {
						System.out.println(difficulty + "Thread");
						snake.move();
						foodGen();
						checkBoard();
						if (difficulty == 2) {
							nonBufferGen();
						}
						repaint();
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					} else {
						repaint();
					}
				}
				if (snake.getHp() == 0) {
					gameOver();
					music.stopAll();
					music.playSFX("src/assets/music/dead.wav");
				}
			}
		});
		movement.start();
	}

	private void gameOver() {
		snake.setHp(0);
		playerName.setBounds(470, 335, 150, 30);
		this.add(playerName);
		playerName.requestFocus();
		Gameplay temp = this;
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getX() >= 665 && e.getX() <= 740 && e.getY() >= 335 && e.getY() <= 365) {
					if (playerName.getText().isEmpty()) {
						JOptionPane.showMessageDialog(temp, "The field is empty");
					} else if (playerName.getText().length() > 8) {
						JOptionPane.showMessageDialog(temp, "Maximum number of characters is 8");
					} else {
						saveScore();
						stateChange(0);
					}
				}
			}
		});
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP && snake.down != true) {
			snake.setDir(false, false, true, false);
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT && snake.right != true) {
			snake.setDir(true, false, false, false);
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN && snake.up != true) {
			snake.setDir(false, false, false, true);
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT && snake.left != true) {
			snake.setDir(false, true, false, false);
		} else if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			if (isPaused == false) {
				isPaused = true;
				pauseTime = music.pauseMusic();
			} else {
				isPaused = false;
				switch (difficulty) {
					case 1:
						music.playPausedMusic(pauseTime, "bin/assets/music/bg.wav");
						break;
					case 2:
						music.playPausedMusic(pauseTime, "bin/assets/music/bg2.wav");
						break;
				}
			}
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

				if (food.get(i) instanceof Food) {
					Random rng = new Random();
					int apple = rng.nextInt(3);
					System.out.printf("Apple rng = %d\n", apple);
					for (int z = 0; z < apple; z++) {
						food.add(appleGen());
					}
					int bombRng = rng.nextInt(50);
					System.out.printf("Bomb rng = %d\n", bombRng);
					if (bombRng <= 7)
						food.add(bombGen());
					int rottenRng = rng.nextInt(50);
					System.out.printf("Rotten rng = %d\n", rottenRng);
					if (rottenRng <= 17)
						food.add(rottenGen());
				}
			}
		}

		for (int i : eaten) {
			food.remove(i);
		}

	}

	public void nonBufferGen() {
		List<Integer> dissapear = new ArrayList<>();
		for (int i = 0; i < spriteNonBuffer.size(); i++) {
			spriteNonBuffer.get(i).tick(snake);
			if (spriteNonBuffer.get(i).getLoop() > 2) {
				dissapear.add(i);
			}
		}
		for (int i : dissapear) {
			spriteNonBuffer.remove(i);
		}
		int fireInstance = 0;
		if (snake.getLen() > 5) {
			int modifier = 3;
			for (SpriteNonBuffered i : spriteNonBuffer) {
				if (i instanceof Fire) {
					fireInstance++;
				}
			}
			if (fireInstance < snake.getLen() / modifier) {
				spriteNonBuffer.add(fireGen());
			}
		}
	}

	public Apple appleGen() {
		Random rng = new Random();
		int x = rng.nextInt(34);
		int y = rng.nextInt(22);
		System.out.printf("Apple on [%d][%d]\n", foodX[x], foodY[y]);
		return new Apple(foodX[x], foodY[y]);
	}

	public Rotten rottenGen() {
		Random rng = new Random();
		int x = rng.nextInt(34);
		int y = rng.nextInt(22);
		System.out.printf("Rotten on [%d][%d]\n", foodX[x], foodY[y]);
		return new Rotten(foodX[x], foodY[y]);
	}

	public Bomb bombGen() {
		Random rng = new Random();
		int x = rng.nextInt(34);
		int y = rng.nextInt(22);
		System.out.printf("Bomb on [%d][%d]\n", foodX[x], foodY[y]);
		return new Bomb(foodX[x], foodY[y]);
	}

	public void checkBoard() {
		int z = 0;
		boolean flag = false;
		for (Food i : food) {
			if (i instanceof Rotten) {
				z++;
			}
			if (i instanceof Apple) {
				flag = true;
			}
		}
		if (flag == false || food.size() == 0) {
			System.out.println("------genset------");
			food.add(appleGen());
		}
		if (z > 10) {
			for (Food i : food) {
				if (i instanceof Rotten) {
					food.remove(i);
				}
			}
		}
	}

	public void setMusic() {
		switch (difficulty) {
			case 1:
				music.playbgMusic("bin/assets/music/bg.wav");
				break;
			case 2:
				music.playbgMusic("bin/assets/music/bg2.wav");
				break;
		}
	}

	public void restartGame() {
		food.clear();
		spriteNonBuffer.clear();
		snake = new Snake(1);
		startThread();
		if (difficulty == 2) {
			spriteThread();
		}
		music.stopAll();
		switch (difficulty) {
			case 1:
				music.playbgMusic("bin/assets/music/bg.wav");
				break;
			case 2:
				music.playbgMusic("bin/assets/music/bg2.wav");
				break;
		}
	}

	public Fire fireGen() {
		Random rng = new Random();
		boolean flag = true;
		int x = 0;
		int y = 0;
		while (flag) {
			x = rng.nextInt(34);
			y = rng.nextInt(22);
			for (int i = 0; i < snake.getLen(); i++) {
				if (snake.snakeX.get(i) == foodX[x] && snake.snakeY.get(i) == foodY[y]) {
					flag = true;
				}
			}
			flag = false;
		}
		return new Fire(3, foodX[x], foodY[y]);
	}

	public void setDiff(int i) {
		System.out.println(i);
		this.difficulty = i;
	}

	@Override
	public void stateChange(int state) {
		switch (state) {
			case 0:
				music.stopAll();
				referred.setContentPane(new MainMenu(referred));
				referred.validate();
				referred.getContentPane().requestFocusInWindow();
				break;
		}
	}

	private void saveScore() {
		List<Player> playerScore = Player.load("score.txt");
		Player.setCompare(0);
		if (playerScore == null) {
			playerScore = new ArrayList<>();
		}
		playerScore.add(new Player(snake.getLen(), playerName.getText()));
		Collections.sort(playerScore);
		Player.save(playerScore, "score.txt");
	}
}
