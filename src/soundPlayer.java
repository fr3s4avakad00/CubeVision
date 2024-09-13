import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class soundPlayer {

    private Clip clip;  // Clip for background sound

    // Constructor
    public soundPlayer(String soundFilePath) {
        startBackgroundSound(soundFilePath);
    }

    // Method to start the background sound
    public void startBackgroundSound(String soundFilePath) {
        System.out.println("Starting background sound...");
        new Thread(() -> {//Multithreading to start a new thread to play the sound ()
            try {
 
                File soundFile = new File(soundFilePath);
                System.out.println("Loading sound file: " + soundFile.getAbsolutePath());
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
    
                clip = AudioSystem.getClip();
    
                clip.open(audioIn);// Open the audio clip and load samples from the audio input stream
    
                clip.loop(Clip.LOOP_CONTINUOUSLY);//loops the sound in a continuous manner
                System.out.println("Sound started playing.");
    
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
                System.out.println("Error playing sound: " + ex.getMessage());
            }
        }).start();
    }
    
    public void stopBackgroundSound() {//Method to stop the background sound   
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }
}
