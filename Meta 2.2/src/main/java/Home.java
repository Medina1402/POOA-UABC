import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Contiene el JPanel que sera el menu, contiene el boton de iniciar
 * @author <a href="https://github.com/medina1402" target="_blank">Abraham Medina Carrillo</a>
 */

public class Home extends JPanel {
    private JButton iniciar;

    public Home(final Application root) {
        setLayout(null);

        iniciar = new JButton("Iniciar");
        iniciar.setSize(root.getWidth() * 3 / 4, 100);
        iniciar.setLocation(root.getWidth() / 2 - iniciar.getWidth() / 2, root.getHeight() / 2 - iniciar.getHeight() / 2 - 15);

        add(iniciar);
        setVisible(true);
        root.add(this);

        iniciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                root.setContentPane(new Game(root).getPanel());
            }
        });
    }
}
