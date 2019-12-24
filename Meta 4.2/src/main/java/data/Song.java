package data;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;

/**
 * Encargada de generar nuevos audios
 * @author <a href="https://github.com/medina1402" target="_blank">Abraham Medina Carrillo</a>
 * @see Clip
 */

public class Song {
    private Clip audio;
    private int duration = 0;
    private boolean isPlaySong = false;

    public Song(String path) {
        try {
            audio = GenerateAudioClip(path);
            duration = audio.getFrameLength();
            audio.stop();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    /**
     * Interpolacion de estado de la pista
     */
    public void playing() {
        if(!isPlaySong) {
            audio.start();
            isPlaySong = true;
        } else {
            audio.stop();
            isPlaySong = false;
        }
    }

    /**
     * @return Milisegundos de duracion
     */
    public int getDuration() {
        return duration;
    }

    /**
     * En que posicion se encuentra reproduciendo la pista
     * @return Posicion del frame actual
     */
    public int getValue() {
        return audio.getFramePosition();
    }

    /**
     * Modifica el frame actual de la pista
     */
    public void setValue(int value) {
        audio.setFramePosition(value);
    }

    /**
     * Crea un nuevo hila para generar una URL con ruta absoluta
     * @param path Ruta relativa del elemento
     * @return La URL a utilizar
     */
    public static URL getURL(String path) {
        return Thread.currentThread().getContextClassLoader().getResource(path);
    }

    /**
     * Genera los recursos de audio manipulables desde la clase contenedora
     * @param path Ruta del archivo
     * @return Un clip manipulable
     */
    public static Clip GenerateAudioClip(String path) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(getURL(path).openStream());
        Clip clip;
        AudioInputStream audioInputStream;
        audioInputStream = AudioSystem.getAudioInputStream(bufferedInputStream);
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        return clip;
    }
}
