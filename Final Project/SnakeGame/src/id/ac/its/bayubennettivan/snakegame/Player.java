package id.ac.its.bayubennettivan.snakegame;

import java.util.List;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Player implements Comparable<Player>
{
    private int score;
    private static int compare = 0;
    
    public Player(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    public static List<Player> load(String filename) {
		List<Player> userScore;
		try {
            FileInputStream fileIn = new FileInputStream("src/com/blazingduet/covsnake/highscore/" + filename);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            userScore = (List<Player>) objectIn.readObject();
            objectIn.close(); 
            return userScore;
        }catch(EOFException e) {

        }catch (IOException e) {

        }catch (ClassNotFoundException e) {

		}
		return null;
    }
    
    public static void save(List<Player> userScore, String filename) 
    {
		try {			 
          FileOutputStream fileOut = new FileOutputStream("src/score/" + filename);
          ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
          objectOut.writeObject(userScore);
          objectOut.close();
      } catch (IOException e) {

      }
	}
    
    public static void setCompare(int state) {
		compare = state;
    }
    
    @Override
    public int compareTo(Player x) {
        if(Player.compare == 0) {
			if(this.score > x.score ) {
				return -1;
			}else {
				return 1;
            }
        }
    }
}
