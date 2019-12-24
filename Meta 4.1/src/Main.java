import javax.sound.sampled.*;
import javax.swing.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class Main extends JFrame {
    // Creacion de un hila para obtener la ruta y generar el objeto Clip
    private static Clip GenerateAudioClip(String path) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResource(path)).openStream());
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(bufferedInputStream);
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        return clip;
    }
    // Sonido Aleatorio ** Ruta **
    private String SoundPath() {
        String[] image = {"doberman-pincher_daniel-simion.wav","labrador-barking-daniel_simon.wav", "small-dog-barking_daniel-simion"};
        return "assets/" + image[new Random().nextInt(image.length)];
    }

    public Main() {
        JButton button = new JButton("PLAY");
        button.setBounds(200, 200, 100, 50);
        button.addActionListener(e -> {
            try {
                GenerateAudioClip(SoundPath()).start();
            } catch (IOException | UnsupportedAudioFileException | LineUnavailableException ex) {
                ex.printStackTrace();
            }
        });
        add(button);
        //*******************************************************************************
        //*******************************************************************************
        setTitle("Objetos concurrentes ::: Abraham Medina Carrillo");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Main();
    }
}
