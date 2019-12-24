package game.tools;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;

public class AudioManager {
    public static URL getURL(String path) {
        return Thread.currentThread().getContextClassLoader().getResource(path);
    }

    public static Clip GenerateAudioClip(String path) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(getURL(path).openStream());
        Clip clip;
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(bufferedInputStream);
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        return clip;
    }
}
