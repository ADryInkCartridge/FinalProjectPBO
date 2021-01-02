package id.ac.its.bayubennettivan.snakegame;

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class Music {

    void playbgMusic(String loc) {
        File path = new File(loc);
        try {
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(path);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    void playSFX(String loc) {
        File path = new File(loc);
        try {
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(path);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInput);
            clip.start();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
