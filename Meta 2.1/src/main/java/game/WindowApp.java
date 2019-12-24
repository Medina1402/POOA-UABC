package game;

import game.screen.Home;
import game.tools.AudioManager;

import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class WindowApp extends JFrame {
    public Thread audio;

    public WindowApp(String title) throws HeadlessException, IOException, ClassNotFoundException {
        audio = new Thread(new Runnable() {
            public void run() {
                try {
                    Clip sound = AudioManager.GenerateAudioClip("Audio/RaymanLegendsSoundtrack-MainMenuTheTowerofBabel.wav");
                    sound.start();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (UnsupportedAudioFileException e) {
                    e.printStackTrace();
                } catch (LineUnavailableException e) {
                    e.printStackTrace();
                }
            }
        });

        setTitle(title);

        setSize(Toolkit.getDefaultToolkit().getScreenSize());
        setUndecorated(true);
        setLocationRelativeTo(null);

        Home screenHome = new Home(this, getWidth(), getHeight());
        add(screenHome);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
