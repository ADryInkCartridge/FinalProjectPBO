package id.ac.its.bayubennettivan.snakegame;

public class DetectCollision {

    public boolean colide(int snakeX, int snakeY, int objX, int objY) {
        if (snakeX == objX && snakeY == objY)
            return true;
        else
            return false;
    }
}