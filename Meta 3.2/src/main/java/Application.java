import data.Download;
import gui.Container;
import gui.TitleBar;

import javax.swing.*;
import java.awt.*;

/**
 * @author <a href="https://github.com/medina1402" target="_blank">Abraham Medina Carrillo</a>
 */

public class Application extends JFrame {
    private TitleBar titleBar;
    private Container container;

    public Application() {
        setMinimumSize(new Dimension(500, 700));
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setUndecorated(true);

        titleBar = new TitleBar(0, 0, getWidth(), getHeight());
        container = new Container(0, titleBar.getHeight(), getWidth(), getHeight() - titleBar.getHeight());

        add(titleBar);
        add(container);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        if(!Download.ComprobarConexion()) JOptionPane.showMessageDialog(this, "Sin conexion a internet.\nNo se podra realizar la descarga de informacion.", "Estado de la conexion", JOptionPane.WARNING_MESSAGE);
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.setVisible(true);
    }
}
