import javax.swing.*;
import java.awt.*;

/**
 * Contiene con JPanel y las propiedades de la ventana a crear
 * @author <a href="https://github.com/medina1402" target="_blank">Abraham Medina Carrillo</a>
 */

public class Application extends JFrame {
    public Home home;

    public Application() {
        setTitle("MiniGame");
        Dimension sizeScreen = Toolkit.getDefaultToolkit().getScreenSize();
        setSize((int) (sizeScreen.height * 0.75), (int) (sizeScreen.height * 0.95));

        home = new Home(this);
        setContentPane(home);

        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Application();
    }
}
