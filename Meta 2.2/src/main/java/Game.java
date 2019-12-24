import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Contiene el minijuego
 * @author <a href="https://github.com/medina1402" target="_blank">Abraham Medina Carrillo</a>
 */

public class Game extends Applet implements ActionListener {
    public static int cuadriculaGame = 2;
    private static int sizeButtonsGame = 0;

    private JPanel panel;
    private JButton buttons[];

    private int numRandom[];
    private Application root;

    /**
     * @param root Elemento padre para agregar al JFrame
     */

    public Game(Application root) {
        this.root = root;
        gameInit();
    }

    /**
     * Contiene el panel que se agregara al JFrame
     * @return JPanel
     */

    public JPanel getPanel() {
        return panel;
    }

    /**
     * Cada que se llame a esta funcion, se creara un nuevo "estado", contendra el cuadrado de la cantidad de cuadros anteriores
     */

    public void gameInit() {
        sizeButtonsGame = cuadriculaGame*cuadriculaGame;

        panel = new JPanel();
        buttons = new JButton[sizeButtonsGame];
        numRandom = new int[sizeButtonsGame];

        panel.setLayout(new GridLayout(cuadriculaGame, cuadriculaGame));
        for(int element=0; element<sizeButtonsGame-1; element++) {
            buttons[element] = new JButton(getRandom(element) + "");
            buttons[element].addActionListener(this);
            panel.add(buttons[element]);
        }
        buttons[ (sizeButtonsGame - 1) ] = new JButton("0");
        buttons[ (sizeButtonsGame - 1) ].setVisible(false);
        buttons[(sizeButtonsGame - 1)].addActionListener(this);
        panel.add(buttons[(sizeButtonsGame - 1)]);

        panel.setVisible(true);
        root.getContentPane().removeAll();
        root.add(panel);
        root.setContentPane(panel);
    }

    /**
     * Verifica que no se repita el numero
     * @param number Numero a buscar
     * @param size Tamaño de los elementos creados (numeros generados)
     * @return Se encontro el numero?
     */

    private boolean searchContainNumber(int number, int size) {
        for(int k=0; k<size; k++) if(number == numRandom[k]) return true;
        return false;
    }

    /**
     * Genera numeros Random sin que se repitan, utilizandose en conjunto de <i>searchContainNumber</i>
     * @param posicion Posicion actual para generar el numero
     * @return retorna el numero random a agregar
     */

    private int getRandom(int posicion) {
        int random = new Random().nextInt(sizeButtonsGame - 1) + 1;
        for(int k=0; k<=posicion; k++)
            while(posicion>0 && searchContainNumber(random, posicion))
                random = new Random().nextInt(sizeButtonsGame - 1) + 1;
        numRandom[posicion] = random;
        return random;
    }

    /**
     * Eventos de Click, al dar click sobre un boton, intercambiara posicion con la que se encuentre vacia, si todos se encuentran ordenados, el juego termina y agrega otro nivel con mas dificultad
     * @param e Listener
     */

    public void actionPerformed(ActionEvent e) {
        JButton temp = (JButton) e.getSource();
        int posicion = 0;
        int meta = 0;
        for(int element=0; element<sizeButtonsGame; element++) {
            if(buttons[element].getText().equals(temp.getText())) {
                buttons[element].setVisible(false);
                posicion = element;
                continue;
            }
        }
        for(int element=0; element<sizeButtonsGame; element++) {
            if(buttons[element].isVisible() == false && buttons[element]!=buttons[posicion]) {
                buttons[element].setVisible(true);
                buttons[element].setText(temp.getText());
                buttons[posicion].setText("0");
            }
            if(buttons[element].getText().equals((element+1) + "")) meta++;
        }
        if(meta == sizeButtonsGame-1) {
            JOptionPane.showMessageDialog(null, "GANASTE");
            cuadriculaGame++;
            panel.setVisible(false);
            panel.removeAll();
            gameInit();
        }
    }
}
