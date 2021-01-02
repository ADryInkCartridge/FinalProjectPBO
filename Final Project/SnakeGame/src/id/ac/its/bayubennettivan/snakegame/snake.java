package id.ac.its.bayubennettivan.snakegame;

import javax.swing.ImageIcon;

public class snake {
    private ImageIcon rightMouth;
	private ImageIcon leftMouth;
	private ImageIcon upMouth;
	private ImageIcon downMouth;
    private ImageIcon snakeBody;
    private boolean left, right, up, down;
    private int[] snakeX = new int[750];
    private int[] snakeY = new int[750];
    private int len, moves, score;

    public snake()
    {
        snakeX[2] = 50;
		snakeX[1] = 75;
		snakeX[0] = 100;
		snakeY[2] = 100;
		snakeY[1] = 100;
		snakeY[0] = 100;
        this.len = 3;
        this.setDirection(false, false, false, false);
        rightMouth = new ImageIcon("src/assets/rightmouth.png");
        leftMouth = new ImageIcon("src/assets/leftmouth.png");
        upMouth = new ImageIcon("src/assets/upmouth.png");
        downMouth = new ImageIcon("src/assets/downmouth.png");
        snakeBody = new ImageIcon("src/assets/snakeimage.png");
    }
    
    public void setDirection(boolean left, boolean right, boolean up, boolean down) {
        this.left = left;
        this.right = right;
        this.up = up;
        this.down = down;
    }

    public boolean isLeft() {
        return left;
    }

    public boolean isRight() {
        return right;
    }

    public boolean isUp() {
        return up;
    }

    public boolean isDown() {
        return down;
    }

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public int getMoves() {
        return moves;
    }

    public void setMoves(int moves) {
        this.moves = moves;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
}
